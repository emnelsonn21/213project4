package application;

public class Deluxe extends Pizza {

	public Deluxe() {
		
	}
	public Deluxe(String orderNumber, Size size, Toppings[] toppings, double price) {
		super(orderNumber, size, toppings, price);
	}
	
	@Override
	public void calculatePrice() {
		double price = 0;
		
		//small is $12.99, medium is $14.99, large is $16.99
		//$1.49 for each additional topping, up to 7 toppings
		if (String.valueOf(this.getSize()).equals("SMALL")) {
			price = 12.99;
		} else if (String.valueOf(this.getSize()).equals("MEDIUM")) {
			price = 14.99;
		} else {
			price = 16.99;
		}
		
		if (this.getNoToppings() > 5) {
			int i = this.getNoToppings() - 5;
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
		return str + " : DELUXE";
	}
	
	
}
