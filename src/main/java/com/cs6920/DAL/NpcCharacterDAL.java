package com.cs6920.DAL;

import java.sql.*;
import java.util.ArrayList;

import com.cs6920.model.NpcCharacter;
/**
 * Data access layer for the Character_npc database table
 * @author Perry Iler
 * @date 6/17/2020
 *
 */
public class NpcCharacterDAL {
	private MySQLAccess sqlAccess;
	private Connection theConnection;
	
	public NpcCharacterDAL(MySQLAccess theDBConnection) {
		this.sqlAccess = theDBConnection;
	}
	
	public NpcCharacter getNpcById(int npcId) throws SQLException {
		NpcCharacter npc = null;
        try {
            this.theConnection = this.sqlAccess.getDBConnection();
            Statement statement = this.theConnection.createStatement();
            String query = "SELECT character_npc_id, " +  
            	    "character_npc_name, " + 
            	    "character_npc_description, " +  
            	    "character_npc_type, " +
            	    "character_npc_faction, " + 
            	    "character_npc_pos_x, " +
            	    "character_npc_pos_y, " +
            	    "character_npc_pos_z,  " +
            	    "character_level  " +
            	"FROM " + this.sqlAccess.getTheDBName() + ".characters_npc " +
            	"WHERE character_npc_id = " + String.valueOf(npcId);
            ResultSet results = statement.executeQuery(query);
            if (results.next() != false) {
                npc = new NpcCharacter();
                npc.setNpcId(Integer.parseInt(results.getString("character_npc_id")));
                npc.setNpcName(results.getString("character_npc_name"));
                npc.setNpcDescprition(results.getString("character_npc_description"));
                npc.setNpcType(Integer.parseInt(results.getString("character_npc_type")));
                npc.setNpcFaction(Integer.parseInt(results.getString("character_npc_faction")));
                npc.setNpcPosX(Double.parseDouble(results.getString("character_npc_pos_x")));
                npc.setNpcPosY(Double.parseDouble(results.getString("character_npc_pos_Y")));
                npc.setNpcPosZ(Double.parseDouble(results.getString("character_npc_pos_Z")));
                npc.setNpcLevel(Integer.parseInt(results.getString("character_level")));
            }
        } catch (Exception e) {
        	System.err.println(e.getMessage());
        }
        finally {
        	theConnection.close();
        }
        return npc;
    }
	
	public NpcCharacter getNpcByName(String characterName) throws SQLException {
		NpcCharacter npc = null;
        try {
            this.theConnection = this.sqlAccess.getDBConnection();
            Statement statement = this.theConnection.createStatement();
            String query = "SELECT character_npc_id, " +  
            	    "character_npc_name, " + 
            	    "character_npc_description, " +  
            	    "character_npc_type, " +
            	    "character_npc_faction, " + 
            	    "character_npc_pos_x, " +
            	    "character_npc_pos_y, " +
            	    "character_npc_pos_z,  " +
            	    "character_level  " +
            	"FROM " + this.sqlAccess.getTheDBName() + ".characters_npc " +
            	"WHERE character_npc_name = \"" + characterName + "\"";
            ResultSet results = statement.executeQuery(query);
            if (results.next() != false) {
                npc = new NpcCharacter();
                npc.setNpcId(Integer.parseInt(results.getString("character_npc_id")));
                npc.setNpcName(results.getString("character_npc_name"));
                npc.setNpcDescprition(results.getString("character_npc_description"));
                npc.setNpcType(Integer.parseInt(results.getString("character_npc_type")));
                npc.setNpcFaction(Integer.parseInt(results.getString("character_npc_faction")));
                npc.setNpcPosX(Double.parseDouble(results.getString("character_npc_pos_x")));
                npc.setNpcPosY(Double.parseDouble(results.getString("character_npc_pos_Y")));
                npc.setNpcPosZ(Double.parseDouble(results.getString("character_npc_pos_Z")));
                npc.setNpcLevel(Integer.parseInt(results.getString("character_level")));
            }
        } catch (Exception e) {
        	System.err.println(e.getMessage());
        }
        finally {
        	theConnection.close();
        }
        return npc;
    }
	
	public ArrayList<NpcCharacter> getAllNpc() throws SQLException {
		
		ArrayList<NpcCharacter> allNpc = new ArrayList<NpcCharacter>();
        try {
            this.theConnection = this.sqlAccess.getDBConnection();
            Statement statement = this.theConnection.createStatement();
            String query = "SELECT character_npc_id, " +  
            	    "character_npc_name, " + 
            	    "character_npc_description, " +  
            	    "character_npc_type, " +
            	    "character_npc_faction, " + 
            	    "character_npc_pos_x, " +
            	    "character_npc_pos_y, " +
            	    "character_npc_pos_z,  " +
            	    "character_level  " +
            	"FROM " + this.sqlAccess.getTheDBName() + ".characters_npc ";
            ResultSet results = statement.executeQuery(query);
            while (results.next() != false) {
            	NpcCharacter npc = new NpcCharacter();
                npc.setNpcId(Integer.parseInt(results.getString("character_npc_id")));
                npc.setNpcName(results.getString("character_npc_name"));
                npc.setNpcDescprition(results.getString("character_npc_description"));
                npc.setNpcType(Integer.parseInt(results.getString("character_npc_type")));
                npc.setNpcFaction(Integer.parseInt(results.getString("character_npc_faction")));
                npc.setNpcPosX(Double.parseDouble(results.getString("character_npc_pos_x")));
                npc.setNpcPosY(Double.parseDouble(results.getString("character_npc_pos_Y")));
                npc.setNpcPosZ(Double.parseDouble(results.getString("character_npc_pos_Z")));
                npc.setNpcLevel(Integer.parseInt(results.getString("character_level")));
                allNpc.add(npc);
            }
        } catch (Exception e) {
        	System.err.println(e.getMessage());
        }
        finally {
        	theConnection.close();
        }
        return allNpc;
    }
	
	public Boolean createNpc(String npcDescription, String npcName, int npcType, int npcFaction, double npcPosX, double npcPosY, double npcPosZ, int npcLevel) throws SQLException {
		Boolean success = false;
		try {
			this.theConnection = this.sqlAccess.getDBConnection();
			String query = "INSERT INTO " + this.sqlAccess.getTheDBName() + ".`characters_npc`" + 
            	    "(character_npc_name, " +
            	    "character_npc_description, " +
            	    "character_npc_type, " + 
            	    "character_npc_faction, " +
            	    "character_npc_pos_x, " +
            	    "character_npc_pos_y, " +
            	    "character_npc_pos_z, " +
            	    "character_level )" +
					"VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
			 PreparedStatement preparedStmt = theConnection.prepareStatement(query);
			  preparedStmt.setString (1, npcName);
			  preparedStmt.setString (2, npcDescription);
			  preparedStmt.setString (3, String.valueOf(npcType));
			  preparedStmt.setString (4, String.valueOf(npcFaction));
			  preparedStmt.setString (5, String.valueOf(npcPosX));
			  preparedStmt.setString (6, String.valueOf(npcPosY));
			  preparedStmt.setString (7, String.valueOf(npcPosZ));
			  preparedStmt.setString (8, String.valueOf(npcLevel));
			  
		      preparedStmt.execute();
		      success = true;
		} catch (Exception e) {
        	System.err.println(e.getMessage());
        }
        finally {
        	theConnection.close();
        }
		return success;
	}
	
	public Boolean updateNpc(NpcCharacter oldCharacter, NpcCharacter updatedCharacter) throws SQLException {
		Boolean success = false;
		try {
			this.theConnection = this.sqlAccess.getDBConnection();
			String query = "UPDATE " + this.sqlAccess.getTheDBName() + ".characters_npc " + 
					"SET " +
            	    "character_npc_name = ?, " +
            	    "character_npc_description = ?, " +
            	    "character_npc_type = ?, " + 
            	    "character_npc_faction = ?, " +
            	    "character_npc_pos_x = ?, " +
            	    "character_npc_pos_y = ?, " +
            	    "character_npc_pos_z = ?, " +
            	    "character_level = ? " +
            	    "WHERE character_npc_id = ?";
		
			 PreparedStatement preparedStmt = theConnection.prepareStatement(query);
			  preparedStmt.setString (1, updatedCharacter.getNpcName());
			  preparedStmt.setString (2, updatedCharacter.getNpcDescprition());
			  preparedStmt.setString (3, String.valueOf(updatedCharacter.getNpcType()));
			  preparedStmt.setString (4, String.valueOf(updatedCharacter.getNpcFaction()));
			  preparedStmt.setString (5, String.valueOf(updatedCharacter.getNpcPosX()));
			  preparedStmt.setString (6, String.valueOf(updatedCharacter.getNpcPosY()));
			  preparedStmt.setString (7, String.valueOf(updatedCharacter.getNpcPosZ()));
			  preparedStmt.setString (8, String.valueOf(updatedCharacter.getNpcLevel()));
			  preparedStmt.setString (9, String.valueOf(oldCharacter.getNpcId()));
		      preparedStmt.execute();
		      success = true;
		} catch (Exception e) {
        	System.err.println(e.getMessage());
        }
        finally {
        	theConnection.close();
        }
		return success;
	}
	
	public boolean deleteNpc(NpcCharacter character) throws SQLException {
		Boolean success = false;
		try {
			this.theConnection = this.sqlAccess.getDBConnection();
			String query = "DELETE FROM " + this.sqlAccess.getTheDBName() + ".characters_npc " + 
					"WHERE character_npc_id = ?";
			PreparedStatement preparedStmt = theConnection.prepareStatement(query);
			preparedStmt.setString (1, String.valueOf(character.getNpcId()));
			
			preparedStmt.execute();
		      success = true;
		} catch (Exception e) {
        	System.err.println(e.getMessage());
        }
        finally {
        	theConnection.close();
        }
		return success;
	}
	
	
	

}
