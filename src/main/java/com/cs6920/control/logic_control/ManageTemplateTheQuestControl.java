package com.cs6920.control.logic_control;

import java.sql.SQLException;
import java.util.ArrayList;

import com.cs6920.DAL.MySQLAccess;
import com.cs6920.model.Conflict;
import com.cs6920.model.Quest;
import com.cs6920.model.QuestItems;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ManageTemplateTheQuestControl {
	//private PlayerDAL playerDAL;
	private ArrayList<Quest> existingTheQuestArrayList;
	private ObservableList<Quest> observableTheQuestList = FXCollections.observableArrayList();
	private int theConflictIdToEdit;
	private QuestsController theQuestsController;
	
	/**
	 * Constructor that sets up the DAL to the current DBConnection class instance
	 * @param theDBConnection
	 */
	public ManageTemplateTheQuestControl(MySQLAccess theDBConnection) {
		//this.playerDAL = new PlayerDAL(theDBConnection);
		this.theQuestsController = new QuestsController(theDBConnection);
	}
	
	public void SetTheConflictToEdit(int theConflictIdToEdit) {
		this.theConflictIdToEdit = theConflictIdToEdit;
	}
	
	public ArrayList<Quest> getExistingQuestList() {
		return this.existingTheQuestArrayList;
	}

	/**
	 * Update the observable list of objects for any changes
	 * @throws SQLException
	 */
	public void UpdateTheQuestArrayList() throws SQLException {
		//existingTheQuestArrayList = new ArrayList<Quest>();
		//existingConflictArrayList = playerDAL.GetPlayers();
		observableTheQuestList.clear();
		observableTheQuestList.addAll(existingTheQuestArrayList);
	}
	
	public int GetConflictIdToEdit () {
		return this.theConflictIdToEdit;
	}
	
	private int getHighestObstacleId () {
		int highestObstacleQuest = 3;
		for (Quest quest : existingTheQuestArrayList) {
			if (quest.GetQuestArcType().contentEquals("obstacle")) {
				highestObstacleQuest = quest.GetidInConflict();
			}
		}
		return highestObstacleQuest;
	}
	
	private void insertNewObstacleQuest(Quest newObstacleQuest) {
		Quest finalQuest = existingTheQuestArrayList.get(existingTheQuestArrayList.size() - 1);
		Quest penultimateQuest = existingTheQuestArrayList.get(existingTheQuestArrayList.size() - 2);
		existingTheQuestArrayList.set(existingTheQuestArrayList.size() - 2, newObstacleQuest);
		penultimateQuest.SetPreReqIdInConflict(penultimateQuest.GetidInConflict());
		penultimateQuest.SetIdInConflict(penultimateQuest.GetidInConflict() + 1);
		finalQuest.SetPreReqIdInConflict(penultimateQuest.GetidInConflict());
		finalQuest.SetIdInConflict(penultimateQuest.GetidInConflict() + 1);
		existingTheQuestArrayList.set(existingTheQuestArrayList.size() - 1, penultimateQuest);
		existingTheQuestArrayList.add(finalQuest);
	}
	
	public void addObstacle() throws SQLException {
		int highestObstacleQuestId = this.getHighestObstacleId();
		Quest obstacleQuest = new Quest(); 
		obstacleQuest.SetQuestArcType("obstacle");
		obstacleQuest.SetPreReqIdInConflict(highestObstacleQuestId);
		obstacleQuest.SetConflictId(theConflictIdToEdit);
		obstacleQuest.SetQuestId(highestObstacleQuestId + 1);
		obstacleQuest.SetIdInConflict(highestObstacleQuestId + 1);
		obstacleQuest.SetMinCharacterLevel(1);
		obstacleQuest.SetQuestName("test");
		this.insertNewObstacleQuest(obstacleQuest);
		this.UpdateTheQuestArrayList();
	}
	
	public void removeQuest(int questIdToRemove) throws SQLException {
		int idInConlictofRemovedQuest = 0;
		for (Quest quest : existingTheQuestArrayList) {
			if (quest.GetQuestId() == questIdToRemove) {
				idInConlictofRemovedQuest = quest.GetQuestId();
				if (!canQuestBeRemoved(quest)) {
					return;
				}
				existingTheQuestArrayList.remove(quest);
				break;
			}
		}
		if (idInConlictofRemovedQuest > 0) {
			for (Quest quest : existingTheQuestArrayList) {
				if (quest.GetidInConflict() > idInConlictofRemovedQuest) {
					quest.SetIdInConflict(quest.GetidInConflict() - 1);
					quest.SetPreReqIdInConflict(quest.GetidInConflict() - 1);
				}
			}
			this.UpdateTheQuestArrayList();
		}
	}
    
    private Boolean canQuestBeRemoved(Quest theQuestToCheck) {
    	if (!theQuestToCheck.GetQuestArcType().matches("custom|insight|obstacle|henchman")) {
    		return false;
    	}
    	if (theQuestToCheck.GetQuestArcType().contentEquals("obstacle")) {
			if (questArcTypeCount("obstacle") <= 1) {
				return false;
			}
    	}
    	else if (theQuestToCheck.GetQuestArcType().contentEquals("insight")) {
			if (questArcTypeCount("insight") <= 1) {
				return false;
			}
    	}
    	else if (theQuestToCheck.GetQuestArcType().contentEquals("custom")) {
			if (questArcTypeCount("custom") <= 1) {
				return false;
			}
    	}
    	return true;
    }
    
    private int questArcTypeCount(String arcTypeName) {
		int questCount = 0;
		for (Quest quest : existingTheQuestArrayList) {
			if (quest.GetQuestArcType().contentEquals(arcTypeName)) {
				questCount++;
			}
		}
		return questCount;
    }
    
    public void updateQuestTemplateList() throws SQLException {
    	this.updateQuestChainInDB(existingTheQuestArrayList);
    }
	
	public void createQuestTemplateList (int conflictId) throws SQLException {
		existingTheQuestArrayList = new ArrayList<Quest>();
		this.existingTheQuestArrayList = this.theQuestsController.GetQuestsByConflictID(theConflictIdToEdit);
		if (this.existingTheQuestArrayList.size() == 0) {
			Quest quest1 = new Quest();
			quest1.SetIdInConflict(1);
			quest1.SetPreReqIdInConflict(0);
			quest1.SetQuestReceiverNpcId(0);
			quest1.SetQuestGiverNpcId(0);
			quest1.SetQuestArcType("calling");
			quest1.SetPreReqQuestId(0);
			quest1.SetConflictId(conflictId);
			quest1.SetQuestId(1);
			quest1.SetMinCharacterLevel(1);
			quest1.SetQuestName("test 1");
			quest1.SetQuestDescription("testing 1");
			quest1.SetQuestGiverDialog("Go");
			quest1.SetQuestReceiverDialog("Stop");
			Quest quest2 = new Quest();
			quest2.SetIdInConflict(2);
			quest2.SetPreReqIdInConflict(1);
			quest2.SetQuestReceiverNpcId(0);
			quest2.SetQuestGiverNpcId(0);
			quest2.SetQuestArcType("leaving");
			quest2.SetPreReqQuestId(1);
			quest2.SetConflictId(conflictId);
			quest2.SetQuestId(2);
			quest2.SetMinCharacterLevel(1);
			quest2.SetQuestName("test 2");
			quest2.SetQuestDescription("testing 2");
			quest2.SetQuestGiverDialog("Go");
			quest2.SetQuestReceiverDialog("Stop");
			Quest quest3 = new Quest();
			quest3.SetIdInConflict(3);
			quest3.SetPreReqIdInConflict(2);
			quest3.SetQuestReceiverNpcId(0);
			quest3.SetQuestGiverNpcId(0);
			quest3.SetQuestArcType("obstacle");
			quest3.SetPreReqQuestId(2);
			quest3.SetConflictId(conflictId);
			quest3.SetQuestId(3);
			quest3.SetMinCharacterLevel(1);
			quest3.SetQuestName("test 3");
			quest3.SetQuestDescription("testing 3");
			quest3.SetQuestGiverDialog("Go");
			quest3.SetQuestReceiverDialog("Stop");
			Quest quest4 = new Quest();
			quest4.SetIdInConflict(4);
			quest4.SetPreReqIdInConflict(3);
			quest4.SetQuestReceiverNpcId(0);
			quest4.SetQuestGiverNpcId(0);
			quest4.SetQuestArcType("obtain elixir");
			quest4.SetPreReqQuestId(3);
			quest4.SetConflictId(conflictId);
			quest4.SetQuestId(4);
			quest4.SetMinCharacterLevel(1);
			quest4.SetQuestName("test 4");
			quest4.SetQuestDescription("testing 4");
			quest4.SetQuestGiverDialog("Go");
			quest4.SetQuestReceiverDialog("Stop");
			Quest quest5 = new Quest();
			quest5.SetIdInConflict(5);
			quest5.SetPreReqIdInConflict(4);
			quest5.SetQuestReceiverNpcId(0);
			quest5.SetQuestGiverNpcId(0);
			quest5.SetQuestArcType("return elixir");
			quest5.SetPreReqQuestId(4);
			quest5.SetConflictId(conflictId);
			quest5.SetQuestId(5);
			quest5.SetMinCharacterLevel(1);
			quest5.SetQuestName("test 5");
			quest5.SetQuestDescription("testing 5");
			quest5.SetQuestGiverDialog("Go");
			quest5.SetQuestReceiverDialog("Stop");
			existingTheQuestArrayList.add(quest1);
			existingTheQuestArrayList.add(quest2);
			existingTheQuestArrayList.add(quest3);
			existingTheQuestArrayList.add(quest4);
			existingTheQuestArrayList.add(quest5);
			this.createNewQuestChainInDB(existingTheQuestArrayList);
			this.existingTheQuestArrayList = this.theQuestsController.GetQuestsByConflictID(theConflictIdToEdit);
		}
	}
	
	public void clearExistingQuestsToEdit() {
		existingTheQuestArrayList.clear();
	}
	
	private void createNewQuestChainInDB (ArrayList<Quest> questsToCreate) throws SQLException {
		for (Quest quest : questsToCreate) {
			this.theQuestsController.CreateQuest(quest.GetQuestGiverNpcId(), quest.GetQuestGiverNpcId(), quest.GetPreReqQuestId(), quest.GetConflictId(), quest.GetMinCharacterLevel(), quest.GetQuestName(), quest.GetQuestDescription(), quest.GetQuestArcType(), quest.GetQuesGiverDialog(), quest.GetQuestReceiverDialog(), quest.GetidInConflict(), quest.GetPreReqQuestId());
		}
	}
	
	private void updateQuestChainInDB (ArrayList<Quest> questsToUpdate) throws SQLException {
		for (Quest quest : questsToUpdate) {
			String outcome = this.theQuestsController.UpdateQuest(quest, quest.GetQuestReceiverNpcId(), quest.GetQuestGiverNpcId(), quest.GetPreReqQuestId(), quest.GetConflictId(), quest.GetMinCharacterLevel(), quest.GetQuestName(), quest.GetQuestDescription(), quest.GetQuestArcType(), quest.GetQuesGiverDialog(), quest.GetQuestReceiverDialog(), quest.GetidInConflict(), quest.GetPreReqQuestId());
			if (outcome != null) {
				System.out.println(outcome);
			}
		}
	}
	
	/**
	 * Get the Observable Player List
	 * @return	the observable list
	 */
	public ObservableList<Quest> GetObservableTheQuestList() {
		return observableTheQuestList;
	}
}
