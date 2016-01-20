package GUI;

import java.io.IOException;

import model.Inputs;
import model.RandomGroups;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import javafx.scene.control.ToggleGroup;
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
	private ToggleGroup groupRadio;
	
	@FXML
	private TextField gruppenGroesseText;
	
	@FXML
	private TextField groupCountField;
	
	@FXML
	private Button starButton;
	
	@FXML
	private Button plusButton;
	
	@FXML
	private Button minusButton;
	
	@FXML
	private Button uebersichtButton;
	
	private static Stage stage;
	
	@FXML
    public void initialize() 
	{   
		gruppenGroesseText.setText(String.valueOf(Inputs.getGroupSize()));
		groupCountField.setText(String.valueOf(Inputs.getGroupCount()));
		if(!Inputs.isUseGroupSize())
		{
			gruppenAnzahlRadio.setSelected(true);
		}
		
		//**für Testzwecke
		ObservableList<String> classList = FXCollections.observableArrayList("ibw2h14a","ibd2h14b");
		klasseAuswaehlenBox.setItems(classList);
		
        System.out.println("init");
        //**
	}
	
	@FXML
	void gotoTableClicked(ActionEvent e) throws IOException
	{
			FXMLLoader Loader = new FXMLLoader(getClass().getResource("tabelle.fxml"));
			Parent rootTable = Loader.load();
			Scene sceneTable = new Scene(rootTable,600,500);
			stage.setTitle("KlassenTabelle");
			stage.setScene(sceneTable);
			TabelleController controllerTable = 
					Loader.<TabelleController>getController();
			controllerTable.setStage(stage);
			
	}
	
	@FXML
	void uebersichtClicked(ActionEvent e)throws IOException
	{
		
		FXMLLoader Loader = new FXMLLoader(getClass().getResource("uebersichtPaged.fxml"));
		Parent rootOverview = Loader.load();
		Scene sceneOverview = new Scene(rootOverview,600,500);
		stage.setTitle("Uebersicht");
		stage.setScene(sceneOverview);
		UebersichtController controllerOverview = 
				Loader.<UebersichtController>getController();
		controllerOverview.setStage(stage);
	}
	
	@FXML
	void gruppenWuerfelnClicked(ActionEvent e) throws IOException
	{
		addGruppenGroesse();
		setGroupCount();
		if(Inputs.isUseGroupSize())
		{
			//Inputs.setAllGroups(RandomGroups.createRandomGroups("size", Integer.parseInt(gruppenGroesseText.getText()), Inputs.getSelectedStudentClasses()));
		}
		else
		{
			//Inputs.setAllGroups(RandomGroups.createRandomGroups("count", Integer.parseInt(groupCountField.getText()), Inputs.getSelectedStudentClasses()));
		}
		
		FXMLLoader Loader = new FXMLLoader(getClass().getResource("gruppen.fxml"));
		Parent rootGroup = Loader.load();
		Scene sceneGroup = new Scene(rootGroup,600,450);
		stage.setTitle("Gruppenbildung");
		stage.setScene(sceneGroup);
		GruppenController controllerGroup = 
				Loader.<GruppenController>getController();
		controllerGroup.setStage(stage);
	}
	
	@FXML
	void aufgabenZuteilenClicked(ActionEvent e) throws IOException
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
	
	public void setStage(Stage s) 
	{
		stage=s;
		
	}	
	
	@FXML
	void minusClicked()
	{
		
	}
	
	
	@FXML 
	void plusClicked()
	{
		klasseAuswaehlenBox.getSelectionModel();
	}
	
	@FXML
	void starClicked()
	{
		
	}
	
	@FXML
	void addGruppenGroesse()
	{
		String pipeline = gruppenGroesseText.getText();
		if(isInteger(pipeline))
		{
			Inputs.setGroupSize(Integer.parseInt(pipeline));
		}
		
	}
	
	@FXML
	void setGroupCount()
	{
		String pipeline = groupCountField.getText();
		if(isInteger(pipeline))
		{
			Inputs.setGroupCount(Integer.parseInt(pipeline));
		}
	}
	
	@FXML
	void gruppenAnzahlClicked()
	{
		Inputs.setUseGroupSize(false);
	}
	
	@FXML
	void gruppenGroesseClicked()
	{
		Inputs.setUseGroupSize(true);
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
	private static boolean isInteger(String s) {
	    try { 
	        Integer.parseInt(s); 
	    } catch(NumberFormatException e) { 
	        return false; 
	    } catch(NullPointerException e) {
	        return false;
	    }
	    return true;
	}
	
	
}
