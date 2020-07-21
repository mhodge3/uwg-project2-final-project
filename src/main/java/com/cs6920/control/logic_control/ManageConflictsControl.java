package com.cs6920.control.logic_control;

import java.sql.SQLException;
import java.util.ArrayList;

import com.cs6920.DAL.ConflictDAL;
import com.cs6920.DAL.MySQLAccess;
import com.cs6920.DAL.QuestItemsDAL;
import com.cs6920.model.Conflict;
import com.cs6920.model.Quest;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * Logic Control for Managing Quest Chains, Communicates between the View and DAL for this feature
 * @author Matthew Hodge
 * @version 6.13.2020
 */
public class ManageConflictsControl {
	//private PlayerDAL playerDAL;
	private ArrayList<Conflict> existingConflictArrayList;
	private ObservableList<Conflict> observableConflictList = FXCollections.observableArrayList();
	private ConflictDAL theConflictDAL;
	private QuestsController theQuestsController;
	private QuestItemsDAL theQuestItemsDAL;
	
	/**
	 * Constructor that sets up the DAL to the current DBConnection class instance
	 * @param theDBConnection
	 */
	public ManageConflictsControl(MySQLAccess theDBConnection) {
		this.theConflictDAL = new ConflictDAL(theDBConnection);
		this.theQuestsController = new QuestsController(theDBConnection);
		this.theQuestItemsDAL = new QuestItemsDAL(theDBConnection);
	}

	/**
	 * Update the observable list of objects for any changes
	 * @throws SQLException
	 */
	public void updateConflictArrayList() throws SQLException {
		this.existingConflictArrayList = new ArrayList<Conflict>();
		this.existingConflictArrayList = this.theConflictDAL.getConflicts();
		this.observableConflictList.clear();
		this.observableConflictList.addAll(this.existingConflictArrayList);
	}
	
	public void createTheQuestConflict() throws SQLException {
		this.theConflictDAL.createConflict(1, 0, "name - change me", "description - change me", "The Quest");
		this.updateConflictArrayList();
	}
	
	public void createVoyageConflict() throws SQLException {
		this.theConflictDAL.createConflict(1, 0, "name - change me", "description - change me", "Voyage and Return");
		this.updateConflictArrayList();
	}
	
	public void createMonsterConflict() throws SQLException {
		this.theConflictDAL.createConflict(1, 0, "name - change me", "description - change me", "Defeat the Monster");
		this.updateConflictArrayList();
	}
	
	public void createCustomConflict() throws SQLException {
		this.theConflictDAL.createConflict(1, 0, "name - change me", "description - change me", "Custom");
		this.updateConflictArrayList();
	}
	
	public void deleteTheQuestConflict(int conflictIdToDelete) throws SQLException {
		ArrayList<Quest> thisConflictsQuests = this.theQuestsController.getQuestsByConflictID(conflictIdToDelete);
		for (Quest conflictQuest : thisConflictsQuests) {
			this.theQuestItemsDAL.deleteQuestItemsByQuestId(conflictQuest.getQuestId());
			this.theQuestsController.deleteQuest(conflictQuest);
		}
		for (Conflict conflict : this.existingConflictArrayList) {
			if (conflict.getConflictId() == conflictIdToDelete) {
				this.theConflictDAL.deleteConflict(conflict);
				break;
			}
		}
		this.updateConflictArrayList();
	}
	
	public Conflict getConflictById(int conflictId) {
		for (Conflict conflict : this.existingConflictArrayList) {
			if (conflict.getConflictId() == conflictId) {
				return conflict;
			}
		}
		return null;
	}
	
	/**
	 * Get the Observable Player List
	 * @return	the observable list
	 */
	public ObservableList<Conflict> GetObservableConflictList() {
		return this.observableConflictList;
	}
}
