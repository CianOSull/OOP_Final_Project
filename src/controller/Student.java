package controller;

public class Student extends Person {
	
	private String dob;
	private ModuleGrade[] modules;
	private int studentID;
	private int numOfMods = 0;
	
	/**
	 * Sub class of person and stores information on students
	 * @param a
	 * @param e
	 * @param p
	 * @param date
	 * @param id
	 */
	public Student(Name a, String e, int p, String date, int id) {
		super(a, e, p);
		// TODO Auto-generated constructor stub
		this.modules = new ModuleGrade[6];
		this.dob = date;
		this.studentID = id;
	}
	
	public void removeModule(String moduleName) {
		for(int i = 0; i < numOfMods; i++) {
			if(modules[i].getModuleName() == moduleName) {
				modules[i] = null;
				numOfMods--;
			}
		}
	}
	
	public void addModule(String s, int n) {
		ModuleGrade mod = new ModuleGrade(s, n);
		modules[numOfMods] = mod;
		numOfMods++;
	}
	
	public void setMarks(String moduleName, int n) {
		for(int i = 0; i < numOfMods; i++) {
			if(modules[i].getModuleName().equals(moduleName) ) {
				modules[i].setGrade(n);
			}
		}
	}
	
	public String toString() {
		String output = "";
		output = super.toString() + ", DOB: " + dob + ", StudentID: " + studentID + "\nModules:\n";
		for(int i = 0; i < numOfMods; i++) {
			if(modules[i] != null) {
				output += modules[i].toString();
			}
		}
		output += "\n";
		return output;
	}
	
	public int getStudentID() {
		return this.studentID;
	}
	
	public String getDOB() {
		return this.dob;
	}
	
	public int phone() {
		return super.getPhone();
	}
	
	public String getEmail() {
		return super.getEmail();
	}
}
