/**
 * 
 */
package com.cs6920.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

/**
 * @author Ashley Palmer
 * @date 6/25/2020
 *
 */

public class Inventory {
	
	private IntegerProperty itemId;
	private IntegerProperty characterId;
	
	/**
	 * Constructor for testing
	 */
	public Inventory() {
		
	}
	
	/**
	 * Constructor for Inventory
	 * @param itemId
	 * @param characterId
	 */
	public Inventory(int itemId, int characterId) {
		this.itemId = new SimpleIntegerProperty(itemId);
		this.characterId = new SimpleIntegerProperty(characterId);
	}
	
	/**
	 * Gets the Item Id
	 * @return itemdID
	 */
	public int getItemId() {
		return itemId.get();
	}
	
	/**
	 * Sets the Item Id
	 * @param setItemID
	 */
	
	public void setItemId(int setItemID) {
		this.itemId = new SimpleIntegerProperty(setItemID);
	}
	
	/**
	 * Gets the ItemID property
	 * @return Property for TableView
	 */
	public final IntegerProperty itemIdProperty() {
	   return itemId;
	}
	
	/**
	 * Gets the characterId
	 * @return characterId
	 */
	public int getCharacterId() {
		return characterId.get();
	}
	
	/**
	 * Gets the characterId property
	 * @return Property for TableView
	 */
	public final IntegerProperty characterIdProperty() {
	   return characterId;
	}
	
	
	/**
	 * Sets the characterId
	 * @param setCharacterId
	 */
	public void setCharacterId(int setCharacterId) {
		this.characterId = new SimpleIntegerProperty(setCharacterId);
	}
	

}
