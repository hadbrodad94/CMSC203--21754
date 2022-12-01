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
import java.util.ArrayList;
public class BevShop implements BevShopInterface {
	private ArrayList <Order> orders = new ArrayList<Order>();
	private int numAlcoholsInOrder;
	private int currentOrderIndex;
	
	public BevShop() {
		currentOrderIndex = 0;
		numAlcoholsInOrder = 0;
	}
	
	public boolean isValidTime(int time) {
		return (time >= MIN_TIME && time <= MAX_TIME);
	}
	
	public boolean isMaxFruit(int numOfFruits) {
		return (numOfFruits > MAX_FRUIT);
	}
	public boolean isEligibleForMore() {
		if(this.getNumOfAlcoholDrink() > MAX_ORDER_FOR_ALCOHOL) {
			return false;
		}else {
			return true;
		}
	}
	public boolean isValidAge(int age) {
		if(age >= MIN_AGE_FOR_ALCOHOL) {
			return true;
		}else {
			return false;
		}
	}
	//getters
	public int getMaxNumOfFruits() {
		return MAX_FRUIT;
	}

	public int getMinAgeForAlcohol() {
		return MIN_AGE_FOR_ALCOHOL;
	}

	public int getMaxOrderForAlcohol() {
		return MAX_ORDER_FOR_ALCOHOL;
	}

	public int getNumOfAlcoholDrink() {
		return numAlcoholsInOrder;
	}
	public Order getCurrentOrder() {
		int x = this.orders.size() -1;
		return this.orders.get(x);
	}
	
	public Order getOrderAtIndex(int index) {
		return orders.get(index);
	}
	public void startNewOrder(int time, Day day, String customerName, int customerAge) {
		Customer customer = new Customer(customerName,customerAge);
		Order tempOrder = new Order(time,day,customer);
		orders.add(tempOrder);
		numAlcoholsInOrder = 0;
		currentOrderIndex = 0;
	}

	public void processCoffeeOrder(String bevName, Size size, boolean extraShot, boolean extraSyrup) {
		getCurrentOrder().addNewBeverage(bevName,size,extraShot,extraSyrup);
	}

	public void processAlcoholOrder(String bevName, Size size) {
		if(this.isEligibleForMore()) {
			getCurrentOrder().addNewBeverage(bevName, size);
			this.numAlcoholsInOrder++;
		}
	}

	public void processSmoothieOrder(String bevName, Size size, int numOfFruits, boolean addProtein) {
		getCurrentOrder().addNewBeverage(bevName, size, numOfFruits, addProtein);
	}

	public int findOrder(int orderNo) {
		int indexFound = -1;
		for(int i = 0; i < orders.size(); i++) {
			if(orders.get(i).getOrderNo() == orderNo) {
				indexFound = i;
			}
		}
		return indexFound;
	}


	public double totalOrderPrice(int orderNo) {
		double price = 0.0;
		for(int i = 0; i < orders.size(); i++) {
			if(orders.get(i).getOrderNo() == orderNo) {
				price = orders.get(i).calcOrderTotal();
			}
		}
		return price;
	}

	public double totalMonthlySale() {
		double total = 0.0;
		for(Order o: orders) {
			total += o.calcOrderTotal();
		}
		return total;
	}

	public int totalNumOfMonthlyOrders() {
		return orders.size();
	}
	
	public void sortOrders() {
		//uses selection sort to go through ever element to see which order number is the smallest.
		//uses a nested loop
		for(int i = 0; i < orders.size(); i++) {
			for(int j =orders.size()- 1; j > i;j--) {
				if(orders.get(i).compareTo(orders.get(j)) == 1) {
					//does the swapping
					Order temp = orders.get(i);
					orders.set(i, orders.get(j));
					orders.set(j, temp);
				}
//				if(orders.get(j).getOrderNo() < orders.get(i).getOrderNo()) {
//					minIndex = j;
//				}
			}
		}
	}
	@Override
	public String toString() {
		String str = "";
		for(Order o : orders) {
			str += o.toString();
		}
		str += "\nTotal Monthly Sale: " +this.totalMonthlySale();
		return str;
	}

	
}
