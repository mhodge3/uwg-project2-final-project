package com.cs6920.DAL;

import java.sql.*;

import com.cs6920.model.Admin;
/**
 * Data access layer for the Admins database table
 * @author Perry Iler
 * @date 6/10/2020
 *
 */
public class AdminDAL {
	private MySQLAccess sqlAccess;
	private Connection theConnection;
	
	public AdminDAL(MySQLAccess theDBConnection) {
		this.sqlAccess = theDBConnection;
		
	}

	public int getAdminID(int playerID) throws Exception {
		Admin admin = null;
        try {
            this.theConnection = this.sqlAccess.getDBConnection();
            Statement statement = this.theConnection.createStatement();
            String query = "SELECT * FROM `" + this.sqlAccess.getTheDBName() + "`.`admins` "
            		+ "WHERE `" + this.sqlAccess.getTheDBName() + "`.admins.`player_id` = "+ String.valueOf(playerID);
            ResultSet results = statement.executeQuery(query);
            if (results.next() != false) {
                admin = new Admin();
                admin.setAdminID(Integer.parseInt(results.getString("admin_id")));
                admin.setAdminID(Integer.parseInt(results.getString("player_id")));
                admin.setIsActive(Integer.parseInt(results.getString("is_active")));
            }
            
        } catch (Exception e) {
        }
        finally {
        	this.theConnection.close();
        }
		return admin.getAdminId();
    }
	
	private Boolean doesAdminExist(int playerId) {
		Boolean success = false;
		try {
			this.theConnection = this.sqlAccess.getDBConnection();
            Statement statement = this.theConnection.createStatement();
            String query = "SELECT * FROM " + this.sqlAccess.getTheDBName() + ".admins " + "WHERE player_id = \"" + playerId + "\"";
            ResultSet results = statement.executeQuery(query);
            if (results.next()) {
            	success = true;
            }
		} catch (Exception e) {
        	System.err.println(e.getMessage());
        }
		return success;
	}
	
	private Boolean updateAdminActiveStatus(int playerId, int makeActive) {
		Boolean success = false;
		try {
		String query = "UPDATE " + this.sqlAccess.getTheDBName() + ".`admins`" +
						"SET " +
						"is_active = ? " +
						"WHERE `player_id` = ?";
			PreparedStatement preparedStmt = this.theConnection.prepareStatement(query);
			preparedStmt.setString (1, String.valueOf(makeActive));
			preparedStmt.setString (2, String.valueOf(playerId));
			preparedStmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	     success = true;
		return success;
	}
	
	public boolean createAdmin(int playerId, int makeActive) throws SQLException {
		Boolean success = false;
		try {
			this.theConnection = this.sqlAccess.getDBConnection();
			if (doesAdminExist(playerId)) {
				this.updateAdminActiveStatus(playerId, makeActive);
			}
			else {
				String query = "INSERT INTO `" + this.sqlAccess.getTheDBName() + "`.`admins`" + 
						"(`player_id`, `is_active`)" + 
						"VALUES (?, ?)";
				 PreparedStatement preparedStmt = this.theConnection.prepareStatement(query);
				 preparedStmt.setString (1, String.valueOf(playerId));
				 preparedStmt.setString (2, String.valueOf(makeActive));
				  			  
			     preparedStmt.execute();
			     success = true;
			}
		} catch (Exception e) {
        	System.err.println(e.getMessage());
        }
        finally {
        	this.theConnection.close();
        }
		return success;
	}

}
