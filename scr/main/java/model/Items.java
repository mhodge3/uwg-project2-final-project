/**
 * 
 */
package model;

/**
 * @author Ashely Palmer
 * @date 6/11/2020
 *
 */
public class Items {
	private int itemId;
	private String itemName;
	private String itemDescription;
	private int itemType;
	private int isQuestItem;
	private int isImplicitItem;
	
	/**
	 * Gets the Item Id
	 * @return itemdID
	 */
	public int GetItemId() {
		return itemId;
	}
	
	/**
	 * Sets the Item Id
	 * @param setItemID
	 */
	
	public void SetItemId(int setItemID) {
		this.itemId = setItemID;
	}
	
	/**
	 * Gets the Item Name
	 * @return itemName
	 */
	
	public String GetItemName() {
		return itemName;
	}
	
	/**
	 * Sets the Item Name
	 * @param setItemName
	 */
	public void SetItemName(String setItemName) {
		this.itemName = setItemName;
	}
	
	/**
	 * Gets the Item Description
	 * @return itemDescription
	 */
	public String GetItemDescription() {
		return itemDescription;
	}
	
	/**
	 * Sets the Item Description
	 * @param setItemDescription
	 */
	public void SetItemDescription(String setItemDescription) {
		this.itemDescription = setItemDescription;
	}
	
	/**
	 * Gets the Item Type
	 * @return itemType
	 */
	public int GetItemType() {
		return itemType;
	}
	
	/**
	 * Sets the Item Type
	 * @param setItemType
	 */
	public void SetItemType(int setItemType) {
		this.itemType = setItemType;
	}
	
	/**
	 * Gets the Is Quest Item
	 * @return isQuestItem
	 */
	public int GetIsQuestItem() {
		return isQuestItem;
	}
	
	/**
	 * Sets the IsQuestItem
	 * @param setIsQuestItem
	 */
	public void SetIsQuestItem(int setIsQuestItem) {
		this.isQuestItem = setIsQuestItem;
	}
	
	/**
	 * Gets the isImplicitItem
	 * @return isImplicitItem
	 */
	public int GetIsImplicitItem() {
		return isImplicitItem;
	}
	
	/**
	 * Sets the IsImplicitItem
	 * @param setIsImplicitItem
	 */
	public void SetIsImplicitItem(int setIsImplicitItem) {
		this.isImplicitItem = setIsImplicitItem;
	}
	

}
