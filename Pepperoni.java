package application;

public class Pepperoni extends Pizza {

	public Pepperoni() {
		
	}
	public Pepperoni(String orderNumber, Size size, Toppings[] toppings, double price) {
		super(orderNumber, size, toppings, price);
	}
	
	@Override
	public void calculatePrice() {
		double price = 0;
		
		if (String.valueOf(this.getSize()).equals("SMALL")) {
			price = 8.99;
		} else if (String.valueOf(this.getSize()).equals("MEDIUM")) {
			price = 10.99;
		} else {
			price = 12.99;
		}
		
		if (this.getNoToppings() > 1) {
			int i = this.getNoToppings() - 1;
			while (i > 0) {
				price += 1.49;
				i--;
				
			}
		}

		this.setPrice(price);
	}
	
	@Override
	public String toString() {
		String str = super.toString();
		return str + " : PEPPERONI";
	}
}
