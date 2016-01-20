package GUI;

import java.io.IOException;
import java.util.ArrayList;

import model.Inputs;
import model.Professor;
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

	public enum ERR_MSG{BAD_USER, NO_MATCH, LOCATION, DB_CON};
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
		/**String username = user.getText().toUpperCase();
		String password = pass.getText();
		
		//prüfen ob Eingaben gemacht wurden
		if(!username.equals("")
				&& username!=null
				&& !password.equals("")
				&& password!=null)
		{
			//User aus der Datenbank abrufen
			
			Professor loginAs = loginProf(username);
			
			//Prüfen ob User gefunden wurde
			
			if(loginAs != null)
			{
				//Passwort überprüfen
				if(loginAs.getPassword().equals(password))
				{
					//Standort gesetzt überprüfen
					if(!Inputs.getLocation().isEmpty())
					{
						Inputs.setLoggedInAs(loginAs);
						Inputs.setActiveClassPool();**/
						
						FXMLLoader Loader = new FXMLLoader(getClass().getResource("hauptmenue.fxml"));
						Parent rootMain = Loader.load();
						Scene sceneMain = new Scene( rootMain,600,400);
						stage.setTitle("Hauptmenü");
						stage.setScene(sceneMain);
						HauptmenueController controllerMain = 
								Loader.<HauptmenueController>getController();
						controllerMain.setStage(stage);/**
					}
					//Fehlernachricht wenn Standort nicht gesetzt
					else
					{
						errorMSG(ERR_MSG.LOCATION);
					}
				}//Fehlernachricht wenn Passwort und User nicht überinestimmen
				else
				{
					errorMSG(ERR_MSG.NO_MATCH);
				}
			}
			//Fehlernachricht wenn User nicht existiert
			else
			{
				errorMSG(ERR_MSG.BAD_USER);
			}
		}
		
		**/
	}
	private Professor loginProf(String loginName)
	{
		/**
		ArrayList<Professor> list = Professor.getByDozentenID(loginName);**/
		
		ArrayList<Professor> list = new ArrayList<Professor>();
		list.add(new Professor("dyc", "Dyck", "Eugen", "test"));
		list.add(new Professor("men", "Menne", "Steffan", "test"));
		list.add(new Professor("vom", "Voss", "Matthias", "test"));
		
		
	/**																	 **/
		Professor professor = null;
		for(Professor p: list)
		{
			if(p.getDozentenID().equalsIgnoreCase(loginName))
			{
				professor = p;
				break;
			}
			
		}
		
		return professor;		
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
	private void errorMSG(ERR_MSG msg)
	{
		
		switch(msg)
		{
		case BAD_USER: 
			user.requestFocus();
			errormsg.setText("Login fehlgeschlagen. Benutzer nicht vorhanden!");
			break;
		case NO_MATCH:
			pass.requestFocus();
			errormsg.setText("Login fehlgeschlagen. Überprüfen Sie ihre Daten!");
			break;
		case LOCATION:
			errormsg.setText("Standort angeben!");
			break;
		case DB_CON:
			errormsg.setText("Datenbankverbindung nicht möglich!");
			break;
		default:
			break;
		}
		
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
