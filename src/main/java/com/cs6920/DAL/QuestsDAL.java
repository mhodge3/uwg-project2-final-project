package com.cs6920.DAL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
	 * @param preReqQuestId
	 * @param conflictId
	 * @param minCharacterLevel
	 * @param questName
	 * @param questDescription
	 * @param questArcType
	 * @return True if inserted | False if not inserted
	 * @throws SQLException 
	 */
	public Boolean CreateQuest(int preReqQuestId, int conflictId, int minCharacterLevel, String questName, String questDescription, String questArcType) throws SQLException {
		Boolean success = false;
		try {
			this.conn = this.sqlAccess.GetDBConnection();
			String query = "INSERT INTO " + this.sqlAccess.GetTheDBName() + ".quests " + 
							"(`pre_req_quest_id`, " +
							"confict_id, " +
							"`min_chartacter_level`, " +
							"`quest_name`, " +
							"`quest_description`, " +
							"`quest_arc_type`) " +
							"VALUES (?, ?, ?, ?, ?, ?)";
	
		
							
			 PreparedStatement preparedStmt = conn.prepareStatement(query);
			 
			 preparedStmt.setString (1, String.valueOf(preReqQuestId));
			 preparedStmt.setString (2, String.valueOf(conflictId));
			 preparedStmt.setString (3, String.valueOf(minCharacterLevel));
			 preparedStmt.setString (4, questName);
			 preparedStmt.setString (5, questDescription);
			 preparedStmt.setString (6, questArcType);
			 System.out.println(query); 
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
            		+ "WHERE " + this.sqlAccess.GetTheDBName() + ".quests.character_id = " + questId + ";";
            ResultSet results = statement.executeQuery(query);
            if (results.next() != false) {
            	quest = new Quest();
                quest.SetQuestId(results.getInt("quest_id"));
                quest.SetPreReqQuestId(results.getInt("pre_req_quest"));
                quest.SetConflictId(results.getInt("confict_id"));
                quest.SetMinCharacterLevel(results.getInt("minCharacterLevel"));
                quest.SetQuestName(results.getString("quest_name"));
                quest.SetQuestDescription(results.getString("quest_description"));
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
            		+ "WHERE " + this.sqlAccess.GetTheDBName() + ".quests.quest_name = " + questName + ";";
            ResultSet results = statement.executeQuery(query);
            if (results.next() != false) {
            	quest = new Quest();
                quest.SetQuestId(results.getInt("quest_id"));
                quest.SetPreReqQuestId(results.getInt("pre_req_quest"));
                quest.SetConflictId(results.getInt("confict_id"));
                quest.SetMinCharacterLevel(results.getInt("minCharacterLevel"));
                quest.SetQuestName(results.getString("quest_name"));
                quest.SetQuestDescription(results.getString("quest_description"));
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
	public Boolean UpdateQuest(int questId, int preReqQuestId, int conflictId, int minCharacterLevel, String questName, String questDescription, String questArcType) throws SQLException {
		Boolean success = false;
		try {
			this.conn = this.sqlAccess.GetDBConnection();
			String query = "UPDATE " + this.sqlAccess.GetTheDBName() + ".quests " + 
					"(pre_req_quest_id, " +
					"confict_id, " +
					"min_chartacter_level, " +
					"quest_name, " +
					"quest_description) " +
					"VALUES(?, ?, ?, ?, ?)";
							
			 PreparedStatement preparedStmt = conn.prepareStatement(query);
			 preparedStmt.setString (1, String.valueOf(preReqQuestId));
			 preparedStmt.setString (2, String.valueOf(conflictId));
			 preparedStmt.setString (3, String.valueOf(minCharacterLevel));
			 preparedStmt.setString (4, questName);
			 preparedStmt.setString (5, questDescription);
			  
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
