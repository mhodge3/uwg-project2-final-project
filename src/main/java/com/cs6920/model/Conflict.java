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
public class Conflict {
	
	private IntegerProperty conflictId;
	private IntegerProperty conflictMinLvl;
	private IntegerProperty conflictTemplate;
	private StringProperty conflictName;
	private StringProperty conflictDescription;
	private StringProperty conflictArcType;
	
	/**
	 * Constructor for testing
	 */
	public Conflict() {
		
	}
	
	/**
	 * Constructor for Conflicts
	 * @param conflictId
	 * @param conflictTemplate
	 * @param conflictName
	 * @param conflictDescription
	 */
	public Conflict(int conflictId, int conflictMinLvl, int conflictTemplate, String conflictName, String conflictDescription, String arcType) {
		this.conflictId = new SimpleIntegerProperty(conflictId);
		this.conflictMinLvl = new SimpleIntegerProperty(conflictMinLvl);
		this.conflictTemplate = new SimpleIntegerProperty(conflictTemplate);
		this.conflictName = new SimpleStringProperty(conflictName);
		this.conflictDescription = new SimpleStringProperty(conflictDescription);
		this.conflictArcType = new SimpleStringProperty(arcType);
	}
	
	/**
	 * Gets the conflictId
	 * @return conflictId
	 */
	public int getConflictId() {
		return conflictId.get();
	}
	
	/**
	 * Gets the conflictId property
	 * @return Property for TableView
	 */
	public final IntegerProperty conflictIdProperty() {
	   return conflictId;
	}
	
	/**
	 * Sets the conflictId
	 * @param setConflictId
	 */
	public void setConflictId(int setConflictId) {
		this.conflictId = new SimpleIntegerProperty(setConflictId);
	}
	
	/**
	 * Gets the conflictMinLvl
	 * @return conflictMinLvl
	 */
	public int getConflictMinLvl() {
		return conflictMinLvl.get();
	}
	
	/**
	 * Gets the conflictMinLvl property
	 * @return Property for TableView
	 */
	public final IntegerProperty conflictMinLvlProperty() {
	   return conflictMinLvl;
	}
	
	/**
	 * Sets the conflictMinLvl
	 * @param setConflictMinLvl
	 */
	public void setConflictMinLvl(int setConflictMinLvl) {
		this.conflictMinLvl = new SimpleIntegerProperty(setConflictMinLvl);
	}
	
	/**
	 * Gets the conflictName
	 * @return conflictName
	 */
	public String getConflictName() {
		return conflictName.get();
	}
	
	/**
	 * Gets the conflictName property
	 * @return Property for TableView
	 */
	public final StringProperty conflictNameProperty() {
	   return conflictName;
	}
	
	/**
	 * Sets the conflictName
	 * @param conflictName
	 */
	public void setConflictName(String SetConflictName) {
		this.conflictName = new SimpleStringProperty(SetConflictName);
	}
	
	/**
	 * Gets the conflictTemplate
	 * @return conflictTemplate
	 */
	public int getConflictTemplate() {
		return conflictTemplate.get();
	}
	
	/**
	 * Gets the conflictTemplate property
	 * @return Property for TableView
	 */
	public final IntegerProperty conflictTemplateProperty() {
	   return conflictTemplate;
	}
	
	/**
	 * Sets the conflictTemplate
	 * @param conflictTemplate
	 */
	public void setConflictTemplate(int setConflictTemplate) {
		this.conflictTemplate = new SimpleIntegerProperty(setConflictTemplate);
	}
	
	/**
	 * Gets the conflictDescription
	 * @return conflictDescription
	 */
	public String getConflictDescription() {
		return conflictDescription.get();
	}
	
	/**
	 * Gets the conflictDescription property
	 * @return Property for TableView
	 */
	public final StringProperty conflictDescriptionProperty() {
	   return conflictDescription;
	}
	
	/**
	 * Sets the conflictTemplate
	 * @param conflictTemplate
	 */
	public void setConflictDescription(String setConflictDescription) {
		this.conflictDescription = new SimpleStringProperty(setConflictDescription);
	}
	/**
	 * Gets the conflictDescription
	 * @return conflictDescription
	 */
	public String getConflictArcType() {
		return this.conflictArcType.get();
	}
	
	/**
	 * Gets the conflictDescription property
	 * @return Property for TableView
	 */
	public final StringProperty conflictArcTypeProperty() {
	   return this.conflictArcType;
	}
	
	/**
	 * Sets the conflictTemplate
	 * @param conflictTemplate
	 */
	public void setConflictArcType(String arcType) {
		this.conflictArcType = new SimpleStringProperty(arcType);
	}
}
