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

}
