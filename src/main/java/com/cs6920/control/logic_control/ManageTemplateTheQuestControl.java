package com.cs6920.control.logic_control;

import java.sql.SQLException;
import java.util.ArrayList;

import com.cs6920.DAL.MySQLAccess;
import com.cs6920.model.Quest;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ManageTemplateTheQuestControl {
	//private PlayerDAL playerDAL;
	private ArrayList<Quest> existingTheQuestArrayList;
	private ObservableList<Quest> observableTheQuestList = FXCollections.observableArrayList();

	/**
	 * Constructor that sets up the DAL to the current DBConnection class instance
	 * @param theDBConnection
	 */
	public ManageTemplateTheQuestControl(MySQLAccess theDBConnection) {
		//this.playerDAL = new PlayerDAL(theDBConnection);
	}

	/**
	 * Update the observable list of objects for any changes
	 * @throws SQLException
	 */
	public void UpdateTheQuestArrayList() throws SQLException {
		existingTheQuestArrayList = new ArrayList<Quest>();
		//existingConflictArrayList = playerDAL.GetPlayers();
		existingTheQuestArrayList = createTempTheQuestList();
		observableTheQuestList.clear();
		observableTheQuestList.addAll(existingTheQuestArrayList);
	}
	
	private ArrayList<Quest> createTempTheQuestList () {
		Quest quest1 = new Quest();
		quest1.SetPreReqQuestId(0);
		quest1.SetConflictId(0);
		quest1.SetQuestName("test");
		quest1.SetQuestDescription("testing");
		Quest quest2 = new Quest();
		quest2.SetPreReqQuestId(0);
		quest2.SetConflictId(0);
		quest2.SetQuestName("test");
		quest2.SetQuestDescription("testing");
		Quest quest3 = new Quest();
		quest3.SetPreReqQuestId(0);
		quest3.SetConflictId(0);
		quest3.SetQuestName("test");
		quest3.SetQuestDescription("testing");
		Quest quest4 = new Quest();
		quest4.SetPreReqQuestId(0);
		quest4.SetConflictId(0);
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
