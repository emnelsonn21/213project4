package application;
/**
This class defines the type Pepperoni, which is an extenstion of Pizza, with all of its attributes and methods
@author Emily Nelson, Cristofer Gomez-Martinez
*/
public class Pepperoni extends Pizza {
	
	/**
	Empty constructor for a Pepperoni pizza
	@author Emily Nelson
	*/
	public Pepperoni() {
		
	}
	
	/**
	Constructor for a Pepperoni pizza
	Creates a type Pizza for this student
	@param orderNumber the order number to set 
	@param size the size of pizza to set
	@param toppings the toppings of the pizza to set
	@param price the price of the pizza to set
	@author Emily Nelson
	*/
	public Pepperoni(String orderNumber, Size size, Toppings[] toppings, double price) {
		super(orderNumber, size, toppings, price);
	}
	
	/**
	Calculates the price of a Pepperoni pizza
	@author Emily Nelson
	*/
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
	
	/**
	Returns the pizza in string form
	@return textual represential of pizza 
	@author Emily Nelson
	*/
	@Override
	public String toString() {
		String str = super.toString();
		return str + " : PEPPERONI";
	}
}
