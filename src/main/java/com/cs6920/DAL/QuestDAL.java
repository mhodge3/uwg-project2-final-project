package com.cs6920.DAL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.cs6920.model.Quest;

/**
 * Data access layer for the Quests database table
 * @author Perry Iler
 * @date 6/29/2020
 *
 */
public class QuestDAL {
	private MySQLAccess sqlAccess;
	private Connection theConnection;
	
	/**
	 * Creates a QuestDAL object to be used by the controllers
	 */
	public QuestDAL(MySQLAccess theDBConnection) {
		this.sqlAccess = theDBConnection;
	}
	
	/**
	 * Creates a quest entry in the database Quests table
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
	public int createQuest(int questReceiverNpcId, int questGiverNpcId,
		int preReqQuestId, int conflictId, int minCharacterLevel, 
		String questName, String questDescription, String questArcType, 
		String questGiverDialog, String questReceiverDialog, int idInConflict,
		int preReqIdInConflict) throws SQLException {
		int questId = 0;
		try {
			this.theConnection = this.sqlAccess.getDBConnection();
			String query = "INSERT INTO " + this.sqlAccess.getTheDBName() + ".quests " + 
			"(quest_receiver_npc_id, " +
			"quest_giver_npc_id, " +
			"pre_req_quest_id, " +
			"conflict_id, " +
			"min_chartacter_level, " +
			"quest_name, " +
			"quest_description, " +
			"quest_arc_type, " +
			"quest_giver_dialog, " +
			"quest_receiver_dialog, " +
			"id_in_conflict, " +
			"pre_req_id_in_conflict) " +  
			"VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";		
					
			PreparedStatement preparedStmt = theConnection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			preparedStmt.setString (1, String.valueOf(questReceiverNpcId));
			preparedStmt.setString (2, String.valueOf(questGiverNpcId));
			preparedStmt.setString (3, String.valueOf(preReqQuestId));
			preparedStmt.setString (4, String.valueOf(conflictId));
			preparedStmt.setString (5, String.valueOf(minCharacterLevel));
			preparedStmt.setString (6, questName);
			preparedStmt.setString (7, questDescription);
			preparedStmt.setString (8, questArcType);
			preparedStmt.setString (9, questGiverDialog);
			preparedStmt.setString (10, questReceiverDialog);
			preparedStmt.setString (11, String.valueOf(idInConflict));
			preparedStmt.setString (12, String.valueOf(preReqIdInConflict));
			preparedStmt.execute();
			ResultSet result = preparedStmt.getGeneratedKeys();
			if (result.next()) {
				questId = result.getInt(1);
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		finally {
			theConnection.close();
		}
		return questId;
	}
	
	/**
	 * Returns Quest by quest Id.
	 * @param Quest ID
	 * @return The Quest looked up
	 * @throws SQLException
	 */
	public Quest getQuestByID(int questId) throws SQLException {
		Quest quest = null;
        try {
            this.theConnection = this.sqlAccess.getDBConnection();
            Statement statement = this.theConnection.createStatement();
            String query = "SELECT * FROM " + this.sqlAccess.getTheDBName() + ".quests "
            		+ "WHERE " + this.sqlAccess.getTheDBName() + ".quests.quest_id = \"" + questId + "\"";
            ResultSet results = statement.executeQuery(query);
            if (results.next() != false) {
            	quest = new Quest();
            	quest.setQuestReceiverNpcId(results.getInt("quest_receiver_npc_id"));
                quest.setQuestGiverNpcId(results.getInt("quest_giver_npc_id"));
                quest.setQuestId(results.getInt("quest_id"));
                quest.setPreReqQuestId(results.getInt("pre_req_quest_id"));
                quest.setConflictId(results.getInt("confict_id"));
                quest.setMinCharacterLevel(results.getInt("min_chartacter_level"));
                quest.setQuestName(results.getString("quest_name"));
                quest.setQuestDescription(results.getString("quest_description"));
                quest.setQuestArcType(results.getString("quest_arc_type"));
                quest.setQuestGiverDialog(results.getString("quest_giver_dialog"));
                quest.setQuestReceiverDialog(results.getString("quest_receiver_dialog"));
                quest.setIdInConflict(results.getInt("id_in_conflict"));
                quest.setPreReqIdInConflict(results.getInt("pre_req_id_in_conflict"));
            }
        } catch (Exception e) {
        	System.err.println(e.getMessage());
        }
        finally {
        	theConnection.close();
        }
        return quest;
    }
	
	/**
	 * Returns Quest by quest name.
	 * @param Quest name
	 * @return The Quest looked up
	 * @throws SQLException
	 */
	public Quest getQuestByName(String questName) throws SQLException {
    	Quest quest = null;
        try {
            this.theConnection = this.sqlAccess.getDBConnection();
            Statement statement = this.theConnection.createStatement();
            String query = "SELECT * FROM " + this.sqlAccess.getTheDBName() + ".quests "
            		+ "WHERE " + this.sqlAccess.getTheDBName() + ".quests.quest_name = \"" + questName + "\"";
            ResultSet results = statement.executeQuery(query);
            if (results.next() != false) {
            	quest = new Quest();
            	quest.setQuestReceiverNpcId(results.getInt("quest_receiver_npc_id"));
                quest.setQuestGiverNpcId(results.getInt("quest_giver_npc_id"));
                quest.setQuestId(results.getInt("quest_id"));
                quest.setPreReqQuestId(results.getInt("pre_req_quest_id"));
                quest.setConflictId(results.getInt("confict_id"));
                quest.setMinCharacterLevel(results.getInt("min_chartacter_level"));
                quest.setQuestName(results.getString("quest_name"));
                quest.setQuestDescription(results.getString("quest_description"));
                quest.setQuestArcType(results.getString("quest_arc_type"));
                quest.setQuestGiverDialog(results.getString("quest_giver_dialog"));
                quest.setQuestReceiverDialog(results.getString("quest_receiver_dialog"));
                quest.setIdInConflict(results.getInt("id_in_conflict"));
                quest.setPreReqIdInConflict(results.getInt("pre_req_id_in_conflict"));
            }
        } catch (Exception e) {
        	System.err.println(e.getMessage());
        }
        finally {
        	theConnection.close();
        }
        return quest;
    }
	
	/**
	 * Updates an existing quest entry in the database Quests table
	 * @param questId
	 * @param preReqQuestId
	 * @param conflictId
	 * @param minCharacterLevel
	 * @param questName
	 * @param questDescription
	 * @param questArcType
	 * @return True if updated | False if not updated
	 * @throws SQLException 
	 */
	public Boolean updateQuest(Quest quest, int questReceiverNpcId, int questGiverNpcId,
							int preReqQuestId, int conflictId, int minCharacterLevel, 
							String questName, String questDescription, String questArcType, 
							String questGiverDialog, String questReceiverDialog, int idInConflict,
							int preReqIdInConflict) throws SQLException {	
		Boolean success = false;
		try {
			this.theConnection = this.sqlAccess.getDBConnection();
			String query = "UPDATE " + this.sqlAccess.getTheDBName() + ".quests " + 
					"SET quest_receiver_npc_id = ?, " +
					"quest_giver_npc_id = ?, " +
					"pre_req_quest_id = ?, " +
					"confict_id = ?, " +
					"min_chartacter_level = ?, " +
					"quest_name = ?, " +
					"quest_description = ?, " +
					"quest_arc_type = ?, " +
					"quest_giver_dialog = ?, " +
					"quest_receiver_dialog = ?, " +
					"id_in_conflict = ?, " +
					"pre_req_id_in_conflict = ? " +  
					"WHERE quest_id = ?";		
							
			 PreparedStatement preparedStmt = theConnection.prepareStatement(query);
			 preparedStmt.setString (1, String.valueOf(questReceiverNpcId));
			 preparedStmt.setString (2, String.valueOf(questGiverNpcId));
			 preparedStmt.setString (3, String.valueOf(preReqQuestId));
			 preparedStmt.setString (4, String.valueOf(conflictId));
			 preparedStmt.setString (5, String.valueOf(minCharacterLevel));
			 preparedStmt.setString (6, questName);
			 preparedStmt.setString (7, questDescription);
			 preparedStmt.setString (8, questArcType);
			 preparedStmt.setString (9, questGiverDialog);
			 preparedStmt.setString (10, questReceiverDialog);
			 preparedStmt.setString (11, String.valueOf(idInConflict));
			 preparedStmt.setString (12, String.valueOf(preReqIdInConflict));
			 preparedStmt.setString (13, String.valueOf(quest.getQuestId()));
		     preparedStmt.execute();
		      success = true;
		} catch (Exception e) {
        	System.err.println(e.getMessage());
        }
        finally {
        	theConnection.close();
        }
		return success;
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
		Boolean success = false;
		try {
			this.theConnection = this.sqlAccess.getDBConnection();
			String query = "DELETE FROM " + this.sqlAccess.getTheDBName() + ".quests " + 
					"WHERE quest_id = ?";
			PreparedStatement preparedStmt = theConnection.prepareStatement(query);
			preparedStmt.setString (1, String.valueOf(quest.getQuestId()));
			
			preparedStmt.execute();
		      success = true;
		} catch (Exception e) {
        	System.err.println(e.getMessage());
        }
        finally {
        	theConnection.close();
        }
		return success;
	}

}
