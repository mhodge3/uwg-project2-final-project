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
public class QuestItemsTest {
	
	/**
	 * Tests the GetItemID and SetItemID Methods
	 * 
	 */
	@Test
	public void testGetItemIDShouldBe1234() {
		QuestItems testItem = new QuestItems();
		testItem.SetItemId(1234);
		assertEquals(1234, testItem.GetItemId());
	}

}
