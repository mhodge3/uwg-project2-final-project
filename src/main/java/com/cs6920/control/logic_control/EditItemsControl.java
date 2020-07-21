package com.cs6920.control.logic_control;

import java.sql.SQLException;

import com.cs6920.DAL.ItemDAL;
import com.cs6920.DAL.MySQLAccess;
import com.cs6920.model.Item;

/**
 * Communicates between the create PlayerAndAdmins view and DAL
 * @author Matthew Hodge
 * @version 6.23.2020
 */
public class EditItemsControl {
	private ItemDAL theItemDAL;
	private Item selectedItem;
	
	/**
	 * Constructor that sets DAL to the current DBConnection class instance
	 * @param theDBConnection
	 */
	public EditItemsControl(MySQLAccess theDBConnection) {
		this.theItemDAL = new ItemDAL(theDBConnection);
	}
	
	/**
	 * Sets an instance of the Item to that found by id
	 * @param itemId
	 */
	public void setSelectedItem(int itemId) {
		try {
			this.selectedItem = this.theItemDAL.getItemById(itemId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Get the Item object for editing
	 * @return
	 */
	public Item getSelectedItem() {
		return this.selectedItem;
	}
	
	/**
	 * Delete this item from the DB
	 * @param itemToDelete
	 * @return String, message for user on outcome of operation
	 */
	public String deleteItem(Item itemToDelete) {
		
		try {
			if (this.theItemDAL.deleteItem(itemToDelete)) {
				return null;
			}
			else {
				return "There was a problem deleting the Item";
			}
		} catch (SQLException e) {
			return "There was a problem deleting the Item from the database";
		}
	}
	
	/**
	 * Update the current Item in the DB
	 * @param itemName
	 * @param itemDescription
	 * @param itemType
	 * @param isQuestItem
	 * @param isImplicitItem
	 * @return String, message for user on outcome of operation
	 * @throws SQLException
	 */
	public String updateItem(String itemName, String itemDescription, int itemType, Boolean isQuestItem, Boolean isImplicitItem, Boolean isTrophyItem) throws SQLException {
		if (itemName == null || itemName.trim().length() == 0) {
			return "The Item Name cannot be empty";
		}
		else if (itemDescription == null || itemDescription.trim().length() == 0) {
			return "The Item Description cannot be empty";
		}
		
		if (this.theItemDAL.updateItem(this.selectedItem, new Item(this.selectedItem.getItemId(), itemName, itemDescription, itemType, isQuestItem, isImplicitItem, isTrophyItem))) {
			return null;
		}
		else {
			return "There was a problem updating the Item";
		}
	}
}
