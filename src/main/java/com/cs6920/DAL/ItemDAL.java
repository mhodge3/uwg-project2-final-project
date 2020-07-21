package com.cs6920.DAL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.cs6920.model.Item;

/**
 * Data Access Layer for Items
 * @author Matthew Hodge
 * @version 6.18.2020
 */
public class ItemDAL {
	private MySQLAccess sqlAccess;
	private Connection theConnection;
	
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
	public ArrayList<Item> getItems() throws SQLException {
		ArrayList<Item> theItemArrayList = new ArrayList<Item>();
		
		try {
            this.theConnection = this.sqlAccess.getDBConnection();
            Statement statement = this.theConnection.createStatement();
            String query = "SELECT  item_id, " + 
            		"item_name, " + 
            		"item_description, " + 
            		"item_type, " + 
            		"is_quest_item, " + 
            		"is_implicit_item, " +
            		"is_trophy_item " +
            	"FROM " + this.sqlAccess.getTheDBName() + ".items ";
            ResultSet results = statement.executeQuery(query);
            while (results.next() != false) {
            	Item item = new Item();
                item.setItemId(Integer.parseInt(results.getString("item_id")));
                item.setItemName(results.getString("item_name"));
                item.setItemDescription(results.getString("item_description"));
                item.setItemType(Integer.parseInt(results.getString("item_type")));
                item.setIsQuestItem(Integer.parseInt(results.getString("is_quest_item")) > 0 ? true : false);
                item.setIsImplicitItem(Integer.parseInt(results.getString("is_implicit_item")) > 0 ? true : false);
                item.setIsTrophy(Integer.parseInt(results.getString("is_trophy_item")) > 0 ? true : false);
                theItemArrayList.add(item);
            }
        } catch (Exception e) {
        	System.err.println(e.getMessage());
        }
        finally {
        	this.theConnection.close();
        }
		return theItemArrayList; 
	}
	
	/**
	 * Get Item by itemID from the database Items table
	 * @return The Item
	 * @throws SQLException
	 */
	public Item getItemById(int itemId) throws SQLException {
		Item item = null;
		
		try {
            this.theConnection = this.sqlAccess.getDBConnection();
            Statement statement = this.theConnection.createStatement();
            String query = "SELECT  item_id," + 
            		"item_name, " + 
            		"item_description, " + 
            		"item_type, " + 
            		"is_quest_item, " + 
            		"is_implicit_item, " +
            		"is_trophy_item " +
            	"FROM " + this.sqlAccess.getTheDBName() + ".items " +
            		"WHERE item_id = \"" + itemId + "\"";
            ResultSet results = statement.executeQuery(query);
            if (results.next() != false) {
            	item = new Item();
                item.setItemId(Integer.parseInt(results.getString("item_id")));
                item.setItemName(results.getString("item_name"));
                item.setItemDescription(results.getString("item_description"));
                item.setItemType(Integer.parseInt(results.getString("item_type")));
                item.setIsQuestItem(Integer.parseInt(results.getString("is_quest_item")) > 0 ? true : false);
                item.setIsImplicitItem(Integer.parseInt(results.getString("is_implicit_item")) > 0 ? true : false);
                item.setIsTrophy(Integer.parseInt(results.getString("is_trophy_item")) > 0 ? true : false);
            }
        } catch (Exception e) {
        	System.err.println(e.getMessage());
        }
        finally {
        	this.theConnection.close();
        }
		return item; 
	}
	
	/**
	 * Get Item by itemName from the database Items table
	 * @return The Item
	 * @throws SQLException
	 */
	public Item getItemByName(String itemName) throws SQLException {
		Item item = null;
		
		try {
            this.theConnection = this.sqlAccess.getDBConnection();
            Statement statement = this.theConnection.createStatement();
            String query = "SELECT  item_id," + 
            		"item_name, " + 
            		"item_description, " + 
            		"item_type, " + 
            		"is_quest_item, " + 
            		"is_implicit_item, " +
            		"is_trophy_item " +
            	"FROM " + this.sqlAccess.getTheDBName() + ".items " +
            		"WHERE item_name = \"" + itemName + "\"";
            ResultSet results = statement.executeQuery(query);
            if (results.next() != false) {
            	item = new Item();
                item.setItemId(Integer.parseInt(results.getString("item_id")));
                item.setItemName(results.getString("item_name"));
                item.setItemDescription(results.getString("item_description"));
                item.setItemType(Integer.parseInt(results.getString("item_type")));
                item.setIsQuestItem(Boolean.parseBoolean(results.getString("is_quest_item")));
                item.setIsImplicitItem(Boolean.parseBoolean(results.getString("is_implicit_item")));
                item.setIsTrophy(Boolean.parseBoolean(results.getString("is_trophy_item")));
            }
        } catch (Exception e) {
        	System.err.println(e.getMessage());
        }
        finally {
        	this.theConnection.close();
        }
		return item; 
	}
	
	public Boolean createItem(String itemName, String itemDescription, int itemType, Boolean isQuestItem, Boolean isImplicitItem, Boolean isTrophyItem) throws SQLException {
		Boolean success = false;
		try {
			this.theConnection = this.sqlAccess.getDBConnection();
			String query = "INSERT INTO " + this.sqlAccess.getTheDBName() + ".items " + 
					"(item_name, " + 
            		"item_description, " + 
            		"item_type, " + 
            		"is_quest_item, " + 
            		"is_implicit_item, " +
            		"is_trophy_item) " +
					"VALUES (?, ?, ?, ?, ?, ?)";
			 PreparedStatement preparedStmt = this.theConnection.prepareStatement(query);
			  preparedStmt.setString (1, itemName);
			  preparedStmt.setString (2, itemDescription);
			  preparedStmt.setString (3, String.valueOf(itemType));
			  int questBoolToInt = isQuestItem ? 1 : 0;
			  preparedStmt.setString (4, String.valueOf(questBoolToInt));
			  int implicitBoolToInt = isImplicitItem ? 1 : 0;
			  preparedStmt.setString (5, String.valueOf(implicitBoolToInt));
			  int trophyBoolToInt = isTrophyItem ? 1 : 0;
			  preparedStmt.setString (6, String.valueOf(trophyBoolToInt));
		      preparedStmt.execute();
		      success = true;
		} catch (Exception e) {
        	System.err.println(e.getMessage());
        }
        finally {
        	this.theConnection.close();
        }
		return success;
	}
	
	public Boolean updateItem(Item oldItem, Item updatedItem) throws SQLException {
		Boolean success = false;
		try {
			this.theConnection = this.sqlAccess.getDBConnection();
			String query = "UPDATE " + this.sqlAccess.getTheDBName() + ".items " + 
					"SET " +
					"item_name = ?, " + 
            		"item_description = ?, " + 
            		"item_type = ?, " + 
            		"is_quest_item = ?, " + 
            		"is_implicit_item = ?, " +
            		"is_trophy_item = ? " +
            	    "WHERE item_id = ?";
		
			 PreparedStatement preparedStmt = this.theConnection.prepareStatement(query);
			  preparedStmt.setString (1, updatedItem.getItemName());
			  preparedStmt.setString (2, updatedItem.getItemDescription());
			  preparedStmt.setString (3, String.valueOf(updatedItem.getItemType()));
			  int questBoolToInt = updatedItem.getIsQuestItem() ? 1 : 0;
			  preparedStmt.setString (4, String.valueOf(questBoolToInt));
			  int implicitBoolToInt = updatedItem.getIsImplicitItem() ? 1 : 0;
			  preparedStmt.setString (5, String.valueOf(implicitBoolToInt));
			  int trophyBoolToInt = updatedItem.getIstrophy() ? 1 : 0;
			  preparedStmt.setString (6, String.valueOf(trophyBoolToInt));
			  preparedStmt.setString (7, String.valueOf(oldItem.getItemId()));
		      preparedStmt.execute();
		      success = true;
		} catch (Exception e) {
        	System.err.println(e.getMessage());
        }
        finally {
        	this.theConnection.close();
        }
		return success;
	}
	
	public boolean deleteItem(Item item) throws SQLException {
		Boolean success = false;
		try {
			this.theConnection = this.sqlAccess.getDBConnection();
			String query = "DELETE FROM " + this.sqlAccess.getTheDBName() + ".items " + 
					"WHERE item_id = ?";
			PreparedStatement preparedStmt = this.theConnection.prepareStatement(query);
			preparedStmt.setString (1, String.valueOf(item.getItemId()));
			
			preparedStmt.execute();
		      success = true;
		} catch (Exception e) {
        	System.err.println(e.getMessage());
        }
        finally {
        	this.theConnection.close();
        }
		return success;
	}
	

}
