import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GradeBookTester {
	GradeBook gb1;
	GradeBook gb2;
	GradeBook gb3;
	GradeBook gb4;
	@BeforeEach
	void setUp() throws Exception {
		gb1 = new GradeBook(5);
		gb2 = new GradeBook(5);
		gb3 = new GradeBook(5);
		gb4 = new GradeBook(5);
		gb1.addScore(95.7);
		gb1.addScore(57.3);
		gb1.addScore(49.7);
		gb1.addScore(99.99);
		
		gb2.addScore(87.3);
		gb2.addScore(30.0);	
		
		//gb3 with 1 element to show the result that returns that one element
		gb3.addScore(60.7);
		
		//gb4 w/ 0 elements to show result is 0 in finalScore method
	}

	@AfterEach
	void tearDown() throws Exception {
		gb1 = gb2 = gb3 = gb4 = null;
	}

	@Test
	void testAddScore() {
		//checks to see whether each object created changed to string format is equal to the numbers in the scores array
		assertTrue(gb1.toString().equals("95.7 57.3 49.7 99.99 "));
		assertTrue(gb2.toString().equals("87.3 30.0 "));
		assertTrue(gb3.toString().equals("60.7 "));
		assertTrue(gb4.toString().equals(""));
	}

	@Test
	void testSum() {
		assertEquals(302.69, gb1.sum(),.0001);
		assertEquals(117.3, gb2.sum(),.0001);
		assertEquals(60.7, gb3.sum(),.0001);
		assertEquals(0.0, gb4.sum(),.0001);
	}

	@Test
	void testMinimum() {
		assertEquals(49.7,gb1.minimum(),.001);
		assertEquals(30.0,gb2.minimum(),.001);
		assertEquals(60.7,gb3.minimum(),.001);
		assertEquals(0.0,gb4.minimum(),.001);
	}

	@Test
	void testFinalScore() {
		assertEquals(252.99,gb1.finalScore());
		assertEquals(87.3,gb2.finalScore());
		assertEquals(60.7,gb3.finalScore());
		assertEquals(0,gb4.finalScore());
	}

}
