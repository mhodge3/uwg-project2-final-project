/**
 * 
 */
package model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.cs6920.model.*;

/**
 * @author Ashley Palmer
 * @date 6/26/2020
 *
 */

public class CharactersPlayerTests {
	
	/**
	 * Tests the GetCharacterD and SetCharacterID Methods
	 * 
	 */
	@Test
	public void testGetCharacteIDShouldBe1234() {
		CharactersPlayer testItem = new CharactersPlayer();
		testItem.SetCharacterId(1234);
		assertEquals(1234, testItem.GetCharacterId());
	}

}
