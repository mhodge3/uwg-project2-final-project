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
import com.cs6920.view.ViewControl;

/**
 * @author Ashley Palmer
 * @date 6/27/2020
 *
 */
public class EditGameStoryViewControl extends ViewControl {
	
	@FXML
	private TextField editGameStoryNameTextBox;
	@FXML
	private TextArea editGameStorySummaryTextArea;
	@FXML
	private TextField playerLevelCapTextField;
	@FXML
	private TextField npcLevelCapTextField;


	private MainDashboardViewControl theMainDashboardViewControl;
	private EditGameStoryControl gameStoryEditControl;
	
	/**
	 * Constructor for this View Control
	 * @param theMainDashboardViewControl	Reference to the MainDashboard's View Control
	 * @throws SQLException 
	 */
    public EditGameStoryViewControl(MainDashboardViewControl theMainDashboardViewControl) throws SQLException {
    	this.theMainDashboardViewControl = theMainDashboardViewControl;
    	this.gameStoryEditControl = new EditGameStoryControl(theMainDashboardViewControl.getDBConnection());
    }
    
    /**
     * Gets logic control for this Edit Game Story view control
     * @return the Item edited
     */
    public EditGameStoryControl getGameStoryEditControl() {
    	return gameStoryEditControl;
    }
    
    @FXML
    public void initialize() {
    	this.setFormForSelectedGameStory(gameStoryEditControl.getGameStoryToEdit());
    }
    
    /**
     * Sets the form values to those of the GameStory to edit
     * @param theGameStoryToEdit
     */
    public void setFormForSelectedGameStory(GameStory theGameStoryToEdit) {
    	editGameStoryNameTextBox.setText(String.valueOf(theGameStoryToEdit.getGameStoryName()));
    	editGameStorySummaryTextArea.setText(theGameStoryToEdit.getGameStorySummary());
    	playerLevelCapTextField.setText(String.valueOf(theGameStoryToEdit.getPlayerLevelCap()));
    }
    
	@FXML
	private void handleGameStoryEditCancelButton() throws SQLException {
		theMainDashboardViewControl.setMainDashboardStage("mainDashboard");
	}
    
	@FXML
	private void handleGameStorySaveButton() throws SQLException {
		String gameStoryCreationError = null;
		try {
			gameStoryCreationError = gameStoryEditControl.updateGameStory(editGameStoryNameTextBox.getText(), editGameStorySummaryTextArea.getText(), Integer.parseInt(playerLevelCapTextField.getText()), Integer.parseInt(npcLevelCapTextField.getText()));
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
		theMainDashboardViewControl.setMainDashboardStage("mainDashboard");
	}

}
