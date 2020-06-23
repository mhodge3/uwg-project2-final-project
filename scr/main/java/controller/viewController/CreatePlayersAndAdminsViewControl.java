package controller.viewController;

import java.sql.SQLException;

import controller.logicController.CreatePlayersAndAdminsControl;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;

/**
 * The View Control for the Create Player and Admins scene.
 * @author Matthew Hodge
 * @version 6.17.2020
 */
public class CreatePlayersAndAdminsViewControl {
	@FXML
	private TextField createPlayerUserNameTextBox;
	@FXML
	private TextField createPlayerPasswordTextBox;
	@FXML
	private TextField createPlayerPasswordConfirmTextBox;
	@FXML
	private TextField createPlayerEmailTextBox;
	@FXML
	private TextField createPlayerUserCountryCodeTextBox;
	@FXML
	private CheckBox createPlayerAsAdminCheckBox;

	private MainDashboardViewControl theMainDashboardViewControl;
	private CreatePlayersAndAdminsControl theCreatePlayersAndAdminsControl;
    
	/**
	 * Constructor for this View Control
	 * @param theMainDashboardViewControl	Reference to the MainDashboard's View Control
	 */
    public CreatePlayersAndAdminsViewControl(MainDashboardViewControl theMainDashboardViewControl) {
    	this.theMainDashboardViewControl = theMainDashboardViewControl;
    	this.theCreatePlayersAndAdminsControl = new CreatePlayersAndAdminsControl(theMainDashboardViewControl.GetDBConnection());
    }
    
    /**
     * Clear Form for next new Entry
     */
    private void ResetCreatePlayerAdminView() {
    	createPlayerUserNameTextBox.setText("");
    	createPlayerPasswordTextBox.setText("");
    	createPlayerPasswordConfirmTextBox.setText("");
    	createPlayerEmailTextBox.setText("");
    	createPlayerUserCountryCodeTextBox.setText("USA");
    	createPlayerAsAdminCheckBox.setSelected(false);
    }
    
	@FXML
	private void handlePlayerAndAdminCreateCanelButton() throws SQLException {
		ResetCreatePlayerAdminView();
		theMainDashboardViewControl.SetMainDashboardStage("managePlayersAndAdmins");
	}
    
	@FXML
	private void handlePlayerAndAdminCreateButton() throws SQLException {
		String userCreationError = theCreatePlayersAndAdminsControl.CreatePlayer(createPlayerUserNameTextBox.getText(), createPlayerPasswordTextBox.getText(), createPlayerPasswordConfirmTextBox.getText(), createPlayerEmailTextBox.getText(), createPlayerUserCountryCodeTextBox.getText(), createPlayerAsAdminCheckBox.isSelected());
		if (userCreationError != null) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error Dialog");
			alert.setHeaderText("Error Creating the new User");
			alert.setContentText(userCreationError);
			alert.showAndWait();
			return;
		}
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("User Account Creation");
		alert.setHeaderText("Account Creation Status");
		alert.setContentText("The User account was successfully created");
		alert.showAndWait();
		ResetCreatePlayerAdminView();
		theMainDashboardViewControl.SetMainDashboardStage("managePlayersAndAdmins");
	}
}
