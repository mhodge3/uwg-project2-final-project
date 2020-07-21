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
		this.theEditQuestControl = new EditQuestControl(theManageTemplateTheQuestViewControl, theDBConnection, questIdToEdit, questArcRole);
	}
	
	private void setUpHeraldNPCComboBox() throws SQLException {
		ArrayList<String> npcNames = new ArrayList<String>();
		for (NpcCharacter theNPC : (ObservableList<NpcCharacter>) this.theEditQuestControl.getTheObservableNPCs()) {
			npcNames.add(theNPC.getNpcName());
		}
		this.questHeraldNPCComboBox.getItems().addAll(npcNames);
		this.questHeraldNPCComboBox.setValue(this.theEditQuestControl.getNpcNameFromListById(this.theEditQuestControl.getQuestGiverNpcId()));
	}
	
	private void setUpMentorNPCComboBox() throws SQLException {
		ArrayList<String> npcNames = new ArrayList<String>();
		for (NpcCharacter theNPC : (ObservableList<NpcCharacter>) this.theEditQuestControl.getTheObservableNPCs()) {
			npcNames.add(theNPC.getNpcName());
		}
		this.questMentorNPCComboBox.getItems().addAll(npcNames);
		this.questMentorNPCComboBox.setValue(this.theEditQuestControl.getNpcNameFromListById(this.theEditQuestControl.getQuestReceiverNpcId()));
	}
	
	private void setUpQuestItemComboBox() throws SQLException {
		ArrayList<String> itemNames = new ArrayList<String>();
		for (Item theItem : (ObservableList<Item>) this.theEditQuestControl.getTheObservableQuestItems()) {
			itemNames.add(theItem.getItemName());
		}
		this.addQuestItemComboBox.getItems().addAll(itemNames);
	}
	
	private void setUpRewardItemComboBox() throws SQLException {
		ArrayList<String> itemNames = new ArrayList<String>();
		for (Item theItem : (ObservableList<Item>) this.theEditQuestControl.getTheObservableRewardItems()) {
			itemNames.add(theItem.getItemName());
		}
		this.addRewardItemComboBox.getItems().addAll(itemNames);
	}
	
	private void setupTextElements() throws SQLException {
		this.editQuestName.setText(this.theEditQuestControl.getQuestName());
		this.editQuestDescription.setText(this.theEditQuestControl.getQuestDescription());
		this.editGiverDialogTextArea.setText(this.theEditQuestControl.getGiverDialog());
		this.editReceiverDialogTextArea.setText(this.theEditQuestControl.getReceiverDialog());
	}
	
	private void setupQuestItemTables() {
		this.itemNeededNameTableColumn.setCellValueFactory(new PropertyValueFactory<QuestItems, String>("itemDisplayName"));
		this.itemNeededQuantityTableColumn.setCellValueFactory(new PropertyValueFactory<QuestItems, Integer>("itemQuantity"));
		this.itemRewardNameTableColumn.setCellValueFactory(new PropertyValueFactory<QuestItems, String>("itemDisplayName"));
		this.itemRewardQuantityTableColumn.setCellValueFactory(new PropertyValueFactory<QuestItems, Integer>("itemQuantity"));
		this.itemsNeededTableView.getItems().clear();
		this.itemsNeededTableView.getItems().addAll(this.theEditQuestControl.getObservableQuestItemsNeededList());
		this.itemsNeededTableView.refresh();
		this.itemsRewardTableView.getItems().clear();
		this.itemsRewardTableView.getItems().addAll(this.theEditQuestControl.getObservableQuestItemsRewardList());
		this.itemsRewardTableView.refresh();
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
		this.theEditQuestControl.updateQuestGiverDialog(this.editGiverDialogTextArea.getText());
		this.theEditQuestControl.updateQuestReceiverDialog(this.editReceiverDialogTextArea.getText());
		this.theEditQuestControl.updateQuestName(this.editQuestName.getText());
		this.theEditQuestControl.updateQuestDescription(this.editQuestDescription.getText());
		this.theEditQuestControl.updateGiverNPC(this.theEditQuestControl.getNpcIdFromListByName(this.questHeraldNPCComboBox.getValue()));
		this.theEditQuestControl.updateReceiverNPC(this.theEditQuestControl.getNpcIdFromListByName(this.questMentorNPCComboBox.getValue()));
		this.theEditQuestControl.refreshQuestDisplay();
		this.theEditQuestControl.getConflictTemplateTheQuestViewControl().refreshTheQuestList();
		this.theEditQuestControl.updateQuestItemsInDB();
		this.handleBackButton();
	}
    
	@FXML
	private void handleBackButton() throws SQLException {
	    Stage stage = (Stage) this.questEditBackButton.getScene().getWindow();
	    stage.close();
	}
    
    @FXML
    private void removeQuestItemNeeded() {
    	try {
    		if (this.itemsNeededTableView.getSelectionModel().getSelectedItem() != null) {
    			this.theEditQuestControl.removeQuestItemNeeded(this.itemsNeededTableView.getSelectionModel().getSelectedItem().getItemDisplayName(), this.itemsNeededTableView.getSelectionModel().getSelectedItem().getItemQuantity());
    			this.itemsNeededTableView.getItems().clear();
    			this.itemsNeededTableView.getItems().addAll(this.theEditQuestControl.getObservableQuestItemsNeededList());
    			this.itemsNeededTableView.refresh();
    		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    @FXML
    private void addQuestItemNeeded() {
    	try {
    		if (this.addQuestItemComboBox.getValue() != null) {
    			this.theEditQuestControl.addQuestItemNeeded(this.addQuestItemComboBox.getValue(), this.itemsNeededAmountSpinner.getValue());
    			this.itemsNeededTableView.getItems().clear();
    			this.itemsNeededTableView.getItems().addAll(this.theEditQuestControl.getObservableQuestItemsNeededList());
    			this.itemsNeededTableView.refresh();
    		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    @FXML
    private void removeQuestItemReward() {
    	try {
    		if (this.itemsRewardTableView.getSelectionModel().getSelectedItem() != null) {
    			this.theEditQuestControl.removeQuestItemReward(this.itemsRewardTableView.getSelectionModel().getSelectedItem().getItemDisplayName(), this.itemsRewardTableView.getSelectionModel().getSelectedItem().getItemQuantity());
    			this.itemsRewardTableView.getItems().clear();
    			this.itemsRewardTableView.getItems().addAll(this.theEditQuestControl.getObservableQuestItemsRewardList());
    			this.itemsRewardTableView.refresh();
    		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    @FXML
    private void addQuestItemReward() {
    	try {
    		if (this.addRewardItemComboBox.getValue() != null) {
    			this.theEditQuestControl.addQuestItemReward(this.addRewardItemComboBox.getValue(), this.itemRewardAmountSpinner.getValue());
    			this.itemsRewardTableView.getItems().clear();
    			this.itemsRewardTableView.getItems().addAll(this.theEditQuestControl.getObservableQuestItemsRewardList());
    			this.itemsRewardTableView.refresh();
    		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
