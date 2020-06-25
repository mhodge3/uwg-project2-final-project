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
	public final IntegerProperty PreReqQuestId() {
	   return preReqQuestId;
	}
	
	
	/**
	 * Sets the preReqQuestId
	 * @param setPreReqQuestId
	 */
	public void SetPreReqQuestId(int setPreReqQuestId) {
		this.preReqQuestId = new SimpleIntegerProperty(setPreReqQuestId);
	}
	
	/**
	 * Gets the conflictId
	 * @return conflictId
	 */
	public int GetConflictId() {
		return conflictId.get();
	}
	
	/**
	 * Gets the conflictId property
	 * @return Property for TableView
	 */
	public final IntegerProperty ConflictId() {
	   return conflictId;
	}
	
	
	/**
	 * Sets the conflictId
	 * @param setConflictId
	 */
	public void SetConflictId(int setConflictId) {
		this.conflictId = new SimpleIntegerProperty(setConflictId);
	}
	
	/**
	 * Gets the minCharacterLevel
	 * @return minCharacterLevel
	 */
	public int GetMinCharacterLevel() {
		return minCharacterLevel.get();
	}
	
	/**
	 * Gets the minCharacterLevel property
	 * @return Property for TableView
	 */
	public final IntegerProperty MinCharacterLevel() {
	   return minCharacterLevel;
	}
	
	
	/**
	 * Sets the MinCharacterLevel
	 * @param setMinCharacterLevel
	 */
	public void SetMinCharacterLevel(int setMinCharacterLevel) {
		this.minCharacterLevel = new SimpleIntegerProperty(setMinCharacterLevel);
	}
	
	/**
	 * Gets the questName
	 * @return questName
	 */
	public String GetQuestName() {
		return questName.get();
	}
	
	/**
	 * Gets the questName property
	 * @return Property for TableView
	 */
	public final StringProperty QuestNameProperty() {
	   return questName;
	}
	
	/**
	 * Sets the questName
	 * @param stQuestName
	 */
	public void SetQuestName(String setQuestName) {
		this.questName = new SimpleStringProperty(setQuestName);
	}

}
