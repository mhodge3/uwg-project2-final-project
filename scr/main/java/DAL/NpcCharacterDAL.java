package DAL;

import java.sql.*;
import java.util.ArrayList;

import model.Admin;
import model.NpcCharacter;
import model.Player;
/**
 * Data access layer for the Character_npc database table
 * @author Perry Iler
 * @date 6/17/2020
 *
 */
public class NpcCharacterDAL {
	private MySQLAccess sqlAccess;
	private Connection conn;
	
	public NpcCharacterDAL(MySQLAccess theDBConnection) {
		this.sqlAccess = theDBConnection;
	}
	
	public NpcCharacter GetNpcById(int npcId) throws SQLException {
		NpcCharacter npc = null;
        try {
            this.conn = this.sqlAccess.GetDBConnection();
            Statement statement = this.conn.createStatement();
            String query = "SELECT character_npc_id, " +  
            	    "character_npc_name, " + 
            	    "character_npc_description, " +  
            	    "character_npc_type, " +
            	    "character_npc_faction, " + 
            	    "character_npc_pos_x, " +
            	    "character_npc_pos_y, " +
            	    "character_npc_pos_z  " +
            	"FROM " + this.sqlAccess.GetTheDBName() + ".characters_npc " +
            	"WHERE character_npc_id = " + String.valueOf(npcId);
            ResultSet results = statement.executeQuery(query);
            if (results.next() != false) {
                npc = new NpcCharacter();
                npc.SetNpcId(Integer.parseInt(results.getString("character_npc_id")));
                npc.SetNpcName(results.getString("character_npc_name"));
                npc.SetNpcDescprition(results.getString("character_npc_description"));
                npc.SetNpcType(Integer.parseInt(results.getString("character_npc_type")));
                npc.SetNpcFaction(Integer.parseInt(results.getString("character_npc_faction")));
                npc.SetNpcPosX(Double.parseDouble(results.getString("character_npc_pos_x")));
                npc.SetNpcPosY(Double.parseDouble(results.getString("character_npc_pos_Y")));
                npc.SetNpcPosZ(Double.parseDouble(results.getString("character_npc_pos_Z")));
            }
        } catch (Exception e) {
        	System.err.println(e.getMessage());
        }
        finally {
        	conn.close();
        }
        return npc;
    }
	
	public NpcCharacter GetNpcByName(String characterName) throws SQLException {
		NpcCharacter npc = null;
        try {
            this.conn = this.sqlAccess.GetDBConnection();
            Statement statement = this.conn.createStatement();
            String query = "SELECT character_npc_id, " +  
            	    "character_npc_name, " + 
            	    "character_npc_description, " +  
            	    "character_npc_type, " +
            	    "character_npc_faction, " + 
            	    "character_npc_pos_x, " +
            	    "character_npc_pos_y, " +
            	    "character_npc_pos_z  " +
            	"FROM " + this.sqlAccess.GetTheDBName() + ".characters_npc " +
            	"WHERE character_npc_name = \"" + characterName + "\"";
            ResultSet results = statement.executeQuery(query);
            if (results.next() != false) {
                npc = new NpcCharacter();
                npc.SetNpcId(Integer.parseInt(results.getString("character_npc_id")));
                npc.SetNpcName(results.getString("character_npc_name"));
                npc.SetNpcDescprition(results.getString("character_npc_description"));
                npc.SetNpcType(Integer.parseInt(results.getString("character_npc_type")));
                npc.SetNpcFaction(Integer.parseInt(results.getString("character_npc_faction")));
                npc.SetNpcPosX(Double.parseDouble(results.getString("character_npc_pos_x")));
                npc.SetNpcPosY(Double.parseDouble(results.getString("character_npc_pos_Y")));
                npc.SetNpcPosZ(Double.parseDouble(results.getString("character_npc_pos_Z")));
            }
        } catch (Exception e) {
        	System.err.println(e.getMessage());
        }
        finally {
        	conn.close();
        }
        return npc;
    }
	
	public ArrayList<NpcCharacter> GetAllNpc() throws SQLException {
		
		ArrayList<NpcCharacter> allNpc = new ArrayList<NpcCharacter>();
        try {
            this.conn = this.sqlAccess.GetDBConnection();
            Statement statement = this.conn.createStatement();
            String query = "SELECT character_npc_id, " +  
            	    "character_npc_name, " + 
            	    "character_npc_description, " +  
            	    "character_npc_type, " +
            	    "character_npc_faction, " + 
            	    "character_npc_pos_x, " +
            	    "character_npc_pos_y, " +
            	    "character_npc_pos_z  " +
            	"FROM " + this.sqlAccess.GetTheDBName() + ".characters_npc ";
            ResultSet results = statement.executeQuery(query);
            while (results.next() != false) {
            	NpcCharacter npc = new NpcCharacter();
                npc.SetNpcId(Integer.parseInt(results.getString("character_npc_id")));
                npc.SetNpcName(results.getString("character_npc_name"));
                npc.SetNpcDescprition(results.getString("character_npc_description"));
                npc.SetNpcType(Integer.parseInt(results.getString("character_npc_type")));
                npc.SetNpcFaction(Integer.parseInt(results.getString("character_npc_faction")));
                npc.SetNpcPosX(Double.parseDouble(results.getString("character_npc_pos_x")));
                npc.SetNpcPosY(Double.parseDouble(results.getString("character_npc_pos_Y")));
                npc.SetNpcPosZ(Double.parseDouble(results.getString("character_npc_pos_Z")));
                allNpc.add(npc);
            }
        } catch (Exception e) {
        	System.err.println(e.getMessage());
        }
        finally {
        	conn.close();
        }
        return allNpc;
    }
	
	public Boolean CreateNpc(String npcDescription, String npcName, int npcType, int npcFaction, double npcPosX, double npcPosY, double npcPosZ) throws SQLException {
		Boolean success = false;
		try {
			this.conn = this.sqlAccess.GetDBConnection();
			String query = "INSERT INTO " + this.sqlAccess.GetTheDBName() + ".`characters_npc`" + 
            	    "(characters_npc.character_npc_name, " +
            	    "characters_npc.character_npc_description, " +
            	    "characters_npc.character_npc_type, " + 
            	    "characters_npc.character_npc_faction, " +
            	    "characters_npc.character_npc_pos_x, " +
            	    "characters_npc.character_npc_pos_y, " +
            	    "characters_npc.character_npc_pos_z )" +
					"VALUES (?, ?, ?, ?, ?, ?, ?)";
			 PreparedStatement preparedStmt = conn.prepareStatement(query);
			  preparedStmt.setString (1, npcName);
			  preparedStmt.setString (2, npcDescription);
			  preparedStmt.setString (3, String.valueOf(npcType));
			  preparedStmt.setString (4, String.valueOf(npcFaction));
			  preparedStmt.setString (5, String.valueOf(npcPosX));
			  preparedStmt.setString (6, String.valueOf(npcPosY));
			  preparedStmt.setString (7, String.valueOf(npcPosZ));
			  
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
	
	public Boolean UpdateNpc(NpcCharacter oldCharacter, NpcCharacter updatedCharacter) throws SQLException {
		Boolean success = false;
		try {
			this.conn = this.sqlAccess.GetDBConnection();
			String query = "UPDATE " + this.sqlAccess.GetTheDBName() + ".characters_npc " + 
					"SET " +
            	    "character_npc_name = ?, " +
            	    "character_npc_description = ?, " +
            	    "character_npc_type = ?, " + 
            	    "character_npc_faction = ?, " +
            	    "character_npc_pos_x = ?, " +
            	    "character_npc_pos_y = ?, " +
            	    "character_npc_pos_z = ?" +
            	    "WHERE character_npc_id = ?";
		
			 PreparedStatement preparedStmt = conn.prepareStatement(query);
			  preparedStmt.setString (1, updatedCharacter.GetNpcName());
			  preparedStmt.setString (2, updatedCharacter.GetNpcDescprition());
			  preparedStmt.setString (3, String.valueOf(updatedCharacter.GetNpcType()));
			  preparedStmt.setString (4, String.valueOf(updatedCharacter.GetNpcFaction()));
			  preparedStmt.setString (5, String.valueOf(updatedCharacter.GetNpcPosX()));
			  preparedStmt.setString (6, String.valueOf(updatedCharacter.GetNpcPosY()));
			  preparedStmt.setString (7, String.valueOf(updatedCharacter.GetNpcPosZ()));
			  preparedStmt.setString (8, String.valueOf(oldCharacter.GetNpcId()));
		      preparedStmt.execute();
		      System.out.println(updatedCharacter.GetNpcName());
		      success = true;
		} catch (Exception e) {
        	System.err.println(e.getMessage());
        }
        finally {
        	conn.close();
        }
		return success;
	}
	
	public boolean DeleteNpc(NpcCharacter character) throws SQLException {
		Boolean success = false;
		try {
			this.conn = this.sqlAccess.GetDBConnection();
			String query = "DELETE FROM " + this.sqlAccess.GetTheDBName() + ".characters_npc " + 
					"WHERE character_npc_id = ?";
			PreparedStatement preparedStmt = conn.prepareStatement(query);
			preparedStmt.setString (1, String.valueOf(character.GetNpcId()));
			
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
