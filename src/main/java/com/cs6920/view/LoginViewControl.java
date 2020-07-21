package com.cs6920.view;

import java.io.IOException;

import com.cs6920.DAL.MySQLAccess;
import com.cs6920.control.logic_control.LoginControl;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import com.cs6920.model.Player;
import com.cs6920.story_mapper.App;

/**
 * This control communicates between the FXML View and Logic Control for Login
 * @author Matthew Hodge
 * @version 6.12.2020
 */

public class LoginViewControl extends ViewControl {
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
	@FXML
	private ImageView loadingConnectionTestImage;
	@FXML
	private ImageView loadingLoginImage;
	
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
        theFxmlLoader = new FXMLLoader(App.class.getResource("LoginView.fxml"));
        theFxmlLoader.setController(this);
        theMainDashboardStage = new Stage();
        theMainDashboardStage.setTitle("Story Mapper");
        theMainDashboardStage.setWidth(800);
        theMainDashboardStage.setHeight(600);
	} 
	
	@FXML
	private void handleTestServerButtonAction()
	{
		loadingConnectionTestImage.setVisible(true);
		Thread handleTestConnection = new Thread(new Runnable() {
		    @Override
		    public void run(){
				if (theLoginControl.testDBConnection(hostTextInput.getText(), usernameDBTextInput.getText(), passwordDBTextInput.getText(), dBNameTextInput.getText())) {
					Platform.runLater(() -> { testMessageSucces(); });
				}
				else {
					Platform.runLater(() -> { testMessageFail(); });
				}
		    }
		});
		handleTestConnection.start();
	}
	
	private void testMessageSucces() {
		dBConnectionMessageLabel.setText("Connection successful.");
	    dBConnectionMessageLabel.setTextFill(Color.GREEN);
		loadingConnectionTestImage.setVisible(false);
	}
	
	private void testMessageFail() {
	    dBConnectionMessageLabel.setText("A connection was not established.");
	    dBConnectionMessageLabel.setTextFill(Color.RED);
		loadingConnectionTestImage.setVisible(false);
	}
	
	@FXML
	private void handleAdminLoginButtonAction() throws Exception
	{
		loadingLoginImage.setVisible(true);
		Thread handleAdminLogin = new Thread(new Runnable() {
		    @Override
		    public void run(){
				Player thePlayerToLogIn = theLoginControl.userLoginPlayer(hostTextInput.getText(), usernameDBTextInput.getText(), passwordDBTextInput.getText(), dBNameTextInput.getText(), adminNameLoginTextBox.getText(), adminPasswordLoginTextBox.getText());
				if (thePlayerToLogIn != null) {
					Platform.runLater(() -> { 
						try {
							if (theLoginControl.isPlayerAdmin(thePlayerToLogIn)) {
								thePlayerToLogIn.setPlayerIsAdmin(true);
								setLoginMessageIsAdmin(); 
								theLoginControl.setUpMainDashboard(thePlayerToLogIn, theMainDashboardStage);
								hideLoginStage();
							}
							else {
								setLoginMessageNotAdmin();;
							}
						} catch (Exception e) {
							System.out.println(e.getMessage());
							Platform.runLater(() -> { setLoginMessageError(e.getMessage()); });
						}
					});
				}
				else {
					Platform.runLater(() -> { setLoginMessageNoAccount(); });
				}
		    }
		});
		handleAdminLogin.start();
	}
	
	private void setLoginMessageNoAccount() {
		adminLoginMessageLabel.setText("No account was found");
		adminLoginMessageLabel.setTextFill(Color.RED);
		loadingLoginImage.setVisible(false);
	}
	private void setLoginMessageError(String error) {
		adminLoginMessageLabel.setText(error);
		adminLoginMessageLabel.setTextFill(Color.RED);
	}
	
	private void setLoginMessageNotAdmin() {
		adminLoginMessageLabel.setText("The Player is NOT an Admin");
		adminLoginMessageLabel.setTextFill(Color.RED);
		loadingLoginImage.setVisible(false);
	}
	
	private void setLoginMessageIsAdmin() {
		adminLoginMessageLabel.setText("The Player is an Admin");
		adminLoginMessageLabel.setTextFill(Color.GREEN);
		loadingLoginImage.setVisible(false);
	}
	
	/**
	 * Gets the loading image for this view
	 * @return the ImageView loading graphic
	 */
	public ImageView getLoadingConnectionTestImage() {
		return this.loadingConnectionTestImage;
	}
	
	/**
	 * Gets the DBConnection class instance
	 * @return the DBConnection class instance
	 */
	public MySQLAccess getDBConnection() {
		return theLoginControl.getDBConnection();
	}
	
	/**
	 * Clears login fields from last login and shows the login stage.
	 */
	public void showLoginStage() {
		resetAdminLoginFields();
		this.theLoginStage.show();
	}
	
	/**
	 * Hide the Login stage
	 */
	public void hideLoginStage() {
		this.theLoginStage.hide();
	}
	
	/**
	 * Creates the initial Login view. this is never destroyed, just hidden.
	 */
	public void loadLoginView() {
        Parent theLoginParentView;
        try {
        	theLoginParentView = theFxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
        theLoginStage.setScene(new Scene(theLoginParentView));
		loadingConnectionTestImage.setVisible(false);
		loadingLoginImage.setVisible(false);
        showLoginStage();
	}
	
	private void resetAdminLoginFields() {
		adminLoginMessageLabel.setText("");
		adminNameLoginTextBox.setText("");
		adminPasswordLoginTextBox.setText("");
		dBConnectionMessageLabel.setText("");
	}
	
}
