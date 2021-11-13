package application;

public class Order {

	private String orderNumber;
	private Pizza[] pizzas;
	private int size;
	
	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}
	
	private int find(Pizza pizza) {
		for (int index = 0; index < size; index++) {
			if (pizza.getOrderNumber().equals(pizzas[index].getOrderNumber())) {
				return index;
			}
		}
		return -1;
	}
	
	public boolean add(Pizza pizza) {
		int index = findEmptySpot();
		pizzas[index] = pizza;
		size++;
		return true;
	}
	
	public boolean remove(Pizza pizza) {
		if (find(pizza) == 1) {
			return false;
		}
		
		int index = find(pizza);
		pizzas[index] = null;
		size--;
		
		if (index < pizzas.length - 1) {
			while (index < pizzas.length - 1) {
				pizzas[index] = pizzas[index + 1];
				index++;
			}
			
			pizzas[index] = null;
		}
		
		return true;
	}
	
	
	public void setPizzas(Pizza[] newPizzas) {
		this.pizzas = newPizzas;
	}
	
	public int getSize() {
		return size;
	}
	
	public void printOrder() {
		if (size == 0) {
			return;
		}
		System.out.println(size + " pizzas for " + orderNumber + " :");
		
		for (int i = 0; i < size; i++) {
			System.out.println(pizzas[i].toString());
		}
	}
	
	public Pizza getPizza(Pizza pizza) {
		Pizza foundPiz = new Pizza();
		int i = find(pizza);
		
		if (i != -1) {
			foundPiz = pizzas[i];
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
	
	
	public Pizza[] getAllPizzasForOneOrder() {
		// a customer with a given order number is going to click view pizzas
		//print every pizza with that order number
		
		Pizza[] pizzas = new Pizza[size];
		
		return pizzas;
	}
	
	public int findEmptySpot() {
		for (int i = 0; i < pizzas.length; i++) {
			if (pizzas[i] == null) {
				return i;
			}
		}
		return -1;
	}

	
	public String getOrderNumber() {
		return orderNumber;
	}
	
	public String getPizzas() {
		String str = "";
		for (int i = 0; i < size; i++) {
			str = str + "\n" +pizzas[i].toString();
		}
		
		return str;
	}
	
	public Pizza[] getArrOfPizzas() {
		Pizza[] pizzasRightSize = new Pizza[size];
		for (int i = 0; i < size; i++) {
			pizzasRightSize[i] = this.pizzas[i];
		}
		return pizzasRightSize;
	}
}
