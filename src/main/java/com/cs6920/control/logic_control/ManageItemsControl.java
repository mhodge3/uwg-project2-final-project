package com.cs6920.control.logic_control;

import java.sql.SQLException;
import java.util.ArrayList;

import com.cs6920.DAL.ItemDAL;
import com.cs6920.DAL.MySQLAccess;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import com.cs6920.model.Item;

/**
 * Logic Control for Managing Items, Communicates between the View and DAL for this feature
 * @author Matthew Hodge
 * @version 6.13.2020
 */
public class ManageItemsControl {
	private ItemDAL theItemDAL;
	private ArrayList<Item> existingItemAdminArrayList;
	private ObservableList<Item> observableItemList = FXCollections.observableArrayList();
	
	/**
	 * 
	 * @param theDBConnection
	 */
	public ManageItemsControl(MySQLAccess theDBConnection) {
		this.theItemDAL = new ItemDAL(theDBConnection);
	}
	
	/**
	 * Updates the observable list for any changes to object list
	 * @throws SQLException
	 */
	public void updateItemArrayList() throws SQLException {
		this.existingItemAdminArrayList = new ArrayList<Item>();
		this.existingItemAdminArrayList = this.theItemDAL.getItems();
		this.observableItemList.clear();
		this.observableItemList.addAll(this.existingItemAdminArrayList);
	}
	
	/**
	 * Get the Observable Player List
	 * @return	the observable list
	 */
	public ObservableList<Item> getObservablePlayerList() {
		return this.observableItemList;
	}
}
