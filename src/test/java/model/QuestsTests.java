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
public class QuestsTests {
	
	/**
	 * Tests the GetQuestID and SetQuestID Methods
	 * 
	 */
	@Test
	public void testGetQuestIDShouldBe1234() {
		Quests testItem = new Quests();
		testItem.SetQuestId(1234);
		assertEquals(1234, testItem.GetQuestId());
	}
	
	/**
	 * Tests the GetPreReqQuestId and SetPreReqQuestId Methods
	 * 
	 */
	@Test
	public void testGetPreReqQuestIdShouldBe1234() {
		Quests testItem = new Quests();
		testItem.SetPreReqQuestId(1234);
		assertEquals(1234, testItem.GetPreReqQuestId());
	}
	
	/**
	 * Tests the GetConflictId and SetConflictId Methods
	 * 
	 */
	@Test
	public void testGetConflictIdShouldBe1234() {
		Quests testItem = new Quests();
		testItem.SetConflictId(1234);
		assertEquals(1234, testItem.GetConflictId());
	}
	
	/**
	 * Tests the GetMinCharacterLevel and  SetMinCharacterLevel Methods
	 * 
	 */
	@Test
	public void testGetMinCharacterLevelShouldBe1234() {
		Quests testItem = new Quests();
		testItem.SetMinCharacterLevel(1234);
		assertEquals(1234, testItem.GetMinCharacterLevel());
	}
	
	
	

}
