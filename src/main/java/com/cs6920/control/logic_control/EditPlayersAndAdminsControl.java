package com.cs6920.control.logic_control;

import java.sql.SQLException;

import com.cs6920.DAL.MySQLAccess;
import com.cs6920.DAL.PlayerDAL;
import com.cs6920.model.Player;

/**
 * Communicates between the create NPCCharacter view and DAL
 * @author Matthew Hodge
 * @version 6.23.2020
 */
public class EditPlayersAndAdminsControl {
	private PlayerDAL playerDAL;
	private Player selectedPlayer;
	
	/**
	 * Constructor that sets DAL to the current DBConnection class instance
	 * @param theDBConnection
	 */
	public EditPlayersAndAdminsControl(MySQLAccess theDBConnection) {
		this.playerDAL = new PlayerDAL(theDBConnection);
	}
	
	/**
	 * Sets an instance of the Player to that found by id
	 * @param playerId
	 */
	public void SetSelectedPlayer(int playerId) {
		try {
			selectedPlayer = playerDAL.GetPlayer(playerId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Get the Player object for editing
	 * @return the Player object to edit
	 */
	public Player GetSelectedPlayer() {
		return selectedPlayer;
	}
	
	/**
	 * Delete this Player from the DB
	 * @param playerToDelete
	 * @return String, message for user on outcome of operation
	 */
	public String DeletePlayer(Player playerToDelete) {
		
		try {
			if (playerDAL.DeletePlayer(playerToDelete)) {
				return null;
			}
			else {
				return "There was a problem deleting the Player";
			}
		} catch (SQLException e) {
			return "There was a problem deleting the Player from the database";
		}
	}
	
	/**
	 * Update this Player in the DB
	 * @param playerName
	 * @param playerPassword
	 * @param playerPasswordConfirm
	 * @param playerEmail
	 * @param playerCountryCode
	 * @param makeAdmin
	 * @return String, message for user on outcome of operation
	 * @throws SQLException
	 */
	public String UpdatePlayer(String playerName, String playerPassword, String playerPasswordConfirm, String playerEmail, String playerCountryCode, Boolean makeAdmin) throws SQLException {
		if (playerName == null || playerName.trim().length() == 0) {
			return "The User Name cannot be empty";
		}
		else if (playerPassword == null || playerPassword.trim().length() == 0) {
			return "The User Password cannot be empty";
		}
		else if (!playerPassword.contentEquals(playerPasswordConfirm)) {
			return "The User Password does not match the Confirm Password";
		}
		else if (playerEmail == null || playerEmail.trim().length() == 0) {
			return "The User Email cannot be empty";
		}
		else if (playerCountryCode == null || playerCountryCode.trim().length() == 0) {
			return "The User Country Code cannot be empty";
		}
		
		if (playerDAL.UpdatePlayer(selectedPlayer, new Player(selectedPlayer.GetPlayerId(), playerName, makeAdmin, playerCountryCode, playerEmail, playerPassword), makeAdmin)) {
			return null;
		}
		else {
			return "There was a problem updating the account";
		}
	}
}
