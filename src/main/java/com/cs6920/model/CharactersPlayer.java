/**
 * 
 */
package com.cs6920.model;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
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
	private DoubleProperty characterPosX;
	private DoubleProperty characterPosY;
	private DoubleProperty characterPosZ;
	
	/**
	 * Constructor for testing
	 */
	public CharactersPlayer() {
		
	}
	
	/**
	 * Constructor for CharactersPlayer
	 * @param characterId
	 * @param characterPlayerId
	 * @param characterName
	 * @param characterType
	 * @param characterFaction
	 * @param characterPosX
	 * @param characterPosY
	 * @param characterPosZ
	 */
	public CharactersPlayer(int characterId, int characterPlayerId, String characterName, int characterType, int characterFaction, double characterPosX, double characterPosY, double characterPosZ) {
		this.characterId = new SimpleIntegerProperty(characterId);
		this.characterPlayerId = new SimpleIntegerProperty(characterPlayerId);
		this.characterName = new SimpleStringProperty(characterName);
		this.characterType = new SimpleIntegerProperty(characterType);
		this.characterFaction = new SimpleIntegerProperty(characterFaction);
		this.characterPosX = new SimpleDoubleProperty(characterPosX);
		this.characterPosY = new SimpleDoubleProperty(characterPosY);
		this.characterPosZ = new SimpleDoubleProperty(characterPosZ);
		
	}
	
	/**
	 * Gets the characterId
	 * @return characterId
	 */
	public int getCharacterId() {
		return this.characterId.get();
	}
	
	/**
	 * Gets the characterId property
	 * @return Property for TableView
	 */
	public final IntegerProperty characterIdProperty() {
	   return this.characterId;
	}
	
	
	/**
	 * Sets the characterId
	 * @param setCharacterId
	 */
	public void setCharacterId(int setCharacterId) {
		this.characterId = new SimpleIntegerProperty(setCharacterId);
	}
	
	/**
	 * Gets the characterPlayerId
	 * @return characterPlayerId
	 */
	public int getCharacterPlayerId() {
		return this.characterPlayerId.get();
	}
	
	/**
	 * Gets the characterPlayerId property
	 * @return Property for TableView
	 */
	public final IntegerProperty characterPlayerIdProperty() {
	   return this.characterPlayerId;
	}
	
	
	/**
	 * Sets the characterPlayerId
	 * @param setCharacterPlayerId
	 */
	public void setCharacterPlayerId(int setPlayerCharacterId) {
		this.characterPlayerId = new SimpleIntegerProperty(setPlayerCharacterId);
	}
	
	/**
	 * Gets the characterName
	 * @return characterName
	 */
	public String getCharacterName() {
		return this.characterName.get();
	}
	
	/**
	 * Gets the characterName property
	 * @return Property for TableView
	 */
	public final StringProperty characterNameProperty() {
	   return this.characterName;
	}
	
	
	/**
	 * Sets the characterName
	 * @param setCharacterName
	 */
	public void setCharacterName(String setCharacterName) {
		this.characterName = new SimpleStringProperty(setCharacterName);
	}
	
	/**
	 * Gets the characterType
	 * @return characterType
	 */
	public int getCharacterType() {
		return this.characterType.get();
	}
	
	/**
	 * Sets the characterType
	 * @param setCharacterType
	 */
	public void setCharacterType(int setCharacterType) {
		this.characterType = new SimpleIntegerProperty(setCharacterType);
	}
	
	/**
	 * Gets the characterType property
	 * @return Property for TableView
	 */
	public final IntegerProperty characterTypeProperty() {
	   return this.characterType;
	}
	
	/**
	 * Gets the characterFaction
	 * @return characterFaction
	 */
	public int getCharacterFaction() {
		return this.characterFaction.get();
	}
	
	/**
	 * Sets the characterFaction
	 * @param setCharacterFaction
	 */
	public void setCharacterFaction(int setCharacterFaction) {
		this.characterFaction= new SimpleIntegerProperty(setCharacterFaction);
	}
	
	/**
	 * Gets the characterFaction property
	 * @return Property for TableView
	 */
	public final IntegerProperty characterFactionProperty() {
	   return this.characterFaction;
	}
	
	/**
	 * Gets the characterPosX
	 * @return characterPosX
	 */
	public double getCharacterPosX() {
		return this.characterPosX.get();
	}
	
	/**
	 * Sets the CharacterPosX
	 * @param setCharacterPosX
	 */
	public void setCharacterPosX(double setCharacterPosX) {
		this.characterPosX = new SimpleDoubleProperty(setCharacterPosX);
	}
	
	/**
	 * Gets the CharacterPosX property
	 * @return Property for TableView
	 */
	public final DoubleProperty CharacterPosXProperty() {
	   return this.characterPosX;
	}
	
	/**
	 * Gets the  haracterPosY
	 * @return CharacterPosY
	 */
	public double getCharacterPosY() {
		return this.characterPosY.get();
	}
		
	/**
	 * Sets the CharacterPosY
	 * @param setCharacterPosY
	 */
	public void setCharacterPosY(double setCharacterPosY) {
		this.characterPosY = new SimpleDoubleProperty(setCharacterPosY);
	}
	
	/**
	 * Gets the CharacterPosY property
	 * @return Property for TableView
	 */
	public final DoubleProperty characterPosYProperty() {
	   return this.characterPosY;
	}
	
	/**
	 * Gets the CharacterPosZ
	 * @return CharacterPosZ
	 */
	public double getCharacterPosZ() {
		return this.characterPosZ.get();
	}
	
	/**
	 * Sets the CharacterPosZ
	 * @param setCharacterPosZ
	 */
	public void setCharacterPosZ(double setCharacterPosZ) {
		this.characterPosZ = new SimpleDoubleProperty(setCharacterPosZ);
	}
	
	/**
	 * Gets the characterPosZ property
	 * @return Property for TableView
	 */
	public final DoubleProperty characterPosZProperty() {
	   return this.characterPosZ;
	}

}
