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
public class CharacterPlayerQuestLogsTest {
	
	/**
	 * Tests the GetCharacterID and SetCharacterID Methods
	 * 
	 */
	@Test
	public void testGetCharacterIDShouldBe1234() {
		CharacterPlayerQuestLog testItem = new CharacterPlayerQuestLog();
		testItem.SetCharacterId(1234);
		assertEquals(1234, testItem.GetCharacterId());
	}
	
	/**
	 * Tests the GetQuestID and SetQuestID Methods
	 * 
	 */
	@Test
	public void testGetQuestIdIDShouldBe1234() {
		CharacterPlayerQuestLog testItem = new CharacterPlayerQuestLog();
		testItem.SetQuestId(1234);
		assertEquals(1234, testItem.GetQuestId());
	}
	
	/**
	 * Tests the GetCharacterID and SetCharacterID Methods
	 * 
	 */
	@Test
	public void testGetQuestStatusShouldBe1234() {
		CharacterPlayerQuestLog testItem = new CharacterPlayerQuestLog();
		testItem.SetQuestStatus(1234);
		assertEquals(1234, testItem.GetQuestStatus());
	}
	
	

}
