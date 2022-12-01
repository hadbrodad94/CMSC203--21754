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
import java.util.Random;
import java.util.ArrayList;
public class Order implements OrderInterface,Comparable<Order> {
	private int orderTime; 
	private Day orderDay;
	private Customer cust;
	private int orderNo;
	private ArrayList<Beverage> beverages;
	//static int numOrders = 0;
	
	//constructor used to get the fields of the private instances, create a list of beverages
	//and an order number which is a method 
	public Order(int orderTime, Day orderDay, Customer cust){
		this.orderTime = orderTime;
		this.orderDay = orderDay;
		this.cust = new Customer(cust);
		this.beverages = new ArrayList<Beverage>();
		this.orderNo = this.generateOrder();
	}
	//adds beverage for alcohol
	//Artraylist adds it and the numOrders++ is a static to keep track of how many calls.
	//An alernative way to do it is to just call the beverages.size() in the method corresponding to the thing.
	public void addNewBeverage(String bevName, Size size) {
		beverages.add(new Alcohol(bevName, size, this.isWeekend()));
		//numOrders++;
	}
	//adds beverage for coffee
	public void addNewBeverage(String bevName, Size size, boolean extraShot, boolean extraSyrup) {
		
		beverages.add(new Coffee(bevName,size,extraShot,extraSyrup));
		//numOrders++;
	}
	//adds beverage for Smoothie
	//overloading methods
	public void addNewBeverage(String bevName, Size size, int numOfFruits, boolean addProtein) {
		beverages.add(new Smoothie(bevName, size, numOfFruits, addProtein));
		//numOrders++;
	}
	// caclulates and returns the total amount for this order
	public double calcOrderTotal() {
		double price = 0.0;
		for(int i = 0; i < beverages.size(); i++) {
			price += beverages.get(i).calcPrice();
		}
		return price;
	}
	//compar5es the order number to see if they are equal, which returns 0
	//if first one is greater than the second, then its 1 and if less than returns -1
	@Override
	public int compareTo(Order anotherOrder) {
		if(this.orderNo > anotherOrder.orderNo) {
			return 1;
		}else if(this.orderNo < anotherOrder.orderNo) {
			return -1;
		}
		return 0;
	}
	public int findNumOfBeveType(Type type) {
		int count = 0;
		for(int i =0; i < beverages.size(); i++) {
			if(beverages.get(i).getType() == type) {
				count++;
			}
		}
		return count;
	}
	//generates order number from 10000 and 90000
	//rand.nextInt(upper - lower) + lower;
	public int generateOrder() {
		Random r = new Random();
		//creates a random generator from (0,80000) and adds 10000 to 
		//make the random number from (10000,90000)
		int randNumGenerator = r.nextInt(90000) + 10000;
		return randNumGenerator;
	}
	
	//getters
	//gets the order number for the beverage
	public Beverage getBeverage(int itemNo) {
		return beverages.get(itemNo);
	}
	public Customer getCustomer() {
		return new Customer(cust);
	}
	//is this the same as getOrderDay?
	public Day getDay() {
		return orderDay;
	}
	public Day getOrderDay() {
		return orderDay;
	}
	public int getOrderTime() {
		return orderTime;
	}
	//can use beverages.size();
	public int getTotalItems() {
		return beverages.size();
	}
	public int getOrderNo() {
		return orderNo;
	}
	public boolean isWeekend() {
		if(orderDay == Day.SATURDAY || orderDay == Day.SUNDAY) {
			return true;
		}else {
			return false;
		}
	}
	//toString displays order num, time, day, customer name and age, as well as all the listed beverages and their total.
	public String toString() {
		String str = "Order Number: " + this.getOrderNo() + "\nTime: " + this.getOrderTime() 
		+"\nDay: "+ this.getDay() + "\nCustomer " + this.getCustomer().toString()
		+"\n";
		for(Beverage b : beverages) {
			str += b.toString();
		}
		str += "\nTotal: " + this.calcOrderTotal();
		return str;
	}
	//setters just in case
	public void setCust(Customer cust) {
		this.cust = cust;
	}
//	public static void setNumOrders(int numOrders) {
//		Order.numOrders = numOrders;
//	}
	public void setOrderTime(int orderTime) {
		this.orderTime = orderTime;
	}
	public void setOrderDay(Day orderDay) {
		this.orderDay = orderDay;
	}
	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}
	public ArrayList<Beverage> getBeverages() {
		return beverages;
	}
	public void setBeverages(ArrayList<Beverage> beverages) {
		this.beverages = beverages;
	}
	
	
}
