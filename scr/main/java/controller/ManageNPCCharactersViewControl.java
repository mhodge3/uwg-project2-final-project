package controller;

import javafx.fxml.FXML;

/**
 * Provides the View Control Logic for the Manage NPC Characters View
 * @author Matthew Hodge
 * @version 6.13.2020
 */
public class ManageNPCCharactersViewControl {
	
	private MainDashboardViewControl theMainDashboardViewControl;
    
	/**
	 * Constructor for this View Control
	 * @param theMainDashboardViewControl	Reference to the MainDashboard's View Control
	 */
    public ManageNPCCharactersViewControl(MainDashboardViewControl theMainDashboardViewControl) {
    	this.theMainDashboardViewControl = theMainDashboardViewControl;
    }
	
	@FXML
	private void handlePlayerAndAdminBackButton() {
		theMainDashboardViewControl.LoadMainDashboardView();
	}
}
