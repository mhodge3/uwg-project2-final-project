package controller;

import javafx.fxml.FXML;

/**
 * Provides the View Control Logic for the Manage Items View
 * @author Matthew Hodge
 * @version 6.13.2020
 */
public class ManageItemsViewControl {
	
	private MainDashboardViewControl theMainDashboardViewControl;
    
	/**
	 * Constructor for this View Control
	 * @param theMainDashboardViewControl	Reference to the MainDashboard's View Control
	 */
    public ManageItemsViewControl(MainDashboardViewControl theMainDashboardViewControl) {
    	this.theMainDashboardViewControl = theMainDashboardViewControl;
    }
	
	@FXML
	private void handleItemsBackButton() {
		theMainDashboardViewControl.LoadMainDashboardView();
	}
}
