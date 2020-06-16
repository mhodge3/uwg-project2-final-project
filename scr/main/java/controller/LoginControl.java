package controller;


import DAL.LoginDAL;
import DAL.MySQLAccess;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import model.Player;

/**
 * Controls the Logic for Login
 * @author Matthew Hodge
 * @version 6.12.2020
 */
public class LoginControl {
	private MySQLAccess theDBConnection;
	private LoginDAL theLoginDAL;
	private LoginViewControl theLoginViewControl;
	private MainDashboardControl theMainDashboardControl;
	private MainDashboardViewControl theMainDashboardViewControl;
	/**
	 * Gives this LoginControl a reference to its View control
	 * @param theLoginViewControl
	 */
	public void SetLoginViewControl(LoginViewControl theLoginViewControl) {
		this.theLoginViewControl = theLoginViewControl;
	}
	
	/**
	 * Passes in the already created DB access object
	 * @param theDBConnection the DB connection object
	 */
	public void SetTheDBConnection(MySQLAccess theDBConnection) {
		this.theDBConnection = theDBConnection;
		this.theLoginDAL = new LoginDAL(theDBConnection);
	}
	
	/**
	 * Check if a database can be accessed
	 * @return true if yes, false if no
	 */
	public Boolean TestDBConnection(String host, String userName, String password, String dBName) {
		BuildConnectionString(host, userName, password, dBName);
		try {
			return theDBConnection.TestDBConnection();
		} catch (Exception e) {
			return false;
		}
	}
	
	public Player UserLoginPlayer(String host, String userName, String password, String dBName, String loginName, String loginPassword) {
		BuildConnectionString(host, userName, password, dBName);
		try {
			return GetPlayer(loginName, loginPassword);
		} catch (Exception e) {
			return null;
		}
	}
	
	/**
	 * Builds the Connection string that the DB will use to access a DDB
	 * @param hostName 
	 * @param userName
	 * @param password
	 */
	public void BuildConnectionString(String hostName, String userName, String password, String dBName) {
		theDBConnection.BuildConnectionString(hostName, userName, password, dBName);
	}
	
	/**
	 * Returns a Player if found in the DB
	 * @param playerName
	 * @param playerPassword
	 * @return The Player found
	 * @throws Exception
	 */
	public Player GetPlayer(String playerName, String playerPassword) throws Exception {
		return theLoginDAL.GetPlayer(playerName, playerPassword);
	}
	
	/**
	 * Determines if a Player object is an Admin
	 * @param thePlayer
	 * @return true if yes, false if no
	 * @throws Exception
	 */
	public Boolean IsPlayerAdmin(Player thePlayer) throws Exception {
		Boolean isPlayerAnAdmin = theLoginDAL.IsPlayerAdmin(thePlayer);
		return isPlayerAnAdmin;
	}
	
	/**
	 * Set's up the initial main dashboard, and show's it if it already exists
	 * @param theAdminPlayer the validated Admin Player object
	 * @param theMainDashboardStage
	 */
	public void SetUpMainDashboard(Player theAdminPlayer, Stage theMainDashboardStage) {
		if(theMainDashboardControl == null) {
			theMainDashboardControl = new MainDashboardControl(theAdminPlayer, theLoginViewControl);
			theMainDashboardViewControl = new MainDashboardViewControl(theMainDashboardControl, theMainDashboardStage);
			theMainDashboardViewControl.LoadMainDashboardView();
		}
		else {
			theMainDashboardViewControl.ShowMainDashboardView();
		}
	}
}
