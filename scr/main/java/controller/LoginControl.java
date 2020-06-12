package controller;

import DAL.MySQLAccess;

public class LoginControl {
	private MySQLAccess theDBConnection;
	
	public void SetTheDBConnection(MySQLAccess theDBConnection) {
		this.theDBConnection = theDBConnection;
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
}
