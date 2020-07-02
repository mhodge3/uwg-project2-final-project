package com.cs6920.control.logic_control;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import com.cs6920.DAL.MySQLAccess;
import com.cs6920.DAL.QuestsDAL;
import com.cs6920.model.Quest;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 * Controller class that retrieves data from the QuestsDAL
 * @author Perry Iler
 * @date 7/1/2020
 *
 */
public class QuestsController {
	private QuestsDAL dal;
	
	/**
	 * Constructor for the QuestsController
	 * @param theDBConnection
	 */
	public QuestsController(MySQLAccess theDBConnection) {
		this.dal = new QuestsDAL(theDBConnection);
	}
	
	public int CreateQuest(int questReceiverNpcId, int questGiverNpcId,
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
		
		return this.dal.CreateQuest(questReceiverNpcId, questGiverNpcId, preReqQuestId, conflictId, minCharacterLevel, questName, questDescription, questArcType, questGiverDialog, questReceiverDialog, idInConflict, preReqIdInConflict);
		
	}

	public String UpdateQuest(Quest quest, int questReceiverNpcId, int questGiverNpcId,
			int preReqQuestId, int conflictId, int minCharacterLevel, 
			String questName, String questDescription, String questArcType, 
			String questGiverDialog, String questReceiverDialog, int idInConflict,
			int preReqIdInConflict) throws SQLException {
		if (String.valueOf(questReceiverNpcId) == null) {
			preReqQuestId = quest.GetQuestReceiverNpcId();
		}
		if (String.valueOf(questGiverNpcId) == null) {
			preReqQuestId = quest.GetQuestGiverNpcId();
		}
		if (String.valueOf(preReqQuestId) == null) {
			preReqQuestId = quest.GetPreReqQuestId();
		}
		if (String.valueOf(minCharacterLevel) == null) {
			minCharacterLevel = quest.GetMinCharacterLevel();
		}
		if (String.valueOf(conflictId) == null) {
			conflictId = quest.GetConflictId();
		}
		if (questName == null || questName.trim().length() == 0) {
			questName = quest.GetQuestName();
		}
		if (questDescription == null || questDescription.trim().length() == 0) {
			questDescription = quest.GetQuestDescription();
		}
		if (questArcType == null || questArcType.trim().length() == 0) {
			questArcType = quest.GetQuestArcType();
		}
		if (questGiverDialog == null || questGiverDialog.trim().length() == 0) {
			questGiverDialog = quest.GetQuesGiverDialog();
		}
		if (questGiverDialog == null || questGiverDialog.trim().length() == 0) {
			questGiverDialog = quest.GetQuesGiverDialog();
		}
		if (String.valueOf(idInConflict) == null) {
			idInConflict = quest.GetidInConflict();
		}
		if (String.valueOf(preReqIdInConflict) == null) {
			preReqIdInConflict = quest.GetidPreReqIdConflict();
		}
		
		if (this.dal.UpdateQuest(quest, questReceiverNpcId, questGiverNpcId, preReqQuestId, 
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
	public Quest GetQuestByID(int questId) throws SQLException {
		return this.dal.GetQuestByID(questId);
	}
	
	/**
	 * Returns Quest by conflictId.
	 * @param Conflict ID
	 * @return The Quests looked up
	 * @throws SQLException
	 */
	public ArrayList<Quest> GetQuestsByConflictID(int conflictId) throws SQLException {
		return this.dal.GetQuestByConflictId(conflictId);
	}
	
	/** 
	 * Returns Quest by quest name.
	 * @param Quest name
	 * @return The Quest looked up
	 * @throws SQLException
	 */
	public Quest GetQuestByName(String questName) throws SQLException {
		return this.dal.GetQuestByName(questName);
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
	public boolean DeleteQuest(Quest quest) throws SQLException {
		return this.dal.DeleteQuest(quest);
	}

}
