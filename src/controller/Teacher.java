package controller;

public class Teacher extends Person  {
	
	private String degree;
	private int age;
	private int teacherID;
	
	/**
	 * Sub class of person and creates information for teacher
	 * @param a
	 * @param e
	 * @param p
	 * @param ag
	 * @param deg
	 * @param id
	 */
	public Teacher(Name a, String e, int p, int ag, String deg, int id) {
		super(a, e, p);
		// TODO Auto-generated constructor stub
		this.age = ag;
		this.degree = deg;
		this.teacherID = id;
	}
	
	public void set_degree(String deg) {
		this.degree = deg;
	}
	
	public String toString() {
		return "Teacher details: \n " + super.toString() + ", age: " + age + ", " + teacherID + ", Degree: " + degree + "\n";
	}
}
