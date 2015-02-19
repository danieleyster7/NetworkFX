package ch.deyster.network.model;

import javafx.stage.Stage;
import ch.deyster.network.Main;

public class GeneralController 
{
	protected Main main;
	protected Stage dialogStage;
	
	public void setMain(Main main)
	{
		this.main = main;
	}
	
	public void setDialogStage(Stage dialogStage)
	{
		this.dialogStage = dialogStage;
	}
}
