/**
 * 
 */
package model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.cs6920.model.*;

/**
 * @author Ashley Palmer
 * @date 6/26/2020
 *
 */
public class ConflictTests {
	
	/**
	 * Tests the GetConflictId and SetConflictId Methods
	 * 
	 */
	@Test
	public void testGetConflictIdShouldBe1234() {
		Conflict testItem = new Conflict();
		testItem.SetConflictId(1234);
		assertEquals(1234, testItem.GetConflictId());
	}
	
	/**
	 * Tests the GetConflictTemplate and SetConflictTemplate Methods
	 * 
	 */
	@Test
	public void testGetConflictTemplateBe1234() {
		Conflict testItem = new Conflict();
		testItem.SetConflictTemplate(1234);
		assertEquals(1234, testItem.GetConflictTemplate());
	}
	
	/**
	 * Tests the GetConflictName and SetConflictName Methods
	 * 
	 */
	@Test
	public void testGetConflictNameBeTom() {
		Conflict testItem = new Conflict();
		testItem.SetConflictName("Tom");
		assertEquals("Tom", testItem.GetConflictName());
	}
	
	/**
	 * Tests the GetConflictDescription and SetConflictDescription Methods
	 * 
	 */
	@Test
	public void testGetConflictDescriptionBeTom() {
		Conflict testItem = new Conflict();
		testItem.SetConflictDescription("Tom");
		assertEquals("Tom", testItem.GetConflictDescription());
	}
	
	

}
