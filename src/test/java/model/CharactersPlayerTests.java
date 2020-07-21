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
		testItem.setCharacterId(1234);
		assertEquals(1234, testItem.getCharacterId());
	}

	/**
	 * Tests the GetCharacterPlayerId and SetCharacterPlayerId Methods
	 * 
	 */
	@Test
	public void testGetCharacterPlayerIdShouldBe1234() {
		CharactersPlayer testItem = new CharactersPlayer();
		testItem.setCharacterPlayerId(1234);
		assertEquals(1234, testItem.getCharacterPlayerId());
	}
	

	/**
	 * Tests the GetCharacterName and SetCharacterName Methods
	 * 
	 */
	@Test
	public void testGetCharacterPlayerIdShouldBeTom() {
		CharactersPlayer testItem = new CharactersPlayer();
		testItem.setCharacterName("Tom");
		assertEquals("Tom", testItem.getCharacterName());
	}
	
	/**
	 * Tests the GetCharacterFaction and SetCharacterFaction Methods
	 * 
	 */
	@Test
	public void testGetCharacterFactionShouldBe1234() {
		CharactersPlayer testItem = new CharactersPlayer();
		testItem.setCharacterFaction(1234);
		assertEquals(1234, testItem.getCharacterFaction());
	}
	
	/**
	 * Tests the GetCharacterPosZ and SetCharacterPosZ Methods
	 * 
	 */
	@Test
	public void testGetCharacterPosZShouldBe1Point1() {
		CharactersPlayer testItem = new CharactersPlayer();
		testItem.setCharacterPosZ(1.1);
		assertEquals(1.1, testItem.getCharacterPosZ());
	}
	
	/**
	 * Tests the GetCharacterPosY and SetCharacterPosY Methods
	 * 
	 */
	@Test
	public void testGetCharacterPosYShouldBe1Point1() {
		CharactersPlayer testItem = new CharactersPlayer();
		testItem.setCharacterPosY(1.1);
		assertEquals(1.1, testItem.getCharacterPosY());
	}
	
	/**
	 * Tests the GetCharacterPosX and SetCharacterPosX Methods
	 * 
	 */
	@Test
	public void testGetCharacterPosXShouldBe1Point1() {
		CharactersPlayer testItem = new CharactersPlayer();
		testItem.setCharacterPosX(1.1);
		assertEquals(1.1, testItem.getCharacterPosX());
	}
}
