package DAL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.Item;
import model.NpcCharacter;

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
		
		try {
            this.conn = this.sqlAccess.GetDBConnection();
            Statement statement = this.conn.createStatement();
            String query = "SELECT  item_id, " + 
            		"item_name, " + 
            		"item_description, " + 
            		"item_type, " + 
            		"is_quest_item, " + 
            		"is_implicit_item " +
            	"FROM " + this.sqlAccess.GetTheDBName() + ".items ";
            ResultSet results = statement.executeQuery(query);
            while (results.next() != false) {
            	Item item = new Item();
                item.SetItemId(Integer.parseInt(results.getString("item_id")));
                item.SetItemName(results.getString("character_item_name"));
                item.SetItemDescription(results.getString("character_item_description"));
                item.SetItemType(Integer.parseInt(results.getString("item_type")));
                item.SetIsQuestItem(Boolean.parseBoolean(results.getString("is_quest_item")));
                item.SetIsImplicitItem(Boolean.parseBoolean(results.getString("is_implicit_item")));
                theItemArrayList.add(item);
            }
        } catch (Exception e) {
        	System.err.println(e.getMessage());
        }
        finally {
        	conn.close();
        }
		return theItemArrayList; 
	}
	
	/**
	 * Get Item by itemID from the database Items table
	 * @return The Item
	 * @throws SQLException
	 */
	public Item GetItemById(int itemId) throws SQLException {
		Item item = null;
		
		try {
            this.conn = this.sqlAccess.GetDBConnection();
            Statement statement = this.conn.createStatement();
            String query = "SELECT  item_id," + 
            		"item_name, " + 
            		"item_description, " + 
            		"item_type, " + 
            		"is_quest_item, " + 
            		"is_implicit_item " +
            	"FROM " + this.sqlAccess.GetTheDBName() + ".items " +
            		"WHERE item_id = \"" + itemId + "\"";
            ResultSet results = statement.executeQuery(query);
            if (results.next() != false) {
            	item = new Item();
                item.SetItemId(Integer.parseInt(results.getString("item_id")));
                item.SetItemName(results.getString("item_name"));
                item.SetItemDescription(results.getString("item_description"));
                item.SetItemType(Integer.parseInt(results.getString("item_type")));
                item.SetIsQuestItem(Boolean.parseBoolean(results.getString("is_quest_item")));
                item.SetIsImplicitItem(Boolean.parseBoolean(results.getString("is_implicit_item")));
            }
        } catch (Exception e) {
        	System.err.println(e.getMessage());
        }
        finally {
        	conn.close();
        }
		return item; 
	}
	
	/**
	 * Get Item by itemName from the database Items table
	 * @return The Item
	 * @throws SQLException
	 */
	public Item GetItemByName(String itemName) throws SQLException {
		Item item = null;
		
		try {
            this.conn = this.sqlAccess.GetDBConnection();
            Statement statement = this.conn.createStatement();
            String query = "SELECT  item_id," + 
            		"item_name, " + 
            		"item_description, " + 
            		"item_type, " + 
            		"is_quest_item, " + 
            		"is_implicit_item " +
            	"FROM " + this.sqlAccess.GetTheDBName() + ".items " +
            		"WHERE item_name = \"" + itemName + "\"";
            ResultSet results = statement.executeQuery(query);
            if (results.next() != false) {
            	item = new Item();
                item.SetItemId(Integer.parseInt(results.getString("item_id")));
                item.SetItemName(results.getString("item_name"));
                item.SetItemDescription(results.getString("item_description"));
                item.SetItemType(Integer.parseInt(results.getString("item_type")));
                item.SetIsQuestItem(Boolean.parseBoolean(results.getString("is_quest_item")));
                item.SetIsImplicitItem(Boolean.parseBoolean(results.getString("is_implicit_item")));
            }
        } catch (Exception e) {
        	System.err.println(e.getMessage());
        }
        finally {
        	conn.close();
        }
		return item; 
	}
	
	public Boolean CreateItem(String itemName, String itemDescription, int itemType, int isQuestItem, int isImplicitItem) throws SQLException {
		Boolean success = false;
		try {
			this.conn = this.sqlAccess.GetDBConnection();
			String query = "INSERT INTO " + this.sqlAccess.GetTheDBName() + ".items " + 
					"(item_name, " + 
            		"item_description, " + 
            		"item_type, " + 
            		"is_quest_item, " + 
            		"is_implicit_item) " +
					"VALUES (?, ?, ?, ?, ?)";
			 PreparedStatement preparedStmt = conn.prepareStatement(query);
			  preparedStmt.setString (1, itemName);
			  preparedStmt.setString (2, itemDescription);
			  preparedStmt.setString (3, String.valueOf(itemType));
			  preparedStmt.setString (4, String.valueOf(isQuestItem));
			  preparedStmt.setString (5, String.valueOf(isImplicitItem));
			  
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
	
	public Boolean UpdateItem(Item oldItem, Item updatedItem) throws SQLException {
		Boolean success = false;
		try {
			this.conn = this.sqlAccess.GetDBConnection();
			String query = "UPDATE " + this.sqlAccess.GetTheDBName() + ".items " + 
					"SET " +
					"item_name = ?, " + 
            		"item_description = ?, " + 
            		"item_type = ?, " + 
            		"is_quest_item = ?, " + 
            		"is_implicit_item = ? " +
            	    "WHERE item_id = ?";
		
			 PreparedStatement preparedStmt = conn.prepareStatement(query);
			  preparedStmt.setString (1, updatedItem.GetItemName());
			  preparedStmt.setString (2, updatedItem.GetItemDescription());
			  preparedStmt.setString (3, String.valueOf(updatedItem.GetItemType()));
			  preparedStmt.setString (4, String.valueOf(updatedItem.GetIsImplicitItem()));
			  preparedStmt.setString (5, String.valueOf(updatedItem.GetIsImplicitItem()));
			  preparedStmt.setString (6, String.valueOf(oldItem.GetItemId()));
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
	
	public boolean DeleteItem(Item item) throws SQLException {
		Boolean success = false;
		try {
			this.conn = this.sqlAccess.GetDBConnection();
			String query = "DELETE FROM " + this.sqlAccess.GetTheDBName() + ".items " + 
					"WHERE item_id = ?";
			PreparedStatement preparedStmt = conn.prepareStatement(query);
			preparedStmt.setString (1, String.valueOf(item.GetItemId()));
			
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
