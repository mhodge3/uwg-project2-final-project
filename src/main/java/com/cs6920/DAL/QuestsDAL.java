package com.cs6920.DAL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.cs6920.model.CharactersPlayer;
import com.cs6920.model.Quest;

/**
 * Data access layer for the Quests database table
 * @author Perry Iler
 * @date 6/29/2020
 *
 */
public class QuestsDAL {
	private MySQLAccess sqlAccess;
	private Connection conn;
	
	/**
	 * Creates a QuestDAL object to be used by the controllers
	 */
	public QuestsDAL(MySQLAccess theDBConnection) {
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
	public int CreateQuest(int questReceiverNpcId, int questGiverNpcId,
								int preReqQuestId, int conflictId, int minCharacterLevel, 
								String questName, String questDescription, String questArcType, 
								String questGiverDialog, String questReceiverDialog, int idInConflict,
								int preReqIdInConflict) throws SQLException {
		int questId = 0;
		try {
			this.conn = this.sqlAccess.GetDBConnection();
			String query = "INSERT INTO " + this.sqlAccess.GetTheDBName() + ".quests " + 
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
							
			 PreparedStatement preparedStmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
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
        	conn.close();
        }
		return questId;
	}

	// Get all method - not sure if needed
	/*public ArrayList<Quest> GetQuests(TBD) throws SQLException {
		ArrayList<Quest> quests = new ArrayList<Quest>();
        try {
            this.conn = this.sqlAccess.GetDBConnection();
            Statement statement = this.conn.createStatement();
            String query = "SELECT * FROM " + this.sqlAccess.GetTheDBName() + ".quests "
            		+ "WHERE " + this.sqlAccess.GetTheDBName() + ".quests.TBD = \"" + TBD + "\"";
            ResultSet results = statement.executeQuery(query);
            while (results.next() != false) {
            	Quest quest = new Quest();
            	quest.SetQuestReceiverNpcId(results.getInt("quest_receiver_npc_id"));
                quest.SetQuestGiverNpcId(results.getInt("quest_giver_npc_id"));
                quest.SetQuestId(results.getInt("quest_id"));
                quest.SetPreReqQuestId(results.getInt("pre_req_quest_id"));
                quest.SetConflictId(results.getInt("conflict_id"));
                quest.SetMinCharacterLevel(results.getInt("min_chartacter_level"));
                quest.SetQuestName(results.getString("quest_name"));
                quest.SetQuestDescription(results.getString("quest_description"));
                quest.SetQuestArcType(results.getString("quest_arc_type"));
                quest.SetQuestGiverDialog(results.getString("quest_giver_dialog"));
                quest.SetQuestReceiverDialog(results.getString("quest_receiver_dialog"));
                quest.SetIdInConflict(results.getInt("id_in_conflict"));
                quest.SetPreReqIdInConflict(results.getInt("pre_req_id_in_conflict"));
                quests.add(quest);
            }
        } catch (Exception e) {
        	System.err.println(e.getMessage());
        }
        finally {
        	conn.close();
        }
        return quests;
    }*/
	
	/**
	 * Returns Quest by quest Id.
	 * @param Quest ID
	 * @return The Quest looked up
	 * @throws SQLException
	 */
	public Quest GetQuestByID(int questId) throws SQLException {
		Quest quest = null;
        try {
            this.conn = this.sqlAccess.GetDBConnection();
            Statement statement = this.conn.createStatement();
            String query = "SELECT * FROM " + this.sqlAccess.GetTheDBName() + ".quests "
            		+ "WHERE " + this.sqlAccess.GetTheDBName() + ".quests.quest_id = \"" + questId + "\"";
            ResultSet results = statement.executeQuery(query);
            if (results.next() != false) {
            	quest = new Quest();
            	quest.SetQuestReceiverNpcId(results.getInt("quest_receiver_npc_id"));
                quest.SetQuestGiverNpcId(results.getInt("quest_giver_npc_id"));
                quest.SetQuestId(results.getInt("quest_id"));
                quest.SetPreReqQuestId(results.getInt("pre_req_quest_id"));
                quest.SetConflictId(results.getInt("conflict_id"));
                quest.SetMinCharacterLevel(results.getInt("min_chartacter_level"));
                quest.SetQuestName(results.getString("quest_name"));
                quest.SetQuestDescription(results.getString("quest_description"));
                quest.SetQuestArcType(results.getString("quest_arc_type"));
                quest.SetQuestGiverDialog(results.getString("quest_giver_dialog"));
                quest.SetQuestReceiverDialog(results.getString("quest_receiver_dialog"));
                quest.SetIdInConflict(results.getInt("id_in_conflict"));
                quest.SetPreReqIdInConflict(results.getInt("pre_req_id_in_conflict"));
            }
        } catch (Exception e) {
        	System.err.println(e.getMessage());
        }
        finally {
        	conn.close();
        }
        return quest;
    }
	
	/**
	 * Returns Quests by conflictId.
	 * @param conflictId
	 * @return The Quests looked up
	 * @throws SQLException
	 */
	public ArrayList<Quest> GetQuestByConflictId(int conflictId) throws SQLException {
    	ArrayList<Quest> quests = new ArrayList<Quest>();
        try {
            this.conn = this.sqlAccess.GetDBConnection();
            Statement statement = this.conn.createStatement();
            String query = "SELECT * FROM " + this.sqlAccess.GetTheDBName() + ".quests "
            		+ "WHERE " + this.sqlAccess.GetTheDBName() + ".quests.conflict_id = \"" + conflictId + "\"";
            ResultSet results = statement.executeQuery(query);
            while (results.next() != false) {
            	Quest quest = new Quest();
            	quest.SetQuestReceiverNpcId(results.getInt("quest_receiver_npc_id"));
                quest.SetQuestGiverNpcId(results.getInt("quest_giver_npc_id"));
                quest.SetQuestId(results.getInt("quest_id"));
                quest.SetPreReqQuestId(results.getInt("pre_req_quest_id"));
                quest.SetConflictId(results.getInt("conflict_id"));
                quest.SetMinCharacterLevel(results.getInt("min_chartacter_level"));
                quest.SetQuestName(results.getString("quest_name"));
                quest.SetQuestDescription(results.getString("quest_description"));
                quest.SetQuestArcType(results.getString("quest_arc_type"));
                quest.SetQuestGiverDialog(results.getString("quest_giver_dialog"));
                quest.SetQuestReceiverDialog(results.getString("quest_receiver_dialog"));
                quest.SetIdInConflict(results.getInt("id_in_conflict"));
                quest.SetPreReqIdInConflict(results.getInt("pre_req_id_in_conflict"));
                quests.add(quest);
            }
        } catch (Exception e) {
        	System.err.println(e.getMessage());
        }
        finally {
        	conn.close();
        }
        return quests;
    }
	
	/**
	 * Returns Quest by quest name.
	 * @param Quest name
	 * @return The Quest looked up
	 * @throws SQLException
	 */
	public Quest GetQuestByName(String questName) throws SQLException {
    	Quest quest = null;
        try {
            this.conn = this.sqlAccess.GetDBConnection();
            Statement statement = this.conn.createStatement();
            String query = "SELECT * FROM " + this.sqlAccess.GetTheDBName() + ".quests "
            		+ "WHERE " + this.sqlAccess.GetTheDBName() + ".quests.quest_name = \"" + questName + "\"";
            ResultSet results = statement.executeQuery(query);
            if (results.next() != false) {
            	quest = new Quest();
            	quest.SetQuestReceiverNpcId(results.getInt("quest_receiver_npc_id"));
                quest.SetQuestGiverNpcId(results.getInt("quest_giver_npc_id"));
                quest.SetQuestId(results.getInt("quest_id"));
                quest.SetPreReqQuestId(results.getInt("pre_req_quest_id"));
                quest.SetConflictId(results.getInt("conflict_id"));
                quest.SetMinCharacterLevel(results.getInt("min_chartacter_level"));
                quest.SetQuestName(results.getString("quest_name"));
                quest.SetQuestDescription(results.getString("quest_description"));
                quest.SetQuestArcType(results.getString("quest_arc_type"));
                quest.SetQuestGiverDialog(results.getString("quest_giver_dialog"));
                quest.SetQuestReceiverDialog(results.getString("quest_receiver_dialog"));
                quest.SetIdInConflict(results.getInt("id_in_conflict"));
                quest.SetPreReqIdInConflict(results.getInt("pre_req_id_in_conflict"));
            }
        } catch (Exception e) {
        	System.err.println(e.getMessage());
        }
        finally {
        	conn.close();
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
	public Boolean UpdateQuest(Quest quest, int questReceiverNpcId, int questGiverNpcId,
							int preReqQuestId, int conflictId, int minCharacterLevel, 
							String questName, String questDescription, String questArcType, 
							String questGiverDialog, String questReceiverDialog, int idInConflict,
							int preReqIdInConflict) throws SQLException {	
		Boolean success = false;
		try {
			this.conn = this.sqlAccess.GetDBConnection();
			System.out.println(quest.GetQuestId());
			String query = "UPDATE " + this.sqlAccess.GetTheDBName() + ".quests " + 
					"SET quest_receiver_npc_id = ?, " +
					"quest_giver_npc_id = ?, " +
					"pre_req_quest_id = ?, " +
					"conflict_id = ?, " +
					"min_chartacter_level = ?, " +
					"quest_name = ?, " +
					"quest_description = ?, " +
					"quest_arc_type = ?, " +
					"quest_giver_dialog = ?, " +
					"quest_receiver_dialog = ?, " +
					"id_in_conflict = ?, " +
					"pre_req_id_in_conflict = ? " +  
					"WHERE quest_id = ?";		
							
			 PreparedStatement preparedStmt = conn.prepareStatement(query);
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
			 preparedStmt.setString (13, String.valueOf(quest.GetQuestId()));
		     preparedStmt.execute();
		      success = true;
		} catch (Exception e) {
        	System.err.println(e.getMessage());
        }
        finally {
        	conn.close();
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
	public boolean DeleteQuest(Quest quest) throws SQLException {
		Boolean success = false;
		try {
			this.conn = this.sqlAccess.GetDBConnection();
			String query = "DELETE FROM " + this.sqlAccess.GetTheDBName() + ".quests " + 
					"WHERE quest_id = ?";
			PreparedStatement preparedStmt = conn.prepareStatement(query);
			preparedStmt.setString (1, String.valueOf(quest.GetQuestId()));
			
			preparedStmt.execute();
		      success = true;
		} catch (Exception e) {
        	System.err.println(e.getMessage());
        }
        finally {
        	conn.close();
        }
		return success;
	}

}
