package controller.viewController;

import controller.logicController.ManagePlayersAndAdminsControl;
import javafx.fxml.FXML;

public class CreatePlayersAndAdminsViewControl {

	private MainDashboardViewControl theMainDashboardViewControl;
	private ManagePlayersAndAdminsControl theManagePlayersAndAdminsControl;
    
	/**
	 * Constructor for this View Control
	 * @param theMainDashboardViewControl	Reference to the MainDashboard's View Control
	 */
    public CreatePlayersAndAdminsViewControl(MainDashboardViewControl theMainDashboardViewControl) {
    	this.theMainDashboardViewControl = theMainDashboardViewControl;
    	this.theManagePlayersAndAdminsControl = new ManagePlayersAndAdminsControl(theMainDashboardViewControl.GetDBConnection());
    }
    
	@FXML
	private void handlePlayerAndAdminEditCanelButton() {
		theMainDashboardViewControl.SetMainDashboardStage("managePlayersAndAdmins");
	}
}
