package GUI;

import java.io.IOException;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.Inputs;

public class GruppenController
{
	private Stage stage;
	
	@FXML
	private Button goBackButton;
	
	@FXML 
	private Button saveButton;
	
	@FXML 
	private Button newButton;
	
	@FXML
	private ScrollPane gruppenParent;
	
	@FXML
	private Label grpSizeLabel;
	
	@FXML
    public void initialize() 
	{  
		/** für Test da Datenbank nicht funktioniert **/
		int students = 23;
		int numberOfGroups = Inputs.getGroupCount();
		int groupSize = Inputs.getGroupSize();
		if(Inputs.isUseGroupSize())
		{
			groupSize = Inputs.getGroupSize();
			numberOfGroups = students / groupSize;
			if(students % groupSize !=0)
			{
				numberOfGroups++;
			}
		}
		else
		{
			numberOfGroups = Inputs.getGroupCount();
			groupSize = students / numberOfGroups;
			if(students % numberOfGroups !=0)
			{
				groupSize++;
			}
		}
		
		/**											**/
		
		if(Inputs.getAllGroups().size()!=0 && Inputs.getAllGroups() != null)
		{
			numberOfGroups = Inputs.getAllGroups().size();
			groupSize = Inputs.getAllGroups().get(0).getMembers().size();
		}
		if(numberOfGroups==1)
		{
			grpSizeLabel.setText(numberOfGroups+" Gruppe mit je "+groupSize+" Studierenden");
		}
		else
		{
			grpSizeLabel.setText(numberOfGroups+" Gruppen mit je "+groupSize+" Studierenden");
		}
		
		buildGroupView( numberOfGroups, groupSize, students);
	}
	
	private void buildGroupView(int numberOfGroups, int groupSize, int students) 
	{
		VBox groupRack = new VBox();
		groupRack.setSpacing(5.0);
		for(int i = 1; i<= numberOfGroups; i++)
		{
			VBox grpContainer = new VBox();
			grpContainer.setId("grp_"+i+"_container");
			grpContainer.setStyle("-fx-border-color: grey; -fx-border-radius: 5px;");
			grpContainer.setPadding(new Insets(5,5,5,5));
			
			Label grpTitle = new Label("Gruppe "+i);
			grpTitle.setPadding(new Insets(0,0,0,5));
						
			grpContainer.getChildren().add(grpTitle);
			HBox row_task = new HBox(2);
			row_task.setId("row_task");
			row_task.setStyle("-fx-border-color: gray; -fx-border-radius: 5px;");
			
			grpContainer.getChildren().add(row_task);
			for(int rows = 0; rows < groupSize / 2 + groupSize % 2; rows++)
			{
				HBox extraRow = new HBox();
				extraRow.setId("row_"+rows);
				extraRow.setSpacing(15.0);
				grpContainer.getChildren().add(extraRow);
			}
			
			for(int block = 0; block < groupSize; block++)
			{
				HBox studentContainer = new HBox();
				studentContainer.setId("studentContainer_"+block);
				
				ImageView studentIMG = new ImageView(new Image("dummy-user.jpg"));
				
				//Bildformatierung
				studentIMG.setFitWidth(80);
				studentIMG.setPreserveRatio(true);
				studentIMG.setSmooth(true);
				studentIMG.setCache(true);

				studentIMG.setId("studentIMG_"+block);
				studentContainer.getChildren().add(studentIMG);
				
				VBox infoContainer = new VBox();
				Label name = new Label("Max Mustermann_"+block);
				name.setId("name_"+block);
				name.setStyle("-fx-pref-width: 160;");
				name.setPadding(new Insets(5,0,0,5));
				
				Label classID = new Label("ib_test");
				classID.setId("classID_"+block);
				classID.setPadding(new Insets(5,0,0,5));
				
				CheckBox checkBox = new CheckBox();
				checkBox.setId("checkBox_"+block);
				checkBox.setPadding(new Insets(5,0,0,5));
				
				infoContainer.getChildren().addAll(name, classID, checkBox);
				studentContainer.getChildren().add(infoContainer);
				
				int row_num = block / 2 ;
				
				for(Node c: grpContainer.getChildren()){
					if(c.getId()!=null)
					{
						if(c.getId().equals("row_"+row_num))
						{
							(((HBox) c).getChildren()).add(0, studentContainer);
						}
					}
				}
					
			}
			HBox taskRow = new HBox();
			VBox taskPoolBox = new VBox();
			VBox taskBox = new VBox();
						
			Label labelTaskPool = new Label("Aufgabenpool");
			
			ChoiceBox<String> taskPoolChoice = new ChoiceBox<String>();
			taskPoolChoice.setId("taskPoolChoice_"+i);
			taskPoolChoice.getStylesheets().add(
	                getClass().getResource(
	                        "choice-size.css"
	                ).toExternalForm()
	        );
			ObservableList<String> taskPoolList = FXCollections.observableArrayList("Paul","Stefan");
			taskPoolChoice.setItems(taskPoolList);
			
			taskPoolChoice.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
			      @Override
			      public void changed(ObservableValue<? extends Number> observableValue, Number number, Number number2) {
			        System.out.println(taskPoolChoice.getItems().get((Integer) number2));
			      }
			    });
			
			Label labelTasks = new Label("Aufgaben");
			
			ChoiceBox<String> taskChoice = new ChoiceBox<String>();
			taskChoice.setId("taskChoice_"+i);
			taskChoice.getStylesheets().add(
	                getClass().getResource(
	                        "choice-size.css"
	                ).toExternalForm()
	        );
			ObservableList<String> taskList = FXCollections.observableArrayList(" kloppen"," streicheln");
			taskChoice.setItems(taskList);
			taskChoice.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
			      @Override
			      public void changed(ObservableValue<? extends Number> observableValue, Number number, Number number2) {
			        System.out.println(taskChoice.getItems().get((Integer) number2));
			      }
			    });

			taskPoolBox.getChildren().addAll(labelTaskPool, taskPoolChoice);
			taskBox.getChildren().addAll(labelTasks, taskChoice);
			
			VBox.setMargin(labelTaskPool, new Insets(5,5,0,5));
			VBox.setMargin(taskPoolChoice, new Insets(5,5,5,5));
			VBox.setMargin(labelTasks, new Insets(5,5,0,5));
			VBox.setMargin(taskChoice, new Insets(5,5,5,5));
			
			taskRow.getChildren().addAll(taskPoolBox, taskBox);
			row_task.getChildren().add(taskRow);
			
			
			groupRack.getChildren().add(grpContainer);
			
		}
		gruppenParent.setFitToWidth(true);
		gruppenParent.setContent(groupRack);
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
	
	@FXML
	void saveClicked()
	{
		
	}
	
	@FXML
	void newClicked()
	{
		
	}
	
	
	public void setStage(Stage s) 
	{
		stage = s;
	}
}
