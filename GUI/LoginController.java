import java.io.IOException;

import database.LoginDatabase;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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
	@FXML
	private Label errormsg;
	
	private Stage stage;
	
	@FXML
	void close(ActionEvent e)
	{
		System.exit(0);
	}
	@FXML
	void login(ActionEvent e)throws IOException
	{
		String username = user.getText();
		String password = pass.getText();
		if(!username.equals("")
				&& username!=null
				&& !password.equals("")
				&& password!=null)
		{
			boolean login = false;
			try 
			{
				login = LoginDatabase.loginValidation(username, password);
			} 
			catch (Exception e1) 
			{
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			if(login)
			{
								
				FXMLLoader testLoader = new FXMLLoader(getClass().getResource("hauptmenue.fxml"));
				Parent root1 = testLoader.load();
				Scene testScene = new Scene( root1,600,400);
				stage.setTitle("Hauptmenü");
				stage.setScene(testScene);
				HauptmenueController controller1 = 
						testLoader.<HauptmenueController>getController();
				controller1.setStage(stage);
				
			}
		}
		else 
		{
			user.requestFocus();
			errormsg.setText("Login fehlgeschlagen. Überprüfen Sie ihre Daten!");
		}
	}
	
	@FXML
	void focusPField()
	{
		pass.requestFocus();
	}
	public void setStage(Stage s)
	{
		stage=s;	
	}
}
