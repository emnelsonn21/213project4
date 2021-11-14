package application;
/**
This class defines the type Deluxe, which is an extenstion of Pizza, with all of its attributes and methods
@author Emily Nelson, Cristofer Gomez-Martinez
*/
public class Deluxe extends Pizza {
	
	/**
	Empty constructor for a Deluxe pizza
	@author Emily Nelson
	*/
	public Deluxe() {
		
	}
	
	/**
	Constructor for a Deluxe pizza
	Creates a type Pizza for this student
	@param orderNumber the order number to set 
	@param size the size of pizza to set
	@param toppings the toppings of the pizza to set
	@param price the price of the pizza to set
	@author Emily Nelson
	*/
	public Deluxe(String orderNumber, Size size, Toppings[] toppings, double price) {
		super(orderNumber, size, toppings, price);
	}
	
	/**
	Calculates the price of a Deluxe pizza
	@author Emily Nelson
	*/
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
	
	/**
	Returns the pizza in string form
	@return textual represential of pizza 
	@author Emily Nelson
	*/
	@Override
	public String toString() {
		String str = super.toString();
		return str + " : DELUXE";
	}
	
	
}
