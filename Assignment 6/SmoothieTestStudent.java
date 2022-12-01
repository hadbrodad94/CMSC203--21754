import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class SmoothieTestStudent {
	Smoothie s1,s2,s3,s4,s5;
	@BeforeEach
	void setUp() throws Exception {
		s1 = new Smoothie("Strawberry", Size.SMALL, 0,false);
		s2 = new Smoothie("Vanilla", Size.SMALL,1,true);
		s3 = new Smoothie("Chocolate", Size.MEDIUM, 3, true);
		s4 = new Smoothie("Tropical", Size.LARGE, 4, true);
		s5 = new Smoothie("Strawberry", Size.SMALL, 0,false);
	}

	@AfterEach
	void tearDown() throws Exception {
		s1 = s2 = s3 = s4 =s5 = null;
	}

	@Test
	void testToString() {
		assertEquals("Beverage name: Strawberry\nSize: SMALL\nProtein Added: false\nNumber of Fruits: 0\nPrice: 2.0",s1.toString());
	}

	@Test
	//used to make sure my numbers are working properly for calculating price
	void testCalcPrice() {
		assertEquals(2.0, s1.calcPrice(),.01);
		assertEquals(4.0, s2.calcPrice(),.01);
		assertEquals(6.0,s3.calcPrice(),.01);
		assertEquals(7.5,s4.calcPrice(),.01);
	}
	
	@Test
	void testGetNumOfFruits() {
		assertEquals(0,s1.getNumOfFruits());
		assertEquals(1,s2.getNumOfFruits());
		assertEquals(3,s3.getNumOfFruits());
		assertEquals(4,s4.getNumOfFruits());
	}

	@Test
	void testIsAddProtein() {
		assertFalse(s1.isAddProtein());
		assertTrue(s2.isAddProtein());
		assertTrue(s3.isAddProtein());
		assertTrue(s4.isAddProtein());
	}

	@Test
	void testEqualsSmoothie() {
		assertFalse(s1.equals(s2));
		assertFalse(s2.equals(s3));
		assertTrue(s1.equals(s5));
	}

}
