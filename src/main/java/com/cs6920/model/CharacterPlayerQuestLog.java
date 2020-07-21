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
public class CharacterPlayerQuestLog {
	
	private IntegerProperty characterId;
	private IntegerProperty questId;
	private IntegerProperty questStatus;
	
	/**
	 * Constructor for testing
	 */
	public CharacterPlayerQuestLog() {
		
	}
	
	/**
	 * Constructor for CharacterPlayerQuest
	 * @param characterId
	 * @param questId
	 * @param questStatus
	 */
	public CharacterPlayerQuestLog(int characterId, int questId, int questStatus) {
		this.characterId = new SimpleIntegerProperty(characterId);
		this.questId = new SimpleIntegerProperty(questId);
		this.questStatus = new SimpleIntegerProperty(questStatus);
	}
	
	/**
	 * Gets the characterId
	 * @return characterId
	 */
	public int getCharacterId() {
		return this.characterId.get();
	}
	
	/**
	 * Gets the characterId property
	 * @return Property for TableView
	 */
	public final IntegerProperty characterIdProperty() {
	   return this.characterId;
	}
	
	
	/**
	 * Sets the characterId
	 * @param setCharacterId
	 */
	public void setCharacterId(int setCharacterId) {
		this.characterId = new SimpleIntegerProperty(setCharacterId);
	}
	
	/**
	 * Gets the questId
	 * @return questId
	 */
	public int getQuestId() {
		return this.questId.get();
	}
	
	/**
	 * Gets the questId property
	 * @return Property for TableView
	 */
	public final IntegerProperty questIdProperty() {
	   return this.questId;
	}
	
	
	/**
	 * Sets the questId
	 * @param setQuestId
	 */
	public void setQuestId(int setQuestId) {
		this.questId = new SimpleIntegerProperty(setQuestId);
	}
	
	/**
	 * Gets the questStatus
	 * @return questStatus
	 */
	public int getQuestStatus() {
		return this.questStatus.get();
	}
	
	/**
	 * Gets the QuestStatus property
	 * @return Property for TableView
	 */
	public final IntegerProperty questStatusProperty() {
	   return this.questStatus;
	}
	
	
	/**
	 * Sets the questStatus
	 * @param setQuestStatus
	 */
	public void setQuestStatus(int setQuestStatus) {
		this.questStatus = new SimpleIntegerProperty(setQuestStatus);
	}
	

}
