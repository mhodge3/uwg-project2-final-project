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
	

}
