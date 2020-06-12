package DAL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import model.Player;

public class LoginDAL {
	private MySQLAccess theDBConnection;
    private Connection theConnection = null;
    private Statement theStatement = null;
    private PreparedStatement thePreparedStatement = null;
    private ResultSet theResultSet = null;
	
	public LoginDAL(MySQLAccess theDBConnection) {
		this.theDBConnection = theDBConnection;
	}
	
    public Player GetPlayer(String playerName, String playerPassword) throws Exception {
    	Player thePlayer = null;
        try {
            // This will load the MySQL driver, each DB has its own driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Setup the connection with the DB
            theConnection = theDBConnection.GetDBConnection();
            // Statements allow to issue SQL queries to the database
            theStatement = theConnection.createStatement();
            String pST = "SELECT * FROM `rpg_story_mapper_db`.`players` "
            		+ "WHERE `rpg_story_mapper_db`.`players`.`player_name` = \"" + playerName + "\""
            				+ "AND `rpg_story_mapper_db`.`players`.`player_password` = \"" + playerPassword + "\";";
            // Result set get the result of the SQL query
            theResultSet = theStatement.executeQuery(pST);
            if (theResultSet.next() != false) {
                thePlayer = new Player();
                thePlayer.SetPlayerName(theResultSet.getString("player_name"));
            }
        } catch (Exception e) {
            thePlayer = null;
        }
        finally {
        	theConnection.close();
        }
        return thePlayer;
    }
}
