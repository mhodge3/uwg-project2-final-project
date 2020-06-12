package storyMapper;

import java.io.IOException;

import DAL.MySQLAccess;
import controller.AdminController;
import javafx.application.Application;
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
    public void start(Stage primaryStage) throws IOException {
        AdminController adminControl = new AdminController();
        
        primaryStage.setScene(new Scene(adminControl));
        primaryStage.setTitle("Story Mapper");
        primaryStage.setWidth(800);
        primaryStage.setHeight(600);
        primaryStage.show();
        adminControl.doSomething();
    }

}
