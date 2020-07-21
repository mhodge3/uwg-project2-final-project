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

public class GameStoryTests {
	
	/**
	 * Tests the GetGameStoryName and  SetGameStoryName Methods
	 * 
	 */
	@Test
	public void testGetGameStoryNameBeTom() {
		GameStory testItem = new GameStory();
		testItem.SetGameStoryName("Tom");
		assertEquals("Tom", testItem.GetGameStoryName());
	}
	
	/**
	 * Tests the GetGameStorySummary and  SetGameStorySummary Methods
	 * 
	 */
	@Test
	public void testGetGameStorySummaryBeTom() {
		GameStory testItem = new GameStory();
		testItem.SetGameStorySummary("Tom");
		assertEquals("Tom", testItem.GetGameStorySummary());
	}
	
	/**
	 * Tests the GetPlayerLevelCap and  SetPlayerLevelCap Methods
	 * 
	 */
	@Test
	public void testGetPlayerLevelCapShouldBe1234() {
		GameStory testItem = new GameStory();
		testItem.SetPlayerLevelCap(1234);
		assertEquals(1234, testItem.GetPlayerLevelCap());
	}

	
}
