package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import controller.ClassGroup;
import controller.Name;
import controller.School;
import controller.Student;
import controller.Teacher;

public class GetTableInfo {
	
	School school;
	ResultSet myRs;
	Statement myStmt;
	
	/**
	 * gets the information from the table
	 * @param myStmt
	 * @param mainSchool
	 */
	public GetTableInfo(Statement myStmt, School mainSchool) {
		this.myStmt = myStmt;
		this.school = mainSchool;
	}
	
	/**
	 * gets student informaiton
	 */
	public void getStudentInfo() {
		int studentID;
		String Fname;
		String Mname;
		String Lname;
		String email;
		int phone;
		String DOB;
		Name name;
		Student student;
		
		try {
			myRs = myStmt.executeQuery("select * from student");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			while(myRs.next()) {
				//sql = "insert into student (studentID, Fname, Mname, Lname, email, phone, DOB)"
				studentID = Integer.parseInt(myRs.getString("studentID"));
				Fname = myRs.getString("Fname");
				Mname = myRs.getString("Mname");
				Lname = myRs.getString("Lname");
				email = myRs.getString("email");
				phone = Integer.parseInt(myRs.getString("phone"));
				DOB = myRs.getString("DOB");
				
				name = new Name(Fname, Mname, Lname);
				student = new Student(name, email, phone, DOB, studentID);
				school.addStudent(student);
			}
		} 
		catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * gets class gorup information
	 */
	public void getClassGroupInfo() {
		int classGroupID;
		ClassGroup newClassGroup;
		
		try {
			myRs = myStmt.executeQuery("select * from classgrouptable");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			while(myRs.next()) {
				//sql = "insert into student (studentID, Fname, Mname, Lname, email, phone, DOB)"
				classGroupID = Integer.parseInt(myRs.getString("classGroupID"));
				newClassGroup = new ClassGroup(classGroupID);
				school.addClassGroup(newClassGroup);
			}
		} 
		catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * gets group information
	 */
	public void assignGroups() {
		int classGroupID;
		ClassGroup classGroup;
		Student student;
		int studentID;
		
		try {
			myRs = myStmt.executeQuery("select * from studentgroup");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			while(myRs.next()) {
				//sql = "insert into student (studentID, Fname, Mname, Lname, email, phone, DOB)"
				classGroupID = Integer.parseInt(myRs.getString("classGroupID"));
				studentID = Integer.parseInt(myRs.getString("studentID"));
				classGroup = school.getClassGroup(classGroupID);
				student = school.getStudent(studentID);
				classGroup.addStudents(student);
			}
		} 
		catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * gets module inforamtion
	 */
	public void getModuleInfo() {
		try {
			myRs = myStmt.executeQuery("select * from module_grade");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Student studentMod;
			int studentID;
			String module_name;
			int grade;
			
			while(myRs.next()) {
				//sql = "insert into student (studentID, Fname 	, Mname, Lname, email, phone, DOB)"
				studentID = Integer.parseInt(myRs.getString("studentID"));
				module_name = myRs.getString("module_name");
				grade = Integer.parseInt(myRs.getString("Grade"));	
				studentMod = school.getStudent(studentID);
				studentMod.addModule(module_name, grade);
			}
		} 
		catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * gets teacher information
	 */
	public void getTeacherInfo() {
		int teacherID;
		String Fname;
		String Mname;
		String Lname;
		String email;
		int phone;
		int age;
		String degree;
		Name name;
		Teacher teacher;
		
		try {
			myRs = myStmt.executeQuery("select * from teachertable");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			while(myRs.next()) {
				//sql = "insert into student (studentID, Fname, Mname, Lname, email, phone, DOB)"
				teacherID = Integer.parseInt(myRs.getString("teacherID"));
				Fname = myRs.getString("Fname");
				Mname = myRs.getString("Mname");
				Lname = myRs.getString("Lname");
				email = myRs.getString("email");
				phone = Integer.parseInt(myRs.getString("phone"));
				age = Integer.parseInt(myRs.getString("age"));
				degree = myRs.getString("degree");
				
				name = new Name(Fname, Mname, Lname);
				teacher = new Teacher(name, email, phone, age, degree, teacherID);
				school.addTeacher(teacher);
			}
		} 
		catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	
}
