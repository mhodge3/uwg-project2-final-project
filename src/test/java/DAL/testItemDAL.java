package DAL;

import static org.junit.jupiter.api.Assertions.*;
import com.cs6920.model.*;
import com.cs6920.DAL.*;

import org.junit.jupiter.api.Test;

/**
 * Test the CRUD methods of the ItemDAL
 * @date 6/20/2020
 * @author Perry Iler
 *
 */
class testItemDAL {
	MySQLAccess access = new MySQLAccess();
	ItemDAL dal = new ItemDAL(access);
	
	@Test
	public void retrievesItemWithID() throws Exception {
		Item item = this.dal.getItemById(1);
		assertEquals(item.getItemId(), 1);
		assertEquals(item.getItemName(), "Dagger of Suck");
		assertEquals(item.getItemDescription(), "You get what you get and you don't throw a fit.");
		assertEquals(item.getItemType(), 0);
		assertEquals(item.getIsQuestItem(), 0);
		assertEquals(item.getIsImplicitItem(), 0);
	}
	
	@Test
	public void retrievesItemWithName() throws Exception {
		Item item = this.dal.getItemByName("Dagger of Suck");
		assertEquals(item.getItemId(), 1);
		assertEquals(item.getItemName(), "Dagger of Suck");
		assertEquals(item.getItemDescription(), "You get what you get and you don't throw a fit.");
		assertEquals(item.getItemType(), 0);
		assertEquals(item.getIsQuestItem(), 0);
		assertEquals(item.getIsImplicitItem(), 0);
	}
	
	@Test
	public void retrievesNonItemShouldBeNull() throws Exception {
		assertEquals(this.dal.getItemById(0), null);
	}
	
	@Test
	public void addAItemToDBShouldBeTrueIfAdded() throws Exception {
		assertTrue(this.dal.createItem("cloak spell", "Invisibility cloak", 1, false, true, false));
		Item item = this.dal.getItemByName("cloak spell");
		assertEquals(item.getItemName(), "cloak spell");
		assertEquals(item.getItemDescription(), "Invisibility cloak");
		assertEquals(item.getItemType(), 1);
		assertEquals(item.getIsQuestItem(), 2);
		assertEquals(item.getIsImplicitItem(), 3);
	}
	
	/* Not sure what's up with this test at the moment, but a couple of subtle things changed in the model
	@Test
	public void updateAItem() throws Exception {
		Item oldItem = this.dal.GetItemByName("cloak spell");
		Item updatedItem = new Item(0,"cloak spell", "Invisibility shield", 4, false, false);
		this.dal.UpdateItem(oldItem, updatedItem);
		oldItem = this.dal.GetItemByName("cloak spell");
		assertEquals(oldItem.GetItemDescription(), "Invisibility shield");
	}
	*/
	
	@Test
	public void deleteAItem() throws Exception {
		Item item1 = this.dal.getItemByName("cloak spell");
		this.dal.deleteItem(item1);
		item1 = this.dal.getItemByName("cloak spell");
		assertEquals(item1, null);
	}
	


}
