package com.cs6920.control.view_control;

import java.sql.SQLException;

import com.cs6920.control.logic_control.CreateNPCCharactersControl;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class CreateNPCCharactersViewControl {

	@FXML
	private TextField createNPCType;
	@FXML
	private TextField createNPCNameTextBox;
	@FXML
	private TextArea createNPCDescriptionTextBox;

	private MainDashboardViewControl theMainDashboardViewControl;
	private CreateNPCCharactersControl theCreateNPCCharactersControl;
    
	/**
	 * Constructor for this View Control
	 * @param theMainDashboardViewControl	Reference to the MainDashboard's View Control
	 */
    public CreateNPCCharactersViewControl(MainDashboardViewControl theMainDashboardViewControl) {
    	this.theMainDashboardViewControl = theMainDashboardViewControl;
    	this.theCreateNPCCharactersControl = new CreateNPCCharactersControl(theMainDashboardViewControl.GetDBConnection());
    }
    
    /**
     * Clear Form for next new Entry
     */
    private void ResetCreateNPCCharactersView() {
    	createNPCType.setText("");
    	createNPCNameTextBox.setText("");
    	createNPCDescriptionTextBox.setText("");
    }
    
	@FXML
	private void handleNPCCreateCanelButton() throws SQLException {
		ResetCreateNPCCharactersView();
		theMainDashboardViewControl.SetMainDashboardStage("manageNPCCharacters");
	}
    
	@FXML
	private void handleNPCCreateButton() throws SQLException {
		String npcCreationError = null;
		try {
			npcCreationError = theCreateNPCCharactersControl.CreateNpc(Integer.parseInt(createNPCType.getText()), createNPCNameTextBox.getText(), createNPCDescriptionTextBox.getText());
		} catch (Exception e) {
			npcCreationError = e.getMessage();
		}
		if (npcCreationError != null) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error Dialog");
			alert.setHeaderText("Error Creating the new NPC");
			alert.setContentText(npcCreationError);
			alert.showAndWait();
			return;
		}
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("NPC Creation");
		alert.setHeaderText("NPC Creation Status");
		alert.setContentText("The NPC was successfully created");
		alert.showAndWait();
		ResetCreateNPCCharactersView();
		theMainDashboardViewControl.SetMainDashboardStage("manageNPCCharacters");
	}
}
