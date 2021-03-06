package GUI;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddTaskController 
{
	
	private int PoolID = 0;
	
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
	private Button addTaskButton;
	
	@FXML
	private Button goBackButton;
	
	public void initialize() {
		
	}
	
	public void addTaskButtonClicked(ActionEvent e) throws IOException
	{
		Save();
		goBack();
	}
	
	public void setPoolID(int PoolID)
	{
		this.PoolID= PoolID;
	}
	
	public int getPoolID()
	{
		return this.PoolID;
	}
	
	public void goBackClicked(ActionEvent e) throws IOException
	{
		goBack();
	}
	
	private void Save()
	{
		if(model.Controller.checkTaskPool(this.PoolID))
		{
			model.Controller.createTask(this.PoolID, fieldName.getText(), fieldDescription.getText(), fieldCategory.getText(), fieldTime.getText());
			System.out.println("Saved");
		}
		
	}
	
	private void goBack() throws IOException
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

	public void setStage(Stage s,int PoolID) {
		this.stage = s;
		setPoolID(PoolID);
		fieldPool.setText(Integer.toString(getPoolID()));
		
	}
	
	
}
