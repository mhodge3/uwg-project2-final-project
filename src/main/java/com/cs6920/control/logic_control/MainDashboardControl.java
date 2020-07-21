package com.cs6920.control.logic_control;

import com.cs6920.DAL.MySQLAccess;
import com.cs6920.model.Player;
import com.cs6920.view.LoginViewControl;

/**
 * This Class Controls logic for the MainDashboard
 * @author Matthew Hodge
 * @version 6.12.2020
 */
public class MainDashboardControl {
	private Player theAdminPlayer;
	private LoginViewControl theLoginViewControl;
	
	/**
	 * Constructor for the MainDashboard
	 * @param theAdminPlayer	A Player object that holds values for the currently logged in Player who is an Admin
	 * @param theLoginViewControl	A reference to the LoginViewControl instance that creation this Dashboard
	 */
	public MainDashboardControl(Player theAdminPlayer, LoginViewControl theLoginViewControl) {
		this.theAdminPlayer = theAdminPlayer;
		this.theLoginViewControl = theLoginViewControl;
	}
	
	/**
	 * Get the Player object that is an Admin
	 * @return Player, the Admin Player
	 */
	public Player getTheAdminPlayer() {
		return this.theAdminPlayer;
	}
	
	/**
	 * Begins the LoginViewControl's process for reseting to the Login View
	 */
	public void resetLoginView() {
		theLoginViewControl.showLoginStage();
	}
	
	/**
	 * Gets the DBDconnection class instance for this run of the program
	 * @return the DB Connection class
	 */
	public MySQLAccess getDBConnection() {
		return theLoginViewControl.getDBConnection();
	}
}
