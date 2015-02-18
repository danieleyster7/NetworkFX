package ch.deyster.network;

import java.io.IOException;

import ch.deyster.network.view.MainDisplayController;
import ch.deyster.network.view.AddItemController;
import ch.deyster.network.model.Network;
import ch.deyster.network.model.Profile;
import javafx.application.Application;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Main extends Application 
{
	private Stage primaryStage;
	private BorderPane rootLayout;
	private Network network;
	private ObservableList<Profile> data = FXCollections.observableArrayList();
	
	public void start(Stage primaryStage) 
	{
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("ADT Testing App");
		this.primaryStage.setResizable(false);
		
		initRootLayout();
		
		showADTDisplay();
	}
	
	public void initRootLayout()
	{
		try
		{
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("view/RootLayout.fxml"));
			rootLayout = (BorderPane) loader.load();
			
			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
			primaryStage.show();			
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void showADTDisplay()
	{
		try
		{
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("view/MainDisplay.fxml"));
			AnchorPane adtDisplay = (AnchorPane) loader.load();
			
			rootLayout.setCenter(adtDisplay);
			
			//TODO: set controller
			MainDisplayController controller = loader.getController();
			controller.setMain(this);
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void showAddItemDialog()
	{
		try
		{
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("view/AddItem.fxml"));
			AnchorPane page = (AnchorPane) loader.load();
			
			Stage dialogStage = new Stage();
			dialogStage.setTitle("Add Item");
			dialogStage.initModality(Modality.WINDOW_MODAL);
			dialogStage.initOwner(primaryStage);
			Scene scene = new Scene(page);
			dialogStage.setScene(scene);
			
			AddItemController controller = loader.getController();
			controller.setDialogStage(dialogStage);
			
			controller.setMain(this);
			
			dialogStage.showAndWait();
			
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	public ObservableList<Profile> getData()
	{
		return data;
	}
	
	public Main() {
		
	}
	
	private void updateData()
	{

	}

	public static void main(String[] args) 
	{
		launch(args);
	}
	
	public void clearData()
	{
		
	}
	
	public void removeAny()
	{
		
	}
	
}