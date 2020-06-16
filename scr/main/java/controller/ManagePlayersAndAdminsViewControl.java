package controller;

import javafx.fxml.FXML;

/**
 * Provides the View Control Logic for the Manage Players and Admin View
 * @author Matthew Hodge
 * @version 6.13.2020
 */
public class ManagePlayersAndAdminsViewControl {
	
	private MainDashboardViewControl theMainDashboardViewControl;
    
	/**
	 * Constructor for this View Control
	 * @param theMainDashboardViewControl	Reference to the MainDashboard's View Control
	 */
    public ManagePlayersAndAdminsViewControl(MainDashboardViewControl theMainDashboardViewControl) {
    	this.theMainDashboardViewControl = theMainDashboardViewControl;
    }
	
	@FXML
	private void handlePlayerAndAdminBackButton() {
		theMainDashboardViewControl.LoadMainDashboardView();
	}
}
