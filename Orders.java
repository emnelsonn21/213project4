package application;

public class Orders {

	private Pizza[] orders;
	private int size;
	
	
	public void setPizzas(Pizza[] newPizzas) {
		this.orders = newPizzas;
	}
	
	public int getSize() {
		return size;
	}
}
