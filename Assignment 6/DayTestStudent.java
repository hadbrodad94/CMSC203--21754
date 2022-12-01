import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DayTestStudent {
	Day d;
	@BeforeEach
	void setUp() throws Exception {
		
	}

	@AfterEach
	void tearDown() throws Exception {
		d = null;
	}

	@Test
	void test() {
		assertEquals(d.MONDAY, Day.MONDAY);
		assertEquals(d.TUESDAY,Day.TUESDAY);
		assertEquals(d.WEDNESDAY,Day.WEDNESDAY);
		assertEquals(d.THURSDAY,Day.THURSDAY);
		assertEquals(d.FRIDAY,Day.FRIDAY);
		assertEquals(d.SATURDAY,Day.SATURDAY);
		assertEquals(d.SUNDAY,Day.SUNDAY);
	}

}
