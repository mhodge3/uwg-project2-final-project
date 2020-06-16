/**
 * 
 */
package testing;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import model.Player;

/**
 * @author Ashley Palmer
 * @date 6/15/2020
 */
public class playertests {
	
	/**
	 * Tests the GetPlayerIdand SetPlayerID Methods
	 * 
	 */
	@Test
	public void testGetSetPlayerIDShouldBe1234() {
		Player testPlayerID = new Player();
		testPlayerID.SetPlayerId(1234);
		assertEquals(1234, testPlayerID.GetPlayerId());
	}
	
	/**
	 * Tests the IsPlayerAdmin Method and SetPlayerIsAdminMethod
	 * 
	 */
	@Test
	public void testIsPlayerAdminShouldBeFalse() {
		Player testPlayerID = new Player();
		testPlayerID.SetPlayerIsAdmin(false);
		assertEquals(false, testPlayerID.GetPlayerIsAdmin());
	}
	
	/**
	 * Tests the IsPlayerAdmin Method and SetPlayerIsAdminMethod
	 * 
	 */
	@Test
	public void testIsPlayerAdminShouldBeTrue() {
		Player testPlayerID = new Player();
		testPlayerID.SetPlayerIsAdmin(true);
		assertEquals(true, testPlayerID.GetPlayerIsAdmin());
	}
	
	/**
	 * Tests the GetPlayerName Method and SetPlayerIsName Method
	 * 
	 */
	@Test
	public void testIsPlayerAdminShouldBeTom() {
		Player testPlayerID = new Player();
		testPlayerID.SetPlayerName("Tom");
		assertEquals("Tom", testPlayerID.GetPlayerName());
	}
	
	/**
	 * Tests the GetPlayerName Method and SetPlayerIsName Method
	 * 
	 */
	@Test
	public void testGetPlayerCountryCodeShouldBeABCD() {
		Player testPlayerID = new Player();
		testPlayerID.SetPlayerCountryCode("ABCD");
		assertEquals("ABCD", testPlayerID.GetPlayerCountryCode());
	}
	
	

}
