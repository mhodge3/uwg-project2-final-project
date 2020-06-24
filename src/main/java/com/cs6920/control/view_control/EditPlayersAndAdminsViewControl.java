package com.cs6920.control.view_control;

import java.sql.SQLException;

import com.cs6920.control.logic_control.EditPlayersAndAdminsControl;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import com.cs6920.model.Player;

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
    
    private Boolean isPlayerToDeleteCurrentAdmin() {
		if (this.theMainDashboardViewControl.GetTheAdminPlayer().GetPlayerId() == theEditPlayersAndAdminsControl.GetSelectedPlayer().GetPlayerId()) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error Dialog");
			alert.setHeaderText("User to Delete Cannot Be Current Admin Account");
			alert.setContentText("The current Admin's account may only be modified by a different Admin");
			alert.showAndWait();
			return true;
		}
		return false;
    }
    
	@FXML
	private void handlePlayersAndAdminsDeleteButton() throws SQLException {
		if (isPlayerToDeleteCurrentAdmin()) {
			return;
		}
		String userDeleteError = null;
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("User Edit");
		alert.setHeaderText("User Edit Status");
		alert.setContentText("Are you sure you want to DELETE user: " + theEditPlayersAndAdminsControl.GetSelectedPlayer().GetPlayerName() + "? This operation cannot be undone.");
		alert.showAndWait();
		if (alert.getResult() == ButtonType.OK) {
			try {
				userDeleteError = theEditPlayersAndAdminsControl.DeletePlayer(theEditPlayersAndAdminsControl.GetSelectedPlayer());
			} catch (Exception e) {
				userDeleteError = e.getMessage();
			}
			if (userDeleteError != null) {
				alert = new Alert(AlertType.ERROR);
				alert.setTitle("Error Dialog");
				alert.setHeaderText("Error Editing the User");
				alert.setContentText(userDeleteError);
				alert.showAndWait();
				return;
			}
			alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("User Edit");
			alert.setHeaderText("User Edit Status");
			alert.setContentText("The User was successfully deleted");
			alert.showAndWait();
			theMainDashboardViewControl.SetMainDashboardStage("managePlayersAndAdmins");
		}
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
    
	@FXML
	private void handlePlayerAndAdminEditSaveButton() throws SQLException {
		String userCreationError = theEditPlayersAndAdminsControl.UpdatePlayer(editPlayerUserNameTextBox.getText(), editPlayerPasswordTextBox.getText(), editPlayerPasswordConfirmTextBox.getText(), editPlayerEmailTextBox.getText(), editPlayerUserCountryCodeTextBox.getText(), editPlayerAsAdminCheckBox.isSelected());
		if (userCreationError != null) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error Dialog");
			alert.setHeaderText("Error Editing the User");
			alert.setContentText(userCreationError);
			alert.showAndWait();
			return;
		}
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("User Account Edit");
		alert.setHeaderText("Account Edit Status");
		alert.setContentText("The User account was successfully modified");
		alert.showAndWait();
		theMainDashboardViewControl.SetMainDashboardStage("managePlayersAndAdmins");
	}
}
