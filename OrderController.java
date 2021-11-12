package application;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
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
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

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
    
    private String orderNum;
 
    public void getOrderNum(String orderNum) {
    	this.orderNum = orderNum;
    }
    
    private boolean firstTime = true;
    Orders orders = new Orders();
    
    public void makeOrders() {
    	Pizza[] newOrders = new Pizza[10];
    	orders.setPizzas(newOrders);
    }
    
    Pizza thePizza = new Pizza();
    
    public void setPicDeluxe() {
    	if (firstTime) {
    		makeOrders();
    		firstTime = false;
    	}
        boolean didWork = false;
    	Toppings[] defaultDeluxeToppings = new Toppings[]{Toppings.SAUSAGE, Toppings.MUSHROOMS, Toppings.ARTICHOKES, Toppings.ONIONS, Toppings.OLIVES, null, null};
    	thePizza = new Deluxe(orderNum, Size.SMALL, defaultDeluxeToppings, 14.99);
    	thePizza.setNoToppings(5);
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
    	
    	thePizza.calculatePrice();
    	txtPrice.setText(String.valueOf(thePizza.getPrice()));
    	
    	didWork = orders.add(thePizza);
    	

    }
    
    public void setPicHawaiian() {
    	imgOrder.setImage(hawaiianImage);
    	
    }
    
    public void setPicPepperoni() {
    	imgOrder.setImage(pepperoniImage);
    }
    
    public void changeToSmall(ActionEvent e) {
    	mnuSize.setText("Small");
    }
    public void changeToMedium(ActionEvent e) {
    	mnuSize.setText("Medium");
    }
    
    public void changeToLarge(ActionEvent e) {
    	mnuSize.setText("Large");
    }
    
    //search for the pizza that we're adding a topping to (orderNum) and update that pizza's number of toppings and also update Toppings[]
    public void addSausage(ActionEvent e) {
    	Pizza foundPizza = addTopping();
    	
       	int index = findEmptySpotToppings(foundPizza.getToppings());
    	foundPizza.getToppings()[index] = Toppings.SAUSAGE;
    	
    	for (int i = 0; i < 7; i++) {
    		System.out.println(foundPizza.getToppings()[i]);
    	}

    	txtSelectedToppings.appendText("Sausage\n");
    	sausageAdd.setDisable(true);
    	sausageRemove.setDisable(false);
    	
    	foundPizza.calculatePrice();
    	txtPrice.setText(String.valueOf(foundPizza.getPrice()));
    }
    
    
    public void addMushroom(ActionEvent e) {
    	Pizza foundPizza = addTopping();
    	
       	int index = findEmptySpotToppings(foundPizza.getToppings());
    	foundPizza.getToppings()[index] = Toppings.MUSHROOMS;
    	
    	for (int i = 0; i < 7; i++) {
    		System.out.println(foundPizza.getToppings()[i]);
    	}
    	
    	txtSelectedToppings.appendText("Mushrooms\n");
    	mushroomAdd.setDisable(true);
    	mushroomRemove.setDisable(false);
    	
    	foundPizza.calculatePrice();
    	txtPrice.setText(String.valueOf(foundPizza.getPrice()));
    }
    
    public void addArtichoke(ActionEvent e) {
    	Pizza foundPizza = addTopping();
    	
       	int index = findEmptySpotToppings(foundPizza.getToppings());
    	foundPizza.getToppings()[index] = Toppings.ARTICHOKES;
    	
    	for (int i = 0; i < 7; i++) {
    		System.out.println(foundPizza.getToppings()[i]);
    	}
    	
    	txtSelectedToppings.appendText("Artichoke Hearts\n");
    	artichokeAdd.setDisable(true);
    	artichokeRemove.setDisable(false);
    	
    	foundPizza.calculatePrice();
    	txtPrice.setText(String.valueOf(foundPizza.getPrice()));
    }
    
    public void addOnions(ActionEvent e) {
    	Pizza foundPizza = addTopping();
    	
       	int index = findEmptySpotToppings(foundPizza.getToppings());
    	foundPizza.getToppings()[index] = Toppings.ONIONS;
    	
    	for (int i = 0; i < 7; i++) {
    		System.out.println(foundPizza.getToppings()[i]);
    	}
    	
    	txtSelectedToppings.appendText("Onions\n");
    	onionsAdd.setDisable(true);
    	onionsRemove.setDisable(false);
    	
    	foundPizza.calculatePrice();
    	txtPrice.setText(String.valueOf(foundPizza.getPrice()));
    }
    
    public void addOlives(ActionEvent e) {
    	Pizza foundPizza = addTopping();
    	
       	int index = findEmptySpotToppings(foundPizza.getToppings());
    	foundPizza.getToppings()[index] = Toppings.OLIVES;
    	
    	for (int i = 0; i < 7; i++) {
    		System.out.println(foundPizza.getToppings()[i]);
    	}
    	
    	txtSelectedToppings.appendText("Olives\n");
    	olivesAdd.setDisable(true);
    	olivesRemove.setDisable(false);
    	
    	foundPizza.calculatePrice();
    	txtPrice.setText(String.valueOf(foundPizza.getPrice()));
    }
    
    public void addHam(ActionEvent e) {
    	Pizza foundPizza = addTopping();
    	
       	int index = findEmptySpotToppings(foundPizza.getToppings());
    	foundPizza.getToppings()[index] = Toppings.HAM;
    	
    	for (int i = 0; i < 7; i++) {
    		System.out.println(foundPizza.getToppings()[i]);
    	}
    	
    	txtSelectedToppings.appendText("Ham\n");
    	hamAdd.setDisable(true);
    	hamRemove.setDisable(false);
    	
    	foundPizza.calculatePrice();
    	txtPrice.setText(String.valueOf(foundPizza.getPrice()));
    }
    
    public void addPineapple(ActionEvent e) {
    	Pizza foundPizza = addTopping();
    	
       	int index = findEmptySpotToppings(foundPizza.getToppings());
    	foundPizza.getToppings()[index] = Toppings.PINEAPPLE;
    	
    	for (int i = 0; i < 7; i++) {
    		System.out.println(foundPizza.getToppings()[i]);
    	}
    	
    	txtSelectedToppings.appendText("Pineapple\n");
    	pineappleAdd.setDisable(true);
    	pineappleRemove.setDisable(false);
    	
    	foundPizza.calculatePrice();
    	txtPrice.setText(String.valueOf(foundPizza.getPrice()));
    }
   
    public void addPepperoni(ActionEvent e) {
    	Pizza foundPizza = addTopping();
    	
    	int index = findEmptySpotToppings(foundPizza.getToppings());
    	foundPizza.getToppings()[index] = Toppings.PEPPERONI;
    	
    	for (int i = 0; i < 7; i++) {
    		System.out.println(foundPizza.getToppings()[i]);
    	}
    	txtSelectedToppings.appendText("Pepperoni\n");
    	pepperoniAdd.setDisable(true);
    	pepperoniRemove.setDisable(false);
    	
    	foundPizza.calculatePrice();
    	txtPrice.setText(String.valueOf(foundPizza.getPrice()));
    }
    

    
    public void removeSausage(ActionEvent e) {
    	Pizza foundPizza = removeTopping();
    	
    	int index = findTopping(foundPizza.getToppings(), Toppings.SAUSAGE);
    	foundPizza.getToppings()[index] = null;
    	
    	if (index < 6) {
    		moveDown(foundPizza, index);
    	}

    	String top = txtSelectedToppings.getText();
    	int endIndex = top.length();
    	int i = top.indexOf("Sausage");
    	top = top.substring(0, i) + top.substring(i+8, endIndex);
    	txtSelectedToppings.setText(top);
    	
    	sausageAdd.setDisable(false);
    	sausageRemove.setDisable(true);
    }
    

    
    public void removeMushroom(ActionEvent e) {
    	Pizza foundPizza = removeTopping();
    	
    	int index = findTopping(foundPizza.getToppings(), Toppings.MUSHROOMS);
    	foundPizza.getToppings()[index] = null;
    	
    	if (index < 6) {
    		moveDown(foundPizza, index);
    	}
    	String top = txtSelectedToppings.getText();
    	int endIndex = top.length();
    	int i = top.indexOf("Mushrooms");
    	top = top.substring(0, i) + top.substring(i+10, endIndex);
    	txtSelectedToppings.setText(top);
    	
    	mushroomAdd.setDisable(false);
    	mushroomRemove.setDisable(true);
    }
    
    
    public void removeArtichoke(ActionEvent e) {
    	Pizza foundPizza = removeTopping();
    	
    	int index = findTopping(foundPizza.getToppings(), Toppings.ARTICHOKES);
    	foundPizza.getToppings()[index] = null;
    	
    	if (index < 6) {
    		moveDown(foundPizza, index);
    	}
    	String top = txtSelectedToppings.getText();
    	int endIndex = top.length();
    	int i = top.indexOf("Artichoke Hearts");
    	top = top.substring(0, i) + top.substring(i+17, endIndex);
    	txtSelectedToppings.setText(top);
    	
    	artichokeAdd.setDisable(false);
    	artichokeRemove.setDisable(true);
    }
    
    public void removeOnions(ActionEvent e) {
    	Pizza foundPizza = removeTopping();
    	
    	int index = findTopping(foundPizza.getToppings(), Toppings.ONIONS);
    	foundPizza.getToppings()[index] = null;
    	
    	if (index < 6) {
    		moveDown(foundPizza, index);
    	}
    	String top = txtSelectedToppings.getText();
    	int endIndex = top.length();
    	int i = top.indexOf("Onions");
    	top = top.substring(0, i) + top.substring(i+7, endIndex);
    	txtSelectedToppings.setText(top);
    	
    	onionsAdd.setDisable(false);
    	onionsRemove.setDisable(true);
    }
    
    public void removeOlives(ActionEvent e) {
    	Pizza foundPizza = removeTopping();
    	
    	int index = findTopping(foundPizza.getToppings(), Toppings.OLIVES);
    	foundPizza.getToppings()[index] = null;
    	
    	if (index < 6) {
    		moveDown(foundPizza, index);
    	}
    	String top = txtSelectedToppings.getText();
    	int endIndex = top.length();
    	int i = top.indexOf("Olives");
    	top = top.substring(0, i) + top.substring(i+7, endIndex);
    	txtSelectedToppings.setText(top);
    	
    	olivesAdd.setDisable(false);
    	olivesRemove.setDisable(true);
    }
    
    public void removeHam(ActionEvent e) {
    	Pizza foundPizza = removeTopping();
    	
    	int index = findTopping(foundPizza.getToppings(), Toppings.HAM);
    	foundPizza.getToppings()[index] = null;
    	
    	if (index < 6) {
    		moveDown(foundPizza, index);
    	}
    	String top = txtSelectedToppings.getText();
    	int endIndex = top.length();
    	int i = top.indexOf("Ham");
    	top = top.substring(0, i) + top.substring(i+4, endIndex);
    	txtSelectedToppings.setText(top);
    	
    	hamAdd.setDisable(false);
    	hamRemove.setDisable(true);
    }
    
    public void removePineapple(ActionEvent e) {
    	Pizza foundPizza = removeTopping();
    	
    	int index = findTopping(foundPizza.getToppings(), Toppings.PINEAPPLE);
    	foundPizza.getToppings()[index] = null;
    	
    	if (index < 6) {
    		moveDown(foundPizza, index);
    	}
    	String top = txtSelectedToppings.getText();
    	int endIndex = top.length();
    	int i = top.indexOf("Pineapple");
    	top = top.substring(0, i) + top.substring(i+10, endIndex);
    	txtSelectedToppings.setText(top);
    	
    	pineappleAdd.setDisable(false);
    	pineappleRemove.setDisable(true);
    }
    
    public void removePepperoni(ActionEvent e) {
    	Pizza foundPizza = removeTopping();
    	
    	int index = findTopping(foundPizza.getToppings(), Toppings.PEPPERONI);
    	foundPizza.getToppings()[index] = null;
    	
    	if (index < 6) {
    		moveDown(foundPizza, index);
    	}
    	String top = txtSelectedToppings.getText();
    	int endIndex = top.length();
    	int i = top.indexOf("Pepperoni");
    	top = top.substring(0, i) + top.substring(i+10, endIndex);
    	txtSelectedToppings.setText(top);
    	
    	pepperoniAdd.setDisable(false);
    	pepperoniRemove.setDisable(true);
    	
    }
    
    public void addToOrder() {
		try {
			Stage newStage = new Stage();
	    	VBox popup = new VBox();
			Label notif  = new Label("\n\n\t\t Successfully Added to Order.");
	    	popup.getChildren().add(notif);
	    	Scene stageScene = new Scene(popup, 250, 100);
	    	newStage.setScene(stageScene);
	    	newStage.setTitle("Order Confirmation");
	    	newStage.show();
	    	return;
		} catch(Exception e) {
			e.printStackTrace();
		}
    }
    
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
    			e.printStackTrace();
    		}
    	}
    	
    	return true;
    }
    
    public Pizza addTopping() {
    	Pizza newPizza = new Pizza(orderNum);
    	
    	Pizza foundPizza = orders.getPizza(newPizza);
    	foundPizza.setNoToppings(foundPizza.getNoToppings() + 1);
    	if (!checkToppings(foundPizza.getNoToppings())) {
    		return null;
    	}
    	
    	return foundPizza;
    }
    
    public Pizza removeTopping() {
    	Pizza newPizza = new Pizza(orderNum);
    	
    	Pizza foundPizza = orders.getPizza(newPizza);
    	foundPizza.setNoToppings(foundPizza.getNoToppings() - 1);
    	return foundPizza;
    }
    
    public int findTopping(Toppings[] toppings, Toppings topping) {
    	for (int i = 0; i < 7; i++) {
    		if (toppings[i] == topping) {
    			return i;
    		}
    	}
    	
    	return -1;
    }
    
    public void moveDown(Pizza foundPizza, int index) {
		while (index < 6) {
			foundPizza.getToppings()[index] = foundPizza.getToppings()[index+1];
			index++;
		}
		
		foundPizza.getToppings()[index] = null;
    }
    
	public int findEmptySpotToppings(Toppings[] toppings) {
		for (int i = 0; i < toppings.length; i++) {
			if (toppings[i] == null) {
				return i;
			}
		}
		return -1;
	}
	
	public void forgetPizza() {
		boolean b = orders.remove(thePizza);
	}
}
