/**
 * 
 */
package model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import com.cs6920.model.*;

/**
 * @author student
 * @date 6/17/2020
 */
public class AdminTests {
	
	/**
	 * Tests Admin model's overloaded constructor
	 */
	@Test
	public void testAdminOverloadedContructor() {
		Admin testAdmin = new Admin(1, 2, 3);
		assertEquals(1, testAdmin.getAdminId());
		assertEquals(2, testAdmin.getPlayerId());
		assertEquals(3, testAdmin.getIsActive());
	}
	
	/**
	 * Tests the GetAdminID and SetAdminID Methods
	 * 
	 */
	@Test
	public void testGetAdminIDShouldBe1234() {
		Admin testAdmin = new Admin();
		testAdmin.setAdminID(1234);
		assertEquals(1234, testAdmin.getAdminId());
	}
	
	/**
	 * Tests the GetPlayerID and SetPlayerID Methods
	 * 
	 */
	@Test
	public void testGetPlayerIDShouldBe1234() {
		Admin testAdmin = new Admin();
		testAdmin.setPlayerId(1234);
		assertEquals(1234, testAdmin.getPlayerId());
	}
	
	/**
	 * Tests the GetIsActive and SetIsActive Methods
	 * 
	 */
	@Test
	public void testGetIsActiveShouldBe1234() {
		Admin testAdmin = new Admin();
		testAdmin.setIsActive(1);;
		assertEquals(1, testAdmin.getIsActive());
	}

}
