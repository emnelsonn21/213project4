package application;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import javafx.stage.FileChooser;

/**
This class keeps the list of orders placed by the user
@author Emily Nelson, Cristofer Gomez-Martinez
*/
public class StoreOrders {

	private Order[] allOrders;
	private int size;
	
	/**
	Finds the index where the order is located in the Order array
	@param order the order being looked for
	@return the index of order if found, -1 otherwise
	@author Emily Nelson
	*/
	public int find(Order order) {
		for (int index = 0; index < size; index++) {
			if (order.getOrderNumber().equals(allOrders[index].getOrderNumber())) {
				return index;
			}
		}
		return -1;
	}
	
	/**
	Finds the index where the order is located in the Order array using customer ID
	@param custID the customer ID being used to locate order
	@return the index of order if found, -1 otherwise
	@author Emily Nelson
	*/
	public int findWithCustID(String custID) {
		for (int index = 0; index < size; index++) {
			if (custID.equals(allOrders[index].getOrderNumber())) {
				return index;
			}
		}
		return -1;
	}
	
	/**
	Adds an Order to Order array
	Does nothing if order is an array already
	@param order the order to add
	@author Emily Nelson
	*/
	public void addToOrders(Order order) {
		if (find(order) != -1) {
			return;
		}
		
		int index = findEmptySpot();
		
		allOrders[index] = order;
		size++;
	}
	
	/**
	Exports the store orders in a text file
	@author Cristofer Gomez-Martinez
	*/
	public File export() {
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Choose location to save");
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
        fileChooser.getExtensionFilters().add(extFilter);
		File file = fileChooser.showSaveDialog(null);
		if (file != null) {
			PrintWriter storeOrders = null;
			try {
				storeOrders = new PrintWriter(file);
				
			}catch (IOException e) {
				e.printStackTrace();
			}
			
			for (int index = 0; index < size; index++) {
				storeOrders.println(allOrders[index].getOrderNumber() + ":");
					
					for(int pizzaIndex = 0; pizzaIndex < allOrders[index].getSize(); pizzaIndex++) {
						storeOrders.println("\t" + allOrders[index].getAllPizzasForOneOrder()[pizzaIndex].toString());
					}
			}
			
			storeOrders.close();
		
		}

			return file;
	}
	
	/**
	Finds the first empty index/spot in the Order array
	@return the index if an empty spot is found, -1 otherwise
	@author Emily Nelson
	*/
	public int findEmptySpot() {
		for (int i = 0; i < allOrders.length; i++) {
			if (allOrders[i] == null) {
				return i;
			}
		}
		return -1;
	}
	
	
	/**
	Returns the array of orders
    @return Order array
	@author Emily Nelson 
	*/
	public Order[] getAllOrders() {
		return this.allOrders;
	}
	
	/**
	Sets the Order array
	@param allOrders the Order array to set
	@author Emily Nelson
	*/
	public void setAllOrders(Order[] allOrders) {
		this.allOrders = allOrders;
	}
	
	/**
	Returns the size of Order array
        @return size of Order array
	@author Emily Nelson 
	*/
	public int getSize() {
		return size;
	}
	
	/**
	Set the size of Order array
    @param size the size to set
	@author Emily Nelson 
	*/
	public void setSize(int size) {
		this.size = size;
	}
}
