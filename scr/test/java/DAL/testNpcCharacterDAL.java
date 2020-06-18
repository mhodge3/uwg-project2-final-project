package DAL;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.NpcCharacter;

class testNpcCharacterDAL {
	MySQLAccess access = new MySQLAccess();
	NpcCharacterDAL dal = new NpcCharacterDAL(access);
	NpcCharacter character = new NpcCharacter();

	@Test
	public void retrievesNpcCharacterID1FromDB() throws Exception {
		this.character = this.dal.GetNpc(1);
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
		this.character = this.dal.GetNpc(2);
		assertEquals(this.character.GetNpcId(), 2);
		assertEquals(this.character.GetNpcName(),"Sum Gal");
		assertEquals(this.character.GetNpcDescprition(),"Testing dummy 2.");
		assertEquals(this.character.GetNpcType(), 0);
		assertEquals(this.character.GetNpcFaction(), 0);
		assertEquals(this.character.GetNpcPosX(), 0);
		assertEquals(this.character.GetNpcPosY(), 0);
		assertEquals(this.character.GetNpcPosZ(), 0);
	}
}

/*"`characters_npc`.`character_npc_name`, " +
"`characters_npc`.`character_npc_description`, " +
"`characters_npc`.`character_npc_type`, " + 
"`characters_npc`.`character_npc_faction`, " +
"`characters_npc`.`character_npc_pos_x`, " +
"`characters_npc`.`character_npc_pos_y`, " +
"`characters_npc`.`character_npc_pos_z` " +
"FROM `rpg_story_mapper_db`.`characters_npc` " +*/
