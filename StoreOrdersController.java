package application;

import java.io.File;
import java.text.DecimalFormat;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
This class contains the methods that organize the user Store Order inputs
@author Emily Nelson, Cristofer Gomez-Martinez
*/
public class StoreOrdersController {
	
	static final double tax = 0.06625;

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
    
    private Order[] allOrders;
  
    private StoreOrders storeOrders;
    
    /**
    *Fills in the Store Order List with pizzas from specific Order
    *@param e the event
    *@author Emily Nelson
    */
    public void fillOrderList(ActionEvent e) {
    	listOrders.getItems().clear();
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
    	
    	totalPrice = totalPrice + (totalPrice * tax);
    	
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
    
    /**
     * Fills the ChoiceBox with all phone numbers to choose from
     * @param storeOrders the instance of store orders
     * @author Emily Nelson
     */
    public void addMenuItems(StoreOrders storeOrders) {
    	for (int i = 0; i < storeOrders.getSize(); i++) {
    		String num = storeOrders.getAllOrders()[i].getOrderNumber();
    		mnuPhoneNumbers.getItems().add(num);
    	}
    }
    
    /**
    Cancels an Order of Pizzas
    @param event the event
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
    
    public void downloadOrder(ActionEvent event) {
    	
    	File file = storeOrders.export();
    	
		try {
			Stage newStage = new Stage();
		    VBox popup = new VBox();
	    	Label confirm  = new Label("File saved to " + file);
	    	popup.getChildren().add(confirm);
	    	Scene stageScene = new Scene(popup, 700, 100);
	    	newStage.setScene(stageScene);
	    	newStage.show();
		} catch(Exception e) {
    		e.printStackTrace();
    	}
    }
    
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
}
