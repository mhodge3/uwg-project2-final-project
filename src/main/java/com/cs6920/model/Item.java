/**
 * 
 */
package com.cs6920.model;



import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * @author Ashely Palmer
 * @date 6/11/2020
 *
 */
public class Item {
	private IntegerProperty itemId;
	private StringProperty itemName;
	private StringProperty itemDescription;
	private IntegerProperty itemType;
	private BooleanProperty isQuestItem;
	private BooleanProperty isImplicitItem;
	private BooleanProperty isTrophy;
	
	
	/**
	 * Constructor for testing
	 */
	public Item(){
		
	}
	
	/**
	 * Constructs Items Object
	 * @param itemId
	 * @param itemName
	 * @param itemDescription
	 * @param itemType
	 * @param isQuestItem
	 * @param isImplicitItem
	 */
	
	public Item(int itemId, String itemName, String itemDescription, int itemType, Boolean isQuestItem, Boolean isImplicitItem) {
		this.itemId = new SimpleIntegerProperty(itemId);
		this.itemName = new SimpleStringProperty(itemName);
		this.itemDescription = new SimpleStringProperty(itemDescription);
		this.itemType = new SimpleIntegerProperty(itemType);
		this.isQuestItem = new SimpleBooleanProperty(isQuestItem);
		this.isImplicitItem = new SimpleBooleanProperty(isImplicitItem);
	}
	
	/**
	 * Gets isTrophy
	 * @return isTrophy
	 */
	public boolean getIstrophy() {
		return isTrophy.get();
	}
	
	/**
	 * Sets the isTrophy
	 * @param setIsTrophy
	 */
	public void setIsTrophy(Boolean setIsTrophy) {
		this.isTrophy = new SimpleBooleanProperty(setIsTrophy);
	}
	
	/**
	 * Gets the IsTrophy property
	 * @return Property for TableView
	 */
	public final BooleanProperty isTrophyProperty() {
	   return isQuestItem;
	}
	
	/**
	 * Gets the Item Id
	 * @return itemdID
	 */
	public int GetItemId() {
		return itemId.get();
	}
	
	/**
	 * Sets the Item Id
	 * @param setItemID
	 */
	
	public void SetItemId(int setItemID) {
		this.itemId = new SimpleIntegerProperty(setItemID);
	}
	
	/**
	 * Gets the ItemID property
	 * @return Property for TableView
	 */
	public final IntegerProperty itemIdProperty() {
	   return itemId;
	}
	
	/**
	 * Gets the Item Name
	 * @return itemName
	 */
	
	public String GetItemName() {
		return itemName.get();
	}
	
	/**
	 * Sets the Item Name
	 * @param setItemName
	 */
	public void SetItemName(String setItemName) {
		this.itemName = new SimpleStringProperty(setItemName);
	}
	
	/**
	 * Gets the ItemName property
	 * @return Property for TableView
	 */
	public final StringProperty itemNameProperty() {
	   return itemName;
	}
	
	/**
	 * Gets the Item Description
	 * @return itemDescription
	 */
	public String GetItemDescription() {
		return itemDescription.get();
	}
	
	/**
	 * Sets the Item Description
	 * @param setItemDescription
	 */
	public void SetItemDescription(String setItemDescription) {
		this.itemDescription = new SimpleStringProperty(setItemDescription);
	}
	
	/**
	 * Gets the ItemDescription property
	 * @return Property for TableView
	 */
	public final StringProperty itemDescriptionProperty() {
	   return itemDescription;
	}
	
	/**
	 * Gets the Item Type
	 * @return itemType
	 */
	public int GetItemType() {
		return itemType.get();
	}
	
	/**
	 * Sets the Item Type
	 * @param setItemType
	 */
	public void SetItemType(int setItemType) {
		this.itemType = new SimpleIntegerProperty(setItemType);
	}
	
	/**
	 * Gets the ItemType property
	 * @return Property for TableView
	 */
	public final IntegerProperty itemTypeProperty() {
	   return itemType;
	}
	
	/**
	 * Gets the Is Quest Item
	 * @return isQuestItem
	 */
	public Boolean GetIsQuestItem() {
		return this.isQuestItem.get();
	}
	
	/**
	 * Sets the IsQuestItem
	 * @param setIsQuestItem
	 */
	public void SetIsQuestItem(Boolean setIsQuestItem) {
		this.isQuestItem = new SimpleBooleanProperty(setIsQuestItem);
	}
	
	/**
	 * Gets the IsItemQuest property
	 * @return Property for TableView
	 */
	public final BooleanProperty isQuestItemProperty() {
	   return isQuestItem;
	}
	
	/**
	 * Gets the isImplicitItem
	 * @return isImplicitItem
	 */
	public Boolean GetIsImplicitItem() {
		return this.isImplicitItem.get();
	}
	
	/**
	 * Sets the IsImplicitItem
	 * @param setIsImplicitItem
	 */
	public void SetIsImplicitItem(Boolean setIsImplicitItem) {
		this.isImplicitItem = new SimpleBooleanProperty(setIsImplicitItem);
	}
	
	/**
	 * Gets the ImplicitItem property
	 * @return Property for TableView
	 */
	public final BooleanProperty isImplicitItemProperty() {
	   return isImplicitItem;
	}
	

}
