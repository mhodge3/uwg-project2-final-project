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

public class NpcCharacterTests {
	
	/**
	 * Tests the GetNpcID and SetNpcID Methods
	 * 
	 */
	@Test
	public void testGetNpcIDShouldBe1234() {
		NpcCharacter testItem = new NpcCharacter();
		testItem.setNpcId(1234);
		assertEquals(1234, testItem.getNpcId());
	}
	
	/**
	 * Tests the GetNpcID and SetNpcID Methods
	 * 
	 */
	@Test
	public void testGetNpcDescriptionShouldBeTom() {
		NpcCharacter testItem = new NpcCharacter();
		testItem.setNpcDescprition("Tom");
		assertEquals("Tom", testItem.getNpcDescprition());
	}
	
	/**
	 * Tests the GetNpcName and SetNpcName Methods
	 * 
	 */
	@Test
	public void testGetNpcNameShouldBeTom() {
		NpcCharacter testItem = new NpcCharacter();
		testItem.setNpcName("Tom");
		assertEquals("Tom", testItem.getNpcName());
	}
	
	/**
	 * Tests the GetNpcType and SetNpcType Methods
	 * 
	 */
	@Test
	public void testGetNpcTypeShouldBe1234() {
		NpcCharacter testItem = new NpcCharacter();
		testItem.setNpcType(1234);
		assertEquals(1234, testItem.getNpcType());
	}
	
	/**
	 * Tests the GetNpcFaction and SetNpcFaction Methods
	 * 
	 */
	@Test
	public void testGetNpcFactionShouldBe1234() {
		NpcCharacter testItem = new NpcCharacter();
		testItem.setNpcFaction(1234);
		assertEquals(1234, testItem.getNpcFaction());
	}
	
	/**
	 * Tests the GetNpcPosZ and SetCharacterNpcPosZ Methods
	 * 
	 */
	@Test
	public void testGetNpcPosZShouldBe1Point1() {
		NpcCharacter testItem = new NpcCharacter();
		testItem.setNpcPosZ(1.1);
		assertEquals(1.1, testItem.getNpcPosZ());
	}
	
	/**
	 * Tests the GetNpcPosY and SetCharacterNpcPosY Methods
	 * 
	 */
	@Test
	public void testGetNpcPosYShouldBe1Point1() {
		NpcCharacter testItem = new NpcCharacter();
		testItem.setNpcPosY(1.1);
		assertEquals(1.1, testItem.getNpcPosY());
	}
	
	/**
	 * Tests the GetNpcPosX and SetCharacterNpcPosX Methods
	 * 
	 */
	@Test
	public void testGetNpcPosXShouldBe1Point1() {
		NpcCharacter testItem = new NpcCharacter();
		testItem.setNpcPosX(1.1);
		assertEquals(1.1, testItem.getNpcPosX());
	}
		

}
