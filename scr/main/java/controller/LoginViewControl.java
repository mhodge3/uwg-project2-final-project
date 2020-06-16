package controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import model.Player;

/**
 * This control communicates between the FXML View and Logic Control for Login
 * @author Matthew Hodge
 * @version 6.12.2020
 */

public class LoginViewControl {
	@FXML
    private TextField hostTextInput;
	@FXML
    private TextField dBNameTextInput;
	@FXML
    private TextField usernameDBTextInput;
	@FXML
    private TextField passwordDBTextInput;
	@FXML
    private Label dBConnectionMessageLabel;
	@FXML
    private TextField adminNameLoginTextBox;
	@FXML
    private TextField adminPasswordLoginTextBox;
	@FXML
	private Label adminLoginMessageLabel;
	
	private FXMLLoader theFxmlLoader;
	private LoginControl theLoginControl;
	private Stage theLoginStage;
	private Stage theMainDashboardStage;
	
	/**
	 * Constructor for the LoginView Control with 1 argument
	 * @param theLoginControl	the instance of a LoginControl to communicate with
	 */
	public LoginViewControl(LoginControl theLoginControl, Stage theLoginStage) {
		this.theLoginControl = theLoginControl;
		this.theLoginStage = theLoginStage;
        theFxmlLoader = new FXMLLoader(getClass().getResource("/view/LoginView.fxml"));
        theFxmlLoader.setController(this);
        theMainDashboardStage = new Stage();
        theMainDashboardStage.setTitle("Story Mapper");
        theMainDashboardStage.setWidth(800);
        theMainDashboardStage.setHeight(600);
	} 
	
	@FXML
	private void handleTestServerButtonAction(ActionEvent event)
	{
		theLoginControl.BuildConnectionString(hostTextInput.getText(), usernameDBTextInput.getText(), passwordDBTextInput.getText(), dBNameTextInput.getText());
		if (theLoginControl.TestDBConnection()) {
		    dBConnectionMessageLabel.setText("Connection successful.");
		    dBConnectionMessageLabel.setTextFill(Color.GREEN);
		}
		else {
		    dBConnectionMessageLabel.setText("A connection was not established.");
		    dBConnectionMessageLabel.setTextFill(Color.RED);
		}
	}
	
	@FXML
	private void handleAdminLoginButtonAction(ActionEvent event) throws Exception
	{
		Player thePlayerToLogIn = null;
		theLoginControl.BuildConnectionString(hostTextInput.getText(), usernameDBTextInput.getText(), passwordDBTextInput.getText(), dBNameTextInput.getText());
		try {
			thePlayerToLogIn = theLoginControl.GetPlayer(adminNameLoginTextBox.getText(), adminPasswordLoginTextBox.getText());
		} catch (Exception e) {
			adminLoginMessageLabel.setText("No account was found");
			adminLoginMessageLabel.setTextFill(Color.RED);
		}
		
		if (thePlayerToLogIn != null) {
			if (theLoginControl.IsPlayerAdmin(thePlayerToLogIn)) {
				thePlayerToLogIn.SetPlayerIsAdmin(true);
				adminLoginMessageLabel.setText("The Player is an Admin");
				adminLoginMessageLabel.setTextFill(Color.GREEN);
				theLoginControl.SetUpMainDashboard(thePlayerToLogIn, theMainDashboardStage);
				HideLoginStage();
			}
			else {
				adminLoginMessageLabel.setText("The Player is NOT an Admin");
				adminLoginMessageLabel.setTextFill(Color.RED);
			}
		}
		else {
			adminLoginMessageLabel.setText("No account was found");
			adminLoginMessageLabel.setTextFill(Color.RED);
		}
	}
	
	/**
	 * Clears login fields from last login and shows the login stage.
	 */
	public void ShowLoginStage() {
		resetAdminLoginFields();
		this.theLoginStage.show();
	}
	
	/**
	 * Hidge the Login stage
	 */
	public void HideLoginStage() {
		this.theLoginStage.hide();
	}
	
	/**
	 * Creates the initial Login view. this is never destroyed, just hidden.
	 */
	public void LoadLoginView() {
        Parent theLoginParentView;
        try {
        	theLoginParentView = theFxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
        theLoginStage.setScene(new Scene(theLoginParentView));
        ShowLoginStage();
	}
	
	private void resetAdminLoginFields() {
		adminLoginMessageLabel.setText("");
		adminNameLoginTextBox.setText("");
		adminPasswordLoginTextBox.setText("");
		dBConnectionMessageLabel.setText("");
	}
	
}
