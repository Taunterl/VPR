import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddTaskController 
{
	private Stage stage;

	@FXML
	private TextField fieldName;
	
	@FXML
	private TextField fieldDescription;
	
	@FXML
	private TextField fieldTime;
	
	@FXML
	private TextField fieldCategory;
	
	@FXML
	private TextField fieldPool;
	
	@FXML
	private Button addTask;

	public void setStage(Stage s) {
		this.stage = s;
		
	}
	
	
}
