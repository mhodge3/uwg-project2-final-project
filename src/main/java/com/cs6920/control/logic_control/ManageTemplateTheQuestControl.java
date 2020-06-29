package com.cs6920.control.logic_control;

import java.sql.SQLException;
import java.util.ArrayList;

import com.cs6920.DAL.MySQLAccess;
import com.cs6920.model.Conflict;
import com.cs6920.model.Quest;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ManageTemplateTheQuestControl {
	//private PlayerDAL playerDAL;
	private ArrayList<Quest> existingTheQuestArrayList;
	private ObservableList<Quest> observableTheQuestList = FXCollections.observableArrayList();
	private int theConflictIdToEdit;

	/**
	 * Constructor that sets up the DAL to the current DBConnection class instance
	 * @param theDBConnection
	 */
	public ManageTemplateTheQuestControl(MySQLAccess theDBConnection) {
		//this.playerDAL = new PlayerDAL(theDBConnection);
	}
	
	public void SetTheConflictToEdit(int theConflictIdToEdit) {
		this.theConflictIdToEdit = theConflictIdToEdit;
	}

	/**
	 * Update the observable list of objects for any changes
	 * @throws SQLException
	 */
	public void UpdateTheQuestArrayList() throws SQLException {
		existingTheQuestArrayList = new ArrayList<Quest>();
		//existingConflictArrayList = playerDAL.GetPlayers();
		existingTheQuestArrayList = this.buildTempQuestTemplateList(this.theConflictIdToEdit);
		observableTheQuestList.clear();
		observableTheQuestList.addAll(existingTheQuestArrayList);
	}
	
	public int GetConflictIdToEdit () {
		return this.theConflictIdToEdit;
	}
	
	private ArrayList<Quest> buildTempQuestTemplateList (int conflictId) {
		Quest quest1 = new Quest();
		quest1.SetQuestArcType(0);
		quest1.SetPreReqQuestId(0);
		quest1.SetConflictId(conflictId);
		quest1.SetQuestId(1);
		quest1.SetMinCharacterLevel(1);
		quest1.SetQuestName("test");
		quest1.SetQuestDescription("testing");
		Quest quest2 = new Quest();
		quest2.SetQuestArcType(1);
		quest2.SetPreReqQuestId(1);
		quest2.SetConflictId(conflictId);
		quest2.SetQuestId(2);
		quest2.SetMinCharacterLevel(1);
		quest2.SetQuestName("test");
		quest2.SetQuestDescription("testing");
		Quest quest3 = new Quest();
		quest3.SetQuestArcType(2);
		quest3.SetPreReqQuestId(2);
		quest3.SetConflictId(conflictId);
		quest3.SetQuestId(3);
		quest3.SetMinCharacterLevel(1);
		quest3.SetQuestName("test");
		quest3.SetQuestDescription("testing");
		Quest quest4 = new Quest();
		quest4.SetQuestArcType(3);
		quest4.SetPreReqQuestId(3);
		quest4.SetConflictId(conflictId);
		quest4.SetQuestId(4);
		quest4.SetMinCharacterLevel(1);
		quest4.SetQuestName("test");
		quest4.SetQuestDescription("testing");
		ArrayList<Quest> tempConflicts = new ArrayList<Quest>();
		tempConflicts.add(quest1);
		tempConflicts.add(quest2);
		tempConflicts.add(quest3);
		tempConflicts.add(quest4);
		return tempConflicts;
	}
	
	/**
	 * Get the Observable Player List
	 * @return	the observable list
	 */
	public ObservableList<Quest> GetObservableTheQuestList() {
		return observableTheQuestList;
	}
}
