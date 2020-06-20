package controller.logicController;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import DAL.MySQLAccess;
import DAL.PlayerDAL;
import javafx.collections.ObservableList;
import model.Player;

/**
 * Controller class that retrieves data from the PlayerDAL
 * @author Perry Iler
 * @date 6/20/2020
 *
 */
public class PlayerController {
	PlayerDAL playerDAL;
	private Player selectedPlayer;
	
	/**
	 * Constructor for the PlayerDALontroller
	 * @param theDBConnection
	 */
	public PlayerController(MySQLAccess theDBConnection) {
		this.playerDAL = new PlayerDAL(theDBConnection);
	}
	
	public void SetSelectedPlayer(int playerId) {
		try {
			selectedPlayer = playerDAL.GetPlayer(playerId);
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
	public Player GetPlayer(String playerName, String playerPassword) throws Exception {
		return playerDAL.GetPlayer(playerName, playerPassword);
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
	public String CreatePlayer(String playerName, String playerPassword, String playerPasswordConfirm, String email, String countryCode, Boolean makeAdmin) throws SQLException {
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
		
		if (playerDAL.CreatePlayer(playerName, playerPassword, email, countryCode, makeAdmin)) {
			return null;
		}
		else {
			return "There was a problem creating the account";
		}
	}
	
	public Player GetSelectedPlayer() {
		return selectedPlayer;
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
	
	/**
	 * Retrieves a list of all user (player) accounts
	 * @return the ArrayList of Users (players)
	 * @throws SQLException
	 */
	public ArrayList<Player> GetPlayers() throws SQLException {
		return this.playerDAL.GetPlayers();
	}
	
	/**
	 * Gets the playerId of the last player inserted into the database players table
	 * @return
	 * @throws SQLException
	 */
	public Integer GetLastInsertedId() throws SQLException {
		return playerDAL.GetLastInsertedID();
	}
	
	/**
	 * Deletes a player entry from the database players table
	 * @param player
	 * @return True if deleted | False if not deleted
	 * @throws SQLException
	 */
	public boolean DeletePlayer(Player player) throws SQLException {
		return this.playerDAL.DeletePlayer(player);
	}
}
