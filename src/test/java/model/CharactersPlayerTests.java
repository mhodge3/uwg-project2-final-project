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
	
	/**
	 * Tests the GetCharacterFaction and SetCharacterFaction Methods
	 * 
	 */
	@Test
	public void testGetCharacterFactionShouldBe1234() {
		CharactersPlayer testItem = new CharactersPlayer();
		testItem.SetCharacterFaction(1234);
		assertEquals(1234, testItem.GetCharacterFaction());
	}
	
	/**
	 * Tests the GetCharacterPosZ and SetCharacterPosZ Methods
	 * 
	 */
	@Test
	public void testGetCharacterPosZShouldBe1Point1() {
		CharactersPlayer testItem = new CharactersPlayer();
		testItem.SetCharacterPosZ(1.1);
		assertEquals(1.1, testItem.GetCharacterPosZ());
	}
	
	/**
	 * Tests the GetCharacterPosY and SetCharacterPosY Methods
	 * 
	 */
	@Test
	public void testGetCharacterPosYShouldBe1Point1() {
		CharactersPlayer testItem = new CharactersPlayer();
		testItem.SetCharacterPosY(1.1);
		assertEquals(1.1, testItem.GetCharacterPosY());
	}
	
	/**
	 * Tests the GetCharacterPosX and SetCharacterPosX Methods
	 * 
	 */
	@Test
	public void testGetCharacterPosXShouldBe1Point1() {
		CharactersPlayer testItem = new CharactersPlayer();
		testItem.SetCharacterPosX(1.1);
		assertEquals(1.1, testItem.GetCharacterPosX());
	}
}
