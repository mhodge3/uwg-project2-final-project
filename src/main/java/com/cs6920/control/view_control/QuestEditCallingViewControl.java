package com.cs6920.control.view_control;

import java.sql.SQLException;
import java.util.ArrayList;

import com.cs6920.control.logic_control.QuestEditCallingControl;
import com.cs6920.model.Item;
import com.cs6920.model.NpcCharacter;
import com.cs6920.model.Quest;
import com.cs6920.model.QuestItems;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
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
	private TextArea editGiverDialogTextArea;
	@FXML
	private TextArea editReceiverDialogTextArea;
	@FXML
	private ComboBox<String> questHeraldNPCComboBox;
	@FXML
	private ComboBox<String> questMentorNPCComboBox;
	@FXML
	private ComboBox<String> addQuestItemComboBox;
	@FXML
	private ComboBox<String> addRewardItemComboBox;
	@FXML
	private TableView<QuestItems> itemsNeededTableView;
	@FXML
	private TableColumn<QuestItems, String> itemNeededNameTableColumn;
	@FXML
	private TableColumn<QuestItems, Integer> itemNeededQuantityTableColumn;
	@FXML
	private Spinner<Integer> itemsNeededAmountSpinner;
	@FXML
	private TableView<QuestItems> itemsRewardTableView;
	@FXML
	private TableColumn<QuestItems, String> itemRewardNameTableColumn;
	@FXML
	private TableColumn<QuestItems, Integer> itemRewardQuantityTableColumn;
	@FXML
	private Spinner<Integer> itemRewardAmountSpinner;
	
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
		editGiverDialogTextArea.setText(theQuestEditCallingControl.getGiverDialog());
		editReceiverDialogTextArea.setText(theQuestEditCallingControl.getReceiverDialog());
	}
	
	private void setupQuestItemTables() {
		itemNeededNameTableColumn.setCellValueFactory(new PropertyValueFactory<QuestItems, String>("itemDisplayName"));
		itemNeededQuantityTableColumn.setCellValueFactory(new PropertyValueFactory<QuestItems, Integer>("itemQuantity"));
		itemRewardNameTableColumn.setCellValueFactory(new PropertyValueFactory<QuestItems, String>("itemDisplayName"));
		itemRewardQuantityTableColumn.setCellValueFactory(new PropertyValueFactory<QuestItems, Integer>("itemQuantity"));
	}

	@FXML
    private void initialize() throws SQLException {
		this.itemsNeededAmountSpinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 100, 1));
		this.itemRewardAmountSpinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 100, 1));
		this.setUpHeraldNPCComboBox();
		this.setUpMentorNPCComboBox();
		this.setupTextElements();
		this.setUpQuestItemComboBox();
		this.setUpRewardItemComboBox();
		this.setupQuestItemTables();
	}
	
	@FXML 
	private void handleQuestSaveChanges() throws SQLException {
		theQuestEditCallingControl.updateQuestGiverDialog(editGiverDialogTextArea.getText());
		theQuestEditCallingControl.updateQuestReceiverDialog(editReceiverDialogTextArea.getText());
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
    
    @FXML
    private void removeQuestItemNeeded() {
    	try {
    		if (itemsNeededTableView.getSelectionModel().getSelectedItem() != null) {
	    		theQuestEditCallingControl.removeQuestItemNeeded(itemsNeededTableView.getSelectionModel().getSelectedItem().GetItemDisplayName(), itemsNeededTableView.getSelectionModel().getSelectedItem().GetItemQuantity());
				itemsNeededTableView.getItems().clear();
				itemsNeededTableView.getItems().addAll(theQuestEditCallingControl.getObservableQuestItemsNeededList());
				itemsNeededTableView.refresh();
    		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    @FXML
    private void addQuestItemNeeded() {
    	try {
    		if (addQuestItemComboBox.getValue() != null) {
	    		theQuestEditCallingControl.addQuestItemNeeded(addQuestItemComboBox.getValue(), itemsNeededAmountSpinner.getValue());
				itemsNeededTableView.getItems().clear();
				itemsNeededTableView.getItems().addAll(theQuestEditCallingControl.getObservableQuestItemsNeededList());
				itemsNeededTableView.refresh();
    		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    @FXML
    private void removeQuestItemReward() {
    	try {
    		if (itemsRewardTableView.getSelectionModel().getSelectedItem() != null) {
	    		theQuestEditCallingControl.removeQuestItemReward(itemsRewardTableView.getSelectionModel().getSelectedItem().GetItemDisplayName(), itemsRewardTableView.getSelectionModel().getSelectedItem().GetItemQuantity());
	    		itemsRewardTableView.getItems().clear();
	    		itemsRewardTableView.getItems().addAll(theQuestEditCallingControl.getObservableQuestItemsRewardList());
	    		itemsRewardTableView.refresh();
    		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    @FXML
    private void addQuestItemReward() {
    	try {
    		if (addRewardItemComboBox.getValue() != null) {
	    		theQuestEditCallingControl.addQuestItemReward(addRewardItemComboBox.getValue(), itemRewardAmountSpinner.getValue());
				itemsRewardTableView.getItems().clear();
				itemsRewardTableView.getItems().addAll(theQuestEditCallingControl.getObservableQuestItemsRewardList());
				itemsRewardTableView.refresh();
    		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
