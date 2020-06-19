package controller.logicController;

import java.sql.SQLException;
import java.util.ArrayList;

import DAL.MySQLAccess;
import DAL.NpcCharacterDAL;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.NpcCharacter;

/**
 * Logic Control for Managing NPC Characters, Communicates between the View and DAL for this feature
 * @author Matthew Hodge
 * @version 6.13.2020
 */
public class ManageNPCCharactersControl {
	private NpcCharacterDAL nPCCharacterDAL;
	private ArrayList<NpcCharacter> existingNPCArrayList;
	private ObservableList<NpcCharacter> observableNPCList = FXCollections.observableArrayList();
	
	public ManageNPCCharactersControl(MySQLAccess theDBConnection) {
		this.nPCCharacterDAL = new NpcCharacterDAL(theDBConnection);
	}
	
	public void UpdatePlayerArrayList() throws SQLException {
		existingNPCArrayList = new ArrayList<NpcCharacter>();
		existingNPCArrayList = nPCCharacterDAL.GetAllNpc();
		observableNPCList.clear();
		observableNPCList.addAll(existingNPCArrayList);
	}
	
	/**
	 * Get the Observable Player List
	 * @return	the observable list
	 */
	public ObservableList<NpcCharacter> GetObservablePlayerList() {
		return observableNPCList;
	}
}
