package com.cs6920.control.logic_control;


import java.sql.SQLException;

import com.cs6920.DAL.LoginDAL;
import com.cs6920.DAL.MySQLAccess;
import com.cs6920.view.LoginViewControl;
import com.cs6920.view.MainDashboardViewControl;
import javafx.stage.Stage;
import com.cs6920.model.Player;

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
	public void setLoginViewControl(LoginViewControl theLoginViewControl) {
		this.theLoginViewControl = theLoginViewControl;
	}
	
	/**
	 * Passes in the already created DB access object
	 * @param theDBConnection the DB connection object
	 */
	public void setTheDBConnection(MySQLAccess theDBConnection) {
		this.theDBConnection = theDBConnection;
		this.theLoginDAL = new LoginDAL(theDBConnection);
	}
	
	/**
	 * Check if a database can be accessed
	 * @return true if yes, false if no
	 */
	public Boolean testDBConnection(String host, String userName, String password, String dBName) {
		buildConnectionString(host, userName, password, dBName);
		try {
			return this.theDBConnection.testDBConnection();
		} catch (Exception e) {
			return false;
		}
	}
	
	/**
	 * Gets the DBConnection class instance for this run of the program
	 * @return  The DBConnection class instance
	 */
	public MySQLAccess getDBConnection() {
		return  this.theDBConnection;
	}
	
	/**
	 * Login that verifies a player exists
	 * @param host
	 * @param userName
	 * @param password
	 * @param dBName
	 * @param loginName
	 * @param loginPassword
	 * @return Player, the Player found
	 */
	public Player userLoginPlayer(String host, String userName, String password, String dBName, String loginName, String loginPassword) {
		buildConnectionString(host, userName, password, dBName);
		try {
			return getPlayer(loginName, loginPassword);
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
	public void buildConnectionString(String hostName, String userName, String password, String dBName) {
		this.theDBConnection.buildConnectionString(hostName, userName, password, dBName);
	}
	
	/**
	 * Returns a Player if found in the DB
	 * @param playerName
	 * @param playerPassword
	 * @return The Player found
	 * @throws Exception
	 */
	public Player getPlayer(String playerName, String playerPassword) throws Exception {
		return this.theLoginDAL.getPlayer(playerName, playerPassword);
	}
	
	/**
	 * Determines if a Player object is an Admin
	 * @param thePlayer
	 * @return true if yes, false if no
	 * @throws Exception
	 */
	public Boolean isPlayerAdmin(Player thePlayer) throws Exception {
		Boolean isPlayerAnAdmin = this.theLoginDAL.isPlayerAdmin(thePlayer);
		return isPlayerAnAdmin;
	}
	
	/**
	 * Set's up the initial main dashboard, and show's it if it already exists
	 * @param theAdminPlayer the validated Admin Player object
	 * @param theMainDashboardStage
	 * @throws SQLException 
	 */
	public void setUpMainDashboard(Player theAdminPlayer, Stage theMainDashboardStage) throws SQLException {
		if(this.theMainDashboardControl == null) {
			this.theMainDashboardControl = new MainDashboardControl(theAdminPlayer, this.theLoginViewControl);
			this.theMainDashboardViewControl = new MainDashboardViewControl(this.theMainDashboardControl, theMainDashboardStage);
			this.theMainDashboardViewControl.loadMainDashboardView();
		}
		else {
			this.theMainDashboardViewControl.showMainDashboardView();
		}
	}
}
