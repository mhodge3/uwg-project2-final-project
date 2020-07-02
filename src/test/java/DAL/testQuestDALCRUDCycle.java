package DAL;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;


import com.cs6920.DAL.MySQLAccess;
import com.cs6920.DAL.QuestsDAL;
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
	QuestsDAL dal = new QuestsDAL(access);
	Quest quest = new Quest();

	@Test
	@Order(1)
	public void createACharactersPlayerInDB() throws Exception {
		assertTrue(this.dal.CreateQuest(10, 12, 2, 2, 1, "test1", "test1 desc",
										"arc", "giver dialog", "receiver dialog", 2, 3));
	}
	
	@Test
	@Order(2)
	public void createACharactersPlayerDupilicatesInDB() throws Exception {
		assertFalse(this.dal.CreateQuest(10, 12, 2, 2, 1, "test1", "desc",
				"arc", "giver dialog", "receiver dialog", 2, 3));
		
	}
	
	@Test
	@Order(3)
	public void getQuestByNameDB() throws Exception {
		this.quest = this.dal.GetQuestByName("test1");
		assertNotNull(this.quest);
		assertEquals(this.quest.GetQuestReceiverNpcId(), 10);
		assertEquals(this.quest.GetQuestGiverNpcId(), 12);
		assertEquals(this.quest.GetPreReqQuestId(), 2);
		assertEquals(this.quest.GetConflictId(), 2);
		assertEquals(this.quest.GetMinCharacterLevel(), 1);
		assertEquals(this.quest.GetQuestName(), "test1");
		assertEquals(this.quest.GetQuestDescription(), "test1 desc");
		assertEquals(this.quest.GetQuestArcType(), "arc");
		assertEquals(this.quest.GetQuesGiverDialog(), "giver dialog");
		assertEquals(this.quest.GetQuestReceiverDialog(), "receiver dialog");
		assertEquals(this.quest.GetidInConflict(), 2);
		assertEquals(this.quest.GetidPreReqIdConflict(), 3);
	}
	
	@Test
	@Order(4)
	public void getQuestByIdDB() throws Exception {
		this.quest = this.dal.GetQuestByName("test1");
		this.quest = this.dal.GetQuestByID(this.quest.GetQuestId());
		assertNotNull(this.quest);
		assertEquals(this.quest.GetQuestReceiverNpcId(), 10);
		assertEquals(this.quest.GetQuestGiverNpcId(), 12);
		assertEquals(this.quest.GetPreReqQuestId(), 2);
		assertEquals(this.quest.GetConflictId(), 2);
		assertEquals(this.quest.GetMinCharacterLevel(), 1);
		assertEquals(this.quest.GetQuestName(), "test1");
		assertEquals(this.quest.GetQuestDescription(), "test1 desc");
		assertEquals(this.quest.GetQuestArcType(), "arc");
		assertEquals(this.quest.GetQuesGiverDialog(), "giver dialog");
		assertEquals(this.quest.GetQuestReceiverDialog(), "receiver dialog");
		assertEquals(this.quest.GetidInConflict(), 2);
		assertEquals(this.quest.GetidPreReqIdConflict(), 3);
	}
	
	@Test
	@Order(5)
	public void updateQuestInTheDB() throws Exception {
		this.quest = this.dal.GetQuestByName("test1");
		this.dal.UpdateQuest(this.quest, 10, 40, 0, 2, 3, "updated test1", "updated", "updated", "updated", "updated", 4, 5);
		this.quest = this.dal.GetQuestByID(this.quest.GetQuestId());
		assertNotNull(this.quest);
		assertEquals(this.quest.GetQuestReceiverNpcId(), 10);
		assertEquals(this.quest.GetQuestGiverNpcId(), 40);
		assertEquals(this.quest.GetPreReqQuestId(), 0);
		assertEquals(this.quest.GetConflictId(), 2);
		assertEquals(this.quest.GetMinCharacterLevel(), 3);
		assertEquals(this.quest.GetQuestName(), "updated test1");
		assertEquals(this.quest.GetQuestDescription(), "updated");
		assertEquals(this.quest.GetQuestArcType(), "updated");
		assertEquals(this.quest.GetQuesGiverDialog(), "updated");
		assertEquals(this.quest.GetQuestReceiverDialog(), "updated");
		assertEquals(this.quest.GetidInConflict(), 4);
		assertEquals(this.quest.GetidPreReqIdConflict(), 5);
	}
	
	@Test
	@Order(6)
	public void deleteANpcCharacterInDB() throws Exception {
		this.quest = this.dal.GetQuestByName("updated test1");
		assertTrue(this.dal.DeleteQuest(quest));
		this.quest = this.dal.GetQuestByName("updated test1");
		assertEquals(this.quest, null);
	}

}