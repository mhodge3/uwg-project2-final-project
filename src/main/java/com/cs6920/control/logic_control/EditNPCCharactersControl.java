package com.cs6920.control.logic_control;

import java.sql.SQLException;

import com.cs6920.DAL.MySQLAccess;
import com.cs6920.DAL.NpcCharacterDAL;
import com.cs6920.model.NpcCharacter;

/**
 * Communicates between the create NPCCharacter view and DAL
 * @author Matthew Hodge
 * @version 6.23.2020
 */
public class EditNPCCharactersControl {
	private NpcCharacterDAL theNpcCharacterDAL;
	private NpcCharacter selectedNPC;
	
	/**
	 * Constructor that sets DAL to the current DBConnection class instance
	 * @param theDBConnection
	 */
	public EditNPCCharactersControl(MySQLAccess theDBConnection) {
		this.theNpcCharacterDAL = new NpcCharacterDAL(theDBConnection);
	}

	/**
	 * Sets an instance of the NPC to that found by id
	 * @param npcId
	 */
	public void setSelectedNPC(int npcId) {
		try {
			selectedNPC = theNpcCharacterDAL.getNpcById(npcId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Get the NPC object for editing
	 * @return the NPCCharacter object to edit
	 */
	public NpcCharacter GetSelectedNPC() {
		return selectedNPC;
	}
	
	/**
	 * Delete this NPC from the DB
	 * @param npcToDelete
	 * @return String, message for user on outcome of operation
	 */
	public String deleteNPC(NpcCharacter npcToDelete) {
		
		try {
			if (theNpcCharacterDAL.deleteNpc(npcToDelete)) {
				return null;
			}
			else {
				return "There was a problem deleting the NPC";
			}
		} catch (SQLException e) {
			return "There was a problem deleting the NPC from the database";
		}
	}
	
	/**
	 * Update this NPCCharacter in the DB
	 * @param npcId
	 * @param npcType
	 * @param npcName
	 * @param npcDescription
	 * @param npcPosX
	 * @param npcPosY
	 * @param npcPosZ
	 * @param npcLevel
	 * @return String, message for user on outcome of operation
	 * @throws SQLException
	 */
	public String updateNpc(int npcId, int npcType, String npcName, String npcDescription, Double npcPosX, Double npcPosY, Double npcPosZ, int npcLevel) throws SQLException {
		if (npcName == null || npcName.trim().length() == 0) {
			return "The NPC Name cannot be empty";
		}
		else if (npcDescription == null || npcDescription.trim().length() == 0) {
			return "The NPC Description cannot be empty";
		}
		
		if (theNpcCharacterDAL.updateNpc(selectedNPC, new NpcCharacter(selectedNPC.getNpcId(), npcDescription, npcName, npcType, 0, npcPosX, npcPosY, npcPosZ, npcLevel))) {
			return null;
		}
		else {
			return "There was a problem updating the NPC";
		}
	}
}
