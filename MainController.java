package application;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

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
    private String custID = "";
    
    //only need to make an order when it's a new customer - different custID
    Order order = new Order();
    public void makeNewOrder() {
    	Pizza[] newOrders = new Pizza[10];
    	order.setPizzas(newOrders);
    }
    
    //only need to make a store order when the mainController window is opened for the first time
    @FXML
    private StoreOrders storeOrders;
    
 
    public void showConfirmation(KeyEvent event) throws Exception {
    	if(event.getCode().equals(KeyCode.ENTER)) {
    		
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

    public void openDeluxeOrderPage(ActionEvent event) throws Exception { 
    	if (custID.equals("")) {
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
    
    public void openHawaiianOrderPage(ActionEvent event) throws Exception { 
    	if (custID.equals("")) {
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
            orderHawaiian.setOrderNum(custID);
            orderHawaiian.setPicHawaiian();
            
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));  
            stage.setTitle("Customize Pizza");

	    	stage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    public void openPepperoniOrderPage(ActionEvent event) throws Exception {  
    	if (custID.equals("")) {
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
            orderPepperoni.setOrderNum(custID);
            orderPepperoni.setPicPepperoni();
            
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));  
            stage.setTitle("Customize Pizza");
            stage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    
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
    
    public void openViewOrderPage(ActionEvent event) {
    	//AnchorPane root = new AnchorPane();
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

        } catch(Exception e) {
            e.printStackTrace();
        }
	}
    
	public void setStoreOrders(StoreOrders storeOrders) {
		this.storeOrders = storeOrders;
		System.out.println("Set for main. Length of allOrders is " + this.storeOrders.getAllOrders().length);
	}
	
	public void addToStoreOrders(Order order) {
		storeOrders.addToOrders(order);
	}
    
}
