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
	
	public void setTheConflictToEdit(Conflict theConflictToEdit) {
		this.theConflictIdToEdit = theConflictToEdit.getConflictId();
		this.theConflictToEdit = theConflictToEdit;
	}
	
	public ArrayList<Quest> getExistingQuestList() {
		return this.existingTheQuestArrayList;
	}

	/**
	 * Update the observable list of objects for any changes
	 * @throws SQLException
	 */
	public void updateTheQuestArrayList() throws SQLException {
		observableTheQuestList.clear();
		observableTheQuestList.addAll(existingTheQuestArrayList);
	}
	
	public int getConflictIdToEdit () {
		return this.theConflictIdToEdit;
	}
	
	public Conflict getConflict() {
		return this.theConflictToEdit;
	}
	
	public void updateTheConflict() throws SQLException {
		this.theConflictDAL.updateConflict(this.theConflictToEdit, this.theConflictToEdit.getConflictMinLvl(), this.theConflictToEdit.getConflictTemplate(), this.theConflictToEdit.getConflictName(), this.theConflictToEdit.getConflictDescription(), this.theConflictToEdit.getConflictArcType());
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
			if (quest.getQuestArcType().contentEquals("obstacle")) {
				highestVariableQuest = quest.getidInConflict();
			}
		}
		return highestVariableQuest;
	}
	
	private void insertNewObstacleQuest(Quest newObstacleQuest) throws SQLException {
		existingTheQuestArrayList.add(newObstacleQuest);
		for (Quest quest : existingTheQuestArrayList) {
			if (quest.getidInConflict() >= newObstacleQuest.getidInConflict() && quest.getQuestId() != 0) {
				quest.setIdInConflict(quest.getidInConflict() + 1);
				quest.setPreReqIdInConflict(quest.getidPreReqIdConflict() + 1);
			}
		}
		this.updateQuestChainInDB();
	}
	
	public void addObstacle() throws SQLException {
		int highestObstacleQuestId = this.getHighestVariableQuestId();
		Quest obstacleQuest = new Quest(); 
		obstacleQuest.setQuestArcType(this.getQuestVariableType());
		obstacleQuest.setPreReqIdInConflict(highestObstacleQuestId);
		obstacleQuest.setConflictId(theConflictIdToEdit);
		obstacleQuest.setQuestId(0);
		obstacleQuest.setIdInConflict(highestObstacleQuestId + 1);
		obstacleQuest.setMinCharacterLevel(1);
		obstacleQuest.setQuestReceiverNpcId(0);
		obstacleQuest.setQuestGiverNpcId(0);
		obstacleQuest.setPreReqQuestId(2);
		obstacleQuest.setQuestName("name - change me");
		obstacleQuest.setQuestDescription("description - change me");
		obstacleQuest.setQuestGiverDialog("Go");
		obstacleQuest.setQuestReceiverDialog("Stop");
		this.insertNewObstacleQuest(obstacleQuest);
	}
	
	public void updateQuestChainInDB() throws SQLException {
		for (Quest quest : existingTheQuestArrayList) {
			if (quest.getQuestId() == 0) {
				int questId = this.theQuestsController.createQuest(quest.getQuestReceiverNpcId(), quest.getQuestGiverNpcId(), 
						quest.getPreReqQuestId(), quest.getConflictId(), quest.getMinCharacterLevel(), 
						quest.getQuestName(), quest.getQuestDescription(), quest.getQuestArcType(), 
						quest.getQuesGiverDialog(), quest.getQuestReceiverDialog(), quest.getidInConflict(),
						quest.getidPreReqIdConflict());
				quest.setQuestId(questId);
			}
			else {
				this.theQuestsController.updateQuest(quest, quest.getQuestReceiverNpcId(), quest.getQuestGiverNpcId(), 
						quest.getPreReqQuestId(), quest.getConflictId(), quest.getMinCharacterLevel(), 
						quest.getQuestName(), quest.getQuestDescription(), quest.getQuestArcType(), 
						quest.getQuesGiverDialog(), quest.getQuestReceiverDialog(), quest.getidInConflict(),
						quest.getidPreReqIdConflict());
			}
		}
		ArrayList<Quest> removedQuests = new ArrayList<Quest>();
		ArrayList<Quest> existingQuests = this.theQuestsController.getQuestsByConflictID(theConflictIdToEdit);
		for (Quest existingQuest : existingQuests) {
			Boolean foundQuest = false;
			for (Quest currentQuest : existingTheQuestArrayList) {
				if (currentQuest.getQuestId() == existingQuest.getQuestId()) {
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
				this.theQuestItemsDAL.deleteQuestItemsByQuestId(quest.getQuestId());
				this.theQuestsController.deleteQuest(quest);
			}
		}
		this.createQuestTemplateList();
		this.updateTheQuestArrayList();
	}
	
	public void removeQuest(int questIdToRemove) throws SQLException {
		int idInConlictofRemovedQuest = 0;
		for (Quest quest : existingTheQuestArrayList) {
			if (quest.getQuestId() == questIdToRemove) {
				idInConlictofRemovedQuest = quest.getidInConflict();
				if (!canQuestBeRemoved(quest)) {
					return;
				}
				existingTheQuestArrayList.remove(quest);
				break;
			}
		}
		if (idInConlictofRemovedQuest > 0) {
			for (Quest quest : existingTheQuestArrayList) {
				if (quest.getidInConflict() > idInConlictofRemovedQuest) {
					quest.setIdInConflict(quest.getidInConflict() - 1);
					quest.setPreReqIdInConflict(quest.getidInConflict() - 1);
				}
			}
		}
		this.updateQuestChainInDB();
	}
    
    private Boolean canQuestBeRemoved(Quest theQuestToCheck) {
    	if (!theQuestToCheck.getQuestArcType().matches("custom|insight|obstacle|henchman")) {
    		return false;
    	}
    	if (theQuestToCheck.getQuestArcType().contentEquals("obstacle")) {
			if (questArcTypeCount("obstacle") <= 1) {
				return false;
			}
    	}
    	else if (theQuestToCheck.getQuestArcType().contentEquals("insight")) {
			if (questArcTypeCount("insight") <= 1) {
				return false;
			}
    	}
    	else if (theQuestToCheck.getQuestArcType().contentEquals("custom")) {
			if (questArcTypeCount("custom") <= 1) {
				return false;
			}
    	}
    	return true;
    }
    
    private int questArcTypeCount(String arcTypeName) {
		int questCount = 0;
		for (Quest quest : existingTheQuestArrayList) {
			if (quest.getQuestArcType().contentEquals(arcTypeName)) {
				questCount++;
			}
		}
		return questCount;
    }
    
    public void updateQuestTemplateList() throws SQLException {
    	this.updateQuestChainInDB();
    }
    
    private String getQuestVariableType() {
    	switch (this.theConflictToEdit.getConflictArcType()) {
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
		quest1.setIdInConflict(1);
		quest1.setPreReqIdInConflict(0);
		quest1.setQuestReceiverNpcId(0);
		quest1.setQuestGiverNpcId(0);
		quest1.setQuestArcType("calling");
		quest1.setPreReqQuestId(0);
		quest1.setConflictId(this.theConflictToEdit.getConflictId());
		quest1.setQuestId(1);
		quest1.setMinCharacterLevel(1);
		quest1.setQuestName("test 1");
		quest1.setQuestDescription("testing 1");
		quest1.setQuestGiverDialog("Go");
		quest1.setQuestReceiverDialog("Stop");
		Quest quest2 = new Quest();
		quest2.setIdInConflict(2);
		quest2.setPreReqIdInConflict(1);
		quest2.setQuestReceiverNpcId(0);
		quest2.setQuestGiverNpcId(0);
		quest2.setQuestArcType("leaving");
		quest2.setPreReqQuestId(1);
		quest2.setConflictId(this.theConflictToEdit.getConflictId());
		quest2.setQuestId(2);
		quest2.setMinCharacterLevel(1);
		quest2.setQuestName("test 2");
		quest2.setQuestDescription("testing 2");
		quest2.setQuestGiverDialog("Go");
		quest2.setQuestReceiverDialog("Stop");
		Quest quest3 = new Quest();
		quest3.setIdInConflict(3);
		quest3.setPreReqIdInConflict(2);
		quest3.setQuestReceiverNpcId(0);
		quest3.setQuestGiverNpcId(0);
		quest3.setQuestArcType(this.getQuestVariableType());
		quest3.setPreReqQuestId(2);
		quest3.setConflictId(this.theConflictToEdit.getConflictId());
		quest3.setQuestId(3);
		quest3.setMinCharacterLevel(1);
		quest3.setQuestName("test 3");
		quest3.setQuestDescription("testing 3");
		quest3.setQuestGiverDialog("Go");
		quest3.setQuestReceiverDialog("Stop");
		Quest quest4 = new Quest();
		quest4.setIdInConflict(4);
		quest4.setPreReqIdInConflict(3);
		quest4.setQuestReceiverNpcId(0);
		quest4.setQuestGiverNpcId(0);
		quest4.setQuestArcType("obtain elixir");
		quest4.setPreReqQuestId(3);
		quest4.setConflictId(this.theConflictToEdit.getConflictId());
		quest4.setQuestId(4);
		quest4.setMinCharacterLevel(1);
		quest4.setQuestName("test 4");
		quest4.setQuestDescription("testing 4");
		quest4.setQuestGiverDialog("Go");
		quest4.setQuestReceiverDialog("Stop");
		Quest quest5 = new Quest();
		quest5.setIdInConflict(5);
		quest5.setPreReqIdInConflict(4);
		quest5.setQuestReceiverNpcId(0);
		quest5.setQuestGiverNpcId(0);
		quest5.setQuestArcType("return elixir");
		quest5.setPreReqQuestId(4);
		quest5.setConflictId(this.theConflictToEdit.getConflictId());
		quest5.setQuestId(5);
		quest5.setMinCharacterLevel(1);
		quest5.setQuestName("test 5");
		quest5.setQuestDescription("testing 5");
		quest5.setQuestGiverDialog("Go");
		quest5.setQuestReceiverDialog("Stop");
		existingTheQuestArrayList.add(quest1);
		existingTheQuestArrayList.add(quest2);
		existingTheQuestArrayList.add(quest3);
		existingTheQuestArrayList.add(quest4);
		existingTheQuestArrayList.add(quest5);
		this.createNewQuestChainInDB(existingTheQuestArrayList);
		this.existingTheQuestArrayList = new ArrayList<Quest>();
		this.existingTheQuestArrayList = this.theQuestsController.getQuestsByConflictID(this.theConflictToEdit.getConflictId());
    }
    
    private void firstSetupOfVoyage() throws SQLException {
		Quest quest1 = new Quest();
		quest1.setIdInConflict(1);
		quest1.setPreReqIdInConflict(0);
		quest1.setQuestReceiverNpcId(0);
		quest1.setQuestGiverNpcId(0);
		quest1.setQuestArcType("calling");
		quest1.setPreReqQuestId(0);
		quest1.setConflictId(this.theConflictToEdit.getConflictId());
		quest1.setQuestId(1);
		quest1.setMinCharacterLevel(1);
		quest1.setQuestName("test 1");
		quest1.setQuestDescription("testing 1");
		quest1.setQuestGiverDialog("Go");
		quest1.setQuestReceiverDialog("Stop");
		Quest quest2 = new Quest();
		quest2.setIdInConflict(2);
		quest2.setPreReqIdInConflict(1);
		quest2.setQuestReceiverNpcId(0);
		quest2.setQuestGiverNpcId(0);
		quest2.setQuestArcType("meeting mentor");
		quest2.setPreReqQuestId(1);
		quest2.setConflictId(this.theConflictToEdit.getConflictId());
		quest2.setQuestId(2);
		quest2.setMinCharacterLevel(1);
		quest2.setQuestName("test 2");
		quest2.setQuestDescription("testing 2");
		quest2.setQuestGiverDialog("Go");
		quest2.setQuestReceiverDialog("Stop");
		Quest quest3 = new Quest();
		quest3.setIdInConflict(3);
		quest3.setPreReqIdInConflict(2);
		quest3.setQuestReceiverNpcId(0);
		quest3.setQuestGiverNpcId(0);
		quest3.setQuestArcType("leaving");
		quest3.setPreReqQuestId(2);
		quest3.setConflictId(this.theConflictToEdit.getConflictId());
		quest3.setQuestId(3);
		quest3.setMinCharacterLevel(1);
		quest3.setQuestName("test 3");
		quest3.setQuestDescription("testing 3");
		quest3.setQuestGiverDialog("Go");
		quest3.setQuestReceiverDialog("Stop");
		Quest quest4 = new Quest();
		quest4.setIdInConflict(4);
		quest4.setPreReqIdInConflict(3);
		quest4.setQuestReceiverNpcId(0);
		quest4.setQuestGiverNpcId(0);
		quest4.setQuestArcType("insight");
		quest4.setPreReqQuestId(3);
		quest4.setConflictId(this.theConflictToEdit.getConflictId());
		quest4.setQuestId(4);
		quest4.setMinCharacterLevel(1);
		quest4.setQuestName("test 4");
		quest4.setQuestDescription("testing 4");
		quest4.setQuestGiverDialog("Go");
		quest4.setQuestReceiverDialog("Stop");
		Quest quest5 = new Quest();
		quest5.setIdInConflict(5);
		quest5.setPreReqIdInConflict(4);
		quest5.setQuestReceiverNpcId(0);
		quest5.setQuestGiverNpcId(0);
		quest5.setQuestArcType("return new wisdom");
		quest5.setPreReqQuestId(4);
		quest5.setConflictId(this.theConflictToEdit.getConflictId());
		quest5.setQuestId(5);
		quest5.setMinCharacterLevel(1);
		quest5.setQuestName("test 5");
		quest5.setQuestDescription("testing 5");
		quest5.setQuestGiverDialog("Go");
		quest5.setQuestReceiverDialog("Stop");
		existingTheQuestArrayList.add(quest1);
		existingTheQuestArrayList.add(quest2);
		existingTheQuestArrayList.add(quest3);
		existingTheQuestArrayList.add(quest4);
		existingTheQuestArrayList.add(quest5);
		this.createNewQuestChainInDB(existingTheQuestArrayList);
		this.existingTheQuestArrayList = new ArrayList<Quest>();
		this.existingTheQuestArrayList = this.theQuestsController.getQuestsByConflictID(this.theConflictToEdit.getConflictId());
    }
    
    private void firstSetupOfMonster() throws SQLException {
		Quest quest1 = new Quest();
		quest1.setIdInConflict(1);
		quest1.setPreReqIdInConflict(0);
		quest1.setQuestReceiverNpcId(0);
		quest1.setQuestGiverNpcId(0);
		quest1.setQuestArcType("calling");
		quest1.setPreReqQuestId(0);
		quest1.setConflictId(this.theConflictToEdit.getConflictId());
		quest1.setQuestId(1);
		quest1.setMinCharacterLevel(1);
		quest1.setQuestName("test 1");
		quest1.setQuestDescription("testing 1");
		quest1.setQuestGiverDialog("Go");
		quest1.setQuestReceiverDialog("Stop");
		Quest quest2 = new Quest();
		quest2.setIdInConflict(2);
		quest2.setPreReqIdInConflict(1);
		quest2.setQuestReceiverNpcId(0);
		quest2.setQuestGiverNpcId(0);
		quest2.setQuestArcType("leaving");
		quest2.setPreReqQuestId(1);
		quest2.setConflictId(this.theConflictToEdit.getConflictId());
		quest2.setQuestId(2);
		quest2.setMinCharacterLevel(1);
		quest2.setQuestName("test 2");
		quest2.setQuestDescription("testing 2");
		quest2.setQuestGiverDialog("Go");
		quest2.setQuestReceiverDialog("Stop");
		Quest quest3 = new Quest();
		quest3.setIdInConflict(3);
		quest3.setPreReqIdInConflict(2);
		quest3.setQuestReceiverNpcId(0);
		quest3.setQuestGiverNpcId(0);
		quest3.setQuestArcType("monster");
		quest3.setPreReqQuestId(2);
		quest3.setConflictId(this.theConflictToEdit.getConflictId());
		quest3.setQuestId(3);
		quest3.setMinCharacterLevel(1);
		quest3.setQuestName("test 3");
		quest3.setQuestDescription("testing 3");
		quest3.setQuestGiverDialog("Go");
		quest3.setQuestReceiverDialog("Stop");
		Quest quest4 = new Quest();
		quest4.setIdInConflict(4);
		quest4.setPreReqIdInConflict(3);
		quest4.setQuestReceiverNpcId(0);
		quest4.setQuestGiverNpcId(0);
		quest4.setQuestArcType("return and reward");
		quest4.setPreReqQuestId(3);
		quest4.setConflictId(this.theConflictToEdit.getConflictId());
		quest4.setQuestId(4);
		quest4.setMinCharacterLevel(1);
		quest4.setQuestName("test 4");
		quest4.setQuestDescription("testing 4");
		quest4.setQuestGiverDialog("Go");
		quest4.setQuestReceiverDialog("Stop");
		existingTheQuestArrayList.add(quest1);
		existingTheQuestArrayList.add(quest2);
		existingTheQuestArrayList.add(quest3);
		existingTheQuestArrayList.add(quest4);
		this.createNewQuestChainInDB(existingTheQuestArrayList);
		this.existingTheQuestArrayList = new ArrayList<Quest>();
		this.existingTheQuestArrayList = this.theQuestsController.getQuestsByConflictID(this.theConflictToEdit.getConflictId());
    }
    
    private void firstSetupOfCustom() throws SQLException {
		Quest quest1 = new Quest();
		quest1.setIdInConflict(1);
		quest1.setPreReqIdInConflict(0);
		quest1.setQuestReceiverNpcId(0);
		quest1.setQuestGiverNpcId(0);
		quest1.setQuestArcType("custom");
		quest1.setPreReqQuestId(0);
		quest1.setConflictId(this.theConflictToEdit.getConflictId());
		quest1.setQuestId(1);
		quest1.setMinCharacterLevel(1);
		quest1.setQuestName("test 1");
		quest1.setQuestDescription("testing 1");
		quest1.setQuestGiverDialog("Go");
		quest1.setQuestReceiverDialog("Stop");
		existingTheQuestArrayList.add(quest1);
		this.createNewQuestChainInDB(existingTheQuestArrayList);
		this.existingTheQuestArrayList = new ArrayList<Quest>();
		this.existingTheQuestArrayList = this.theQuestsController.getQuestsByConflictID(this.theConflictToEdit.getConflictId());
    }
	
	public void createQuestTemplateList () throws SQLException {
		existingTheQuestArrayList = new ArrayList<Quest>();
		this.existingTheQuestArrayList = this.theQuestsController.getQuestsByConflictID(this.theConflictToEdit.getConflictId());
		if (this.existingTheQuestArrayList.size() == 0) {
			switch (this.theConflictToEdit.getConflictArcType()) {
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
			this.theQuestsController.createQuest(quest.getQuestGiverNpcId(), quest.getQuestGiverNpcId(), quest.getPreReqQuestId(), quest.getConflictId(), quest.getMinCharacterLevel(), quest.getQuestName(), quest.getQuestDescription(), quest.getQuestArcType(), quest.getQuesGiverDialog(), quest.getQuestReceiverDialog(), quest.getidInConflict(), quest.getidPreReqIdConflict());
		}
	}
	
	/**
	 * Get the Observable Player List
	 * @return	the observable list
	 */
	public ObservableList<Quest> getObservableTheQuestList() {
		return observableTheQuestList;
	}
}
