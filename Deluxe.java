package application;
import java.text.DecimalFormat;
/**
This class defines the type Deluxe, which is an extenstion of Pizza, with all of its attributes and methods
@author Emily Nelson, Cristofer Gomez-Martinez
*/
public class Deluxe extends Pizza {

	private String orderNumber;
	private double thePrice;
	static final double smallPrice = 12.99;
	static final double medPrice = 14.99;
	static final double largePrice = 16.99;
	static final double toppingPrice = 1.49;
	static final int defaultToppings = 5;

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
		if (String.valueOf(this.size).equals("SMALL")) {
			price = 12.99;
			price = smallPrice;
		} else if (String.valueOf(this.size).equals("MEDIUM")) {
			price = 14.99;
			price = medPrice;
		} else {
			price = 16.99;
			price = largePrice;
		}

		
		if (this.toppings.size() > defaultToppings) {
			int i = this.toppings.size() - defaultToppings;
			while (i > 0) {
				price += 1.49;
				price += toppingPrice;
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
	@return textual representation of pizza 
	@author Emily Nelson
	*/
	@Override
	public String toString() {
		String str = super.toString();
		return "DELUXE : " + str;
	}
}
