/**
 * 
 */
package com.cs6920.control.logic_control;

import java.sql.SQLException;

import com.cs6920.DAL.GameStoryDAL;
import com.cs6920.DAL.MySQLAccess;
import com.cs6920.model.GameStory;

/**
 * @author Ashley Palmer
 * @date 6/27/2020
 *
 */
public class EditGameStoryControl {
	
	private GameStoryDAL gameStoryDAL;
	private GameStory selectedGameStory;
	
	/**
	 * Constructor that sets DAL to the current DBConnection class instance
	 * @param theDBConnection
	 * @throws SQLException 
	 */
	public EditGameStoryControl(MySQLAccess theDBConnection) throws SQLException {
		this.gameStoryDAL = new GameStoryDAL(theDBConnection);
		this.getGameStoryFromDB();
	}
	
	private void getGameStoryFromDB() throws SQLException {
		this.selectedGameStory = this.gameStoryDAL.GetGameStory();
	}
	
	public GameStory getGameStoryToEdit() {
		return this.selectedGameStory;
	}
	
	/**
	 * Update the current GameStory in the DB
	 * @param gameStoryName
	 * @param gameStorySummary
	 * @return String, message for user on outcome of operation
	 * @throws SQLException
	 */
	public String UpdateGameStory(String gameStoryName, String gameStorySummary) throws SQLException {
		if (gameStoryName == null || gameStoryName.trim().length() == 0) {
			return "The Game Story cannot be empty";
		}
		else if (gameStorySummary == null || gameStorySummary.trim().length() == 0) {
			return "The Game Story Summary cannot be empty";
		}
		
		if (gameStoryDAL.UpdateGameStory(selectedGameStory, new GameStory(gameStoryName, gameStorySummary))) {
			this.getGameStoryFromDB();
			return null;
		}
		else {
			return "There was a problem updating the Game Story";
		}
	}

}
