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
import javafx.scene.control.PasswordField;
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
    private PasswordField passwordDBPasswordField;
	@FXML
    private Label dBConnectionMessageLabel;
	@FXML
    private TextField adminNameLoginTextBox;
	@FXML
    private PasswordField adminPasswordLoginPasswordField;
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
		this.theFxmlLoader = new FXMLLoader(App.class.getResource("LoginView.fxml"));
		this.theFxmlLoader.setController(this);
		this.theMainDashboardStage = new Stage();
		this.theMainDashboardStage.setTitle("Story Mapper");
		this.theMainDashboardStage.setWidth(800);
		this.theMainDashboardStage.setHeight(600);
	} 
	
	@FXML
	private void handleTestServerButtonAction()
	{
		this.loadingConnectionTestImage.setVisible(true);
		Thread handleTestConnection = new Thread(new Runnable() {
		    @Override
		    public void run(){
				if (theLoginControl.testDBConnection(hostTextInput.getText(), usernameDBTextInput.getText(), passwordDBPasswordField.getText(), dBNameTextInput.getText())) {
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
		this.dBConnectionMessageLabel.setText("Connection successful.");
		this.dBConnectionMessageLabel.setTextFill(Color.GREEN);
		this.loadingConnectionTestImage.setVisible(false);
	}
	
	private void testMessageFail() {
		this.dBConnectionMessageLabel.setText("A connection was not established.");
		this.dBConnectionMessageLabel.setTextFill(Color.RED);
		this.loadingConnectionTestImage.setVisible(false);
	}
	
	@FXML
	private void handleAdminLoginButtonAction() throws Exception
	{
		this.loadingLoginImage.setVisible(true);
		Thread handleAdminLogin = new Thread(new Runnable() {
		    @Override
		    public void run(){
				Player thePlayerToLogIn = theLoginControl.userLoginPlayer(hostTextInput.getText(), usernameDBTextInput.getText(), passwordDBPasswordField.getText(), dBNameTextInput.getText(), adminNameLoginTextBox.getText(), adminPasswordLoginPasswordField.getText());
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
		this.adminLoginMessageLabel.setText("No account was found");
		this.adminLoginMessageLabel.setTextFill(Color.RED);
		this.loadingLoginImage.setVisible(false);
	}
	private void setLoginMessageError(String error) {
		this.adminLoginMessageLabel.setText(error);
		this.adminLoginMessageLabel.setTextFill(Color.RED);
	}
	
	private void setLoginMessageNotAdmin() {
		this.adminLoginMessageLabel.setText("The Player is NOT an Admin");
		this.adminLoginMessageLabel.setTextFill(Color.RED);
		this.loadingLoginImage.setVisible(false);
	}
	
	private void setLoginMessageIsAdmin() {
		this.adminLoginMessageLabel.setText("The Player is an Admin");
		this.adminLoginMessageLabel.setTextFill(Color.GREEN);
		this.loadingLoginImage.setVisible(false);
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
		return this.theLoginControl.getDBConnection();
	}
	
	/**
	 * Clears login fields from last login and shows the login stage.
	 */
	public void showLoginStage() {
		this.resetAdminLoginFields();
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
        this.theLoginStage.setScene(new Scene(theLoginParentView));
        this.theLoginStage.setResizable(false);
        this.loadingConnectionTestImage.setVisible(false);
        this.loadingLoginImage.setVisible(false);
        this.showLoginStage();
	}
	
	private void resetAdminLoginFields() {
		this.adminLoginMessageLabel.setText("");
		this.adminNameLoginTextBox.setText("");
		this.adminPasswordLoginPasswordField.setText("");
		this.dBConnectionMessageLabel.setText("");
	}
	
}
