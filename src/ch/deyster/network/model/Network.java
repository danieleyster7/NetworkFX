package ch.deyster.network.model;

import java.util.ArrayList;

import javafx.collections.ObservableList;


public class Network
{
	ArrayList<Profile> profiles;
	
	public Network()
	{
		profiles = new ArrayList<Profile>();
	}
	
	public void joinNetwork(Profile profile)
	{
		profiles.add(profile);
	}
	
	public void leaveNetwork(Profile profile)
	{
		profiles.remove(profile);
	}
}
