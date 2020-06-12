/**
 * 
 */
package model;

/**
 * @author Ashley Palmer
 * @date 6/11/2020
 *
 */
public class Player {
	private String playerName;
	private Boolean playerIsAdmin;
	
	public String GetPlayerName() {
		return playerName;
	}
	
	public void SetPlayerName(String userName) {
		this.playerName = userName;
	}
	
	public Boolean GetPlayerIsAdmin() {
		return playerIsAdmin;
	}
	
	public void SetPlayerIsAdmin(Boolean playerIsAdmin) {
		this.playerIsAdmin = playerIsAdmin;
	}
}
