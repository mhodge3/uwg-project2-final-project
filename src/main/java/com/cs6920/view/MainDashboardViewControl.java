package com.cs6920.view;

import java.io.IOException;
import java.sql.SQLException;

import com.cs6920.DAL.MySQLAccess;
import com.cs6920.control.logic_control.MainDashboardControl;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import com.cs6920.model.Conflict;
import com.cs6920.model.Player;
import com.cs6920.story_mapper.App;
import com.cs6920.view.conflict_templates.ConflictTemplateTheQuestViewControl;
import com.cs6920.view.create.CreateItemsViewControl;
import com.cs6920.view.create.CreateNPCCharactersViewControl;
import com.cs6920.view.create.CreatePlayersAndAdminsViewControl;
import com.cs6920.view.edit.EditItemsViewControl;
import com.cs6920.view.edit.EditNPCCharactersViewControl;
import com.cs6920.view.edit.EditPlayersAndAdminsViewControl;
import com.cs6920.view.manage.ManageItemsViewControl;
import com.cs6920.view.manage.ManageNPCCharactersViewControl;
import com.cs6920.view.manage.ManagePlayersAndAdminsViewControl;
import com.cs6920.view.manage.ManageQuestChainsViewControl;

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
    private ManagePlayersAndAdminsViewControl theManagePlayersAndAdminsViewControl;
	private EditPlayersAndAdminsViewControl theEditPlayersAndAdminsViewControl;
    
    private Parent theManageItemsParentView;
    private Scene theManageItemsScene;
    private Parent theEditItemsParentView;
    private Scene theEditItemsScene;
    private Parent theCreateItemsParentView;
    private Scene theCreateItemsScene;
    private ManageItemsViewControl theManageItemsViewControl;
	private EditItemsViewControl theEditItemsViewControl;
    
    private Parent theManageNPCCharactersParentView;
    private Scene theManageNPCCharactersScene;
    private Parent theEditNPCCharactersParentView;
    private Scene theEditNPCCharactersScene;
    private Parent theCreateNPCCharactersParentView;
    private Scene theCreateNPCCharactersScene;
    private ManageNPCCharactersViewControl theManageNPCCharactersViewControl;
	private EditNPCCharactersViewControl theEditNPCCharactersViewControl;
    
    private Parent theManageQuestChainsParentView;
    private Scene theManageQuestChainsScene;
    private ManageQuestChainsViewControl theManageQuestChainsViewControl;
    
    private Parent theManageTemplateTheQuestParentView;
    private Scene theManageTemplateTheQuestScene;
    private ConflictTemplateTheQuestViewControl theManageTheQuestViewControl;
	
	/**
	 * Constructor for the MainDashbaordView Control with 1 argument
	 * @param theMainDashboardControl	the instance of a MainDashboard to communicate with
	 */
	public MainDashboardViewControl(MainDashboardControl theMainDashbaordControl, Stage theMainDashboardStage) {
		this.theMainDashbaordControl = theMainDashbaordControl;
		this.theMainDashboardStage = theMainDashboardStage;
		this.CreateMainDashboardScene();
		
		this.CreateManagePlayersAndAdminsScene();
		this.CreateEditPlayersAndAdminsScene();
		this.CreateCreatePlayersAndAdminsScene();
		
		this.CreateManageItemsScene();
		this.CreateEditItemsScene();
		this.CreateCreateItemsScene();
		
		this.CreateManageNPCCharactersScene();
		this.CreateEditNPCCharactersScene();
		this.CreateCreateNPCScene();
		
		this.CreateManageQuestChainsScene();
		
		this.CreateManageTemplateTheQuestScene();
	} 
	
	/**
	 * Gets the Player object that is logged in as Admin
	 * @return the Admin Player Object
	 */
	public Player GetTheAdminPlayer() {
		return this.theMainDashbaordControl.GetTheAdminPlayer();
	}
	
	/**
	 * Sets the view control reference in the logic control the theManagePlayersAndAdminsViewControl
	 * @param theManagePlayersAndAdminsViewControl
	 */
	public void SetTheManagePlayersAndAdminsViewControl(ManagePlayersAndAdminsViewControl theManagePlayersAndAdminsViewControl) {
		this.theManagePlayersAndAdminsViewControl = theManagePlayersAndAdminsViewControl;
	}
	
	/**
	 * Sets the view control reference in the logic control the theManageNPCCharactersViewControl
	 * @param theManageNPCCharactersViewControl
	 */
	public void SetTheManageNPCCharactersViewControl(ManageNPCCharactersViewControl theManageNPCCharactersViewControl) {
		this.theManageNPCCharactersViewControl = theManageNPCCharactersViewControl;
	}

	/**
	 * Sets the view control reference in the logic control the theManageItemsViewControl
	 * @param theManageItemsViewControl
	 */
	public void SetTheManageItemsViewControl(ManageItemsViewControl theManageItemsViewControl) {
		this.theManageItemsViewControl = theManageItemsViewControl;
	}

	/**
	 * Sets the view control reference in the logic control the theManageQuestChainsViewControl
	 * @param theManageQuestChainsViewControl
	 */
	public void SetTheManageQuestChainsViewControl(ManageQuestChainsViewControl theManageQuestChainsViewControl) {
		this.theManageQuestChainsViewControl = theManageQuestChainsViewControl;
	}

	/**
	 * Sets the view control reference in the logic control the theManageQuestChainsViewControl
	 * @param theManageQuestChainsViewControl
	 */
	public void SetTheManageTheQuestViewControl(ConflictTemplateTheQuestViewControl theManageTheQuestViewControl) {
		this.theManageTheQuestViewControl = theManageTheQuestViewControl;
	}
	
	/**
	 * Sets the id of the Player to be edited
	 * @param playerIdToEdit
	 */
	public void SetPlayerToEdit(int playerIdToEdit) {
		theEditPlayersAndAdminsViewControl.GetEditPlayersAndAdminsControl().SetSelectedPlayer(playerIdToEdit);
		theEditPlayersAndAdminsViewControl.SetFormForSelectedPlayer(theEditPlayersAndAdminsViewControl.GetEditPlayersAndAdminsControl().GetSelectedPlayer());
	}

	/**
	 * Sets the id of the NPCCharacter to be edited
	 * @param npcIdToEdit
	 */
	public void SetNPCToEdit(int npcIdToEdit) {
		theEditNPCCharactersViewControl.GetEditNPCCharactersControl().SetSelectedNPC(npcIdToEdit);
		theEditNPCCharactersViewControl.SetFormForSelectedNPC(theEditNPCCharactersViewControl.GetEditNPCCharactersControl().GetSelectedNPC());
	}

	/**
	 * Sets the id of the Item to be edited
	 * @param itemIdToEdit
	 */
	public void SetItemToEdit(int itemIdToEdit) {
		theEditItemsViewControl.GetEditItemsControl().SetSelectedItem(itemIdToEdit);
		theEditItemsViewControl.SetFormForSelectedItem(theEditItemsViewControl.GetEditItemsControl().GetSelectedItem());
	}
	
	public void SetConflictToEdit(int conflictIdToEdit) {
		this.theManageTheQuestViewControl.GetTheManageTemplateTheQuestControl().SetTheConflictToEdit(conflictIdToEdit);
		//theEditItemsViewControl.SetFormForSelectedItem(theEditItemsViewControl.GetEditItemsControl().GetSelectedItem());
	}
	
	@FXML
	private void handleLogoutButtonAction() throws Exception
	{
		theMainDashbaordControl.ResetLoginView();
		HideMainDashboardView();
	}
	
	@FXML
	public void handleManagePlayersAndAdminsButton() throws Exception
	{
		SetMainDashboardStage("managePlayersAndAdmins");
	}
	
	@FXML
	private void handleItemsButton() throws Exception
	{
		SetMainDashboardStage("manageItems");
	}
	
	@FXML
	private void handleNPCCharactersButton() throws Exception
	{
		SetMainDashboardStage("manageNPCCharacters");
	}
	
	@FXML
	private void handleQuestChainsButton() throws Exception
	{
		SetMainDashboardStage("manageQuestChains");
	}
	
	/**
	 * Loads the new MainDashboard when the dashboard is first accessed
	 * @throws SQLException 
	 */
	public void LoadMainDashboardView() throws SQLException {
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
	
	/**
	 * Get the instance of the DB Connection for this run of the program
	 * @return	The DbConnection instance
	 */
	public MySQLAccess GetDBConnection() {
		return theMainDashbaordControl.GetDBConnection();
	}
	
	/**
	 * Sets the MainDashboard Stage Scene
	 * @param theSceneNameToLoad	the String name of the scene to load
	 * @throws SQLException 
	 */
	public void SetMainDashboardStage(String theSceneNameToLoad) throws SQLException {
		Scene theSceneToStage = null;
		switch (theSceneNameToLoad) {
			case "mainDashboard":
				theSceneToStage = theMainDashboardScene;
				break;
			case "managePlayersAndAdmins":
				theManagePlayersAndAdminsViewControl.updateExistingPlayerAdminList();
				theSceneToStage = theManagePlayersAndAdminsScene;
				break;
			case "editPlayersAndAdmins":
				theSceneToStage = theEditPlayersAndAdminsScene;
				break;
			case "createPlayersAndAdmins":
				theSceneToStage = theCreatePlayersAndAdminsScene;
				break;
			case "manageItems":
				theManageItemsViewControl.updateExistingItemsList();
				theSceneToStage = theManageItemsScene;
				break;
			case "editItems":
				theSceneToStage = theEditItemsScene;
				break;
			case "createItems":
				theSceneToStage = theCreateItemsScene;
				break;
			case "manageNPCCharacters":
				theManageNPCCharactersViewControl.updateExistingNPCCharactersList();
				theSceneToStage = theManageNPCCharactersScene;
				break;
			case "editNPCCharacters":
				theSceneToStage = theEditNPCCharactersScene;
				break;
			case "createNPCCharacters":
				theSceneToStage = theCreateNPCCharactersScene;
				break;
			case "manageQuestChains":
				theManageQuestChainsViewControl.updateExistingConflictList();
				theSceneToStage = theManageQuestChainsScene;
				break;
			case "manageTemplateTheQuest":
				theManageTheQuestViewControl.updateExistingTheQuestList();
				theSceneToStage = theManageTemplateTheQuestScene;
				break;
			default: break;
		}
        theMainDashboardStage.setScene(theSceneToStage);
        ShowMainDashboardView();
	}
	
	private void CreateMainDashboardScene() {
        try {
            theFxmlLoader = new FXMLLoader(getClass().getResource("MainDashboardView.fxml"));
            theFxmlLoader.setController(this);
            theFxmlLoader.setLocation(App.class.getResource("MainDashboardView.fxml"));
            theMainDashboardParentView = theFxmlLoader.load();
            theMainDashboardScene = new Scene(theMainDashboardParentView);
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
	}
	
	private void CreateEditPlayersAndAdminsScene() {
        try {
            theFxmlLoader = new FXMLLoader(App.class.getResource("EditPlayersAndAdminsView.fxml"));
            theEditPlayersAndAdminsViewControl = new EditPlayersAndAdminsViewControl(this);
            theFxmlLoader.setController(theEditPlayersAndAdminsViewControl);
            theEditPlayersAndAdminsParentView = theFxmlLoader.load();
            theEditPlayersAndAdminsScene = new Scene(theEditPlayersAndAdminsParentView);
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
	}
	
	private void CreateCreatePlayersAndAdminsScene() {
        theFxmlLoader = new FXMLLoader(App.class.getResource("CreatePlayersAndAdminsView.fxml"));
        theFxmlLoader.setController(new CreatePlayersAndAdminsViewControl(this));
        try {
        	theCreatePlayersAndAdminsParentView = theFxmlLoader.load();
        	theCreatePlayersAndAdminsScene = new Scene(theCreatePlayersAndAdminsParentView);
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
	}
	
	private void CreateManagePlayersAndAdminsScene() {
        theFxmlLoader = new FXMLLoader(App.class.getResource("ManagePlayersAndAdminsView.fxml"));
        theFxmlLoader.setController(new ManagePlayersAndAdminsViewControl(this));
        try {
        	theManagePlayersAndAdminsParentView = theFxmlLoader.load();
        	theManagePlayersAndAdminsScene = new Scene(theManagePlayersAndAdminsParentView);
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
	}
	
	private void CreateManageItemsScene() {
        theFxmlLoader = new FXMLLoader(App.class.getResource("ManageItemsView.fxml"));
        theFxmlLoader.setController(new ManageItemsViewControl(this));
        try {
        	theManageItemsParentView = theFxmlLoader.load();
        	theManageItemsScene = new Scene(theManageItemsParentView);
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
	}
	
	private void CreateEditItemsScene() {
        theFxmlLoader = new FXMLLoader(App.class.getResource("EditItemsView.fxml"));
        theEditItemsViewControl = new EditItemsViewControl(this);
        theFxmlLoader.setController(theEditItemsViewControl);
        try {
        	theEditItemsParentView = theFxmlLoader.load();
        	theEditItemsScene = new Scene(theEditItemsParentView);
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
	}
	
	private void CreateCreateItemsScene() {
        theFxmlLoader = new FXMLLoader(App.class.getResource("CreateItemsView.fxml"));
        theFxmlLoader.setController(new CreateItemsViewControl(this));
        try {
        	theCreateItemsParentView = theFxmlLoader.load();
        	theCreateItemsScene = new Scene(theCreateItemsParentView);
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
	}
	
	private void CreateManageNPCCharactersScene() {
        theFxmlLoader = new FXMLLoader(App.class.getResource("ManageNPCCharactersView.fxml"));
        theFxmlLoader.setController(new ManageNPCCharactersViewControl(this));
        try {
        	theManageNPCCharactersParentView = theFxmlLoader.load();
        	theManageNPCCharactersScene = new Scene(theManageNPCCharactersParentView);
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
	}
	
	private void CreateEditNPCCharactersScene() {
        theFxmlLoader = new FXMLLoader(App.class.getResource("EditNPCCharactersView.fxml"));
        theEditNPCCharactersViewControl = new EditNPCCharactersViewControl(this);
        theFxmlLoader.setController(theEditNPCCharactersViewControl);
        try {
        	theEditNPCCharactersParentView = theFxmlLoader.load();
        	theEditNPCCharactersScene = new Scene(theEditNPCCharactersParentView);
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
	}
	
	private void CreateCreateNPCScene() {
        theFxmlLoader = new FXMLLoader(App.class.getResource("CreateNPCCharactersView.fxml"));
        theFxmlLoader.setController(new CreateNPCCharactersViewControl(this));
        try {
        	theCreateNPCCharactersParentView = theFxmlLoader.load();
        	theCreateNPCCharactersScene = new Scene(theCreateNPCCharactersParentView);
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
	}
	
	private void CreateManageQuestChainsScene() {
        theFxmlLoader = new FXMLLoader(App.class.getResource("ManageQuestChainsView.fxml"));
        theFxmlLoader.setController(new ManageQuestChainsViewControl(this));
        try {
        	theManageQuestChainsParentView = theFxmlLoader.load();
        	theManageQuestChainsScene = new Scene(theManageQuestChainsParentView);
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
	}
	
	private void CreateManageTemplateTheQuestScene() {
        theFxmlLoader = new FXMLLoader(App.class.getResource("ManageTemplateTheQuestView.fxml"));
        theFxmlLoader.setController(new ConflictTemplateTheQuestViewControl(this));
        try {
        	theManageTemplateTheQuestParentView = theFxmlLoader.load();
        	theManageTemplateTheQuestScene = new Scene(theManageTemplateTheQuestParentView);
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
	}
}
