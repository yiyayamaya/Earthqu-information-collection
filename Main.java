package DIY2;
	
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			  Parent root = FXMLLoader.load(getClass().getResource("/DIY2/MainUI.fxml"));
	            primaryStage.setTitle("EarthquakeAnalyzer");
	            primaryStage.setScene(new Scene(root));
	            primaryStage.show();
	            primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {

	                //close the database when the window is closed
	                @Override
	                public void handle(WindowEvent event) {
	                    //database.closeDatabase();
	                }
	            });
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
