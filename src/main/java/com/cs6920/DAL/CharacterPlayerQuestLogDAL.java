package com.cs6920.DAL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.cs6920.model.CharacterPlayerQuestLog;

/**
 * Data access layer for the characterplayerquestlog database table
 * @author Perry Iler
 * @date 6/27/2020
 *
 */
public class CharacterPlayerQuestLogDAL {
	private MySQLAccess sqlAccess;
	private Connection theConnection;
	
	/**
	 * Creates a CharacterPlayerQuestLogDAL object to be used by the controllers
	 */
	public CharacterPlayerQuestLogDAL(MySQLAccess theDBConnection) {
		this.sqlAccess = theDBConnection;
	}
	
	/**
	 * Creates a characterPlayerQuestLog entry in the database CharacterPlayerQuestLogDAL table
	 * @param characterId
	 * @param questId
	 * @param questStatus
	 * @return True if inserted | False if not inserted
	 * @throws SQLException
	 */
	public Boolean createCharacterPlayerQuestLog(int characterId, int questId, int questStatus) throws SQLException {
		Boolean success = false;
		try {
			this.theConnection = this.sqlAccess.getDBConnection();
			String query = "INSERT INTO " + this.sqlAccess.getTheDBName() + ".characterplayerquestlog " + 
					"(quest_id, " +
					"character_id, " +
					"quest_status) " +
					"VALUES (?, ?, ?)";
							
			 PreparedStatement preparedStmt = theConnection.prepareStatement(query);
			 preparedStmt.setString (1, String.valueOf(questId));
			 preparedStmt.setString (2, String.valueOf(characterId));
			 preparedStmt.setString (3, String.valueOf(questStatus));
			  
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
	 * Returns characterPlayerQuestLog by questID
	 * 
	 * @param QuestId
	 * @return The characterPlayerQuestLog looked up
	 * @throws SQLException
	 */
	public CharacterPlayerQuestLog getCharacterPlayerQuestLogByQuestId(int QuestId) throws SQLException {
		CharacterPlayerQuestLog questLog = null;
        try {
            this.theConnection = this.sqlAccess.getDBConnection();
            Statement statement = this.theConnection.createStatement();
            String query = "SELECT * FROM " + this.sqlAccess.getTheDBName() + ".characterplayerquestlog "
            		+ "WHERE " + this.sqlAccess.getTheDBName() + ".characterplayerquestlog.quest_id = " + QuestId + ";";
            ResultSet results = statement.executeQuery(query);
            if (results.next() != false) {
            	questLog = new CharacterPlayerQuestLog();
                questLog.setQuestId(results.getInt("quest_id"));
                questLog.setCharacterId(results.getInt("character_id"));
                questLog.setQuestStatus(results.getInt("quest_status"));
            }
        } catch (Exception e) {
        	System.err.println(e.getMessage());
        }
        finally {
        	theConnection.close();
        }
        return questLog;
    }
	
	/**
	 * Returns characterPlayerQuestLog by characterID
	 * 
	 * @param QuestId
	 * @return The characterPlayerQuestLog looked up
	 * @throws SQLException
	 */
	public CharacterPlayerQuestLog getCharacterPlayerQuestLogByCharacterId(int characterID) throws SQLException {
		CharacterPlayerQuestLog questLog = null;
        try {
            this.theConnection = this.sqlAccess.getDBConnection();
            Statement statement = this.theConnection.createStatement();
            String query = "SELECT * FROM " + this.sqlAccess.getTheDBName() + ".characterplayerquestlog "
            		+ "WHERE " + this.sqlAccess.getTheDBName() + ".characterplayerquestlog.character_id = " + characterID + ";";
            ResultSet results = statement.executeQuery(query);
            if (results.next() != false) {
            	questLog = new CharacterPlayerQuestLog();
                questLog.setQuestId(results.getInt("quest_id"));
                questLog.setCharacterId(results.getInt("character_id"));
                questLog.setQuestStatus(results.getInt("quest_status"));
            }
        } catch (Exception e) {
        	System.err.println(e.getMessage());
        }
        finally {
        	theConnection.close();
        }
        return questLog;
    }
	
	/**
	 * Updates a characterPlayerQuestLog entry in the database CharacterPlayerQuestLogDAL table
	 * @param characterId
	 * @param questId
	 * @param questStatus
	 * @return True if updated | False if not updated
	 * @throws SQLException
	 */
	public Boolean updateCharacterPlayerQuestLogStatus(CharacterPlayerQuestLog log, int updatedStatus) throws SQLException {
		Boolean success = false;
		try {
			this.theConnection = this.sqlAccess.getDBConnection();
			String query = "UPDATE " + this.sqlAccess.getTheDBName() + ".characterplayerquestlog " + 
					"SET " +
					"quest_status = ? " +
					"WHERE quest_id = ?";
							
			 PreparedStatement preparedStmt = theConnection.prepareStatement(query);
			 preparedStmt.setString (1, String.valueOf(updatedStatus));
			 preparedStmt.setString (2, String.valueOf(log.getQuestId()));
			  
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
	 * Deletes an existing log entry in the database CharacterPlayerQuestLogDAL table
	 * @param log The CharacterPlayerQuestLog to be deleted
	 * @return True if deleted | False if not deleted
	 * @throws SQLException
	 */
	public boolean deleteCharacterPlayerQuestLog(CharacterPlayerQuestLog log) throws SQLException {
		Boolean success = false;
		try {
			this.theConnection = this.sqlAccess.getDBConnection();
			String query = "DELETE FROM " + this.sqlAccess.getTheDBName() + ".characterplayerquestlog " + 
					"WHERE quest_id = ?";
			PreparedStatement preparedStmt = theConnection.prepareStatement(query);
			preparedStmt.setString (1, String.valueOf(log.getQuestId()));
			
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
