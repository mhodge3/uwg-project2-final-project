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
	 * Constructor for testing
	 */
	public Conflicts() {
		
	}
	
	
	/**
	 * Constructor for Conflicts
	 * @param conflictId
	 * @param conflictTemplate
	 * @param conflictName
	 * @param conflictDescription
	 */
	public Conflicts(int conflictId, int conflictTemplate, String conflictName, String conflictDescription) {
		this.conflictId = new SimpleIntegerProperty(conflictId);
		this.conflictTemplate = new SimpleIntegerProperty(conflictTemplate);
		this.conflictName = new SimpleStringProperty(conflictName);
		this.conflictDescription = new SimpleStringProperty(conflictDescription);
	}
	
	
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
	public void SetConflictName(String SetConflictName) {
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
	
	/**
	 * Gets the conflictDescription
	 * @return conflictDescription
	 */
	public String GetConflictDescription() {
		return conflictDescription.get();
	}
	
	/**
	 * Gets the conflictDescription property
	 * @return Property for TableView
	 */
	public final StringProperty ConflictDescription() {
	   return conflictDescription;
	}
	
	
	/**
	 * Sets the conflictTemplate
	 * @param conflictTemplate
	 */
	public void SetConflictDescription(String setConflictDescription) {
		this.conflictDescription = new SimpleStringProperty(setConflictDescription);
	}
	

}
