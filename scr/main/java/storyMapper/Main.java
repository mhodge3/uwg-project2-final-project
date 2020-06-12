package storyMapper;

import java.io.IOException;

import DAL.MySQLAccess;
import controller.LoginControl;
import controller.LoginViewControl;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Entry point to the RPG Story Mapper program
 * 
 * @author Hodge
 * @version 6.10.2020
 */

public class Main extends Application {

	public static void main(String[] args) throws Exception {
		//System.out.println("Hello World");
        //MySQLAccess dao = new MySQLAccess();
        //dao.readDataBase();
        launch(args);
	}
    
    @Override
    public void start(Stage primaryStage) throws Exception {
    	LoginControl theLoginControl = new LoginControl();
        LoginViewControl theLoginViewControl = new LoginViewControl(theLoginControl);
        MySQLAccess theDBConnection = new MySQLAccess();
        theLoginControl.SetTheDBConnection(theDBConnection);
        Parent theLoginParentView;
        try {
        	theLoginParentView = theLoginViewControl.getTheFxmlLoader().load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
        primaryStage.setScene(new Scene(theLoginParentView));
        primaryStage.setTitle("Story Mapper");
        primaryStage.setWidth(800);
        primaryStage.setHeight(600);
        primaryStage.show();
    }

}
