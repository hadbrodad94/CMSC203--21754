import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BevShopTestStudent {
	BevShop bs;
	@BeforeEach
	void setUp() throws Exception {
		bs = new BevShop();
	}

	@AfterEach
	void tearDown() throws Exception {
		bs = null;
	}

//	@Test
//	void testBevShop() {
//		fail("Not yet implemented");
//	}

	@Test
	void testIsValidTime() {
		assertTrue(bs.isValidTime(8));
		assertFalse(bs.isValidTime(5));
		assertFalse(bs.isValidTime(57));
		assertTrue(bs.isValidTime(23));
	}

	@Test
	void testIsMaxFruit() {
		assertFalse(bs.isMaxFruit(3));
		assertTrue(bs.isMaxFruit(20));
		assertFalse(bs.isMaxFruit(5));
	}

	@Test
	void testIsEligibleForMore() {
		BevShop bsa = new BevShop();
		bsa.startNewOrder(12, Day.MONDAY, "Msj", 23);
		bsa.processAlcoholOrder("a1", Size.SMALL);
		assertTrue(bsa.isEligibleForMore());
		bsa.processAlcoholOrder("a2", Size.SMALL);
		assertTrue(bsa.isEligibleForMore());
		bsa.processAlcoholOrder("a3", Size.SMALL);
		assertTrue(bsa.isEligibleForMore());
	}

	@Test
	void testIsValidAge() {
		assertFalse(bs.isValidAge(17));
		assertTrue(bs.isValidAge(27));
		assertFalse(bs.isValidAge(18));
		assertTrue(bs.isValidAge(87));
	}

	@Test
	void testGetMaxNumOfFruits() {
		assertEquals(5,bs.getMaxNumOfFruits());
	}

	@Test
	void testGetMinAgeForAlcohol() {
		assertEquals(21,bs.getMinAgeForAlcohol());
	}

	@Test
	void testGetMaxOrderForAlcohol() {
		assertEquals(3,bs.getMaxOrderForAlcohol());
	}

	@Test
	void testGetNumOfAlcoholDrink() {
		BevShop bsa = new BevShop();
		bsa.startNewOrder(13, Day.SUNDAY, "Hana", 30);
		bsa.processAlcoholOrder("a1", Size.MEDIUM);
		assertEquals(1,bsa.getNumOfAlcoholDrink());
		bsa.processAlcoholOrder("a2", Size.LARGE);
		assertEquals(2,bsa.getNumOfAlcoholDrink());
		
	}

	@Test
	void testGetCurrentOrder() {
		bs.startNewOrder(18, Day.MONDAY, "James", 34);
		bs.processSmoothieOrder("Rise and Shine", Size.MEDIUM, 3, false);

		assertEquals(bs.getOrderAtIndex(0), bs.getCurrentOrder());
	}

	@Test
	void testGetOrderAtIndex() {
		BevShop bsa = new BevShop();
		bsa.startNewOrder(11, Day.SATURDAY, "Jorge", 20);
		bsa.processCoffeeOrder("Capuccino", Size.LARGE, true, false);
		assertEquals(bsa.getCurrentOrder(),bsa.getOrderAtIndex(0));
		
		bsa.processSmoothieOrder("tasty", Size.SMALL, 1, false);
		//System.out.println(bsa.getCurrentOrder());
		
	}

	@Test
	void testStartNewOrder() {
		bs.startNewOrder(8,Day.MONDAY,"John", 30);
		assertEquals(8, bs.getCurrentOrder().getOrderTime());
		assertEquals(Day.MONDAY, bs.getCurrentOrder().getOrderDay());
		assertEquals(8, bs.getCurrentOrder().getOrderTime());
		assertEquals("John", bs.getCurrentOrder().getCustomer().getName());
		assertEquals(30, bs.getCurrentOrder().getCustomer().getAge());
		assertEquals(0,bs.getNumOfAlcoholDrink());
		assertTrue(bs.getCurrentOrder().getTotalItems() == 0);
	}

	@Test
	void testProcessCoffeeOrder() {
		
		bs.startNewOrder(14,Day.MONDAY,"Rakesh", 19);
		bs.processCoffeeOrder("Arabic", Size.LARGE, true, false);
		assertTrue(bs.getCurrentOrder().getTotalItems() == 1);
		
		Coffee c = (Coffee) bs.getCurrentOrder().getBeverage(0);
		assertTrue(bs.getCurrentOrder().getBeverage(0).getBevName().equals("Arabic"));
		assertTrue(bs.getCurrentOrder().getBeverage(0).getSize().equals(Size.LARGE));
		assertTrue(bs.getCurrentOrder().getBeverage(0).getType().equals(Type.COFFEE));
		assertTrue(c.getExtraShot()); 
		assertFalse(c.getExtraSyrup()); 
		
		bs.processCoffeeOrder("Turkish", Size.MEDIUM, false, true);
		c = (Coffee) bs.getCurrentOrder().getBeverage(1);
		assertFalse(c.getExtraShot());
		assertTrue(c.getExtraSyrup());
		
		assertTrue(bs.getCurrentOrder().getTotalItems() == 2);
		assertTrue(bs.getCurrentOrder().getBeverage(1).getBevName().equals("Turkish"));
		assertTrue(bs.getCurrentOrder().getBeverage(1).getSize().equals(Size.MEDIUM));
		assertTrue(bs.getCurrentOrder().getBeverage(1).getType().equals(Type.COFFEE));
		
	}

	@Test
	void testProcessAlcoholOrder() {
		bs.startNewOrder(20,Day.MONDAY,"Omar", 11);
		
		//used to check if age is right
		assertFalse(bs.isValidAge(11));
		assertTrue(bs.isValidAge(25));
		
		bs.processAlcoholOrder("A1", Size.SMALL);
		assertTrue(bs.getCurrentOrder().getTotalItems() == 1);
		assertTrue(bs.getCurrentOrder().getBeverage(0).getBevName().equals("A1"));
		assertTrue(bs.getCurrentOrder().getBeverage(0).getSize().equals(Size.SMALL));
		assertTrue(bs.getCurrentOrder().getBeverage(0).getType().equals(Type.ALCOHOL));	
		assertTrue(bs.isEligibleForMore());
		
		
		bs.processAlcoholOrder("A2", Size.MEDIUM);
		assertTrue(bs.getCurrentOrder().getTotalItems() == 2);
		assertTrue(bs.getCurrentOrder().getBeverage(1).getBevName().equals("A2"));
		assertTrue(bs.getCurrentOrder().getBeverage(1).getSize().equals(Size.MEDIUM));
		assertTrue(bs.getCurrentOrder().getBeverage(1).getType().equals(Type.ALCOHOL));	
		assertTrue(bs.isEligibleForMore());
		
		bs.processAlcoholOrder("A3", Size.LARGE);
		assertTrue(bs.getCurrentOrder().getTotalItems() == 3);
		assertTrue(bs.getCurrentOrder().getBeverage(2).getBevName().equals("A3"));
		assertTrue(bs.getCurrentOrder().getBeverage(2).getSize().equals(Size.LARGE));
		assertTrue(bs.getCurrentOrder().getBeverage(2).getType().equals(Type.ALCOHOL));	
		assertEquals(1,bs.totalNumOfMonthlyOrders());
	}

	@Test
	void testProcessSmoothieOrder() {
		bs.startNewOrder(20,Day.MONDAY,"Amy", 11);
		//since this method overlaps with smoothie, I included it just in case
		assertTrue(bs.isMaxFruit(6));
		assertFalse(bs.isMaxFruit(5));
		
		//creates smoothie order
		bs.processSmoothieOrder("Mango", Size.MEDIUM, 2, true);
		assertTrue(bs.getCurrentOrder().getTotalItems() == 1);
		assertTrue(bs.getCurrentOrder().getBeverage(0).getBevName().equals("Mango"));
		assertTrue(bs.getCurrentOrder().getBeverage(0).getSize().equals(Size.MEDIUM));
		assertTrue(bs.getCurrentOrder().getBeverage(0).getType().equals(Type.SMOOTHIE));	
		
		bs.processSmoothieOrder("Lemon", Size.MEDIUM, 6, true);
		assertTrue(bs.getCurrentOrder().getTotalItems() == 2);
		assertTrue(bs.getCurrentOrder().getBeverage(1).getBevName().equals("Lemon"));
		assertTrue(bs.getCurrentOrder().getBeverage(1).getSize().equals(Size.MEDIUM));
		assertTrue(bs.getCurrentOrder().getBeverage(1).getType().equals(Type.SMOOTHIE));	
	}

	@Test
	void testFindOrder() {
		bs.startNewOrder(10, Day.SATURDAY, "Morry", 29);
		assertEquals(0, bs.findOrder(bs.getCurrentOrder().getOrderNo()));
		bs.startNewOrder(20, Day.MONDAY, "Rat", 20);
		assertEquals(1, bs.findOrder(bs.getCurrentOrder().getOrderNo()));
		bs.startNewOrder(35, Day.WEDNESDAY, "Mouse", 21);
		assertEquals(2, bs.findOrder(bs.getCurrentOrder().getOrderNo()));
		
	}

	@Test
	void testTotalOrderPrice() {
		bs.startNewOrder(24, Day.MONDAY, "Majd", 18);
		bs.processCoffeeOrder("mn", Size.MEDIUM, true, false);//3.5
		bs.processSmoothieOrder("poow", Size.MEDIUM, 4, true);//6.5
		assertEquals(10.0, bs.totalOrderPrice(bs.getCurrentOrder().getOrderNo()));
		
	}

	@Test
	void testTotalMonthlySale() {
		bs.startNewOrder(20, Day.MONDAY, "Alan", 2);
		bs.processAlcoholOrder("A1", Size.SMALL);//2
		bs.processCoffeeOrder("Capp", Size.LARGE, true, false);//4.5
		bs.startNewOrder(17, Day.FRIDAY, "George", 2);
		bs.processAlcoholOrder("a2", Size.SMALL);//2
		assertEquals(8.5,bs.totalMonthlySale());
	}

	@Test
	void testTotalNumOfMonthlyOrders() {
		bs.startNewOrder(10, Day.MONDAY, "Moo", 12);
		bs.processCoffeeOrder("Capp", Size.LARGE, true, false);
		assertEquals(1,bs.totalNumOfMonthlyOrders());
		bs.startNewOrder(9, Day.FRIDAY,"Jorge", 12);
		bs.processAlcoholOrder("a1", Size.MEDIUM);
		assertEquals(2,bs.totalNumOfMonthlyOrders());
	}

	@Test
	void testSortOrders() {
		bs.startNewOrder(11, Day.FRIDAY, "Majd", 18);
		bs.startNewOrder(19, Day.MONDAY, "Latif", 19);
		bs.startNewOrder(17, Day.SATURDAY, "Shamsan", 12);
		bs.startNewOrder(15, Day.FRIDAY, "Hana", 20);
//		bs.processAlcoholOrder("Alcohol", Size.SMALL);
//		bs.processCoffeeOrder("Caramel Frappe", Size.MEDIUM, true, true);
		bs.sortOrders();
		assertTrue(bs.getOrderAtIndex(0).getOrderNo() < bs.getOrderAtIndex(1).getOrderNo());
		assertTrue(bs.getOrderAtIndex(1).getOrderNo() < bs.getOrderAtIndex(2).getOrderNo());
		assertTrue(bs.getOrderAtIndex(2).getOrderNo() < bs.getOrderAtIndex(3).getOrderNo());
		
	}

	@Test
	void testToString() {
		bs.startNewOrder(21,Day.MONDAY,"Perry", 20);
		bs.processCoffeeOrder("Arabic", Size.SMALL, true, false); 
		bs.processCoffeeOrder("Turkish", Size.LARGE, false, false); 
		
		assertTrue(bs.toString().contains( String.valueOf(bs.getOrderAtIndex(0).getOrderNo()) ));
		assertTrue(bs.toString().contains(bs.getOrderAtIndex(0).getCustomer().getName()) );
		assertTrue(bs.toString().contains(bs.getOrderAtIndex(0).getBeverage(0).getSize().toString()) )  ;
		assertTrue(bs.toString().contains(bs.getOrderAtIndex(0).getBeverage(0).getBevName()) );
		
		bs.startNewOrder(15,Day.SUNDAY,"Henry", 25);
		bs.processSmoothieOrder("Hex", Size.SMALL, 1, true);
		
		assertTrue(bs.toString().contains( String.valueOf(bs.getOrderAtIndex(1).getOrderNo()) ));
		assertTrue(bs.toString().contains(bs.getOrderAtIndex(1).getCustomer().getName()) );
		assertTrue(bs.toString().contains(bs.getOrderAtIndex(1).getBeverage(0).getSize().toString()) )  ;
		assertTrue(bs.toString().contains(bs.getOrderAtIndex(1).getBeverage(0).getBevName()) );
		
			
		
		
		assertTrue(bs.toString().contains( String.valueOf(bs.totalMonthlySale() )  ));
	}

}
