package controller.viewController;

import java.sql.SQLException;

import controller.logicController.CreatePlayersAndAdminsControl;
import controller.logicController.ManagePlayersAndAdminsControl;
import javafx.fxml.FXML;
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
    
	@FXML
	private void handlePlayerAndAdminCreateCanelButton() {
		theMainDashboardViewControl.SetMainDashboardStage("managePlayersAndAdmins");
	}
    
	@FXML
	private void handlePlayerAndAdminCreateButton() throws SQLException {
		String userCreationError = theCreatePlayersAndAdminsControl.CreatePlayer(createPlayerUserNameTextBox.getText(), createPlayerPasswordTextBox.getText(), createPlayerPasswordConfirmTextBox.getText(), createPlayerEmailTextBox.getText(), createPlayerUserCountryCodeTextBox.getText());
		if (!userCreationError.isEmpty()) {
			return;
		}
		if (createPlayerAsAdminCheckBox.isSelected()) {
			userCreationError = null;
		}
		if (userCreationError != null) {
			theMainDashboardViewControl.SetMainDashboardStage("managePlayersAndAdmins");
		}
	}
}
