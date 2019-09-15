package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import controller.School;
import controller.Student;

public class DatabaseHandler {
	insertData isd;
	updateData ud;
	deleteData dd;
	GetTableInfo gti;
	Statement myStmt;
	
	public DatabaseHandler(School mainSchool) {
		try {
			String url = "jdbc:mysql://127.0.0.1:3306/oopproject";
			String user = "root";
			String password = "";
			
			// Get Connection to database
			//Connection myConn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/database_project", "testUser", "password"); // personal server
			//Connection myConn = DriverManager.getConnection(url, user, password); // CIT Server
			Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/oopproject?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","");
			// Create Statement
			myStmt = myConn.createStatement();
			
			isd = new insertData(myStmt);
			ud = new updateData(myStmt);
			dd = new deleteData(myStmt);
			gti = new GetTableInfo(myStmt, mainSchool);
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
	}
	
	public void insertStudent(Student student, int classID) {
		isd.insertStudent(student.getFirstName(), student.getMiddleName(), student.getLastName(), student.getEmail(), student.getPhone(),
				student.getDOB(), student.getStudentID());
		isd.insertStudentInClass(student.getStudentID(), classID);
	}
	
	public void insertClassGroup(int n) {
		isd.insertClassGroup(n);
	}
	
	public void deleteStudent(int id) {
		dd.deleteStudent(id);
	}
	
	public void deleteClassGroup(int id) {
		dd.deleteClassGroup(id);
	}
	
	public void updateModule(int value, int stid, String subject) {
		ud.dataUpdate(value, stid, subject);
	}
	
	public void getStudentInfo() {
		gti.getStudentInfo();
	}
	
	public void getClassGroupInfo() {
		gti.getClassGroupInfo();
	}
	
	public void assignGroups() {
		gti.assignGroups();
	}
	
	public void getModuleInfo() {
		gti.getModuleInfo();
	}
	
	public void getTeacherInfo() {
		gti.getTeacherInfo();
	}
}
