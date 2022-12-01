/*
 * Class: CMSC203 
 * Instructor: Professor Grinberg
 * Description: Creating a order of beverages program.
 * Due: 12/05/22
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Majd Haddad
*/

public class BevShopDriverApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int tempAge, tempOrderNo;

		Customer tempCustomer;
		int anInvalidTime = 8, anotherInvalidTime = 24;

		BevShop b = new BevShop();
		
		if ( !b.isValidTime(anInvalidTime))
			System.out.println( "Failed the test for invalid time!!"); 
		 
		if ( b.isValidTime(anotherInvalidTime))
			System.out.println( "Failed the test for invalid time!!");  
		
		System.out.println(b.getMaxOrderForAlcohol()); // 3
		System.out.println(b.getMinAgeForAlcohol()); // 21
		System.out.println("Start a new order"); // Start a new order
		b.startNewOrder(12, Day.MONDAY, "John", 23);

		System.out.println("Total on the Order:" + b.getCurrentOrder().calcOrderTotal()); // 0.0

		tempCustomer = b.getCurrentOrder().getCustomer();

		tempCustomer.setName("kim");
		tempCustomer.setAge(10);

		System.out.println(b.getCurrentOrder().getCustomer().getName()); // John
		System.out.println(b.getCurrentOrder().getCustomer().getAge()); // 23

		tempAge = b.getCurrentOrder().getCustomer().getAge();
		System.out.println(b.isValidAge(tempAge)); // true
		if (b.isValidAge(tempAge)) {
			System.out.println("Add alcohol drink"); // Add alcohol drink

			b.processAlcoholOrder("Mohito", Size.SMALL);
		}

		System.out.println("Total on the Order:" + b.getCurrentOrder().calcOrderTotal()); // 2.0
		System.out.println(b.isEligibleForMore()); // true

		System.out.println("Add second alcohol drink"); // Add second alcohol
														// drink
		b.processAlcoholOrder("tonic", Size.LARGE);
		System.out.println("Total on the Order:" + b.getCurrentOrder().calcOrderTotal()); // 6.0
		System.out.println(b.getNumOfAlcoholDrink()); // 2

		System.out.println("Add third alcohol drink"); // Add third alcohol
														// drink
		b.processAlcoholOrder("wine", Size.SMALL);

		System.out.println("Total on the Order:" + b.getCurrentOrder().calcOrderTotal()); // 8.0

		System.out.println(b.getNumOfAlcoholDrink()); // 3

		if (!b.isEligibleForMore())
			System.out.println("Maximum alcohol drink for this order"); // Maximum
																		// alcohol
																		// drink
																		// for
																		// this
																		// order

		System.out.println("Add a COFFEE to order"); // Add a COFFEE to order
		b.processCoffeeOrder("cappuchino", Size.SMALL, true, true);
		System.out.println(b.getNumOfAlcoholDrink()); // 3

		System.out.println("Total on the Order:" + b.getCurrentOrder().calcOrderTotal()); // 11.0
		tempOrderNo = b.getCurrentOrder().getOrderNo();

		if (b.findOrder(tempOrderNo) != -1) {
			System.out.println("Total on the Order:" + b.totalOrderPrice(tempOrderNo)); // 11.0
		}

		else

			System.out.println("order not found! Should not get to here!");

		System.out.println("Start a new order"); // Start a new order

		b.startNewOrder(10, Day.SUNDAY, "Mary", 12);

		System.out.println("Total on the Order:" + b.getCurrentOrder().calcOrderTotal()); // 0.0
		System.out.println("Add a SMOOTHIE to order"); // Add a SMOOTHIE to
														// order
		b.processSmoothieOrder("Morning Boost", Size.LARGE, 2, true);
		System.out.println("Total on the Order:" + b.getCurrentOrder().calcOrderTotal()); // 6.5
		System.out.println("Add a COFFEE to order");
		b.processCoffeeOrder("Latte", Size.MEDIUM, false, false);
		System.out.println("Total on the Order:" + b.getCurrentOrder().calcOrderTotal()); // 9.5
		System.out.println(b.getNumOfAlcoholDrink()); // 0
		if (b.isValidAge(b.getCurrentOrder().getCustomer().getAge())) {
			System.out.println("Should not get to here!!!");
			b.processAlcoholOrder("mohito", Size.MEDIUM);
		} else
			System.out.println("Age not appropriate for alcohol drink!!"); // Age
																			// not
																			// appropriate
																			// for
																			// alcohol
																			// drink!!

		tempOrderNo = b.getCurrentOrder().getOrderNo();

		if (b.findOrder(tempOrderNo) != -1)
			System.out.println("Total on the Order:" + b.totalOrderPrice(tempOrderNo)); // 9.5
		else {
			System.out.println("Order not found. Should no get to here!!");
		}

		int numOfFruits = 6;
		if (b.isMaxFruit(numOfFruits)) {
			// Maximum number of fruits
			System.out.println("Maximum number of fruits\n"); // Maximum number
																// of fruits
		}
		numOfFruits = 5;

		b.processSmoothieOrder("Detox", Size.LARGE, numOfFruits, false);
		System.out.println("Total on the Order:" + b.getCurrentOrder().calcOrderTotal()); // 16.0
		System.out.println("Total amount for all orders:" + b.totalMonthlySale()); // 27.0
		
		
		for (int i =0; i< 7; i++) 
		{
		
			for (int j = 7; j > i; j--)
			{
				System.out.print("*");
			}
			
			System.out.println();
		}
		
		for (int i = 0; i <= 7; i++) 
		{
		      for (int j = 0; j < i; j++) {
		        System.out.print("*");
		      }
		      System.out.println();
		    }
		
		int[] bb = {4,7,2,9,1};
		
		swap(bb);
	
		
		  }
	public static void swap (int[] bro) {
		int temp, j;
		for (int i =1; i < bro.length; i++)
		{
			temp = bro[i];
			
			j= i-1;
			while(j>= 0 && bro[j] > temp)
			{
				bro[j+1] = bro[j];
				j--;
			}
			
			bro[j+1] =temp;
		}
		
		for(int i =0; i<bro.length; i++) {
			System.out.print(bro[i] + ", ");
		}
		}

//		BevShop bs = new BevShop();
//		
//		Order o = new Order(11, Day.FRIDAY,new Customer("Majd", 18));
//		Order o2 = new Order(13,Day.SATURDAY, new Customer("Latif", 23));
//		
//		Coffee c = new Coffee("Caramel Frappe", Size.MEDIUM, false,true);
//		System.out.println("Adding Coffee:");
//		System.out.println();
//		o.addNewBeverage("Caramel Frappe", Size.MEDIUM, false, true); //3.5
//		System.out.println(o.getBeverage(0).toString());
//		
//		System.out.println("Adding alcohol:");
//		System.out.println();
//		o.addNewBeverage("Alcohol", Size.SMALL); //2
//		System.out.println(o.getBeverage(1).toString());
//		
//		System.out.println("Adding Smoothie:");
//		System.out.println();
//		
//		o.addNewBeverage("Mango", Size.SMALL, 1, true); //4
//		System.out.println(o.getBeverage(2).toString());
//		
//		System.out.println(o.calcOrderTotal());
//		
//		
//		bs.startNewOrder(15, Day.MONDAY, "Majd", 18);
//		bs.processCoffeeOrder("Caramel Frappe", Size.MEDIUM, false, true);
//		bs.processAlcoholOrder("Alcohol", Size.SMALL);
//		bs.processSmoothieOrder("Mango", Size.SMALL, 1, true);
//		bs.processAlcoholOrder("Alcohol2", Size.LARGE);
//		bs.processAlcoholOrder("Alcohol3", Size.MEDIUM);
//		bs.processAlcoholOrder("Alcohol4", Size.SMALL);
//		
//		
//		bs.startNewOrder(12, Day.SATURDAY, "Latif", 27);
//		bs.processCoffeeOrder("Arabic", Size.MEDIUM, false, false);
//		
//		System.out.println(bs.totalNumOfMonthlyOrders());
//		System.out.println(bs.totalMonthlySale());
//		
//		
////		System.out.println("Start a new Order");
////		System.out.println("Add alcohol drink");
////		bv.startNewOrder(11, Day.FRIDAY,"John", 23);
////		bv.processAlcoholOrder("Alcohol", Size.SMALL);
////		System.out.println("Add second alcohol drink");
////		bv.processAlcoholOrder("Alcohol2",Size.LARGE);
////		System.out.println("Add third alcohol drink");
////		bv.processAlcoholOrder("Alcohol3", Size.SMALL);
////		
//				
//		System.out.println("Programmer: Majd Haddad");
	}


