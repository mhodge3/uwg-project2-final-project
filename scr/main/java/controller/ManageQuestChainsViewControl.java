package controller;

import javafx.fxml.FXML;

/**
 * Provides the View Control Logic for the Managing Quest Chains View
 * @author Matthew Hodge
 * @version 6.13.2020
 */
public class ManageQuestChainsViewControl {
	
	private MainDashboardViewControl theMainDashboardViewControl;
    
	/**
	 * Constructor for this View Control
	 * @param theMainDashboardViewControl	Reference to the MainDashboard's View Control
	 */
    public ManageQuestChainsViewControl(MainDashboardViewControl theMainDashboardViewControl) {
    	this.theMainDashboardViewControl = theMainDashboardViewControl;
    }
	
	@FXML
	private void handleQuestChainsBackButton() {
		theMainDashboardViewControl.LoadMainDashboardView();
	}
}
