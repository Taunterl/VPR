
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class HauptmenueController 
{
	@FXML
	private ChoiceBox<String> klasseAuswaehlenBox;
	@FXML
	private Button beendenButton;
	
	@FXML
	private Button chooseStudentButton;
	
	@FXML
	private ImageView studentImage;
	
	@FXML
	private Button gruppenWuerfelnButton;
	
	@FXML
	private Button aufgabenZuteilenButton;
	
	@FXML
	private Button gotoTableButton;
	
	@FXML
	private RadioButton gruppenGroesseRadio;
	
	@FXML
	private Label studentName;
	
	@FXML
	private Label classID;
	
	@FXML
	private RadioButton gruppenAnzahlRadio;
	
	@FXML
	private TextField gruppenGroesseText;
	
	@FXML
	private Button starButton;
	
	@FXML
	private Button plusButton;
	
	@FXML
	private Button minusButton;
	
	@FXML
	private Button uebersichtButton;
	
	private Stage stage;
	
	@FXML
	void gotoTableClicked(ActionEvent e) throws IOException
	{
			FXMLLoader testLoader = new FXMLLoader(getClass().getResource("tabelle.fxml"));
			Parent root2 = testLoader.load();
			Scene testScene = new Scene(root2,600,500);
			stage.setTitle("KlassenTabelle");
			stage.setScene(testScene);
			TabelleController controller2 = 
					testLoader.<TabelleController>getController();
			controller2.setStage(stage);
			
	}
	public void setStage(Stage s) 
	{
		stage=s;
		
	}

	@FXML
	void uebersichtClicked(ActionEvent e)throws IOException
	{
		FXMLLoader testLoader = new FXMLLoader(getClass().getResource("uebersicht.fxml"));
		Parent root3 = testLoader.load();
		Scene testScene = new Scene(root3,600,400);
		stage.setTitle("Uebersicht");
		stage.setScene(testScene);
		UebersichtController controller3 = 
				testLoader.<UebersichtController>getController();
		controller3.setStage(stage);
	}
	
	
	@FXML
	void minusClicked()
	{
		
	}
	
	
	@FXML 
	void plusClicked()
	{
		
	}
	
	@FXML
	void starClicked()
	{
		
	}
	
	@FXML
	void addGruppenGroesse()
	{
		
	}
	
	@FXML
	void gruppenAnzahlClicked()
	{
		
	}
	
	@FXML
	void gruppenGroesseClicked()
	{
		
	}
	
	@FXML
	void beendenButtonClicked()
	{
		System.exit(0);
	}
	
	@FXML
	void chooseStudentClicked()
	{
		
	}
	
	@FXML
	void gruppenWuerfelnClicked(ActionEvent e) throws IOException
	{
		FXMLLoader testLoader = new FXMLLoader(getClass().getResource("gruppen.fxml"));
		Parent root5 = testLoader.load();
		Scene testScene = new Scene(root5,600,400);
		stage.setTitle("Gruppenbildung");
		stage.setScene(testScene);
		GruppenController controller5 = 
				testLoader.<GruppenController>getController();
		controller5.setStage(stage);
	}
	
	@FXML
	void aufgabenZuteilenClicked(ActionEvent e) throws IOException
	{
		FXMLLoader testLoader = new FXMLLoader(getClass().getResource("aufgaben.fxml"));
		Parent root4 = testLoader.load();
		Scene testScene = new Scene(root4,600,400);
		stage.setTitle("Aufgaben");
		stage.setScene(testScene);
		AufgabenController controller4 = 
				testLoader.<AufgabenController>getController();
		controller4.setStage(stage);
	}
}
