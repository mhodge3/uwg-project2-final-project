package com.cs6920.view.manage;

import java.sql.SQLException;

import com.cs6920.control.logic_control.ManageItemsControl;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import com.cs6920.model.Item;
import com.cs6920.view.MainDashboardViewControl;
import com.cs6920.view.ViewControl;

/**
 * Provides the View Control Logic for the Manage Items View
 * @author Matthew Hodge
 * @version 6.13.2020
 */
public class ManageItemsViewControl extends ViewControl {
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
	@FXML
	private TableColumn<Item, Boolean> itemIsTrophyTableColumn;
	
	private MainDashboardViewControl theMainDashboardViewControl;
	private ManageItemsControl theManageItemsControl;
    
	/**
	 * Constructor for this View Control
	 * @param theMainDashboardViewControl	Reference to the MainDashboard's View Control
	 */
    public ManageItemsViewControl(MainDashboardViewControl theMainDashboardViewControl) {
    	this.theMainDashboardViewControl = theMainDashboardViewControl;
    	this.theMainDashboardViewControl.setTheManageItemsViewControl(this);
    	this.theManageItemsControl = new ManageItemsControl(theMainDashboardViewControl.getDBConnection());
    }
    
	/**
	 * Binds the ObservableList to the TableView
	 * @throws SQLException 
	 */
    public void updateExistingItemsList() throws SQLException {
    	this.theManageItemsControl.updateItemArrayList();
    	this.existingItemTableView.getItems().clear();
    	this.existingItemTableView.getItems().addAll(this.theManageItemsControl.getObservablePlayerList());
    }

	@FXML
    private void initialize() throws SQLException {
		this.itemIDTableColumn.setCellValueFactory(new PropertyValueFactory<Item, Integer>("itemId"));
		this.itemTypeTableColumn.setCellValueFactory(new PropertyValueFactory<Item, Integer>("itemType"));
		this.itemNameTableColumn.setCellValueFactory(new PropertyValueFactory<Item, String>("itemName"));
		this.itemDescriptionTableColumn.setCellValueFactory(new PropertyValueFactory<Item, String>("itemDescription"));
		this.itemIsImplicitTableColumn.setCellValueFactory(new PropertyValueFactory<Item, Boolean>("isImplicitItem"));
		this.itemIsForQuestTableColumn.setCellValueFactory(new PropertyValueFactory<Item, Boolean>("isQuestItem"));
		this.itemIsTrophyTableColumn.setCellValueFactory(new PropertyValueFactory<Item, Boolean>("isTrophy"));
    }
	
	@FXML
	private void handleItemsBackButton() throws SQLException {
		this.theMainDashboardViewControl.loadMainDashboardView();
	}
	
	@FXML
	private void handleEditSelectedItemButton() throws SQLException {
		if (this.existingItemTableView.getSelectionModel().getSelectedItem() != null) {
			this.theMainDashboardViewControl.setItemToEdit(this.existingItemTableView.getSelectionModel().getSelectedItem().getItemId());
			this.theMainDashboardViewControl.setMainDashboardStage("editItems");
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
		this.theMainDashboardViewControl.setMainDashboardStage("createItems");
	}
}
