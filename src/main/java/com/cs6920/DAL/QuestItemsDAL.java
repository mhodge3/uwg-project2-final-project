package com.cs6920.DAL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.cs6920.model.QuestItems;

/**
 * Data Access Layer for QuestItems
 * @author Matthew Hodge
 * @version 7.3.2020
 */
public class QuestItemsDAL {
	private MySQLAccess sqlAccess;
	private Connection conn;
	
	/**
	 * Creates a QuestItemsDAL object to be used by the controllers
	 */
	public QuestItemsDAL(MySQLAccess theDBConnection) {
		this.sqlAccess = theDBConnection;
	}
	
	/**
	 * Get Quest Items in QuestItems table
	 * @return The Array List of QuestItems
	 * @throws SQLException
	 */
	public ArrayList<QuestItems> GetQuestItemsByQuestId(int questId) throws SQLException {
		ArrayList<QuestItems> theQuestItemsArrayList = new ArrayList<QuestItems>();
		
		try {
            this.conn = this.sqlAccess.GetDBConnection();
            Statement statement = this.conn.createStatement();
            String query = "SELECT  quest_id, " + 
            		"item_id, " + 
            		"item_quantity, " + 
            		"item_display_name " + 
            	"FROM " + this.sqlAccess.GetTheDBName() + ".questitems "
            			+ "WHERE `quest_id` = \"" + questId + "\";";
            ResultSet results = statement.executeQuery(query);
            while (results.next() != false) {
            	QuestItems questItem = new QuestItems();
                questItem.SetQuestId(Integer.parseInt(results.getString("quest_id")));
                questItem.SetItemId(Integer.parseInt(results.getString("item_id")));
                questItem.SetItemQuantity(Integer.parseInt(results.getString("item_quantity")));
                questItem.SetItemDisplayName(results.getString("item_display_name"));
                theQuestItemsArrayList.add(questItem);
            }
        } catch (Exception e) {
        	System.err.println(e.getMessage());
        }
        finally {
        	conn.close();
        }
		return theQuestItemsArrayList; 
	}
	
	public Boolean DeleteQuestItemsByQuestId(int questId) throws SQLException {
		Boolean success = false;
		try {
			this.conn = this.sqlAccess.GetDBConnection();
			String query = "DELETE FROM " + this.sqlAccess.GetTheDBName() + ".questitems " + 
					"WHERE quest_id = ?";
			PreparedStatement preparedStmt = conn.prepareStatement(query);
			preparedStmt.setString (1, String.valueOf(questId));
			
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
	
	public Boolean CreateQuestItem(int questId, int itemId, int itemQuantity, String itemDisplayName) throws SQLException {
		Boolean success = false;
		try {
			this.conn = this.sqlAccess.GetDBConnection();
			String query = "INSERT INTO " + this.sqlAccess.GetTheDBName() + ".questitems " + 
					"(quest_id, " + 
            		"item_id, " + 
            		"item_quantity, " + 
            		"item_display_name) " +
					"VALUES (?, ?, ?, ?)";
			 PreparedStatement preparedStmt = conn.prepareStatement(query);
			  preparedStmt.setString(1, String.valueOf(questId));
			  preparedStmt.setString(2, String.valueOf(itemId));
			  preparedStmt.setString(3, String.valueOf(itemQuantity));
			  preparedStmt.setString(4, itemDisplayName);
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
