package DAL;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;


import com.cs6920.DAL.MySQLAccess;
import com.cs6920.DAL.QuestDAL;
import com.cs6920.model.Quest;


@TestMethodOrder(OrderAnnotation.class) 
/**
 * Test the methods of the QuestDAL in a CRUD cycle
 * @date 6/30/2020
 * @author Perry Iler
 *
 */
class testQuestDALCRUDCycle {

	MySQLAccess access = new MySQLAccess();
	QuestDAL dal = new QuestDAL(access);
	Quest quest = new Quest();

	@Test
	@Order(1)
	public void createAQuestInDB() throws Exception {
		int newId = this.dal.createQuest(10, 12, 2, 2, 1, "test1", "test1 desc",
				"arc", "giver dialog", "receiver dialog", 2, 3);
		assertTrue(newId > 0);
	}
	
	/*@Test
	@Order(2)
	public void createAQuestDupilicatesInDB() throws Exception {
		int newId = this.dal.CreateQuest(10, 12, 2, 2, 1, "test1", "desc",
				"arc", "giver dialog", "receiver dialog", 2, 3);
		assertFalse(newId > 0);
	}*/
	
	@Test
	@Order(3)
	public void getQuestByNameDB() throws Exception {
		this.quest = this.dal.getQuestByName("test1");
		assertNotNull(this.quest);
		assertEquals(this.quest.getQuestReceiverNpcId(), 10);
		assertEquals(this.quest.getQuestGiverNpcId(), 12);
		assertEquals(this.quest.getPreReqQuestId(), 2);
        assertEquals(this.quest.getConflictId(), 2);
		assertEquals(this.quest.getMinCharacterLevel(), 1);
		assertEquals(this.quest.getQuestName(), "test1");
		assertEquals(this.quest.getQuestDescription(), "test1 desc");
		assertEquals(this.quest.getQuestArcType(), "arc");
		assertEquals(this.quest.getQuesGiverDialog(), "giver dialog");
		assertEquals(this.quest.getQuestReceiverDialog(), "receiver dialog");
		assertEquals(this.quest.getidInConflict(), 2);
		assertEquals(this.quest.getidPreReqIdConflict(), 3);
	}
	
	@Test
	@Order(4)
	public void getQuestByIdDB() throws Exception {
		this.quest = this.dal.getQuestByName("test1");
		this.quest = this.dal.getQuestByID(this.quest.getQuestId());
		assertNotNull(this.quest);
		assertEquals(this.quest.getQuestReceiverNpcId(), 10);
		assertEquals(this.quest.getQuestGiverNpcId(), 12);
		assertEquals(this.quest.getPreReqQuestId(), 2);
		assertEquals(this.quest.getConflictId(), 2);
		assertEquals(this.quest.getMinCharacterLevel(), 1);
		assertEquals(this.quest.getQuestName(), "test1");
		assertEquals(this.quest.getQuestDescription(), "test1 desc");
		assertEquals(this.quest.getQuestArcType(), "arc");
		assertEquals(this.quest.getQuesGiverDialog(), "giver dialog");
		assertEquals(this.quest.getQuestReceiverDialog(), "receiver dialog");
		assertEquals(this.quest.getidInConflict(), 2);
		assertEquals(this.quest.getidPreReqIdConflict(), 3);
	}
	
	@Test
	@Order(5)
	public void updateQuestInTheDB() throws Exception {
		this.quest = this.dal.getQuestByName("test1");
		this.dal.updateQuest(this.quest, 10, 40, 0, 2, 3, "updated test1", "updated", "updated", "updated", "updated", 4, 5);
		this.quest = this.dal.getQuestByID(this.quest.getQuestId());
		assertNotNull(this.quest);
		assertEquals(this.quest.getQuestReceiverNpcId(), 10);
		assertEquals(this.quest.getQuestGiverNpcId(), 40);
		assertEquals(this.quest.getPreReqQuestId(), 0);
		assertEquals(this.quest.getConflictId(), 2);
		assertEquals(this.quest.getMinCharacterLevel(), 3);
		assertEquals(this.quest.getQuestName(), "updated test1");
		assertEquals(this.quest.getQuestDescription(), "updated");
		assertEquals(this.quest.getQuestArcType(), "updated");
		assertEquals(this.quest.getQuesGiverDialog(), "updated");
		assertEquals(this.quest.getQuestReceiverDialog(), "updated");
		assertEquals(this.quest.getidInConflict(), 4);
		assertEquals(this.quest.getidPreReqIdConflict(), 5);
	}
	
	@Test
	@Order(6)
	public void deleteAQuestFronDB() throws Exception {
		this.quest = this.dal.getQuestByName("updated test1");
		assertTrue(this.dal.deleteQuest(quest));
		this.quest = this.dal.getQuestByName("updated test1");
		assertEquals(this.quest, null);
	}

}
