/**
 * 
 */
package model;

/**
 * @author Ashley Palmer
 * @date 6/11/2020
 *
 */
public class Admin extends Player {
	private int adminId;
	private int playerID;
	
	/**
	 * Gets the adminID
	 * @return adminId
	 */
	public int GetAdminId() {
		return adminId;
	}
	
	/**
	 * Sets the AdminId
	 * @param setAdminId
	 */
	public void SetAdminID(int setAdminId) {
		this.adminId = setAdminId;
	}
	
	/**
	 * Gets the playerId
	 * return playerId
	 */
	public int GetPlayerId() {
		return playerID;
	}
	
	/**
	 * Sets the playerId
	 * @param setPlayerId
	 */
	public void SetPlayerID(int setPlayerId) {
		this.playerID = setPlayerId;
	}

}
