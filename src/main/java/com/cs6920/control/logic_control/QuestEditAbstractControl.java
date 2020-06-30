package com.cs6920.control.logic_control;

import java.sql.SQLException;
import java.util.ArrayList;

import com.cs6920.DAL.MySQLAccess;
import com.cs6920.DAL.NpcCharacterDAL;
import com.cs6920.model.NpcCharacter;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

abstract class QuestEditAbstractControl {
	private ArrayList<NpcCharacter> existingNPCArrayList;
	private NpcCharacterDAL theNpcCharacterDAL;
	private ObservableList<NpcCharacter> observableNPCList = FXCollections.observableArrayList();
	
	public QuestEditAbstractControl(MySQLAccess theDBConnection) throws SQLException {
		theNpcCharacterDAL = new NpcCharacterDAL(theDBConnection);
		this.UpdatePlayerArrayList();
	}
	
	/**
	 * Update the observable list of objects for any changes
	 * @throws SQLException
	 */
	public void UpdatePlayerArrayList() throws SQLException {
		existingNPCArrayList = new ArrayList<NpcCharacter>();
		existingNPCArrayList = theNpcCharacterDAL.GetAllNpc();
		observableNPCList.clear();
		observableNPCList.addAll(existingNPCArrayList);
	}
	
	public ObservableList<NpcCharacter> getTheObservableNPCs() {
		return this.observableNPCList;
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
