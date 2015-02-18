package ch.deyster.network.view;

import java.util.Observable;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import ch.deyster.network.Main;
import ch.deyster.network.model.*;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.*;
public class MainDisplayController
{
	@FXML
	private TableView<Profile> listTable;
	
	@FXML
	private TableColumn<Profile, String> nameColumn;
	
	@FXML
	private TableColumn<Profile, String> statusColumn;
	
	private Main main;
	
	public MainDisplayController() {
	}
	
	@FXML
	private void initialize() {
		nameColumn.setCellValueFactory(
				cellData -> cellData.getValue().nameProperty());
		statusColumn.setCellValueFactory(
				cellData -> cellData.getValue().statusProperty());
		
	}
	
	public void setMain(Main mainApp)
	{
		this.main = mainApp;
		
		listTable.setItems(mainApp.getData());
	}
	
	@FXML
	public void handleAdd()
	{
		main.showAddItemDialog();
	}
	
	@FXML
	public void handleRemove()
	{
		
	}
	
	@FXML
	public void handleRemoveAny() {
		main.removeAny();
	}
	
	@FXML
	public void handleClear(){
		main.clearData();
	}
	
	@FXML
	public void handleFrequency()
	{
		
	}
	
	@FXML
	public void handleReplace()
	{
		
	}
}




















