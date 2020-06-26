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
	
	/**
	 * Gets the characterName
	 * @return characterName
	 */
	public String GetCharacterName() {
		return characterName.get();
	}
	
	/**
	 * Gets the characterName property
	 * @return Property for TableView
	 */
	public final StringProperty CharacterNameProperty() {
	   return characterName;
	}
	
	
	/**
	 * Sets the characterName
	 * @param setCharacterName
	 */
	public void CharacterName(String setCharacterName) {
		this.characterName = new SimpleStringProperty(setCharacterName);
	}
	
	/**
	 * Gets the characterType
	 * @return characterType
	 */
	public int GetCharacterType() {
		return characterType.get();
	}
	
	/**
	 * Sets the characterType
	 * @param setCharacterType
	 */
	public void SetCharacterType(int setCharacterType) {
		this.characterType = new SimpleIntegerProperty(setCharacterType);
	}
	
	/**
	 * Gets the characterType property
	 * @return Property for TableView
	 */
	public final IntegerProperty CharacterTypeProperty() {
	   return characterType;
	}
	
	/**
	 * Gets the characterFaction
	 * @return characterFaction
	 */
	public int GetCharacterFaction() {
		return characterFaction.get();
	}
	
	/**
	 * Sets the characterFaction
	 * @param setCharacterFaction
	 */
	public void SetCharacterFaction(int setCharacterFaction) {
		this.characterFaction= new SimpleIntegerProperty(setCharacterFaction);
	}
	
	/**
	 * Gets the characterFaction property
	 * @return Property for TableView
	 */
	public final IntegerProperty CharacterFactionProperty() {
	   return characterFaction;
	}
	
	/**
	 * Gets the characterPosX
	 * @return characterPosX
	 */
	public double GetCharacterPosX() {
		return characterPosX.get();
	}
	
	/**
	 * Sets the CharacterPosX
	 * @param setCharacterPosX
	 */
	public void SetCharacterPosX(double setCharacterPosX) {
		this.characterPosX = new SimpleDoubleProperty(setCharacterPosX);
	}
	
	/**
	 * Gets the CharacterPosX property
	 * @return Property for TableView
	 */
	public final DoubleProperty CharacterPosXProperty() {
	   return characterPosX;
	}
	
	/**
	 * Gets the  haracterPosY
	 * @return CharacterPosY
	 */
	public double GetCharacterPosY() {
		return characterPosY.get();
	}
		
	/**
	 * Sets the CharacterPosY
	 * @param setCharacterPosY
	 */
	public void SetCharacterPosY(double setCharacterPosY) {
		this.characterPosY = new SimpleDoubleProperty(setCharacterPosY);
	}
	
	/**
	 * Gets the CharacterPosY property
	 * @return Property for TableView
	 */
	public final DoubleProperty CharacterPosYProperty() {
	   return characterPosY;
	}
	
	/**
	 * Gets the CharacterPosZ
	 * @return CharacterPosZ
	 */
	public double GetCharacterPosZ() {
		return characterPosZ.get();
	}
	
	/**
	 * Sets the CharacterPosZ
	 * @param setCharacterPosZ
	 */
	public void SetCharacterPosZ(double setCharacterPosZ) {
		this.characterPosZ = new SimpleDoubleProperty(setCharacterPosZ);
	}
	
	/**
	 * Gets the characterPosZ property
	 * @return Property for TableView
	 */
	public final DoubleProperty CharacterPosZProperty() {
	   return characterPosZ;
	}
	
	

}
