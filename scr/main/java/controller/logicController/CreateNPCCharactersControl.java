package controller.logicController;

import java.sql.SQLException;

import DAL.MySQLAccess;
import DAL.NpcCharacterDAL;

public class CreateNPCCharactersControl {
	private NpcCharacterDAL npcDAL;
	
	public CreateNPCCharactersControl(MySQLAccess theDBConnection) {
		this.npcDAL = new NpcCharacterDAL(theDBConnection);
	}
	
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
