/**
 * 
 */
package model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import com.cs6920.model.*;

/**
 * @author Ashley Palmer
 * @date 6/15/2020
 */
public class PlayerTests {
	
	/**
	 * Tests the GetPlayerIdand SetPlayerID Methods
	 * 
	 */
	@Test
	public void testGetSetPlayerIDShouldBe1234() {
		Player testPlayerID = new Player();
		testPlayerID.setPlayerId(1234);
		assertEquals(1234, testPlayerID.getPlayerId());
	}
	
	/**
	 * Tests the IsPlayerAdmin Method and SetPlayerIsAdminMethod
	 * 
	 */
	@Test
	public void testIsPlayerAdminShouldBeFalse() {
		Player testPlayerID = new Player();
		testPlayerID.setPlayerIsAdmin(false);
		assertEquals(false, testPlayerID.getPlayerIsAdmin());
	}
	
	/**
	 * Tests the IsPlayerAdmin Method and SetPlayerIsAdminMethod
	 * 
	 */
	@Test
	public void testIsPlayerAdminShouldBeTrue() {
		Player testPlayerID = new Player();
		testPlayerID.setPlayerIsAdmin(true);
		assertEquals(true, testPlayerID.getPlayerIsAdmin());
	}
	
	/**
	 * Tests the GetPlayerName Method and SetPlayerIsName Method
	 * 
	 */
	@Test
	public void testIsPlayerAdminShouldBeTom() {
		Player testPlayerID = new Player();
		testPlayerID.setPlayerName("Tom");
		assertEquals("Tom", testPlayerID.getPlayerName());
	}
	
	/**
	 * Tests the GetPlayerEmail Method and SetPlayerEmail Method
	 * 
	 */
	@Test
	public void testGetPlayerEmailShouldBeTomAtYahooDotCom() {
		Player testPlayerID = new Player();
		testPlayerID.setPlayerEmail("tom@yahoo.com");
		assertEquals("tom@yahoo.com", testPlayerID.getPlayerEmail());
	}
	
	/**
	 * Tests the GetPlayerCountryCode Method and SetPlayerCountryCode Method
	 * 
	 */
	@Test
	public void testGetPlayerCountryCodeShouldBeABCD() {
		Player testPlayerID = new Player();
		testPlayerID.setPlayerCountryCode("ABCD");
		assertEquals("ABCD", testPlayerID.getPlayerCountryCode());
	}
	
	/**
	 * Tests the GetPlayerPassword Method and SetPlayerPassword Method
	 * 
	 */
	@Test
	public void testGetPlayerPasswordShouldBetestpassword() {
		Player testPlayerID = new Player();
		testPlayerID.setPlayerPassword("testpassword");
		assertEquals("testpassword", testPlayerID.getPlayerPassword());
	}
	
	

}
