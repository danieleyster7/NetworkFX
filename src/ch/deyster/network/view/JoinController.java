package ch.deyster.network.view;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import ch.deyster.network.Main;
import ch.deyster.network.model.GeneralController;

public class JoinController extends GeneralController
{
	@FXML
	private TextField name;
	private boolean okClicked;
	
	@FXML
	public void handleOk()
	{
		//IF there's something in the textfield
		if(name.getText() != null)
		{
			//IF a user doesnt exist yet
			if(main.getUser() == null)
			{
				main.newUser(name.getText());
				dialogStage.close();
			}
			else
				name.setText("YOU ALREADY HAVE A PROFILE DUMMY!");
		}
		else
			name.setText("YOU MUST ENTER A NAME HERE!");
	}
	
	@FXML
	public void handleCancel()
	{
		dialogStage.close();
	}
	
	public boolean okClicked()
	{
		return okClicked;
	}
	
}
