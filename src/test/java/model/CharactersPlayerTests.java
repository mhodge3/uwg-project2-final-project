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
	 * Tests the GetCharacterID and SetCharacterID Methods
	 * 
	 */
	@Test
	public void testGetCharacterIDShouldBe1234() {
		CharactersPlayer testItem = new CharactersPlayer();
		testItem.SetCharacterId(1234);
		assertEquals(1234, testItem.GetCharacterId());
	}

	/**
	 * Tests the GetCharacterPlayerId and SetCharacterPlayerId Methods
	 * 
	 */
	@Test
	public void testGetCharacterPlayerIdShouldBe1234() {
		CharactersPlayer testItem = new CharactersPlayer();
		testItem.SetCharacterPlayerId(1234);
		assertEquals(1234, testItem.GetCharacterPlayerId());
	}
	

	/**
	 * Tests the GetCharacterName and SetCharacterName Methods
	 * 
	 */
	@Test
	public void testGetCharacterPlayerIdShouldBeTom() {
		CharactersPlayer testItem = new CharactersPlayer();
		testItem.SetCharacterName("Tom");
		assertEquals("Tom", testItem.GetCharacterName());
	}
}
