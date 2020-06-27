package DAL;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;

import com.cs6920.DAL.CharactersPlayerDAL;
import com.cs6920.DAL.MySQLAccess;
import com.cs6920.model.CharactersPlayer;

@TestMethodOrder(OrderAnnotation.class)

/**
 * Test the methods of the CharactersPlayerDAL in a CRUD cycle
 * @date 6/27/2020
 * @author Perry Iler
 *
 */
class testCharactersPlayerCRUDCycle {
	
	MySQLAccess access = new MySQLAccess();
	CharactersPlayerDAL dal = new CharactersPlayerDAL(access);
	CharactersPlayer character = new CharactersPlayer();

	@Test
	@Order(1)
	public void createACharactersPlayerInDB() throws Exception {
		assertTrue(this.dal.CreateCharacterPlayer(1, "new character", 1, 3, 3.1, 4.2, 5.3));
		
	}
	
	/**
	 * Testing foreign key constraints
	 * @throws Exception 
	 */
	/*@Test
	@Order(2)
	public void createANonPlayerCharactersPlayerInDB() throws Exception {
		assertFalse(this.dal.CreateCharacterPlayer(100000, "new charter", 1, 3, 3.1, 4.2, 5.3));
		
	}
	
	@Test
	@Order(3)
	public void getPlayerCharacterByCharacterNameFromDB() throws Exception {
		this.character = this.dal.GetCharactersPlayerByName("new character");
		assertEquals(this.character.GetCharacterPlayerId(), 1);
		assertEquals(this.character.GetCharacterName(), "new character");
		assertEquals(this.character.GetCharacterType(), 1);
		assertEquals(this.character.GetCharacterFaction(), 3);
		assertEquals(this.character.GetCharacterPosX(), 3.1);
		assertEquals(this.character.GetCharacterPosY(), 4.2);
		assertEquals(this.character.GetCharacterPosZ(), 5.3);
	}
	
	@Test
	@Order(3)
	public void getPlayerCharacterByCharacterIDFromDB() throws Exception {
		this.character = this.dal.GetCharactersPlayerByName("new character");
		this.character = this.dal.GetCharactersPlayerByID(this.character.GetCharacterId());
		assertEquals(this.character.GetCharacterPlayerId(), 1);
		assertEquals(this.character.GetCharacterName(), "new character");
		assertEquals(this.character.GetCharacterType(), 1);
		assertEquals(this.character.GetCharacterFaction(), 3);
		assertEquals(this.character.GetCharacterPosX(), 3.1);
		assertEquals(this.character.GetCharacterPosY(), 4.2);
		assertEquals(this.character.GetCharacterPosZ(), 5.3);
	}
	
	@Test
	@Order(4)
	public void updatePlayerCharacterInTheDB() throws Exception {
		this.character = this.dal.GetCharactersPlayerByName("new character");
		CharactersPlayer updatedCharacter = new CharactersPlayer(1, 1, "updated character", 4, 4, 5.1, 5.2, 5.5);
		assertTrue(this.dal.UpdateCharacterPlayer(this.character, updatedCharacter));
		this.character = this.dal.GetCharactersPlayerByName("updated character");
		assertEquals(this.character.GetCharacterPlayerId(), 1);
		assertEquals(this.character.GetCharacterName(), "updated character");
		assertEquals(this.character.GetCharacterType(), 4);
		assertEquals(this.character.GetCharacterFaction(), 4);
		assertEquals(this.character.GetCharacterPosX(), 5.1);
		assertEquals(this.character.GetCharacterPosY(), 5.2);
		assertEquals(this.character.GetCharacterPosZ(), 5.5);
	}
	
	@Test
	@Order(5)
	public void deleteANpcCharacterInDB() throws Exception {
		this.character = this.dal.GetCharactersPlayerByName("updated character");
		assertTrue(this.dal.DeleteCharacterPlayer(this.character));
		this.character = this.dal.GetCharactersPlayerByName("updated character");
		assertEquals(this.character, null);
	}*/
}
