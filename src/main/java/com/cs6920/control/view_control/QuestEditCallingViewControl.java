package com.cs6920.control.view_control;

import java.sql.SQLException;
import java.util.ArrayList;

import com.cs6920.control.logic_control.QuestEditCallingControl;
import com.cs6920.model.Item;
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
	@FXML
	private ComboBox<String> questMentorNPCComboBox;
	@FXML
	private ComboBox<String> addQuestItemComboBox;
	@FXML
	private ComboBox<String> addRewardItemComboBox;
	
	QuestEditCallingControl theQuestEditCallingControl;
	
	public QuestEditCallingViewControl(ManageTemplateTheQuestViewControl theManageTemplateTheQuestViewControl, int questIdToEdit) throws SQLException {
		theQuestEditCallingControl = new QuestEditCallingControl(theManageTemplateTheQuestViewControl, questIdToEdit);
	}
	
	private void setUpHeraldNPCComboBox() throws SQLException {
		ArrayList<String> npcNames = new ArrayList<String>();
		for (NpcCharacter theNPC : (ObservableList<NpcCharacter>) theQuestEditCallingControl.getTheObservableNPCs()) {
			npcNames.add(theNPC.GetNpcName());
		}
		questHeraldNPCComboBox.getItems().addAll(npcNames);
		questHeraldNPCComboBox.setValue(theQuestEditCallingControl.GetNpcNameFromListById(theQuestEditCallingControl.getQuestGiverNpcId()));
	}
	
	private void setUpMentorNPCComboBox() throws SQLException {
		ArrayList<String> npcNames = new ArrayList<String>();
		for (NpcCharacter theNPC : (ObservableList<NpcCharacter>) theQuestEditCallingControl.getTheObservableNPCs()) {
			npcNames.add(theNPC.GetNpcName());
		}
		questMentorNPCComboBox.getItems().addAll(npcNames);
		questMentorNPCComboBox.setValue(theQuestEditCallingControl.GetNpcNameFromListById(theQuestEditCallingControl.getQuestReceiverNpcId()));
	}
	
	private void setUpQuestItemComboBox() throws SQLException {
		ArrayList<String> itemNames = new ArrayList<String>();
		for (Item theItem : (ObservableList<Item>) theQuestEditCallingControl.getTheObservableQuestItems()) {
			itemNames.add(theItem.GetItemName());
		}
		addQuestItemComboBox.getItems().addAll(itemNames);
	}
	
	private void setUpRewardItemComboBox() throws SQLException {
		ArrayList<String> itemNames = new ArrayList<String>();
		for (Item theItem : (ObservableList<Item>) theQuestEditCallingControl.getTheObservableRewardItems()) {
			itemNames.add(theItem.GetItemName());
		}
		addRewardItemComboBox.getItems().addAll(itemNames);
	}
	
	private void setupTextElements() throws SQLException {
		editCallingQuestName.setText(theQuestEditCallingControl.getQuestName());
		editCallingQuestDescription.setText(theQuestEditCallingControl.getQuestDescription());
	}

	@FXML
    private void initialize() throws SQLException {
		this.setUpHeraldNPCComboBox();
		this.setUpMentorNPCComboBox();
		this.setupTextElements();
		this.setUpQuestItemComboBox();
		this.setUpRewardItemComboBox();
	}
	
	@FXML 
	private void handleQuestSaveChanges() throws SQLException {
		theQuestEditCallingControl.updateQuestName(editCallingQuestName.getText());
		theQuestEditCallingControl.updateQuestDescription(editCallingQuestDescription.getText());
		theQuestEditCallingControl.updateGiverNPC(theQuestEditCallingControl.GetNpcIdFromListByName(questHeraldNPCComboBox.getValue()));
		theQuestEditCallingControl.updateReceiverNPC(theQuestEditCallingControl.GetNpcIdFromListByName(questMentorNPCComboBox.getValue()));
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
