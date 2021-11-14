package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

/**
This class contains the main method that runs the software
@author Emily Nelson, Cristofer Gomez-Martinez
*/
public class Main extends Application {
	
    public StoreOrders storeOrders = new StoreOrders();
    public void makeStoreOrders() {
    	 Order[] allOrders = new Order[10];
    	 storeOrders.setAllOrders(allOrders);
    }
    
	@Override
	public void start(Stage primaryStage) {
		AnchorPane root = new AnchorPane();
		try {
			
			makeStoreOrders();
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("View.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            MainController mainCont = fxmlLoader.getController();
 
            mainCont.setStoreOrders(storeOrders);
            
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));  
            stage.setTitle("RU Pizzeria");
            stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
