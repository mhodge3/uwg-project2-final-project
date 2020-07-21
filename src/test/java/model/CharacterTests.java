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
 *
 */
public class CharacterTests {
	
	/**
	 * Tests the GetNpcId and SetNpcId Methods
	 * 
	 */
	@Test
	public void testGetNpcIDShouldBe1234() {
		NpcCharacter testCharacter = new NpcCharacter();
		testCharacter.setNpcId(1234);
		assertEquals(1234, testCharacter.getNpcId());
	}
	
	/**
	 * Tests the GetNpcDescription and SetNpcDescription Methods
	 * 
	 */
	@Test
	public void testGetNpcDescpritionShouldBeCoolPlayer() {
		NpcCharacter testCharacter = new NpcCharacter();
		testCharacter.setNpcDescprition("cool player");
		assertEquals("cool player", testCharacter.getNpcDescprition());
	}
	
	/**
	 * Tests the GetNpcName and SetNpcName Methods
	 * 
	 */
	@Test
	public void testGetNpcNameShouldBeTom() {
		NpcCharacter testCharacter = new NpcCharacter();
		testCharacter.setNpcName("Tom");
		assertEquals("Tom", testCharacter.getNpcName());
	}
	
	/**
	 * Tests the GetNpcType Method and SetNpcType() Method
	 * 
	 */
	@Test
	public void testGetNpcTypeShouldBe1() {
		NpcCharacter testCharacter = new NpcCharacter();
		testCharacter.setNpcType(1);
		assertEquals(1, testCharacter.getNpcType());
	}
	
	/**
	 * Tests the GetNpcFaction() Method and SetNpcFaction() Method
	 * 
	 */
	@Test
	public void testGetNpcFactionShouldBe2() {
		NpcCharacter testCharacter = new NpcCharacter();
		testCharacter.setNpcFaction(2);
		assertEquals(2, testCharacter.getNpcFaction());
	}
	
	/**
	 * Tests the GetNpcPosX() Method and SetNpcPosX() Method
	 * 
	 */
	@Test
	public void testGetNpcPosXPointShouldBe1Point1() {
		NpcCharacter testCharacter = new NpcCharacter();
		testCharacter.setNpcPosX(1.1);
		assertEquals(1.1, testCharacter.getNpcPosX());
	}
	
	/**
	 * Tests the GetNpcPosY() Method and SetNpcPosY() Method
	 * 
	 */
	@Test
	public void testGetNpcPosYPointShouldBe1Point1() {
		NpcCharacter testCharacter = new NpcCharacter();
		testCharacter.setNpcPosY(1.1);
		assertEquals(1.1, testCharacter.getNpcPosY());
	}
	
	/**
	 * Tests the GetNpcPosZ() Method and SetNpcPosZ() Method
	 * 
	 */
	@Test
	public void testGetNpcPosZPointShouldBe1Point1() {
		NpcCharacter testCharacter = new NpcCharacter();
		testCharacter.setNpcPosZ(1.1);
		assertEquals(1.1, testCharacter.getNpcPosZ());
	}
	
	
	

}
