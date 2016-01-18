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
	void addNameField()
	{
		
	}
	
	@FXML
	void imagePlusClicked()
	{
		
	}
	
	
	
	@FXML
	private TableView<String> classTable;
	
	@FXML
	private ChoiceBox<String> classChoice;
	
	@FXML
	void plusClicked()
	{
		
	}
	
	@FXML
	void goBackClicked(ActionEvent e) throws Exception
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
