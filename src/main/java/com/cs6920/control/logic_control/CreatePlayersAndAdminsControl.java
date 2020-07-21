package com.cs6920.control.logic_control;

import java.sql.SQLException;

import com.cs6920.DAL.MySQLAccess;
import com.cs6920.DAL.PlayerDAL;

/**
 * Communicates between the create PlayerAndAdmins view and DAL
 * @author Matthew Hodge
 * @version 6.23.2020
 */
public class CreatePlayersAndAdminsControl {
	private PlayerDAL thePlayerDAL;
	
	/**
	 * Constructor that sets DAL to the current DBConnection class instance
	 * @param theDBConnection
	 */
	public CreatePlayersAndAdminsControl(MySQLAccess theDBConnection) {
		this.thePlayerDAL = new PlayerDAL(theDBConnection);
	}
	
	/**
	 * Communicates between the create Items view and DAL
	 * @param playerName
	 * @param playerPassword
	 * @param playerPasswordConfirm
	 * @param email
	 * @param countryCode
	 * @param makeAdmin
	 * @return String, message for user on outcome of operation
	 * @throws SQLException
	 */
	public String createPlayer(String playerName, String playerPassword, String playerPasswordConfirm, String email, String countryCode, Boolean makeAdmin) throws SQLException {
		if (playerName == null || playerName.trim().length() == 0) {
			return "The User Name cannot be empty";
		}
		else if (playerPassword == null || playerPassword.trim().length() == 0) {
			return "The User Password cannot be empty";
		}
		else if (!playerPassword.contentEquals(playerPasswordConfirm)) {
			return "The User Password does not match the Confirm Password";
		}
		else if (email == null || email.trim().length() == 0) {
			return "The User Email cannot be empty";
		}
		else if (countryCode == null || countryCode.trim().length() == 0) {
			return "The User Country Code cannot be empty";
		}
		
		if (this.thePlayerDAL.createPlayer(playerName, playerPassword, email, countryCode, makeAdmin)) {
			return null;
		}
		else {
			return "There was a problem creating the account";
		}
	}
}
