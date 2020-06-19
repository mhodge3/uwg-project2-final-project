/**
 * 
 */
package model;



import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import model.Item;

/**
 * @author Ashley Palmer
 * @date 6/17/2020
 *
 */
public class ItemsTest {
	
	/**
	 * Tests the GetItemID and SetItemID Methods
	 * 
	 */
	@Test
	public void testGetItemIDShouldBe1234() {
		Item testItem = new Item();
		testItem.SetItemId(1234);
		assertEquals(1234, testItem.GetItemId());
	}
	
	/**
	 * Tests the GetItemName and SetItemName Methods
	 * 
	 */
	@Test
	public void testGetItemNameShouldBeTom() {
		Item testItem = new Item();
		testItem.SetItemName("Tom");
		assertEquals("Tom", testItem.GetItemName());
	}
	
	/**
	 * Tests the GetItemDescription and SetItemDescription Methods
	 * 
	 */
	@Test
	public void testGetItemNameShouldBeASuperCool() {
		Item testItem = new Item();
		testItem.SetItemDescription("A Super Cool");
		assertEquals("A Super Cool", testItem.GetItemDescription());
	}
	
	/**
	 * Tests the GetItemType and SetItemType Methods
	 * 
	 */
	@Test
	public void testGetItemTypeShouldBe1234() {
		Item testItem = new Item();
		testItem.SetItemType(1234);
		assertEquals(1234, testItem.GetItemType());
	}
	
	/**
	 * Tests the GetIsQuestItem and SetIsQuestItem Methods
	 * 
	 */
	@Test
	public void testGetIsQuestItemShouldBe1234() {
		Item testItem = new Item();
		testItem.SetIsQuestItem(1234);
		assertEquals(1234, testItem.GetIsQuestItem());
	}
	
	/**
	 * Tests the GetIsImplicitItem and SetIsImplicitItem Methods
	 * 
	 */
	@Test
	public void testGetIsImplicitItemShouldBe1234() {
		Item testItem = new Item();
		testItem.SetIsImplicitItem(1234);
		assertEquals(1234, testItem.GetIsImplicitItem());
	}

}
