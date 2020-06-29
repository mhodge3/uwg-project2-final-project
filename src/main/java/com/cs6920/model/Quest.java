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

public class Quest {
	
	private IntegerProperty questId;
	private IntegerProperty preReqQuestId;
	private IntegerProperty conflictId;
	private IntegerProperty minCharacterLevel;
	private IntegerProperty questArcType;
	private StringProperty questName;
	private StringProperty questDescription;
	
	/**
	 * Constructor for testing.
	 */
	public Quest() {
		
	}
	
	public Quest(int questId, int preReqQuestId, int conflictId, int minCharacterLevel, String questName, String questDescription, int questArcType) {
		this.questId = new SimpleIntegerProperty(questId);
		this.preReqQuestId = new SimpleIntegerProperty(preReqQuestId);
		this.conflictId = new SimpleIntegerProperty(conflictId);
		this.minCharacterLevel = new SimpleIntegerProperty(minCharacterLevel);
		this.questName = new SimpleStringProperty(questName);
		this.questDescription = new SimpleStringProperty(questDescription);
		this.questArcType = new SimpleIntegerProperty(questArcType);
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
	 * Gets the questArcType
	 * @return questArcType
	 */
	public int GetQuestArcType() {
		return this.questArcType.get();
	}
	
	/**
	 * Gets the questArcType property
	 * @return Property for TableView
	 */
	public final IntegerProperty questArcTypeProperty() {
	   return this.questArcType;
	}
	
	
	/**
	 * Sets the questArcType
	 * @param questArcType
	 */
	public void SetQuestArcType(int questArcType) {
		this.questArcType = new SimpleIntegerProperty(questArcType);
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
	public final IntegerProperty preReqQuestIdProperty() {
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
	public final IntegerProperty conflictIdProperty() {
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
	public final IntegerProperty minCharacterLevelProperty() {
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
	public final StringProperty questNameProperty() {
	   return questName;
	}
	
	/**
	 * Sets the questName
	 * @param stQuestName
	 */
	public void SetQuestName(String setQuestName) {
		this.questName = new SimpleStringProperty(setQuestName);
	}
	
	/**
	 * Gets the questDescription
	 * @return questDescription
	 */
	public String GetQuestDescription() {
		return questDescription.get();
	}
	
	/**
	 * Gets the questDescription property
	 * @return Property for TableView
	 */
	public final StringProperty questDescriptionProperty() {
	   return questDescription;
	}
	
	/**
	 * Sets the questDescription
	 * @param setQuestDescription
	 */
	public void SetQuestDescription(String setQuestDescription) {
		this.questDescription = new SimpleStringProperty(setQuestDescription);
	}

}
