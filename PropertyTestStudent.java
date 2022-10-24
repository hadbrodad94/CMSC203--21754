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

class PropertyTestStudent {
	private Property prop1,prop2;
	@BeforeEach
	void setUp() throws Exception {
		prop1 = new Property("McDonalds", "Silver Spring", 6000.2, "Ronald MacDonald");
		prop2 = new Property("Library","Rockville", 1237.99, "Billy Boh",7,7,8,8);
		
	}

	@AfterEach
	void tearDown() throws Exception {
		prop1 = prop2 = null;
	}

	@Test
	void testGetCity() {
		assertEquals("Silver Spring", prop1.getCity());
		assertEquals("Rockville",prop2.getCity());
	}

	@Test
	void testGetOwner() {
		assertEquals("Ronald MacDonald",prop1.getOwner());
		assertEquals("Billy Boh", prop2.getOwner());
	}

	@Test
	void testGetPlot() {
		assertEquals(0,prop1.getPlot().getX());
		assertEquals(0,prop1.getPlot().getY());
		assertEquals(1,prop1.getPlot().getWidth());
		assertEquals(1,prop1.getPlot().getDepth());
		
		
		assertEquals(7,prop2.getPlot().getX());
		assertEquals(7,prop2.getPlot().getY());
		assertEquals(8,prop2.getPlot().getWidth());
		assertEquals(8,prop2.getPlot().getDepth());
		
	}

	@Test
	void testGetPropertyName() {
		assertEquals("McDonalds", prop1.getPropertyName());
		assertEquals("Library",prop2.getPropertyName());
	}

	@Test
	void testGetRentAmount() {
		assertEquals(6000.2,prop1.getRentAmount());
		assertEquals(1237.99,prop2.getRentAmount());
	}

	@Test
	void testToString() {
		assertEquals("McDonalds,Silver Spring,Ronald MacDonald,6000.2", prop1.toString());
		assertEquals("Library,Rockville,Billy Boh,1237.99",prop2.toString());
	}

}
