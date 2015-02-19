package ch.deyster.network.view;

import java.util.Observable;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import ch.deyster.network.Main;
import ch.deyster.network.model.*;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.*;
public class MainDisplayController
{
	
	@FXML
	private TableView<Profile> profilesTable;
	@FXML
	private TableView<StringProperty> friendsTable;
	@FXML
	private TableColumn<Profile, String> nameColumn;
	@FXML
	private TableColumn<StringProperty, String> friendsColumn;
	@FXML
	private Label nameLabel;
	@FXML
	private Label statusLabel;
	private Main main;
	private ObservableList<StringProperty> friends = FXCollections.observableArrayList();
	
	public MainDisplayController() {
	}
	
	@FXML
	private void initialize() {
		//Initialize the table with profiles
		nameColumn.setCellValueFactory(
				cellData -> cellData.getValue().nameProperty());
		//Set default profile empty
		showProfile(null);
		
		//Make listener for table. If a profile is selected, display it on the profile window
		profilesTable.getSelectionModel().selectedItemProperty().addListener(
				(observable, oldvalue, newValue) -> showProfile(newValue));
	}
	
	public void setMain(Main mainApp)
	{
		this.main = mainApp;
		
		profilesTable.setItems(mainApp.getData());
	}
	
	private void showProfile(Profile profile)
	{
		if(profile != null)
		{
			nameLabel.setText(profile.getName());
			statusLabel.setText(profile.getStatus());
			friendsTable.setItems(profile.friendsProperty());
			friendsColumn.setCellValueFactory(
					cellData -> cellData.getValue());
		}
		else
		{
			nameLabel.setText(" ");
			statusLabel.setText(" ");
		}
	}
	
}




















