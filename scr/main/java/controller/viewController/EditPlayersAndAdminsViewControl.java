package controller.viewController;

import controller.logicController.ManagePlayersAndAdminsControl;
import javafx.fxml.FXML;

public class EditPlayersAndAdminsViewControl {

	private MainDashboardViewControl theMainDashboardViewControl;
	private ManagePlayersAndAdminsControl theManagePlayersAndAdminsControl;
    
	/**
	 * Constructor for this View Control
	 * @param theMainDashboardViewControl	Reference to the MainDashboard's View Control
	 */
    public EditPlayersAndAdminsViewControl(MainDashboardViewControl theMainDashboardViewControl) {
    	this.theMainDashboardViewControl = theMainDashboardViewControl;
    	this.theManagePlayersAndAdminsControl = new ManagePlayersAndAdminsControl(theMainDashboardViewControl.GetDBConnection());
    }
    
	@FXML
	private void handlePlayerAndAdminEditBackButton() {
		theMainDashboardViewControl.SetMainDashboardStage("managePlayersAndAdmins");
	}
}
