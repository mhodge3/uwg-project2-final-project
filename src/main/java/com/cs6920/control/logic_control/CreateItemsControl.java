package com.cs6920.control.logic_control;

import java.sql.SQLException;

import com.cs6920.DAL.ItemDAL;
import com.cs6920.DAL.MySQLAccess;

/**
 * Communicates between the create Items view and DAL
 * @author Matthew Hodge
 * @version 6.23.2020
 */
public class CreateItemsControl {
	private ItemDAL itemDAL;
	
	/**
	 * Constructor that sets DAL to the current DBConnection class instance
	 * @param theDBConnection
	 */
	public CreateItemsControl(MySQLAccess theDBConnection) {
		this.itemDAL = new ItemDAL(theDBConnection);
	}
	
	/**
	 * Uses the DAL to create the new Item entry in the DB
	 * @param itemName
	 * @param itemDescription
	 * @param itemType
	 * @param isQuestItem
	 * @param isImplicitItem
	 * @return String, message for user on outcome of operation
	 * @throws SQLException
	 */
	public String CreateItem(String itemName, String itemDescription, int itemType, Boolean isQuestItem, Boolean isImplicitItem) throws SQLException {
		if (itemName == null || itemName.trim().length() == 0) {
			return "The Item Name cannot be empty";
		}
		else if (itemDescription == null || itemDescription.trim().length() == 0) {
			return "The Item Description cannot be empty";
		}
		
		if (itemDAL.CreateItem(itemName, itemDescription, itemType, isQuestItem, isImplicitItem)) {
			return null;
		}
		else {
			return "There was a problem creating the Item";
		}
	}
}
