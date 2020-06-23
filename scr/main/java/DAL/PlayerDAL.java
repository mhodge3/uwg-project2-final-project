package DAL;

import java.sql.*;
import java.util.ArrayList;

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
	private AdminDAL adminDAL;
	
	/**
	 * Creates a PlayerDAL object to be used by the controllers
	 */
	public PlayerDAL(MySQLAccess theDBConnection) {
		this.sqlAccess = theDBConnection;
		this.adminDAL = new AdminDAL(theDBConnection);
	}
	
	/**
	 * Retrieves a list of all user (player) accounts
	 * @return the ArrayList of Users (players)
	 * @throws SQLException
	 */
	public ArrayList<Player> GetPlayers() throws SQLException {
		ArrayList<Player> thePlayerArrayList = new ArrayList<Player>();
        try {
            this.conn = this.sqlAccess.GetDBConnection();
            Statement statement = this.conn.createStatement();
            String query = "SELECT * FROM `" + this.sqlAccess.GetTheDBName() + "`.`players`;";
            ResultSet results = statement.executeQuery(query);
            while (results.next() != false) {
                Player thisPlayer = new Player();
                thisPlayer.SetPlayerName(results.getString("player_name"));
                thisPlayer.SetPlayerId(Integer.parseInt(results.getString("player_id")));
                thisPlayer.SetPlayerPassword(results.getString("player_password"));
                thisPlayer.SetPlayerEmail(results.getString("player_email"));
                thisPlayer.SetPlayerCountryCode(results.getNString("player_country_code"));
                thisPlayer.SetPlayerIsAdmin(IsPlayerAdmin(thisPlayer));
                thePlayerArrayList.add(thisPlayer);
            }
        } catch (Exception e) {
        	System.err.println(e.getMessage());
        }
        finally {
        	conn.close();
        }
        return thePlayerArrayList;
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
            String query = "SELECT * FROM " + this.sqlAccess.GetTheDBName() + ".players "
            		+ "WHERE " + this.sqlAccess.GetTheDBName() + ".players.player_name = \"" + playerName + "\""
            				+ " AND " + this.sqlAccess.GetTheDBName() + ".players.player_password = \"" + playerPassword + "\";";
            ResultSet results = statement.executeQuery(query);
            if (results.next() != false) {
                player = new Player();
                player.SetPlayerName(results.getString("player_name"));
                player.SetPlayerId(Integer.parseInt(results.getString("player_id")));
                player.SetPlayerPassword(results.getString("player_password"));
                player.SetPlayerEmail(results.getString("player_email"));
                player.SetPlayerCountryCode(results.getNString("player_country_code"));
                player.SetPlayerIsAdmin(IsPlayerAdmin(player));
            }
        } catch (Exception e) {
        	System.err.println(e.getMessage());
        }
        finally {
        	conn.close();
        }
        return player;
    }
	
	/**
	 * Returns player by ID. Used for management of players, not verification for login as player
	 * @param playerId
	 * @return The Player looked up
	 * @throws SQLException
	 */
	public Player GetPlayer(int playerId) throws SQLException {
    	Player player = null;
        try {
            this.conn = this.sqlAccess.GetDBConnection();
            Statement statement = this.conn.createStatement();
            String query = "SELECT * FROM " + this.sqlAccess.GetTheDBName() + ".players "
            		+ "WHERE " + this.sqlAccess.GetTheDBName() + ".players.player_id = " + playerId + ";";
            ResultSet results = statement.executeQuery(query);
            if (results.next() != false) {
                player = new Player();
                player.SetPlayerName(results.getString("player_name"));
                player.SetPlayerId(Integer.parseInt(results.getString("player_id")));
                player.SetPlayerPassword(results.getString("player_password"));
                player.SetPlayerEmail(results.getString("player_email"));
                player.SetPlayerCountryCode(results.getNString("player_country_code"));
                player.SetPlayerIsAdmin(IsPlayerAdmin(player));
            }
        } catch (Exception e) {
        	System.err.println(e.getMessage());
        }
        finally {
        	conn.close();
        }
        return player;
    }
	
	/**
	 * Creates a Player entry in the database players table
	 * @param playerName
	 * @param playerPassword
	 * @param email
	 * @param countryCode
	 * @param makeAdmin
	 * @return
	 * @throws SQLException
	 */
	public boolean CreatePlayer(String playerName, String playerPassword, String email, String countryCode, Boolean makeAdmin) throws SQLException {
		Boolean success = false;
		try {
			this.conn = this.sqlAccess.GetDBConnection();
			String query = "INSERT INTO " + this.sqlAccess.GetTheDBName() + ".`players`" + 
					"(`player_name`,`player_password`,`player_email`,`player_country_code`)" + 
					"VALUES (?, ?, ?, ?)";
			 PreparedStatement preparedStmt = conn.prepareStatement(query);
			  preparedStmt.setString (1, playerName);
			  preparedStmt.setString (2, playerPassword);
			  preparedStmt.setString (3, email);
			  preparedStmt.setString (4, countryCode);
			  
		      preparedStmt.execute();
		      if (makeAdmin) {
		    	  makeAdmin();
		      }
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
	 * Gets the playerId of the last player inserted into the database players table
	 * @return
	 * @throws SQLException
	 */
	public Integer GetLastInsertedID() throws SQLException {
		Integer lastID = null;
		try {
			this.conn = this.sqlAccess.GetDBConnection();
			String query = "SELECT LAST_INSERT_ID();";
			PreparedStatement getLastInsertId = conn.prepareStatement(query);
			ResultSet results = getLastInsertId.executeQuery();
			if (results.next())
			{
				lastID = results.getInt("last_insert_id()");            
			}
		} catch (Exception e) {
        	System.err.println(e.getMessage());
        }
        finally {
        	conn.close();
        }
		return lastID;
	}
	
	private void makeAdmin() {
		makeAdmin(0, 1);
	}
	
	private void makeAdmin(int idToMakeAdmin, int makeActive) {
		try {
			Integer theId = idToMakeAdmin;
			if (theId == 0) {
				String query = "SELECT LAST_INSERT_ID();";
				PreparedStatement getLastInsertId = conn.prepareStatement(query);
				ResultSet results = getLastInsertId.executeQuery();
				if (results.next())
				{
					theId = results.getInt("last_insert_id()");            
				}
			}
			if (theId > 0) {
				adminDAL.CreateAdmin(theId, makeActive);
			}
		}
		catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
	
	/**
	 * Updates an existing Player entry in the database players table
	 * @param oldPlayer
	 * @param updatedPlayer
	 * @param makeAdmin
	 * @return 
	 * @throws SQLException
	 */
	public boolean UpdatePlayer(Player oldPlayer, Player updatedPlayer, Boolean makeAdmin) throws SQLException {
		Boolean success = false;
		try {
			this.conn = this.sqlAccess.GetDBConnection();
			String query = "UPDATE " + this.sqlAccess.GetTheDBName() + ".`players`" +
					"SET " +
					"player_name = ?, " +
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
			if (makeAdmin) {
				makeAdmin(oldPlayer.GetPlayerId(), 1);
			}
			else {
				makeAdmin(oldPlayer.GetPlayerId(), 0);
			}
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
			String query = "DELETE FROM " + this.sqlAccess.GetTheDBName() + ".`players` " + 
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
	
	/**
	 * Returns weather is a player is a admin 
	 * @param player
	 * @return True if Admin | False if not Admin
	 * @throws Exception
	 */
	public Boolean IsPlayerAdmin(Player player) throws Exception {
    	Boolean isAdmin = false;
        try {
            this.conn = this.sqlAccess.GetDBConnection();
            Statement statement = this.conn.createStatement();
            String query = "SELECT * FROM " + this.sqlAccess.GetTheDBName() + ".admins " + "WHERE player_id = \"" + player.GetPlayerId() + "\" AND is_active = 1";
            ResultSet results = statement.executeQuery(query);
            if (results.next()) {
            	isAdmin = true;
            }
        } catch (Exception e) {
        }
        finally {
        	conn.close();
        }
        return isAdmin;
    }
	

}
