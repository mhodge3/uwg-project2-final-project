package controller.logicController;

import java.sql.SQLException;
import java.util.ArrayList;

import DAL.MySQLAccess;
import DAL.PlayerDAL;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Player;

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
		try {
			GetPlayerArrayList();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void GetPlayerArrayList() throws SQLException {
		existingPlayerAdminArrayList = playerDAL.GetPlayers();
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
