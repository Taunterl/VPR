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
		FXMLLoader Loader = new FXMLLoader(getClass().getResource("uebersicht.fxml"));
		Parent rootOverview = Loader.load();
		Scene sceneOverview = new Scene(rootOverview,600,500);
		stage.setTitle("Uebersicht");
		stage.setScene(sceneOverview);
		UebersichtController controllerOverview = 
				Loader.<UebersichtController>getController();
		controllerOverview.setStage(stage);
	}
	
	@FXML
	void goBackClicked(ActionEvent e) throws IOException
	{
		FXMLLoader Loader = new FXMLLoader(getClass().getResource("hauptmenue.fxml"));
		Parent rootMain = Loader.load();
		Scene sceneMain = new Scene( rootMain,600,400);
		stage.setTitle("Hauptmenü");
		stage.setScene(sceneMain);
		HauptmenueController controllerMain = 
				Loader.<HauptmenueController>getController();
		controllerMain.setStage(stage);
	}

	public void setStage(Stage s) 
	{
		stage = s;
		
	}
	
	@FXML
	void plusClicked()
	{
		
	}
	
	@FXML
	void starClicked()
	{
		
	}
	
	
	
	
}
