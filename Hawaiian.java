package application;

import java.text.DecimalFormat;

/**
This class defines the type Hawaiian, which is an extenstion of Pizza, with all of its attributes and methods
@author Emily Nelson, Cristofer Gomez-Martinez
*/
public class Hawaiian extends Pizza {

	private String orderNumber;
	private double thePrice;
	/**
	Empty constructor for a Hawaiian pizza
	@author Emily Nelson
	*/
	public Hawaiian() {
		
	}
	
	/**
	Calculates the price of a Hawaiian pizza
	@author Emily Nelson
	*/
	@Override
	public double price() {
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
		
		if (this.toppings.size() > 2) {
			int i = this.toppings.size() - 2;
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
	@return textual represential of pizza 
	@author Emily Nelson
	*/
	@Override 
	public String toString() {
		String str = super.toString();
		return "HAWAIIAN : " + str;
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
