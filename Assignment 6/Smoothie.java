
public class Smoothie extends Beverage{
	private int numOfFruits;
	private boolean addProtein;
	
	
	public Smoothie(String bevName, Size size, int nOF, boolean aP) {
		super(bevName,Type.SMOOTHIE,size);
		numOfFruits = nOF;
		addProtein = aP;
	}

	public int getNumOfFruits() {
		return numOfFruits;
	}

	public boolean isAddProtein() {
		return addProtein;
	}
	
	@Override
	public String toString() {
		return super.toString() + "\nProtein Added: " + this.isAddProtein() + "\nNumber of Fruits: " 
		+ this.getNumOfFruits() + "\nPrice: " + this.calcPrice();
	}

	@Override
	public double calcPrice() {
		double price = 0;
		final double priceOfEachFruit = .50;
		final double proteinPrice = 1.5;
		price = super.addSizePrice();
		for(int i = 1; i <= this.getNumOfFruits(); i++) {
			price+= priceOfEachFruit;
		}
		if(this.isAddProtein()) {
			price += proteinPrice;
		}
		return price;
	}
	
	@Override
	public boolean equals(Object o) {
		Smoothie s = (Smoothie)o;
		if(this.addProtein == s.addProtein && this.numOfFruits == s.numOfFruits && this.getBevName() == s.getBevName()
				&& this.getSize() == s.getSize() && this.getType() == s.getType()
				&& this.getBasePrice() == s.getBasePrice()) {
			return true;
		}else {
			return false;
		}
	}
}
