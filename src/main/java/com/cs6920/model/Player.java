/**
 * 
 */
package com.cs6920.model;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * @author Ashley Palmer
 * @date 6/11/2020
 *
 */
public class Player {
	private IntegerProperty playerId;
	private StringProperty playerName;
	private BooleanProperty playerIsAdmin;
	private StringProperty playerCountryCode;
	private StringProperty playerEmail;
	private String playerPassword;
	
	/**
	 * Default Player constructor. Not currently used, but exists for tests
	 */
	public Player () {
		
	}
	
	/**
	 * Player Constructor
	 * @param playerId
	 * @param playerName
	 * @param playerIsAdmin
	 * @param playerCountryCode
	 * @param playerEmail
	 * @param playerPassword
	 */
	public Player(int playerId, String playerName, Boolean playerIsAdmin, String playerCountryCode, String playerEmail, String playerPassword) {
		this.playerId = new SimpleIntegerProperty(playerId);
		this.playerName = new SimpleStringProperty(playerName);
		this.playerIsAdmin = new SimpleBooleanProperty(playerIsAdmin);
		this.playerCountryCode = new SimpleStringProperty(playerCountryCode);
		this.playerEmail = new SimpleStringProperty(playerEmail);
		this.playerPassword = playerPassword;
	}
	
	/**
	 * Gets the player Name
	 * @return playerName
	 */
	public String GetPlayerName() {
		return playerName.get();
	}
	
	/**
	 * Gets the player name property
	 * @return Property for TableView
	 */
	public final StringProperty playerNameProperty() {
	   return playerName;
	}
	
	/**
	 * Sets the playerName
	 * @param userName
	 */
	public void SetPlayerName(String userName) {
		this.playerName = new SimpleStringProperty(userName);
	}
	
	/**
	 * Gets PlayerIsAdmin
	 * @return playerIsAdmin
	 */
	public Boolean GetPlayerIsAdmin() {
		return playerIsAdmin.getValue();
	}
	
	/**
	 * Sets PlayerIsAdmin
	 * @param playerIsAdmin
	 */
	public void SetPlayerIsAdmin(Boolean playerIsAdmin) {
		this.playerIsAdmin = new SimpleBooleanProperty(playerIsAdmin);
	}

	/**
	 * Gets the playerIsAdmin property
	 * @return Property for TableView
	 */
	public final BooleanProperty playerIsAdminProperty() {
	   return playerIsAdmin;
	}
	
	/**
	 * Gets playerId
	 * @return playerId
	 */
	public int GetPlayerId() {
		return playerId.get();
	}

	/**
	 * Gets the playerId property
	 * @return Property for TableView
	 */
	public final IntegerProperty playerIdProperty() {
	   return playerId;
	}
	
	/**
	 * Sets the playerId
	 * @param playerId
	 */
	public void SetPlayerId(int playerId) {
		this.playerId = new SimpleIntegerProperty(playerId);
	}
	
	/**
	 * Gets player Country code
	 * @return
	 */
	public String GetPlayerCountryCode() {
		return playerCountryCode.get();
	}

	/**
	 * Gets the playerCountryCode property
	 * @return Property for TableView
	 */
	public final StringProperty playerCountryCodeProperty() {
	   return playerCountryCode;
	}
	
	/**
	 * Sets player Country code
	 * @param setPlayerCountryCode
	 */
	public void SetPlayerCountryCode(String setPlayerCountryCode) {
		this.playerCountryCode = new SimpleStringProperty(setPlayerCountryCode);
	}
	
	/**
	 * Gets the playerEmail
	 * @return playerEmail
	 */
	public String GetPlayerEmail() {
		return playerEmail.get();
	}

	/**
	 * Gets the playerEmail property
	 * @return Property for TableView
	 */
	public final StringProperty playerEmailProperty() {
	   return playerEmail;
	}
	
	/**
	 * Sets the playerEmail
	 * @param setPlayerEmail
	 */
	public void SetPlayerEmail(String setPlayerEmail) {
		this.playerEmail = new SimpleStringProperty(setPlayerEmail);
	}
	
	/**
	 * Gets the playerPassword
	 * @return playerPassword
	 */
	public String GetPlayerPassword() {
		return playerPassword;
	}
	
	/**
	 * Sets the playerPassword
	 * @param setPlayerPassword
	 */
	public void SetPlayerPassword(String setPlayerPassword) {
		this.playerPassword = setPlayerPassword;
	}
}
