package com.cs6920.control.logic_control;

import java.sql.SQLException;
import java.util.ArrayList;

import com.cs6920.DAL.MySQLAccess;
import com.cs6920.DAL.QuestsDAL;
import com.cs6920.model.Quest;


/**
 * Controller class that retrieves data from the QuestsDAL
 * @author Perry Iler
 * @date 7/1/2020
 *
 */
public class QuestsController {
	private QuestsDAL theQuestsDAL;
	
	/**
	 * Constructor for the QuestsController
	 * @param theDBConnection
	 */
	public QuestsController(MySQLAccess theDBConnection) {
		this.theQuestsDAL = new QuestsDAL(theDBConnection);
	}
	
	public int createQuest(int questReceiverNpcId, int questGiverNpcId,
			int preReqQuestId, int conflictId, int minCharacterLevel, 
			String questName, String questDescription, String questArcType, 
			String questGiverDialog, String questReceiverDialog, int idInConflict,
			int preReqIdInConflict) throws SQLException {
		if (String.valueOf(questReceiverNpcId) == null) {
			System.out.println("The quest receiver NpcId cannot be empty");
		}
		else if (String.valueOf(questGiverNpcId) == null) {
			System.out.println("The quest giver NpcId cannot be empty");
		}
		else if (String.valueOf(minCharacterLevel) == null) {
			System.out.println("The min character level cannot be empty");
		}
		else if (questName == null || questName.trim().length() == 0) {
			System.out.println("The quest name cannot be empty");
		}
		else if (questDescription == null || questDescription.trim().length() == 0) {
			System.out.println("The quest description cannot be empty");
		}
		else if (questArcType == null || questArcType.trim().length() == 0) {
			System.out.println("The arc type Code cannot be empty");
		}
		else if (questGiverDialog == null || questGiverDialog.trim().length() == 0) {
			System.out.println("The quest giver dialog cannot be empty");
		}
		else if (questReceiverDialog == null || questReceiverDialog.trim().length() == 0) {
			System.out.println("The quest receiver dialog cannot be empty");
		}
		else if (String.valueOf(idInConflict) == null) {
			System.out.println("The ID in the conflict cannot be empty");
		}
		else if (String.valueOf(preReqIdInConflict) == null) {
			System.out.println("The preReqId in the conflict cannot be empty");
		}
		
		return this.theQuestsDAL.createQuest(questReceiverNpcId, questGiverNpcId, preReqQuestId, conflictId, minCharacterLevel, questName, questDescription, questArcType, questGiverDialog, questReceiverDialog, idInConflict, preReqIdInConflict);
		
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
		
		if (this.theQuestsDAL.updateQuest(quest, questReceiverNpcId, questGiverNpcId, preReqQuestId, 
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
		return this.theQuestsDAL.getQuestByID(questId);
	}
	
	/**
	 * Returns Quest by conflictId.
	 * @param Conflict ID
	 * @return The Quests looked up
	 * @throws SQLException
	 */
	public ArrayList<Quest> getQuestsByConflictID(int conflictId) throws SQLException {
		return this.theQuestsDAL.getQuestByConflictId(conflictId);
	}
	
	/** 
	 * Returns Quest by quest name.
	 * @param Quest name
	 * @return The Quest looked up
	 * @throws SQLException
	 */
	public Quest getQuestByName(String questName) throws SQLException {
		return this.theQuestsDAL.getQuestByName(questName);
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
		return this.theQuestsDAL.deleteQuest(quest);
	}

}
