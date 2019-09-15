 package controller;

public class GenerateExamples {
	/**
	 * Generates examples of the system
	 * @param mainSchool
	 */
	public GenerateExamples(School mainSchool) {
		Name n1 = new Name("John", "Mathis", "Johnstone");
		Name n2 = new Name("Tobias", "Killenger", "Keane");
		Name n3 = new Name("Collin", "Dylan", "Murphy");
		Name n4 = new Name("Eric", "Nero", "Tobin");
		Name n5 = new Name("Herrod", "Blasphermous", "Hieratic");
		Name n6 = new Name("Brian", "Holland", "Lynch");
		
		// Create students
		Student s1 = new Student(n1, "john@mycit.ie", 	35387568, "07/09/1990", 0030);
		Student s2 = new Student(n2, "tobias@mycit.ie", 35354478, "21/12/1995", 0031);
		Student s3 = new Student(n3, "collin@mycit.ie", 35339478, "01/06/1989", 0032);
		Student s4 = new Student(n4, "eric@mycit.ie", 	35387424, "05/07/1994", 0033);
		Student s5 = new Student(n5, "herrod@mycit.ie", 35385785, "24/03/1996", 0034);
		Student s6 = new Student(n6, "brian@mycit.ie", 	35386565, "31/10/1999", 0035);
		
		//Create Teachers
		Teacher t1 = new Teacher(n1, "john@mycit.ie", 35387568, 25, "Hardvard", 12);
		Teacher t2 = new Teacher(n2, "tobias@mycit.ie", 35354478, 24, "Yale", 11);
		Teacher t3 = new Teacher(n3, "collin@mycit.ie", 35339478, 23, "UCC", 10);
		
		// Set up student modules
		s1.addModule("Math", 0);
		s1.addModule("English", 0);
		s1.addModule("Object", 0);
		s1.addModule("Linear", 0);
		s1.addModule("History", 0);
		s1.addModule("Modular", 0);
		s2.addModule("Math", 0);
		s2.addModule("English", 0);
		s2.addModule("Object", 0);
		s3.addModule("Linear", 0);
		s3.addModule("History", 0);
		s4.addModule("Modular", 0);
		s5.addModule("Math", 0);
		s5.addModule("English", 0);
		s5.addModule("Object", 0);
		s5.addModule("Linear", 0);
		s6.addModule("History", 0);
		s6.addModule("Modular", 0);
		
		// Class groups
		ClassGroup c1 = new ClassGroup(0001);
		c1.addStudents(s1);
		c1.addStudents(s2);
		c1.addStudents(s3);
		c1.addStudents(s4);
		c1.addStudents(s5);
		c1.addStudents(s6);
		
		ClassGroup c2 = new ClassGroup(0002);
		c2.addStudents(s1);
		c2.addStudents(s2);
		c2.addStudents(s3);
		
		ClassGroup c3 = new ClassGroup(1234);
		c3.addStudents(s4);
		c3.addStudents(s5);
		c3.addStudents(s6);
		
		// Marks of students
		s1.setMarks("English", 57);
		s1.setMarks("Math", 30);
		s1.setMarks("History", 80);
		s2.setMarks("Object", 20);
		s5.setMarks("English", 10);
		s6.setMarks("Modular", 100);
		
		mainSchool.addStudent(s1);
		mainSchool.addStudent(s2);
		mainSchool.addStudent(s3);
		mainSchool.addStudent(s4);
		mainSchool.addStudent(s5);
		mainSchool.addStudent(s6);
		
		mainSchool.addTeacher(t1);
		mainSchool.addTeacher(t2);
		mainSchool.addTeacher(t3);
		
		mainSchool.addClassGroup(c1);
		mainSchool.addClassGroup(c2);
		mainSchool.addClassGroup(c3);
	}
}
