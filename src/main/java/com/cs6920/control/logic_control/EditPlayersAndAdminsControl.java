package com.cs6920.control.logic_control;

import java.sql.SQLException;

import com.cs6920.DAL.MySQLAccess;
import com.cs6920.DAL.PlayerDAL;
import com.cs6920.model.Player;

public class EditPlayersAndAdminsControl {
	private PlayerDAL playerDAL;
	private Player selectedPlayer;
	
	public EditPlayersAndAdminsControl(MySQLAccess theDBConnection) {
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
	
	public Player GetSelectedPlayer() {
		return selectedPlayer;
	}
	
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
