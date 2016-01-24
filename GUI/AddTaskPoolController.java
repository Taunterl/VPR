package GUI;

import java.io.IOException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddTaskPoolController 
{
	private Stage stage;
	
	@FXML
	private ChoiceBox<String> choiceDozID;
	
	@FXML
	private TextField fieldFach;
	
	@FXML
	private TextField fieldBeschreibung;

	@FXML
	private Button createNewTaskPool;
	
	@FXML
	private Button goBackButton;
	
	
	public void initialize() {
		
		//**für Testzwecke
		ObservableList<String> dozList = FXCollections.observableArrayList("DYC","HIL");
		choiceDozID.setItems(dozList);
	}
	
	public void goBackButtonClicked(ActionEvent e) throws IOException
	{
		goBack();
	}
	
	public void createNewTaskPoolClicked(ActionEvent e) throws IOException
	{
		Save();
		goBack();
	}
	
	private void Save()
	{
		System.out.println(choiceDozID.getValue());
		model.Controller.CreateTaskPool(fieldBeschreibung.getText(), 1, fieldFach.getText(), fieldBeschreibung.getText()); //TODO Dozente auswahl
		System.out.println("Saved");	
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
	
	public void setStage(Stage s) {
		this.stage = s;
		
	}
	
}
