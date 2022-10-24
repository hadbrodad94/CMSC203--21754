/*
 * Class: CMSC203 
 * Instructor:Grinberg
 * Description: Designs a Property Management that collects the plot, property and combines it together in an organized fashion.
 * Due: 10/24/22
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here:Majd Haddad
*/


public class ManagementCompany {
	public final int MAX_PROPERTY = 5;
	public final int MGMT_DEPTH = 10;
	public final int MGMT_WIDTH = 10;
	
	private String name;
	private String taxID;
	private double mgmFee;
	private Plot plot;
	private Property[] property;
	private int numberOfProperties;
	
	public ManagementCompany() {
		this.name = "";
		this.taxID = "";
		this.mgmFee = 0.0;
		this.plot = new Plot(0,0,MGMT_WIDTH,MGMT_DEPTH);
		this.property = new Property[MAX_PROPERTY];
	}
	/**
	 * 
	 * @param name
	 * @param taxID
	 * @param mgmFee
	 * Constructor
	 * Default Constructor for ManagementCompany
	 */
	public ManagementCompany(String name, String taxID, double mgmFee) {
		this.name = name;
		this.taxID = taxID;
		this.mgmFee = mgmFee;
		this.property = new Property[MAX_PROPERTY];
		this.plot = new Plot(0,0,MGMT_WIDTH,MGMT_DEPTH);
	}
	/**
	 * 
	 * @param name
	 * @param taxID
	 * @param mgmFee
	 * @param x
	 * @param y
	 * @param width
	 * @param depth
	 * Constructor 
	 * default constructor for ManagementCompany
	 */
	public ManagementCompany(String name, String taxID, double mgmFee, int x, int y, int width, int depth) {
		this.name = name;
		this.taxID = taxID;
		this.mgmFee = mgmFee;
		this.plot = new Plot(x,y,width, depth);
		this.property = new Property[MAX_PROPERTY];
	}
	/**
	 * 
	 * @param otherCompany
	 * @return copied the elements of other company. Deep Copy.
	 */
	public ManagementCompany(ManagementCompany otherCompany) {
		this.name = otherCompany.name;
		this.taxID = otherCompany.taxID;
		this.mgmFee = otherCompany.mgmFee;
		this.plot = new Plot(otherCompany.plot);
		this.property = new Property[MAX_PROPERTY];
	}
	/**
	 * @param name
	 * @param city
	 * @param rent
	 * @param owner
	 * @return the property expectations when its null, when it doesnt encompass, when it overlaps and returns the subscript of the element that is not null given the parameters
	 */
	public int addProperty(String name, String city, double rent, String owner) {
		return addProperty( new Property(name,city,rent,owner));
		
	}
	/**
	 * 
	 * @param property
	 * @return the property expectations when its null, when it doesnt encompass, when it overlaps and returns the subscript of the element that is not null.
	 */
	public int addProperty(Property property) {
	//if the property is null, returns -2
		if(this.property == null) {
			return -2;
		}
		//if property does not encompass the other property, then return -3
		else if(!this.plot.encompasses(property.getPlot())) {
			return -3;
		}
		//for every property, if the property is not null and it overlaps, return -4. if not, return the element i.
		for(int i = 0; i < this.property.length;i++) {
			if(this.property[i] != null) {
				if(this.property[i].getPlot().overlaps(property.getPlot())) {
					return -4;
				}
			}
			else {
				this.property[i]=property;
				return i;
			}
		}
		
		return -1;
	
	}
	/**
	 * 
	 * @param name
	 * @param city
	 * @param rent
	 * @param owner
	 * @param x
	 * @param y
	 * @param width
	 * @param depth
	 * @return a new property with the following parameters. Uses addProperty method from above to return the number significant to the numbers added.
	 */
	public int addProperty(String name, String city, double rent, String owner, int x, int y, int width, int depth) {
		return addProperty(new Property(name,city,rent,owner,x,y,width,depth));
	}
	public Property getHighestRentPropperty() {
		//gets the property in the array with the maximum amount of rent
		int propertyIndex=0;
		double highest = 0.0;
		
		for(int i = 0; i< MAX_PROPERTY;i++) {
			if(property[i] != null && property[i].getRentAmount()> highest){
			
				highest = property[i].getRentAmount();
				propertyIndex=i;
			
		}
	}
	return property[propertyIndex];

	
	}
	/**
	 * 
	 * @return the management fee from ManagementCompany
	 */
	public double getMgmFeePer() {
		//gets the management fee per
		return mgmFee;
	}
	/**
	 * 
	 * @return the the name from ManagementCompany
	 */
	public String getName() {
		return name;
	}
	/**
	 * 
	 * @return the plot from ManagementCompany
	 */
	public Plot getPlot() {
		return plot;
	}
	/**
	 * 
	 * @return the properties array from ManagementCompany
	 */
	public Property [] getProperties() {
		return property;
	}
	/**
	 * 
	 * @return the property count from ManagementCompany
	 */
	public int getPropertiesCount() {
		//gets the number of existing properties in the array
		int counter = 0;
		for(int i = 0; i < property.length; i++) {
			if(property[i]!=null){
				counter++;
			}
		}
		return counter;
	}
	/**
	 * 
	 * @return the taxID from ManagementCompany
	 */
	public String getTaxID() {
		return taxID;
	}
	/**
	 * 
	 * @return the total rent from every property in the ManagementCompany
	 */
	public double getTotalRent() {
		//returns the total rent of the properties in the properties array
		double total = 0.0;
		for(int i = 0; i < property.length; i++) {
			if(property[i]!= null){
				total += property[i].getRentAmount();
			}
		}
		return total;
	}
	/**
	 * 
	 * @return true if the managementFee is within 0-100 and false otherwise
	 */
	public boolean isManagementFeeValid() {
		//checks if the management company has a valid (between 0-100) fee
		if(this.getMgmFeePer()>= 0 && getMgmFeePer() <= 100) {
			return true;
		}else {
			return false;
		}
	}
	/**
	 * 
	 * @return true if the number of properties in a managementcompany is over 5 and false otherwise.
	 */
	public boolean isPropertiesFull() {
		//checks if the properties array has reached the maximum capacity
		boolean isFull = false;
		int numOfProperties = property.length;
		if(numOfProperties > 5) {
			isFull = true;
		}
		return isFull;
	}
	/**
	 * 
	 * @return void.
	 */
	public void removeLastProperty() {
		//removes(nullifies) the LAST property in the properties array
		int lastProperty = property.length;
		property[lastProperty-1] = null;
	}
	/**
	 * 
	 * @return the String of every field in this class.
	 */
	public String toString() {
		String str = "List of the properties for " + this.getName() + ", taxID: " + this.getTaxID() + "\n" 
		+ "______________________________________________________\n";
		
		for(int i = 0; i < property.length; i++){
			str+= property[i] + "\n";
		}
		
		str+= "______________________________________________________\n"
				+ "\n"
				+ "total management Fee: " + (this.getTotalRent() * (this.mgmFee/100));
		return str;
	}
}
