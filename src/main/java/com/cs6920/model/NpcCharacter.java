/**
 * 
 */
package com.cs6920.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.DoubleProperty;

/**
 * @author Ashley Palmer
 * @date 6/11/2020
 *
 */
public class NpcCharacter {
	private IntegerProperty npcId;
	private StringProperty npcDescprition;
	private StringProperty npcName;
	private IntegerProperty npcType;
	private IntegerProperty npcLevel;
	private IntegerProperty npcFaction;
	private DoubleProperty npcPosX;
	private DoubleProperty npcPosY;
	private DoubleProperty npcPosZ;
	
	/**
	 * Constructor used for testing.
	 */
	public NpcCharacter() {
		
	}
	
	/**
	 * Constructions the NpcCharacter
	 * @param npcId
	 * @param npcDescription
	 * @param npcName
	 * @param npcType
	 * @param npcFaction
	 * @param npcPosX
	 * @param npcPosY
	 * @param npcPosZ
	 */
	
	public NpcCharacter(int npcId, String npcDescription, String npcName, int npcType, int npcFaction, double npcPosX, double npcPosY, double npcPosZ, int npcLevel) {
		this.npcId = new SimpleIntegerProperty(npcId);
		this.npcDescprition = new SimpleStringProperty(npcDescription);
		this.npcName = new SimpleStringProperty(npcName);
		this.npcType = new SimpleIntegerProperty(npcType);
		this.npcFaction = new SimpleIntegerProperty(npcFaction);
		this.npcPosX = new SimpleDoubleProperty(npcPosX);
		this.npcPosY = new SimpleDoubleProperty(npcPosY);
		this.npcPosZ = new SimpleDoubleProperty(npcPosZ);
		this.npcLevel = new SimpleIntegerProperty(npcLevel);
		
	}
	
	/**
	 * Gets the npcId
	 * @return npcId
	 */
	public int getNpcId() {
		return this.npcId.get();
	}
	
	/**
	 * Sets the npcID
	 * @param setNpcId
	 */
	public void setNpcId(int setNpcId) {
		this.npcId = new SimpleIntegerProperty(setNpcId);
	}
	
	/**
	 * Gets the NpcID property
	 * @return Property for TableView
	 */
	public final IntegerProperty npcIdProperty() {
	   return this.npcId;
	}
	
	/**
	 * Gets the npcLevel
	 * @return npcId
	 */
	public int getNpcLevel() {
		return this.npcLevel.get();
	}
	
	/**
	 * Sets the npcLevel
	 * @param setNpcId
	 */
	public void setNpcLevel(int npcLevel) {
		this.npcLevel = new SimpleIntegerProperty(npcLevel);
	}
	
	/**
	 * Gets the npcLevel property
	 * @return Property for TableView
	 */
	public final IntegerProperty npcLevelProperty() {
	   return this.npcLevel;
	}
	
	/**
	 * GEts the npcDescprition
	 * @return npcDescprition
	 */
	public String getNpcDescprition() {
		return this.npcDescprition.get();
	}
	
	/**
	 * Sets the NpcDescprition
	 * @param setNpcDescprition
	 */
	public void setNpcDescprition(String setNpcDescprition) {
		this.npcDescprition = new SimpleStringProperty(setNpcDescprition);
	}
	
	/**
	 * Gets the NpcDescription property
	 * @return Property for TableView
	 */
	public final StringProperty npcDescriptionProperty() {
	   return this.npcDescprition;
	}
	
	/**
	 * Gets the npcName
	 * @return npcName
	 */
	public String getNpcName() {
		return this.npcName.get();
	}
	
	/**
	 * Sets the NpcName
	 * @param setNpcName
	 */
	public void setNpcName(String setNpcName) {
		this.npcName = new SimpleStringProperty(setNpcName);
	}
	
	/**
	 * Gets the NpcName property
	 * @return Property for TableView
	 */
	public final StringProperty npcNameProperty() {
	   return this.npcName;
	}
	
	
	/**
	 * Gets the npctype
	 * @return npcType
	 */
	public int getNpcType() {
		return this.npcType.get();
	}
	
	/**
	 * Sets the npc Type
	 * @param setNpcType
	 */
	public void setNpcType(int setNpcType) {
		this.npcType = new SimpleIntegerProperty(setNpcType);
	}
	
	/**
	 * Gets the NpcType property
	 * @return Property for TableView
	 */
	public final IntegerProperty npcTypeProperty() {
	   return this.npcType;
	}
	
	/**
	 * Gets the npcFaction
	 * @return npcFaction
	 */
	public int getNpcFaction() {
		return this.npcFaction.get();
	}
	
	/**
	 * Sets the npc Faction
	 * @param setNpcFaction
	 */
	public void setNpcFaction(int setNpcFaction) {
		this.npcFaction = new SimpleIntegerProperty(setNpcFaction);
	}
	
	/**
	 * Gets the NpcFaction property
	 * @return Property for TableView
	 */
	public final IntegerProperty npcFactionProperty() {
	   return this.npcFaction;
	}
	
	/**
	 * Gets the NpcPosX
	 * @return npcPosX
	 */
	public double getNpcPosX() {
		return this.npcPosX.get();
	}
	
	/**
	 * Sets the npcPosX
	 * @param setNpcPosX
	 */
	public void setNpcPosX(double setNpcPosX) {
		this.npcPosX = new SimpleDoubleProperty(setNpcPosX);
	}
	
	/**
	 * Gets the NpcPosX property
	 * @return Property for TableView
	 */
	public final DoubleProperty npcPosXProperty() {
	   return this.npcPosX;
	}
	
	/**
	 * Gets the NpcPosY
	 * @return npcPosY
	 */
	public double getNpcPosY() {
		return this.npcPosY.get();
	}
		
	/**
	 * Sets the npcPosY
	 * @param setNpcPosY
	 */
	public void setNpcPosY(double setNpcPosY) {
		this.npcPosY = new SimpleDoubleProperty(setNpcPosY);
	}
	
	/**
	 * Gets the NpcPosY property
	 * @return Property for TableView
	 */
	public final DoubleProperty npcPosYProperty() {
	   return this.npcPosY;
	}
	
	/**
	 * Gets the NpcPosZ
	 * @return npcPosZ
	 */
	public double getNpcPosZ() {
		return this.npcPosZ.get();
	}
	
	/**
	 * Sets the npcPosZ
	 * @param setNpcPosZ
	 */
	public void setNpcPosZ(double setNpcPosZ) {
		this.npcPosZ = new SimpleDoubleProperty(setNpcPosZ);
	}
	
	/**
	 * Gets the NpcPosZ property
	 * @return Property for TableView
	 */
	public final DoubleProperty npcPosZProperty() {
	   return this.npcPosZ;
	}
	
	

}
