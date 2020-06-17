package controller.viewController;

import java.io.IOException;

import DAL.MySQLAccess;
import controller.logicController.MainDashboardControl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * This class is the View Logic for a MainDashboard
 * @author Matthew Hodge
 * @version 6.12.2020
 */
public class MainDashboardViewControl {
	@FXML
    private VBox mainDashboardVBox;
	
	private FXMLLoader theFxmlLoader;
	private MainDashboardControl theMainDashbaordControl;
	private Stage theMainDashboardStage;
	private Parent theMainDashboardParentView;
	private Scene theMainDashboardScene;
	
    private Parent theManagePlayersAndAdminsParentView;
    private Scene theManagePlayersAndAdminsScene;
    private Parent theEditPlayersAndAdminsParentView;
    private Scene theEditPlayersAndAdminsScene;
    private Parent theCreatePlayersAndAdminsParentView;
    private Scene theCreatePlayersAndAdminsScene;
    
    private Parent theManageItemsParentView;
    private Scene theManageItemsScene;
    
    private Parent theManageNPCCharactersParentView;
    private Scene theManageNPCCharactersScene;
    
    private Parent theManageQuestChainsParentView;
    private Scene theManageQuestChainsScene;
	
	/**
	 * Constructor for the MainDashbaordView Control with 1 argument
	 * @param theMainDashboardControl	the instance of a MainDashboard to communicate with
	 */
	public MainDashboardViewControl(MainDashboardControl theMainDashbaordControl, Stage theMainDashboardStage) {
		this.theMainDashbaordControl = theMainDashbaordControl;
		this.theMainDashboardStage = theMainDashboardStage;
		CreateMainDashboardScene();
		
		CreateManagePlayersAndAdminsrScene();
		CreateEditPlayersAndAdminsrScene();
		CreateCreatePlayersAndAdminsrScene();
		
		CreateManageItemsScene();
		
		CreateManageNPCCharactersScene();
		
		CreateManageQuestChainsScene();
	} 
	
	@FXML
	private void handleLogoutButtonAction(ActionEvent event) throws Exception
	{
		theMainDashbaordControl.ResetLoginView();
		HideMainDashboardView();
	}
	
	@FXML
	public void handleManagePlayersAndAdminsButton(ActionEvent event) throws Exception
	{
		SetMainDashboardStage("managePlayersAndAdmins");
	}
	
	@FXML
	private void handleItemsButton(ActionEvent event) throws Exception
	{
		SetMainDashboardStage("manageItems");
	}
	
	@FXML
	private void handleNPCCharactersButton(ActionEvent event) throws Exception
	{
		SetMainDashboardStage("manageNPCCharacters");
	}
	
	@FXML
	private void handleQuestChainsButton(ActionEvent event) throws Exception
	{
		SetMainDashboardStage("manageQuestChains");
	}
	
	/**
	 * Loads the new MainDashboard when the dashboard is first accessed
	 */
	public void LoadMainDashboardView() {
		SetMainDashboardStage("mainDashboard");
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
	
	public MySQLAccess GetDBConnection() {
		return theMainDashbaordControl.GetDBConnection();
	}
	
	public void SetMainDashboardStage(String theSceneNameToLoad) {
		Scene theSceneToStage = null;
		switch (theSceneNameToLoad) {
			case "mainDashboard":
				theSceneToStage = theMainDashboardScene;
				break;
			case "managePlayersAndAdmins":
				theSceneToStage = theManagePlayersAndAdminsScene;
				break;
			case "editPlayersAndAdmins":
				theSceneToStage = theEditPlayersAndAdminsScene;
				break;
			case "createPlayersAndAdmins":
				theSceneToStage = theCreatePlayersAndAdminsScene;
				break;
			case "manageItems":
				theSceneToStage = theManageItemsScene;
				break;
			case "manageNPCCharacters":
				theSceneToStage = theManageNPCCharactersScene;
				break;
			case "manageQuestChains":
				theSceneToStage = theManageQuestChainsScene;
				break;
			default: break;
		}
        theMainDashboardStage.setScene(theSceneToStage);
        ShowMainDashboardView();
	}
	
	private void CreateMainDashboardScene() {
        theFxmlLoader = new FXMLLoader(getClass().getResource("/view/MainDashboardView.fxml"));
        theFxmlLoader.setController(this);
        try {
        	theMainDashboardParentView = theFxmlLoader.load();
        	theMainDashboardScene = new Scene(theMainDashboardParentView);
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
	}
	
	private void CreateEditPlayersAndAdminsrScene() {
        theFxmlLoader = new FXMLLoader(getClass().getResource("/view/EditPlayersAndAdminsView.fxml"));
        theFxmlLoader.setController(new EditPlayersAndAdminsViewControl(this));
        try {
        	theEditPlayersAndAdminsParentView = theFxmlLoader.load();
        	theEditPlayersAndAdminsScene = new Scene(theEditPlayersAndAdminsParentView);
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
	}
	
	private void CreateCreatePlayersAndAdminsrScene() {
        theFxmlLoader = new FXMLLoader(getClass().getResource("/view/CreatePlayersAndAdminsView.fxml"));
        theFxmlLoader.setController(new CreatePlayersAndAdminsViewControl(this));
        try {
        	theCreatePlayersAndAdminsParentView = theFxmlLoader.load();
        	theCreatePlayersAndAdminsScene = new Scene(theCreatePlayersAndAdminsParentView);
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
	}
	
	private void CreateManagePlayersAndAdminsrScene() {
        theFxmlLoader = new FXMLLoader(getClass().getResource("/view/ManagePlayersAndAdminsView.fxml"));
        theFxmlLoader.setController(new ManagePlayersAndAdminsViewControl(this));
        try {
        	theManagePlayersAndAdminsParentView = theFxmlLoader.load();
        	theManagePlayersAndAdminsScene = new Scene(theManagePlayersAndAdminsParentView);
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
	}
	
	private void CreateManageItemsScene() {
        theFxmlLoader = new FXMLLoader(getClass().getResource("/view/ManageItemsView.fxml"));
        theFxmlLoader.setController(new ManageItemsViewControl(this));
        try {
        	theManageItemsParentView = theFxmlLoader.load();
        	theManageItemsScene = new Scene(theManageItemsParentView);
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
	}
	
	private void CreateManageNPCCharactersScene() {
        theFxmlLoader = new FXMLLoader(getClass().getResource("/view/ManageNPCCharactersView.fxml"));
        theFxmlLoader.setController(new ManageNPCCharactersViewControl(this));
        try {
        	theManageNPCCharactersParentView = theFxmlLoader.load();
        	theManageNPCCharactersScene = new Scene(theManageNPCCharactersParentView);
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
	}
	
	private void CreateManageQuestChainsScene() {
        theFxmlLoader = new FXMLLoader(getClass().getResource("/view/ManageQuestChainsView.fxml"));
        theFxmlLoader.setController(new ManageQuestChainsViewControl(this));
        try {
        	theManageQuestChainsParentView = theFxmlLoader.load();
        	theManageQuestChainsScene = new Scene(theManageQuestChainsParentView);
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
	}
}
