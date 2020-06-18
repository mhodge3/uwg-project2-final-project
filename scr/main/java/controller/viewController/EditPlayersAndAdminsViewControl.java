package controller.viewController;

import java.sql.SQLException;

import controller.logicController.EditPlayersAndAdminsControl;
import controller.logicController.ManagePlayersAndAdminsControl;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import model.Player;

/**
 * The View Control for the Edit Players and Admins scene
 * @author Matthew Hodge
 * @version 6.17.2020
 */
public class EditPlayersAndAdminsViewControl {
	@FXML
	private TextField editPlayerUserNameTextBox;
	@FXML
	private TextField editPlayerPasswordTextBox;
	@FXML
	private TextField editPlayerPasswordConfirmTextBox;
	@FXML
	private TextField editPlayerEmailTextBox;
	@FXML
	private TextField editPlayerUserCountryCodeTextBox;
	@FXML
	private CheckBox editPlayerAsAdminCheckBox;

	private MainDashboardViewControl theMainDashboardViewControl;
	private EditPlayersAndAdminsControl theEditPlayersAndAdminsControl;
    
	/**
	 * Constructor for this View Control
	 * @param theMainDashboardViewControl	Reference to the MainDashboard's View Control
	 */
    public EditPlayersAndAdminsViewControl(MainDashboardViewControl theMainDashboardViewControl) {
    	this.theMainDashboardViewControl = theMainDashboardViewControl;
    	this.theEditPlayersAndAdminsControl = new EditPlayersAndAdminsControl(theMainDashboardViewControl.GetDBConnection());
    }
    
    public EditPlayersAndAdminsControl GetEditPlayersAndAdminsControl() {
    	return theEditPlayersAndAdminsControl;
    }
    
    public void SetFormForSelectedPlayer(Player thePlayerToEdit) {
    	editPlayerUserNameTextBox.setText(thePlayerToEdit.GetPlayerName());
    	editPlayerPasswordTextBox.setText(thePlayerToEdit.GetPlayerPassword());
    	editPlayerPasswordConfirmTextBox.setText(thePlayerToEdit.GetPlayerPassword());
    	editPlayerEmailTextBox.setText(thePlayerToEdit.GetPlayerEmail());
    	editPlayerUserCountryCodeTextBox.setText(thePlayerToEdit.GetPlayerCountryCode());
    	editPlayerAsAdminCheckBox.setSelected(thePlayerToEdit.GetPlayerIsAdmin());
    }
    
	@FXML
	private void handlePlayerAndAdminEditBackButton() throws SQLException {
		theMainDashboardViewControl.SetMainDashboardStage("managePlayersAndAdmins");
	}
}
