package com.cs6920.DAL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.cs6920.model.CharactersPlayer;

/**
 * Data access layer for the CharacterPlayer database table
 * @author Perry Iler
 * @date 6/26/2020
 *
 */
public class CharactersPlayerDAL {
	private MySQLAccess sqlAccess;
	private Connection conn;
	
	/**
	 * Creates a CharactersPlayerDAL object to be used by the controllers
	 */
	public CharactersPlayerDAL(MySQLAccess theDBConnection) {
		this.sqlAccess = theDBConnection;
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
	 * @return True if inserted | False if not inserted
	 * @throws SQLException
	 */
	public Boolean CreateCharacterPlayer(int characterPlayerId, String characterName, int characterType, int characterFaction, double characterPosX, double characterPosY, double characterPosZ) throws SQLException {
		Boolean success = false;
		try {
			this.conn = this.sqlAccess.GetDBConnection();
			String query = "INSERT INTO " + this.sqlAccess.GetTheDBName() + ".charactersplayer " + 
					"(character_player_id, " +
					"character_name, " +
					"character_type, " +
					"character_faction, " +
					"character_posX, " +
					"character_posY, " +
					"character_posZ) " +
					"VALUES (?, ?, ?, ?, ?, ?, ?)";
			 System.out.println(query); 			
			 PreparedStatement preparedStmt = conn.prepareStatement(query);
			 preparedStmt.setString (1, String.valueOf(characterPlayerId));
			 preparedStmt.setString (2, characterName);
			 preparedStmt.setString (3, String.valueOf(characterType));
			 preparedStmt.setString (4, String.valueOf(characterFaction));
			 preparedStmt.setString (5, String.valueOf(characterPosX));
			 preparedStmt.setString (6, String.valueOf(characterPosY));
			 preparedStmt.setString (7, String.valueOf(characterPosZ));
			  
		      preparedStmt.execute();
		      success = true;
		} catch (Exception e) {
        	System.err.println(e.getMessage());
        }
        finally {
        	conn.close();
        }
		return success;
	}
	
	/**
	 * Returns CharactersPlayer by ID.
	 * @param Character ID
	 * @return The CharactersPlayer looked up
	 * @throws SQLException
	 */
	public CharactersPlayer GetCharactersPlayerByID(int characterId) throws SQLException {
    	CharactersPlayer charactersPlayer = null;
        try {
            this.conn = this.sqlAccess.GetDBConnection();
            Statement statement = this.conn.createStatement();
            String query = "SELECT * FROM " + this.sqlAccess.GetTheDBName() + ".charactersplayer "
            		+ "WHERE " + this.sqlAccess.GetTheDBName() + ".charactersplayer.character_id = " + characterId + ";";
            ResultSet results = statement.executeQuery(query);
            if (results.next() != false) {
            	charactersPlayer = new CharactersPlayer();
                charactersPlayer.SetCharacterId(results.getInt("character_id"));
                charactersPlayer.SetCharacterPlayerId(results.getInt("character_player_id"));
                charactersPlayer.SetCharacterName(results.getString("character_name"));
                charactersPlayer.SetCharacterType(results.getInt("character_type"));
                charactersPlayer.SetCharacterFaction(results.getInt("character_faction"));
                charactersPlayer.SetCharacterPosX(results.getDouble("character_posX"));
                charactersPlayer.SetCharacterPosY(results.getDouble("character_posY"));
                charactersPlayer.SetCharacterPosZ(results.getDouble("character_posZ"));
            }
        } catch (Exception e) {
        	System.err.println(e.getMessage());
        }
        finally {
        	conn.close();
        }
        return charactersPlayer;
    }
	
	/**
	 * Returns CharactersPlayer by CharacterName.
	 * @param Character name
	 * @return The CharactersPlayer looked up
	 * @throws SQLException
	 */
	public CharactersPlayer GetCharactersPlayerByName(String CharacterName) throws SQLException {
    	CharactersPlayer charactersPlayer = null;
        try {
            this.conn = this.sqlAccess.GetDBConnection();
            Statement statement = this.conn.createStatement();
            String query = "SELECT * FROM " + this.sqlAccess.GetTheDBName() + ".charactersPlayer "
            		+ "WHERE " + this.sqlAccess.GetTheDBName() + ".charactersplayer.character_name = \"" + CharacterName + "\"";
            ResultSet results = statement.executeQuery(query);
            if (results.next() != false) {
            	charactersPlayer = new CharactersPlayer();
                charactersPlayer.SetCharacterId(results.getInt("character_id"));
                charactersPlayer.SetCharacterPlayerId(results.getInt("character_player_id"));
                charactersPlayer.SetCharacterName(results.getString("character_name"));
                charactersPlayer.SetCharacterType(results.getInt("character_type"));
                charactersPlayer.SetCharacterFaction(results.getInt("character_faction"));
                charactersPlayer.SetCharacterPosX(results.getDouble("character_posX"));
                charactersPlayer.SetCharacterPosY(results.getDouble("character_posY"));
                charactersPlayer.SetCharacterPosZ(results.getDouble("character_posZ"));
            }
        } catch (Exception e) {
        	System.err.println(e.getMessage());
        }
        finally {
        	conn.close();
        }
        return charactersPlayer;
    }
	
	/**
	 * Updates an existing Character entry in the database CharactersPlayers table
	 * @param oldCharacter
	 * @param updatedCharacter
	 * @return True if updated | False if not updated
	 * @throws SQLException
	 */
	public Boolean UpdateCharacterPlayer(CharactersPlayer oldCharacter, CharactersPlayer updatedCharacter) throws SQLException {
		Boolean success = false;
		try {
			this.conn = this.sqlAccess.GetDBConnection();
			String query = "UPDATE " + this.sqlAccess.GetTheDBName() + ".charactersplayer " + 
					"SET " + 
						"character_player_id = ?, " +
						"character_name = ?, " +
						"character_type = ?, " +
						"character_faction = ?, " +
						"character_posX = ?, " +
						"character_posY = ?, " +
						"character_posZ = ? " +
						"WHERE character_id = ?";
							
			 PreparedStatement preparedStmt = conn.prepareStatement(query);
			 preparedStmt.setString (1, String.valueOf(updatedCharacter.GetCharacterPlayerId()));
			 preparedStmt.setString (2, updatedCharacter.GetCharacterName());
			 preparedStmt.setString (3, String.valueOf(updatedCharacter.GetCharacterType()));
			 preparedStmt.setString (4, String.valueOf(updatedCharacter.GetCharacterFaction()));
			 preparedStmt.setString (5, String.valueOf(updatedCharacter.GetCharacterPosX()));
			 preparedStmt.setString (6, String.valueOf(updatedCharacter.GetCharacterPosY()));
			 preparedStmt.setString (7, String.valueOf(updatedCharacter.GetCharacterPosZ()));
			 preparedStmt.setString (8, String.valueOf(oldCharacter.GetCharacterId()));
			  
		      preparedStmt.execute();
		      success = true;
		} catch (Exception e) {
        	System.err.println(e.getMessage());
        }
        finally {
        	conn.close();
        }
		return success;
	}
	
	/**
	 * Deletes an existing Character entry in the database CharactersPlayers table
	 * @param character The CharactersPlayer to be deleted
	 * @return True if deleted | False if not deleted
	 * @throws SQLException
	 */
	public boolean DeleteCharacterPlayer(CharactersPlayer character) throws SQLException {
		Boolean success = false;
		try {
			this.conn = this.sqlAccess.GetDBConnection();
			String query = "DELETE FROM " + this.sqlAccess.GetTheDBName() + ".charactersplayer " + 
					"WHERE character_player_id = ?";
			PreparedStatement preparedStmt = conn.prepareStatement(query);
			preparedStmt.setString (1, String.valueOf(character.GetCharacterPlayerId()));
			
			preparedStmt.execute();
		      success = true;
		} catch (Exception e) {
        	System.err.println(e.getMessage());
        }
        finally {
        	conn.close();
        }
		return success;
	}
}
