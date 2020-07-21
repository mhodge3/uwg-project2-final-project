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
	private IntegerProperty idInConflict;
	private IntegerProperty preReqIdInConflict;
	private IntegerProperty minCharacterLevel;
	private IntegerProperty questGiverNpcId;
	private IntegerProperty questReceiverNpcId;
	private StringProperty questArcType;
	private StringProperty questName;
	private StringProperty questDescription;
	private StringProperty questGiverDialog;
	private StringProperty questReceiverDialog;
	
	/**
	 * Constructor for testing.
	 */
	public Quest() {
		
	}
	
	public Quest(int questReceiverNpcId, int questGiverNpcId, int questId, int preReqQuestId, int conflictId, int minCharacterLevel, String questName, String questDescription, String questArcType, String questGiverDialog, String questReceiverDialog, int idInConflict, int preReqIdInConflict) {
		this.questReceiverNpcId = new SimpleIntegerProperty(questReceiverNpcId);
		this.questGiverNpcId = new SimpleIntegerProperty(questGiverNpcId);
		this.questId = new SimpleIntegerProperty(questId);
		this.preReqQuestId = new SimpleIntegerProperty(preReqQuestId);
		this.conflictId = new SimpleIntegerProperty(conflictId);
		this.minCharacterLevel = new SimpleIntegerProperty(minCharacterLevel);
		this.questName = new SimpleStringProperty(questName);
		this.questDescription = new SimpleStringProperty(questDescription);
		this.questArcType = new SimpleStringProperty(questArcType);
		this.questGiverDialog = new SimpleStringProperty(questGiverDialog);
		this.questReceiverDialog = new SimpleStringProperty(questReceiverDialog);
		this.idInConflict = new SimpleIntegerProperty(idInConflict);
		this.preReqIdInConflict = new SimpleIntegerProperty(preReqIdInConflict);
	}
	
	/**
	 * Gets the questReceiverNpcId
	 * @return questReceiverNpcId
	 */
	public int getQuestReceiverNpcId() {
		return this.questReceiverNpcId.get();
	}
	
	/**
	 * Gets the questReceiverNpcId property
	 * @return Property for TableView
	 */
	public final IntegerProperty questReceiverNpcIdProperty() {
	   return this.questReceiverNpcId;
	}
	
	
	/**
	 * Sets the questReceiverNpcId
	 * @param questReceiverNpcId
	 */
	public void setQuestReceiverNpcId(int questReceiverNpcId) {
		this.questReceiverNpcId = new SimpleIntegerProperty(questReceiverNpcId);
	}
	
	/**
	 * Gets the questGiverNpcId
	 * @return questGiverNpcId
	 */
	public int getQuestGiverNpcId() {
		return this.questGiverNpcId.get();
	}
	
	/**
	 * Gets the questGiverNpcId property
	 * @return Property for TableView
	 */
	public final IntegerProperty questGiverNpcIdProperty() {
	   return this.questGiverNpcId;
	}
	
	
	/**
	 * Sets the questGiverNpcId
	 * @param questGiverNpcId
	 */
	public void setQuestGiverNpcId(int questGiverNpcId) {
		this.questGiverNpcId = new SimpleIntegerProperty(questGiverNpcId);
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
	 * Gets the questArcType
	 * @return questArcType
	 */
	public String getQuestArcType() {
		return this.questArcType.get();
	}
	
	/**
	 * Gets the questArcType property
	 * @return Property for TableView
	 */
	public final StringProperty questArcTypeProperty() {
	   return this.questArcType;
	}
	
	
	/**
	 * Sets the questArcType
	 * @param questArcType
	 */
	public void setQuestArcType(String questArcType) {
		this.questArcType = new SimpleStringProperty(questArcType);
	}
	
	/**
	 * Gets the preReqQuestId
	 * @return preReqQuestId
	 */
	public int getPreReqQuestId() {
		return this.preReqQuestId.get();
	}
	
	/**
	 * Gets the PreReqQuestId property
	 * @return Property for TableView
	 */
	public final IntegerProperty preReqQuestIdProperty() {
	   return this.preReqQuestId;
	}
	
	
	/**
	 * Sets the preReqQuestId
	 * @param setPreReqQuestId
	 */
	public void setPreReqQuestId(int setPreReqQuestId) {
		this.preReqQuestId = new SimpleIntegerProperty(setPreReqQuestId);
	}
	
	/**
	 * Gets the conflictId
	 * @return conflictId
	 */
	public int getConflictId() {
		return this.conflictId.get();
	}
	
	/**
	 * Gets the conflictId property
	 * @return Property for TableView
	 */
	public final IntegerProperty conflictIdProperty() {
	   return this.conflictId;
	}
	
	
	/**
	 * Sets the conflictId
	 * @param setConflictId
	 */
	public void setConflictId(int setConflictId) {
		this.conflictId = new SimpleIntegerProperty(setConflictId);
	}
	
	/**
	 * Gets the minCharacterLevel
	 * @return minCharacterLevel
	 */
	public int getMinCharacterLevel() {
		return this.minCharacterLevel.get();
	}
	
	/**
	 * Gets the minCharacterLevel property
	 * @return Property for TableView
	 */
	public final IntegerProperty minCharacterLevelProperty() {
	   return this.minCharacterLevel;
	}
	
	
	/**
	 * Sets the MinCharacterLevel
	 * @param setMinCharacterLevel
	 */
	public void setMinCharacterLevel(int setMinCharacterLevel) {
		this.minCharacterLevel = new SimpleIntegerProperty(setMinCharacterLevel);
	}
	
	/**
	 * Gets the questName
	 * @return questName
	 */
	public String getQuestName() {
		return this.questName.get();
	}
	
	/**
	 * Gets the questName property
	 * @return Property for TableView
	 */
	public final StringProperty questNameProperty() {
	   return this.questName;
	}
	
	/**
	 * Sets the questName
	 * @param stQuestName
	 */
	public void setQuestName(String setQuestName) {
		this.questName = new SimpleStringProperty(setQuestName);
	}
	
	/**
	 * Gets the questDescription
	 * @return questDescription
	 */
	public String getQuestDescription() {
		return this.questDescription.get();
	}
	
	/**
	 * Gets the questDescription property
	 * @return Property for TableView
	 */
	public final StringProperty questDescriptionProperty() {
	   return this.questDescription;
	}
	
	/**
	 * Sets the questDescription
	 * @param setQuestDescription
	 */
	public void setQuestDescription(String setQuestDescription) {
		this.questDescription = new SimpleStringProperty(setQuestDescription);
	}
	
	/**
	 * Gets the questGiverDialog
	 * @return questGiverDialog
	 */
	public String getQuesGiverDialog() {
		return this.questGiverDialog.get();
	}
	
	/**
	 * Gets the questGiverDialog property
	 * @return Property for TableView
	 */
	public final StringProperty questGiverDialogProperty() {
	   return this.questGiverDialog;
	}
	
	/**
	 * Sets the questDescription
	 * @param questGiverDialog
	 */
	public void setQuestGiverDialog(String questGiverDialog) {
		this.questGiverDialog = new SimpleStringProperty(questGiverDialog);
	}
	
	/**
	 * Gets the questReceiverDialog
	 * @return questReceiverDialog
	 */
	public String getQuestReceiverDialog() {
		return this.questReceiverDialog.get();
	}
	
	/**
	 * Gets the questReceiverDialog property
	 * @return Property for TableView
	 */
	public final StringProperty questReceiverDialogProperty() {
	   return this.questReceiverDialog;
	}
	
	/**
	 * Sets the questReceiverDialog
	 * @param questReceiverDialog
	 */
	public void setQuestReceiverDialog(String questReceiverDialog) {
		this.questReceiverDialog = new SimpleStringProperty(questReceiverDialog);
	}
	
	/**
	 * Gets the idInConflict
	 * @return idInConflict
	 */
	public int getidInConflict() {
		return this.idInConflict.get();
	}
	
	/**
	 * Gets the idInConflict property
	 * @return Property for TableView
	 */
	public final IntegerProperty idInConflictProperty() {
	   return this.idInConflict;
	}
	
	
	/**
	 * Sets the idInConflict
	 * @param idInConflict
	 */
	public void setIdInConflict(int idInConflict) {
		this.idInConflict = new SimpleIntegerProperty(idInConflict);
	}
	
	/**
	 * Gets the preReqIdInConflict
	 * @return preReqIdInConflict
	 */
	public int getidPreReqIdConflict() {
		return this.preReqIdInConflict.get();
	}
	
	/**
	 * Gets the preReqIdInConflict property
	 * @return Property for TableView
	 */
	public final IntegerProperty preReqIdInConflictProperty() {
	   return this.preReqIdInConflict;
	}
	
	
	/**
	 * Sets the preReqIdInConflict
	 * @param preReqIdInConflict
	 */
	public void setPreReqIdInConflict(int preReqIdInConflict) {
		this.preReqIdInConflict = new SimpleIntegerProperty(preReqIdInConflict);
	}

}
