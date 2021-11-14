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
	
    private String orderNum = "";
    
    private Order[] allOrders;
    
    private StoreOrders storeOrders;
    
    
    protected void fillOrderReviewList2(Order[] allOrders) {
    	int i = findWithOrderNum(orderNum);
    	Pizza[] pizzas = new Pizza[allOrders[i].getSize()];
    	pizzas = allOrders[i].getArrOfPizzas();
    	orderReviewList.getItems().addAll(pizzas);
    	double price = calculateTotalPrice();
    	txtTotalPrice.setText(String.valueOf(price));
    }
    
    @FXML
    private void removeItem(ActionEvent event) {
    	int i = findWithOrderNum(orderNum);
    	Pizza pizza = orderReviewList.getSelectionModel().getSelectedItem();
    	allOrders[i].remove(pizza);
    	orderReviewList.getItems().remove(pizza);
    }
    
    private int findWithOrderNum(String orderNum) {
		for (int index = 0; index < allOrders.length; index++) {
			if (orderNum.equals(allOrders[index].getOrderNumber())) {
				return index;
			}
		}
		return -1;
    }
    
    private double calculateTotalPrice() {
    	double price = 0;
    	int index = findWithOrderNum(orderNum);
    	int noPizzas = allOrders[index].getSize();
    	Order order = allOrders[index];
    	
    	for (int i = 0; i < noPizzas; i++) {
    		price += order.getArrOfPizzas()[i].price();
    	}
    	
    	price = price + (price * tax);
    	DecimalFormat df = new DecimalFormat("0.00");
    	
    	return Double.valueOf(df.format(price));
    }
    
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
    
    @FXML
    private void cancelOrder(ActionEvent event) {
    	int index = findWithOrderNum(orderNum);
    	allOrders[index] = null;
    	storeOrders.setSize(storeOrders.getSize() - 1);
    	Stage stage = (Stage) btnCancel.getScene().getWindow();
    	stage.close();
    }
    
	public void settingStoreOrders(StoreOrders storeOrders) {
		this.storeOrders = storeOrders;
	}
	
    public void getAllOrders(Order[] allOrders) {
    	this.allOrders = allOrders;
    }
    
    public void takeOrderNum(String orderNum) {
    	
    	this.orderNum = orderNum;
    }
}
