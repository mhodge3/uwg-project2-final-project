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
	

}
