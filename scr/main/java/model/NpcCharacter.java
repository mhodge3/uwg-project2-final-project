/**
 * 
 */
package model;

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
	
	public NpcCharacter(int npcId, String npcDescription, String npcName, int npcType, int npcFaction, double npcPosX, double npcPosY, double npcPosZ) {
		this.npcId = new SimpleIntegerProperty(npcId);
		this.npcDescprition = new SimpleStringProperty(npcDescription);
		this.npcName = new SimpleStringProperty(npcName);
		this.npcType = new SimpleIntegerProperty(npcType);
		this.npcFaction = new SimpleIntegerProperty(npcFaction);
		this.npcPosX = new SimpleDoubleProperty(npcPosX);
		this.npcPosY = new SimpleDoubleProperty(npcPosY);
		this.npcPosZ = new SimpleDoubleProperty(npcPosZ);
		
		
	}
	
	/**
	 * Gets the npcId
	 * @return npcId
	 */
	public int GetNpcId() {
		return npcId.get();
	}
	
	/**
	 * Sets the npcID
	 * @param setNpcId
	 */
	public void SetNpcId(int setNpcId) {
		this.npcId = new SimpleIntegerProperty(setNpcId);
	}
	
	/**
	 * Gets the NpcID property
	 * @return Property for TableView
	 */
	public final IntegerProperty npcIdProperty() {
	   return npcId;
	}
	
	/**
	 * GEts the npcDescprition
	 * @return npcDescprition
	 */
	public String GetNpcDescprition() {
		return npcDescprition.get();
	}
	
	/**
	 * Sets the NpcDescprition
	 * @param setNpcDescprition
	 */
	public void SetNpcDescprition(String setNpcDescprition) {
		this.npcDescprition = new SimpleStringProperty(setNpcDescprition);
	}
	
	/**
	 * Gets the NpcDescription property
	 * @return Property for TableView
	 */
	public final StringProperty npcDescriptionProperty() {
	   return npcDescprition;
	}
	
	/**
	 * Gets the npcName
	 * @return npcName
	 */
	public String GetNpcName() {
		return npcName.get();
	}
	
	/**
	 * Sets the NpcName
	 * @param setNpcName
	 */
	public void SetNpcName(String setNpcName) {
		this.npcName = new SimpleStringProperty(setNpcName);
	}
	
	/**
	 * Gets the NpcName property
	 * @return Property for TableView
	 */
	public final StringProperty npcNameProperty() {
	   return npcName;
	}
	
	
	/**
	 * Gets the npctype
	 * @return npcType
	 */
	public int GetNpcType() {
		return npcType.get();
	}
	
	/**
	 * Sets the npc Type
	 * @param setNpcType
	 */
	public void SetNpcType(int setNpcType) {
		this.npcType = new SimpleIntegerProperty(setNpcType);
	}
	
	/**
	 * Gets the NpcType property
	 * @return Property for TableView
	 */
	public final IntegerProperty npcTypeProperty() {
	   return npcType;
	}
	
	/**
	 * Gets the npcFaction
	 * @return npcFaction
	 */
	public int GetNpcFaction() {
		return npcFaction.get();
	}
	
	/**
	 * Sets the npc Faction
	 * @param setNpcFaction
	 */
	public void SetNpcFaction(int setNpcFaction) {
		this.npcFaction = new SimpleIntegerProperty(setNpcFaction);
	}
	
	/**
	 * Gets the NpcFaction property
	 * @return Property for TableView
	 */
	public final IntegerProperty npcFactionProperty() {
	   return npcFaction;
	}
	
	/**
	 * Gets the NpcPosX
	 * @return npcPosX
	 */
	public double GetNpcPosX() {
		return npcPosX.get();
	}
	
	/**
	 * Sets the npcPosX
	 * @param setNpcPosX
	 */
	public void SetNpcPosX(double setNpcPosX) {
		this.npcPosX = new SimpleDoubleProperty(setNpcPosX);
	}
	
	/**
	 * Gets the NpcPosX property
	 * @return Property for TableView
	 */
	public final DoubleProperty npcPosXProperty() {
	   return npcPosX;
	}
	
	/**
	 * Gets the NpcPosY
	 * @return npcPosY
	 */
	public double GetNpcPosY() {
		return npcPosY.get();
	}
		
	/**
	 * Sets the npcPosY
	 * @param setNpcPosY
	 */
	public void SetNpcPosY(double setNpcPosY) {
		this.npcPosY = new SimpleDoubleProperty(setNpcPosY);
	}
	
	/**
	 * Gets the NpcPosY property
	 * @return Property for TableView
	 */
	public final DoubleProperty npcPosYProperty() {
	   return npcPosY;
	}
	
	/**
	 * Gets the NpcPosZ
	 * @return npcPosZ
	 */
	public double GetNpcPosZ() {
		return npcPosZ.get();
	}
	
	/**
	 * Sets the npcPosZ
	 * @param setNpcPosZ
	 */
	public void SetNpcPosZ(double setNpcPosZ) {
		this.npcPosZ = new SimpleDoubleProperty(setNpcPosZ);
	}
	
	/**
	 * Gets the NpcPosZ property
	 * @return Property for TableView
	 */
	public final DoubleProperty npcPosZProperty() {
	   return npcPosZ;
	}

}
