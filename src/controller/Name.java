package controller;

public class Name {
	String firstName, middleName, lastName;
	
	/**
	 * Creates information on name
	 * @param firstName
	 */
	public Name(String firstName) {
		this.firstName = firstName;
	}
	
	public Name(String firstName, String middleName) {
		this.firstName = firstName;
		this.middleName = middleName;
	}
	
	public Name(String firstName, String middleName, String lastName) {
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
	}
	
	public String get_firstName() {
		return firstName;
	}
	
	public String get_middleName() {
		return middleName;
	}
	
	public String get_lastName() {
		return lastName;
	}
}
