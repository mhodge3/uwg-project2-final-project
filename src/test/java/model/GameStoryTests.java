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
		testItem.setGameStoryName("Tom");
		assertEquals("Tom", testItem.getGameStoryName());
	}
	
	/**
	 * Tests the GetGameStorySummary and  SetGameStorySummary Methods
	 * 
	 */
	@Test
	public void testGetGameStorySummaryBeTom() {
		GameStory testItem = new GameStory();
		testItem.setGameStorySummary("Tom");
		assertEquals("Tom", testItem.getGameStorySummary());
	}
	
	/**
	 * Tests the GetPlayerLevelCap and  SetPlayerLevelCap Methods
	 * 
	 */
	@Test
	public void testGetPlayerLevelCapShouldBe1234() {
		GameStory testItem = new GameStory();
		testItem.setPlayerLevelCap(1234);
		assertEquals(1234, testItem.getPlayerLevelCap());
	}
	
	/**
	 * Tests the npcCharacterLevelCap and npcCharacterLevelCap Methods
	 * 
	 */
	@Test
	public void testGetNpcCharacterLevelCapCapShouldBe1234() {
		GameStory testItem = new GameStory();
		testItem.setNpcCharacterLevelCap(1234);
		assertEquals(1234, testItem.getNpcCharacterLevelCap());
	}

	
}
