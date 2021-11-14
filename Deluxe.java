package application;

import java.text.DecimalFormat;

/**
This class defines the type Deluxe, which is an extenstion of Pizza, with all of its attributes and methods
@author Emily Nelson, Cristofer Gomez-Martinez
*/
public class Deluxe extends Pizza {

	private String orderNumber;
	private double thePrice;
	
	/**
	Empty constructor for a Deluxe pizza
	@author Emily Nelson
	*/
	public Deluxe() {
		
	}

	/**
	Calculates the price of a Deluxe pizza
	@author Emily Nelson
	*/
	@Override
	public double price() {
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
		
		if (this.toppings.size() > 5) {
			int i = this.toppings.size() - 5;
			while (i > 0) {
				price += 1.49;
				i--;
				
			}
		}

		DecimalFormat df = new DecimalFormat("0.00");
    	
    		price = Double.valueOf(df.format(price));

		this.setPrice(price);
		return price;
	}
	
	/**
	Returns the pizza in string form
	@return textual representation of pizza 
	@author Emily Nelson
	*/
	@Override
	public String toString() {
		String str = super.toString();
		return "DELUXE : " + str;
	}
	
	
	/**
	 * Sets price of pizza
	 * @param price
	 * @author Emily Nelson
	 */
	public void setPrice(double price) {
		this.thePrice = price;
	}
	
}
