package controller;

import DAL.LoginDAL;
import DAL.MySQLAccess;
import model.Player;

public class LoginControl {
	private MySQLAccess theDBConnection;
	private LoginDAL theLoginDAL;
	
	public void SetTheDBConnection(MySQLAccess theDBConnection) {
		this.theDBConnection = theDBConnection;
		this.theLoginDAL = new LoginDAL(theDBConnection);
	}
	
	public Boolean TestDBConnection() {
		try {
			return theDBConnection.TestDBConnection();
		} catch (Exception e) {
			return false;
		}
	}
	
	public void BuildConnectionString(String hostName, String userName, String password) {
		theDBConnection.BuildConnectionString(hostName, userName, password);
	}
	
	public Player GetPlayer(String playerName, String playerPassword) throws Exception {
		return theLoginDAL.GetPlayer(playerName, playerPassword);
	}
	
	public Boolean IsPlayerAdmin(Player thePlayer) throws Exception {
		return theLoginDAL.IsPlayerAdmin(thePlayer);
	}
}
