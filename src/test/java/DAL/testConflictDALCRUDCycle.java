package DAL;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;

import com.cs6920.DAL.ConflictDAL;
import com.cs6920.DAL.MySQLAccess;
import com.cs6920.model.Conflict;


@TestMethodOrder(OrderAnnotation.class) 
/**
 * Test the methods of the ConflictDAL in a CRUD cycle
 * @date 7/1/2020
 * @author Perry Iler
 *
 */
class testConflictDALCRUDCycle {

	MySQLAccess access = new MySQLAccess();
	ConflictDAL dal = new ConflictDAL(access);
	Conflict conflict = new Conflict();

	@Test
	@Order(1)
	public void createACharactersPlayerInDB() throws Exception {
		assertTrue(this.dal.CreateConflict(1, 2, "test1", "test1 desc", "arc test"));
	}
	
	@Test
	@Order(2)
	public void createAConflictDupilicatesInDB() throws Exception {
		assertFalse(this.dal.CreateConflict(1, 2, "test1", "test1 desc", "arc test"));
		
	}
	
	@Test
	@Order(3)
	public void getQuestByNameDB() throws Exception {
		this.conflict = this.dal.GetQuestByName("test1");
		assertNotNull(this.conflict);
		assertEquals(this.conflict.GetConflictMinLvl(), 1);
		assertEquals(this.conflict.GetConflictTemplate(), 2);
		assertEquals(this.conflict.GetConflictName(), "test1");
		assertEquals(this.conflict.GetConflictDescription(), "test1 desc");
		assertEquals(this.conflict.GetConflictArcType(), "arc test");
	}
	
	@Test
	@Order(4)
	public void getQuestByIdDB() throws Exception {
		this.conflict = this.dal.GetQuestByName("test1");
		this.conflict = this.dal.GetQuestByID(this.conflict.GetConflictId());
		assertNotNull(this.conflict);
		assertEquals(this.conflict.GetConflictMinLvl(), 1);
		assertEquals(this.conflict.GetConflictTemplate(), 2);
		assertEquals(this.conflict.GetConflictName(), "test1");
		assertEquals(this.conflict.GetConflictDescription(), "test1 desc");
		assertEquals(this.conflict.GetConflictArcType(), "arc test");
	}
	
	@Test
	@Order(5)
	public void updateQuestInTheDB() throws Exception {
		this.conflict = this.dal.GetQuestByName("test1");
		this.dal.UpdateConflict(conflict, 3, 4, "updated", "updated", "updated");
		this.conflict = this.dal.GetQuestByName("updated");
		assertNotNull(this.conflict);
		assertEquals(this.conflict.GetConflictMinLvl(), 3);
		assertEquals(this.conflict.GetConflictTemplate(), 4);
		assertEquals(this.conflict.GetConflictName(), "updated");
		assertEquals(this.conflict.GetConflictDescription(), "updated");
		assertEquals(this.conflict.GetConflictArcType(), "updated");
	}
	
	@Test
	@Order(6)
	public void deleteANpcCharacterInDB() throws Exception {
		this.conflict = this.dal.GetQuestByName("updated");
		assertTrue(this.dal.DeleteConflict(conflict));
		this.conflict = this.dal.GetQuestByName("updated");
		assertEquals(this.conflict, null);
	}

}
