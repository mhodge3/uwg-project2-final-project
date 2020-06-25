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
	 * Test Constructor not used.
	 */
	public GameStory() {
		
	}
	
	/**
	 * Constructor for GameStory
	 * @param gameStoryName
	 * @param gameStorySummary
	 */
	public GameStory(String gameStoryName, String gameStorySummary) {
		this.gameStoryName = new SimpleStringProperty(gameStoryName);
		this.gameStorySummary = new SimpleStringProperty(gameStorySummary);
	}
	
	/**
	 * Gets the gameStory Name
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
	
	/**
	 * Gets the gameStorySummary Name
	 * @return gameStoryName
	 */
	public String GetGameStorySummaryName() {
		return gameStorySummary.get();
	}
	
	/**
	 * Gets the gameStorySummary property
	 * @return Property for TableView
	 */
	public final StringProperty GameStorySummaryProperty() {
	   return gameStorySummary;
	}
	
	/**
	 * Sets the gameStorySummary
	 * @param gameStoryName
	 */
	public void SetGameStorySummary(String gameStorySummary) {
		this.gameStorySummary = new SimpleStringProperty(gameStorySummary);
	}

}
