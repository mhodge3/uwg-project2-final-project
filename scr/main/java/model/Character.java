/**
 * 
 */
package model;

/**
 * @author Ashley Palmer
 * @date 6/11/2020
 *
 */
public class Character {
	private int npcId;
	private String npcDescprition;
	private String npcName;
	private int npcType;
	private int npcFaction;
	private double npcPosX;
	private double npcPosY;
	private double npcPosZ;
	
	/**
	 * Gets the npcId
	 * @return npcId
	 */
	public int GetNpcId() {
		return npcId;
	}
	
	/**
	 * Sets the npcID
	 * @param setNpcId
	 */
	public void SetNpcId(int setNpcId) {
		this.npcId = setNpcId;
	}
	
	/**
	 * GEts the npcDescprition
	 * @return npcDescprition
	 */
	public String GetNpcDescprition() {
		return npcDescprition;
	}
	
	/**
	 * Sets the NpcDescprition
	 * @param setNpcDescprition
	 */
	public void SetNpcDescprition(String setNpcDescprition) {
		this.npcDescprition = setNpcDescprition;
	}
	
	/**
	 * Gets the npcName
	 * @return npcName
	 */
	public String GetNpcName() {
		return npcName;
	}
	
	/**
	 * Sets the NpcName
	 * @param setNpcName
	 */
	public void SetNpcName(String setNpcName) {
		this.npcName = setNpcName;
	}
	
	/**
	 * Gets the npctype
	 * @return npcType
	 */
	public int GetNpcType() {
		return npcType;
	}
	
	/**
	 * Sets the npc Type
	 * @param setNpcType
	 */
	public void SetNpcType(int setNpcType) {
		this.npcType = setNpcType;
	}
	
	/**
	 * Gets the npcFaction
	 * @return npcFaction
	 */
	public int GetNpcFaction() {
		return npcFaction;
	}
	
	/**
	 * Sets the npc Faction
	 * @param setNpcFaction
	 */
	public void SetNpcFaction(int setNpcFaction) {
		this.npcFaction = setNpcFaction;
	}
	
	/**
	 * Gets the NpcPosX
	 * @return npcPosX
	 */
	public double GetNpcPosX() {
		return npcPosX;
	}
	
	/**
	 * Sets the npcPosX
	 * @param setNpcPosX
	 */
	public void SetNpcPosX(double setNpcPosX) {
		this.npcPosX = setNpcPosX;
	}
	
	/**
	 * Gets the NpcPosY
	 * @return npcPosY
	 */
	public double GetNpcPosY() {
		return npcPosY;
	}
	
	/**
	 * Sets the npcPosY
	 * @param setNpcPosY
	 */
	public void SetNpcPosY(double setNpcPosY) {
		this.npcPosY = setNpcPosY;
	}

}
