package DAL;

import static org.junit.jupiter.api.Assertions.*;
import com.cs6920.model.*;
import com.cs6920.DAL.*;

import org.junit.jupiter.api.Test;

class testAdminDAL {
	Player thePlayer = new Player();
	MySQLAccess access = new MySQLAccess();
	AdminDAL adminDal = new AdminDAL(access);
	PlayerDAL playerDal = new PlayerDAL(access);
	
	/*@Test
	public void createAdmin() throws Exception {
		this.thePlayer = this.playerDal.GetPlayer("player", "test1234");
		assertTrue(this.adminDal.CreateAdmin(thePlayer.GetPlayerId()));
	}*/
	
	@Test
	public void getTheAdminId() throws Exception {
		assertEquals(this.adminDal.getAdminID(1), 1);
	}
		

}
