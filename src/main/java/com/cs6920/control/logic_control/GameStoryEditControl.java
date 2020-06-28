/**
 * 
 */
package com.cs6920.control.logic_control;

import java.sql.SQLException;

import com.cs6920.DAL.GameStoryDAL;
import com.cs6920.DAL.ItemDAL;
import com.cs6920.DAL.MySQLAccess;
import com.cs6920.model.GameStory;
import com.cs6920.model.Item;

/**
 * @author Ashley Palmer
 * @date 6/27/2020
 *
 */
public class GameStoryEditControl {
	
	private GameStoryDAL gameStoryDAL;
	private GameStory selectedGameStory;
	
	/**
	 * Constructor that sets DAL to the current DBConnection class instance
	 * @param theDBConnection
	 */
	public GameStoryEditControl(MySQLAccess theDBConnection) {
		this.gameStoryDAL = new GameStoryDAL(theDBConnection);
	}
	
	/**
	 * Sets an instance of the Item to that found by id
	 * @param itemId
	 */
	public void SetSelectedItem(String gameStoryName) {
		try {
			selectedGameStory = gameStoryDAL.GetGameStoryByName(gameStoryName);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Get the Item object for editing
	 * @return
	 */
	public GameStory GetSelectedItem() {
		return selectedGameStory;
	}
	
	/**
	 * Delete this GameStory from the DB
	 * @param gameStoryToDelete
	 * @return String, message for user on outcome of operation
	 */
	public String DeleteItem(GameStory gameStoryToDelete) {
		
		try {
			if (gameStoryDAL.DeleteGameStory(gameStoryToDelete)) {
				return null;
			}
			else {
				return "There was a problem deleting the Item";
			}
		} catch (SQLException e) {
			return "There was a problem deleting the Item from the database";
		}
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
		
		if (gameStoryDAL.UpdateGameStory(selectedGameStory, new GameStory(selectedGameStory.GetGameStoryName(),gameStorySummary))) {
			return null;
		}
		else {
			return "There was a problem updating the Game Story";
		}
	}

}
