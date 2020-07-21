package com.cs6920.DAL;

import java.sql.*;
import java.util.ArrayList;

import com.cs6920.model.Player;
/**
 * Data access layer for the Player database table
 * @author Perry Iler
 * @date 6/10/2020
 *
 */
public class PlayerDAL {
	private MySQLAccess sqlAccess;
	private Connection theConnection;
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
	public ArrayList<Player> getPlayers() throws SQLException {
		ArrayList<Player> thePlayerArrayList = new ArrayList<Player>();
        try {
            this.theConnection = this.sqlAccess.getDBConnection();
            Statement statement = this.theConnection.createStatement();
            String query = "SELECT * FROM `" + this.sqlAccess.getTheDBName() + "`.`players`;";
            ResultSet results = statement.executeQuery(query);
            while (results.next() != false) {
                Player thisPlayer = new Player();
                thisPlayer.setPlayerName(results.getString("player_name"));
                thisPlayer.setPlayerId(Integer.parseInt(results.getString("player_id")));
                thisPlayer.setPlayerPassword(results.getString("player_password"));
                thisPlayer.setPlayerEmail(results.getString("player_email"));
                thisPlayer.setPlayerCountryCode(results.getNString("player_country_code"));
                thisPlayer.setPlayerIsAdmin(isPlayerAdmin(thisPlayer));
                thePlayerArrayList.add(thisPlayer);
            }
        } catch (Exception e) {
        	System.err.println(e.getMessage());
        }
        finally {
        	theConnection.close();
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
	public Player getPlayer(String playerName, String playerPassword) throws SQLException {
    	Player player = null;
        try {
            this.theConnection = this.sqlAccess.getDBConnection();
            Statement statement = this.theConnection.createStatement();
            String query = "SELECT * FROM " + this.sqlAccess.getTheDBName() + ".players "
            		+ "WHERE " + this.sqlAccess.getTheDBName() + ".players.player_name = \"" + playerName + "\""
            				+ " AND " + this.sqlAccess.getTheDBName() + ".players.player_password = \"" + playerPassword + "\";";
            ResultSet results = statement.executeQuery(query);
            if (results.next() != false) {
                player = new Player();
                player.setPlayerName(results.getString("player_name"));
                player.setPlayerId(Integer.parseInt(results.getString("player_id")));
                player.setPlayerPassword(results.getString("player_password"));
                player.setPlayerEmail(results.getString("player_email"));
                player.setPlayerCountryCode(results.getNString("player_country_code"));
                player.setPlayerIsAdmin(isPlayerAdmin(player));
            }
        } catch (Exception e) {
        	System.err.println(e.getMessage());
        }
        finally {
        	theConnection.close();
        }
        return player;
    }
	
	/**
	 * Returns player by ID. Used for management of players, not verification for login as player
	 * @param playerId
	 * @return The Player looked up
	 * @throws SQLException
	 */
	public Player getPlayer(int playerId) throws SQLException {
    	Player player = null;
        try {
            this.theConnection = this.sqlAccess.getDBConnection();
            Statement statement = this.theConnection.createStatement();
            String query = "SELECT * FROM " + this.sqlAccess.getTheDBName() + ".players "
            		+ "WHERE " + this.sqlAccess.getTheDBName() + ".players.player_id = " + playerId + ";";
            ResultSet results = statement.executeQuery(query);
            if (results.next() != false) {
                player = new Player();
                player.setPlayerName(results.getString("player_name"));
                player.setPlayerId(Integer.parseInt(results.getString("player_id")));
                player.setPlayerPassword(results.getString("player_password"));
                player.setPlayerEmail(results.getString("player_email"));
                player.setPlayerCountryCode(results.getNString("player_country_code"));
                player.setPlayerIsAdmin(isPlayerAdmin(player));
            }
        } catch (Exception e) {
        	System.err.println(e.getMessage());
        }
        finally {
        	theConnection.close();
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
	public boolean createPlayer(String playerName, String playerPassword, String email, String countryCode, Boolean makeAdmin) throws SQLException {
		Boolean success = false;
		try {
			this.theConnection = this.sqlAccess.getDBConnection();
			String query = "INSERT INTO " + this.sqlAccess.getTheDBName() + ".`players`" + 
					"(`player_name`,`player_password`,`player_email`,`player_country_code`)" + 
					"VALUES (?, ?, ?, ?)";
			 PreparedStatement preparedStmt = theConnection.prepareStatement(query);
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
        	theConnection.close();
        }
		return success;
	}
	
	/**
	 * Gets the playerId of the last player inserted into the database players table
	 * @return
	 * @throws SQLException
	 */
	public Integer getLastInsertedID() throws SQLException {
		Integer lastID = null;
		try {
			this.theConnection = this.sqlAccess.getDBConnection();
			String query = "SELECT LAST_INSERT_ID();";
			PreparedStatement getLastInsertId = theConnection.prepareStatement(query);
			ResultSet results = getLastInsertId.executeQuery();
			if (results.next())
			{
				lastID = results.getInt("last_insert_id()");            
			}
		} catch (Exception e) {
        	System.err.println(e.getMessage());
        }
        finally {
        	theConnection.close();
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
				PreparedStatement getLastInsertId = theConnection.prepareStatement(query);
				ResultSet results = getLastInsertId.executeQuery();
				if (results.next())
				{
					theId = results.getInt("last_insert_id()");            
				}
			}
			if (theId > 0) {
				adminDAL.createAdmin(theId, makeActive);
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
	public boolean updatePlayer(Player oldPlayer, Player updatedPlayer, Boolean makeAdmin) throws SQLException {
		Boolean success = false;
		try {
			this.theConnection = this.sqlAccess.getDBConnection();
			String query = "UPDATE " + this.sqlAccess.getTheDBName() + ".`players`" +
					"SET " +
					"player_name = ?, " +
					"`player_password` = ?, " +
					"`player_email` = ?, " +
					"`player_country_code` = ? " +
					"WHERE `player_id` = ?";

			 PreparedStatement preparedStmt = theConnection.prepareStatement(query);
		      preparedStmt.setString (1, updatedPlayer.getPlayerName());
		      preparedStmt.setString (2, updatedPlayer.getPlayerPassword());
		      preparedStmt.setString (3, updatedPlayer.getPlayerEmail());
		      preparedStmt.setString (4, updatedPlayer.getPlayerCountryCode());
		      preparedStmt.setString (5, String.valueOf(oldPlayer.getPlayerId()));

		      preparedStmt.execute();
			if (makeAdmin) {
				makeAdmin(oldPlayer.getPlayerId(), 1);
			}
			else {
				makeAdmin(oldPlayer.getPlayerId(), 0);
			}
		      success = true;
		} catch (Exception e) {
        	System.err.println(e.getMessage());
        }
        finally {
        	theConnection.close();
        }
		return success;
	}
	
	public boolean deletePlayer(Player player) throws SQLException {
		Boolean success = false;
		try {
			this.theConnection = this.sqlAccess.getDBConnection();
			String query = "DELETE FROM " + this.sqlAccess.getTheDBName() + ".`players` " + 
					"WHERE `player_id` = ?";
			PreparedStatement preparedStmt = theConnection.prepareStatement(query);
			preparedStmt.setString (1, String.valueOf(player.getPlayerId()));
			
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
	
	/**
	 * Returns weather is a player is a admin 
	 * @param player
	 * @return True if Admin | False if not Admin
	 * @throws Exception
	 */
	public Boolean isPlayerAdmin(Player player) throws Exception {
    	Boolean isAdmin = false;
        try {
            this.theConnection = this.sqlAccess.getDBConnection();
            Statement statement = this.theConnection.createStatement();
            String query = "SELECT * FROM " + this.sqlAccess.getTheDBName() + ".admins " + "WHERE player_id = \"" + player.getPlayerId() + "\" AND is_active = 1";
            ResultSet results = statement.executeQuery(query);
            if (results.next()) {
            	isAdmin = true;
            }
        } catch (Exception e) {
        }
        finally {
        	theConnection.close();
        }
        return isAdmin;
    }
	

}
