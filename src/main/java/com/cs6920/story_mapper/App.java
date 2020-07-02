package com.cs6920.story_mapper;

import com.cs6920.DAL.MySQLAccess;
import com.cs6920.control.logic_control.LoginControl;
import com.cs6920.view.LoginViewControl;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

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
        theLoginStage.setWidth(375);
        theLoginStage.setHeight(480);
        theLoginViewControl.LoadLoginView();
    }

}