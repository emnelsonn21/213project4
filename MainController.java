package application;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
This class contains the methods that organize the Main Menu user inputs
@author Emily Nelson, Cristofer Gomez-Martinez
*/
public class MainController {

    @FXML
    private Button btnDownlaod;

    @FXML
    private Button btnOrderPepperoni;

    @FXML
    private Button btnOrderDeluxe;

    @FXML
    private Button btnOrderHawaiian;

    @FXML
    private Button btnPlaceOrder;

    @FXML
    private TextField customerID;

    @FXML
    private ImageView deluxeImage;

    @FXML
    private ImageView hawaiianImage;

    @FXML
    private ImageView pepperoniImage;
    
    @FXML
    private String oldCustID = "";
    
    @FXML
    private String custID = "";
    
    /**
     * Sets the customerID 
     * @param string: customerID
     * @author Emily Nelson
     */
    public void setCustomerID(String string) {
    	customerID.setText(string);
    }
    
    //only need to make an order when it's a new customer - different custID
    private Order order = new Order();
    
    /**
    Creates a new Order of pizzas
    @author Emily Nelson
    */
    public void makeNewOrder() {
    	order = new Order();
    	Pizza[] newOrders = new Pizza[10];
    	order.setPizzas(newOrders);
    }
    
    //only need to make a store order when the mainController window is opened for the first time
    @FXML
    private StoreOrders storeOrders;
    
    /**
    Confirms if order has been started
    @param event the event
    @author Emily Nelson
    */
    public void showConfirmation(KeyEvent event) throws Exception {
    	if(event.getCode().equals(KeyCode.ENTER)) {
    		if (customerID.getText().equals("")) {
	    		try {
	   	    		Stage newStage = new Stage();
	   		    	VBox popup = new VBox();
	   	    			Label notConfirmed = new Label("\n\nPlease enter a phone number.");
	   			    	popup.getChildren().add(notConfirmed);
    			    	Scene stageScene = new Scene(popup, 250, 100);
	    			    newStage.setScene(stageScene);
	    			   	newStage.setTitle("Order Confirmation");
	    			   	newStage.show();
		    	}  catch(Exception e) {
			    	e.printStackTrace();
			    }
    		} else if (customerID.getText().equals(custID)) {	
	    		try {
	   	    		Stage newStage = new Stage();
	   		    	VBox popup = new VBox();
	   	    			Label notConfirmed = new Label("\n\nOrder already placed for this phone number.\n\tPlease enter a new number.");
	   			    	popup.getChildren().add(notConfirmed);
    			    	Scene stageScene = new Scene(popup, 250, 100);
	    			    newStage.setScene(stageScene);
	    			   	newStage.setTitle("Order Confirmation");
	    			   	newStage.show();
		    	}  catch(Exception e) {
			    	e.printStackTrace();
			    }
    		} else {
    			oldCustID = custID;
	    		custID = customerID.getText();
	    		boolean isValidPhone = isValidTelephoneNumber(custID);

		    	try {
		    		Stage newStage = new Stage();
			    	VBox popup = new VBox();
		    		if (!isValidPhone) {
		    			Label notConfirmed = new Label("\n\n\tInvalid Phone number. Please try again.");
				    	popup.getChildren().add(notConfirmed);
				    	Scene stageScene = new Scene(popup, 250, 100);
				    	newStage.setScene(stageScene);
				    	newStage.setTitle("Order Confirmation");
				    	newStage.show();
		    		} else {	
		    			makeNewOrder();
		    			order.setOrderNumber(custID);
		    			customerID.clear();
				    	Label confirm  = new Label("\n\n\t\t Starting order. \n\t\t Order ID is " + custID);
				    	popup.getChildren().add(confirm);
				    	Scene stageScene = new Scene(popup, 250, 100);
				    	newStage.setScene(stageScene);
				    	newStage.setTitle("Order Confirmation");
				    	newStage.show();
		    		}
		    	} catch(Exception e) {
		    		e.printStackTrace();
		    	}
    		}
    	}
    }

    /**
    Opens up the Deluxe ordering page
    @param event the event
    @author Emily Nelson
    */
    public void openDeluxeOrderPage(ActionEvent event) throws Exception { 
    	if (custID.equals("")) { //never anything entered 
    		try {
    			Stage newStage = new Stage();
		    	VBox popup = new VBox();
    			Label warning  = new Label("\n\n\t\t Please enter a phone number.");
		    	popup.getChildren().add(warning);
		    	Scene stageScene = new Scene(popup, 250, 100);
		    	newStage.setScene(stageScene);
		    	newStage.setTitle("Order Confirmation");
		    	newStage.show();
		    	return;
    		} catch(Exception e) {
    			e.printStackTrace();
    		}
    	}
    	else if (oldCustID.equals(custID)) { //new order
    		try {
    			Stage newStage = new Stage();
		    	VBox popup = new VBox();
    			Label warning  = new Label("\n\n\t\t Please enter a phone number.");
		    	popup.getChildren().add(warning);
		    	Scene stageScene = new Scene(popup, 250, 100);
		    	newStage.setScene(stageScene);
		    	newStage.setTitle("Order Confirmation");
		    	newStage.show();
		    	return;
    		} catch(Exception e) {
    			e.printStackTrace();
    		}
    	}
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("orderPizzaView.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            OrderController orderDeluxe = fxmlLoader.getController();
            
            orderDeluxe.setOrder(order);
            orderDeluxe.setOrderNum(custID);
            orderDeluxe.setPicDeluxe();
            orderDeluxe.setTheStoreOrders(storeOrders);
            
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));  
            stage.setTitle("Customize Pizza");
            stage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    /**
    Opens up the Hawaiian ordering page
    @param event
    @author Emily Nelson
    */
    public void openHawaiianOrderPage(ActionEvent event) throws Exception { 
    	if (custID.equals("")) { //never anything entered 
    		try {
    			Stage newStage = new Stage();
		    	VBox popup = new VBox();
    			Label warning  = new Label("\n\n\t\t Please enter a phone number.");
		    	popup.getChildren().add(warning);
		    	Scene stageScene = new Scene(popup, 250, 100);
		    	newStage.setScene(stageScene);
		    	newStage.setTitle("Order Confirmation");
		    	newStage.show();
		    	return;
    		} catch(Exception e) {
    			e.printStackTrace();
    		}
    	}
    	else if (oldCustID.equals(custID)) { //new order
    		try {
    			Stage newStage = new Stage();
		    	VBox popup = new VBox();
    			Label warning  = new Label("\n\n\t\t Please enter a phone number.");
		    	popup.getChildren().add(warning);
		    	Scene stageScene = new Scene(popup, 250, 100);
		    	newStage.setScene(stageScene);
		    	newStage.setTitle("Order Confirmation");
		    	newStage.show();
		    	return;
    		} catch(Exception e) {
    			e.printStackTrace();
    		}
    	}
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("orderPizzaView.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            OrderController orderHawaiian = fxmlLoader.getController();
            
            orderHawaiian.setOrder(order);
            orderHawaiian.setOrderNum(custID);
            orderHawaiian.setPicHawaiian();
            orderHawaiian.setTheStoreOrders(storeOrders);
            
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));  
            stage.setTitle("Customize Pizza");
            stage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    /**
    Opens up the Pepperoni ordering page
    @param event
    @author Emily Nelson
    */
    public void openPepperoniOrderPage(ActionEvent event) throws Exception {  
    	if (custID.equals("")) { //never anything entered 
    		try {
    			Stage newStage = new Stage();
		    	VBox popup = new VBox();
    			Label warning  = new Label("\n\n\t\t Please enter a phone number.");
		    	popup.getChildren().add(warning);
		    	Scene stageScene = new Scene(popup, 250, 100);
		    	newStage.setScene(stageScene);
		    	newStage.setTitle("Order Confirmation");
		    	newStage.show();
		    	return;
    		} catch(Exception e) {
    			e.printStackTrace();
    		}
    	}
    	else if (oldCustID.equals(custID)) { //new order
    		try {
    			Stage newStage = new Stage();
		    	VBox popup = new VBox();
    			Label warning  = new Label("\n\n\t\t Please enter a phone number.");
		    	popup.getChildren().add(warning);
		    	Scene stageScene = new Scene(popup, 250, 100);
		    	newStage.setScene(stageScene);
		    	newStage.setTitle("Order Confirmation");
		    	newStage.show();
		    	return;
    		} catch(Exception e) {
    			e.printStackTrace();
    		}
    	}
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("orderPizzaView.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            OrderController orderPepperoni = fxmlLoader.getController();
            
            orderPepperoni.setOrder(order);
            orderPepperoni.setOrderNum(custID);
            orderPepperoni.setPicPepperoni();
            orderPepperoni.setTheStoreOrders(storeOrders);
            
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));  
            stage.setTitle("Customize Pizza");
            stage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    /**
    Checks if valid phone number has been entered
    @param entry phone number that was entered
    @return true if phone number is valid, false otherwise
    @author Emily Nelson
    */
    private boolean isValidTelephoneNumber(String entry) {
    	if (entry.length() != 10) {
    		return false;
    	}
    	
    	for (int i = 0; i < entry.length(); i++) {
    		if (!Character.isDigit(entry.charAt(i))) {
    			return false;
    		}
    	}
    	
    	return true;
    }
    
    /**
    Opens "View Order" Page
    @param event
    @author Emily Nelson
    */
    public void openViewOrderPage(ActionEvent event) {
    	if (storeOrders.getAllOrders()[0] == null) {
	        try {
	        	FXMLLoader fxmlLoader1 = new FXMLLoader(getClass().getResource("ReviewOrderView.fxml"));
	        	Parent root1 = (Parent) fxmlLoader1.load();
	        	Stage stage = new Stage();
	            stage.setScene(new Scene(root1));  
	            stage.setTitle("Review Order");
	            stage.show();
	
	        } catch(Exception e) {
	            e.printStackTrace();
	        }
    	} else {
	        try {
	        	FXMLLoader fxmlLoader1 = new FXMLLoader(getClass().getResource("ReviewOrderView.fxml"));
	        	Parent root1 = (Parent) fxmlLoader1.load();
	            ReviewOrderController reviewOrder = (ReviewOrderController) fxmlLoader1.getController();
	        	Stage stage = new Stage();
	            stage.setScene(new Scene(root1));  
	            stage.setTitle("Review Order");
	            stage.show();
	            
	            reviewOrder.takeOrderNum(custID);
	            reviewOrder.getAllOrders(storeOrders.getAllOrders());
	            reviewOrder.fillOrderReviewList2(storeOrders.getAllOrders());
	            reviewOrder.settingStoreOrders(storeOrders);
	
	        } catch(Exception e) {
	            e.printStackTrace();
	        }
    	}
	}
    
    /**
    Opens "Store Orders" Page
    @param event
    @author Emily Nelson
    */
    public void openStoreOrdersPage(ActionEvent event) {
        try {
        	FXMLLoader fxmlLoader1 = new FXMLLoader(getClass().getResource("StoreOrdersView.fxml"));
        	Parent root1 = (Parent) fxmlLoader1.load();
            StoreOrdersController storeOrdersCont = (StoreOrdersController) fxmlLoader1.getController();
        	Stage stage = new Stage();
            stage.setScene(new Scene(root1));  
            stage.setTitle("Review Order");
            stage.show();
            
            storeOrdersCont.getAllOrders(storeOrders.getAllOrders());
            storeOrdersCont.addMenuItems(storeOrders);
            storeOrdersCont.getStoreOrders(storeOrders);

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    
	/**
	Sets the store orders to new store orders
	@param storeOrders the new store orders to set 
	@author Emily Nelson
	*/
	public void setStoreOrders(StoreOrders storeOrders) {
		this.storeOrders = storeOrders;
	}
	
	/**
	Adds an order into the store orders
	@param order order to add
	@author Emily Nelson
	*/
	public void addToStoreOrders(Order order) {
		storeOrders.addToOrders(order);
	}
    
}
