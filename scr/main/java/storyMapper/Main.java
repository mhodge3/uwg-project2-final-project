package storyMapper;

import java.io.IOException;

import DAL.MySQLAccess;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
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
		System.out.println("Hello World");
        MySQLAccess dao = new MySQLAccess();
        dao.readDataBase();
        launch(args);
	}
    
    @Override
    public void start(Stage primaryStage) throws IOException {
    	Parent root = FXMLLoader.load(getClass().getResource("/view/LoginView.fxml"));
    	Scene scene = new Scene(root, 300, 275);
        
    	primaryStage.setTitle("FXML Welcome");
    	primaryStage.setScene(scene);
    	primaryStage.show();
    }

}
