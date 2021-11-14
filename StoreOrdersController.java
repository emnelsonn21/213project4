package application;

import java.text.DecimalFormat;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class StoreOrdersController {

    @FXML
    private Button btnCancelOrder;

    @FXML
    private Button btnExportOrders;

    @FXML
    private ChoiceBox<String> mnuPhoneNumbers;

    @FXML
    private ListView<Pizza> listOrders;

    @FXML
    private TextField txtOrdersTotal;
    
    private String orderNum = "";
    
    //need to get the order[] from OrderController and put it here
    //use getPizzas method as a toString
    Order[] allOrders;
    
    //also need to get storeOrders from main-->ordercont and assign allOrders to it
    StoreOrders storeOrders;
    
    public void getAllOrders(Order[] allOrders) {
    	this.allOrders = allOrders;
    }
    
    public void getStoreOrders(StoreOrders storeOrders) {
    	this.storeOrders = storeOrders;
    }
    
    public void takeOrderNum(String orderNum) {
    	
    	this.orderNum = orderNum;
    }
    
    public void fillOrderList(ActionEvent e) {
    	String orderNum = mnuPhoneNumbers.getValue();
    	int i = findWithOrderNum(orderNum);
    	Pizza[] pizzas = new Pizza[allOrders[i].getSize()];
    	pizzas = allOrders[i].getArrOfPizzas();
    	listOrders.getItems().addAll(pizzas);
    	
    	double totalPrice = 0;
    	for (int j = 0; j < pizzas.length; j++) {
    		totalPrice += pizzas[j].price();
    	}
    	
    	DecimalFormat df = new DecimalFormat("0.00");
    	
    	totalPrice = totalPrice + (totalPrice * .06625);
    	
    	txtOrdersTotal.setText(df.format(totalPrice));

    }
    
    private int findWithOrderNum(String orderNum) {
		for (int index = 0; index < allOrders.length; index++) {
			if (orderNum.equals(allOrders[index].getOrderNumber())) {
				return index;
			}
		}
		return -1;
    }
    
    public void addMenuItems(StoreOrders storeOrders) {
    	for (int i = 0; i < storeOrders.getSize(); i++) {
    		String num = storeOrders.getAllOrders()[i].getOrderNumber();
    		mnuPhoneNumbers.getItems().add(num);
    	}
    }
    
    public void cancelOrder(ActionEvent event) {
    	String orderNum = mnuPhoneNumbers.getValue();
    	int index = findWithOrderNum(orderNum);
    	allOrders[index] = null;
    	storeOrders.setSize(storeOrders.getSize() - 1);
    	Stage stage = (Stage) btnCancelOrder.getScene().getWindow();
    	stage.close();
    }
}
