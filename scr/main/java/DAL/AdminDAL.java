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
	
	public boolean CreateAdmin(int playerId) throws SQLException {
		Boolean success = false;
		try {
			this.conn = this.sqlAccess.GetDBConnection();
			String query = "INSERT INTO `" + this.sqlAccess.GetTheDBName() + "`.`admins`" + 
					"(`player_id`)" + 
					"VALUES (?)";
			 PreparedStatement preparedStmt = conn.prepareStatement(query);
			 preparedStmt.setString (1, String.valueOf(playerId));
			  			  
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
