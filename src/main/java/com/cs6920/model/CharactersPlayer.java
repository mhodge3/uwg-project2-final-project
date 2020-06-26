/**
 * 
 */
package com.cs6920.model;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.StringProperty;

/**
 * @author Ashley Palmer
 * @date 6/25/2020
 *
 */
public class CharactersPlayer {
	private IntegerProperty characterId;
	private IntegerProperty characterPlayerId;
	private StringProperty characterName;
	private IntegerProperty characterType;
	private IntegerProperty characterFaction;
	private DoubleProperty npcPosX;
	private DoubleProperty npcPosY;
	private DoubleProperty npcPosZ;
	
	/**
	 * Gets the characterId
	 * @return characterId
	 */
	public int GetCharacterId() {
		return characterId.get();
	}
	
	/**
	 * Gets the characterId property
	 * @return Property for TableView
	 */
	public final IntegerProperty CharacterIdProperty() {
	   return characterId;
	}
	
	
	/**
	 * Sets the characterId
	 * @param setCharacterId
	 */
	public void SetCharacterId(int setCharacterId) {
		this.characterId = new SimpleIntegerProperty(setCharacterId);
	}
	
	/**
	 * Gets the characterPlayerId
	 * @return characterPlayerId
	 */
	public int GetCharacterPlayerId() {
		return characterPlayerId.get();
	}
	
	/**
	 * Gets the characterPlayerId property
	 * @return Property for TableView
	 */
	public final IntegerProperty CharacterPlayerIdProperty() {
	   return characterPlayerId;
	}
	
	
	/**
	 * Sets the characterPlayerId
	 * @param setCharacterPlayerId
	 */
	public void SetCharacterPlayerId(int setPlayerCharacterId) {
		this.characterPlayerId = new SimpleIntegerProperty(setPlayerCharacterId);
	}
	
	

}
