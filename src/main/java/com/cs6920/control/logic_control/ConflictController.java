package com.cs6920.control.logic_control;

import java.sql.SQLException;
import java.util.ArrayList;

import com.cs6920.DAL.ConflictDAL;
import com.cs6920.DAL.MySQLAccess;
import com.cs6920.model.Conflict;

/**
* Controller class that retrieves data from the ConflictDAL
* @author Perry Iler
* @date 7/2/2020
*
*/
public class ConflictController {
	private ConflictDAL theConflictDAL;
	
	/**
	 * One parameter constructor for a ConflictController
	 * @param theDBConnection
	 */
	public ConflictController(MySQLAccess theDBConnection) {
		this.theConflictDAL = new ConflictDAL(theDBConnection);
	}
	
	/**
	 * Calls the CreateConflict method of the ConflictDAL
	 * @param conflictId
	 * @param conflictMinLvl
	 * @param conflictTemplate
	 * @param conflictName
	 * @param conflictDescription
	 * @param arcType
	 * @return True if inserted | False if not inserted
	 * @throws SQLException
	 */
	public String createConflict(int conflictMinLvl, int conflictTemplate, String conflictName, 
								String conflictDescription, String arcType) throws SQLException {
		if (String.valueOf(conflictMinLvl) == null) {
			return "The conflict MinLevel cannot be empty";
		}
		else if (String.valueOf(conflictTemplate) == null) {
			return "The conflict template cannot be empty";
		}
		else if (conflictName == null || conflictName.trim().length() == 0) {
			return "The conflict name cannot be empty";
		}
		else if (conflictDescription == null || conflictDescription.trim().length() == 0) {
			return "The conflict description cannot be empty";
		}
		else if (arcType == null || arcType.trim().length() == 0) {
			return "The arc type Code cannot be empty";
		}
		else {
			this.theConflictDAL.createConflict(conflictMinLvl, conflictTemplate, conflictName, conflictDescription, arcType);
			return null;
		}
	}
	
	/**
	 * Calls the GetQuestByID method of the ConflictDAL
	 * @param conflictId
	 * @return The Conflict found
	 * @throws SQLException
	 */
	public Conflict getQuestByID(int conflictId) throws SQLException {
		return this.getQuestByID(conflictId);
    }
	
	/**
	 * Calls the CreateConflict method of the ConflictDAL
	 * @param conflictId
	 * @return The Conflict found
	 * @throws SQLException
	 */
	public ArrayList<Conflict> getConflicts() throws SQLException {
		return this.theConflictDAL.getConflicts();
    }
	
	/**
	 * Calls the GetQuestByName method of the ConflictDAL
	 * @param conflictName
	 * @return The Conflict found
	 * @throws SQLException
	 */
	public Conflict getQuestByName(String conflictName) throws SQLException {
		return this.theConflictDAL.getQuestByName(conflictName);
    }
	
	/**
	 * Calls the UpdateConflict method of the ConflictDAL
	 * @param conflict
	 * @param conflictMinLvl
	 * @param conflictTemplate
	 * @param conflictName
	 * @param conflictDescription
	 * @param arcType
	 * @return True if updated | False if not updated
	 * @throws SQLException
	 */
	public String updateConflict(Conflict conflict, int conflictMinLvl, int conflictTemplate, 
			  String conflictName, String conflictDescription, String arcType) throws SQLException {
		if (String.valueOf(conflictMinLvl) == null) {
			conflictMinLvl = conflict.getConflictMinLvl();
		}
		if (String.valueOf(conflictTemplate) == null) {
			conflictTemplate = conflict.getConflictTemplate();
		}
		if (conflictName == null || conflictName.trim().length() == 0) {
			conflictName = conflict.getConflictName();
		}
		if (conflictDescription == null || conflictDescription.trim().length() == 0) {
			conflictDescription = conflict.getConflictDescription();
		}
		if (arcType == null || arcType.trim().length() == 0) {
			arcType = conflict.getConflictArcType();
		}
		if (this.theConflictDAL.updateConflict(conflict, conflictMinLvl, conflictTemplate, conflictName, conflictDescription, arcType)){
			return null;
		}
		else {
			return "There was a problem updating the conflict";
		}
	}
	
	/**
	 * Calls the DeleteConflict method of the ConflictDAL
	 * @param conflict
	 * @return True if deleted | False if not deleted
	 * @throws SQLException
	 */
	public boolean deleteConflict(Conflict conflict) throws SQLException {
		return this.theConflictDAL.deleteConflict(conflict);
	}

}
