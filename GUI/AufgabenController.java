import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

public class AufgabenController 
{
	private Stage stage;
	
	@FXML
	private Button goBackButton;
	
	@FXML
	private TableView<String> aufgabenTabelle;
	
	
	@FXML
	private ChoiceBox<String> aufgabenChoice;
	
	@FXML
	private Button starButton;
	
	@FXML
	private Button plusButton;
	
	@FXML
	private Button uebersichtButton;
	
	@FXML
	void uebersichtClicked(ActionEvent e) throws IOException
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
	void plusClicked()
	{
		
	}
	
	@FXML
	void starClicked()
	{
		
	}
	
	
	@FXML
	void goBackClicked(ActionEvent e) throws IOException
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

	public void setStage(Stage s) 
	{
		stage = s;
		
	}
	
}
