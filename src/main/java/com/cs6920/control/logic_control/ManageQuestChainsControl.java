package com.cs6920.control.logic_control;

import java.sql.SQLException;
import java.util.ArrayList;

import com.cs6920.DAL.ConflictDAL;
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
	private ConflictDAL theConflictDAL;
	/**
	 * Constructor that sets up the DAL to the current DBConnection class instance
	 * @param theDBConnection
	 */
	public ManageQuestChainsControl(MySQLAccess theDBConnection) {
		this.theConflictDAL = new ConflictDAL(theDBConnection);
	}

	/**
	 * Update the observable list of objects for any changes
	 * @throws SQLException
	 */
	public void UpdateConflictArrayList() throws SQLException {
		existingConflictArrayList = new ArrayList<Conflict>();
		//existingConflictArrayList = playerDAL.GetPlayers();
		existingConflictArrayList = this.theConflictDAL.GetConflicts();
		observableConflictList.clear();
		observableConflictList.addAll(existingConflictArrayList);
	}
	
	public void createTheQuestConflict() throws SQLException {
		this.theConflictDAL.CreateConflict(1, 0, "name - change me", "description - change me", "The Quest");
		this.UpdateConflictArrayList();
	}
	
	/**
	 * Get the Observable Player List
	 * @return	the observable list
	 */
	public ObservableList<Conflict> GetObservableConflictList() {
		return observableConflictList;
	}
}
