package controller.viewController;

import java.sql.SQLException;

import controller.logicController.CreateItemsControl;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class CreateItemsViewControl {
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

	private MainDashboardViewControl theMainDashboardViewControl;
	private CreateItemsControl theCreateItemsControl;
    
	/**
	 * Constructor for this View Control
	 * @param theMainDashboardViewControl	Reference to the MainDashboard's View Control
	 */
    public CreateItemsViewControl(MainDashboardViewControl theMainDashboardViewControl) {
    	this.theMainDashboardViewControl = theMainDashboardViewControl;
    	this.theCreateItemsControl = new CreateItemsControl(theMainDashboardViewControl.GetDBConnection());
    }
    
    /**
     * Clear Form for next new Entry
     */
    private void ResetCreateItemsView() {
    	createItemTypeTextBox.setText("");
    	createItemNameTextBox.setText("");
    	createItemDescriptionTextArea.setText("");
    	createIsItemForQuestCheckBox.setSelected(false);
    	createIsItemImplicitCheckBox.setSelected(false);
    }
    
	@FXML
	private void handleItemCanelButton() throws SQLException {
		ResetCreateItemsView();
		theMainDashboardViewControl.SetMainDashboardStage("manageItems");
	}
    
	@FXML
	private void handleItemCreateButton() throws SQLException {
		String itemCreationError = null;
		try {
			itemCreationError = theCreateItemsControl.CreateItem(createItemNameTextBox.getText(), createItemDescriptionTextArea.getText(), Integer.parseInt(createItemTypeTextBox.getText()), createIsItemForQuestCheckBox.isSelected(), createIsItemImplicitCheckBox.isSelected());
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
		ResetCreateItemsView();
		theMainDashboardViewControl.SetMainDashboardStage("manageItems");
	}
}
