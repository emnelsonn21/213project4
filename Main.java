package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;


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

			root = (AnchorPane)FXMLLoader.load(getClass().getResource("View.fxml"));
			Scene scene = new Scene(root,675,538);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("RU Pizzeria");
			primaryStage.show();
			
			makeStoreOrders();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("View.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            MainController mainCont = fxmlLoader.getController();    
            mainCont.setStoreOrders(storeOrders);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
