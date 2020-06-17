package controller.viewController;

import java.sql.SQLException;

import controller.logicController.ManagePlayersAndAdminsControl;
import javafx.fxml.FXML;

/**
 * The View Control for the Edit Players and Admins scene
 * @author Matthew Hodge
 * @version 6.17.2020
 */
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
	private void handlePlayerAndAdminEditBackButton() throws SQLException {
		theMainDashboardViewControl.SetMainDashboardStage("managePlayersAndAdmins");
	}
}
