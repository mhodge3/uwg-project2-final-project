package com.cs6920.DAL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.cs6920.model.CharactersPlayer;

/**
 * Data access layer for the CharacterPlayer database table
 * @author Perry Iler
 * @date 6/26/2020
 *
 */
public class CharactersPlayerDAL {
	private MySQLAccess sqlAccess;
	private Connection theConnection;
	
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
	public Boolean createCharacterPlayer(int characterPlayerId, String characterName, int characterType, int characterFaction, double characterPosX, double characterPosY, double characterPosZ) throws SQLException {
		Boolean success = false;
		try {
			this.theConnection = this.sqlAccess.getDBConnection();
			String query = "INSERT INTO " + this.sqlAccess.getTheDBName() + ".charactersplayer " + 
					"(character_player_id, " +
					"character_name, " +
					"character_type, " +
					"character_faction, " +
					"character_posX, " +
					"character_posY, " +
					"character_posZ) " +
					"VALUES (?, ?, ?, ?, ?, ?, ?)";			
			 PreparedStatement preparedStmt = this.theConnection.prepareStatement(query);
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
        	this.theConnection.close();
        }
		return success;
	}
	
	/**
	 * Returns a list of CharactersPlayers by PlayerID.
	 * @param Character ID
	 * @return The CharactersPlayers list looked up
	 * @throws SQLException
	 */
	public ArrayList<CharactersPlayer> getCharactersPlayers(int playerId) throws SQLException {
		ArrayList<CharactersPlayer> charactersPlayers = new ArrayList<CharactersPlayer>();
        try {
            this.theConnection = this.sqlAccess.getDBConnection();
            Statement statement = this.theConnection.createStatement();
            String query = "SELECT * FROM " + this.sqlAccess.getTheDBName() + ".charactersplayer "
            		+ "WHERE " + this.sqlAccess.getTheDBName() + ".charactersplayer.character_player_id = " + playerId + ";";
            ResultSet results = statement.executeQuery(query);
            while (results.next() != false) {
            	CharactersPlayer charactersPlayer = new CharactersPlayer();
                charactersPlayer.setCharacterId(results.getInt("character_id"));
                charactersPlayer.setCharacterPlayerId(results.getInt("character_player_id"));
                charactersPlayer.setCharacterName(results.getString("character_name"));
                charactersPlayer.setCharacterType(results.getInt("character_type"));
                charactersPlayer.setCharacterFaction(results.getInt("character_faction"));
                charactersPlayer.setCharacterPosX(results.getDouble("character_posX"));
                charactersPlayer.setCharacterPosY(results.getDouble("character_posY"));
                charactersPlayer.setCharacterPosZ(results.getDouble("character_posZ"));
                charactersPlayers.add(charactersPlayer);
            }
        } catch (Exception e) {
        	System.err.println(e.getMessage());
        }
        finally {
        	this.theConnection.close();
        }
        return charactersPlayers;
    }
	
	/**
	 * Returns CharactersPlayer by ID.
	 * @param Character ID
	 * @return The CharactersPlayer looked up
	 * @throws SQLException
	 */
	public CharactersPlayer getCharactersPlayerByID(int characterId) throws SQLException {
    	CharactersPlayer charactersPlayer = null;
        try {
            this.theConnection = this.sqlAccess.getDBConnection();
            Statement statement = this.theConnection.createStatement();
            String query = "SELECT * FROM " + this.sqlAccess.getTheDBName() + ".charactersplayer "
            		+ "WHERE " + this.sqlAccess.getTheDBName() + ".charactersplayer.character_id = " + characterId + ";";
            ResultSet results = statement.executeQuery(query);
            if (results.next() != false) {
            	charactersPlayer = new CharactersPlayer();
                charactersPlayer.setCharacterId(results.getInt("character_id"));
                charactersPlayer.setCharacterPlayerId(results.getInt("character_player_id"));
                charactersPlayer.setCharacterName(results.getString("character_name"));
                charactersPlayer.setCharacterType(results.getInt("character_type"));
                charactersPlayer.setCharacterFaction(results.getInt("character_faction"));
                charactersPlayer.setCharacterPosX(results.getDouble("character_posX"));
                charactersPlayer.setCharacterPosY(results.getDouble("character_posY"));
                charactersPlayer.setCharacterPosZ(results.getDouble("character_posZ"));
            }
        } catch (Exception e) {
        	System.err.println(e.getMessage());
        }
        finally {
        	this.theConnection.close();
        }
        return charactersPlayer;
    }
	
	/**
	 * Returns CharactersPlayer by CharacterName.
	 * @param Character name
	 * @return The CharactersPlayer looked up
	 * @throws SQLException
	 */
	public CharactersPlayer getCharactersPlayerByName(String CharacterName) throws SQLException {
    	CharactersPlayer charactersPlayer = null;
        try {
            this.theConnection = this.sqlAccess.getDBConnection();
            Statement statement = this.theConnection.createStatement();
            String query = "SELECT * FROM " + this.sqlAccess.getTheDBName() + ".charactersPlayer "
            		+ "WHERE " + this.sqlAccess.getTheDBName() + ".charactersplayer.character_name = \"" + CharacterName + "\"";
            ResultSet results = statement.executeQuery(query);
            if (results.next() != false) {
            	charactersPlayer = new CharactersPlayer();
                charactersPlayer.setCharacterId(results.getInt("character_id"));
                charactersPlayer.setCharacterPlayerId(results.getInt("character_player_id"));
                charactersPlayer.setCharacterName(results.getString("character_name"));
                charactersPlayer.setCharacterType(results.getInt("character_type"));
                charactersPlayer.setCharacterFaction(results.getInt("character_faction"));
                charactersPlayer.setCharacterPosX(results.getDouble("character_posX"));
                charactersPlayer.setCharacterPosY(results.getDouble("character_posY"));
                charactersPlayer.setCharacterPosZ(results.getDouble("character_posZ"));
            }
        } catch (Exception e) {
        	System.err.println(e.getMessage());
        }
        finally {
        	this.theConnection.close();
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
	public Boolean updateCharacterPlayer(CharactersPlayer oldCharacter, CharactersPlayer updatedCharacter) throws SQLException {
		Boolean success = false;
		try {
			this.theConnection = this.sqlAccess.getDBConnection();
			String query = "UPDATE " + this.sqlAccess.getTheDBName() + ".charactersplayer " + 
					"SET " + 
						"character_player_id = ?, " +
						"character_name = ?, " +
						"character_type = ?, " +
						"character_faction = ?, " +
						"character_posX = ?, " +
						"character_posY = ?, " +
						"character_posZ = ? " +
						"WHERE character_id = ?";
							
			 PreparedStatement preparedStmt = this.theConnection.prepareStatement(query);
			 preparedStmt.setString (1, String.valueOf(updatedCharacter.getCharacterPlayerId()));
			 preparedStmt.setString (2, updatedCharacter.getCharacterName());
			 preparedStmt.setString (3, String.valueOf(updatedCharacter.getCharacterType()));
			 preparedStmt.setString (4, String.valueOf(updatedCharacter.getCharacterFaction()));
			 preparedStmt.setString (5, String.valueOf(updatedCharacter.getCharacterPosX()));
			 preparedStmt.setString (6, String.valueOf(updatedCharacter.getCharacterPosY()));
			 preparedStmt.setString (7, String.valueOf(updatedCharacter.getCharacterPosZ()));
			 preparedStmt.setString (8, String.valueOf(oldCharacter.getCharacterId()));
			  
		      preparedStmt.execute();
		      success = true;
		} catch (Exception e) {
        	System.err.println(e.getMessage());
        }
        finally {
        	this.theConnection.close();
        }
		return success;
	}
	
	/**
	 * Deletes an existing Character entry in the database CharactersPlayers table
	 * @param character The CharactersPlayer to be deleted
	 * @return True if deleted | False if not deleted
	 * @throws SQLException
	 */
	public boolean deleteCharacterPlayer(CharactersPlayer character) throws SQLException {
		Boolean success = false;
		try {
			this.theConnection = this.sqlAccess.getDBConnection();
			String query = "DELETE FROM " + this.sqlAccess.getTheDBName() + ".charactersplayer " + 
					"WHERE character_player_id = ?";
			PreparedStatement preparedStmt = this.theConnection.prepareStatement(query);
			preparedStmt.setString (1, String.valueOf(character.getCharacterPlayerId()));
			
			preparedStmt.execute();
		      success = true;
		} catch (Exception e) {
        	System.err.println(e.getMessage());
        }
        finally {
        	this.theConnection.close();
        }
		return success;
	}
}
