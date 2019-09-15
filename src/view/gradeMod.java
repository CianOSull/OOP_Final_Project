package view;

import controller.ClassGroup;
import controller.Name;
import controller.School;
import controller.Student;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import model.DatabaseHandler;

public class gradeMod extends Tab {
	public gradeMod(School mainSchool, DatabaseHandler db) {
		setText("Change marks");
		  GridPane  gp = new GridPane();
	      
		  // Buttons 
		  Button b1 = new Button ("Change mark of the subject");
		  
		  //TextField
		  TextField studentID = new TextField("");
		  TextField subject = new TextField("");
		  TextField marks = new TextField("");
		  
		  // Label
		  Label l1 = new Label("Student ID: ");
		  Label l2 = new Label("Subject: ");
		  Label l3 = new Label("Marks: ");
		  
		  
		  VBox vboxText = new VBox();
		  vboxText.setPadding(new Insets(30, 25, 25, 10));
		  vboxText.setSpacing(27);
	      vboxText.getChildren().addAll(studentID, subject, marks, b1 );
	      
	      VBox vboxLabel = new VBox();
	      vboxLabel.setPadding(new Insets(10, 5, 25, 10));
	      vboxLabel.setSpacing(35);
	      vboxLabel.getChildren().addAll(l1, l2, l3);
	      
	      b1.setOnAction(e->{
	    	  Student student = mainSchool.getStudent(Integer.parseInt(studentID.getText()));
	    	  //Student student = mainSchool.getStudent(24);
	    	  if(student != null) {
	    		 //String subjectHold = subject.getText();
	    		 student.setMarks(subject.getText(), Integer.parseInt(marks.getText()));
	    		 db.updateModule(Integer.parseInt(marks.getText()), student.getStudentID(), subject.getText());
	    		 System.out.println("Marks were changed");
	    	  }
	    	  else {
	    		 System.out.println("You entered your student wrong");
	    	  }
	      });
	      
	      //Add all the elements
	      gp.add(vboxLabel, 0, 0);
		  gp.add(vboxText, 0, 0);
	      
	      setContent(gp);
	}
}
