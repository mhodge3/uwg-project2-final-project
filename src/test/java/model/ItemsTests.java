/**
 * 
 */
package model;



import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import com.cs6920.model.*;

/**
 * @author Ashley Palmer
 * @date 6/17/2020
 *
 */
public class ItemsTests {
	
	/**
	 * Tests the GetItemID and SetItemID Methods
	 * 
	 */
	@Test
	public void testGetItemIDShouldBe1234() {
		Item testItem = new Item();
		testItem.setItemId(1234);
		assertEquals(1234, testItem.getItemId());
	}
	
	/**
	 * Tests the GetItemName and SetItemName Methods
	 * 
	 */
	@Test
	public void testGetItemNameShouldBeTom() {
		Item testItem = new Item();
		testItem.setItemName("Tom");
		assertEquals("Tom", testItem.getItemName());
	}
	
	/**
	 * Tests the GetItemDescription and SetItemDescription Methods
	 * 
	 */
	@Test
	public void testGetItemNameShouldBeASuperCool() {
		Item testItem = new Item();
		testItem.setItemDescription("A Super Cool");
		assertEquals("A Super Cool", testItem.getItemDescription());
	}
	
	/**
	 * Tests the GetItemType and SetItemType Methods
	 * 
	 */
	@Test
	public void testGetItemTypeShouldBe1234() {
		Item testItem = new Item();
		testItem.setItemType(1234);
		assertEquals(1234, testItem.getItemType());
	}
	
	/**
	 * Tests the GetIsQuestItem and SetIsQuestItem Methods
	 * 
	 */
	@Test
	public void testGetIsQuestItemShouldBeTrue() {
		Item testItem = new Item();
		testItem.setIsQuestItem(true);
		assertEquals(true, testItem.getIsQuestItem());
	}
	
	/**
	 * Tests the GetIsTrophyand SetIsTrophy Methods
	 * 
	 */
	@Test
	public void testGetIsTrophyShouldBeTrue() {
		Item testItem = new Item();
		testItem.setIsQuestItem(true);
		assertEquals(true, testItem.getIsQuestItem());
	}
	
	/**
	 * Tests the GetIsImplicitItem and SetIsImplicitItem Methods
	 * 
	 */
	@Test
	public void testGetIsImplicitItemShouldBe1234() {
		Item testItem = new Item();
		testItem.setIsImplicitItem(false);
		assertEquals(false, testItem.getIsImplicitItem());
	}

}
