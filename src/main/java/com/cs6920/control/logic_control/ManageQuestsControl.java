package com.cs6920.control.logic_control;

import java.sql.SQLException;
import java.util.ArrayList;

import com.cs6920.DAL.ConflictDAL;
import com.cs6920.DAL.MySQLAccess;
import com.cs6920.DAL.QuestItemsDAL;
import com.cs6920.model.Conflict;
import com.cs6920.model.Quest;
import com.cs6920.model.QuestItems;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ManageQuestsControl {
	//private PlayerDAL playerDAL;
	private ArrayList<Quest> existingTheQuestArrayList;
	private ObservableList<Quest> observableTheQuestList = FXCollections.observableArrayList();
	private int theConflictIdToEdit;
	private QuestsController theQuestsController;
	private QuestItemsDAL theQuestItemsDAL;
	private Conflict theConflictToEdit;
	private ConflictDAL theConflictDAL;
	
	/**
	 * Constructor that sets up the DAL to the current DBConnection class instance
	 * @param theDBConnection
	 */
	public ManageQuestsControl(MySQLAccess theDBConnection) {
		//this.playerDAL = new PlayerDAL(theDBConnection);
		this.theQuestsController = new QuestsController(theDBConnection);
		this.theQuestItemsDAL = new QuestItemsDAL(theDBConnection);
		this.theConflictDAL = new ConflictDAL(theDBConnection);
	}
	
	public void SetTheConflictToEdit(Conflict theConflictToEdit) {
		this.theConflictIdToEdit = theConflictToEdit.GetConflictId();
		this.theConflictToEdit = theConflictToEdit;
	}
	
	public ArrayList<Quest> getExistingQuestList() {
		return this.existingTheQuestArrayList;
	}

	/**
	 * Update the observable list of objects for any changes
	 * @throws SQLException
	 */
	public void UpdateTheQuestArrayList() throws SQLException {
		observableTheQuestList.clear();
		observableTheQuestList.addAll(existingTheQuestArrayList);
	}
	
	public int GetConflictIdToEdit () {
		return this.theConflictIdToEdit;
	}
	
	public Conflict getConflict() {
		return this.theConflictToEdit;
	}
	
	public void updateTheConflict() throws SQLException {
		this.theConflictDAL.UpdateConflict(this.theConflictToEdit, this.theConflictToEdit.GetConflictMinLvl(), this.theConflictToEdit.GetConflictTemplate(), this.theConflictToEdit.GetConflictName(), this.theConflictToEdit.GetConflictDescription(), this.theConflictToEdit.GetConflictArcType());
	}
	
	private int getHighestVariableQuestId () {
		int highestVariableQuest = 3;
		if (this.getQuestVariableType() == "insight") {
			highestVariableQuest = 4;
		}
		if (this.getQuestVariableType() == "henchman") {
			highestVariableQuest = 2;
		}
		if (this.getQuestVariableType() == "custom") {
			highestVariableQuest = 1;
		}
		for (Quest quest : existingTheQuestArrayList) {
			if (quest.GetQuestArcType().contentEquals("obstacle")) {
				highestVariableQuest = quest.GetidInConflict();
			}
		}
		return highestVariableQuest;
	}
	
	private void insertNewObstacleQuest(Quest newObstacleQuest) throws SQLException {
		existingTheQuestArrayList.add(newObstacleQuest);
		for (Quest quest : existingTheQuestArrayList) {
			if (quest.GetidInConflict() >= newObstacleQuest.GetidInConflict() && quest.GetQuestId() != 0) {
				quest.SetIdInConflict(quest.GetidInConflict() + 1);
				quest.SetPreReqIdInConflict(quest.GetidPreReqIdConflict() + 1);
			}
		}
		this.updateQuestChainInDB();
	}
	
	public void addObstacle() throws SQLException {
		int highestObstacleQuestId = this.getHighestVariableQuestId();
		Quest obstacleQuest = new Quest(); 
		obstacleQuest.SetQuestArcType(this.getQuestVariableType());
		obstacleQuest.SetPreReqIdInConflict(highestObstacleQuestId);
		obstacleQuest.SetConflictId(theConflictIdToEdit);
		obstacleQuest.SetQuestId(0);
		obstacleQuest.SetIdInConflict(highestObstacleQuestId + 1);
		obstacleQuest.SetMinCharacterLevel(1);
		obstacleQuest.SetQuestReceiverNpcId(0);
		obstacleQuest.SetQuestGiverNpcId(0);
		obstacleQuest.SetPreReqQuestId(2);
		obstacleQuest.SetQuestName("name - change me");
		obstacleQuest.SetQuestDescription("description - change me");
		obstacleQuest.SetQuestGiverDialog("Go");
		obstacleQuest.SetQuestReceiverDialog("Stop");
		this.insertNewObstacleQuest(obstacleQuest);
	}
	
	public void updateQuestChainInDB() throws SQLException {
		for (Quest quest : existingTheQuestArrayList) {
			if (quest.GetQuestId() == 0) {
				int questId = this.theQuestsController.CreateQuest(quest.GetQuestReceiverNpcId(), quest.GetQuestGiverNpcId(), 
						quest.GetPreReqQuestId(), quest.GetConflictId(), quest.GetMinCharacterLevel(), 
						quest.GetQuestName(), quest.GetQuestDescription(), quest.GetQuestArcType(), 
						quest.GetQuesGiverDialog(), quest.GetQuestReceiverDialog(), quest.GetidInConflict(),
						quest.GetidPreReqIdConflict());
				quest.SetQuestId(questId);
			}
			else {
				this.theQuestsController.UpdateQuest(quest, quest.GetQuestReceiverNpcId(), quest.GetQuestGiverNpcId(), 
						quest.GetPreReqQuestId(), quest.GetConflictId(), quest.GetMinCharacterLevel(), 
						quest.GetQuestName(), quest.GetQuestDescription(), quest.GetQuestArcType(), 
						quest.GetQuesGiverDialog(), quest.GetQuestReceiverDialog(), quest.GetidInConflict(),
						quest.GetidPreReqIdConflict());
			}
		}
		ArrayList<Quest> removedQuests = new ArrayList<Quest>();
		ArrayList<Quest> existingQuests = this.theQuestsController.GetQuestsByConflictID(theConflictIdToEdit);
		for (Quest existingQuest : existingQuests) {
			Boolean foundQuest = false;
			for (Quest currentQuest : existingTheQuestArrayList) {
				if (currentQuest.GetQuestId() == existingQuest.GetQuestId()) {
					foundQuest = true;
					break;
				}
			}
			if (!foundQuest) {
				removedQuests.add(existingQuest);
			}
		}
		if (removedQuests.size() > 0) {
			for (Quest quest : removedQuests) {
				this.theQuestItemsDAL.DeleteQuestItemsByQuestId(quest.GetQuestId());
				this.theQuestsController.DeleteQuest(quest);
			}
		}
		this.createQuestTemplateList();
		this.UpdateTheQuestArrayList();
	}
	
	public void removeQuest(int questIdToRemove) throws SQLException {
		int idInConlictofRemovedQuest = 0;
		for (Quest quest : existingTheQuestArrayList) {
			if (quest.GetQuestId() == questIdToRemove) {
				idInConlictofRemovedQuest = quest.GetidInConflict();
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
		}
		this.updateQuestChainInDB();
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
    	this.updateQuestChainInDB();
    }
    
    private String getQuestVariableType() {
    	switch (this.theConflictToEdit.GetConflictArcType()) {
	    	case "The Quest":
	    		return "obstacle";
	    	case "Voyage and Return":
	    		return "insight";
	    	case "Defeat the Monster":
	    		return "henchman";
	    	case "Custom":
	    		return "custom";
	    	default: return "unkown";
    	}
    }
    
    private void firstSetupOfTheQuest() throws SQLException {
		Quest quest1 = new Quest();
		quest1.SetIdInConflict(1);
		quest1.SetPreReqIdInConflict(0);
		quest1.SetQuestReceiverNpcId(0);
		quest1.SetQuestGiverNpcId(0);
		quest1.SetQuestArcType("calling");
		quest1.SetPreReqQuestId(0);
		quest1.SetConflictId(this.theConflictToEdit.GetConflictId());
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
		quest2.SetConflictId(this.theConflictToEdit.GetConflictId());
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
		quest3.SetQuestArcType(this.getQuestVariableType());
		quest3.SetPreReqQuestId(2);
		quest3.SetConflictId(this.theConflictToEdit.GetConflictId());
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
		quest4.SetConflictId(this.theConflictToEdit.GetConflictId());
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
		quest5.SetConflictId(this.theConflictToEdit.GetConflictId());
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
		this.existingTheQuestArrayList = new ArrayList<Quest>();
		this.existingTheQuestArrayList = this.theQuestsController.GetQuestsByConflictID(this.theConflictToEdit.GetConflictId());
    }
    
    private void firstSetupOfVoyage() throws SQLException {
		Quest quest1 = new Quest();
		quest1.SetIdInConflict(1);
		quest1.SetPreReqIdInConflict(0);
		quest1.SetQuestReceiverNpcId(0);
		quest1.SetQuestGiverNpcId(0);
		quest1.SetQuestArcType("calling");
		quest1.SetPreReqQuestId(0);
		quest1.SetConflictId(this.theConflictToEdit.GetConflictId());
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
		quest2.SetQuestArcType("meeting mentor");
		quest2.SetPreReqQuestId(1);
		quest2.SetConflictId(this.theConflictToEdit.GetConflictId());
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
		quest3.SetQuestArcType("leaving");
		quest3.SetPreReqQuestId(2);
		quest3.SetConflictId(this.theConflictToEdit.GetConflictId());
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
		quest4.SetQuestArcType("insight");
		quest4.SetPreReqQuestId(3);
		quest4.SetConflictId(this.theConflictToEdit.GetConflictId());
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
		quest5.SetQuestArcType("return new wisdom");
		quest5.SetPreReqQuestId(4);
		quest5.SetConflictId(this.theConflictToEdit.GetConflictId());
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
		this.existingTheQuestArrayList = new ArrayList<Quest>();
		this.existingTheQuestArrayList = this.theQuestsController.GetQuestsByConflictID(this.theConflictToEdit.GetConflictId());
    }
    
    private void firstSetupOfMonster() throws SQLException {
		Quest quest1 = new Quest();
		quest1.SetIdInConflict(1);
		quest1.SetPreReqIdInConflict(0);
		quest1.SetQuestReceiverNpcId(0);
		quest1.SetQuestGiverNpcId(0);
		quest1.SetQuestArcType("calling");
		quest1.SetPreReqQuestId(0);
		quest1.SetConflictId(this.theConflictToEdit.GetConflictId());
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
		quest2.SetConflictId(this.theConflictToEdit.GetConflictId());
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
		quest3.SetQuestArcType("monster");
		quest3.SetPreReqQuestId(2);
		quest3.SetConflictId(this.theConflictToEdit.GetConflictId());
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
		quest4.SetQuestArcType("return and reward");
		quest4.SetPreReqQuestId(3);
		quest4.SetConflictId(this.theConflictToEdit.GetConflictId());
		quest4.SetQuestId(4);
		quest4.SetMinCharacterLevel(1);
		quest4.SetQuestName("test 4");
		quest4.SetQuestDescription("testing 4");
		quest4.SetQuestGiverDialog("Go");
		quest4.SetQuestReceiverDialog("Stop");
		existingTheQuestArrayList.add(quest1);
		existingTheQuestArrayList.add(quest2);
		existingTheQuestArrayList.add(quest3);
		existingTheQuestArrayList.add(quest4);
		this.createNewQuestChainInDB(existingTheQuestArrayList);
		this.existingTheQuestArrayList = new ArrayList<Quest>();
		this.existingTheQuestArrayList = this.theQuestsController.GetQuestsByConflictID(this.theConflictToEdit.GetConflictId());
    }
    
    private void firstSetupOfCustom() throws SQLException {
		Quest quest1 = new Quest();
		quest1.SetIdInConflict(1);
		quest1.SetPreReqIdInConflict(0);
		quest1.SetQuestReceiverNpcId(0);
		quest1.SetQuestGiverNpcId(0);
		quest1.SetQuestArcType("custom");
		quest1.SetPreReqQuestId(0);
		quest1.SetConflictId(this.theConflictToEdit.GetConflictId());
		quest1.SetQuestId(1);
		quest1.SetMinCharacterLevel(1);
		quest1.SetQuestName("test 1");
		quest1.SetQuestDescription("testing 1");
		quest1.SetQuestGiverDialog("Go");
		quest1.SetQuestReceiverDialog("Stop");
		existingTheQuestArrayList.add(quest1);
		this.createNewQuestChainInDB(existingTheQuestArrayList);
		this.existingTheQuestArrayList = new ArrayList<Quest>();
		this.existingTheQuestArrayList = this.theQuestsController.GetQuestsByConflictID(this.theConflictToEdit.GetConflictId());
    }
	
	public void createQuestTemplateList () throws SQLException {
		existingTheQuestArrayList = new ArrayList<Quest>();
		this.existingTheQuestArrayList = this.theQuestsController.GetQuestsByConflictID(this.theConflictToEdit.GetConflictId());
		if (this.existingTheQuestArrayList.size() == 0) {
			switch (this.theConflictToEdit.GetConflictArcType()) {
				case "The Quest":
					this.firstSetupOfTheQuest();
					break;
				case "Voyage and Return":
					this.firstSetupOfVoyage();
					break;
				case "Defeat the Monster":
					this.firstSetupOfMonster();
					break;
				case "Custom":
					this.firstSetupOfCustom();
					break;
				default: break;
			}
		}
	}
	
	public void clearExistingQuestsToEdit() {
		existingTheQuestArrayList.clear();
	}
	
	private void createNewQuestChainInDB (ArrayList<Quest> questsToCreate) throws SQLException {
		for (Quest quest : questsToCreate) {
			this.theQuestsController.CreateQuest(quest.GetQuestGiverNpcId(), quest.GetQuestGiverNpcId(), quest.GetPreReqQuestId(), quest.GetConflictId(), quest.GetMinCharacterLevel(), quest.GetQuestName(), quest.GetQuestDescription(), quest.GetQuestArcType(), quest.GetQuesGiverDialog(), quest.GetQuestReceiverDialog(), quest.GetidInConflict(), quest.GetidPreReqIdConflict());
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