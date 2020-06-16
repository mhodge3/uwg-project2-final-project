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
	private String playerCountryCode;
	private String playerEmail;
	private String playerPassword;
	
	/**
	 * Gets the player Name
	 * @return playerName
	 */
	public String GetPlayerName() {
		return playerName;
	}
	
	/**
	 * Sets the playerName
	 * @param userName
	 */
	public void SetPlayerName(String userName) {
		this.playerName = userName;
	}
	
	/**
	 * Gets PlayerIsAdmin
	 * @return playerIsAdmin
	 */
	public Boolean GetPlayerIsAdmin() {
		return playerIsAdmin;
	}
	
	/**
	 * Sets PlayerIsAdmin
	 * @param playerIsAdmin
	 */
	public void SetPlayerIsAdmin(Boolean playerIsAdmin) {
		this.playerIsAdmin = playerIsAdmin;
	}
	
	/**
	 * Gets playerId
	 * @return playerId
	 */
	public int GetPlayerId() {
		return playerId;
	}
	
	/**
	 * Sets the playerId
	 * @param playerId
	 */
	public void SetPlayerId(int playerId) {
		this.playerId = playerId;
	}
	
	/**
	 * Gets player Country code
	 * @return
	 */
	public String GetPlayerCountryCode() {
		return playerCountryCode;
	}
	
	/**
	 * Sets player Country code
	 * @param setPlayerCountryCode
	 */
	public void SetPlayerCountryCode(String setPlayerCountryCode) {
		this.playerCountryCode = setPlayerCountryCode;
	}
	
	/**
	 * Gets the playerEmail
	 * @return playerEmail
	 */
	public String GetPlayerEmail() {
		return playerEmail;
	}
	
	/**
	 * Sets the playerEmail
	 * @param setPlayerEmail
	 */
	
	public void SetPlayerEmail(String setPlayerEmail) {
		this.playerEmail = setPlayerEmail;
	}
	
	/**
	 * Gets the playerPassword
	 * @return playerPassword
	 */
	public String GetPlayerPassword() {
		return playerPassword;
	}
	
	/**
	 * Sets the playerPassword
	 * @param setPlayerPassword
	 */
	public void SetPlayerPassword(String setPlayerPassword) {
		this.playerPassword = setPlayerPassword;
	}
}
