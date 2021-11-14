package application;

import java.text.DecimalFormat;

/**
This class defines the type Pepperoni, which is an extenstion of Pizza, with all of its attributes and methods
@author Emily Nelson, Cristofer Gomez-Martinez
*/
public class Pepperoni extends Pizza {

	private String orderNumber;
	private double thePrice;
	/**
	Empty constructor for a Pepperoni pizza
	@author Emily Nelson
	*/
	public Pepperoni() {
		
	}
	
	
	/**
	Calculates the price of a Pepperoni pizza
	@author Emily Nelson
	*/
	@Override
	public double price() {
		double price = 0;
		
		if (String.valueOf(this.size).equals("SMALL")) {
			price = 8.99;
		} else if (String.valueOf(this.size).equals("MEDIUM")) {
			price = 10.99;
		} else {
			price = 12.99;
		}
		
		if (this.toppings.size() > 1) {
			int i = this.toppings.size() - 1;
			while (i > 0) {
				price += 1.49;
				i--;
				
			}
		}

		DecimalFormat df = new DecimalFormat("0.00");
    	
    	price = Double.valueOf(df.format(price));

		this.thePrice = price;
		
		return price;
	}
	
	/**
	Returns the pizza in string form
	@return textual represential of pizza 
	@author Emily Nelson
	*/
	@Override
	public String toString() {
		String str = super.toString();
		return "PEPPERONI : " + str;
	}
	
}
