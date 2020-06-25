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
	public int GetCharacterId() {
		return characterId.get();
	}
	
	/**
	 * Gets the characterId property
	 * @return Property for TableView
	 */
	public final IntegerProperty CharacterIdProperty() {
	   return characterId;
	}
	
	
	/**
	 * Sets the characterId
	 * @param setCharacterId
	 */
	public void SetCharacterId(int setCharacterId) {
		this.characterId = new SimpleIntegerProperty(setCharacterId);
	}
	
	/**
	 * Gets the questId
	 * @return questId
	 */
	public int GetquestId() {
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
	 * Gets the questStatus
	 * @return questStatus
	 */
	public int GetQuestStatus() {
		return questStatus.get();
	}
	
	/**
	 * Gets the QuestStatus property
	 * @return Property for TableView
	 */
	public final IntegerProperty QuestStatusProperty() {
	   return questStatus;
	}
	
	
	/**
	 * Sets the questStatus
	 * @param setQuestStatus
	 */
	public void QuestStatus(int setQuestStatus) {
		this.questStatus = new SimpleIntegerProperty(setQuestStatus);
	}
	

}
