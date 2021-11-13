package application;

public class Hawaiian extends Pizza {

	public Hawaiian() {
		
	}
	@Override
	public void calculatePrice() {
		double price = 0;
		
		//small is $10.99, medium is $12.99, large is $14.99
		//$1.49 for each additional topping, up to 2 toppings
		if (String.valueOf(this.getSize()).equals("SMALL")) {
			price = 10.99;
		} else if (String.valueOf(this.getSize()).equals("MEDIUM")) {
			price = 12.99;
		} else {
			price = 14.99;
		}
		
		if (this.getNoToppings() > 2) {
			int i = this.getNoToppings() - 2;
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
		return str + " : HAWAIIAN";
	}
}
