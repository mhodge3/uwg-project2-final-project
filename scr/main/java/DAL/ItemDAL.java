package DAL;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Item;

/**
 * Data Access Layer for Items
 * @author Matthew Hodge
 * @version 6.18.2020
 */
public class ItemDAL {
	private MySQLAccess sqlAccess;
	private Connection conn;
	
	/**
	 * Creates a PlayerDAL object to be used by the controllers
	 */
	public ItemDAL(MySQLAccess theDBConnection) {
		this.sqlAccess = theDBConnection;
	}
	
	/**
	 * Get Items in Items table
	 * @return The Array List of Items
	 * @throws SQLException
	 */
	public ArrayList<Item> GetItems() throws SQLException {
		ArrayList<Item> theItemArrayList = new ArrayList<Item>();
		return theItemArrayList; 
	}

}
