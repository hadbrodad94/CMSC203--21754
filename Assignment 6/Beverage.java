//abstract class
public abstract class Beverage {
	private String bevName;
	private Type type;
	private Size size;
	private final double basePrice = 2.0;
	private final double sizePrice = 1.0;
	
	public Beverage(String bV, Type t, Size s) {
		this.bevName = bV;
		this.type = t;
		this.size = s;
	}
	
	public double getBasePrice() {
		return basePrice;
	}
	public double getSizePrice() {
		return sizePrice;
	}
	public Type getType() {
		return type;
	}
	public String getBevName() {
		return bevName;
	}
	public Size getSize() {
		return size;
	}
	public double addSizePrice() {
		double price = basePrice;
		if(this.getSize() == Size.MEDIUM) {
			price += sizePrice;
		}else if(this.getSize() == Size.LARGE) {
			price += sizePrice *2;
		}
		return price;
	}
	
	public String toString() {
		String str = "Beverage name: " + this.getBevName() + "\nSize: " + this.getSize();
		return str;
	}
	public boolean equals(Beverage anotherBev) {
		if(this.bevName == anotherBev.getBevName() && this.size == anotherBev.getSize() && this.type == anotherBev.type) {
			return true;
		}else {
			return false;
		}
	}
	
	public abstract double calcPrice();
}
