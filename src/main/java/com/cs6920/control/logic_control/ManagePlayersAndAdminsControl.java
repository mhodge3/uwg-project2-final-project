package com.cs6920.control.logic_control;

import java.sql.SQLException;
import java.util.ArrayList;

import com.cs6920.DAL.MySQLAccess;
import com.cs6920.DAL.PlayerDAL;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import com.cs6920.model.Player;

/**
 * Logic Control for Managing Players and Admins, Communicates between the View and DAL for this feature
 * @author Matthew Hodge
 * @version 6.13.2020
 */
public class ManagePlayersAndAdminsControl {
	private PlayerDAL playerDAL;
	private ArrayList<Player> existingPlayerAdminArrayList;
	private ObservableList<Player> observablePlayerList = FXCollections.observableArrayList();
	
	public ManagePlayersAndAdminsControl(MySQLAccess theDBConnection) {
		this.playerDAL = new PlayerDAL(theDBConnection);
	}
	
	public void UpdatePlayerArrayList() throws SQLException {
		existingPlayerAdminArrayList = new ArrayList<Player>();
		existingPlayerAdminArrayList = playerDAL.GetPlayers();
		observablePlayerList.clear();
		observablePlayerList.addAll(existingPlayerAdminArrayList);
	}
	
	/**
	 * Get the Observable Player List
	 * @return	the observable list
	 */
	public ObservableList<Player> GetObservablePlayerList() {
		return observablePlayerList;
	}
}
