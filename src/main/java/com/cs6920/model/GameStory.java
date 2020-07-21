/**
 * 
 */
package com.cs6920.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
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
	private IntegerProperty playerLevelCap;
	private IntegerProperty npcCharacterLevelCap;
	
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
	public GameStory(String gameStoryName, String gameStorySummary, int playerLevelCap, int npcCharacterLevelCap) {
		this.gameStoryName = new SimpleStringProperty(gameStoryName);
		this.gameStorySummary = new SimpleStringProperty(gameStorySummary);
		this.playerLevelCap = new SimpleIntegerProperty(playerLevelCap);
		this.npcCharacterLevelCap = new SimpleIntegerProperty(npcCharacterLevelCap);
		
	}
	
	/**
	 * Gets the gameStory Name
	 * @return gameStoryName
	 */
	public String getGameStoryName() {
		return this.gameStoryName.get();
	}
	
	/**
	 * Gets the game story name property
	 * @return Property for TableView
	 */
	public final StringProperty gameStoryNameProperty() {
	   return this.gameStoryName;
	}
	
	/**
	 * Sets the gameStoryName
	 * @param gameStoryName
	 */
	public void setGameStoryName(String gameStoryName) {
		this.gameStoryName = new SimpleStringProperty(gameStoryName);
	}
	
	/**
	 * Gets the gameStorySummary Name
	 * @return gameStoryName
	 */
	public String getGameStorySummary() {
		return this.gameStorySummary.get();
	}
	
	/**
	 * Gets the gameStorySummary property
	 * @return Property for TableView
	 */
	public final StringProperty gameStorySummaryProperty() {
	   return this.gameStorySummary;
	}
	
	/**
	 * Sets the gameStorySummary
	 * @param gameStoryName
	 */
	public void setGameStorySummary(String gameStorySummary) {
		this.gameStorySummary = new SimpleStringProperty(gameStorySummary);
	}
	
	/**
	 * Gets the playerLevelCap Name
	 * @return playerLevelCap
	 */
	public int getPlayerLevelCap() {
		return this.playerLevelCap.get();
	}
	
	/**
	 * Gets the playerLevelCap property
	 * @return Property for TableView
	 */
	public final IntegerProperty playerLevelCapProperty() {
	   return this.playerLevelCap;
	}
	
	/**
	 * Sets the playerLevelCap
	 * @param playerLevelCap
	 */
	public void setPlayerLevelCap(int playerLevelCap) {
		this.playerLevelCap = new SimpleIntegerProperty(playerLevelCap);
	}
	
	/**
	 * Gets the npcCharacterLevelCap
	 * @return npcCharacterLevelCap
	 */
	public int getNpcCharacterLevelCap() {
		return this.npcCharacterLevelCap.get();
	}
	
	/**
	 * Gets the playerLevelCap property
	 * @return Property for TableView
	 */
	public final IntegerProperty npcCharacterLevelCapProperty() {
	   return this.npcCharacterLevelCap;
	}
	
	/**
	 * Sets the npcCharacterLevelCap
	 * @param npcCharacterLevelCap
	 */
	public void setNpcCharacterLevelCap(int setNpcCharacterLevelCap) {
		this.npcCharacterLevelCap = new SimpleIntegerProperty(setNpcCharacterLevelCap);
	}

}
