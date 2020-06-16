package DAL;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.Player;

class testPlayerDALGetPlayer {
	
	Player thePlayer = new Player();
	PlayerDAL dal = new PlayerDAL();
	
	@Test
	public void retrievesPlayerWithNameAdminPasswordtest1234() throws Exception {
		this.thePlayer = this.dal.GetPlayer("admin", "test1234");
		assertEquals(this.thePlayer.GetPlayerId(), 1);
		assertEquals(this.thePlayer.GetPlayerName(), "admin");
		assertEquals(this.thePlayer.GetPlayerPassword(), "test1234");
		assertEquals(this.thePlayer.GetPlayerEmail(), "admin@demo.com");
		assertEquals(this.thePlayer.GetPlayerCountryCode(), "USA");
	}
	
	@Test
	public void retrievesPlayerWithNamePlayerPasswordtest1234() throws Exception {
		this.thePlayer = this.dal.GetPlayer("player", "test1234");
		assertEquals(this.thePlayer.GetPlayerId(), 2);
		assertEquals(this.thePlayer.GetPlayerName(), "player");
		assertEquals(this.thePlayer.GetPlayerPassword(), "test1234");
		assertEquals(this.thePlayer.GetPlayerEmail(), "player@demo.com");
		assertEquals(this.thePlayer.GetPlayerCountryCode(), "USA");
	}
	
	@Test
	public void retrievesNonPlayer() throws Exception {
		this.thePlayer = this.dal.GetPlayer("nonPlayer", "test1234");
		assertEquals(this.thePlayer, null);
	}
	
	/*@Test
	public void addAPlayerToDB() throws Exception {
		assertTrue(this.dal.CreatePlayer("bogus", "test1234", "bogus@bogus,com", "USA"));
	}*/
	
	/*@Test
	public void updateAPlayer() throws Exception {
		Player oldPlayer = this.dal.GetPlayer("bogus", "test1234");
		Player updatedPlayer = new Player("bogus", false, "USA", "bogus@newemail,com", "newpw");
		this.dal.UpdatePlayer(oldPlayer, updatedPlayer);
		oldPlayer = this.dal.GetPlayer("bogus", "newpw");
		assertEquals(oldPlayer.GetPlayerPassword(), "newpw");
	}*/
	
	@Test
	public void deleteAPlayer() throws Exception {
		this.thePlayer = this.dal.GetPlayer("bogus", "newpw");
		this.dal.DeletePlayer(thePlayer);
		this.thePlayer = this.dal.GetPlayer("bogus", "newpw");
		assertEquals(this.thePlayer, null);
	}

}
