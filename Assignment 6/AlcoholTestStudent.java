import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AlcoholTestStudent {
	Alcohol a1,a2,a3,a4;
	@BeforeEach
	void setUp() throws Exception {
		a1 = new Alcohol("Alcohol1",Size.SMALL,true);
		a2 = new Alcohol("Alcohol2",Size.MEDIUM,false);
		a3 = new Alcohol("Alcohol3", Size.LARGE,true);
		a4 = new Alcohol("Alcohol1",Size.SMALL,true);
	}

	@AfterEach
	void tearDown() throws Exception {
		a1 = a2 = a3 =a4 = null;
	}

	@Test
	void testToString() {
		assertEquals("Beverage name: Alcohol1\nSize: SMALL\nWeekend: true\nPrice: 2.6",a1.toString());
	}

	@Test
	void testCalcPrice() {
		assertEquals(2.60, a1.calcPrice(),.01);
		assertEquals(3.0, a2.calcPrice(),.01);
		assertEquals(4.60, a3.calcPrice(),.01);
	}

	@Test
	void testIsWeekend() {
		assertTrue(a1.isWeekend());
		assertFalse(a2.isWeekend());
		assertTrue(a3.isWeekend());
	}

	@Test
	void testEqualsAlcohol() {
		assertTrue(a1.equals(a4));
		assertFalse(a1.equals(a2));
		assertFalse(a2.equals(a3));
	}

}

