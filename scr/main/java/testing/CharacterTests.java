/**
 * 
 */
package testing;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import model.Character;

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
		Character testCharacter = new Character();
		testCharacter.SetNpcId(1234);
		assertEquals(1234, testCharacter.GetNpcId());
	}
	
	/**
	 * Tests the GetNpcDescription and SetNpcDescription Methods
	 * 
	 */
	@Test
	public void testGetNpcDescpritionShouldBeCoolPlayer() {
		Character testCharacter = new Character();
		testCharacter.SetNpcDescription("cool player");
		assertEquals("cool player", testCharacter.GetNpcDescription());
	}
	
	/**
	 * Tests the GetNpcName and SetNpcName Methods
	 * 
	 */
	@Test
	public void testGetNpcNameShouldBeTom() {
		Character testCharacter = new Character();
		testCharacter.SetNpcName("Tom");
		assertEquals("Tom", testCharacter.GetNpcName());
	}
	
	/**
	 * Tests the GetNpcType Method and SetNpcType() Method
	 * 
	 */
	@Test
	public void testGetNpcTypeShouldBe1() {
		Character testCharacter = new Character();
		testCharacter.SetNpcType(1);
		assertEquals(1, testCharacter.GetNpcType());
	}
	
	/**
	 * Tests the GetNpcFaction() Method and SetNpcFaction() Method
	 * 
	 */
	@Test
	public void testGetNpcFactionShouldBe2() {
		Character testCharacter = new Character();
		testCharacter.SetNpcFaction(2);
		assertEquals(2, testCharacter.GetNpcFaction());
	}
	
	/**
	 * Tests the GetNpcPosX() Method and SetNpcPosX() Method
	 * 
	 */
	@Test
	public void testGetNpcPosXPointShouldBe1Point1() {
		Character testCharacter = new Character();
		testCharacter.SetNpcPosX(1.1);
		assertEquals(1.1, testCharacter.GetNpcPosX());
	}
	
	/**
	 * Tests the GetNpcPosY() Method and SetNpcPosY() Method
	 * 
	 */
	@Test
	public void testGetNpcPosYPointShouldBe1Point1() {
		Character testCharacter = new Character();
		testCharacter.SetNpcPosY(1.1);
		assertEquals(1.1, testCharacter.GetNpcPosY());
	}
	
	/**
	 * Tests the GetNpcPosZ() Method and SetNpcPosZ() Method
	 * 
	 */
	@Test
	public void testGetNpcPosZPointShouldBe1Point1() {
		Character testCharacter = new Character();
		testCharacter.SetNpcPosZ(1.1);
		assertEquals(1.1, testCharacter.GetNpcPosZ());
	}
	
	
	

}
