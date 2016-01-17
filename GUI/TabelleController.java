import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TabelleController 
{
	private Stage stage;
	
	@FXML
	private HBox hBox;
	
	@FXML
	private VBox vBox1;
	
	@FXML
	private VBox vBox2;
	
	
	@FXML
	private Button goBackButton;
	
	@FXML
	private ImageView studentImage;
	
	@FXML
	private TextField nameField;
	
	@FXML
	private Button uebersichtButton;
	
	@FXML
	private Button imagePlusButton;
	
	@FXML
	private Button plusButton;

	@FXML
	private TableView<String> classTable;
	
	@FXML
	private ChoiceBox<String> classChoice;
	
	@FXML
	void uebersichtClicked(ActionEvent e)throws IOException
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
	void goBackClicked(ActionEvent e) throws Exception
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
	
	@FXML
	void addNameField()
	{
		
	}
	
	@FXML
	void imagePlusClicked()
	{
		
	}	
	
	@FXML
	void plusClicked()
	{
		
	}
	
	public void setStage(Stage s)
	{
		 stage = s;
	}
}
