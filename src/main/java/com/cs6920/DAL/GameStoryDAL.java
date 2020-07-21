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
	private Connection theConnection;
	
	public GameStoryDAL(MySQLAccess theDBConnection) {
		this.sqlAccess = theDBConnection;
	}
	
	/**
	 * Get GameStory first (and should be only) GameStory
	 * @return The Game Story
	 * @throws SQLException
	 */
	public GameStory getGameStory() throws SQLException {
		GameStory story = null;
		
		try {
            this.theConnection = this.sqlAccess.getDBConnection();
            Statement statement = this.theConnection.createStatement();
            String query = "SELECT  * " + 
            		"FROM " + this.sqlAccess.getTheDBName() + ".gamestory;";
            ResultSet results = statement.executeQuery(query);
            if (results.next() != false) {
            	story = new GameStory();
                story.setGameStoryName(results.getString("game_story_name"));
                story.setGameStorySummary(results.getString("game_story_summary"));
                story.setPlayerLevelCap(Integer.parseInt(results.getString("player_character_level_cap")));
                story.setNpcCharacterLevelCap(Integer.parseInt(results.getString("npc_character_level_cap")));
            }
        } catch (Exception e) {
        	System.err.println(e.getMessage());
        }
        finally {
        	theConnection.close();
        }
		return story; 
	}
	
	/**
	 * Get GameStory by gameStoryName from the database GameStory table
	 * @return The Game Story
	 * @throws SQLException
	 */
	public GameStory getGameStoryByName(String gameStoryName) throws SQLException {
		GameStory story = null;
		
		try {
            this.theConnection = this.sqlAccess.getDBConnection();
            Statement statement = this.theConnection.createStatement();
            String query = "SELECT  * " +  
            		"FROM " + this.sqlAccess.getTheDBName() + ".gamestory " +
            		"WHERE game_story_name = \"" + gameStoryName + "\"";
            ResultSet results = statement.executeQuery(query);
            if (results.next() != false) {
            	story = new GameStory();
                story.setGameStoryName(results.getString("game_story_name"));
                story.setGameStoryName(results.getString("game_story_summary"));
                story.setPlayerLevelCap(Integer.parseInt(results.getString("player_character_level_cap")));
                story.setNpcCharacterLevelCap(Integer.parseInt(results.getString("npc_character_level_cap")));
            }
        } catch (Exception e) {
        	System.err.println(e.getMessage());
        }
        finally {
        	theConnection.close();
        }
		return story; 
	}
	
	/**
	 * Deletes the GameStory
	 * @param story
	 * @return success
	 * @throws SQLException
	 */
	public boolean deleteGameStory(GameStory story) throws SQLException {
		Boolean success = false;
		try {
			this.theConnection = this.sqlAccess.getDBConnection();
			String query = "DELETE FROM " + this.sqlAccess.getTheDBName() + ".gamestory " + 
					"WHERE game_story_name = ?";
			PreparedStatement preparedStmt = theConnection.prepareStatement(query);
			preparedStmt.setString (1, String.valueOf(story.getGameStoryName()));
			
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
	 * Updates Game Story Name
	 * @param oldGameStory
	 * @param updatedGameStory
	 * @return success
	 * @throws SQLException
	 */
	public Boolean updateGameStory(GameStory oldGameStory, GameStory updatedGameStory) throws SQLException {
		Boolean success = false;
		try {
			this.theConnection = this.sqlAccess.getDBConnection();
			String query = "UPDATE " + this.sqlAccess.getTheDBName() + ".gamestory " + 
					"SET " +
					"game_story_name = ?, " + 
            		"game_story_summary = ?, " + 
            		"player_character_level_cap = ?, " + 
            		"npc_character_level_cap = ? " + 
            	    "WHERE game_story_name = ?";
		
			 PreparedStatement preparedStmt = theConnection.prepareStatement(query);
			  preparedStmt.setString (1, updatedGameStory.getGameStoryName());
			  preparedStmt.setString (2, updatedGameStory.getGameStorySummary());
			  preparedStmt.setString (3, String.valueOf(updatedGameStory.getPlayerLevelCap()));
			  preparedStmt.setString (4, String.valueOf(updatedGameStory.getNpcCharacterLevelCap()));
			  preparedStmt.setString (5, String.valueOf(oldGameStory.getGameStoryName()));
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
	 * Creates Game Story
	 * @param gameStoryName
	 * @param gameStorySummary
	 * @return
	 * @throws SQLException
	 */
	
	public Boolean createGameStory(String gameStoryName, String gameStorySummary) throws SQLException {
		Boolean success = false;
		try {
			this.theConnection = this.sqlAccess.getDBConnection();
			String query = "INSERT INTO " + this.sqlAccess.getTheDBName() + ".gamestory " + 
					"(game_story_name, " + 
            		"game_story_summar " + 
					"VALUES (?, ?)";
			 PreparedStatement preparedStmt = theConnection.prepareStatement(query);
			  preparedStmt.setString (1, gameStoryName);
			  preparedStmt.setString (2, gameStorySummary);
			  
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
