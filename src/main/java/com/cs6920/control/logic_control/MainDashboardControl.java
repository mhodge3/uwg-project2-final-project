package com.cs6920.control.logic_control;

import com.cs6920.DAL.MySQLAccess;
import com.cs6920.control.view_control.LoginViewControl;
import com.cs6920.model.Player;

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
	
	public Player GetTheAdminPlayer() {
		return this.theAdminPlayer;
	}
	
	/**
	 * Begins the LoginViewControl's process for reseting to the Login View
	 */
	public void ResetLoginView() {
		theLoginViewControl.ShowLoginStage();
	}
	
	public MySQLAccess GetDBConnection() {
		return theLoginViewControl.GetDBConnection();
	}
}
