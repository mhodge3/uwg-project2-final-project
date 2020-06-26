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
public class ConflictsTests {
	
	/**
	 * Tests the GetConflictId and SetConflictId Methods
	 * 
	 */
	@Test
	public void testGetConflictIdShouldBe1234() {
		Conflicts testItem = new Conflicts();
		testItem.SetConflictId(1234);
		assertEquals(1234, testItem.GetConflictId());
	}
	
	/**
	 * Tests the GetConflictTemplate and SetConflictTemplate Methods
	 * 
	 */
	@Test
	public void testGetConflictTemplateBe1234() {
		Conflicts testItem = new Conflicts();
		testItem.SetConflictTemplate(1234);
		assertEquals(1234, testItem.GetConflictTemplate());
	}
	
	/**
	 * Tests the GetConflictName and SetConflictName Methods
	 * 
	 */
	@Test
	public void testGetConflictNameBeTom() {
		Conflicts testItem = new Conflicts();
		testItem.SetConflictName("Tom");
		assertEquals("Tom", testItem.GetConflictName());
	}
	
	
	

}
