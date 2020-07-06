package com.cs6920.control.logic_control;

import java.sql.SQLException;
import java.util.ArrayList;

import com.cs6920.DAL.CharactersPlayerDAL;
import com.cs6920.DAL.MySQLAccess;
import com.cs6920.model.CharactersPlayer;

/**
* Controller class that retrieves data from the CharactersPlayerDAL
* @author Perry Iler
* @date 6/29/2020
*
*/
public class CharactersPlayerController {

	private CharactersPlayerDAL dal;
	
	/**
	 * Constructor for the CharactersPlayerController
	 * @param theDBConnection
	 */
	public CharactersPlayerController(MySQLAccess theDBConnection) {
		this.dal = new CharactersPlayerDAL(theDBConnection);
	}
	
	/**
	 * Creates a characterPlayer entry in the database CharacterPlayer table
	 * @param characterId
	 * @param characterPlayerId
	 * @param characterName
	 * @param characterType
	 * @param characterFaction
	 * @param characterPosX
	 * @param characterPosY
	 * @param characterPosZ
	 * @return Error message
	 */
	public String CreateCharacterPlayer(int characterPlayerId, String characterName, int characterType, int characterFaction, double characterPosX, double characterPosY, double characterPosZ) {
		try {
			if(String.valueOf(characterPlayerId) == null || characterPlayerId <= 0) {
				return "The player ID cannot be empty or less than or equal to zero";
			}
			else if (characterName == null || characterName.trim().length() == 0) {
				return "The User characterName cannot be empty";
			}
			else if(String.valueOf(characterType) == null || characterType <= 0) {
				return "The type cannot be empty or less than or equal to zero";
			}
			else if(String.valueOf(characterFaction) == null || characterFaction <= 0) {
				return "The fraction cannot be empty or less than or equal to zero";
			}
			else if(String.valueOf(characterPosX) == null) {
				return "The posX cannot be empty.";
			}
			else if(String.valueOf(characterPosY) == null) {
				return "The posY cannot be empty";
			}
			else if(String.valueOf(characterPosX) == null) {
				return "The posY cannot be empty";
			}
			
			if (this.dal.CreateCharacterPlayer(characterPlayerId, characterName, characterType, characterFaction, characterPosX, characterPosY, characterPosZ)) {
				return null;
			}
			else {
				return "There was a problem creating the characterPlayer";
			}
			
		} catch (Exception e) {
			return "There was a problem creating the characterPlayer";
        }
       
	}
	
	/**
	 * Calls GetCharactersPlayerByID method from the DAL
	 * @param Character ID
	 * @return The CharactersPlayer looked up
	 * @throws SQLException
	 */
	public CharactersPlayer GetCharactersPlayerByID(int characterId) throws SQLException {
    	return this.dal.GetCharactersPlayerByID(characterId);           
        
    }
	
	/**
	 * Calls GetCharactersPlayerByname method from the DAL
	 * @param Character name
	 * @return The CharactersPlayer looked up
	 * @throws SQLException
	 */
	public CharactersPlayer GetCharactersPlayerByName(String CharacterName) throws SQLException {
    	return this.dal.GetCharactersPlayerByName(CharacterName);
    }
	
	/**
	 * Calls GetCharactersPlayers method from the DAL
	 * @param playerId
	 * @return
	 * @throws SQLException
	 */
	public ArrayList<CharactersPlayer> GetCharactersPlayers(int playerId) throws SQLException {
		return this.GetCharactersPlayers(playerId);
	}
	
	/**
	 * Calls updateCharactersPlayer method from the DAL
	 * @param oldCharacter
	 * @param updatedCharacter
	 * @return Error message
	 */
	public String updateCharacterPlayer(CharactersPlayer oldCharacter, CharactersPlayer updatedCharacter) {
		try {
			if (this.dal.UpdateCharacterPlayer(oldCharacter, updatedCharacter)) {
				return null;
			}
			else {
				return "There was a problem updating the characterPlayer";
			}
			
		} catch (Exception e) {
			return "There was a problem updating the characterPlayer";
        }
	}
	
	/**
	 * Calls updateCharactersPlayer method from the DAL
	 * @param oldCharacter
	 * @param updatedCharacter
	 * @return Error message
	 */
	public String DeleteCharacterPlayer(CharactersPlayer character) {
		try {
			if (this.dal.DeleteCharacterPlayer(character)) {
				return null;
			}
			else {
				return "There was a problem deleting the characterPlayer";
			}
			
		} catch (Exception e) {
			return "There was a problem deleting the characterPlayer";
        }
	}
	
}
