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
	 * Gets the Item Id
	 * @return itemdID
	 */
	public int GetItemId() {
		return itemId.get();
	}
	
	/**
	 * Sets the Item Id
	 * @param setItemID
	 */
	
	public void SetItemId(int setItemID) {
		this.itemId = new SimpleIntegerProperty(setItemID);
	}
	
	/**
	 * Gets the ItemID property
	 * @return Property for TableView
	 */
	public final IntegerProperty itemIdProperty() {
	   return itemId;
	}
	

}
