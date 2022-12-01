import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SizeTestStudent {
	Size s;
	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
		s = null;
	}

	@Test
	void test() {
		assertEquals(s.SMALL,Size.SMALL);
		assertEquals(s.MEDIUM,Size.MEDIUM);
		assertEquals(s.LARGE,Size.LARGE);
	}

}
