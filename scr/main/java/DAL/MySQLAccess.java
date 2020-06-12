package DAL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

/**
 * Connection class for a MySQL database. This is being built from information located at 
 * https://www.vogella.com/tutorials/MySQLJava/article.html
 * 
 * @author Hodge
 * @version 6.10.2020
 */

public class MySQLAccess {
    private Connection theConnection = null;
    private Statement theStatement = null;
    private PreparedStatement thePreparedStatement = null;
    private ResultSet theResultSet = null;
    private String connectionString;
    
    public MySQLAccess() {
    	BuildConnectionString("localhost", "root", "test1234");
    }
    
    /**
     * Simple test of whether or not the MySQL server can be reached with the supplied credentials
     * @return	bool, whether or not the server accessed
     * @throws Exception
     */
    public Boolean TestDBConnection() throws Exception {
    	Boolean connectionSuccess = false;
        try {
            // This will load the MySQL driver, each DB has its own driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Setup the connection with the DB
            theConnection = DriverManager.getConnection(connectionString);
        	thePreparedStatement = null;
        	theResultSet = null;
        	connectionSuccess = true;
        } catch (Exception e) {
        } finally {
            close();
        }
        return connectionSuccess;
    }

    /**
     * Simple test to see if we're reading information from the DB. Be sure the connection string is correct for your environment.
     * @throws Exception
     */
    public void readDataBase() throws Exception {
        try {
            // This will load the MySQL driver, each DB has its own driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Setup the connection with the DB
            theConnection = DriverManager.getConnection(connectionString);

            // Statements allow to issue SQL queries to the database
            theStatement = theConnection.createStatement();
            // Result set get the result of the SQL query
            theResultSet = theStatement.executeQuery("select * from rpg_story_mapper_db.characters_npc");
            writeResultSet(theResultSet);

        } catch (Exception e) {
            throw e;
        } finally {
            close();
        }

    }
    
    /**
     * Build the connection string for the DB based on user input for credentails
     * @param hostName	location of the host. Ex, localhost
     * @param userName	username to access the DB. Ex, root
     * @param password	password for this DB user. Ex, test1234
     */
    public void BuildConnectionString(String hostName, String userName, String password) {
    	connectionString = "jdbc:mysql://" + hostName + "/?user=" + userName + "&password=" + password;
    }

    private void writeResultSet(ResultSet resultSet) throws SQLException {
        while (resultSet.next()) {
            String characterName = resultSet.getString("character_npc_name");
            System.out.println("Character Name: " + characterName);
        }
    }

    // You need to close the resultSet
    private void close() {
        try {
            if (theResultSet != null) {
                theResultSet.close();
            }

            if (theStatement != null) {
                theStatement.close();
            }

            if (theConnection != null) {
                theConnection.close();
            }
        } catch (Exception e) {

        }
    }

}
