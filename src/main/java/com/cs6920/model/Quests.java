/**
 * 
 */
package com.cs6920.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.StringProperty;

/**
 * @author Ashley Palmer
 * @date 6/25/2020
 *
 */

public class Quests {
	
	private IntegerProperty questId;
	private IntegerProperty preReqQuestId;
	private IntegerProperty conflictId;
	private IntegerProperty minCharacterLevel;
	private StringProperty questName;
	private StringProperty questDescription;
	
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
	 * Gets the preReqQuestId
	 * @return preReqQuestId
	 */
	public int GetPreReqQuestId() {
		return preReqQuestId.get();
	}
	
	/**
	 * Gets the PreReqQuestId property
	 * @return Property for TableView
	 */
	public final IntegerProperty QuestPreReqQuestId() {
	   return preReqQuestId;
	}
	
	
	/**
	 * Sets the preReqQuestId
	 * @param setPreReqQuestId
	 */
	public void SetPreReqQuestId(int setPreReqQuestId) {
		this.preReqQuestId = new SimpleIntegerProperty(setPreReqQuestId);
	}

}
