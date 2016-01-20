package GUI;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class RandomApp extends Application
{

	public static void main(String[] args)
	{
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception 
	{
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("login.fxml"));
		
		primaryStage.setTitle("Login");
		Parent root = fxmlLoader.load();
		Scene loginScene = new Scene(root, 600, 200);
		primaryStage.setScene(loginScene);
		primaryStage.show();
		
		LoginController controller =
				fxmlLoader.<LoginController>getController();
		controller.setStage(primaryStage);
	}	
}
