package com.cs6920.control.view_control;

import java.sql.SQLException;

import com.cs6920.control.logic_control.ManageItemsControl;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import com.cs6920.model.Item;

/**
 * Provides the View Control Logic for the Manage Items View
 * @author Matthew Hodge
 * @version 6.13.2020
 */
public class ManageItemsViewControl {
	@FXML
	private TableView<Item> existingItemTableView;
	@FXML
	private TableColumn<Item, Integer> itemIDTableColumn;
	@FXML
	private TableColumn<Item, Integer> itemTypeTableColumn;
	@FXML
	private TableColumn<Item, String> itemNameTableColumn;
	@FXML
	private TableColumn<Item, String> itemDescriptionTableColumn;
	@FXML
	private TableColumn<Item, Boolean> itemIsImplicitTableColumn;
	@FXML
	private TableColumn<Item, Boolean> itemIsForQuestTableColumn;
	
	private MainDashboardViewControl theMainDashboardViewControl;
	private ManageItemsControl theManageItemsControl;
    
	/**
	 * Constructor for this View Control
	 * @param theMainDashboardViewControl	Reference to the MainDashboard's View Control
	 */
    public ManageItemsViewControl(MainDashboardViewControl theMainDashboardViewControl) {
    	this.theMainDashboardViewControl = theMainDashboardViewControl;
    	this.theMainDashboardViewControl.SetTheManageItemsViewControl(this);
    	this.theManageItemsControl = new ManageItemsControl(theMainDashboardViewControl.GetDBConnection());
    }
    
	/**
	 * Binds the ObservableList to the TableView
	 * @throws SQLException 
	 */
    public void updateExistingItemsList() throws SQLException {
    	theManageItemsControl.UpdateItemArrayList();
    	existingItemTableView.getItems().clear();
    	existingItemTableView.getItems().addAll(theManageItemsControl.GetObservablePlayerList());
    }

	@FXML
    private void initialize() throws SQLException {
		itemIDTableColumn.setCellValueFactory(new PropertyValueFactory<Item, Integer>("itemId"));
		itemTypeTableColumn.setCellValueFactory(new PropertyValueFactory<Item, Integer>("itemType"));
		itemNameTableColumn.setCellValueFactory(new PropertyValueFactory<Item, String>("itemName"));
		itemDescriptionTableColumn.setCellValueFactory(new PropertyValueFactory<Item, String>("itemDescription"));
		itemIsImplicitTableColumn.setCellValueFactory(new PropertyValueFactory<Item, Boolean>("isImplicitItem"));
		itemIsForQuestTableColumn.setCellValueFactory(new PropertyValueFactory<Item, Boolean>("isQuestItem"));
    }
	
	@FXML
	private void handleItemsBackButton() throws SQLException {
		theMainDashboardViewControl.LoadMainDashboardView();
	}
	
	@FXML
	private void handleEditSelectedItemButton() throws SQLException {
		if (existingItemTableView.getSelectionModel().getSelectedItem() != null) {
			theMainDashboardViewControl.SetItemToEdit(existingItemTableView.getSelectionModel().getSelectedItem().GetItemId());
			theMainDashboardViewControl.SetMainDashboardStage("editItems");
		}
		else {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Edit Item Issue");
			alert.setHeaderText("Cannot Edit Item");
			alert.setContentText("An Item to edit was not selected. Please select the item you wish to edit");
			alert.showAndWait();
		}
	}
	
	@FXML
	private void handleCreateItemButton() throws SQLException {
		theMainDashboardViewControl.SetMainDashboardStage("createItems");
	}
}
