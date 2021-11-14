package application;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class StoreOrders {

	private Order[] allOrders;
	int size;
	
	public int find(Order order) {
		for (int index = 0; index < size; index++) {
			if (order.getOrderNumber().equals(allOrders[index].getOrderNumber())) {
				return index;
			}
		}
		return -1;
	}
	
	public int findWithCustID(String custID) {
		for (int index = 0; index < size; index++) {
			if (custID.equals(allOrders[index].getOrderNumber())) {
				return index;
			}
		}
		return -1;
	}
	
	public void addToOrders(Order order) {
		if (find(order) != -1) {
			return;
		}
		
		int index = findEmptySpot();
		
		allOrders[index] = order;
		size++;
		System.out.println("total orders: " + size);
	}
	
	public void export() {
		try {
			File textFile = new File("StoreOrders.txt");
			
			textFile.createNewFile();
			
			PrintWriter storeOrders = new PrintWriter("StoreOrders.txt");
			
			for (int index = 0; index < size; index++) {
				storeOrders.println(allOrders[index].getOrderNumber());
					
					for(int pizzaIndex = 0; pizzaIndex < allOrders[index].getSize(); pizzaIndex++) {
						storeOrders.println("\t" + allOrders[index].getAllPizzasForOneOrder()[pizzaIndex].toString());
					}
			}
			
			storeOrders.close();
		}catch (IOException e) {
			//e.printStackTrace();
		}
			
	}
	
	public int findEmptySpot() {
		for (int i = 0; i < allOrders.length; i++) {
			if (allOrders[i] == null) {
				return i;
			}
		}
		return -1;
	}
	
	public void printAllOrders() {
		for (int i = 0; i < size; i++) {
			System.out.println(allOrders[i].getPizzas());
		}
	}
	
	
	public Order[] getAllOrders() {
		return this.allOrders;
	}
	public void setAllOrders(Order[] allOrders) {
		this.allOrders = allOrders;
	}
	
	public int getSize() {
		return size;
	}
	
	public void setSize(int size) {
		this.size = size;
	}
}
