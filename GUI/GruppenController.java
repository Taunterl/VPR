
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class GruppenController
{
	private Stage stage;
	
	@FXML
	private Button goBackButton;
	
	@FXML 
	private Button saveButton;
	
	@FXML 
	private Button newButton;
	
	private void buildGroupView(int numberOfGroups, int groupSize) 
	{
		for(int i = 1; i<= numberOfGroups; i++)
		{
			VBox grpContainer = new VBox();
			grpContainer.setId("grp_"+i+"_container");
			//grpContainer.se);
			HBox row_1 = new HBox();
			row_1.setId("row_1");
			HBox row_2 = new HBox();
			row_2.setId("row_2");
			grpContainer.getChildren().addAll(row_1, row_2);
			
			for(int rows = 2; rows < groupSize / 2; rows++)
			{
				HBox extraRow = new HBox();
				extraRow.setId("row_"+rows);
				grpContainer.getChildren().add(extraRow);
			}
			
			for(int block = 0; block < groupSize; block++)
			{
				HBox studentContainer = new HBox();
				studentContainer.setId("studentContainer_"+block);
				ImageView studentIMG = new ImageView();
				studentIMG.setId("studentIMG_"+block);
				studentContainer.getChildren().add(studentIMG);
				VBox infoContainer = new VBox();
				Label name = new Label();
				name.setId("name_"+block);
				Label classID = new Label();
				classID.setId("classID_"+block);
				CheckBox checkBox = new CheckBox();
				checkBox.setId("checkBox_"+block);
				infoContainer.getChildren().addAll(name, classID, checkBox);
				studentContainer.getChildren().add(infoContainer);
				
				int row_num =  block / 2 ;
				
				((HBox) grpContainer.getChildren().get(grpContainer.getChildren().indexOf("row_"+row_num))).getChildren().add(0, studentContainer);
			}
			
			VBox taskPoolBox = new VBox();
			VBox taskBox = new VBox();
			
			Label labelTaskPool = new Label("Aufgabenpool");
			ChoiceBox taskPoolChoice = new ChoiceBox();
			taskPoolChoice.setId("taskPoolChoice_"+i);
			ObservableList<String> taskList = FXCollections.observableArrayList("Paul kloppen","Paul streicheln");
			
			Label labelTasks = new Label("Aufgabenpool");
			ChoiceBox taskChoice = new ChoiceBox();
			taskChoice.setId("taskChoice_"+i);
			
			taskPoolBox.getChildren().addAll(labelTaskPool, taskPoolChoice);
			taskBox.getChildren().addAll(labelTasks, taskChoice);
			
			row_1.getChildren().add(taskPoolBox);
			row_2.getChildren().add(taskBox);
			
			grpContainer.getChildren().addAll(row_1, row_2);
			
			
		}
		
	}
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
