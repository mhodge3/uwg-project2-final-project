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
public class QuestItems {
	
	private IntegerProperty questId;
	private IntegerProperty itemId;
	private IntegerProperty itemQuantity;
	
	
	/**
	 * Gets the questId
	 * @return questId
	 */
	public int GetQuestId() {
		return questId.get();
	}
	
	/**
	 * Gets the questId property
	 * @return Property for TableView
	 */
	public final IntegerProperty QuestIdProperty() {
	   return questId;
	}
	
	
	/**
	 * Sets the questId
	 * @param setQuestId
	 */
	public void SetQuestId(int setQuestId) {
		this.questId = new SimpleIntegerProperty(setQuestId);
	}
	
	/**
	 * Gets the itemId
	 * @return itemId
	 */
	public int GetItemId() {
		return itemId.get();
	}
	
	/**
	 * Gets the itemId property
	 * @return Property for TableView
	 */
	public final IntegerProperty ItemIdProperty() {
	   return itemId;
	}
	
	
	/**
	 * Sets the itemId
	 * @param setItemId
	 */
	public void SetItemId(int setItemId) {
		this.itemId = new SimpleIntegerProperty(setItemId);
	}
	
	/**
	 * Gets the itemQuantity
	 * @return itemQuantity
	 */
	public int GetItemQuantity() {
		return itemQuantity.get();
	}
	
	/**
	 * Gets the itemId property
	 * @return Property for TableView
	 */
	public final IntegerProperty ItemQuantityProperty() {
	   return itemQuantity;
	}
	
	
	/**
	 * Sets the itemQuantity
	 * @param setItemQuantity
	 */
	public void SetItemQuantity(int setItemQuantity) {
		this.itemQuantity = new SimpleIntegerProperty(setItemQuantity);
	}

}
