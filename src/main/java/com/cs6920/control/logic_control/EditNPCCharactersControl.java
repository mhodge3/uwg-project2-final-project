package com.cs6920.control.logic_control;

import java.sql.SQLException;

import com.cs6920.DAL.MySQLAccess;
import com.cs6920.DAL.NpcCharacterDAL;
import com.cs6920.model.NpcCharacter;

public class EditNPCCharactersControl {
	private NpcCharacterDAL npcDAL;
	private NpcCharacter selectedNPC;
	
	public EditNPCCharactersControl(MySQLAccess theDBConnection) {
		this.npcDAL = new NpcCharacterDAL(theDBConnection);
	}
	
	public void SetSelectedNPC(int npcId) {
		try {
			selectedNPC = npcDAL.GetNpcById(npcId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public NpcCharacter GetSelectedNPC() {
		return selectedNPC;
	}
	
	public String DeleteNPC(NpcCharacter npcToDelete) {
		
		try {
			if (npcDAL.DeleteNpc(npcToDelete)) {
				return null;
			}
			else {
				return "There was a problem deleting the NPC";
			}
		} catch (SQLException e) {
			return "There was a problem deleting the NPC from the database";
		}
	}
	
	public String UpdateNpc(int npcId, int npcType, String npcName, String npcDescription) throws SQLException {
		if (npcName == null || npcName.trim().length() == 0) {
			return "The NPC Name cannot be empty";
		}
		else if (npcDescription == null || npcDescription.trim().length() == 0) {
			return "The NPC Description cannot be empty";
		}
		
		if (npcDAL.UpdateNpc(selectedNPC, new NpcCharacter(selectedNPC.GetNpcId(), npcDescription, npcName, npcType, 0, 0, 0, 0))) {
			return null;
		}
		else {
			return "There was a problem updating the NPC";
		}
	}
}
