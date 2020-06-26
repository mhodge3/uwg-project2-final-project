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
public class InventoryTests {
	
	/**
	 * Tests the GetItemID and SetItemID Methods
	 * 
	 */
	@Test
	public void testGetItemIDShouldBe1234() {
		Inventory testItem = new Inventory();
		testItem.SetItemId(1234);
		assertEquals(1234, testItem.GetItemId());
	}
	
	/**
	 * Tests the GetItemID and SetItemID Methods
	 * 
	 */
	@Test
	public void testGetCharacterIdShouldBe1234() {
		Inventory testItem = new Inventory();
		testItem.SetCharacterId(1234);
		assertEquals(1234, testItem.GetCharacterId());
	}
	
	

}
