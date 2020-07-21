/**
 * 
 */
package com.cs6920.DAL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.cs6920.model.GameStory;

/**
 * @author Ashley Palmer
 * 6/27/2020
 *
 */
public class GameStoryDAL {
	
	private MySQLAccess sqlAccess;
	private Connection conn;
	
	public GameStoryDAL(MySQLAccess theDBConnection) {
		this.sqlAccess = theDBConnection;
	}
	
	/**
	 * Get GameStory first (and should be only) GameStory
	 * @return The Game Story
	 * @throws SQLException
	 */
	public GameStory GetGameStory() throws SQLException {
		GameStory story = null;
		
		try {
            this.conn = this.sqlAccess.GetDBConnection();
            Statement statement = this.conn.createStatement();
            String query = "SELECT  * " + 
            		"FROM " + this.sqlAccess.GetTheDBName() + ".gamestory;";
            ResultSet results = statement.executeQuery(query);
            if (results.next() != false) {
            	story = new GameStory();
                story.SetGameStoryName(results.getString("game_story_name"));
                story.SetGameStorySummary(results.getString("game_story_summary"));
                story.SetPlayerLevelCap(Integer.parseInt(results.getString("player_character_level_cap")));
                story.SetNpcCharacterLevelCap(Integer.parseInt(results.getString("npc_character_level_cap")));
            }
        } catch (Exception e) {
        	System.err.println(e.getMessage());
        }
        finally {
        	conn.close();
        }
		return story; 
	}
	
	/**
	 * Get GameStory by gameStoryName from the database GameStory table
	 * @return The Game Story
	 * @throws SQLException
	 */
	public GameStory GetGameStoryByName(String gameStoryName) throws SQLException {
		GameStory story = null;
		
		try {
            this.conn = this.sqlAccess.GetDBConnection();
            Statement statement = this.conn.createStatement();
            String query = "SELECT  * " +  
            		"FROM " + this.sqlAccess.GetTheDBName() + ".gamestory " +
            		"WHERE game_story_name = \"" + gameStoryName + "\"";
            ResultSet results = statement.executeQuery(query);
            if (results.next() != false) {
            	story = new GameStory();
                story.SetGameStoryName(results.getString("game_story_name"));
                story.SetGameStoryName(results.getString("game_story_summary"));
                story.SetPlayerLevelCap(Integer.parseInt(results.getString("player_character_level_cap")));
                story.SetNpcCharacterLevelCap(Integer.parseInt(results.getString("npc_character_level_cap")));
            }
        } catch (Exception e) {
        	System.err.println(e.getMessage());
        }
        finally {
        	conn.close();
        }
		return story; 
	}
	
	/**
	 * Deletes the GameStory
	 * @param story
	 * @return success
	 * @throws SQLException
	 */
	public boolean DeleteGameStory(GameStory story) throws SQLException {
		Boolean success = false;
		try {
			this.conn = this.sqlAccess.GetDBConnection();
			String query = "DELETE FROM " + this.sqlAccess.GetTheDBName() + ".gamestory " + 
					"WHERE game_story_name = ?";
			PreparedStatement preparedStmt = conn.prepareStatement(query);
			preparedStmt.setString (1, String.valueOf(story.GetGameStoryName()));
			
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
	 * Updates Game Story Name
	 * @param oldGameStory
	 * @param updatedGameStory
	 * @return success
	 * @throws SQLException
	 */
	public Boolean UpdateGameStory(GameStory oldGameStory, GameStory updatedGameStory) throws SQLException {
		Boolean success = false;
		try {
			this.conn = this.sqlAccess.GetDBConnection();
			String query = "UPDATE " + this.sqlAccess.GetTheDBName() + ".gamestory " + 
					"SET " +
					"game_story_name = ?, " + 
            		"game_story_summary = ?, " + 
            		"player_character_level_cap = ?, " + 
            		"npc_character_level_cap = ? " + 
            	    "WHERE game_story_name = ?";
		
			 PreparedStatement preparedStmt = conn.prepareStatement(query);
			  preparedStmt.setString (1, updatedGameStory.GetGameStoryName());
			  preparedStmt.setString (2, updatedGameStory.GetGameStorySummary());
			  preparedStmt.setString (3, String.valueOf(updatedGameStory.GetPlayerLevelCap()));
			  preparedStmt.setString (4, String.valueOf(updatedGameStory.GetNpcCharacterLevelCap()));
			  preparedStmt.setString (5, String.valueOf(oldGameStory.GetGameStoryName()));
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
	 * Creates Game Story
	 * @param gameStoryName
	 * @param gameStorySummary
	 * @return
	 * @throws SQLException
	 */
	
	public Boolean CreateGameStory(String gameStoryName, String gameStorySummary) throws SQLException {
		Boolean success = false;
		try {
			this.conn = this.sqlAccess.GetDBConnection();
			String query = "INSERT INTO " + this.sqlAccess.GetTheDBName() + ".gamestory " + 
					"(game_story_name, " + 
            		"game_story_summar " + 
					"VALUES (?, ?)";
			 PreparedStatement preparedStmt = conn.prepareStatement(query);
			  preparedStmt.setString (1, gameStoryName);
			  preparedStmt.setString (2, gameStorySummary);
			  
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
