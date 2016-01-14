import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController  
{

	@FXML
	private Button loginBtn;
	@FXML
	private TextField user;
	@FXML 
	private PasswordField pass;
	
	
	private Stage stage;
	@FXML
	void close(ActionEvent e)
	{
		System.exit(0);
	}
	@FXML
	void login(ActionEvent e)throws IOException
	{
		if(user.getText().equals("Benutzer") 
						&& pass.getText().equals("pass"))
		{
		FXMLLoader testLoader = new FXMLLoader(getClass().getResource("test.fxml"));
		Parent root1 = testLoader.load();
		Scene testScene = new Scene( root1,500,300);
		stage.setTitle("Test");
		stage.setScene(testScene);
		HauptmenueController controller1 = 
				testLoader.<HauptmenueController>getController();
		
		}
		else                      //Testfall
		{
			System.out.println("Benutzer oder Passwort falsch");
		}
	}
	public void setStage(Stage s)  
	{
		stage=s;
	}
}
