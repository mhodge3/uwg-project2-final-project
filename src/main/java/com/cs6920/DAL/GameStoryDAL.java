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
import com.cs6920.model.Item;

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
	 * Get GameStory by gameStoryName from the database GameStory table
	 * @return The Game Story
	 * @throws SQLException
	 */
	public GameStory GetGameStoryByName(String gameStoryName) throws SQLException {
		GameStory story = null;
		
		try {
            this.conn = this.sqlAccess.GetDBConnection();
            Statement statement = this.conn.createStatement();
            String query = "SELECT  game_story_name," + 
            		"game_story_summary " + 
            		"FROM " + this.sqlAccess.GetTheDBName() + ".gamestory " +
            		"WHERE game_story_name = \"" + gameStoryName + "\"";
            ResultSet results = statement.executeQuery(query);
            if (results.next() != false) {
            	story = new GameStory();
                story.SetGameStoryName(results.getString("game_story_name"));
                story.SetGameStoryName(results.getString("game_story_summary"));
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
            		"game_story_summary = ? " + 
            	    "WHERE game_story_name = ?";
		
			 PreparedStatement preparedStmt = conn.prepareStatement(query);
			  preparedStmt.setString (1, updatedGameStory.GetGameStoryName());
			  preparedStmt.setString (2, updatedGameStory.GetGameStorySummary());
			  preparedStmt.setString (3, String.valueOf(oldGameStory.GetGameStoryName()));
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
