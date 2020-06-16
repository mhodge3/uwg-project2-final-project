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
	
	

}
