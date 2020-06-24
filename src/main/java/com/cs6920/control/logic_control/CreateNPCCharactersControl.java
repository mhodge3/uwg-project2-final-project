package com.cs6920.control.logic_control;

import java.sql.SQLException;

import com.cs6920.DAL.MySQLAccess;
import com.cs6920.DAL.NpcCharacterDAL;

/**
 * Communicates between the create NPCCharacters view and DAL
 * @author Matthew Hodge
 * @version 6.23.2020
 */
public class CreateNPCCharactersControl {
	private NpcCharacterDAL npcDAL;
	
	/**
	 * Constructor that sets DAL to the current DBConnection class instance
	 * @param theDBConnection
	 */
	public CreateNPCCharactersControl(MySQLAccess theDBConnection) {
		this.npcDAL = new NpcCharacterDAL(theDBConnection);
	}
	
	/**
	 * Uses the DAL to create the new Item entry in the DB
	 * @param npcType
	 * @param npcDescription
	 * @param npcName
	 * @return String, message for user on outcome of operation
	 * @throws SQLException
	 */
	public String CreateNpc(int npcType, String npcDescription, String npcName) throws SQLException {
		if (npcName == null || npcName.trim().length() == 0) {
			return "The NPC Name cannot be empty";
		}
		else if (npcDescription == null || npcDescription.trim().length() == 0) {
			return "The NPC Description cannot be empty";
		}
		
		if (npcDAL.CreateNpc(npcDescription, npcName, npcType, 0, 0, 0, 0)) {
			return null;
		}
		else {
			return "There was a problem creating the account";
		}
	}
}
