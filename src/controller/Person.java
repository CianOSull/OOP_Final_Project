package controller;

public class Person {
	private Name name;
	private String email;
	private int phone;
	
	/**
	 * This is the super class for teacher and students and stores informaiton on them
	 * @param a
	 * @param e
	 * @param p
	 */
	public Person(Name a, String e, int p) {
		this.name = a;
		this.email = e;
		this.phone = p;
		
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public int getPhone() {
		return this.phone;
	}
	
	public String getFirstName() {
		return this.name.get_firstName();
	}
	
	public String getMiddleName() {
		return this.name.get_middleName();
	}
	
	public String getLastName() {
		return this.name.get_lastName();
	}
	
	public String toString() {
		return "Name: " + name.get_firstName() + " " + name.get_middleName() + " " + name.get_lastName() + ", Email: " + email + 
				", Phone number: " + phone;
	}
	
}
