package GUI;

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
	
	@FXML
	private Button addTaskButton;
	
	@FXML
	private Button goBackButton;
	
	public void addTaskButtonClicked(ActionEvent e)
	{
		
	}
	
	public void goBackClicked(ActionEvent e) throws IOException
	{
		FXMLLoader Loader = new FXMLLoader(getClass().getResource("aufgaben.fxml"));
		Parent rootTasks = Loader.load();
		Scene sceneTasks = new Scene(rootTasks,600,400);
		stage.setTitle("Aufgaben");
		stage.setScene(sceneTasks);
		AufgabenController controllerTasks = 
				Loader.<AufgabenController>getController();
		controllerTasks.setStage(stage);
	}

	public void setStage(Stage s) {
		this.stage = s;
		
	}
	
	
}
