package com.cs6920.control.logic_control;

import java.sql.SQLException;
import java.util.ArrayList;
import com.cs6920.DAL.MySQLAccess;
import com.cs6920.DAL.PlayerDAL;
import com.cs6920.model.Player;

/**
 * Controller class that retrieves data from the PlayerDAL
 * @author Perry Iler
 * @date 6/20/2020
 *
 */
public class PlayerController {
	private PlayerDAL thePlayerDAL;
	private Player theSelectedPlayer;
	
	/**
	 * Constructor for the PlayerDALontroller
	 * @param theDBConnection
	 */
	public PlayerController(MySQLAccess theDBConnection) {
		this.thePlayerDAL = new PlayerDAL(theDBConnection);
	}
	
	/**
	 * Sets the selected player object from DB by id
	 * @param playerId
	 */
	public void setSelectedPlayer(int playerId) {
		try {
			theSelectedPlayer = thePlayerDAL.getPlayer(playerId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Returns a Player if found in the DB
	 * @param playerName
	 * @param playerPassword
	 * @return The Player found
	 * @throws Exception
	 */
	public Player getPlayer(String playerName, String playerPassword) throws Exception {
		return thePlayerDAL.getPlayer(playerName, playerPassword);
	}
	
	/**
	 * Creates a Player entry in the database players table
	 * @param playerName
	 * @param playerPassword
	 * @param playerPasswordConfirm
	 * @param email
	 * @param countryCode
	 * @param makeAdmin
	 * @return String = Error message
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
		
		if (thePlayerDAL.createPlayer(playerName, playerPassword, email, countryCode, makeAdmin)) {
			return null;
		}
		else {
			return "There was a problem creating the account";
		}
	}
	
	/**
	 * Gets the Player object of the selected Player
	 * @return The selected Player
	 */
	public Player getSelectedPlayer() {
		return theSelectedPlayer;
	}
	
	/**
	 * Updates an existing Player entry in the database players table
	 * 
	 * @param playerName
	 * @param playerPassword
	 * @param playerPasswordConfirm
	 * @param playerEmail
	 * @param playerCountryCode
	 * @param makeAdmin
	 * @return String = Error message
	 * @throws SQLException
	 */
	public String updatePlayer(String playerName, String playerPassword, String playerPasswordConfirm, String playerEmail, String playerCountryCode, Boolean makeAdmin) throws SQLException {
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
		
		if (thePlayerDAL.updatePlayer(theSelectedPlayer, new Player(theSelectedPlayer.getPlayerId(), playerName, makeAdmin, playerCountryCode, playerEmail, playerPassword), makeAdmin)) {
			return null;
		}
		else {
			return "There was a problem updating the account";
		}
	}
	
	/**
	 * Retrieves a list of all user (player) accounts
	 * @return the ArrayList of Users (players)
	 * @throws SQLException
	 */
	public ArrayList<Player> getPlayers() throws SQLException {
		return this.thePlayerDAL.getPlayers();
	}
	
	/**
	 * Gets the playerId of the last player inserted into the database players table
	 * @return
	 * @throws SQLException
	 */
	public Integer getLastInsertedId() throws SQLException {
		return thePlayerDAL.getLastInsertedID();
	}
	
	/**
	 * Deletes a player entry from the database players table
	 * @param player
	 * @return True if deleted | False if not deleted
	 * @throws SQLException
	 */
	public boolean deletePlayer(Player player) throws SQLException {
		return this.thePlayerDAL.deletePlayer(player);
	}
	
	/**
	 * Returns weather is a player is a admin 
	 * @param player
	 * @return True if Admin | False if not Admin
	 * @throws Exception
	 */
	public Boolean isPlayerAdmin(Player player) throws Exception {
    	return this.thePlayerDAL.isPlayerAdmin(player);
    }
}
