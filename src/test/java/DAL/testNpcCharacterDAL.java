package DAL;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import com.cs6920.model.*;
import com.cs6920.DAL.*;

class testNpcCharacterDAL {
	MySQLAccess access = new MySQLAccess();
	NpcCharacterDAL dal = new NpcCharacterDAL(access);
	NpcCharacter character = new NpcCharacter();

	@Test
	public void retrievesNpcCharacterID1FromDB() throws Exception {
		this.character = this.dal.GetNpcById(1);
		assertEquals(this.character.GetNpcId(), 1);
		assertEquals(this.character.GetNpcName(),"Sum Guy");
		assertEquals(this.character.GetNpcDescprition(),"Testing dummy.");
		assertEquals(this.character.GetNpcType(), 0);
		assertEquals(this.character.GetNpcFaction(), 0);
		assertEquals(this.character.GetNpcPosX(), 0);
		assertEquals(this.character.GetNpcPosY(), 0);
		assertEquals(this.character.GetNpcPosZ(), 0);
	}
	
	@Test
	public void retrievesNpcCharacterID2FromDB() throws Exception {
		this.character = this.dal.GetNpcById(2);
		assertEquals(this.character.GetNpcId(), 2);
		assertEquals(this.character.GetNpcName(),"Sum Gal");
		assertEquals(this.character.GetNpcDescprition(),"Testing dummy 2.");
		assertEquals(this.character.GetNpcType(), 0);
		assertEquals(this.character.GetNpcFaction(), 0);
		assertEquals(this.character.GetNpcPosX(), 0);
		assertEquals(this.character.GetNpcPosY(), 0);
		assertEquals(this.character.GetNpcPosZ(), 0);
	}
	
	@Test
	public void retrievesNpcCharacterByNameFromDB() throws Exception {
		this.character = this.dal.GetNpcByName("Sum Gal");
		assertEquals(this.character.GetNpcId(), 2);
		assertEquals(this.character.GetNpcName(),"Sum Gal");
		assertEquals(this.character.GetNpcDescprition(),"Testing dummy 2.");
		assertEquals(this.character.GetNpcType(), 0);
		assertEquals(this.character.GetNpcFaction(), 0);
		assertEquals(this.character.GetNpcPosX(), 0);
		assertEquals(this.character.GetNpcPosY(), 0);
		assertEquals(this.character.GetNpcPosZ(), 0);
	}
	
	@Test
	public void retrievesAllNpcCharactersFromDB() throws Exception {
		ArrayList<NpcCharacter> allNpc = this.dal.GetAllNpc();
		assertEquals(allNpc.get(0).GetNpcName(), "Sum Guy");
		assertEquals(allNpc.get(1).GetNpcName(), "Sum Gal");
	}
	
	@Test
	public void createANpcCharacterInDB() throws Exception {
		assertTrue(this.dal.CreateNpc("the character", "Max", 1, 2, 2.1, 3.0, 4.0));
		this.character = this.dal.GetNpcByName("Max");
		assertEquals(this.character.GetNpcName(),"Max");
		assertEquals(this.character.GetNpcDescprition(),"the character");
		assertEquals(this.character.GetNpcType(), 1);
		assertEquals(this.character.GetNpcFaction(), 2);
		assertEquals(this.character.GetNpcPosX(), 2.1);
		assertEquals(this.character.GetNpcPosY(), 3.0);
		assertEquals(this.character.GetNpcPosZ(), 4.0);
	}
	
	@Test
	public void updateANpcCharacterInDB() throws Exception {
		this.character = this.dal.GetNpcByName("Max");
		NpcCharacter updatedCharacter = new NpcCharacter(0, "the good guy", "Max", 3, 7, 14.1, 337.5, 4.5);
		assertTrue(this.dal.UpdateNpc(this.character, updatedCharacter));
		this.character = this.dal.GetNpcByName("Max");
		assertEquals(this.character.GetNpcName(),"Max");
		assertEquals(this.character.GetNpcDescprition(),"the good guy");
		assertEquals(this.character.GetNpcType(), 3);
		assertEquals(this.character.GetNpcFaction(), 7);
		assertEquals(this.character.GetNpcPosX(), 14.1);
		assertEquals(this.character.GetNpcPosY(), 337.5);
		assertEquals(this.character.GetNpcPosZ(), 4.5);
	}
	
	@Test
	public void deleteANpcCharacterInDB() throws Exception {
		this.character = this.dal.GetNpcByName("Max");
		assertTrue(this.dal.DeleteNpc(this.character));
		this.character = this.dal.GetNpcByName("Max");
		assertEquals(this.character, null);
	}
	
	
}

