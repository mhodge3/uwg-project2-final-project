package com.cs6920.control.view_control;

import java.sql.SQLException;

import com.cs6920.control.logic_control.QuestEditCallingControl;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class QuestEditCallingViewControl {
	@FXML 
	private Button questEditBackButton;
	@FXML
	private TextField editCallingQuestName;
	
	QuestEditCallingControl theQuestEditCallingControl;
	
	public QuestEditCallingViewControl(ManageTemplateTheQuestViewControl theManageTemplateTheQuestViewControl, int questIdToEdit) {
		theQuestEditCallingControl = new QuestEditCallingControl(theManageTemplateTheQuestViewControl, questIdToEdit);
	}
	
	@FXML 
	private void handleQuestSaveChanges() throws SQLException {
		theQuestEditCallingControl.updateQuestName(editCallingQuestName.getText());
		theQuestEditCallingControl.refreshQuestDisplay();
		this.handleBackButton();
	}
    
	@FXML
	private void handleBackButton() throws SQLException {
	    // get a handle to the stage
	    Stage stage = (Stage) questEditBackButton.getScene().getWindow();
	    // do what you have to do
	    stage.close();
	}
}
