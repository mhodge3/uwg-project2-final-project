package DAL;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import com.cs6920.model.*;
import com.cs6920.DAL.*;

@TestMethodOrder(OrderAnnotation.class)


/**
 * Test the methods of the PlayerDAL in a CRUD cycle
 * @date 6/17/2020
 * @author Perry Iler
 *
 */
class testPlayerDAL {
	
	Player thePlayer = new Player();
	MySQLAccess access = new MySQLAccess();
	PlayerDAL dal = new PlayerDAL(new MySQLAccess());
	
	@Test
	@Order(1)
	public void addAPlayerToDBShouldBeTrueIfAdded() throws Exception {
		this.dal.CreatePlayer("bogus", "test1234", "bogus@bogus.com", "USA", false);
		Player player = this.dal.GetPlayer("bogus", "test1234");
		assertEquals(player.GetPlayerName(), "bogus");
		assertEquals(player.GetPlayerPassword(), "test1234");
		assertEquals(player.GetPlayerEmail(), "bogus@bogus.com");
		assertEquals(player.GetPlayerCountryCode(), "USA");
		assertFalse(this.dal.IsPlayerAdmin(player));
	}
	
	@Test
	@Order(2)
	public void addAAdminPlayerToDBShouldBeTrueIfAdded() throws Exception {
		this.dal.CreatePlayer("joe", "test1234", "joe@joe.com", "USA", true);
		Player player = this.dal.GetPlayer("joe", "test1234");
		assertEquals(player.GetPlayerName(), "joe");
		assertEquals(player.GetPlayerPassword(), "test1234");
		assertEquals(player.GetPlayerEmail(), "joe@joe.com");
		assertEquals(player.GetPlayerCountryCode(), "USA");
		assertTrue(this.dal.IsPlayerAdmin(player));
	}
	
	@Test
	@Order(3)
	public void addAPlayerWithANonUniqueNameToDBShouldBefalse() throws Exception {
		assertFalse(this.dal.CreatePlayer("bogus", "test1234", "bogus@bogus.com", "USA", false));
	}
	
	@Test
	@Order(4)
	public void retrievesAddedPlayer() throws Exception {
		Player player = this.dal.GetPlayer("bogus", "test1234");
		assertEquals(player.GetPlayerName(), "bogus");
		assertEquals(player.GetPlayerPassword(), "test1234");
		assertEquals(player.GetPlayerEmail(), "bogus@bogus.com");
		assertEquals(player.GetPlayerCountryCode(), "USA");
	}
	
	@Test
	@Order(5)
	public void updateAPlayer() throws Exception {
		Player oldPlayer = this.dal.GetPlayer("bogus", "test1234");
		Player updatedPlayer = new Player(0, "bogus", false, "USA", "bogus@newemail.com", "newpw");
		this.dal.UpdatePlayer(oldPlayer, updatedPlayer, false);
		oldPlayer = this.dal.GetPlayer("bogus", "newpw");
		assertEquals(oldPlayer.GetPlayerPassword(), "newpw");
	}
	
	@Test
	@Order(6)
	public void isPlayerAnAdmin() throws Exception {
		Player player = this.dal.GetPlayer("bogus", "test1234");
		Player admin = this.dal.GetPlayer("joe", "test1234");
		assertFalse(this.dal.IsPlayerAdmin(player));
		assertTrue(this.dal.IsPlayerAdmin(admin));
	}
	
	@Test
	@Order(7)
	public void deleteAPlayer() throws Exception {
		Player player = this.dal.GetPlayer("bogus", "newpw");
		this.dal.DeletePlayer(player);
		player = this.dal.GetPlayer("bogus", "newpw");
		assertNull(player);
	}

	
	@Test
	@Order(7)
	public void deleteAAdimPlayer() throws Exception {
		Player admin = this.dal.GetPlayer("joe", "test1234");
		this.dal.DeletePlayer(admin);
		admin = this.dal.GetPlayer("joe", "test1234");
		assertNull(admin);
	}
	
	@Test
	@Order(8)
	public void retrievesNonPlayerShouldBeNull() throws Exception {
		this.thePlayer = this.dal.GetPlayer("joe", "test1234");
		assertEquals(this.thePlayer, null);
	}
	
	@Test
	@Order(9)
	public void deleteAPlayerForCnostraintTesting() throws Exception {
		Player player = this.dal.GetPlayer("player", "test1234");
		assertTrue(this.dal.DeletePlayer(player));
		player = this.dal.GetPlayer("player", "test1234");
		assertNull(player);
	}

}
