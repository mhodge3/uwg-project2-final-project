package DAL;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;
import java.sql.Connection;
import org.junit.jupiter.api.Test;

class testMYQLAccess {

	public MySQLAccess access = new MySQLAccess();
	
	@Test
	public void testGetConnectionShouldNotnull() throws SQLException {
		Connection conn = this.access.getConnection();
		assertTrue(conn != null);
	}

}
