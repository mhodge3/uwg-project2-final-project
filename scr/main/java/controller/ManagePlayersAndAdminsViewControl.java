package controller;

import javafx.fxml.FXML;
import javafx.scene.layout.VBox;

public class ManagePlayersAndAdminsViewControl {
	
	private MainDashboardViewControl theMainDashboardViewControl;
    
    public ManagePlayersAndAdminsViewControl(MainDashboardViewControl theMainDashboardViewControl) {
    	this.theMainDashboardViewControl = theMainDashboardViewControl;
    }
	
	@FXML
	private void handlePlayerAndAdminBackButton() {
		theMainDashboardViewControl.LoadMainDashboardView();
	}
}
