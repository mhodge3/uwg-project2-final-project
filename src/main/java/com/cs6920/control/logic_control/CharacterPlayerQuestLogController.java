package com.cs6920.control.logic_control;

import java.sql.SQLException;

import com.cs6920.DAL.CharacterPlayerQuestLogDAL;
import com.cs6920.DAL.MySQLAccess;
import com.cs6920.model.CharacterPlayerQuestLog;

/**
* Controller class that retrieves data from the CharacterPlayerQuestLogDAL
* @author Perry Iler
* @date 6/29/2020
*
*/
public class CharacterPlayerQuestLogController {
	private CharacterPlayerQuestLogDAL theCharacterPlayerQuestLogDAL;
	
	/**
	 * Constructor for the CharacterPlayerQuestLogController
	 * @param theDBConnection
	 */
	public CharacterPlayerQuestLogController(MySQLAccess theDBConnection) {
		this.theCharacterPlayerQuestLogDAL = new CharacterPlayerQuestLogDAL(theDBConnection);
	}
	
	/**
	 * Calls the CreateCharacterPlayerQuestLog method from the DAL
	 * @param characterId
	 * @param questId
	 * @param questStatus
	 * @return Error message
	 * @throws SQLException
	 */
	public String createCharacterPlayerQuestLog(int characterId, int questId, int questStatus) {
		
		try {
			if(this.theCharacterPlayerQuestLogDAL.createCharacterPlayerQuestLog(characterId, questId, questStatus)) {
				return null;
			}
			else {
				return "There was a problem creating the quest log";
			}
		} catch (SQLException e) {
			return "There was a problem creating the quest log";
		}
	}
	
	/**
	 * Calls the GetCharacterPlayerQuestLogByQuestID method from the DAL
	 * 
	 * @param questId
	 * @return The characterPlayerQuestLog looked up
	 */
	public CharacterPlayerQuestLog getCharacterPlayerQuestLogByQuestId(int questId) {
		try {
			return this.theCharacterPlayerQuestLogDAL.getCharacterPlayerQuestLogByQuestId(questId);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
    }

	/**
	 * Calls the GetCharacterPlayerQuestLogByQuestID method from the DAL
	 * @param characterID
	 * @return The characterPlayerQuestLog looked up
	 */
	public CharacterPlayerQuestLog getCharacterPlayerQuestLogByCharacterId(int characterID) {
		try {
			return this.theCharacterPlayerQuestLogDAL.getCharacterPlayerQuestLogByCharacterId(characterID);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
    }
	
	/**
	 * Calls the UpdateCharacterPlayerQuestLogStatus method from the DAL
	 * @param log
	 * @param updatedStatus
	 * @return Error message
	 */
	public String updateCharacterPlayerQuestLogStatus(CharacterPlayerQuestLog log, int updatedStatus) {
		try {
			if(this.theCharacterPlayerQuestLogDAL.updateCharacterPlayerQuestLogStatus(log, updatedStatus)) {
				return null;
			}
			else {
				return "There was a problem updating the quest log";
			}
		} catch (Exception e) {
			return "There was a problem updating the quest log";
        }
	}
	
	/**
	 * Calls the DeleteCharacterPlayerQuestLog method from the DAL
	 * @param log
	 * @return Error message
	 */
	public String deleteCharacterPlayerQuestLog(CharacterPlayerQuestLog log) {
		try {
			if(this.theCharacterPlayerQuestLogDAL.deleteCharacterPlayerQuestLog(log)) {
				return null;
			}
			else {
				return "There was a problem deleting the quest log";
			}
		} catch (Exception e) {
			return "There was a problem deleting the quest log";
        }
	}
}
