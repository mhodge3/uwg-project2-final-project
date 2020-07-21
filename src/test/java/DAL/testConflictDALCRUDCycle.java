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
		assertTrue(this.dal.createConflict(1, 2, "test1", "test1 desc", "arc test"));
	}
	
	@Test
	@Order(2)
	public void createAConflictDupilicatesInDB() throws Exception {
		assertFalse(this.dal.createConflict(1, 2, "test1", "test1 desc", "arc test"));
		
	}
	
	@Test
	@Order(3)
	public void getQuestByNameDB() throws Exception {
		this.conflict = this.dal.getQuestByName("test1");
		assertNotNull(this.conflict);
		assertEquals(this.conflict.getConflictMinLvl(), 1);
		assertEquals(this.conflict.getConflictTemplate(), 2);
		assertEquals(this.conflict.getConflictName(), "test1");
		assertEquals(this.conflict.getConflictDescription(), "test1 desc");
		assertEquals(this.conflict.getConflictArcType(), "arc test");
	}
	
	@Test
	@Order(4)
	public void getQuestByIdDB() throws Exception {
		this.conflict = this.dal.getQuestByName("test1");
		this.conflict = this.dal.getQuestByID(this.conflict.getConflictId());
		assertNotNull(this.conflict);
		assertEquals(this.conflict.getConflictMinLvl(), 1);
		assertEquals(this.conflict.getConflictTemplate(), 2);
		assertEquals(this.conflict.getConflictName(), "test1");
		assertEquals(this.conflict.getConflictDescription(), "test1 desc");
		assertEquals(this.conflict.getConflictArcType(), "arc test");
	}
	
	@Test
	@Order(5)
	public void updateQuestInTheDB() throws Exception {
		this.conflict = this.dal.getQuestByName("test1");
		this.dal.updateConflict(conflict, 3, 4, "updated", "updated", "updated");
		this.conflict = this.dal.getQuestByName("updated");
		assertNotNull(this.conflict);
		assertEquals(this.conflict.getConflictMinLvl(), 3);
		assertEquals(this.conflict.getConflictTemplate(), 4);
		assertEquals(this.conflict.getConflictName(), "updated");
		assertEquals(this.conflict.getConflictDescription(), "updated");
		assertEquals(this.conflict.getConflictArcType(), "updated");
	}
	
	@Test
	@Order(6)
	public void deleteANpcCharacterInDB() throws Exception {
		this.conflict = this.dal.getQuestByName("updated");
		assertTrue(this.dal.deleteConflict(conflict));
		this.conflict = this.dal.getQuestByName("updated");
		assertEquals(this.conflict, null);
	}

}
