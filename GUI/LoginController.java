import java.io.IOException;

import model.Inputs;
import database.LoginDatabase;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
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
	@FXML
	private ToggleGroup locationGroup;
	@FXML
	private RadioButton PBRadio;
	@FXML
	private RadioButton BIRadio;
	
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
			if(login && !Inputs.getLocation().isEmpty())
			{
				
				Inputs.setLoggedInAs(username.toUpperCase());
				
				FXMLLoader Loader = new FXMLLoader(getClass().getResource("hauptmenue.fxml"));
				Parent rootMain = Loader.load();
				Scene sceneMain = new Scene( rootMain,600,400);
				stage.setTitle("Hauptmenü");
				stage.setScene(sceneMain);
				HauptmenueController controllerMain = 
						Loader.<HauptmenueController>getController();
				controllerMain.setStage(stage);
				
			}
			//wird mit Absicht ohne Abfrage über ToggleGroup gelöst
			else if(Inputs.getLocation().isEmpty())
			{
				locationMissing();
			}
			else
			{
				loginFailed();
			}
		}
		else 
		{
			loginFailed();
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
	private void loginFailed()
	{
		user.requestFocus();
		errormsg.setText("Login fehlgeschlagen. Überprüfen Sie ihre Daten!");
	}
	private void locationMissing()
	{
		errormsg.setText("Standort angeben!");
	}
	@FXML
	void setLocationToPB()
	{
		Inputs.setLocation("PB");
		if(user.getText().equals(""))
		{
			user.requestFocus();
		}
		else
		{
			pass.requestFocus();
		}
	}
	@FXML
	void setLocationToBI()
	{
		Inputs.setLocation("BI");
		if(user.getText().equals(""))
		{
			user.requestFocus();
		}
		else
		{
			pass.requestFocus();
		}
	}
	
}
