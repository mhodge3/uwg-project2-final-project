package storyMapper;

import DAL.MySQLAccess;
import controller.LoginControl;
import controller.LoginViewControl;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 * Entry point to the RPG Story Mapper program
 * 
 * @author Matthew Hodge
 * @version 6.10.2020
 */

public class Main extends Application {

	public static void main(String[] args) throws Exception {
        launch(args);
	}
    
    @Override
    public void start(Stage theLoginStage) throws Exception {
    	LoginControl theLoginControl = new LoginControl();
        LoginViewControl theLoginViewControl = new LoginViewControl(theLoginControl, theLoginStage);
        MySQLAccess theDBConnection = new MySQLAccess();
        theLoginControl.SetTheDBConnection(theDBConnection);
        theLoginControl.SetLoginViewControl(theLoginViewControl);
        theLoginStage.setTitle("Story Mapper");
        theLoginStage.setWidth(800);
        theLoginStage.setHeight(600);
        theLoginViewControl.LoadLoginView();
    }

}
