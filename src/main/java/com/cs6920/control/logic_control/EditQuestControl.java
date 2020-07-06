package com.cs6920.control.logic_control;

import java.sql.SQLException;
import java.util.ArrayList;

import com.cs6920.DAL.ItemDAL;
import com.cs6920.DAL.MySQLAccess;
import com.cs6920.DAL.NpcCharacterDAL;
import com.cs6920.DAL.QuestItemsDAL;
import com.cs6920.model.Item;
import com.cs6920.model.NpcCharacter;
import com.cs6920.model.QuestItems;
import com.cs6920.view.edit.EditConflictQuestsViewControl;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class EditQuestControl {
	private ArrayList<NpcCharacter> existingNPCArrayList;
	private NpcCharacterDAL theNpcCharacterDAL;
	private ObservableList<NpcCharacter> observableNPCList = FXCollections.observableArrayList();
	private ArrayList<QuestItems> theQuestItemsNeededList;
	private ObservableList<QuestItems> observableTheQuestItemsNeededList = FXCollections.observableArrayList();
	private ArrayList<QuestItems> theQuestItemsRewardList;
	private ObservableList<QuestItems> observableTheQuestItemsRewardList = FXCollections.observableArrayList();
	private ItemDAL theItemDAL;
	private QuestItemsDAL theQuestItemsDAL;
	private ArrayList<Item> existingQuestItems;
	private ArrayList<Item> existingRewardItems;
	private ObservableList<Item> observableQuestItemsList = FXCollections.observableArrayList();
	private ObservableList<Item> observableRewardItemsList = FXCollections.observableArrayList();
	private int questIdToEdit;
	private EditConflictQuestsViewControl theEditConflictQuestsViewControl;
	
	public EditQuestControl(EditConflictQuestsViewControl theEditConflictQuestsViewControl, MySQLAccess theDBConnection, int questIdToEdit, String questArcRole) throws SQLException {
		this.theEditConflictQuestsViewControl = theEditConflictQuestsViewControl;
		this.questIdToEdit = questIdToEdit;
		theNpcCharacterDAL = new NpcCharacterDAL(theDBConnection);
		theItemDAL = new ItemDAL(theDBConnection);
		theQuestItemsDAL = new QuestItemsDAL(theDBConnection);
		this.UpdateNPCArrayList();
		ArrayList<Item> allItems = theItemDAL.GetItems();
		existingQuestItems = new ArrayList<Item>();
		existingRewardItems = new ArrayList<Item>();
		for (Item item : allItems) {
			if (item.GetIsQuestItem()) {
				if (questArcRole.contentEquals("insight") && item.GetIsImplicitItem()) {
					existingQuestItems.add(item);
				}
				else if ((questArcRole.contentEquals("henchman") || questArcRole.contentEquals("monster") || questArcRole.contentEquals("return and reward")) && item.getIstrophy()) {
					existingQuestItems.add(item);
				}
				else if (questArcRole.contentEquals("return new wisdom") && (item.GetIsImplicitItem() || item.getIstrophy())) {
					existingQuestItems.add(item);
				}
				else if (!questArcRole.contentEquals("insight") && !questArcRole.contentEquals("return and reward") && !questArcRole.contentEquals("return new wisdom") && !questArcRole.contentEquals("monster") && !questArcRole.contentEquals("henchman") && !item.GetIsImplicitItem() && !item.getIstrophy()){
					existingQuestItems.add(item);
				}
			} 
			else {
				existingRewardItems.add(item);
			}
		}
		theQuestItemsNeededList = new ArrayList<QuestItems>();
		theQuestItemsRewardList = new ArrayList<QuestItems>();
		ArrayList<QuestItems> existingQuestItems = this.theQuestItemsDAL.GetQuestItemsByQuestId(theEditConflictQuestsViewControl.GetTheManageQuestsControl().getExistingQuestList().get(this.questIdToEdit).GetQuestId());
		for (QuestItems questItem : existingQuestItems) {
			Item theItem = this.theItemDAL.GetItemById(questItem.GetItemId());
			if (theItem.GetIsQuestItem()) {
				theQuestItemsNeededList.add(questItem);
			}
			else {
				theQuestItemsRewardList.add(questItem);
			}
		}
		this.UpdateQuestItemsNeededList();
		this.UpdateQuestItemsRewardList();
		this.UpdateQuestItemsArrayList();
		this.UpdateRewardItemsArrayList();
	}
	
	public EditConflictQuestsViewControl getConflictTemplateTheQuestViewControl() {
		return this.theEditConflictQuestsViewControl;
	}
	
	/**
	 * Update the observable list of objects for any changes
	 * @throws SQLException
	 */
	public void UpdateNPCArrayList() throws SQLException {
		existingNPCArrayList = new ArrayList<NpcCharacter>();
		existingNPCArrayList = theNpcCharacterDAL.GetAllNpc();
		observableNPCList.clear();
		observableNPCList.addAll(existingNPCArrayList);
	}
	
	/**
	 * Update the observable list of objects for any changes
	 * @throws SQLException
	 */
	public void UpdateQuestItemsArrayList() throws SQLException {
		observableQuestItemsList.clear();
		observableQuestItemsList.addAll(existingQuestItems);
	}
	
	/**
	 * Update the observable list of objects for any changes
	 * @throws SQLException
	 */
	public void UpdateQuestItemsNeededList() throws SQLException {
		observableTheQuestItemsNeededList.clear();
		observableTheQuestItemsNeededList.addAll(theQuestItemsNeededList);
	}
	
	/**
	 * Update the observable list of objects for any changes
	 * @throws SQLException
	 */
	public void UpdateQuestItemsRewardList() throws SQLException {
		observableTheQuestItemsRewardList.clear();
		observableTheQuestItemsRewardList.addAll(theQuestItemsRewardList);
	}
	
	/**
	 * Update the observable list of objects for any changes
	 * @throws SQLException
	 */
	public void UpdateRewardItemsArrayList() throws SQLException {
		observableRewardItemsList.clear();
		observableRewardItemsList.addAll(existingRewardItems);
	}
	
	public void addQuestItemNeeded(String itemName, int quantity) throws SQLException {
		int itemId = this.getItemIdByName(itemName, existingQuestItems);
		this.theQuestItemsNeededList.add(new QuestItems(theEditConflictQuestsViewControl.GetTheManageQuestsControl().getExistingQuestList().get(this.questIdToEdit).GetQuestId(), itemId, quantity, itemName));
		this.UpdateQuestItemsNeededList();
	}
	
	public void addQuestItemReward(String itemName, int quantity) throws SQLException {
		int itemId = this.getItemIdByName(itemName, existingRewardItems);
		this.theQuestItemsRewardList.add(new QuestItems(theEditConflictQuestsViewControl.GetTheManageQuestsControl().getExistingQuestList().get(this.questIdToEdit).GetQuestId(), itemId, quantity, itemName));
		this.UpdateQuestItemsRewardList();
	}
	
	public void removeQuestItemNeeded(String itemName, int quantity) throws SQLException {
		int itemId = this.getItemIdByName(itemName, existingQuestItems);
		for (QuestItems questItemNeeded : theQuestItemsNeededList) {
			if (questItemNeeded.GetItemId() == itemId && questItemNeeded.GetItemQuantity() == quantity) {
				theQuestItemsNeededList.remove(questItemNeeded);
				break;
			} 
		}
		this.UpdateQuestItemsNeededList();
	}
	
	public void removeQuestItemReward(String itemName, int quantity) throws SQLException {
		int itemId = this.getItemIdByName(itemName, existingRewardItems);
		for (QuestItems questItemReward : theQuestItemsRewardList) {
			if (questItemReward.GetItemId() == itemId && questItemReward.GetItemQuantity() == quantity) {
				theQuestItemsRewardList.remove(questItemReward);
				break;
			} 
		}
		this.UpdateQuestItemsRewardList();
	}
	
	private int getItemIdByName(String itemName, ArrayList<Item> theItems) {
		for (Item item : theItems) {
			if (item.GetItemName().contentEquals(itemName)) {
				return item.GetItemId();
			} 
		}
		return 0;
	}
	
	public ObservableList<QuestItems> getObservableQuestItemsNeededList() {
		return this.observableTheQuestItemsNeededList;
	}
	
	public ObservableList<QuestItems> getObservableQuestItemsRewardList() {
		return this.observableTheQuestItemsRewardList;
	}
	
	public ObservableList<NpcCharacter> getTheObservableNPCs() {
		return this.observableNPCList;
	}
	
	public ObservableList<Item> getTheObservableQuestItems() {
		return this.observableQuestItemsList;
	}
	
	public ObservableList<Item> getTheObservableRewardItems() {
		return this.observableRewardItemsList;
	}
	
	public int getQuestIdToEdit() {
		return this.questIdToEdit;
	}
	
	public String GetNpcNameFromListById(int npcId) {
		for (NpcCharacter theNPC : existingNPCArrayList) {
			if (theNPC.GetNpcId() == npcId) {
				return theNPC.GetNpcName();
			}
		}
		return "none";
	}
	
	public int GetNpcIdFromListByName(String npcName) {
		for (NpcCharacter theNPC : existingNPCArrayList) {
			if (theNPC.GetNpcName().contentEquals(npcName)) {
				return theNPC.GetNpcId();
			}
		}
		return 0;
	}
	
	public void updateQuestName(String newQuestName) throws SQLException {
		theEditConflictQuestsViewControl.GetTheManageQuestsControl().getExistingQuestList().get(this.questIdToEdit).SetQuestName(newQuestName);
	}
	
	public void updateQuestDescription(String newQuestDescription) throws SQLException {
		theEditConflictQuestsViewControl.GetTheManageQuestsControl().getExistingQuestList().get(this.questIdToEdit).SetQuestDescription(newQuestDescription);
	}
	
	public void updateGiverNPC(int npcId) throws SQLException {
		theEditConflictQuestsViewControl.GetTheManageQuestsControl().getExistingQuestList().get(this.questIdToEdit).SetQuestGiverNpcId(npcId);
	}
	
	public void updateQuestGiverDialog(String newQuestGiverDialog) throws SQLException {
		theEditConflictQuestsViewControl.GetTheManageQuestsControl().getExistingQuestList().get(this.questIdToEdit).SetQuestGiverDialog(newQuestGiverDialog);
	}
	
	public void updateQuestReceiverDialog(String newQuestReceiverDialog) throws SQLException {
		theEditConflictQuestsViewControl.GetTheManageQuestsControl().getExistingQuestList().get(this.questIdToEdit).SetQuestReceiverDialog(newQuestReceiverDialog);
	}
	
	public void updateReceiverNPC(int npcId) throws SQLException {
		theEditConflictQuestsViewControl.GetTheManageQuestsControl().getExistingQuestList().get(this.questIdToEdit).SetQuestReceiverNpcId(npcId);
	}
	
	public int getQuestGiverNpcId() throws SQLException {
		return theEditConflictQuestsViewControl.GetTheManageQuestsControl().getExistingQuestList().get(this.questIdToEdit).GetQuestGiverNpcId();
	}
	
	public int getQuestReceiverNpcId() throws SQLException {
		return theEditConflictQuestsViewControl.GetTheManageQuestsControl().getExistingQuestList().get(this.questIdToEdit).GetQuestReceiverNpcId();
	}
	
	public String getQuestName() throws SQLException {
		return theEditConflictQuestsViewControl.GetTheManageQuestsControl().getExistingQuestList().get(this.questIdToEdit).GetQuestName();
	}
	
	public String getQuestDescription() throws SQLException {
		return theEditConflictQuestsViewControl.GetTheManageQuestsControl().getExistingQuestList().get(this.questIdToEdit).GetQuestDescription();
	}
	
	public String getGiverDialog() throws SQLException {
		return theEditConflictQuestsViewControl.GetTheManageQuestsControl().getExistingQuestList().get(this.questIdToEdit).GetQuesGiverDialog();
	}
	
	public String getReceiverDialog() throws SQLException {
		return theEditConflictQuestsViewControl.GetTheManageQuestsControl().getExistingQuestList().get(this.questIdToEdit).GetQuestReceiverDialog();
	}
	
	public void refreshQuestDisplay() throws SQLException {
		theEditConflictQuestsViewControl.GetTheManageQuestsControl().updateQuestChainInDB();
	}
	
	public void updateQuestItemsInDB() throws SQLException {
		this.theQuestItemsDAL.DeleteQuestItemsByQuestId(theEditConflictQuestsViewControl.GetTheManageQuestsControl().getExistingQuestList().get(this.questIdToEdit).GetQuestId());
		for (QuestItems questItem : theQuestItemsNeededList) {
			this.theQuestItemsDAL.CreateQuestItem(questItem.GetQuestId(), questItem.GetItemId(), questItem.GetItemQuantity(), questItem.GetItemDisplayName());
		}
		for (QuestItems questItem : theQuestItemsRewardList) {
			this.theQuestItemsDAL.CreateQuestItem(questItem.GetQuestId(), questItem.GetItemId(), questItem.GetItemQuantity(), questItem.GetItemDisplayName());
		}
	}
}
