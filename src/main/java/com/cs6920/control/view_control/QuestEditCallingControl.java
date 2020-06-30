package com.cs6920.control.view_control;

import java.sql.SQLException;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class QuestEditCallingControl {
	@FXML 
	private Button questEditBackButton;
    
	@FXML
	private void handleBackButton() throws SQLException {
	    // get a handle to the stage
	    Stage stage = (Stage) questEditBackButton.getScene().getWindow();
	    // do what you have to do
	    stage.close();
	}
}
