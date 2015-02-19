package ch.deyster.network.view;

import javafx.fxml.FXML;
import ch.deyster.network.Main;

public class RootLayoutController 
{
	private Main main;
	
	public void setMainApp(Main main)
	{
		this.main = main;
	}
	
	@FXML
	public void handleJoin()
	{
		main.showJoinDialog();
	}
	
	@FXML
	public void handleLeave()
	{
		
	}
	
	@FXML
	public void handleUpdateStatus()
	{
		
	}
	
	@FXML
	public void handleClose()
	{
		System.exit(0);
	}
}
