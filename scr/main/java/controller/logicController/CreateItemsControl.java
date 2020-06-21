package controller.logicController;

import java.sql.SQLException;

import DAL.ItemDAL;
import DAL.MySQLAccess;

public class CreateItemsControl {
	private ItemDAL itemDAL;
	
	public CreateItemsControl(MySQLAccess theDBConnection) {
		this.itemDAL = new ItemDAL(theDBConnection);
	}
	
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
