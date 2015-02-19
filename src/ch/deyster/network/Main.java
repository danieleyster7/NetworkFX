package ch.deyster.network;

import java.io.IOException;

import ch.deyster.network.view.JoinController;
import ch.deyster.network.view.LeaveController;
import ch.deyster.network.view.MainDisplayController;
import ch.deyster.network.view.RootLayoutController;
import ch.deyster.network.view.StatusController;
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
	private Network network = new Network();
	private Profile userProfile;
	
	public void start(Stage primaryStage) 
	{
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("ADT Testing App");
		this.primaryStage.setResizable(false);
		
		initRootLayout();
		
		showMainDisplay();
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
			
			RootLayoutController controller = loader.getController();
			controller.setMainApp(this);
			
			primaryStage.show();	
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	//Shows main window
	public void showMainDisplay()
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
	
	//Shows popup for joining network
	public void showJoinDialog()
	{
		try
		{
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("view/Join.fxml"));
			AnchorPane page = (AnchorPane) loader.load();
			
			Stage dialogStage = new Stage();
			dialogStage.setTitle("Join Network");
			dialogStage.initModality(Modality.WINDOW_MODAL);
			dialogStage.initOwner(primaryStage);
			Scene scene = new Scene(page);
			dialogStage.setScene(scene);
			
			JoinController controller = loader.getController();
			controller.setDialogStage(dialogStage);
			
			controller.setMain(this);
			
			dialogStage.showAndWait();
			
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	//Shows popup for leaving network
	public void showLeaveDialog()
	{
		try
		{
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("view/Leave.fxml"));
			AnchorPane page = (AnchorPane) loader.load();
			
			Stage dialogStage = new Stage();
			dialogStage.setTitle("Leave Network");
			dialogStage.initModality(Modality.WINDOW_MODAL);
			dialogStage.initOwner(primaryStage);
			Scene scene = new Scene(page);
			dialogStage.setScene(scene);
			
			LeaveController controller = loader.getController();
			controller.setDialogStage(dialogStage);
			
			controller.setMain(this);
			
			dialogStage.showAndWait();
			
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	//Shows popup for changing status
	public void showStatusDialog()
	{
		try
		{
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("view/Status.fxml"));
			AnchorPane page = (AnchorPane) loader.load();
			
			Stage dialogStage = new Stage();
			dialogStage.setTitle("Set Status");
			dialogStage.initModality(Modality.WINDOW_MODAL);
			dialogStage.initOwner(primaryStage);
			Scene scene = new Scene(page);
			dialogStage.setScene(scene);
			
			StatusController controller = loader.getController();
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
		return network.getProfiles();
	}
	
	//Create user profile
	public void newUser(String name)
	{
		userProfile = new Profile(name);
		network.joinNetwork(userProfile);
	}
	
	//Get userProfile
	public Profile getUser()
	{
		return userProfile;
	}
	//Make some dummy profiles in the Network
	public Main() 
	{
		//Make 3 dummy profiles
		Profile one = new Profile("Bob Boberson");
		one.setStatus("I am Bob");
		
		Profile two = new Profile("Steve Steveroni");
		two.setStatus("I am not Bob");
		
		Profile three = new Profile("George G-Dawg");
		three.setStatus("Straight up Gangsta");
		
		//Add friends
		one.addFriend(two.getName());
		one.addFriend(three.getName());
		two.addFriend(three.getName());
		three.addFriend(one.getName());
		
		//Add profiles to network
		network.joinNetwork(one);
		network.joinNetwork(two);
		network.joinNetwork(three);
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