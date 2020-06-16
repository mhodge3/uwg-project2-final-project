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
	 * Tests the GetPlayerId Method
	 * 
	 */
	@Test
	public void testGetPlayerIDShouldBe1234() {
		Player testPlayerID = new Player();
		testPlayerID.SetPlayerId(1234);
		assertEquals(1234, testPlayerID.GetPlayerId());
	}

}
