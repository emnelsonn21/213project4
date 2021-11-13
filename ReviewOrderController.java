package application;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;

public class ReviewOrderController {

	@FXML
	private ListView<Pizza> orderReviewList;
	
    private String orderNum = "";
    
    //need to get the order[] from OrderController and put it here
    //use getPizzas method as a toString
    Order[] allOrders;
    
    public void getAllOrders(Order[] allOrders) {
    	this.allOrders = allOrders;
    	System.out.println(allOrders.length);
    }
    
    public void takeOrderNum(String orderNum) {
    	
    	this.orderNum = orderNum;
    }
    
    public void fillOrderReviewList() {
    	int i = findWithOrderNum(orderNum);
    	System.out.println("this order is size " + allOrders[i].getSize());
    	Pizza[] pizzas = new Pizza[allOrders[i].getSize()];
    	pizzas = allOrders[i].getArrOfPizzas();
    	orderReviewList.getItems().addAll(pizzas);
    }
    
    public void fillOrderReviewList2(Order[] allOrders) {
    	int i = findWithOrderNum(orderNum);
    	System.out.println("this order is size " + allOrders[i].getSize());
    	Pizza[] pizzas = new Pizza[allOrders[i].getSize()];
    	pizzas = allOrders[i].getArrOfPizzas();
    	orderReviewList.getItems().addAll(pizzas);
    }
    
    
    private int findWithOrderNum(String orderNum) {
		for (int index = 0; index < allOrders.length; index++) {
			if (orderNum.equals(allOrders[index].getOrderNumber())) {
				return index;
			}
		}
		return -1;
    }
}
