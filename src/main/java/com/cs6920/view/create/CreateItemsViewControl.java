package com.cs6920.view.create;

import java.sql.SQLException;

import com.cs6920.control.logic_control.CreateItemsControl;
import com.cs6920.view.MainDashboardViewControl;
import com.cs6920.view.ViewControl;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

/**
 * Communicates between the Create Items fxml view and the logic control
 * @author Matthew Hodge
 * @version 6.23.2020
 */
public class CreateItemsViewControl extends ViewControl {
	@FXML
	private TextField createItemTypeTextBox;
	@FXML
	private TextField createItemNameTextBox;
	@FXML
	private TextArea createItemDescriptionTextArea;
	@FXML
	private CheckBox createIsItemForQuestCheckBox;
	@FXML
	private CheckBox createIsItemImplicitCheckBox;
	@FXML 
	private CheckBox createIsItemTrophyCheckBox;

	private MainDashboardViewControl theMainDashboardViewControl;
	private CreateItemsControl theCreateItemsControl;
    
	/**
	 * Constructor for this View Control
	 * @param theMainDashboardViewControl	Reference to the MainDashboard's View Control
	 */
    public CreateItemsViewControl(MainDashboardViewControl theMainDashboardViewControl) {
    	this.theMainDashboardViewControl = theMainDashboardViewControl;
    	this.theCreateItemsControl = new CreateItemsControl(theMainDashboardViewControl.getDBConnection());
    }
    
    
    private void resetCreateItemsView() {
    	this.createItemTypeTextBox.setText("");
    	this.createItemNameTextBox.setText("");
    	this.createItemDescriptionTextArea.setText("");
    	this.createIsItemForQuestCheckBox.setSelected(false);
    	this.createIsItemImplicitCheckBox.setSelected(false);
    }
    
	@FXML
	private void handleItemCanelButton() throws SQLException {
		this.resetCreateItemsView();
		this.theMainDashboardViewControl.setMainDashboardStage("manageItems");
	}
    
	@FXML
	private void handleItemCreateButton() throws SQLException {
		String itemCreationError = null;
		try {
			itemCreationError = this.theCreateItemsControl.createItem(this.createItemNameTextBox.getText(), this.createItemDescriptionTextArea.getText(), Integer.parseInt(this.createItemTypeTextBox.getText()), this.createIsItemForQuestCheckBox.isSelected(), this.createIsItemImplicitCheckBox.isSelected(), this.createIsItemTrophyCheckBox.isSelected());
		} catch (Exception e) {
			itemCreationError = e.getMessage();
		}
		if (itemCreationError != null) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error Dialog");
			alert.setHeaderText("Error Creating the new Item");
			alert.setContentText(itemCreationError);
			alert.showAndWait();
			return;
		}
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Item Creation");
		alert.setHeaderText("Item Creation Status");
		alert.setContentText("The Item was successfully created");
		alert.showAndWait();
		this.resetCreateItemsView();
		this.theMainDashboardViewControl.setMainDashboardStage("manageItems");
	}
}
