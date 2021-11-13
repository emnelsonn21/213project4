package application;

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
		
	}
	
	public int findEmptySpot() {
		for (int i = 0; i < allOrders.length; i++) {
			if (allOrders[i] == null) {
				return i;
			}
		}
		return -1;
	}
	
	public Order[] getAllOrders() {
		return this.allOrders;
	}
	public void setAllOrders(Order[] allOrders) {
		this.allOrders = allOrders;
	}
}
