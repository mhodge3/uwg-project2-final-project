package controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * This class is the View Logic for a MainDashboard
 * @author Matthew Hodge
 * @version 6.12.2020
 */
public class MainDashboardViewControl {
	private FXMLLoader theFxmlLoader;
	private MainDashboardControl theMainDashbaordControl;
	private Stage theMainDashboardStage;
	
	/**
	 * Constructor for the MainDashbaordView Control with 1 argument
	 * @param theMainDashboardControl	the instance of a MainDashboard to communicate with
	 */
	public MainDashboardViewControl(MainDashboardControl theMainDashbaordControl, Stage theMainDashboardStage) {
		this.theMainDashbaordControl = theMainDashbaordControl;
		this.theMainDashboardStage = theMainDashboardStage;
        theFxmlLoader = new FXMLLoader(getClass().getResource("/view/MainDashboardView.fxml"));
        theFxmlLoader.setController(this);
	} 
	
	@FXML
	private void handleLogoutButtonAction(ActionEvent event) throws Exception
	{
		theMainDashbaordControl.ResetLoginView();
		HideMainDashboardView();
	}
	
	/**
	 * Enabiles the view of the MainDashboard
	 */
	public void ShowMainDashboardView() {
		theMainDashboardStage.show();
	}
	
	/**
	 * Hidge the view of the MainDashboard
	 */
	public void HideMainDashboardView() {
		theMainDashboardStage.hide();
	}
	
	/**
	 * Loads the new MainDashboard when the dashboard is first accessed
	 */
	public void LoadMainDashboardView() {
        Parent theMainDashboardParentView;
        try {
        	theMainDashboardParentView = theFxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
        theMainDashboardStage.setScene(new Scene(theMainDashboardParentView));
        ShowMainDashboardView();
	}
}
