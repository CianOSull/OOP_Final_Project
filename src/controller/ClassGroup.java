package controller;

import java.util.ArrayList;

public class ClassGroup {
	private ArrayList<Student> studentList;
	private int classGroupID;
	
	/**
	 * 
	 * @param n
	 * This class stores and creates information on class groups
	 */
	public ClassGroup(int n){
		this.studentList = new ArrayList<Student>();
		this.classGroupID = n;
	}
	
	public void addStudents(Student s) {
		this.studentList.add(s);
	}
	
	public void removeStudentList(int n) {
		this.studentList.remove(n);
	}
	
	public int getGroupID() {
		return this.classGroupID;
	}
	
	public String toString() {
		String output = "Class Group ID " + classGroupID + ": \n";
		for(int i = 0; i < studentList.size(); i++) {
			if(studentList.get(i) != null) {
				output += studentList.get(i).toString();
			}
		}
		return output;
	}
	
}
