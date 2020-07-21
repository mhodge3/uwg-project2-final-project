/**
 * 
 */
package com.cs6920.model;

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
	public int getAdminId() {
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
	public void setAdminID(int adminId) {
		this.adminId = new SimpleIntegerProperty(adminId);
	}
	
	/**
	 * Gets playerId
	 * @return playerId
	 */
	public int getPlayerId() {
		return playerId.get();
	}
	
	/**
	 * Sets the playerId
	 * @param playerId
	 */
	public void setPlayerId(int playerId) {
		this.playerId = new SimpleIntegerProperty(playerId);
	}
	
	/**
	 * Gets isActive
	 * @return isActive
	 */
	public int getIsActive() {
		return isActive.get();
	}
	
	/**
	 * Sets the isActive
	 * @param isActive
	 */
	public void setIsActive(int isActive) {
		this.isActive = new SimpleIntegerProperty(isActive);
	}

}
