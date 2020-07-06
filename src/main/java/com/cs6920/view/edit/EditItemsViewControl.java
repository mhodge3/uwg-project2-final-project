package com.cs6920.view.edit;

import java.sql.SQLException;

import com.cs6920.control.logic_control.EditItemsControl;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.CheckBox;
import com.cs6920.model.Item;
import com.cs6920.view.MainDashboardViewControl;
/**
 * Communicates between the Create EditItems fxml view and the logic control
 * @author Matthew Hodge
 * @version 6.23.2020
 */
public class EditItemsViewControl {
	@FXML
	private TextField editItemTypeTextBox;
	@FXML
	private TextField editItemNameTextBox;
	@FXML
	private TextArea editItemDescriptionTextArea;
	@FXML
	private CheckBox editIsItemForQuestCheckBox;
	@FXML
	private CheckBox editIsItemImplicitCheckBox;
	@FXML
	private CheckBox editIsItemTrophyCheckBox;

	private MainDashboardViewControl theMainDashboardViewControl;
	private EditItemsControl theEditItemsControl;
    
	/**
	 * Constructor for this View Control
	 * @param theMainDashboardViewControl	Reference to the MainDashboard's View Control
	 */
    public EditItemsViewControl(MainDashboardViewControl theMainDashboardViewControl) {
    	this.theMainDashboardViewControl = theMainDashboardViewControl;
    	this.theEditItemsControl = new EditItemsControl(theMainDashboardViewControl.GetDBConnection());
    }
    
    /**
     * Gets logic control for this Edit Item view control
     * @return the Item edited
     */
    public EditItemsControl GetEditItemsControl() {
    	return theEditItemsControl;
    }
    
    /**
     * Sets the form values to those of the Item to edit
     * @param theItemToEdit
     */
    public void SetFormForSelectedItem(Item theItemToEdit) {
    	editItemTypeTextBox.setText(String.valueOf(theItemToEdit.GetItemType()));
    	editItemNameTextBox.setText(theItemToEdit.GetItemName());
    	editItemDescriptionTextArea.setText(theItemToEdit.GetItemDescription());
    	editIsItemForQuestCheckBox.setSelected(theItemToEdit.GetIsQuestItem());
    	editIsItemImplicitCheckBox.setSelected(theItemToEdit.GetIsImplicitItem());
    	editIsItemImplicitCheckBox.setSelected(theItemToEdit.getIstrophy());
    }
    
	@FXML
	private void handleItemEditBackButton() throws SQLException {
		theMainDashboardViewControl.SetMainDashboardStage("manageItems");
	}
    
	@FXML
	private void handleItemDeleteButton() throws SQLException {
		String itemDeleteError = null;
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Item Edit");
		alert.setHeaderText("Item Edit Status");
		alert.setContentText("Are you sure you want to DELETE " + theEditItemsControl.GetSelectedItem().GetItemName() + "? This operation cannot be undone.");
		alert.showAndWait();
		if (alert.getResult() == ButtonType.OK) {
			try {
				itemDeleteError = theEditItemsControl.DeleteItem(theEditItemsControl.GetSelectedItem());
			} catch (Exception e) {
				itemDeleteError = e.getMessage();
			}
			if (itemDeleteError != null) {
				alert = new Alert(AlertType.ERROR);
				alert.setTitle("Error Dialog");
				alert.setHeaderText("Error Editing the Item");
				alert.setContentText(itemDeleteError);
				alert.showAndWait();
				return;
			}
			alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Item Edit");
			alert.setHeaderText("Item Edit Status");
			alert.setContentText("The Item was successfully deleted");
			alert.showAndWait();
			theMainDashboardViewControl.SetMainDashboardStage("manageItems");
		}
	}
    
	@FXML
	private void handleItemEditSaveButton() throws SQLException {
		String itemCreationError = null;
		try {
			itemCreationError = theEditItemsControl.UpdateItem(editItemNameTextBox.getText(), editItemDescriptionTextArea.getText(), Integer.parseInt(editItemTypeTextBox.getText()), editIsItemForQuestCheckBox.isSelected(), editIsItemImplicitCheckBox.isSelected(), editIsItemTrophyCheckBox.isSelected());
		} catch (Exception e) {
			itemCreationError = e.getMessage();
		}
		if (itemCreationError != null) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error Dialog");
			alert.setHeaderText("Error Editing the Item");
			alert.setContentText(itemCreationError);
			alert.showAndWait();
			return;
		}
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Item Edit");
		alert.setHeaderText("Item Edit Status");
		alert.setContentText("The Item was successfully modified");
		alert.showAndWait();
		theMainDashboardViewControl.SetMainDashboardStage("manageItems");
	}
}
