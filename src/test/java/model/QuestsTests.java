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
		Quest testItem = new Quest();
		testItem.SetQuestId(1234);
		assertEquals(1234, testItem.GetQuestId());
	}
	
	/**
	 * Tests the GetPreReqQuestId and SetPreReqQuestId Methods
	 * 
	 */
	@Test
	public void testGetPreReqQuestIdShouldBe1234() {
		Quest testItem = new Quest();
		testItem.SetPreReqQuestId(1234);
		assertEquals(1234, testItem.GetPreReqQuestId());
	}
	
	/**
	 * Tests the GetConflictId and SetConflictId Methods
	 * 
	 */
	@Test
	public void testGetConflictIdShouldBe1234() {
		Quest testItem = new Quest();
		testItem.SetConflictId(1234);
		assertEquals(1234, testItem.GetConflictId());
	}
	
	/**
	 * Tests the GetMinCharacterLevel and  SetMinCharacterLevel Methods
	 * 
	 */
	@Test
	public void testGetMinCharacterLevelShouldBe1234() {
		Quest testItem = new Quest();
		testItem.SetMinCharacterLevel(1234);
		assertEquals(1234, testItem.GetMinCharacterLevel());
	}
	
	/**
	 * Tests the GetQuestName and  SetQuestName Methods
	 * 
	 */
	@Test
	public void testGetQuestNameShouldBeTom() {
		Quest testItem = new Quest();
		testItem.SetQuestName("Tom");
		assertEquals("Tom", testItem.GetQuestName());
	}
	
	/**
	 * Tests the GetQuestDescription and  SetQuestDescription Methods
	 * 
	 */
	@Test
	public void testGetQuestDescriptionBeTom() {
		Quest testItem = new Quest();
		testItem.SetQuestDescription("Tom");
		assertEquals("Tom", testItem.GetQuestDescription());
	}
	
	/**
	 * Tests the GetquestGiverNpcId and  SetquestGiverNpcId Methods
	 * 
	 */
	@Test
	public void testGetQuestGiverNpcIdShouldBe1234() {
		Quest testItem = new Quest();
		testItem.SetQuestGiverNpcId(1234);
		assertEquals(1234, testItem.GetQuestGiverNpcId());
	}
	
	
	

}
