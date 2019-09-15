package view;

import controller.ClassGroup;
import controller.School;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import model.DatabaseHandler;

public class AddClassGroup extends Tab {
	public AddClassGroup(School mainSchool, DatabaseHandler db) {
		  setText("Add a Class Group");
		  GridPane  gp = new GridPane();
	      
		  // Buttons 
		  Button b1 = new Button ("Submit Class Group");
		  
		  // Label
		  Label l1 = new Label("Click to create class group: ");
		  
	      VBox vboxLabel = new VBox();
	      vboxLabel.setPadding(new Insets(10, 5, 25, 10));
	      vboxLabel.setSpacing(35);
	      vboxLabel.getChildren().addAll(l1, b1);
	      
	      b1.setOnAction(e->{
	    	  int groupID = mainSchool.ClassGroupsNewID();
	    	  ClassGroup newClassGroup = new ClassGroup(groupID);
	    	  db.insertClassGroup(groupID);
	    	  mainSchool.addClassGroup(newClassGroup);
	    	  System.out.println("Class Group added");
	      });
	      
	      //Add all the elements
	      gp.add(vboxLabel, 0, 0);
	      
	      setContent(gp);
	}
}
