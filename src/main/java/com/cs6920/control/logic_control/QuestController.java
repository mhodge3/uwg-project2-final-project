package com.cs6920.control.logic_control;

import java.sql.SQLException;

import com.cs6920.DAL.MySQLAccess;
import com.cs6920.DAL.QuestDAL;
import com.cs6920.model.Quest;

/**
 * Controller class that retrieves data from the QuestDAL
 * @author Perry Iler
 * @date 7/1/2020
 *
 */
public class QuestController {
	private QuestDAL theQuestDAL;
	
	/**
	 * Constructor for the QuestController
	 * @param theDBConnection
	 */
	public QuestController(MySQLAccess theDBConnection) {
		this.theQuestDAL = new QuestDAL(theDBConnection);
	}
	
	/**
	 * Calls the CreateQuest method of the DAL
	 * @param questReceiverNpcId
	 * @param questGiverNpcId
	 * @param preReqQuestId
	 * @param conflictId
	 * @param minCharacterLevel
	 * @param questName
	 * @param questDescription
	 * @param questArcType
	 * @param questGiverDialog
	 * @param questReceiverDialog
	 * @param idInConflict
	 * @param preReqIdInConflict
	 * @return True if inserted | False if not inserted
	 * @throws SQLException
	 */
	public String createQuest(int questReceiverNpcId, int questGiverNpcId,
			int preReqQuestId, int conflictId, int minCharacterLevel, 
			String questName, String questDescription, String questArcType, 
			String questGiverDialog, String questReceiverDialog, int idInConflict,
			int preReqIdInConflict) throws SQLException {
		if (String.valueOf(questReceiverNpcId) == null) {
			return "The quest receiver NpcId cannot be empty";
		}
		else if (String.valueOf(questGiverNpcId) == null) {
			return "The quest giver NpcId cannot be empty";
		}
		else if (String.valueOf(minCharacterLevel) == null) {
			return "The min character level cannot be empty";
		}
		else if (questName == null || questName.trim().length() == 0) {
			return "The quest name cannot be empty";
		}
		else if (questDescription == null || questDescription.trim().length() == 0) {
			return "The quest description cannot be empty";
		}
		else if (questArcType == null || questArcType.trim().length() == 0) {
			return "The arc type Code cannot be empty";
		}
		else if (questGiverDialog == null || questGiverDialog.trim().length() == 0) {
			return "The quest giver dialog cannot be empty";
		}
		else if (questReceiverDialog == null || questReceiverDialog.trim().length() == 0) {
			return "The quest receiver dialog cannot be empty";
		}
		else if (String.valueOf(idInConflict) == null) {
			return "The ID in the conflict cannot be empty";
		}
		else if (String.valueOf(preReqIdInConflict) == null) {
			return "The preReqId in the conflict cannot be empty";
		}
		
		if (this.theQuestDAL.createQuest(questReceiverNpcId, questGiverNpcId, preReqQuestId, conflictId, minCharacterLevel, questName, questDescription, questArcType, questGiverDialog, questReceiverDialog, idInConflict, preReqIdInConflict) > 0) {
			return null;
		}
		else {
			return "There was a problem creating the quest";
		}
	}

	public String updateQuest(Quest quest, int questReceiverNpcId, int questGiverNpcId,
			int preReqQuestId, int conflictId, int minCharacterLevel, 
			String questName, String questDescription, String questArcType, 
			String questGiverDialog, String questReceiverDialog, int idInConflict,
			int preReqIdInConflict) throws SQLException {
		if (String.valueOf(questReceiverNpcId) == null) {
			preReqQuestId = quest.getQuestReceiverNpcId();
		}
		if (String.valueOf(questGiverNpcId) == null) {
			preReqQuestId = quest.getQuestGiverNpcId();
		}
		if (String.valueOf(preReqQuestId) == null) {
			preReqQuestId = quest.getPreReqQuestId();
		}
		if (String.valueOf(minCharacterLevel) == null) {
			minCharacterLevel = quest.getMinCharacterLevel();
		}
		if (String.valueOf(conflictId) == null) {
			conflictId = quest.getConflictId();
		}
		if (questName == null || questName.trim().length() == 0) {
			questName = quest.getQuestName();
		}
		if (questDescription == null || questDescription.trim().length() == 0) {
			questDescription = quest.getQuestDescription();
		}
		if (questArcType == null || questArcType.trim().length() == 0) {
			questArcType = quest.getQuestArcType();
		}
		if (questGiverDialog == null || questGiverDialog.trim().length() == 0) {
			questGiverDialog = quest.getQuesGiverDialog();
		}
		if (questGiverDialog == null || questGiverDialog.trim().length() == 0) {
			questGiverDialog = quest.getQuesGiverDialog();
		}
		if (String.valueOf(idInConflict) == null) {
			idInConflict = quest.getidInConflict();
		}
		if (String.valueOf(preReqIdInConflict) == null) {
			preReqIdInConflict = quest.getidPreReqIdConflict();
		}
		
		if (this.theQuestDAL.updateQuest(quest, questReceiverNpcId, questGiverNpcId, preReqQuestId, 
				conflictId, minCharacterLevel, questName, questDescription, questArcType, 
				questGiverDialog, questReceiverDialog, idInConflict, preReqIdInConflict)) {
				return null;
		}
		else {
			return "There was a problem updating the quest";
		}
	}
	
	/**
	 * Returns Quest by quest Id.
	 * @param Quest ID
	 * @return The Quest looked up
	 * @throws SQLException
	 */
	public Quest getQuestByID(int questId) throws SQLException {
		return this.getQuestByID(questId);
	}
	
	/** 
	 * Returns Quest by quest name.
	 * @param Quest name
	 * @return The Quest looked up
	 * @throws SQLException
	 */
	public Quest getQuestByName(String questName) throws SQLException {
		return this.getQuestByName(questName);
	}
	
	/**
	 * Deletes an existing quest entry in the database Quests table
	 * @param questId
	 * @param preReqQuestId
	 * @param conflictId
	 * @param minCharacterLevel
	 * @param questName
	 * @param questDescription
	 * @param questArcType
	 * @return True if deleted | False if not deleted
	 * @throws SQLException 
	 */
	public boolean deleteQuest(Quest quest) throws SQLException {
		return this.deleteQuest(quest);
	}

}
