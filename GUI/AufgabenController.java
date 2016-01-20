package GUI;

import java.io.IOException;

import model.Aufgaben;
import model.Controller;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBase;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
//neuer test
public class AufgabenController 
{
	private Stage stage;
	
	@FXML
	private Button goBackButton;
	
	@FXML
	private TableColumn<String,String> columnName;
	
	@FXML
	private TableColumn<String,String> columnNr;
	
	@FXML
	private TableColumn<String,String> columnDescribe;
	
	@FXML
	private TableColumn<String,String> columnTime;
	
	
	@FXML
	private TableView<String> aufgabenTabelle;
	
	
	
	@FXML
	private TableColumn columnCategory;
	
	@FXML
	private TableColumn columnPool;

	@FXML
	private ChoiceBox<String> aufgabenChoice;
	
	@FXML
	private Button starButton;
	
	@FXML
	private Button addTask;
	
	@FXML
	private Button plusButton;
	
	@FXML
	private Button uebersichtButton;
	
	public void initialize() 
	{   
	 		Controller.dbconnect();
	 		ObservableList<String> PoolList = Controller.getPools();
	 		aufgabenChoice.setItems(PoolList);
	 		
 	        System.out.println("init-AufgabenController");
 	        aufgabenTabelle.setEditable(true);
 	        
 	        columnNr.setCellValueFactory(new PropertyValueFactory<>("id"));
 	        columnName.setCellValueFactory(new PropertyValueFactory<>("name"));
 	        columnDescribe.setCellValueFactory(new PropertyValueFactory<>("describtion"));
 	        columnTime.setCellValueFactory(new PropertyValueFactory<>("time"));
 	        columnCategory.setCellValueFactory(new PropertyValueFactory<>("category"));
 	        columnPool.setCellValueFactory(new PropertyValueFactory<>("pool"));

 	        aufgabenChoice.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
			      @Override
			      public void changed(ObservableValue<? extends Number> observableValue, Number number, Number number2) {
			        System.out.println(aufgabenChoice.getItems().get((Integer) number2));
			      }
			    });
	}
	
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
	 @FXML
     	void goToAddTask(ActionEvent e) throws IOException
	{
    	 
    		 FXMLLoader loader = new FXMLLoader(getClass().getResource("aufgabe.fxml"));
    		 Parent rootAddTask = loader.load();
    	 	Scene sceneAddTask = new Scene(rootAddTask, 450, 300 );
    	 	stage.setTitle("Aufgabe hinzufgen");
    	 	stage.setScene(sceneAddTask);
    	 	AddTaskController controllerAddTask = loader.<AddTaskController>getController();
    	 	controllerAddTask.setStage(stage);
        }
        
     private void changeTable() {
    	 // TODO Auto-generated method stub
    	 for(Aufgaben a: getProduct()){
    		 ObservableList<String> tasks = FXCollections.observableArrayList();
    		 tasks.add(a.getName());
    		 aufgabenTabelle.setItems(tasks);
    	 }
    	 
     }
     
     public ObservableList<Aufgaben> getProduct(){
    	 
         ObservableList<Aufgaben> tasks = FXCollections.observableArrayList();
         tasks.add(new Aufgaben(1,"Laptop","Hallo", "40" , "Proggn","OPR"));
         tasks.add(new Aufgaben(2,"WARUM","Hallo", "50" , "Jesus","OPR"));

         return tasks;
     }
}
