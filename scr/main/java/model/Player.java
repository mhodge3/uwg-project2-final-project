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
	private int playerId;
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
	
	public int GetPlayerId() {
		return playerId;
	}
	
	public void SetPlayerId(int playerId) {
		this.playerId = playerId;
	}
}
