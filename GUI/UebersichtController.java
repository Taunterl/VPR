import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class UebersichtController 
{
	@FXML
	private Button goBackButton;
	
	private Stage stage;
	
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