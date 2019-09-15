package controller;

public class ModuleGrade {
	private String moduleName;
	private int grade;
	/**
	 * 
	 * @param s
	 * @param g
	 * This is the class that creates and stores infromation on modules
	 */
	public ModuleGrade(String s, int g) {
		this.moduleName = s;
		this.grade = g;
	}
	
	public String getModuleName() {
		return this.moduleName;
	}
	
	public int getGrade() {
		return grade;
	}
	
	public void setModuleName(String a) {
		this.moduleName = a;
	}
	
	public void setGrade(int n) {
		this.grade = n;
	}
	
	public String toString() {
		return " Module name: " + moduleName + ", Marks: " + grade + "\n";
	}
	
}
