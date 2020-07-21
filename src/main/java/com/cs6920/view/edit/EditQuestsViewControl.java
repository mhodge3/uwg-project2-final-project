package com.cs6920.view.edit;

import java.sql.SQLException;
import java.util.ArrayList;

import com.cs6920.DAL.MySQLAccess;
import com.cs6920.control.logic_control.EditQuestControl;
import com.cs6920.model.Item;
import com.cs6920.model.NpcCharacter;
import com.cs6920.model.QuestItems;
import com.cs6920.view.ViewControl;

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

public class EditQuestsViewControl extends ViewControl {
	@FXML 
	private Button questEditBackButton;
	@FXML
	private TextField editQuestName;
	@FXML
	private TextArea editQuestDescription;
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
	
	EditQuestControl theEditQuestControl;
	
	public EditQuestsViewControl(EditConflictQuestsViewControl theManageTemplateTheQuestViewControl, MySQLAccess theDBConnection, int questIdToEdit, String questArcRole) throws SQLException {
		theEditQuestControl = new EditQuestControl(theManageTemplateTheQuestViewControl, theDBConnection, questIdToEdit, questArcRole);
	}
	
	private void setUpHeraldNPCComboBox() throws SQLException {
		ArrayList<String> npcNames = new ArrayList<String>();
		for (NpcCharacter theNPC : (ObservableList<NpcCharacter>) theEditQuestControl.getTheObservableNPCs()) {
			npcNames.add(theNPC.getNpcName());
		}
		questHeraldNPCComboBox.getItems().addAll(npcNames);
		questHeraldNPCComboBox.setValue(theEditQuestControl.getNpcNameFromListById(theEditQuestControl.getQuestGiverNpcId()));
	}
	
	private void setUpMentorNPCComboBox() throws SQLException {
		ArrayList<String> npcNames = new ArrayList<String>();
		for (NpcCharacter theNPC : (ObservableList<NpcCharacter>) theEditQuestControl.getTheObservableNPCs()) {
			npcNames.add(theNPC.getNpcName());
		}
		questMentorNPCComboBox.getItems().addAll(npcNames);
		questMentorNPCComboBox.setValue(theEditQuestControl.getNpcNameFromListById(theEditQuestControl.getQuestReceiverNpcId()));
	}
	
	private void setUpQuestItemComboBox() throws SQLException {
		ArrayList<String> itemNames = new ArrayList<String>();
		for (Item theItem : (ObservableList<Item>) theEditQuestControl.getTheObservableQuestItems()) {
			itemNames.add(theItem.getItemName());
		}
		addQuestItemComboBox.getItems().addAll(itemNames);
	}
	
	private void setUpRewardItemComboBox() throws SQLException {
		ArrayList<String> itemNames = new ArrayList<String>();
		for (Item theItem : (ObservableList<Item>) theEditQuestControl.getTheObservableRewardItems()) {
			itemNames.add(theItem.getItemName());
		}
		addRewardItemComboBox.getItems().addAll(itemNames);
	}
	
	private void setupTextElements() throws SQLException {
		editQuestName.setText(theEditQuestControl.getQuestName());
		editQuestDescription.setText(theEditQuestControl.getQuestDescription());
		editGiverDialogTextArea.setText(theEditQuestControl.getGiverDialog());
		editReceiverDialogTextArea.setText(theEditQuestControl.getReceiverDialog());
	}
	
	private void setupQuestItemTables() {
		itemNeededNameTableColumn.setCellValueFactory(new PropertyValueFactory<QuestItems, String>("itemDisplayName"));
		itemNeededQuantityTableColumn.setCellValueFactory(new PropertyValueFactory<QuestItems, Integer>("itemQuantity"));
		itemRewardNameTableColumn.setCellValueFactory(new PropertyValueFactory<QuestItems, String>("itemDisplayName"));
		itemRewardQuantityTableColumn.setCellValueFactory(new PropertyValueFactory<QuestItems, Integer>("itemQuantity"));
		itemsNeededTableView.getItems().clear();
		itemsNeededTableView.getItems().addAll(theEditQuestControl.getObservableQuestItemsNeededList());
		itemsNeededTableView.refresh();
		itemsRewardTableView.getItems().clear();
		itemsRewardTableView.getItems().addAll(theEditQuestControl.getObservableQuestItemsRewardList());
		itemsRewardTableView.refresh();
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
		theEditQuestControl.updateQuestGiverDialog(editGiverDialogTextArea.getText());
		theEditQuestControl.updateQuestReceiverDialog(editReceiverDialogTextArea.getText());
		theEditQuestControl.updateQuestName(editQuestName.getText());
		theEditQuestControl.updateQuestDescription(editQuestDescription.getText());
		theEditQuestControl.updateGiverNPC(theEditQuestControl.getNpcIdFromListByName(questHeraldNPCComboBox.getValue()));
		theEditQuestControl.updateReceiverNPC(theEditQuestControl.getNpcIdFromListByName(questMentorNPCComboBox.getValue()));
		theEditQuestControl.refreshQuestDisplay();
		theEditQuestControl.getConflictTemplateTheQuestViewControl().refreshTheQuestList();
		theEditQuestControl.updateQuestItemsInDB();
		this.handleBackButton();
	}
    
	@FXML
	private void handleBackButton() throws SQLException {
	    Stage stage = (Stage) questEditBackButton.getScene().getWindow();
	    stage.close();
	}
    
    @FXML
    private void removeQuestItemNeeded() {
    	try {
    		if (itemsNeededTableView.getSelectionModel().getSelectedItem() != null) {
    			theEditQuestControl.removeQuestItemNeeded(itemsNeededTableView.getSelectionModel().getSelectedItem().getItemDisplayName(), itemsNeededTableView.getSelectionModel().getSelectedItem().getItemQuantity());
				itemsNeededTableView.getItems().clear();
				itemsNeededTableView.getItems().addAll(theEditQuestControl.getObservableQuestItemsNeededList());
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
    			theEditQuestControl.addQuestItemNeeded(addQuestItemComboBox.getValue(), itemsNeededAmountSpinner.getValue());
				itemsNeededTableView.getItems().clear();
				itemsNeededTableView.getItems().addAll(theEditQuestControl.getObservableQuestItemsNeededList());
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
    			theEditQuestControl.removeQuestItemReward(itemsRewardTableView.getSelectionModel().getSelectedItem().getItemDisplayName(), itemsRewardTableView.getSelectionModel().getSelectedItem().getItemQuantity());
	    		itemsRewardTableView.getItems().clear();
	    		itemsRewardTableView.getItems().addAll(theEditQuestControl.getObservableQuestItemsRewardList());
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
    			theEditQuestControl.addQuestItemReward(addRewardItemComboBox.getValue(), itemRewardAmountSpinner.getValue());
				itemsRewardTableView.getItems().clear();
				itemsRewardTableView.getItems().addAll(theEditQuestControl.getObservableQuestItemsRewardList());
				itemsRewardTableView.refresh();
    		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
