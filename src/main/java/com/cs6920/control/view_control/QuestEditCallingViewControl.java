package com.cs6920.control.view_control;

import java.sql.SQLException;
import java.util.ArrayList;

import com.cs6920.control.logic_control.QuestEditCallingControl;
import com.cs6920.model.NpcCharacter;
import com.cs6920.model.Quest;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class QuestEditCallingViewControl {
	@FXML 
	private Button questEditBackButton;
	@FXML
	private TextField editCallingQuestName;
	@FXML
	private TextArea editCallingQuestDescription;
	@FXML
	private ComboBox<String> questHeraldNPCComboBox;
	
	QuestEditCallingControl theQuestEditCallingControl;
	
	public QuestEditCallingViewControl(ManageTemplateTheQuestViewControl theManageTemplateTheQuestViewControl, int questIdToEdit) throws SQLException {
		theQuestEditCallingControl = new QuestEditCallingControl(theManageTemplateTheQuestViewControl, questIdToEdit);
	}
	
	private void setUpHeraldNPCComboBox() {
		ArrayList<String> npcNames = new ArrayList<String>();
		for (NpcCharacter theNPC : (ObservableList<NpcCharacter>) theQuestEditCallingControl.getTheObservableNPCs()) {
			npcNames.add(theNPC.GetNpcName());
		}
		questHeraldNPCComboBox.getItems().addAll(npcNames);
	}

	@FXML
    private void initialize() throws SQLException {
		this.setUpHeraldNPCComboBox();
	}
	
	@FXML 
	private void handleQuestSaveChanges() throws SQLException {
		theQuestEditCallingControl.updateQuestName(editCallingQuestName.getText());
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
