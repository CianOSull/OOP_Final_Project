package view;

import controller.School;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import model.DatabaseHandler;

public class ListSchoolInfo extends Tab {
	public ListSchoolInfo(School mainSchool, DatabaseHandler db) {
		setText("List School Info");
		
		Button b1 = new Button ("List All student information and class groups (All lists will be output to the console)");
		
		TextArea output = new TextArea("");
		output.setEditable(false);
		output.setPrefSize(100, 100);
		Label l1 = new Label("List of all the Cars");
		String splitUp = "======================================Student Detials================================\n";
		
		VBox vbox = new VBox();
	    vbox.setPadding(new Insets(10, 5, 25, 10));
	    vbox.setSpacing(10);
	    //Background colour
	    vbox.setStyle("-fx-background-color: orange;");
	    //Font colour
	    vbox.getChildren().addAll(l1, output, b1);
	    
	    b1.setOnAction(e->{
	    	//System.out.print(mainSchool.toString());
	    	System.out.print(splitUp + mainSchool.toString());
	    	output.setText(mainSchool.toString());
	    });
	    
	    setContent(vbox);
	}
}
