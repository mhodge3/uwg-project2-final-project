package DAL;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import com.cs6920.DAL.CharacterPlayerQuestLogDAL;
import com.cs6920.DAL.MySQLAccess;
import com.cs6920.model.CharacterPlayerQuestLog;

class testCharacterPlayerQuestLogDALCRUDCycle {

	MySQLAccess access = new MySQLAccess();
	CharacterPlayerQuestLogDAL dal = new CharacterPlayerQuestLogDAL(access);
	CharacterPlayerQuestLog log = new CharacterPlayerQuestLog();

	@Test
	@Order(1)
	public void createACharactersPlayerQuestLogInDB() throws Exception {
		assertTrue(this.dal.createCharacterPlayerQuestLog(1, 1, 1));
		
	}
	
	/**
	 * Testing foreign key constraints
	 * @throws Exception 
	 */
	@Test
	@Order(2)
	public void createANonPlayerCharactersLogInDB() throws Exception {
		assertFalse(this.dal.createCharacterPlayerQuestLog(1, 10000, 1));
		
	}
	
	@Test
	@Order(3)
	public void getQuestLogCharacterIDFromDB() throws Exception {
		this.log = this.dal.getCharacterPlayerQuestLogByCharacterId(1);
		assertEquals(this.log.getCharacterId(), 1);
		assertEquals(this.log.getQuestStatus(), 1);
	}
	
	/*@Test
	@Order(4)
	public void getQuestLogQuestIDFromDB() throws Exception {
		this.log = this.dal.GetCharacterPlayerQuestLogByQuestID(1);
		assertEquals(this.log.GetQuestId(), 1);
		assertEquals(this.log.GetCharacterId(), 1);
		assertEquals(this.log.GetQuestStatus(), 1);
	}*/
	
	@Test
	@Order(4)
	public void updateQuestLogStatusInTheDB() throws Exception {
		this.log = this.dal.getCharacterPlayerQuestLogByCharacterId(1);
		this.dal.updateCharacterPlayerQuestLogStatus(log, 0);
		this.log = this.dal.getCharacterPlayerQuestLogByCharacterId(1);
		assertEquals(this.log.getCharacterId(), 1);
		assertEquals(this.log.getQuestStatus(), 0);
	}
	
	
/*	@Test
	@Order(6)
	public void deleteQuestLogStatusInTheDB() throws Exception {
		this.log = this.dal.GetCharacterPlayerQuestLogByCharacterId(1);
		this.dal.UpdateCharacterPlayerQuestLogStatus(log, 0);
		this.log = this.dal.GetCharacterPlayerQuestLogByCharacterId(1);
		assertEquals(this.log, null);
	}*/
}
