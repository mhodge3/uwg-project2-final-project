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
		this.dal.createPlayer("bogus", "test1234", "bogus@bogus.com", "USA", false);
		Player player = this.dal.getPlayer("bogus", "test1234");
		assertEquals(player.getPlayerName(), "bogus");
		assertEquals(player.getPlayerPassword(), "test1234");
		assertEquals(player.getPlayerEmail(), "bogus@bogus.com");
		assertEquals(player.getPlayerCountryCode(), "USA");
		assertFalse(this.dal.isPlayerAdmin(player));
	}
	
	@Test
	@Order(2)
	public void addAAdminPlayerToDBShouldBeTrueIfAdded() throws Exception {
		this.dal.createPlayer("joe", "test1234", "joe@joe.com", "USA", true);
		Player player = this.dal.getPlayer("joe", "test1234");
		assertEquals(player.getPlayerName(), "joe");
		assertEquals(player.getPlayerPassword(), "test1234");
		assertEquals(player.getPlayerEmail(), "joe@joe.com");
		assertEquals(player.getPlayerCountryCode(), "USA");
		assertTrue(this.dal.isPlayerAdmin(player));
	}
	
	@Test
	@Order(3)
	public void addAPlayerWithANonUniqueNameToDBShouldBefalse() throws Exception {
		assertFalse(this.dal.createPlayer("bogus", "test1234", "bogus@bogus.com", "USA", false));
	}
	
	@Test
	@Order(4)
	public void retrievesAddedPlayer() throws Exception {
		Player player = this.dal.getPlayer("bogus", "test1234");
		assertEquals(player.getPlayerName(), "bogus");
		assertEquals(player.getPlayerPassword(), "test1234");
		assertEquals(player.getPlayerEmail(), "bogus@bogus.com");
		assertEquals(player.getPlayerCountryCode(), "USA");
	}
	
	@Test
	@Order(5)
	public void updateAPlayer() throws Exception {
		Player oldPlayer = this.dal.getPlayer("bogus", "test1234");
		Player updatedPlayer = new Player(0, "bogus", false, "USA", "bogus@newemail.com", "newpw");
		this.dal.updatePlayer(oldPlayer, updatedPlayer, false);
		oldPlayer = this.dal.getPlayer("bogus", "newpw");
		assertEquals(oldPlayer.getPlayerPassword(), "newpw");
	}
	
	@Test
	@Order(6)
	public void isPlayerAnAdmin() throws Exception {
		Player player = this.dal.getPlayer("bogus", "test1234");
		Player admin = this.dal.getPlayer("joe", "test1234");
		assertFalse(this.dal.isPlayerAdmin(player));
		assertTrue(this.dal.isPlayerAdmin(admin));
	}
	
	@Test
	@Order(7)
	public void deleteAPlayer() throws Exception {
		Player player = this.dal.getPlayer("bogus", "newpw");
		this.dal.deletePlayer(player);
		player = this.dal.getPlayer("bogus", "newpw");
		assertNull(player);
	}

	
	@Test
	@Order(7)
	public void deleteAAdimPlayer() throws Exception {
		Player admin = this.dal.getPlayer("joe", "test1234");
		this.dal.deletePlayer(admin);
		admin = this.dal.getPlayer("joe", "test1234");
		assertNull(admin);
	}
	
	@Test
	@Order(8)
	public void retrievesNonPlayerShouldBeNull() throws Exception {
		this.thePlayer = this.dal.getPlayer("joe", "test1234");
		assertEquals(this.thePlayer, null);
	}
	
	@Test
	@Order(9)
	public void deleteAPlayerForCnostraintTesting() throws Exception {
		Player player = this.dal.getPlayer("player", "test1234");
		assertTrue(this.dal.deletePlayer(player));
		player = this.dal.getPlayer("player", "test1234");
		assertNull(player);
	}

}
