package DAL;

import java.sql.*;

import model.Admin;
import model.Player;
/**
 * Data access layer for the Admins database table
 * @author Perry Iler
 * @date 6/10/2020
 *
 */
public class AdminDAL {
	private MySQLAccess sqlAccess;
	private Connection conn;
	
	public AdminDAL(MySQLAccess theDBConnection) {
		this.sqlAccess = theDBConnection;
		
	}

	public int getAdminID(int playerID) throws Exception {
		Admin admin = null;
        try {
            this.conn = this.sqlAccess.GetDBConnection();
            Statement statement = this.conn.createStatement();
            String query = "SELECT * FROM `" + this.sqlAccess.GetTheDBName() + "`.`admins` "
            		+ "WHERE `" + this.sqlAccess.GetTheDBName() + "`.admins.`player_id` = "+ String.valueOf(playerID);
            ResultSet results = statement.executeQuery(query);
            if (results.next() != false) {
                admin = new Admin();
                admin.SetAdminID(Integer.parseInt(results.getString("admin_id")));
                admin.SetAdminID(Integer.parseInt(results.getString("player_id")));
            }
            
        } catch (Exception e) {
        }
        finally {
        	conn.close();
        }
		return admin.GetAdminId();
    }
	
	private Boolean doesAdminExist(int playerId) {
		Boolean success = false;
		try {
			this.conn = this.sqlAccess.GetDBConnection();
            Statement statement = this.conn.createStatement();
            String query = "SELECT * FROM " + this.sqlAccess.GetTheDBName() + ".admins " + "WHERE player_id = \"" + playerId + "\"";
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
		String query = "UPDATE " + this.sqlAccess.GetTheDBName() + ".`admins`" +
						"SET " +
						"is_active = ? " +
						"WHERE `player_id` = ?";
			PreparedStatement preparedStmt = conn.prepareStatement(query);
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
	
	public boolean CreateAdmin(int playerId, int makeActive) throws SQLException {
		Boolean success = false;
		try {
			this.conn = this.sqlAccess.GetDBConnection();
			if (doesAdminExist(playerId)) {
				this.updateAdminActiveStatus(playerId, makeActive);
			}
			else {
				String query = "INSERT INTO `" + this.sqlAccess.GetTheDBName() + "`.`admins`" + 
						"(`player_id`, `is_active`)" + 
						"VALUES (?, ?)";
				 PreparedStatement preparedStmt = conn.prepareStatement(query);
				 preparedStmt.setString (1, String.valueOf(playerId));
				 preparedStmt.setString (2, String.valueOf(makeActive));
				  			  
			     preparedStmt.execute();
			     success = true;
			}
		} catch (Exception e) {
        	System.err.println(e.getMessage());
        }
        finally {
        	conn.close();
        }
		return success;
	}

}
