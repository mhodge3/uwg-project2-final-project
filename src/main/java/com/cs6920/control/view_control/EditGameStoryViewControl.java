/**
 * 
 */
package com.cs6920.control.view_control;

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

/**
 * @author Ashley Palmer
 * @date 6/27/2020
 *
 */
public class EditGameStoryViewControl {
	
	@FXML
	private TextField editGameStoryNameTextBox;
	@FXML
	private TextArea editGameStorySummaryTextArea;;
	@FXML
	private CheckBox editIsItemForQuestCheckBox;
	@FXML
	private CheckBox editIsItemImplicitCheckBox;

	private MainDashboardViewControl theMainDashboardViewControl;
	private EditItemsControl theEditItemsControl;
	
	/**
	 * Constructor for this View Control
	 * @param theMainDashboardViewControl	Reference to the MainDashboard's View Control
	 */
    public EditGameStoryViewControl(MainDashboardViewControl theMainDashboardViewControl) {
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
    	editGameStoryNameTextBox.setText(String.valueOf(theItemToEdit.GetItemType()));
    	editGameStorySummaryTextArea.setText(theItemToEdit.GetItemDescription());
    	editIsItemForQuestCheckBox.setSelected(theItemToEdit.GetIsQuestItem());
    	editIsItemImplicitCheckBox.setSelected(theItemToEdit.GetIsImplicitItem());
    }
    
	@FXML
	private void handleItemEditBackButton() throws SQLException {
		theMainDashboardViewControl.SetMainDashboardStage("manageItems");
	}
    
	@FXML
	private void handleItemDeleteButton() throws SQLException {
		String itemDeleteError = null;
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Game Story Edit");
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
				alert.setHeaderText("Error Editing the Game Story");
				alert.setContentText(itemDeleteError);
				alert.showAndWait();
				return;
			}
			alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Game Story Edit");
			alert.setHeaderText("Game Story Edit Status");
			alert.setContentText("The Game Story was successfully deleted");
			alert.showAndWait();
			theMainDashboardViewControl.SetMainDashboardStage("manageItems");
		}
	}
    
	@FXML
	private void handleItemEditSaveButton() throws SQLException {
		String itemCreationError = null;
		try {
			itemCreationError = theEditItemsControl.UpdateItem(editGameStorySummaryTextArea.getText(), Integer.parseInt(editGameStoryNameTextBox.getText()), editIsItemForQuestCheckBox.isSelected(), editIsItemImplicitCheckBox.isSelected());
		} catch (Exception e) {
			itemCreationError = e.getMessage();
		}
		if (itemCreationError != null) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error Dialog");
			alert.setHeaderText("Error Editing the Game Story");
			alert.setContentText(itemCreationError);
			alert.showAndWait();
			return;
		}
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Game Story Edit");
		alert.setHeaderText("Game Story Edit Status");
		alert.setContentText("The Game Story was successfully modified");
		alert.showAndWait();
		theMainDashboardViewControl.SetMainDashboardStage("manageItems");
	}

}
