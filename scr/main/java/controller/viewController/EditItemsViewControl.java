package controller.viewController;

import java.sql.SQLException;

import controller.logicController.EditItemsControl;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.CheckBox;
import model.Item;

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
    
    public EditItemsControl GetEditItemsControl() {
    	return theEditItemsControl;
    }
    
    public void SetFormForSelectedItem(Item theItemToEdit) {
    	editItemTypeTextBox.setText(String.valueOf(theItemToEdit.GetItemType()));
    	editItemNameTextBox.setText(theItemToEdit.GetItemName());
    	editItemDescriptionTextArea.setText(theItemToEdit.GetItemDescription());
    	editIsItemForQuestCheckBox.setSelected(theItemToEdit.GetIsQuestItem());
    	editIsItemImplicitCheckBox.setSelected(theItemToEdit.GetIsImplicitItem());
    }
    
	@FXML
	private void handleItemEditBackButton() throws SQLException {
		theMainDashboardViewControl.SetMainDashboardStage("manageItems");
	}
    
	@FXML
	private void handleItemEditSaveButton() throws SQLException {
		String itemCreationError = null;
		try {
			itemCreationError = theEditItemsControl.UpdateItem(editItemNameTextBox.getText(), editItemDescriptionTextArea.getText(), Integer.parseInt(editItemTypeTextBox.getText()), editIsItemForQuestCheckBox.isSelected(), editIsItemImplicitCheckBox.isSelected());
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
		alert.setHeaderText("ItemC Edit Status");
		alert.setContentText("The Item was successfully modified");
		alert.showAndWait();
		theMainDashboardViewControl.SetMainDashboardStage("manageItems");
	}
}
