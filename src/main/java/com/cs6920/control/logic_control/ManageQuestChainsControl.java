package com.cs6920.control.logic_control;

import java.sql.SQLException;
import java.util.ArrayList;

import com.cs6920.DAL.MySQLAccess;
import com.cs6920.model.Conflict;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * Logic Control for Managing Quest Chains, Communicates between the View and DAL for this feature
 * @author Matthew Hodge
 * @version 6.13.2020
 */
public class ManageQuestChainsControl {
	//private PlayerDAL playerDAL;
	private ArrayList<Conflict> existingConflictArrayList;
	private ObservableList<Conflict> observableConflictList = FXCollections.observableArrayList();

	/**
	 * Constructor that sets up the DAL to the current DBConnection class instance
	 * @param theDBConnection
	 */
	public ManageQuestChainsControl(MySQLAccess theDBConnection) {
		//this.playerDAL = new PlayerDAL(theDBConnection);
	}

	/**
	 * Update the observable list of objects for any changes
	 * @throws SQLException
	 */
	public void UpdateConflictArrayList() throws SQLException {
		existingConflictArrayList = new ArrayList<Conflict>();
		//existingConflictArrayList = playerDAL.GetPlayers();
		existingConflictArrayList = createTempConflictList();
		observableConflictList.clear();
		observableConflictList.addAll(existingConflictArrayList);
	}
	
	private ArrayList<Conflict> createTempConflictList () {
		Conflict conflict1 = new Conflict();
		conflict1.SetConflictDescription("Stuff.");
		conflict1.SetConflictName("name");
		conflict1.SetConflictTemplate(1);
		conflict1.SetConflictMinLvl(7);
		conflict1.SetConflictId(1);
		conflict1.SetConflictArcType("Voyage and Return");
		Conflict conflict2 = new Conflict();
		conflict2.SetConflictDescription("Stuff.");
		conflict2.SetConflictName("name 2");
		conflict2.SetConflictTemplate(2);
		conflict2.SetConflictMinLvl(5);
		conflict2.SetConflictId(2);
		conflict2.SetConflictArcType("The Quest");
		Conflict conflict3 = new Conflict();
		conflict3.SetConflictDescription("Stuff.");
		conflict3.SetConflictName("name 3");
		conflict3.SetConflictTemplate(3);
		conflict3.SetConflictMinLvl(1);
		conflict3.SetConflictId(3);
		conflict3.SetConflictArcType("Deafeat the Monster");
		Conflict conflict4 = new Conflict();
		conflict4.SetConflictDescription("Stuff.");
		conflict4.SetConflictName("name 4");
		conflict4.SetConflictTemplate(0);
		conflict4.SetConflictMinLvl(3);
		conflict4.SetConflictId(4);
		conflict4.SetConflictArcType("Custom");
		ArrayList<Conflict> tempConflicts = new ArrayList<Conflict>();
		tempConflicts.add(conflict1);
		tempConflicts.add(conflict2);
		tempConflicts.add(conflict3);
		tempConflicts.add(conflict4);
		return tempConflicts;
	}
	
	/**
	 * Get the Observable Player List
	 * @return	the observable list
	 */
	public ObservableList<Conflict> GetObservableConflictList() {
		return observableConflictList;
	}
}
