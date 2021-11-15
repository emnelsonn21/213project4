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

/**
This class contains the methods that organize the user Store Order inputs
@author Emily Nelson, Cristofer Gomez-Martinez
*/
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
    private Order[] allOrders;
    
    //also need to get storeOrders from main-->ordercont and assign allOrders to it
    private StoreOrders storeOrders;
    
    /**
    Sets the Order array with all orders
    @param allOrders the orders to set
    @author Emily Nelson
    */
    public void getAllOrders(Order[] allOrders) {
    	this.allOrders = allOrders;
    }
    
    /**
    Sets the store orders
    @param storeOrders the store orders to set 
    @author Emily Nelson
    */
    public void getStoreOrders(StoreOrders storeOrders) {
    	this.storeOrders = storeOrders;
    }
    
    /**
    Sets the order number
    @param orderNum the order number to set
    @author Emily Nelson
    */
    public void takeOrderNum(String orderNum) {
    	this.orderNum = orderNum;
    }
    
    /**
    Fills in the Store Order List with pizzas from specific Order
    @param event
    @author Emily Nelson
    */
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
    
    /**
    Finds the index of the Order in the Orders array
    @param orderNum the order number used to find index
    @return the index of Order if found, -1 otherwise
    */
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
    
    /**
    Cancels an Order of Pizzas
    @param event
    @author Emily Nelson
    */
    public void cancelOrder(ActionEvent event) {
    	String orderNum = mnuPhoneNumbers.getValue();
    	int index = findWithOrderNum(orderNum);
    	allOrders[index] = null;
    	storeOrders.setSize(storeOrders.getSize() - 1);
    	Stage stage = (Stage) btnCancelOrder.getScene().getWindow();
    	stage.close();
    }
}
