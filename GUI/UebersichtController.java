package GUI;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Pagination;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.Inputs;
import model.Student;

public class UebersichtController 
{
	@FXML
	private Button goBackButton;
	@FXML
	private AnchorPane classPages;
	
	private Pagination pagination;
	
	private Stage stage;
	
	@FXML
	void initialize(){
		Inputs.setActiveStudents();
		System.out.println(Inputs.getActiveStudents().size() / itemsPerPage());
		int pages = Inputs.getActiveStudents().size() / itemsPerPage();
		if(Inputs.getActiveStudents().size() % itemsPerPage() != 0)
		{
			pages++;
		}
		pagination = new Pagination(pages, 0);
	    pagination.setPageFactory((Integer pageIndex) -> createPage(pageIndex));
	    
	    AnchorPane.setRightAnchor(pagination, 10.0);
	    AnchorPane.setBottomAnchor(pagination, 10.0);
	    AnchorPane.setLeftAnchor(pagination, 10.0);
	    classPages.getChildren().addAll(pagination);
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
	
	private int itemsPerPage()
	{
		return 9;
	}

	public VBox createPage(int pageIndex) {
		VBox box = new VBox();
		HBox lineOne = new HBox();
		HBox lineTwo = new HBox();
		HBox lineTree = new HBox();
		int page = pageIndex * itemsPerPage();
		int maxItems = Inputs.getActiveStudents().size();
		int itemRange = page + itemsPerPage();
		if(maxItems < itemRange)
		{
			itemRange = maxItems;
		}
		int lines = 0;
		for (int item = page; item < itemRange ; item++) 
		{				
			if(lines / 3 == 0)
			{					
				lineOne.getChildren().add(createStudentBlock(Inputs.getActiveStudents().get(item)));
			}
			else if(lines / 3 == 1)
			{
				lineTwo.getChildren().add(createStudentBlock(Inputs.getActiveStudents().get(item)));
			}
			else
			{
				lineTree.getChildren().add(createStudentBlock(Inputs.getActiveStudents().get(item)));
			}
					
					
			lines++;
		}
		
			
		box.getChildren().addAll(lineOne,lineTwo,lineTree);
		
		return box;
	}
	
	private HBox createStudentBlock(Student student)
	{
		HBox container = new HBox(2);
		ImageView img = new ImageView();
		
		if(student.getPicture()!=null)
		{
			img.setImage(new Image(student.getPicture()));
			
	        img.setFitWidth(100);
	        img.setPreserveRatio(true);
	        img.setSmooth(true);
	        img.setCache(true);
		}
		VBox lines = new VBox(3);
		Label name = new Label(student.getName()+", "+student.getSecondName());	//
		Label studentID = new Label(student.getStudentID());	//
		lines.getChildren().addAll(name, studentID);
		container.getChildren().addAll(img, lines);
		
		return container;
		
	}
	
}
