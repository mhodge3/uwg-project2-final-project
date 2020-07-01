/**
 * 
 */
package com.cs6920.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * @author Ashley Palmer
 * @date 6/25/2020
 *
 */
public class QuestItems {
	
	private IntegerProperty questId;
	private IntegerProperty itemId;
	private IntegerProperty itemQuantity;
	private StringProperty itemDisplayName;
	
	/**
	 * Constructor for testing.
	 */
	public QuestItems() {
		
	}
	
	public QuestItems(int questID, int itemId, int itemQuantity, String itemDisplayName) {
		this.questId = new SimpleIntegerProperty(questID);
		this.itemId = new SimpleIntegerProperty(itemId);
		this.itemQuantity = new SimpleIntegerProperty(itemQuantity);
		this.itemDisplayName = new SimpleStringProperty(itemDisplayName);
	}
	
	
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
	public final IntegerProperty questIdProperty() {
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
	public final IntegerProperty itemIdProperty() {
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
	public final IntegerProperty itemQuantityProperty() {
	   return itemQuantity;
	}
	
	
	/**
	 * Sets the itemQuantity
	 * @param setItemQuantity
	 */
	public void SetItemQuantity(int setItemQuantity) {
		this.itemQuantity = new SimpleIntegerProperty(setItemQuantity);
	}
	
	/**
	 * Gets the itemDisplayName
	 * @return itemDisplayName
	 */
	public String GetItemDisplayName() {
		return itemDisplayName.get();
	}
	
	/**
	 * Gets the itemDisplayName property
	 * @return Property for TableView
	 */
	public final StringProperty itemDisplayNameProperty() {
	   return itemDisplayName;
	}
	
	
	/**
	 * Sets the itemDisplayName
	 * @param itemDisplayName
	 */
	public void SetItemDisplayName(String itemDisplayName) {
		this.itemDisplayName = new SimpleStringProperty(itemDisplayName);
	}

}
