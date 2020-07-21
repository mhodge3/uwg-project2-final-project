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
public class CharacterPlayerQuestLogsTests {
	
	/**
	 * Tests the GetCharacterID and SetCharacterID Methods
	 * 
	 */
	@Test
	public void testGetCharacterIDShouldBe1234() {
		CharacterPlayerQuestLog testItem = new CharacterPlayerQuestLog();
		testItem.setCharacterId(1234);
		assertEquals(1234, testItem.getCharacterId());
	}
	
	/**
	 * Tests the GetQuestID and SetQuestID Methods
	 * 
	 */
	@Test
	public void testGetQuestIdIDShouldBe1234() {
		CharacterPlayerQuestLog testItem = new CharacterPlayerQuestLog();
		testItem.setQuestId(1234);
		assertEquals(1234, testItem.getQuestId());
	}
	
	/**
	 * Tests the GetCharacterID and SetCharacterID Methods
	 * 
	 */
	@Test
	public void testGetQuestStatusShouldBe1234() {
		CharacterPlayerQuestLog testItem = new CharacterPlayerQuestLog();
		testItem.setQuestStatus(1234);
		assertEquals(1234, testItem.getQuestStatus());
	}
	
	

}
