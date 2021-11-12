package application;

public class Orders {

	private Pizza[] orders;
	private int size;
	
	private int find(Pizza pizza) {
		
		for (int index = 0; index < size; index++) {
			if (pizza.getOrderNumber().equals(orders[index].getOrderNumber())) {
				return index;
			}
		}
		return -1;
	}
	
	public boolean add(Pizza pizza) {
		if (find(pizza) != -1) {
			return false;
		}
		
		int index = findEmptySpot();
		orders[index] = pizza;
		size++;
		return true;
	}
	
	public boolean remove(Pizza pizza) {
		if (find(pizza) == 1) {
			return false;
		}
		
		int index = find(pizza);
		orders[index] = null;
		size--;
		
		if (index < orders.length - 1) {
			while (index < orders.length - 1) {
				orders[index] = orders[index + 1];
				index++;
			}
			
			orders[index] = null;
		}
		
		return true;
	}
	
	
	public void setPizzas(Pizza[] newPizzas) {
		this.orders = newPizzas;
	}
	
	public int getSize() {
		return size;
	}
	
	public Pizza getPizza(Pizza pizza) {
		Pizza foundPiz = new Pizza();
		int i = find(pizza);
		
		System.out.println("index is " + i);
		
		if (i != -1) {
			foundPiz = orders[i];
			if (foundPiz instanceof Deluxe) {
				Deluxe del = (Deluxe) foundPiz;
				return del;
			} 
			if (foundPiz instanceof Hawaiian) {
				Hawaiian haw = (Hawaiian) foundPiz;
				return haw;
			}
			if (foundPiz instanceof Pepperoni) {
				Pepperoni pep = (Pepperoni) foundPiz;
				return pep;
			}
		} 
		return null;
	}
	
	public int findEmptySpot() {
		for (int i = 0; i < orders.length; i++) {
			if (orders[i] == null) {
				return i;
			}
		}
		return -1;
	}
}
