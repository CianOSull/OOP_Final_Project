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
import javafx.scene.layout.VBox;
import model.DatabaseHandler;

public class RemoveClassGroup extends Tab {
	public RemoveClassGroup(School mainSchool, DatabaseHandler db) {
		
		setText("Remove a Class Group");
		
		Button b1 = new Button ("Remove Class Group");
		
		TextField classGroupID = new TextField("");
		Label l1 = new Label("Enter the Class Group ID to Remove the Class Group");
		
		VBox vbox = new VBox();
	    vbox.setPadding(new Insets(10, 5, 25, 10));
	    vbox.setSpacing(10);
	    //Background colour
	    vbox.setStyle("-fx-background-color: white;");
	    //Font colour
	    vbox.getChildren().addAll(l1, classGroupID, b1);
	    
	    b1.setOnAction(e->{
	    	ClassGroup classGroup = mainSchool.getClassGroup(Integer.parseInt(classGroupID.getText()));
			if(classGroup != null) {
				db.deleteClassGroup(classGroup.getGroupID());
				mainSchool.removeClassGroup(classGroup);
				System.out.println("Class group has been removed");
			}
			else {
				System.out.println("You entered your class group wrong");
			}
	    });
	    
	    setContent(vbox);
	}
}
