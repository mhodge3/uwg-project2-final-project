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
		testItem.SetNpcId(1234);
		assertEquals(1234, testItem.GetNpcId());
	}
	
	/**
	 * Tests the GetNpcID and SetNpcID Methods
	 * 
	 */
	@Test
	public void testGetNpcDescriptionShouldBeTom() {
		NpcCharacter testItem = new NpcCharacter();
		testItem.SetNpcDescprition("Tom");
		assertEquals("Tom", testItem.GetNpcDescprition());
	}
	
	/**
	 * Tests the GetNpcName and SetNpcName Methods
	 * 
	 */
	@Test
	public void testGetNpcNameShouldBeTom() {
		NpcCharacter testItem = new NpcCharacter();
		testItem.SetNpcName("Tom");
		assertEquals("Tom", testItem.GetNpcName());
	}
	
	/**
	 * Tests the GetNpcType and SetNpcType Methods
	 * 
	 */
	@Test
	public void testGetNpcTypeShouldBe1234() {
		NpcCharacter testItem = new NpcCharacter();
		testItem.SetNpcType(1234);
		assertEquals(1234, testItem.GetNpcType());
	}
	
	/**
	 * Tests the GetNpcFaction and SetNpcFaction Methods
	 * 
	 */
	@Test
	public void testGetNpcFactionShouldBe1234() {
		NpcCharacter testItem = new NpcCharacter();
		testItem.SetNpcFaction(1234);
		assertEquals(1234, testItem.GetNpcFaction());
	}
	
	/**
	 * Tests the GetNpcPosZ and SetCharacterNpcPosZ Methods
	 * 
	 */
	@Test
	public void testGetNpcPosZShouldBe1Point1() {
		NpcCharacter testItem = new NpcCharacter();
		testItem.SetNpcPosZ(1.1);
		assertEquals(1.1, testItem.GetNpcPosZ());
	}
	
	/**
	 * Tests the GetNpcPosY and SetCharacterNpcPosY Methods
	 * 
	 */
	@Test
	public void testGetNpcPosYShouldBe1Point1() {
		NpcCharacter testItem = new NpcCharacter();
		testItem.SetNpcPosY(1.1);
		assertEquals(1.1, testItem.GetNpcPosY());
	}
	
	/**
	 * Tests the GetNpcPosX and SetCharacterNpcPosX Methods
	 * 
	 */
	@Test
	public void testGetNpcPosXShouldBe1Point1() {
		NpcCharacter testItem = new NpcCharacter();
		testItem.SetNpcPosX(1.1);
		assertEquals(1.1, testItem.GetNpcPosX());
	}
		

}
