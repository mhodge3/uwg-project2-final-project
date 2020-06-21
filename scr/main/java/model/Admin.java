/**
 * 
 */
package model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

/**
 * @author Ashley Palmer
 * @date 6/11/2020
 *
 */
public class Admin extends Player {
	private IntegerProperty adminId;
	private IntegerProperty playerId;
	private IntegerProperty isActive;
	
	/**
	 * Default Player constructor. Not currently used, but exists for tests
	 */
	public Admin() {}
	
	public Admin(int adminId, int playerId, int isActive) {
		this.adminId = new SimpleIntegerProperty(adminId);
		this.playerId = new SimpleIntegerProperty(playerId);
		this.isActive = new SimpleIntegerProperty(isActive);
	}
	
	/**
	 * Gets the adminID
	 * @return adminId
	 */
	public int GetAdminId() {
		return adminId.get();
	}
	
	/**
	 * Gets the playerId property
	 * @return Property for TableView
	 */
	public final IntegerProperty adminIdProperty() {
	   return playerId;
	}
	
	
	/**
	 * Sets the AdminId
	 * @param setAdminId
	 */
	public void SetAdminID(int adminId) {
		this.adminId = new SimpleIntegerProperty(adminId);
	}
	
	/**
	 * Gets playerId
	 * @return playerId
	 */
	public int GetPlayerId() {
		return playerId.get();
	}
	
	/**
	 * Sets the playerId
	 * @param playerId
	 */
	public void SetPlayerId(int playerId) {
		this.playerId = new SimpleIntegerProperty(playerId);
	}
	
	/**
	 * Gets isActive
	 * @return isActive
	 */
	public int GetIsActive() {
		return isActive.get();
	}
	
	/**
	 * Sets the isActive
	 * @param isActive
	 */
	public void SetIsActive(int isActive) {
		this.isActive = new SimpleIntegerProperty(isActive);
	}

}
