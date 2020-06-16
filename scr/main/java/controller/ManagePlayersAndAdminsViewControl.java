package controller;

import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import model.Player;

/**
 * Provides the View Control Logic for the Manage Players and Admin View
 * @author Matthew Hodge
 * @version 6.13.2020
 */
public class ManagePlayersAndAdminsViewControl {
	@FXML
	private ListView<Player> existingUserListView;
	
	private MainDashboardViewControl theMainDashboardViewControl;
	private ManagePlayersAndAdminsControl theManagePlayersAndAdminsControl;

	@FXML
    public void initialize() {
    	updateExistingPlayerAdminList();
    }
    
    public void updateExistingPlayerAdminList() {
    	existingUserListView.getItems().addAll(theManagePlayersAndAdminsControl.GetObservablePlayerList());
    	System.out.println(existingUserListView.toString());
    }
    
	/**
	 * Constructor for this View Control
	 * @param theMainDashboardViewControl	Reference to the MainDashboard's View Control
	 */
    public ManagePlayersAndAdminsViewControl(MainDashboardViewControl theMainDashboardViewControl) {
    	this.theMainDashboardViewControl = theMainDashboardViewControl;
    	this.theManagePlayersAndAdminsControl = new ManagePlayersAndAdminsControl(theMainDashboardViewControl.GetDBConnection());
    }
	
	@FXML
	private void handlePlayerAndAdminBackButton() {
		theMainDashboardViewControl.LoadMainDashboardView();
	}
}
