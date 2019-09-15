package controller;

import java.util.ArrayList;

public class School {
	private ArrayList<Teacher> teacherList;
	private ArrayList<ClassGroup> classGroupList;
	private ArrayList<Student> studentList;
	
	/**
	 * The class that stores inforamtion on the school system
	 */
	public School() {
		this.teacherList = new ArrayList<Teacher>();
		this.classGroupList = new ArrayList<ClassGroup>();
		this.studentList = new ArrayList<Student>();
		
	}
	
	public void addTeacher(Teacher t) {
		teacherList.add(t);
	}
	
	public void removeTeacher(Teacher teacher) {
		for(int i = 0; i < classGroupList.size(); i++) {
			if(teacherList.get(i) == teacher) {
				teacher = teacherList.remove(i);
			}
		}
	}
	
	public void removeLastStudent() {
		classGroupList.remove((classGroupList.size()-1));
		studentList.remove((studentList.size()-1));
	}
	
	public void addClassGroup(ClassGroup c) {
		classGroupList.add(c);
	}
	
	public void removeClassGroup(ClassGroup group) {
		for(int i = 0; i < classGroupList.size(); i++) {
			if(classGroupList.get(i) == group) {
				group = classGroupList.remove(i);
			}
		}
	}
	
	public void addStudent(Student s) {
		studentList.add(s);
	}
	
	public void removeStudent(Student student) {
		for(int i = 0; i < classGroupList.size(); i++) {
			if(studentList.get(i) == student) {
				student = studentList.remove(i);
			}
		}
	}
	
	public ClassGroup getClassGroup(int groupID) {
		ClassGroup group = null;
		for(int i = 0; i < classGroupList.size(); i++) {
			if(classGroupList.get(i).getGroupID() == groupID) {
				group = classGroupList.get(i);
			}
		}
		return group;
	}
	public Student getStudent(int studentID) {
		Student student = null;
		for(int i = 0; i < classGroupList.size(); i++) {
			if(studentList.get(i).getStudentID() == studentID) {
				student = studentList.get(i);
			}
		}
		return student;
	}
	
	public int ClassGroupsNewID() {
		return classGroupList.get((classGroupList.size()-1)).getGroupID();
	}
	
	public int lastStudentID() {
		return studentList.get((studentList.size()-1)).getStudentID();
	}
	
	public String toString() {
		String output = "";
		for(int i = 0; i < classGroupList.size(); i++) {
			output += classGroupList.get(i).toString();
		}
		for(int i = 0; i < teacherList.size(); i++) {
			output += teacherList.get(i).toString();
		}
		return output;
	}
}
