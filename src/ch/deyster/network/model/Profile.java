package ch.deyster.network.model;

import java.util.ArrayList;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


public class Profile 
{
	private String name;
	private StringProperty nameProperty;
	private String status;
	private StringProperty statusProperty;
	private ArrayList<String> friends;
	private ObservableList<StringProperty> friendsProperty = FXCollections.observableArrayList();
	
	public Profile()
	{
		friends = new ArrayList<String>();
		nameProperty = new SimpleStringProperty("");
		statusProperty = new SimpleStringProperty("");
	}
	
	public Profile(String name)
	{
		this.name = name;
		nameProperty = new SimpleStringProperty(name);
		friends = new ArrayList<String>();
		statusProperty = new SimpleStringProperty("");
	}
	
	public void setName(String name)
	{
		this.name = name;
		nameProperty.set(name);
	}
	
	public String getName()
	{
		return name;
	}
	
	public StringProperty nameProperty()
	{
		return nameProperty;
	}
	
	
	public String getStatus()
	{
		return status;
	}
	
	public void setStatus(String status)
	{
		this.status = status;
		statusProperty.set(status);
	}
	
	public StringProperty statusProperty()
	{
		return statusProperty;
	}
	
	public void addFriend(String friend)
	{
		friends.add(friend);
		friendsProperty.add(new SimpleStringProperty(friend));
	}
	
	public void removeFriend(String friend)
	{
		friends.remove(friend);
		friendsProperty.remove(new SimpleStringProperty(friend));
	}
	
	public ObservableList<StringProperty> friendsProperty()
	{
		return friendsProperty;
	}
}
