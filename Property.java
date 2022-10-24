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
public class Property {
	private String propertyName;
	private String city;
	private double rentAmount;
	private String owner;
	private Plot plot;
	
	public Property(){
		propertyName = "";
		city = "";
		rentAmount = 0.0;
		owner = "";
		plot = new Plot();
	}
	public Property(String propertyName, String city, double rentAmount, String owner) {
		this.propertyName = propertyName;
		this.city = city;
		this.rentAmount = rentAmount;
		this.owner = owner;
		plot=new Plot ();
	}
	public Property(String propertyName, String city, double rentAmount, String owner, int x, int y, int width, int depth) {
		this.propertyName = propertyName;
		this.city = city;
		this.rentAmount = rentAmount;
		this.owner = owner;
		this.plot = new Plot(x, y, width, depth);
	}
	public Property(Property otherProperty) {
		this.propertyName = otherProperty.propertyName;
		this.city= otherProperty.city;
		this.rentAmount = otherProperty.rentAmount;
		this.owner = otherProperty.owner;
		this.plot = new Plot(otherProperty.plot);
	}
	public String getCity() {
		return city;
	}
	public String getOwner() {
		return owner;
	}
	public Plot getPlot() {
		return plot;
	}
	public String getPropertyName() {
		return propertyName;
	}
	public double getRentAmount() {
		return this.rentAmount;
	}
	public String toString() {
		String str = propertyName + "," + city + "," + owner + "," + rentAmount;
		return str;
	}
}
