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
		testItem.setQuestId(1234);
		assertEquals(1234, testItem.getQuestId());
	}
	
	/**
	 * Tests the GetPreReqQuestId and SetPreReqQuestId Methods
	 * 
	 */
	@Test
	public void testGetPreReqQuestIdShouldBe1234() {
		Quest testItem = new Quest();
		testItem.setPreReqQuestId(1234);
		assertEquals(1234, testItem.getPreReqQuestId());
	}
	
	/**
	 * Tests the GetConflictId and SetConflictId Methods
	 * 
	 */
	@Test
	public void testGetConflictIdShouldBe1234() {
		Quest testItem = new Quest();
		testItem.setConflictId(1234);
		assertEquals(1234, testItem.getConflictId());
	}
	
	/**
	 * Tests the GetMinCharacterLevel and  SetMinCharacterLevel Methods
	 * 
	 */
	@Test
	public void testGetMinCharacterLevelShouldBe1234() {
		Quest testItem = new Quest();
		testItem.setMinCharacterLevel(1234);
		assertEquals(1234, testItem.getMinCharacterLevel());
	}
	
	/**
	 * Tests the GetQuestName and  SetQuestName Methods
	 * 
	 */
	@Test
	public void testGetQuestNameShouldBeTom() {
		Quest testItem = new Quest();
		testItem.setQuestName("Tom");
		assertEquals("Tom", testItem.getQuestName());
	}
	
	/**
	 * Tests the GetQuestDescription and  SetQuestDescription Methods
	 * 
	 */
	@Test
	public void testGetQuestDescriptionBeTom() {
		Quest testItem = new Quest();
		testItem.setQuestDescription("Tom");
		assertEquals("Tom", testItem.getQuestDescription());
	}
	
	/**
	 * Tests the GetquestGiverNpcId and  SetquestGiverNpcId Methods
	 * 
	 */
	@Test
	public void testGetQuestGiverNpcIdShouldBe1234() {
		Quest testItem = new Quest();
		testItem.setQuestGiverNpcId(1234);
		assertEquals(1234, testItem.getQuestGiverNpcId());
	}
	
	/**
	 * Tests the GetQuestReceiverNpcId and  SetQuestReceiverNpcId Methods
	 * 
	 */
	@Test
	public void testQuestReceiverNpcIdShouldBe1234() {
		Quest testItem = new Quest();
		testItem.setQuestReceiverNpcId(1234);
		assertEquals(1234, testItem.getQuestReceiverNpcId());
	}
	
	/**
	 * Tests the GetQuestArcType and  SetQuestArcType Methods
	 * 
	 */
	@Test
	public void testQuestArcTypeShouldBeTom() {
		Quest testItem = new Quest();
		testItem.setQuestArcType("Tom");
		assertEquals("Tom", testItem.getQuestArcType());
	}
	
	
	

}
