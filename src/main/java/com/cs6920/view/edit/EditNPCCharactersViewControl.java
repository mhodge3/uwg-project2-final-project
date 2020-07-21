package com.cs6920.view.edit;

import java.sql.SQLException;

import com.cs6920.control.logic_control.EditNPCCharactersControl;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;

import com.cs6920.model.NpcCharacter;
import com.cs6920.view.MainDashboardViewControl;
import com.cs6920.view.ViewControl;

/**
 * Communicates between the Create Edit NCPCharacters fxml view and the logic control
 * @author Matthew Hodge
 * @version 6.23.2020
 */
public class EditNPCCharactersViewControl extends ViewControl {
	@FXML
	private TextField editNPCType;
	@FXML
	private TextField editNPCPosX;
	@FXML
	private TextField editNPCPosY;
	@FXML
	private TextField editNPCPosZ;
	@FXML
	private Spinner<Integer> editNPCLevelSpinner;
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
    
    /**
     * Gets the logic control instance for this view
     * @return  the logic control instance
     */
    public EditNPCCharactersControl GetEditNPCCharactersControl() {
    	return theEditNPCCharactersControl;
    }
    
    /**
     * Sets the form values for the current NPC to edit
     * @param theNPCToEdit
     */
    public void SetFormForSelectedNPC(NpcCharacter theNPCToEdit) {
    	this.editNPCType.setText(String.valueOf(theNPCToEdit.GetNpcType()));
    	this.editNPCNameTextBox.setText(theNPCToEdit.GetNpcName());
    	this.editNPCDescriptionTextBox.setText(theNPCToEdit.GetNpcDescprition());
    	this.editNPCPosX.setText(Double.toString(theNPCToEdit.GetNpcPosX()));
    	this.editNPCPosY.setText(Double.toString(theNPCToEdit.GetNpcPosY()));
    	this.editNPCPosZ.setText(Double.toString(theNPCToEdit.GetNpcPosZ()));
		this.editNPCLevelSpinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(1, this.theMainDashboardViewControl.getTheGameStory().GetNpcCharacterLevelCap(), theNPCToEdit.GetNpcLevel()));
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
			npcCreationError = theEditNPCCharactersControl.UpdateNpc(theEditNPCCharactersControl.GetSelectedNPC().GetNpcId(), Integer.parseInt(editNPCType.getText()), editNPCNameTextBox.getText(), editNPCDescriptionTextBox.getText(), Double.parseDouble(editNPCPosX.getText()), Double.parseDouble(editNPCPosY.getText()), Double.parseDouble(editNPCPosZ.getText()), this.editNPCLevelSpinner.getValue());
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
