package controller.logicController;

import java.sql.SQLException;
import java.util.ArrayList;

import DAL.ItemDAL;
import DAL.MySQLAccess;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Item;

/**
 * Logic Control for Managing Items, Communicates between the View and DAL for this feature
 * @author Matthew Hodge
 * @version 6.13.2020
 */
public class ManageItemsControl {
	private ItemDAL itemDAL;
	private ArrayList<Item> existingItemAdminArrayList;
	private ObservableList<Item> observableItemList = FXCollections.observableArrayList();
	
	public ManageItemsControl(MySQLAccess theDBConnection) {
		this.itemDAL = new ItemDAL(theDBConnection);
	}
	
	public void UpdateItemArrayList() throws SQLException {
		existingItemAdminArrayList = new ArrayList<Item>();
		existingItemAdminArrayList = itemDAL.GetItems();
		observableItemList.clear();
		observableItemList.addAll(existingItemAdminArrayList);
	}
	
	/**
	 * Get the Observable Player List
	 * @return	the observable list
	 */
	public ObservableList<Item> GetObservablePlayerList() {
		return observableItemList;
	}
}
