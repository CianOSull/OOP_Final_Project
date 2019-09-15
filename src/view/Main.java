package view;
	
import controller.GenerateExamples;
import controller.School;
import javafx.application.Application;
import javafx.stage.Stage;
import model.DatabaseHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;

public class Main extends Application  {
	School mainSchool;
	DatabaseHandler db;
	
	@Override
	public void start(Stage primaryStage) {
		mainSchool = new School();
		db = new DatabaseHandler(mainSchool);
		
		//GenerateExamples t = new GenerateExamples(mainSchool);
		
		// This file manager puts the car list object into a file and also allows you to put the contents into a new calss at the start
		try {
			BorderPane mainPane = new BorderPane();
			Group root = new Group();
			Scene scene = new Scene(root,700,500);
			
			TabPane tp = new TabPane();
			
			//The this here is passing the object main into all of them so they can use the score getter and setter
			tp.getTabs().add(new AddStudents(mainSchool, db));
			tp.getTabs().add(new RemoveStudents(mainSchool, db));
			tp.getTabs().add(new AddClassGroup(mainSchool, db));
			tp.getTabs().add(new RemoveClassGroup(mainSchool, db));
			tp.getTabs().add(new gradeMod(mainSchool, db));
			tp.getTabs().add(new ListSchoolInfo(mainSchool, db));
			
			//Set up School from database
			
			db.getClassGroupInfo();
			db.getStudentInfo();
			db.assignGroups();
			db.getModuleInfo();
			db.getTeacherInfo();
			
			mainPane.setCenter(tp);	  
			mainPane.prefHeightProperty().bind(scene.heightProperty());
			mainPane.prefWidthProperty().bind(scene.widthProperty());
		     
		    root.getChildren().add(mainPane);
			
		    primaryStage.setScene(scene);
			primaryStage.show();
		} 
		
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}