package view;

import controller.School;
import controller.Student;
import controller.ClassGroup;
import controller.Name;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import model.DatabaseHandler;

public class AddStudents extends Tab {
	public AddStudents(School mainSchool, DatabaseHandler db) {
		  setText("Add a Student");
		  GridPane  gp = new GridPane();
	      
		  // Buttons 
		  Button b1 = new Button ("Submit Student");
		  
		  //TextField
		  TextField firstName = new TextField("");
		  TextField middleName = new TextField("");
		  TextField lastName = new TextField("");
		  TextField email = new TextField("");
		  TextField phone = new TextField("");
		  TextField DOB = new TextField("");
		  TextField classGroupID = new TextField("");
		  
		  // Label
		  Label l1 = new Label("First Name: ");
		  Label l2 = new Label("Middle Name: ");
		  Label l3 = new Label("Last Name: ");
		  Label l4 = new Label("Email: ");
		  Label l5 = new Label("Phone: ");
		  Label l6 = new Label("DOB: ");
		  Label l7 = new Label("Class Group ID: ");
		  
		  VBox vboxText = new VBox();
		  vboxText.setPadding(new Insets(30, 25, 25, 10));
		  vboxText.setSpacing(27);
	      vboxText.getChildren().addAll(firstName, middleName, lastName, email, phone, DOB, classGroupID, b1);
	      
	      VBox vboxLabel = new VBox();
	      vboxLabel.setPadding(new Insets(10, 5, 25, 10));
	      vboxLabel.setSpacing(35);
	      vboxLabel.getChildren().addAll(l1, l2, l3, l4, l5, l6, l7);
	      
	      b1.setOnAction(e->{
	    	  ClassGroup classGroup = mainSchool.getClassGroup(Integer.parseInt(classGroupID.getText()));
	    	  if(classGroup != null) {
	    		  int studentID = mainSchool.lastStudentID() + 1;
	    		  Name newName = new Name(firstName.getText(), middleName.getText(), lastName.getText());
		    	  Student newStudent = new Student(newName, email.getText(), Integer.parseInt(phone.getText()), DOB.getText(), studentID);
		    	  classGroup.addStudents(newStudent);
		    	  db.insertStudent(newStudent, classGroup.getGroupID());
		    	  System.out.println("Student was entered into the system");
	    	  }
	    	  else {
	    		  System.out.println("You entered your class group wrong");
	    	  }
	      });
	      
	      //Add all the elements
	      gp.add(vboxLabel, 0, 0);
		  gp.add(vboxText, 0, 0);
	      
	      setContent(gp);
	}
}
