/**
 * 
 */
package com.cs6920.control.logic_control;

import java.sql.SQLException;

import com.cs6920.DAL.MySQLAccess;

import com.cs6920.DAL.GameStoryDAL;

/**
 * @author Ashley Palmmer
 * @date 6/28/2020
 *
 */
public class CreateGameStoryControl {
	private GameStoryDAL theGameStoryDAL;
	
	/**
	 * Constructor that sets DAL to the current DBConnection class instance
	 * @param theDBConnection
	 */
	public CreateGameStoryControl(MySQLAccess theDBConnection) {
		this.theGameStoryDAL = new GameStoryDAL(theDBConnection);
	}
	
	/**
	 * Uses the DAL to create the new Game Story entry in the DB
	 * @param gameStoryName
	 * @param gameStorySummary
	 * @return String, message for user on outcome of operation
	 * @throws SQLException
	 */
	public String createGameStory(String gameStoryName, String gameStorySummary) throws SQLException {
		if (gameStoryName == null || gameStoryName.trim().length() == 0) {
			return "The Item Name cannot be empty";
		}
		else if (gameStoryName == null || gameStorySummary.trim().length() == 0) {
			return "The Item Description cannot be empty";
		}
		
		if (theGameStoryDAL.createGameStory(gameStoryName, gameStorySummary)) {
			return null;
		}
		else {
			return "There was a problem creating the Item";
		}
	}

}
