/*
 * Class: CMSC203 
 * Instructor:Grinberg
 * Description: Designs a Property Management that collects the plot, property and combines it together in an organized fashion.
 * Due: 10/24/22
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here:Majd Haddad
*/

/**
 * @author Majd Haddad
 */
 import static org.junit.jupiter.api.Assertions.*;
 

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PlotTestStudent {
	private Plot p1,p2, p3,p4;
	private Plot p5,p6,p7,p8;
	@BeforeEach
	void setUp() throws Exception {
		p1 = new Plot(0,8,8,8);
		p2 = new Plot(8,8,4,8);
		p3 = new Plot(7,8,3,8);
		p4 = new Plot(2,4,4,4);
		
		p5 = new Plot(12,12,6,6); 
		p6 = new Plot(13,14,4,3);
		p7 = new Plot(12,12,3,2);
		p8 = new Plot(15,17,3,1);
		 
	}

	@AfterEach
	void tearDown() throws Exception {
		p1 = p2 = p3 = p4 = p5 = p6 = p7 = p8 = null;
	}
	
	@Test
	void testGetDepth() {
		assertEquals(8, p1.getDepth());
		assertEquals(8, p2.getDepth());
		assertEquals(8, p3.getDepth());
	}

	@Test
	void testGetWidth() {
		assertEquals(8, p1.getWidth());
		assertEquals(4, p2.getWidth());
		assertEquals(3, p3.getWidth());
	}

	@Test
	void testGetX() {
		assertEquals(0, p1.getX());
		assertEquals(8, p2.getX());
		assertEquals(7, p3.getX());
	}

	@Test
	void testGetY() {
		assertEquals(8, p1.getY());
		assertEquals(8, p2.getY());
		assertEquals(8, p3.getY());
	}

	@Test
	void testEncompasses() {
		assertFalse(p1.encompasses(p2));
		assertFalse(p1.encompasses(p3));
		assertFalse(p2.encompasses(p3));
		assertFalse(p4.encompasses(p1));
		
		assertTrue(p5.encompasses(p6));
		assertTrue(p5.encompasses(p7));
		assertTrue(p5.encompasses(p8));
	}

	@Test
	void testOverlaps() {
		assertFalse(p1.overlaps(p2));
		assertTrue(p1.overlaps(p3));
		assertTrue(p2.overlaps(p3));
		assertFalse(p4.overlaps(p1));
		
		assertFalse(p1.overlaps(p5));
		assertFalse(p2.overlaps(p5));
		assertFalse(p3.overlaps(p5));
		assertFalse(p1.overlaps(p7));
	}

	@Test
	void testToString() {
		assertEquals("0,8,8,8", p1.toString());
		assertEquals("8,8,4,8", p2.toString());
		assertEquals("7,8,3,8", p3.toString());
	}
	@Test
	//just used to assure that setters are good
	public void testSetX() {
		p1.setX(7);
		assertEquals(7, p1.getX());
	}
	@Test
	//just used to assure that setters are good
	public void testSetY() {
		p1.setY(7);
		assertEquals(7, p1.getY());
	}
	public void testSetWidth() {
		p1.setWidth(7);
		assertEquals(7, p1.getWidth());
	}
	public void testSetDepth() {
		p1.setDepth(7);
		assertEquals(7, p1.getDepth());
	}
}