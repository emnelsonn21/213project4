package application;

import java.text.DecimalFormat;
import java.util.ArrayList;

public abstract class Pizza {
	protected ArrayList<Toppings> toppings = new ArrayList<Toppings>();
	protected Size size;
	public abstract double price();
	
	
	public Pizza() {
		
	}
	
	
	@Override
	public String toString() {
		String theToppings = "";
		for (int i = 0; i < toppings.size(); i++) {
			if (toppings.get(i) != null) {
				theToppings += toppings.get(i) + ", ";
			}
		}
		
		DecimalFormat df = new DecimalFormat("0.00");
		
		return String.valueOf(size) + " pizza with " + theToppings;
	}
	
	
	public void setSize(Size size) {
		this.size = size;
	}
		
	
	public void setToppings(ArrayList<Toppings> toppings) {
		this.toppings = toppings;
	}

}

