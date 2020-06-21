/**
 * 
 */
package model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import model.Admin;

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
		assertEquals(1, testAdmin.GetAdminId());
		assertEquals(2, testAdmin.GetPlayerId());
		assertEquals(3, testAdmin.GetIsActive());
	}
	
	/**
	 * Tests the GetAdminID and SetAdminID Methods
	 * 
	 */
	@Test
	public void testGetAdminIDShouldBe1234() {
		Admin testAdmin = new Admin();
		testAdmin.SetAdminID(1234);
		assertEquals(1234, testAdmin.GetAdminId());
	}
	
	/**
	 * Tests the GetPlayerID and SetPlayerID Methods
	 * 
	 */
	@Test
	public void testGetPlayerIDShouldBe1234() {
		Admin testAdmin = new Admin();
		testAdmin.SetPlayerId(1234);
		assertEquals(1234, testAdmin.GetPlayerId());
	}
	
	/**
	 * Tests the GetIsActive and SetIsActive Methods
	 * 
	 */
	@Test
	public void testGetIsActiveShouldBe1234() {
		Admin testAdmin = new Admin();
		testAdmin.SetIsActive(1);;
		assertEquals(1, testAdmin.GetIsActive());
	}

}
