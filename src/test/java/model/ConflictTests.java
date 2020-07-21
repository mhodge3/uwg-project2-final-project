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
	 * Tests the GetConflictMinLvl and SetConflictMinLvl Methods
	 * 
	 */
	@Test
	public void testGetConflictMinLvlShouldBe1234() {
		Conflict testItem = new Conflict();
		testItem.setConflictMinLvl(1234);
		assertEquals(1234, testItem.getConflictMinLvl());
	}
	
	/**
	 * Tests the GetConflictId and SetConflictId Methods
	 * 
	 */
	@Test
	public void testGetConflictIdShouldBe1234() {
		Conflict testItem = new Conflict();
		testItem.setConflictId(1234);
		assertEquals(1234, testItem.getConflictId());
	}
	
	/**
	 * Tests the GetConflictTemplate and SetConflictTemplate Methods
	 * 
	 */
	@Test
	public void testGetConflictTemplateBe1234() {
		Conflict testItem = new Conflict();
		testItem.setConflictTemplate(1234);
		assertEquals(1234, testItem.getConflictTemplate());
	}
	
	/**
	 * Tests the GetConflictName and SetConflictName Methods
	 * 
	 */
	@Test
	public void testGetConflictNameBeTom() {
		Conflict testItem = new Conflict();
		testItem.setConflictName("Tom");
		assertEquals("Tom", testItem.getConflictName());
	}
	
	/**
	 * Tests the GetCconflictArcType and SetConflictArcType Methods
	 * 
	 */
	@Test
	public void testGetConflictArcTypeShouldBeTom() {
		Conflict testItem = new Conflict();
		testItem.setConflictArcType("Tom");
		assertEquals("Tom", testItem.getConflictArcType());
	}
	
	/**
	 * Tests the GetConflictDescription and SetConflictDescription Methods
	 * 
	 */
	@Test
	public void testGetConflictDescriptionBeTom() {
		Conflict testItem = new Conflict();
		testItem.setConflictDescription("Tom");
		assertEquals("Tom", testItem.getConflictDescription());
	}
	
	

}
