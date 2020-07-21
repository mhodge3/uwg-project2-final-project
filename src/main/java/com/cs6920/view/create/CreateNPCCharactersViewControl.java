package com.cs6920.view.create;

import java.sql.SQLException;

import com.cs6920.control.logic_control.CreateNPCCharactersControl;
import com.cs6920.view.MainDashboardViewControl;
import com.cs6920.view.ViewControl;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

/**
 * Communicates between the Create NPCCharacters fxml view and the logic control
 * @author Matthew Hodge
 * @version 6.23.2020
 */
public class CreateNPCCharactersViewControl extends ViewControl {

	@FXML
	private TextField createNPCType;
	@FXML
	private TextField createNPCPosX;
	@FXML
	private TextField createNPCPosY;
	@FXML
	private TextField createNPCPosZ;
	@FXML
	private Spinner<Integer> createNPCLevelSpinner;
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
    
    private void ResetCreateNPCCharactersView() {
    	this.createNPCType.setText("");
    	this.createNPCNameTextBox.setText("");
    	this.createNPCDescriptionTextBox.setText("");
    	this.createNPCPosX.setText("");
    	this.createNPCPosY.setText("");
    	this.createNPCPosZ.setText("");
		this.createNPCLevelSpinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(1, this.theMainDashboardViewControl.getTheGameStory().GetNpcCharacterLevelCap(), 1));
    }
    
    @FXML
    private void initialize()  {
		this.createNPCLevelSpinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(1, this.theMainDashboardViewControl.getTheGameStory().GetNpcCharacterLevelCap(), 1));
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
			npcCreationError = theCreateNPCCharactersControl.CreateNpc(Integer.parseInt(createNPCType.getText()), createNPCNameTextBox.getText(), createNPCDescriptionTextBox.getText(), Double.parseDouble(createNPCPosX.getText()), Double.parseDouble(createNPCPosY.getText()), Double.parseDouble(createNPCPosZ.getText()), this.createNPCLevelSpinner.getValue());
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
