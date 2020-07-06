/**
 * 
 */
package com.cs6920.view.edit;

import java.sql.SQLException;

import com.cs6920.control.logic_control.EditGameStoryControl;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

import com.cs6920.model.GameStory;
import com.cs6920.view.MainDashboardViewControl;

/**
 * @author Ashley Palmer
 * @date 6/27/2020
 *
 */
public class EditGameStoryViewControl {
	
	@FXML
	private TextField editGameStoryNameTextBox;
	@FXML
	private TextArea editGameStorySummaryTextArea;


	private MainDashboardViewControl theMainDashboardViewControl;
	private EditGameStoryControl gameStoryEditControl;
	
	/**
	 * Constructor for this View Control
	 * @param theMainDashboardViewControl	Reference to the MainDashboard's View Control
	 * @throws SQLException 
	 */
    public EditGameStoryViewControl(MainDashboardViewControl theMainDashboardViewControl) throws SQLException {
    	this.theMainDashboardViewControl = theMainDashboardViewControl;
    	this.gameStoryEditControl = new EditGameStoryControl(theMainDashboardViewControl.GetDBConnection());
    }
    
    /**
     * Gets logic control for this Edit Game Story view control
     * @return the Item edited
     */
    public EditGameStoryControl GetGameStoryEditControl() {
    	return gameStoryEditControl;
    }
    
    @FXML
    public void initialize() {
    	this.SetFormForSelectedGameStory(gameStoryEditControl.getGameStoryToEdit());
    }
    
    /**
     * Sets the form values to those of the GameStory to edit
     * @param theGameStoryToEdit
     */
    public void SetFormForSelectedGameStory(GameStory theGameStoryToEdit) {
    	editGameStoryNameTextBox.setText(String.valueOf(theGameStoryToEdit.GetGameStoryName()));
    	editGameStorySummaryTextArea.setText(theGameStoryToEdit.GetGameStorySummary());
    }
    
	@FXML
	private void handleGameStoryEditCancelButton() throws SQLException {
		theMainDashboardViewControl.SetMainDashboardStage("mainDashboard");
	}
    
	@FXML
	private void handleGameStorySaveButton() throws SQLException {
		String gameStoryCreationError = null;
		try {
			gameStoryCreationError = gameStoryEditControl.UpdateGameStory(editGameStoryNameTextBox.getText(), editGameStorySummaryTextArea.getText());
		} catch (Exception e) {
			gameStoryCreationError = e.getMessage();
		}
		if (gameStoryCreationError != null) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error Dialog");
			alert.setHeaderText("Error Editing the Game Story");
			alert.setContentText(gameStoryCreationError);
			alert.showAndWait();
			return;
		}
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Game Story Edit");
		alert.setHeaderText("Game Story Edit Status");
		alert.setContentText("The Game Story was successfully modified");
		alert.showAndWait();
		theMainDashboardViewControl.SetMainDashboardStage("mainDashboard");
	}

}
