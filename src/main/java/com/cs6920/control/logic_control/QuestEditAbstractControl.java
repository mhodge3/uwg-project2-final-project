package com.cs6920.control.logic_control;

import java.sql.SQLException;
import java.util.ArrayList;

import com.cs6920.DAL.ItemDAL;
import com.cs6920.DAL.MySQLAccess;
import com.cs6920.DAL.NpcCharacterDAL;
import com.cs6920.model.Item;
import com.cs6920.model.NpcCharacter;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

abstract class QuestEditAbstractControl {
	private ArrayList<NpcCharacter> existingNPCArrayList;
	private NpcCharacterDAL theNpcCharacterDAL;
	private ObservableList<NpcCharacter> observableNPCList = FXCollections.observableArrayList();
	

	private ItemDAL theItemDAL;
	private ArrayList<Item> existingQuestItems;
	private ArrayList<Item> existingRewardItems;
	private ObservableList<Item> observableQuestItemsList = FXCollections.observableArrayList();
	private ObservableList<Item> observableRewardItemsList = FXCollections.observableArrayList();
	
	public QuestEditAbstractControl(MySQLAccess theDBConnection) throws SQLException {
		theNpcCharacterDAL = new NpcCharacterDAL(theDBConnection);
		theItemDAL = new ItemDAL(theDBConnection);
		this.UpdateNPCArrayList();
		ArrayList<Item> allItems = theItemDAL.GetItems();
		existingQuestItems = new ArrayList<Item>();
		existingRewardItems = new ArrayList<Item>();
		for (Item item : allItems) {
			if (item.GetIsQuestItem()) {
				existingQuestItems.add(item);
			} 
			else {
				existingRewardItems.add(item);
			}
		}
		this.UpdateQuestItemsArrayList();
		this.UpdateRewardItemsArrayList();
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
	public void UpdateRewardItemsArrayList() throws SQLException {
		observableRewardItemsList.clear();
		observableRewardItemsList.addAll(existingRewardItems);
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
}
