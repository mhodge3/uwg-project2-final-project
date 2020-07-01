/**
 * 
 */
package com.cs6920.control.view_control;

import java.sql.SQLException;

import com.cs6920.control.logic_control.GameStoryEditControl;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

import com.cs6920.model.GameStory;
import com.cs6920.model.Item;

/**
 * @author Ashley Palmer
 * @date 6/27/2020
 *
 */
public class EditGameStoryViewControl {
	
	@FXML
	private TextField editGameStoryNameTextBox;
	@FXML
	private TextArea editGameStorySummaryTextArea;;


	private MainDashboardViewControl theMainDashboardViewControl;
	private GameStoryEditControl gameStoryEditControl;
	
	/**
	 * Constructor for this View Control
	 * @param theMainDashboardViewControl	Reference to the MainDashboard's View Control
	 */
    public EditGameStoryViewControl(MainDashboardViewControl theMainDashboardViewControl) {
    	this.theMainDashboardViewControl = theMainDashboardViewControl;
    	this.gameStoryEditControl = new GameStoryEditControl(theMainDashboardViewControl.GetDBConnection());
    }
    
    /**
     * Gets logic control for this Edit Game Story view control
     * @return the Item edited
     */
    public GameStoryEditControl GetGameStoryEditControl() {
    	return gameStoryEditControl;
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
		theMainDashboardViewControl.SetMainDashboardStage("manageItems");
	}
    
	@FXML
	private void handleDeleteSelectedButton() throws SQLException {
		String GameStoryDeleteError = null;
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Game Story Edit");
		alert.setHeaderText("Item Edit Status");
		alert.setContentText("Are you sure you want to DELETE " + gameStoryEditControl.GetSelectedItem().GetGameStoryName() + "? This operation cannot be undone.");
		alert.showAndWait();
		if (alert.getResult() == ButtonType.OK) {
			try {
				GameStoryDeleteError = gameStoryEditControl.DeleteItem(gameStoryEditControl.GetSelectedItem());
			} catch (Exception e) {
				GameStoryDeleteError = e.getMessage();
			}
			if (GameStoryDeleteError != null) {
				alert = new Alert(AlertType.ERROR);
				alert.setTitle("Error Dialog");
				alert.setHeaderText("Error Editing the Game Story");
				alert.setContentText(GameStoryDeleteError);
				alert.showAndWait();
				return;
			}
			alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Game Story Edit");
			alert.setHeaderText("Game Story Edit Status");
			alert.setContentText("The Game Story was successfully deleted");
			alert.showAndWait();
			theMainDashboardViewControl.SetMainDashboardStage("manageItems");
		}
	}
    
	@FXML
	private void handleGameStorySaveButton() throws SQLException {
		String gameStoryCreationError = null;
		try {
			gameStoryCreationError = gameStoryEditControl.UpdateGameStory(editGameStorySummaryTextArea.getText(), editGameStoryNameTextBox.getText());
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
		theMainDashboardViewControl.SetMainDashboardStage("manageItems");
	}

}
