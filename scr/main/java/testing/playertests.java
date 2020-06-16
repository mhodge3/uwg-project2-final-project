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
	
	
	
	

}
