import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TypeTestStudent {
	Type t;
	@BeforeEach
	void setUp() throws Exception {
		
	}

	@AfterEach
	void tearDown() throws Exception {
		t = null;
	}

	@Test
	void test() {
		assertEquals(t.ALCOHOL, Type.ALCOHOL);
		assertEquals(t.SMOOTHIE, Type.SMOOTHIE);
		assertEquals(t.COFFEE,Type.COFFEE);
	}

}
