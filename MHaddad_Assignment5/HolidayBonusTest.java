import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class HolidayBonusTest {
	private double[][] dataSet1 = {{3,5,7},{8,2},{11,12,16,17}};
	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testCalculateHolidayBonus() {
		try {
			double[] result = HolidayBonus.calculateHolidayBonus(dataSet1);
			assertEquals(4000.0, result[0], .001);
			assertEquals(3000.0, result[1], .001);
			assertEquals(20000.0, result[2], .001);
		} catch (Exception e) {
			fail("This should not have caused an Exception");
		}
	}

	@Test
	void testCalculateTotalHolidayBonus() {
		assertEquals(27000.0, HolidayBonus.calculateTotalHolidayBonus(dataSet1), .001);
	}

}
