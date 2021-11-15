package application;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
This class contains the methods that organize the user Order inputs
@author Emily Nelson, Cristofer Gomez-Martinez
*/
public class OrderController {
	
    @FXML
    private ImageView imgOrder;
    
    @FXML
    private Image deluxeImage = new Image(getClass().getResourceAsStream("deluxe_pizza.jpg"));
    
    @FXML
    private Image hawaiianImage = new Image(getClass().getResourceAsStream("hawaiian_pizza.jpg"));
    
    @FXML
    private Image pepperoniImage = new Image(getClass().getResourceAsStream("pepperoni_pizza.jpg"));
    
    @FXML
    private MenuButton mnuSize;
    
    @FXML
    private MenuItem mnuSmall;
    
    @FXML
    private MenuItem mnuMedium;
    
    @FXML
    private MenuItem mnuLarge;
    
    @FXML
    private Menu mnuArtichoke;

    @FXML
    private Menu mnuHam;

    @FXML
    private Menu mnuMushrooms;

    @FXML
    private Menu mnuOlives;

    @FXML
    private Menu mnuOnions;

    @FXML
    private Menu mnuPepperoni;

    @FXML
    private Menu mnuPineapple;

    @FXML
    private Menu mnuSausage;
    
    @FXML
    private MenuItem artichokeAdd;

    @FXML
    private MenuItem artichokeRemove;

    @FXML
    private MenuItem hamAdd;

    @FXML
    private MenuItem hamRemove;

    @FXML
    private MenuItem mushroomAdd;

    @FXML
    private MenuItem mushroomRemove;

    @FXML
    private MenuItem olivesAdd;

    @FXML
    private MenuItem olivesRemove;

    @FXML
    private MenuItem onionsAdd;

    @FXML
    private MenuItem onionsRemove;

    @FXML
    private MenuItem pepperoniAdd;

    @FXML
    private MenuItem pepperoniRemove;

    @FXML
    private MenuItem pineappleAdd;

    @FXML
    private MenuItem pineappleRemove;

    @FXML
    private MenuItem sausageAdd;

    @FXML
    private MenuItem sausageRemove;

    @FXML
    private TextArea txtSelectedToppings;
    
    @FXML
    private TextField txtPrice;
    
    @FXML
    private Button btnAddToOrder;
    
    @FXML
    private Stage stage;
    
    @FXML
    private AnchorPane scenePane;
    
    private String orderNum;
 
    /**
    Returns the number of order
    @return order number
    @author Emily Nelson 
    */
    public String getOrderNum() {
    	return orderNum;
    }
    
    /**
    Sets the order number to given order number
    @param orderNum the order number to set
    @author Emily Nelson
    */
    public void setOrderNum(String orderNum) {
    	this.orderNum = orderNum;
    }

    private Order order;
    
    private StoreOrders storeOrders;
       
   
    private Pizza thePizza;
    
    /**
    Sets up the Deluxe ordering page
    @author Emily Nelson
    */
    public void setPicDeluxe() {
    	ArrayList<Toppings> defaultDeluxeToppings = new ArrayList<Toppings>();
    	defaultDeluxeToppings.add(Toppings.SAUSAGE);
    	defaultDeluxeToppings.add(Toppings.MUSHROOMS);
    	defaultDeluxeToppings.add(Toppings.ARTICHOKES);
    	defaultDeluxeToppings.add(Toppings.ONIONS);
    	defaultDeluxeToppings.add(Toppings.OLIVES);
    	thePizza = PizzaMaker.createPizza("Deluxe");
    	thePizza = (Deluxe) thePizza;
    	thePizza.setSize(Size.SMALL);
    	thePizza.setToppings(defaultDeluxeToppings);
    	
    	imgOrder.setImage(deluxeImage);
    	txtSelectedToppings.appendText("Sausage\nMushrooms\nArtichoke Hearts\nOnions\nOlives\n");
    	sausageAdd.setDisable(true);
    	mushroomAdd.setDisable(true);
    	artichokeAdd.setDisable(true);
    	onionsAdd.setDisable(true);
    	olivesAdd.setDisable(true);
    	hamRemove.setDisable(true);
    	pineappleRemove.setDisable(true);
    	pepperoniRemove.setDisable(true);
  
    	txtPrice.setText(String.valueOf(thePizza.price()));

    }
    
    /**
    Sets up the Hawaiian ordering page
    @author Emily Nelson
    */
    public void setPicHawaiian() {
    	imgOrder.setImage(hawaiianImage);
    	ArrayList<Toppings> defaultHawaiianToppings = new ArrayList<Toppings>();
    	defaultHawaiianToppings.add(Toppings.HAM);
    	defaultHawaiianToppings.add(Toppings.PINEAPPLE);
    	thePizza = PizzaMaker.createPizza("Hawaiian");
    	thePizza = (Hawaiian) thePizza;
    	thePizza.setSize(Size.SMALL);
    	thePizza.setToppings(defaultHawaiianToppings);
    	
    	txtSelectedToppings.appendText("Pineapple\nHam\n");
    	sausageRemove.setDisable(true);
    	mushroomRemove.setDisable(true);
    	artichokeRemove.setDisable(true);
    	onionsRemove.setDisable(true);
    	olivesRemove.setDisable(true);
    	hamAdd.setDisable(true);
    	pineappleAdd.setDisable(true);
    	//pineappleRemove.setDisable(false);
    	pepperoniRemove.setDisable(true);
    	
    	txtPrice.setText(String.valueOf(thePizza.price()));
    }
    
    /**
    Sets up the Pepperoni ordering page
    @author Emily Nelson
    */
    public void setPicPepperoni() {
    	imgOrder.setImage(pepperoniImage);
    	ArrayList<Toppings> defaultPepperoniToppings = new ArrayList<Toppings>();
    	defaultPepperoniToppings.add(Toppings.PEPPERONI);
    	thePizza = PizzaMaker.createPizza("Pepperoni");
    	thePizza = (Pepperoni) thePizza;
    	thePizza.setSize(Size.SMALL);
    	thePizza.setToppings(defaultPepperoniToppings);
    	
    	txtSelectedToppings.appendText("Pepperoni\n");
    	
    	//pepperoniRemove.setDisable(false);
    	pepperoniAdd.setDisable(true);
    	sausageRemove.setDisable(true);
    	mushroomRemove.setDisable(true);    
    	artichokeRemove.setDisable(true);
    	onionsRemove.setDisable(true);
    	olivesRemove.setDisable(true);
    	hamRemove.setDisable(true);
    	pineappleRemove.setDisable(true);
    	
    	txtPrice.setText(String.valueOf(thePizza.price()));
    	
    }
    
    /**
    Changes pizza size to Small
    @author Emily Nelson
    */
    public void changeToSmall(ActionEvent e) {
    	mnuSize.setText("Small");
    	
    	thePizza.setSize(Size.SMALL);
    	
    	txtPrice.setText(String.valueOf(thePizza.price()));
    }
    
    /**
    Changes pizza size to Medium
    @author Emily Nelson
    */
    public void changeToMedium(ActionEvent e) {
    	mnuSize.setText("Medium");
    	
    	thePizza.setSize(Size.MEDIUM);
    	
    	txtPrice.setText(String.valueOf(thePizza.price()));
    	
    }
    
    /**
    Changes pizza size to Large
    @author Emily Nelson
    */
    public void changeToLarge(ActionEvent e) {
    	mnuSize.setText("Large");
    	
    	thePizza.setSize(Size.LARGE);
    	
    	txtPrice.setText(String.valueOf(thePizza.price()));
    }
    
    /**
    Adds Sausage to pizza
    Does nothing if sausage is on pizza already
    @author Emily Nelson
    */
    public void addSausage(ActionEvent e) {
      	if (!checkToppings(thePizza.toppings.size())) return;
    	thePizza.toppings.add(Toppings.SAUSAGE);
    	txtSelectedToppings.appendText("Sausage\n");
    	sausageAdd.setDisable(true);
    	sausageRemove.setDisable(false);
    	
    	txtPrice.setText(String.valueOf(thePizza.price()));
    }
    
    /**
    Adds Mushroom to pizza
    Does nothing if mushroom is on pizza already
    @author Emily Nelson
    */
    public void addMushroom(ActionEvent e) {
      	if (!checkToppings(thePizza.toppings.size())) return;
      	thePizza.toppings.add(Toppings.MUSHROOMS);
    	txtSelectedToppings.appendText("Mushrooms\n");
    	mushroomAdd.setDisable(true);
    	mushroomRemove.setDisable(false);
    	
    	txtPrice.setText(String.valueOf(thePizza.price()));
    }
    
    /**
    Adds Artichoke to pizza
    Does nothing if Artichoke is on pizza already
    @author Emily Nelson
    */
    public void addArtichoke(ActionEvent e) {
      	if (!checkToppings(thePizza.toppings.size())) return;
      	thePizza.toppings.add(Toppings.ARTICHOKES);
    	txtSelectedToppings.appendText("Artichoke Hearts\n");
    	artichokeAdd.setDisable(true);
    	artichokeRemove.setDisable(false);
    	
    	txtPrice.setText(String.valueOf(thePizza.price()));
    }
    
    /**
    Adds Onions to pizza
    Does nothing if onions is on pizza already
    @author Emily Nelson
    */
    public void addOnions(ActionEvent e) {
      	if (!checkToppings(thePizza.toppings.size())) return;
      	thePizza.toppings.add(Toppings.ONIONS);
    	txtSelectedToppings.appendText("Onions\n");
    	onionsAdd.setDisable(true);
    	onionsRemove.setDisable(false);
    	
    	txtPrice.setText(String.valueOf(thePizza.price()));
    }
    
    /**
    Adds Olives to pizza
    Does nothing if olives is on pizza already
    @author Emily Nelson
    */
    public void addOlives(ActionEvent e) {
      	if (!checkToppings(thePizza.toppings.size())) return;
      	thePizza.toppings.add(Toppings.OLIVES);
    	txtSelectedToppings.appendText("Olives\n");
    	olivesAdd.setDisable(true);
    	olivesRemove.setDisable(false);
    	
    	txtPrice.setText(String.valueOf(thePizza.price()));
    }
    
    /**
    Adds Ham to pizza
    Does nothing if ham is on pizza already
    @author Emily Nelson
    */
    public void addHam(ActionEvent e) {
      	if (!checkToppings(thePizza.toppings.size())) return;
      	thePizza.toppings.add(Toppings.HAM);
    	txtSelectedToppings.appendText("Ham\n");
    	hamAdd.setDisable(true);
    	hamRemove.setDisable(false);
    	
    	txtPrice.setText(String.valueOf(thePizza.price()));
    }
    
    /**
    Adds Pineapple to pizza
    Does nothing if pineapple is on pizza already
    @author Emily Nelson
    */
    public void addPineapple(ActionEvent e) {
      	if (!checkToppings(thePizza.toppings.size())) return;
      	thePizza.toppings.add(Toppings.PINEAPPLE);
    	txtSelectedToppings.appendText("Pineapple\n");
    	pineappleAdd.setDisable(true);
    	pineappleRemove.setDisable(false);
    	
    	txtPrice.setText(String.valueOf(thePizza.price()));
    }
   
    /**
    Adds Pepperoni to pizza
    Does nothing if pepperoni is on pizza already
    @author Emily Nelson
    */
    public void addPepperoni(ActionEvent e) {
      	if (!checkToppings(thePizza.toppings.size())) return;
      	thePizza.toppings.add(Toppings.PEPPERONI);
    	txtSelectedToppings.appendText("Pepperoni\n");
    	pepperoniAdd.setDisable(true);
    	pepperoniRemove.setDisable(false);
    	
    	txtPrice.setText(String.valueOf(thePizza.price()));
    }
    
    /**
    Removes Sausage from pizza
    Does nothing if sausage is not on pizza 
    @author Emily Nelson
    */
    public void removeSausage(ActionEvent e) { 	
    	thePizza.toppings.remove(Toppings.SAUSAGE);

    	String top = txtSelectedToppings.getText();
    	int endIndex = top.length();
    	int i = top.indexOf("Sausage");
    	top = top.substring(0, i) + top.substring(i+8, endIndex);
    	txtSelectedToppings.setText(top);
    	
    	sausageAdd.setDisable(false);
    	sausageRemove.setDisable(true);
    	
    	txtPrice.setText(String.valueOf(thePizza.price()));
    }
    
    /**
    Removes Mushroom from pizza
    Does nothing if mushroom is not on pizza 
    @author Emily Nelson
    */
    public void removeMushroom(ActionEvent e) {
    	thePizza.toppings.remove(Toppings.MUSHROOMS);

    	String top = txtSelectedToppings.getText();
    	int endIndex = top.length();
    	int i = top.indexOf("Mushrooms");
    	top = top.substring(0, i) + top.substring(i+10, endIndex);
    	txtSelectedToppings.setText(top);
    	
    	mushroomAdd.setDisable(false);
    	mushroomRemove.setDisable(true);
    	
    	txtPrice.setText(String.valueOf(thePizza.price()));
    }
    
    /**
    Removes Artichoke from pizza
    Does nothing if Artichoke is not on pizza 
    @author Emily Nelson
    */
    public void removeArtichoke(ActionEvent e) {
    	thePizza.toppings.remove(Toppings.ARTICHOKES);

    	String top = txtSelectedToppings.getText();
    	int endIndex = top.length();
    	int i = top.indexOf("Artichoke Hearts");
    	top = top.substring(0, i) + top.substring(i+17, endIndex);
    	txtSelectedToppings.setText(top);
    	
    	artichokeAdd.setDisable(false);
    	artichokeRemove.setDisable(true);
    	
    	txtPrice.setText(String.valueOf(thePizza.price()));
    }
    
    /**
    Removes Onions from pizza
    Does nothing if onions is not on pizza 
    @author Emily Nelson
    */
    public void removeOnions(ActionEvent e) {
    	thePizza.toppings.remove(Toppings.ONIONS);

    	String top = txtSelectedToppings.getText();
    	int endIndex = top.length();
    	int i = top.indexOf("Onions");
    	top = top.substring(0, i) + top.substring(i+7, endIndex);
    	txtSelectedToppings.setText(top);
    	
    	onionsAdd.setDisable(false);
    	onionsRemove.setDisable(true);

    	txtPrice.setText(String.valueOf(thePizza.price()));
    }
    
    /**
    Removes Olives from pizza
    Does nothing if olives is not on pizza 
    @author Emily Nelson
    */
    public void removeOlives(ActionEvent e) {
    	thePizza.toppings.remove(Toppings.OLIVES);

    	String top = txtSelectedToppings.getText();
    	int endIndex = top.length();
    	int i = top.indexOf("Olives");
    	top = top.substring(0, i) + top.substring(i+7, endIndex);
    	txtSelectedToppings.setText(top);
    	
    	olivesAdd.setDisable(false);
    	olivesRemove.setDisable(true);
    	
    	txtPrice.setText(String.valueOf(thePizza.price()));
    }
    
    /**
    Removes Ham from pizza
    Does nothing if ham is not on pizza 
    @author Emily Nelson
    */
    public void removeHam(ActionEvent e) {
    	thePizza.toppings.remove(Toppings.HAM);

    	String top = txtSelectedToppings.getText();
    	int endIndex = top.length();
    	int i = top.indexOf("Ham");
    	top = top.substring(0, i) + top.substring(i+4, endIndex);
    	txtSelectedToppings.setText(top);
    	
    	hamAdd.setDisable(false);
    	hamRemove.setDisable(true);
    	
    	txtPrice.setText(String.valueOf(thePizza.price()));
    }
    
    /**
    Removes Pineapple from pizza
    Does nothing if pineapple is not on pizza 
    @author Emily Nelson
    */
    public void removePineapple(ActionEvent e) {
    	thePizza.toppings.remove(Toppings.PINEAPPLE);

    	String top = txtSelectedToppings.getText();
    	int endIndex = top.length();
    	int i = top.indexOf("Pineapple");
    	top = top.substring(0, i) + top.substring(i+10, endIndex);
    	txtSelectedToppings.setText(top);
    	
    	pineappleAdd.setDisable(false);
    	pineappleRemove.setDisable(true);

    	txtPrice.setText(String.valueOf(thePizza.price()));
    }
    
    /**
    Removes Pepperoni from pizza
    Does nothing if pepperoni is not on pizza 
    @author Emily Nelson
    */
    public void removePepperoni(ActionEvent e) {
    	thePizza.toppings.remove(Toppings.PEPPERONI);

    	String top = txtSelectedToppings.getText();
    	int endIndex = top.length();
    	int i = top.indexOf("Pepperoni");
    	top = top.substring(0, i) + top.substring(i+10, endIndex);
    	txtSelectedToppings.setText(top);
    	
    	pepperoniAdd.setDisable(false);
    	pepperoniRemove.setDisable(true);

    	txtPrice.setText(String.valueOf(thePizza.price()));
    	
    }
    
    /**
    Checks if pizza has more than 7 toppings
    @param numToppings the number of toppings
    @return true if pizza has no more than 7 toppings, false otherwise
    @author Emily Nelson
    */
    public boolean checkToppings(int numToppings) {
    	if (numToppings > 7) {
    		try {
    			Stage newStage = new Stage();
		    	VBox popup = new VBox();
    			Label warning  = new Label("\n\n\t\t No more than 7 toppings.");
		    	popup.getChildren().add(warning);
		    	Scene stageScene = new Scene(popup, 250, 100);
		    	newStage.setScene(stageScene);
		    	newStage.setTitle("Warning");
		    	newStage.show();
		    	return false;
    		} catch(Exception e) {
    			//e.printStackTrace();
    		}
    	}
    	
    	return true;
    }

    /**
    Finds the index where the topping is located in the Toppings array
    @param toppings the Toppings array being looked through
    @param topping the topping being looked for
    @return the index of the topping if found, -1 otherwise
    @author Emily Nelson
    */
    public int findTopping(Toppings[] toppings, Toppings topping) {
    	for (int i = 0; i < 7; i++) {
    		if (toppings[i] == topping) {
    			return i;
    		}
    	}
    	
    	return -1;
    }
    
    
	/**
	Finds the first empty index/spot in the Toppings array
	@param toppings the Toppings array where the empty spot is being looked for
	@return the index if an empty spot is found, -1 otherwise
	@author Emily Nelson
	*/
	public int findEmptySpotToppings(Toppings[] toppings) {
		for (int i = 0; i < toppings.length; i++) {
			if (toppings[i] == null) {
				return i;
			}
		}
		return -1;
	}
	

	private Order[] allOrders;
	
	/**
	Adds pizza to order
	Adds pizza to store orders
	@param event
	@author Emily Nelson
	*/
	public void addToOrder(ActionEvent e) {
		stage = (Stage) scenePane.getScene().getWindow();
		order.add(thePizza);
		order.printOrder();

		allOrders = new Order[10];
		storeOrders.addToOrders(order);
		
		try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("View.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            MainController mainCont = fxmlLoader.getController();
            mainCont.setStoreOrders(storeOrders);
		} catch (Exception exception) {
			
		}
		stage.close();
	}
	
	/**
	Sets the store orders to new store oders
	@param storeOrders the new store orders to set 
	@author Emily Nelson
	*/
	public void setTheStoreOrders(StoreOrders storeOrders) {
		this.storeOrders = storeOrders;
	}
	
	/**
	Sets the order to new order
	@param order the new order to set 
	@author Emily Nelson
	*/
	public void setOrder(Order order) {
		this.order = order;
	}
}
