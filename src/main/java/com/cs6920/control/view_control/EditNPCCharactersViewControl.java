package com.cs6920.control.view_control;

import java.sql.SQLException;

import com.cs6920.control.logic_control.EditNPCCharactersControl;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import com.cs6920.model.NpcCharacter;

public class EditNPCCharactersViewControl {
	@FXML
	private TextField editNPCType;
	@FXML
	private TextField editNPCNameTextBox;
	@FXML
	private TextArea editNPCDescriptionTextBox;

	private MainDashboardViewControl theMainDashboardViewControl;
	private EditNPCCharactersControl theEditNPCCharactersControl;
    
	/**
	 * Constructor for this View Control
	 * @param theMainDashboardViewControl	Reference to the MainDashboard's View Control
	 */
    public EditNPCCharactersViewControl(MainDashboardViewControl theMainDashboardViewControl) {
    	this.theMainDashboardViewControl = theMainDashboardViewControl;
    	this.theEditNPCCharactersControl = new EditNPCCharactersControl(theMainDashboardViewControl.GetDBConnection());
    }
    
    public EditNPCCharactersControl GetEditNPCCharactersControl() {
    	return theEditNPCCharactersControl;
    }
    
    public void SetFormForSelectedNPC(NpcCharacter theNPCToEdit) {
    	editNPCType.setText(String.valueOf(theNPCToEdit.GetNpcType()));
    	editNPCNameTextBox.setText(theNPCToEdit.GetNpcName());
    	editNPCDescriptionTextBox.setText(theNPCToEdit.GetNpcDescprition());
    }
    
	@FXML
	private void handleNPCEditBackButton() throws SQLException {
		theMainDashboardViewControl.SetMainDashboardStage("manageNPCCharacters");
	}
    
	@FXML
	private void handleNPCDeleteButton() throws SQLException {
		String npcDeleteError = null;
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("NPC Edit");
		alert.setHeaderText("NPC Edit Status");
		alert.setContentText("Are you sure you want to DELETE " + theEditNPCCharactersControl.GetSelectedNPC().GetNpcName() + "? This operation cannot be undone.");
		alert.showAndWait();
		if (alert.getResult() == ButtonType.OK) {
			try {
				npcDeleteError = theEditNPCCharactersControl.DeleteNPC(theEditNPCCharactersControl.GetSelectedNPC());
			} catch (Exception e) {
				npcDeleteError = e.getMessage();
			}
			if (npcDeleteError != null) {
				alert = new Alert(AlertType.ERROR);
				alert.setTitle("Error Dialog");
				alert.setHeaderText("Error Editing the NPC");
				alert.setContentText(npcDeleteError);
				alert.showAndWait();
				return;
			}
			alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("NPC Edit");
			alert.setHeaderText("NPC Edit Status");
			alert.setContentText("The NPC was successfully deleted");
			alert.showAndWait();
			theMainDashboardViewControl.SetMainDashboardStage("manageNPCCharacters");
		}
	}
    
	@FXML
	private void handleNPCEditSaveButton() throws SQLException {
		String npcCreationError = null;
		try {
			npcCreationError = theEditNPCCharactersControl.UpdateNpc(theEditNPCCharactersControl.GetSelectedNPC().GetNpcId(), Integer.parseInt(editNPCType.getText()), editNPCNameTextBox.getText(), editNPCDescriptionTextBox.getText());
		} catch (Exception e) {
			npcCreationError = e.getMessage();
		}
		if (npcCreationError != null) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error Dialog");
			alert.setHeaderText("Error Editing the NPC");
			alert.setContentText(npcCreationError);
			alert.showAndWait();
			return;
		}
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("NPC Edit");
		alert.setHeaderText("NPC Edit Status");
		alert.setContentText("The NPC was successfully modified");
		alert.showAndWait();
		theMainDashboardViewControl.SetMainDashboardStage("manageNPCCharacters");
	}
}
