package DAL;

import java.sql.*;

import model.Admin;
/**
 * Data access layer for the Admins database table
 * @author Perry Iler
 * @date 6/10/2020
 *
 */
public class AdminDAL {
	private MySQLAccess sqlAccess;
	private Connection conn;
	
	public AdminDAL() {
		this.sqlAccess = new MySQLAccess();
		
	}
	

	public Admin getAdmin() throws Exception {
     
		Admin admin = null;
		
		
		return admin;
    }

}
