/**
 * 
 */
package com.cs6920.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * @author Ashley Palmer
 * @date 6/25/2020
 *
 */
public class GameStory {
	
	
	private StringProperty gameStoryName;
	private StringProperty gameStorySummary;
	
	/**
	 * Gets the gameStorn Name
	 * @return gameStoryName
	 */
	public String GetGameStoryName() {
		return gameStoryName.get();
	}
	
	/**
	 * Gets the game story name property
	 * @return Property for TableView
	 */
	public final StringProperty GameStoryNameProperty() {
	   return gameStoryName;
	}
	
	/**
	 * Sets the gameStoryName
	 * @param gameStoryName
	 */
	public void SetGameStoryName(String gameStoryName) {
		this.gameStoryName = new SimpleStringProperty(gameStoryName);
	}

}
