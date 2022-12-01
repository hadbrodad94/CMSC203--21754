import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CoffeeTestStudent {
	Coffee c1, c2, c3, c4;
	@BeforeEach
	void setUp() throws Exception {
		c1 = new Coffee("Latte", Size.SMALL, true, true);
		c2 = new Coffee("Arabic Coffee", Size.MEDIUM,false,false);
		c3 = new Coffee("Turkish Coffee",Size.LARGE,true,false);
		c4 = new Coffee("Latte", Size.SMALL, true, true);
	}

	@AfterEach
	void tearDown() throws Exception {
		c1 = c2 = c3 =c4;
	}

	@Test
	void testToString() {
		assertEquals("Beverage name: Arabic Coffee\nSize: MEDIUM\nExtra Shot: false\nExtra Syrup: false\nPrice: 3.0",c2.toString());
	}

	@Test
	void testCalcPrice() {
		assertEquals(3.0, c1.calcPrice(),.01);
		assertEquals(3.0,c2.calcPrice(),.01);
		assertEquals(4.5,c3.calcPrice(),.01);
	}

	@Test
	void testGetExtraShot() {
		assertTrue(c1.getExtraShot());
		assertFalse(c2.getExtraShot());
		assertTrue(c3.getExtraShot());
	}

	@Test
	void testGetExtraSyrup() {
		assertTrue(c1.getExtraSyrup());
		assertFalse(c2.getExtraSyrup());
		assertFalse(c3.getExtraSyrup());
	}

	@Test
	void testEqualsCoffee() {
		assertTrue(c1.equals(c4));
		assertFalse(c1.equals(c2));
	}

}
