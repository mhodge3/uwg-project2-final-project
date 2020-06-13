package controller;


import DAL.LoginDAL;
import DAL.MySQLAccess;
import javafx.stage.Stage;
import model.Player;

public class LoginControl {
	private MySQLAccess theDBConnection;
	private LoginDAL theLoginDAL;
	private LoginViewControl theLoginViewControl;
	private MainDashboardControl theMainDashboardControl;
	private MainDashboardViewControl theMainDashboardViewControl;
	
	public void SetLoginViewControl(LoginViewControl theLoginViewControl) {
		this.theLoginViewControl = theLoginViewControl;
	}
	
	public void SetTheDBConnection(MySQLAccess theDBConnection) {
		this.theDBConnection = theDBConnection;
		this.theLoginDAL = new LoginDAL(theDBConnection);
	}
	
	public Boolean TestDBConnection() {
		try {
			return theDBConnection.TestDBConnection();
		} catch (Exception e) {
			return false;
		}
	}
	
	public void BuildConnectionString(String hostName, String userName, String password) {
		theDBConnection.BuildConnectionString(hostName, userName, password);
	}
	
	public Player GetPlayer(String playerName, String playerPassword) throws Exception {
		return theLoginDAL.GetPlayer(playerName, playerPassword);
	}
	
	public Boolean IsPlayerAdmin(Player thePlayer) throws Exception {
		Boolean isPlayerAnAdmin = theLoginDAL.IsPlayerAdmin(thePlayer);
		return isPlayerAnAdmin;
	}
	
	public void SetUpMainDashboard(Player theAdminPlayer, Stage thePrimaryStage) {
		if(theMainDashboardControl == null) {
			theMainDashboardControl = new MainDashboardControl(theAdminPlayer, theLoginViewControl);
			theMainDashboardViewControl = new MainDashboardViewControl(theMainDashboardControl, thePrimaryStage);
			theMainDashboardControl.SetMainDashboardViewControl(theMainDashboardViewControl);
			theMainDashboardViewControl.LoadMainDashboardView();
		}
		else {
			theMainDashboardViewControl.ShowMainDashboardView();
		}
	}
}
