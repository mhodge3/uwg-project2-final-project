package com.cs6920.control.logic_control;

import java.sql.SQLException;
import java.util.ArrayList;

import com.cs6920.DAL.MySQLAccess;
import com.cs6920.DAL.NpcCharacterDAL;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import com.cs6920.model.NpcCharacter;

/**
 * Logic Control for Managing NPC Characters, Communicates between the View and DAL for this feature
 * @author Matthew Hodge
 * @version 6.13.2020
 */
public class ManageNPCCharactersControl {
	private NpcCharacterDAL nPCCharacterDAL;
	private ArrayList<NpcCharacter> existingNPCArrayList;
	private ObservableList<NpcCharacter> observableNPCList = FXCollections.observableArrayList();
	
	/**
	 * Constructor that sets up the DAL to the current DBConnection class instance
	 * @param theDBConnection
	 */
	public ManageNPCCharactersControl(MySQLAccess theDBConnection) {
		this.nPCCharacterDAL = new NpcCharacterDAL(theDBConnection);
	}
	
	/**
	 * Update the observable list of objects for any changes
	 * @throws SQLException
	 */
	public void updatePlayerArrayList() throws SQLException {
		this.existingNPCArrayList = new ArrayList<NpcCharacter>();
		this.existingNPCArrayList = this.nPCCharacterDAL.getAllNpc();
		this.observableNPCList.clear();
		this.observableNPCList.addAll(this.existingNPCArrayList);
	}
	
	/**
	 * Get the Observable Player List
	 * @return	the observable list
	 */
	public ObservableList<NpcCharacter> getObservablePlayerList() {
		return this.observableNPCList;
	}
}
