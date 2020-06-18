package DAL;

import java.sql.*;

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
	private String dataBase;
	
	public NpcCharacterDAL(MySQLAccess theDBConnection) {
		this.sqlAccess = theDBConnection;
		this.dataBase = this.sqlAccess.GetTheDBName();
	}
	
	public NpcCharacter GetNpc(int npcId) throws SQLException {
		NpcCharacter npc = null;
        try {
            this.conn = this.sqlAccess.GetDBConnection();
            Statement statement = this.conn.createStatement();
            String query = "SELECT `characters_npc`.`character_npc_id`, " +
            	    "`characters_npc`.`character_npc_name`, " +
            	    "`characters_npc`.`character_npc_description`, " +
            	    "`characters_npc`.`character_npc_type`, " + 
            	    "`characters_npc`.`character_npc_faction`, " +
            	    "`characters_npc`.`character_npc_pos_x`, " +
            	    "`characters_npc`.`character_npc_pos_y`, " +
            	    "`characters_npc`.`character_npc_pos_z` " +
            	"FROM `rpg_story_mapper_db`.`characters_npc` " +
            	"WHERE " + this.dataBase + ".characters_npc.character_npc_id = \"" + String.valueOf(npcId) + "\"";
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

}
