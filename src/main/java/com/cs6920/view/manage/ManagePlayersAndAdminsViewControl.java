package com.cs6920.view.manage;

import java.sql.SQLException;

import com.cs6920.control.logic_control.ManagePlayersAndAdminsControl;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import com.cs6920.model.Player;
import com.cs6920.view.MainDashboardViewControl;
import com.cs6920.view.ViewControl;

/**
 * Provides the View Control Logic for the Manage Players and Admin View
 * @author Matthew Hodge
 * @version 6.13.2020
 */
public class ManagePlayersAndAdminsViewControl extends ViewControl {
	@FXML
	private TableView<Player> existingUserTableView;
	@FXML
	private TableColumn<Player, Integer> userIDTableColumn;
	@FXML
	private TableColumn<Player, Boolean> userIsAdminTableColumn;
	@FXML
	private TableColumn<Player, String> userNameTableColumn;
	@FXML
	private TableColumn<Player, String> userEmailTableColumn;
	@FXML
	private TableColumn<Player, String> userCountryCodeTableColumn;
	
	private MainDashboardViewControl theMainDashboardViewControl;
	private ManagePlayersAndAdminsControl theManagePlayersAndAdminsControl;
    
	/**
	 * Constructor for this View Control
	 * @param theMainDashboardViewControl	Reference to the MainDashboard's View Control
	 */
    public ManagePlayersAndAdminsViewControl(MainDashboardViewControl theMainDashboardViewControl) {
    	this.theMainDashboardViewControl = theMainDashboardViewControl;
    	this.theMainDashboardViewControl.setTheManagePlayersAndAdminsViewControl(this);
    	this.theManagePlayersAndAdminsControl = new ManagePlayersAndAdminsControl(theMainDashboardViewControl.getDBConnection());
    }

	@FXML
    private void initialize() throws SQLException {
		userIDTableColumn.setCellValueFactory(new PropertyValueFactory<Player, Integer>("playerId"));
		userIsAdminTableColumn.setCellValueFactory(new PropertyValueFactory<Player, Boolean>("playerIsAdmin"));
		userNameTableColumn.setCellValueFactory(new PropertyValueFactory<Player, String>("playerName"));
		userEmailTableColumn.setCellValueFactory(new PropertyValueFactory<Player, String>("playerEmail"));
		userCountryCodeTableColumn.setCellValueFactory(new PropertyValueFactory<Player, String>("playerCountryCode"));
    }
    
	/**
	 * Binds the ObservableList to the TableView
	 * @throws SQLException 
	 */
    public void updateExistingPlayerAdminList() throws SQLException {
    	theManagePlayersAndAdminsControl.updatePlayerArrayList();
    	existingUserTableView.getItems().clear();
    	existingUserTableView.getItems().addAll(theManagePlayersAndAdminsControl.getObservablePlayerList());
    }
	
	@FXML
	private void handlePlayerAndAdminBackButton() throws SQLException {
		theMainDashboardViewControl.setMainDashboardStage("mainDashboard");
	}
	
	@FXML
	private void handleEditSelectedUserButton() throws SQLException {
		if (existingUserTableView.getSelectionModel().getSelectedItem() != null) {
			theMainDashboardViewControl.setPlayerToEdit(existingUserTableView.getSelectionModel().getSelectedItem().getPlayerId());
			theMainDashboardViewControl.setMainDashboardStage("editPlayersAndAdmins");
		}
		else {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Edit User Issue");
			alert.setHeaderText("Cannot Edit User");
			alert.setContentText("A User to edit was not selected. Please select the user you wish to edit");
			alert.showAndWait();
		}
	}
	
	@FXML
	private void handleCreateUserButton() throws SQLException {
		theMainDashboardViewControl.setMainDashboardStage("createPlayersAndAdmins");
	}
}
