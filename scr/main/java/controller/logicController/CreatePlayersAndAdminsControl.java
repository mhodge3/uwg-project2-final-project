package controller.logicController;

import java.sql.SQLException;

import DAL.MySQLAccess;
import DAL.PlayerDAL;

public class CreatePlayersAndAdminsControl {
	private PlayerDAL playerDAL;
	
	public CreatePlayersAndAdminsControl(MySQLAccess theDBConnection) {
		this.playerDAL = new PlayerDAL(theDBConnection);
	}
	
	public String CreatePlayer(String playerName, String playerPassword, String playerPasswordConfirm, String email, String countryCode) throws SQLException {
		if (playerName == null || playerName.trim().length() == 0) {
			return "The User Name cannot be empty";
		}
		else if (playerPassword == null || playerPassword.trim().length() == 0) {
			return "The User Password cannot be empty";
		}
		else if (playerPassword != playerPasswordConfirm) {
			return "The User Password does not match the Confirm Password";
		}
		else if (email == null || email.trim().length() == 0) {
			return "The User Email cannot be empty";
		}
		else if (countryCode == null || countryCode.trim().length() == 0) {
			return "The User Country Code cannot be empty";
		}
		
		if (playerDAL.CreatePlayer(playerName, playerPassword, email, countryCode)) {
			return null;
		}
		else {
			return "There was a problem creating the account";
		}
	}
}
