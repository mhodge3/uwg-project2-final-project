/**
 * 
 */
package com.cs6920.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * @author Ashley Palmer
 * @date 6/25/2020
 *
 */
public class Conflicts {
	
	private IntegerProperty conflictId;
	private IntegerProperty conflictTemplate;
	private StringProperty conflictName;
	private StringProperty conflictDescription;
	
	
	/**
	 * Gets the conflictId
	 * @return conflictId
	 */
	public int GetConflictId() {
		return conflictId.get();
	}
	
	/**
	 * Gets the conflictId property
	 * @return Property for TableView
	 */
	public final IntegerProperty ConflictId() {
	   return conflictId;
	}
	
	
	/**
	 * Sets the conflictId
	 * @param setConflictId
	 */
	public void SetConflictId(int setConflictId) {
		this.conflictId = new SimpleIntegerProperty(setConflictId);
	}
	
	/**
	 * Gets the conflictName
	 * @return conflictName
	 */
	public String GetConflictName() {
		return conflictName.get();
	}
	
	/**
	 * Gets the conflictName property
	 * @return Property for TableView
	 */
	public final StringProperty ConflictNameProperty() {
	   return conflictName;
	}
	
	/**
	 * Sets the conflictName
	 * @param conflictName
	 */
	public void SetPlayerName(String SetConflictName) {
		this.conflictName = new SimpleStringProperty(SetConflictName);
	}
	
	/**
	 * Gets the conflictTemplate
	 * @return conflictTemplate
	 */
	public int GetConflictTemplate() {
		return conflictTemplate.get();
	}
	
	/**
	 * Gets the conflictTemplate property
	 * @return Property for TableView
	 */
	public final IntegerProperty ConflictTemplate() {
	   return conflictTemplate;
	}
	
	
	/**
	 * Sets the conflictTemplate
	 * @param conflictTemplate
	 */
	public void SetConflictTemplate(int setConflictTemplate) {
		this.conflictTemplate = new SimpleIntegerProperty(setConflictTemplate);
	}
	

}
