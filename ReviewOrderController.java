package application;

import java.text.DecimalFormat;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
This class contains the methods that organize the user ReviewOrder inputs
@author Emily Nelson, Cristofer Gomez-Martinez
*/
public class ReviewOrderController {
	
	static final double tax = 0.06625;

    @FXML
    private AnchorPane scenePane;
    
	@FXML
	private ListView<Pizza> orderReviewList;
	
    @FXML
    private Button btnAddItems;

    @FXML
    private Button btnPlaceOrder;

    @FXML
    private Button btnRemoveItem;
    
    @FXML
    private Button btnCancel;
    
    @FXML
    private TextField txtTotalPrice;
    
    @FXML
    private TextField txtSalesTax;
	
    private String orderNum = "";
    
    private Order[] allOrders;
    
    private StoreOrders storeOrders;
    
    /**
    Fills in the Review List with all the pizzas from  a specific Order
    @param allOrders the array of Orders to look through and find specific Order
    @author Emily Nelson
    */
    protected void fillOrderReviewList2(Order[] allOrders) {
    	int i = findWithOrderNum(orderNum);
    	Pizza[] pizzas = new Pizza[allOrders[i].getSize()];
    	pizzas = allOrders[i].getArrOfPizzas();
    	orderReviewList.getItems().addAll(pizzas);
    	double price = calculateTotalPrice();
    	DecimalFormat df = new DecimalFormat("0.00");
    	txtTotalPrice.setText(df.format(price + (price * tax)));
    	txtSalesTax.setText(df.format(price * tax));
    }
    
    /**
    Removes selected Pizza from Order
    @param event
    @author Emily Nelson
    */
    @FXML
    private void removeItem(ActionEvent event) {
    	int i = findWithOrderNum(orderNum);
    	Pizza pizza = orderReviewList.getSelectionModel().getSelectedItem();
    	allOrders[i].remove(pizza);
    	orderReviewList.getItems().remove(pizza);
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
    Gets the total price of all pizza in specific Order
    @return the total price of all pizzas in Order
    @author Emily Nelson
    */
    private double calculateTotalPrice() {
    	double price = 0;
    	int index = findWithOrderNum(orderNum);
    	int noPizzas = allOrders[index].getSize();
    	Order order = allOrders[index];
    	
    	for (int i = 0; i < noPizzas; i++) {
    		price += order.getArrOfPizzas()[i].price();
    	}
    	
    //	price = price + (price * tax);
    	
    	DecimalFormat df = new DecimalFormat("0.00");
    	
    	return Double.valueOf(df.format(price));
    }
    
    /**
    Places an Order of Pizzas
    @param event
    @author Emily Nelson
    */
    @FXML
    private void placeOrder(ActionEvent event) {
    	try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("View.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            MainController mainCont = fxmlLoader.getController();
            mainCont.setCustomerID("");
		} catch (Exception exception) {
			exception.printStackTrace();
		}
    	Stage stage = (Stage) btnPlaceOrder.getScene().getWindow();
    	stage.close();
    }
    
    /**
    Cancels an Order of Pizzas
    @param event
    @author Emily Nelson
    */
    @FXML
    private void cancelOrder(ActionEvent event) {
    	int index = findWithOrderNum(orderNum);
    	allOrders[index] = null;
    	storeOrders.setSize(storeOrders.getSize() - 1);
    	Stage stage = (Stage) btnCancel.getScene().getWindow();
    	stage.close();
    }
    
	/**
	Sets the store orders
	@param storeOrders the store orders to set 
	@author Emily Nelson
	*/
	public void settingStoreOrders(StoreOrders storeOrders) {
		this.storeOrders = storeOrders;
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
    Sets the order number
    @param orderNum the order number to set
    @author Emily Nelson
    */
    public void takeOrderNum(String orderNum) {
    	
    	this.orderNum = orderNum;
    }
}
