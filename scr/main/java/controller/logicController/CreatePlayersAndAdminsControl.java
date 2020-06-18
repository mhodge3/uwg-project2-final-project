package controller.logicController;

import java.sql.SQLException;

import DAL.AdminDAL;
import DAL.MySQLAccess;
import DAL.PlayerDAL;

public class CreatePlayersAndAdminsControl {
	private PlayerDAL playerDAL;
	private AdminDAL adminDAL;
	
	public CreatePlayersAndAdminsControl(MySQLAccess theDBConnection) {
		this.playerDAL = new PlayerDAL(theDBConnection);
		this.adminDAL = new AdminDAL(theDBConnection);
	}
	
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
	
	public Integer GetLastInsertedId() throws SQLException {
		return playerDAL.GetLastInsertedID();
	}
	
	public String CreateAdmin(int thePlayerIdToElevate) throws SQLException {
		if (adminDAL.CreateAdmin(thePlayerIdToElevate)) {
			return null;
		}
		else {
			return "There was an error making this Player User an Admin";
		}
	}
}
