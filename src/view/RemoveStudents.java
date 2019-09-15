package view;

import controller.School;
import controller.Student;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import model.DatabaseHandler;

public class RemoveStudents extends Tab {
	public RemoveStudents(School mainSchool, DatabaseHandler db) {
		
		setText("Remove a Student");
		
		Button b1 = new Button ("Remove Student");
		
		TextField studentID = new TextField("");
		Label l1 = new Label("Enter the Student ID to Remove the student");
		
		VBox vbox = new VBox();
	    vbox.setPadding(new Insets(10, 5, 25, 10));
	    vbox.setSpacing(10);
	    //Background colour
	    vbox.setStyle("-fx-background-color: green;");
	    //Font colour
	    vbox.getChildren().addAll(l1, studentID, b1);
	    
	    b1.setOnAction(e->{
	    	Student student = mainSchool.getStudent(Integer.parseInt(studentID.getText()));
			if(student != null) {
				mainSchool.removeStudent(student);
				db.deleteStudent(student.getStudentID());
				System.out.println("Student has been removed");
			}
			else {
				System.out.println("You entered your class group wrong");
			}
	    });
	    
	    setContent(vbox);
	}
}
