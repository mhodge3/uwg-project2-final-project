package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;

public class LoginViewControl {
	@FXML
    private TextField HostTextInput;
	@FXML
    private TextField UsernameDBTextInput;
	@FXML
    private TextField PasswordDBTextInput;
	
	private FXMLLoader theFxmlLoader;
	private AdminControl theAdminControl;
	
	public LoginViewControl(AdminControl theAdminControl) {
		this.theAdminControl = theAdminControl;
        theFxmlLoader = new FXMLLoader(getClass().getResource("/view/LoginView.fxml"));
        theFxmlLoader.setController(this);
	} 
	
	@FXML
	private void handleTestServerButtonAction(ActionEvent event)
	{
		theAdminControl.BuildConnectionString(HostTextInput.getText(), UsernameDBTextInput.getText(), PasswordDBTextInput.getText());
		if (theAdminControl.TestDBConnection()) {
		    System.out.println("Go!");
		}
		else {
		    System.out.println("No Go.");
		}
	}
	
	public FXMLLoader getTheFxmlLoader() {
		return theFxmlLoader;
	}
}
