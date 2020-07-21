package com.cs6920.DAL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.cs6920.model.Conflict;

/**
 * Data access layer for the Contflicts database table
 * @author Perry Iler
 * @date 7/1/2020
 */
public class ConflictDAL {
	private MySQLAccess sqlAccess;
	private Connection theConnection;
	
	/**
	 * Creates a ConflictDAL object to be used by the controllers
	 */
	public ConflictDAL(MySQLAccess theDBConnection) {
		this.sqlAccess = theDBConnection;
	}
	
	/**
	 * Creates a conflict entry in the database Conflicts table
	 * @param conflictId
	 * @param conflictMinLvl
	 * @param conflictTemplate
	 * @param conflictName
	 * @param conflictDescription
	 * @param arcType
	 * @return True if inserted | False if not inserted
	 * @throws SQLException
	 */
	public Boolean createConflict(int conflictMinLvl, int conflictTemplate, 
								  String conflictName, String conflictDescription, String arcType) throws SQLException {
		Boolean success = false;
		try {
			this.theConnection = this.sqlAccess.getDBConnection();
			String query = "INSERT INTO " + this.sqlAccess.getTheDBName() + ".conflicts " + 
					"(conflict_min_level, " +
					"conflict_template, " +
					"conflict_name, " +
					"conflict_description, " +
					"conflict_arc_type) " +
					"VALUES (?, ?, ?, ?, ?)";		
							
			 PreparedStatement preparedStmt = theConnection.prepareStatement(query);
			 preparedStmt.setString (1, String.valueOf(conflictMinLvl));
			 preparedStmt.setString (2, String.valueOf(conflictTemplate));
			 preparedStmt.setString (3, conflictName);
			 preparedStmt.setString (4, conflictDescription);
			 preparedStmt.setString (5, arcType);
		     preparedStmt.execute();
		      success = true;
		} catch (Exception e) {
        	System.err.println(e.getMessage());
        }
        finally {
        	theConnection.close();
        }
		return success;
	}
	
	/**
	 * Returns Conflict by conflict Id.
	 * @param conflictId
	 * @return The Conflict found
	 * @throws SQLException
	 */
	public Conflict getQuestByID(int conflictId) throws SQLException {
		Conflict conflict = null;
        try {
            this.theConnection = this.sqlAccess.getDBConnection();
            Statement statement = this.theConnection.createStatement();
            String query = "SELECT * FROM " + this.sqlAccess.getTheDBName() + ".conflicts "
            		+ "WHERE " + this.sqlAccess.getTheDBName() + ".conflicts.conflict_id = \"" + conflictId + "\"";
            ResultSet results = statement.executeQuery(query);
            if (results.next() != false) {
            	conflict = new Conflict();
            	conflict.setConflictId(results.getInt("conflict_id"));
            	conflict.setConflictMinLvl(results.getInt("conflict_min_level"));
            	conflict.setConflictTemplate(results.getInt("conflict_template"));
            	conflict.setConflictName(results.getString("conflict_name"));
            	conflict.setConflictDescription(results.getString("conflict_description"));
            	conflict.setConflictArcType(results.getString("conflict_arc_type"));
            }
        } catch (Exception e) {
        	System.err.println(e.getMessage());
        }
        finally {
        	theConnection.close();
        }
        return conflict;
    }
	
	/**
	 * Returns a list of Conflicts by conflict Id.
	 * @param conflictId
	 * @return The Conflict found
	 * @throws SQLException
	 */
	public ArrayList<Conflict> getConflicts() throws SQLException {
		ArrayList<Conflict> conflicts = new ArrayList<Conflict>();
        try {
            this.theConnection = this.sqlAccess.getDBConnection();
            Statement statement = this.theConnection.createStatement();
            String query = "SELECT * FROM " + this.sqlAccess.getTheDBName() + ".conflicts ";
            ResultSet results = statement.executeQuery(query);
            while (results.next() != false) {
            	Conflict conflict = new Conflict();
            	conflict.setConflictId(results.getInt("conflict_id"));
            	conflict.setConflictMinLvl(results.getInt("conflict_min_level"));
            	conflict.setConflictTemplate(results.getInt("conflict_template"));
            	conflict.setConflictName(results.getString("conflict_name"));
            	conflict.setConflictDescription(results.getString("conflict_description"));
            	conflict.setConflictArcType(results.getString("conflict_arc_type"));
            	conflicts.add(conflict);
            }
        } catch (Exception e) {
        	System.err.println(e.getMessage());
        }
        finally {
        	theConnection.close();
        }
        return conflicts;
    }
	
	/**
	 * Returns Conflict by conflict name.
	 * @param conflictName
	 * @return The Conflict found
	 * @throws SQLException
	 */
	public Conflict getQuestByName(String conflictName) throws SQLException {
		Conflict conflict = null;
        try {
            this.theConnection = this.sqlAccess.getDBConnection();
            Statement statement = this.theConnection.createStatement();
            String query = "SELECT * FROM " + this.sqlAccess.getTheDBName() + ".conflicts "
            		+ "WHERE " + this.sqlAccess.getTheDBName() + ".conflicts.conflict_name = \"" + conflictName + "\"";
            ResultSet results = statement.executeQuery(query);
            if (results.next() != false) {
            	conflict = new Conflict();
            	conflict.setConflictId(results.getInt("conflict_id"));
            	conflict.setConflictMinLvl(results.getInt("conflict_min_level"));
            	conflict.setConflictTemplate(results.getInt("conflict_template"));
            	conflict.setConflictName(results.getString("conflict_name"));
            	conflict.setConflictDescription(results.getString("conflict_description"));
            	conflict.setConflictArcType(results.getString("conflict_arc_type"));
            }
        } catch (Exception e) {
        	System.err.println(e.getMessage());
        }
        finally {
        	theConnection.close();
        }
        return conflict;
    }
	
	/**
	 * Updates an existing conflict entry in the database Conflicts table
	 * @param conflict
	 * @param conflictMinLvl
	 * @param conflictTemplate
	 * @param conflictName
	 * @param conflictDescription
	 * @param arcType
	 * @return True if updated | False if not updated
	 * @throws SQLException
	 */
	public Boolean updateConflict(Conflict conflict, int conflictMinLvl, int conflictTemplate, 
			  String conflictName, String conflictDescription, String arcType) throws SQLException {
		Boolean success = false;
		try {
			this.theConnection = this.sqlAccess.getDBConnection();
			String query = "UPDATE " + this.sqlAccess.getTheDBName() + ".conflicts " + 
					"SET " +
					"conflict_min_level = ?, " +
					"conflict_template = ?, " +
					"conflict_name  = ?, " +
					"conflict_description = ?, " +
					"conflict_arc_type = ? " +
					"WHERE conflict_id = ?";		

			PreparedStatement preparedStmt = theConnection.prepareStatement(query);
			preparedStmt.setString (1, String.valueOf(conflictMinLvl));
			preparedStmt.setString (2, String.valueOf(conflictTemplate));
			preparedStmt.setString (3, conflictName);
			preparedStmt.setString (4, conflictDescription);
			preparedStmt.setString (5, arcType);
			preparedStmt.setString (6, String.valueOf(conflict.getConflictId()));
			preparedStmt.execute();
			success = true;
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		finally {
			theConnection.close();
		}
		return success;
	}
	
	/**
	 * Deletes an existing conflict entry in the database Conflicts table
	 * @param conflict
	 * @return True if deleted | False if not deleted
	 * @throws SQLException
	 */
	public boolean deleteConflict(Conflict conflict) throws SQLException {
		Boolean success = false;
		try {
			this.theConnection = this.sqlAccess.getDBConnection();
			String query = "DELETE FROM " + this.sqlAccess.getTheDBName() + ".conflicts " + 
					"WHERE conflict_id = ?";
			PreparedStatement preparedStmt = theConnection.prepareStatement(query);
			preparedStmt.setString (1, String.valueOf(conflict.getConflictId()));
			
			preparedStmt.execute();
		      success = true;
		} catch (Exception e) {
        	System.err.println(e.getMessage());
        }
        finally {
        	theConnection.close();
        }
		return success;
	}

}
