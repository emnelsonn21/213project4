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
import javafx.scene.control.MenuButton;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
    
    
    public void setPicDeluxe() {
    	Toppings[] defaultDeluxeToppings = new Toppings[]{Toppings.SAUSAGE, Toppings.MUSHROOMS, Toppings.ARTICHOKES, Toppings.ONIONS, Toppings.OLIVES};
    	Deluxe newDeluxe = new Deluxe(Size.SMALL, defaultDeluxeToppings, 14.99);
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
    	
    	newDeluxe.calculatePrice();
    	txtPrice.setText(String.valueOf(newDeluxe.getPrice()));
    	
    	
    	
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
    
    public void addSausage(ActionEvent e) {
    	txtSelectedToppings.appendText("Sausage\n");
    	sausageAdd.setDisable(true);
    	sausageRemove.setDisable(false);
    }
    
    public void addMushroom(ActionEvent e) {
    	txtSelectedToppings.appendText("Mushrooms\n");
    	mushroomAdd.setDisable(true);
    	mushroomRemove.setDisable(false);
    }
    
    public void addArtichoke(ActionEvent e) {
    	txtSelectedToppings.appendText("Artichoke Hearts\n");
    	artichokeAdd.setDisable(true);
    	artichokeRemove.setDisable(false);
    }
    
    public void addOnions(ActionEvent e) {
    	txtSelectedToppings.appendText("Onions\n");
    	onionsAdd.setDisable(true);
    	onionsRemove.setDisable(false);
    }
    
    public void addOlives(ActionEvent e) {
    	txtSelectedToppings.appendText("Olives\n");
    	olivesAdd.setDisable(true);
    	olivesRemove.setDisable(false);
    }
    
    public void addHam(ActionEvent e) {
    	txtSelectedToppings.appendText("Ham\n");
    	hamAdd.setDisable(true);
    	hamRemove.setDisable(false);
    }
    
    public void addPineapple(ActionEvent e) {
    	txtSelectedToppings.appendText("Pineapple\n");
    	pineappleAdd.setDisable(true);
    	pineappleRemove.setDisable(false);
    }
    
    public void addPepperoni(ActionEvent e) {
    	txtSelectedToppings.appendText("Pepperoni\n");
    	pepperoniAdd.setDisable(true);
    	pepperoniRemove.setDisable(false);
    }
    
    public void removeSausage(ActionEvent e) {
    	String top = txtSelectedToppings.getText();
    	int endIndex = top.length();
    	int i = top.indexOf("Sausage");
    	top = top.substring(0, i) + top.substring(i+8, endIndex);
    	txtSelectedToppings.setText(top);
    	
    	sausageAdd.setDisable(false);
    	sausageRemove.setDisable(true);
    }
    
    public void removeMushroom(ActionEvent e) {
    	String top = txtSelectedToppings.getText();
    	int endIndex = top.length();
    	int i = top.indexOf("Mushrooms");
    	top = top.substring(0, i) + top.substring(i+10, endIndex);
    	txtSelectedToppings.setText(top);
    	
    	mushroomAdd.setDisable(false);
    	mushroomRemove.setDisable(true);
    }
    
    public void removeArtichoke(ActionEvent e) {
    	String top = txtSelectedToppings.getText();
    	int endIndex = top.length();
    	int i = top.indexOf("Artichoke Hearts");
    	top = top.substring(0, i) + top.substring(i+17, endIndex);
    	txtSelectedToppings.setText(top);
    	
    	artichokeAdd.setDisable(false);
    	artichokeRemove.setDisable(true);
    }
    
    public void removeOnions(ActionEvent e) {
    	String top = txtSelectedToppings.getText();
    	int endIndex = top.length();
    	int i = top.indexOf("Onions");
    	top = top.substring(0, i) + top.substring(i+7, endIndex);
    	txtSelectedToppings.setText(top);
    	
    	onionsAdd.setDisable(false);
    	onionsRemove.setDisable(true);
    }
    
    public void removeOlives(ActionEvent e) {
    	String top = txtSelectedToppings.getText();
    	int endIndex = top.length();
    	int i = top.indexOf("Olives");
    	top = top.substring(0, i) + top.substring(i+7, endIndex);
    	txtSelectedToppings.setText(top);
    	
    	olivesAdd.setDisable(false);
    	olivesRemove.setDisable(true);
    }
    
    public void removeHam(ActionEvent e) {
    	String top = txtSelectedToppings.getText();
    	int endIndex = top.length();
    	int i = top.indexOf("Ham");
    	top = top.substring(0, i) + top.substring(i+4, endIndex);
    	txtSelectedToppings.setText(top);
    	
    	hamAdd.setDisable(false);
    	hamRemove.setDisable(true);
    }
    
    public void removePineapple(ActionEvent e) {
    	String top = txtSelectedToppings.getText();
    	int endIndex = top.length();
    	int i = top.indexOf("Pineapple");
    	top = top.substring(0, i) + top.substring(i+10, endIndex);
    	txtSelectedToppings.setText(top);
    	
    	pineappleAdd.setDisable(false);
    	pineappleRemove.setDisable(true);
    }
    
    public void removePepperoni(ActionEvent e) {
    	String top = txtSelectedToppings.getText();
    	int endIndex = top.length();
    	int i = top.indexOf("Pepperoni");
    	top = top.substring(0, i) + top.substring(i+10, endIndex);
    	txtSelectedToppings.setText(top);
    	
    	pepperoniAdd.setDisable(false);
    	pepperoniRemove.setDisable(true);
    	
    }
    
    public void priceChange(ActionEvent e) {
    	
    }
}
