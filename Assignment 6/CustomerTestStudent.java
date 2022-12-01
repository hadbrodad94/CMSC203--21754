import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CustomerTestStudent {
	Customer c,c2;
	@BeforeEach
	void setUp() throws Exception {
		c = new Customer("Majd", 18);
	}

	@AfterEach
	void tearDown() throws Exception {
		c =null;
	}
	//this test tests both constructors essentially to see
	//whether the copy constructor is the same after changing
	//parts (deep copy)
	@Test
	void testCustomerStringInt() {
		c2 = new Customer(c);
		assertFalse(c == c2);
		c2.setAge(25);
		c2.setName("Majdoo");
		assertFalse(c2.getName().equals(c.getName()));
		assertFalse(c2.getAge() == c.getAge());
	}

	@Test
	void testGetName() {
		assertEquals("Majd", c.getName());
	}


	@Test
	void testGetAge() {
		assertEquals(18,c.getAge());
	}

	@Test
	void testToString() {
		assertEquals("Name: Majd\nAge: 18", c.toString());
	}

}
