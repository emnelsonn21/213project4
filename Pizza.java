package application;

import java.text.DecimalFormat;

public class Pizza {
	
	public void calculatePrice() {
	}

	private Size size;
	//private Type type;
	private Toppings[] toppings;
	private double price;
	
	
	public Pizza() {
		
	}
	
	public Pizza(Size size, Toppings[] toppings, double price) {
		this.size = size;
		this.toppings = toppings;
		this.price = price;
	}
	
	
	@Override
	public String toString() {
		String theToppings = "";
		for (int i = 0; i < toppings.length; i++) {
			theToppings += toppings[i] + ", ";
		}
		
		DecimalFormat df = new DecimalFormat("0.00");
		
		return String.valueOf(size) + " pizza with " + theToppings + " for " + df.format(price);
	}
	
	public Size getSize() {
		return size;
	}
	
	public void setSize(Size size) {
		this.size = size;
	}
	
	public double getPrice() {
		return price;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	public Toppings[] getToppings() {
		return toppings;
	}
}

