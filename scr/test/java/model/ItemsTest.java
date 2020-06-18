/**
 * 
 */
package model;



import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import model.Items;

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
		Items testItem = new Items();
		testItem.SetItemId(1234);
		assertEquals(1234, testItem.GetItemId());
	}
	
	/**
	 * Tests the GetItemName and SetItemName Methods
	 * 
	 */
	@Test
	public void testGetItemNameShouldBeTom() {
		Items testItem = new Items();
		testItem.SetItemName("Tom");
		assertEquals("Tom", testItem.GetItemName());
	}
	
	/**
	 * Tests the GetItemDescription and SetItemDescription Methods
	 * 
	 */
	@Test
	public void testGetItemNameShouldBeASuperCool() {
		Items testItem = new Items();
		testItem.SetItemDescription("A Super Cool");
		assertEquals("A Super Cool", testItem.GetItemDescription());
	}
	
	/**
	 * Tests the GetItemType and SetItemType Methods
	 * 
	 */
	@Test
	public void testGetItemTypeShouldBe1234() {
		Items testItem = new Items();
		testItem.SetItemType(1234);
		assertEquals(1234, testItem.GetItemType());
	}
	
	/**
	 * Tests the GetIsQuestItem and SetIsQuestItem Methods
	 * 
	 */
	@Test
	public void testGetIsQuestItemShouldBe1234() {
		Items testItem = new Items();
		testItem.SetIsQuestItem(1234);
		assertEquals(1234, testItem.GetIsQuestItem());
	}
	
	/**
	 * Tests the GetIsImplicitItem and SetIsImplicitItem Methods
	 * 
	 */
	@Test
	public void testGetIsImplicitItemShouldBe1234() {
		Items testItem = new Items();
		testItem.SetIsImplicitItem(1234);
		assertEquals(1234, testItem.GetIsImplicitItem());
	}

}
