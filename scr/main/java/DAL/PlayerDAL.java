package DAL;

import java.sql.*;

import model.Player;
/**
 * Data access layer for the Player database table
 * @author Perry Iler
 * @date 6/10/2020
 *
 */
public class PlayerDAL {
	private MySQLAccess sqlAccess;
	private Connection conn;
	
	/**
	 * Creates a PlayerDAL object to be used by the controllers
	 */
	public PlayerDAL(MySQLAccess theDBConnection) {
		this.sqlAccess = theDBConnection;
	}
	
	/**
	 * Retrieves a Player with a playername and playerpassword from the DB.
	 * 
	 * @param playerName
	 * @param playerPassword
	 * @return player with playername and password
	 * @throws SQLException
	 */
	public Player GetPlayer(String playerName, String playerPassword) throws SQLException {
    	Player player = null;
        try {
            this.conn = this.sqlAccess.GetDBConnection();
            Statement statement = this.conn.createStatement();
            String query = "SELECT * FROM `rpg_story_mapper_db`.`players` "
            		+ "WHERE `rpg_story_mapper_db`.`players`.`player_name` = \"" + playerName + "\""
            				+ "AND `rpg_story_mapper_db`.`players`.`player_password` = \"" + playerPassword + "\";";
            ResultSet results = statement.executeQuery(query);
            if (results.next() != false) {
                player = new Player();
                player.SetPlayerName(results.getString("player_name"));
                player.SetPlayerId(Integer.parseInt(results.getString("player_id")));
                player.SetPlayerPassword(results.getString("player_password"));
                player.SetPlayerEmail(results.getString("player_email"));
                player.SetPlayerCountryCode(results.getNString("player_country_code"));
            }
        } catch (Exception e) {
        	System.err.println(e.getMessage());
        }
        finally {
        	conn.close();
        }
        return player;
    }
	
	public boolean CreatePlayer(String playerName, String playerPassword, String email, String countryCode) throws SQLException {
		Boolean success = false;
		try {
			this.conn = this.sqlAccess.GetDBConnection();
			String query = "INSERT INTO `rpg_story_mapper_db`.`players`\r\n" + 
					"(`player_name`,`player_password`,`player_email`,`player_country_code`)" + 
					"VALUES (?, ?, ?, ?)";
			 PreparedStatement preparedStmt = conn.prepareStatement(query);
			  preparedStmt.setString (1, playerName);
			  preparedStmt.setString (2, playerPassword);
			  preparedStmt.setString (3, email);
			  preparedStmt.setString (4, countryCode);
			  
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
	
	public boolean UpdatePlayer(Player oldPlayer, Player updatedPlayer) throws SQLException {
		Boolean success = false;
		try {
			this.conn = this.sqlAccess.GetDBConnection();
			String query = "UPDATE `rpg_story_mapper_db`.`players`" +
					"SET " +
					"`player_name` = ?, " +
					"`player_password` = ?, " +
					"`player_email` = ?, " +
					"`player_country_code` = ? " +
					"WHERE `player_id` = ?";

			 PreparedStatement preparedStmt = conn.prepareStatement(query);
		      preparedStmt.setString (1, updatedPlayer.GetPlayerName());
		      preparedStmt.setString (2, updatedPlayer.GetPlayerPassword());
		      preparedStmt.setString (3, updatedPlayer.GetPlayerEmail());
		      preparedStmt.setString (4, updatedPlayer.GetPlayerCountryCode());
		      preparedStmt.setString (5, String.valueOf(oldPlayer.GetPlayerId()));
		      
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
	
	public boolean DeletePlayer(Player player) throws SQLException {
		Boolean success = false;
		try {
			this.conn = this.sqlAccess.GetDBConnection();
			String query = "DELETE FROM `rpg_story_mapper_db`.`players` " + 
					"WHERE `player_id` = ?";
			PreparedStatement preparedStmt = conn.prepareStatement(query);
			preparedStmt.setString (1, String.valueOf(player.GetPlayerId()));
			
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
