package ch.deyster.network.model;

import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


public class Network
{
	private ObservableList<Profile> profilesProperty = FXCollections.observableArrayList();
	
	public Network(){}
	
	public void joinNetwork(Profile profile)
	{
		profilesProperty.add(profile);
	}
	
	public void leaveNetwork(Profile profile)
	{
		profilesProperty.remove(profile);
	}
	
	public ObservableList<Profile> getProfiles()
	{
		return profilesProperty;
	}
}
