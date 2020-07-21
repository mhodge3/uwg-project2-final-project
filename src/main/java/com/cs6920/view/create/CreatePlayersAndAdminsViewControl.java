package com.cs6920.view.create;

import java.sql.SQLException;

import com.cs6920.control.logic_control.CreatePlayersAndAdminsControl;
import com.cs6920.view.MainDashboardViewControl;
import com.cs6920.view.ViewControl;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;

/**
 * Communicates between the Create PlayersAndAdmins fxml view and the logic control
 * @author Matthew Hodge
 * @version 6.23.2020
 */
public class CreatePlayersAndAdminsViewControl extends ViewControl {
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
    	this.theCreatePlayersAndAdminsControl = new CreatePlayersAndAdminsControl(theMainDashboardViewControl.getDBConnection());
    }
    
    private void resetCreatePlayerAdminView() {
    	this.createPlayerUserNameTextBox.setText("");
    	this.createPlayerPasswordTextBox.setText("");
    	this.createPlayerPasswordConfirmTextBox.setText("");
    	this.createPlayerEmailTextBox.setText("");
    	this.createPlayerUserCountryCodeTextBox.setText("USA");
    	this.createPlayerAsAdminCheckBox.setSelected(false);
    }
    
	@FXML
	private void handlePlayerAndAdminCreateCanelButton() throws SQLException {
		this.resetCreatePlayerAdminView();
		this.theMainDashboardViewControl.setMainDashboardStage("managePlayersAndAdmins");
	}
    
	@FXML
	private void handlePlayerAndAdminCreateButton() throws SQLException {
		String userCreationError = this.theCreatePlayersAndAdminsControl.createPlayer(this.createPlayerUserNameTextBox.getText(), this.createPlayerPasswordTextBox.getText(), this.createPlayerPasswordConfirmTextBox.getText(), this.createPlayerEmailTextBox.getText(), this.createPlayerUserCountryCodeTextBox.getText(), this.createPlayerAsAdminCheckBox.isSelected());
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
		this.resetCreatePlayerAdminView();
		this.theMainDashboardViewControl.setMainDashboardStage("managePlayersAndAdmins");
	}
}
