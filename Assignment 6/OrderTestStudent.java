import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OrderTestStudent {
	Order o,o2;
	@BeforeEach
	void setUp() throws Exception {
		o = new Order(17, Day.SATURDAY, new Customer("Majd", 18));
		o2 = new Order(29, Day.MONDAY,new Customer("Latif", 19));
	}

	@AfterEach
	void tearDown() throws Exception {
		o = o2 = null;
	}

	@Test
	void testAddNewBeverageStringSize() {
		assertTrue(o.getTotalItems()== 0);
		o.addNewBeverage("Alcohol", Size.LARGE);
		assertTrue(o.getBeverage(0).getType().equals(Type.ALCOHOL));
	}

	@Test
	void testAddNewBeverageStringSizeBooleanBoolean() {
		assertTrue(o.getTotalItems() == 0);
		o.addNewBeverage("Arabic", Size.MEDIUM, false, true);
		assertTrue(o.getBeverage(0).getType().equals(Type.COFFEE));
	}

	@Test
	void testAddNewBeverageStringSizeIntBoolean() {
		assertTrue(o.getTotalItems() == 0);
		o.addNewBeverage("Strawberry Bannana", Size.SMALL, 2, true);
		assertTrue(o.getBeverage(0).getType().equals(Type.SMOOTHIE));
	}

	@Test
	void testCalcOrderTotal() {
		o.addNewBeverage("Alcohol", Size.MEDIUM); //3.6
		o.addNewBeverage("Mocha", Size.SMALL, false, true); //2.5
		o.addNewBeverage("Strawberry Bannana Smoothie", Size.LARGE, 2, true);//6.5
		assertEquals(12.6,o.calcOrderTotal());
		
		o2.addNewBeverage("Berry Mix", Size.SMALL, 3, false);//3.5
		o2.addNewBeverage("Mango", Size.MEDIUM, 1, true); //5.0
		o2.addNewBeverage("Arabic", Size.MEDIUM, true, true); // 4.0
		assertEquals(12.5, o2.calcOrderTotal());
	}

	//you cant test the compareTo method because it has to do with random Numbers
	@Test
	void testFindNumOfBeveType() {
		o2.addNewBeverage("Berry Mix", Size.SMALL, 3, false);//3.5
		o2.addNewBeverage("Mango", Size.MEDIUM, 1, true); //5.0
		o2.addNewBeverage("Arabic", Size.MEDIUM, true, true); // 4.0
		assertEquals(2, o2.findNumOfBeveType(Type.SMOOTHIE));
		assertEquals(1,o2.findNumOfBeveType(Type.COFFEE));
		assertEquals(0,o2.findNumOfBeveType(Type.ALCOHOL));
		
		o.addNewBeverage("Alcohol", Size.MEDIUM); //3.6
		o.addNewBeverage("Mocha", Size.SMALL, false, true); //2.5
		o.addNewBeverage("Strawberry Bannana Smoothie", Size.LARGE, 2, true);//6.5
		assertEquals(1,o.findNumOfBeveType(Type.SMOOTHIE));
		assertEquals(1,o.findNumOfBeveType(Type.ALCOHOL));
		assertEquals(1,o.findNumOfBeveType(Type.COFFEE));
	}

	//you cant create a generate Order junit test because the numbers are always randomized/.

	@Test
	void testGetBeverage() {
		o.addNewBeverage("Alcohol", Size.MEDIUM); //3.6
		o.addNewBeverage("Mocha", Size.SMALL, false, true); //2.5
		o.addNewBeverage("Strawberry Bannana Smoothie", Size.LARGE, 2, true);//6.5
		assertEquals("Beverage name: Alcohol\nSize: "+ o.getBeverage(0).getSize() +"\nWeekend: true\nPrice: 3.6",o.getBeverage(0).toString());
		assertEquals("Beverage name: Mocha\nSize: "+ o.getBeverage(1).getSize() + "\nExtra Shot: false\nExtra Syrup: true\nPrice: 2.5",o.getBeverage(1).toString());
		assertEquals("Beverage name: Strawberry Bannana Smoothie\nSize: "+ o.getBeverage(2).getSize() +"\nProtein Added: true\nNumber of Fruits: 2\nPrice: 6.5",o.getBeverage(2).toString());
	}

	@Test
	void testGetCustomer() {
		assertEquals("Name: Majd\nAge: 18", o.getCustomer().toString());
	}

	@Test
	void testGetDay() {
		assertEquals(Day.SATURDAY,o.getOrderDay());
		assertEquals(Day.MONDAY,o2.getOrderDay());
	}

	@Test
	void testGetOrderDay() {
		assertEquals(Day.SATURDAY,o.getOrderDay());
		assertEquals(Day.MONDAY,o2.getOrderDay());
	}

	@Test
	void testGetOrderTime() {
		assertEquals(17,o.getOrderTime());
		assertEquals(29,o2.getOrderTime());
	}

	@Test
	void testGetTotalItems() {
		o.addNewBeverage("Alcohol", Size.MEDIUM); //3.6
		o.addNewBeverage("Mocha", Size.SMALL, false, true); //2.5
		o.addNewBeverage("Strawberry Bannana Smoothie", Size.LARGE, 2, true);//6.5
		assertEquals(3,o.getTotalItems());
		
		o2.addNewBeverage("Berry Mix", Size.SMALL, 3, false);//3.5
		o2.addNewBeverage("Mango", Size.MEDIUM, 1, true); //5.0
		o2.addNewBeverage("Arabic", Size.MEDIUM, true, true); // 4.0
		assertEquals(3,o2.getTotalItems());
	}

	//you cant create a generate Order junit test because the numbers are always randomized/.

	@Test
	void testIsWeekend() {
		assertTrue(o.isWeekend());
		assertFalse(o2.isWeekend());
	}

	@Test
	void testToString() {
		o.addNewBeverage("Alcohol", Size.MEDIUM); //3.6
		assertEquals("Order Number: " + o.getOrderNo() +"\nTime: 17\nDay: " + o.getDay() + 
				"\nCustomer Name: Majd\nAge: 18\nBeverage name: Alcohol\nSize: " + o.getBeverage(0).getSize()
				+ "\nWeekend: true\nPrice: 3.6\nTotal: 3.6",o.toString());
	}
}
