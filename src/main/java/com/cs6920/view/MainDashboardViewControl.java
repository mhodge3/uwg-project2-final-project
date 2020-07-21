package com.cs6920.view;

import java.io.IOException;
import java.sql.SQLException;

import com.cs6920.DAL.MySQLAccess;
import com.cs6920.control.logic_control.EditGameStoryControl;
import com.cs6920.control.logic_control.MainDashboardControl;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import com.cs6920.model.Conflict;
import com.cs6920.model.GameStory;
import com.cs6920.model.Player;
import com.cs6920.story_mapper.App;
import com.cs6920.view.create.CreateItemsViewControl;
import com.cs6920.view.create.CreateNPCCharactersViewControl;
import com.cs6920.view.create.CreatePlayersAndAdminsViewControl;
import com.cs6920.view.edit.EditConflictQuestsViewControl;
import com.cs6920.view.edit.EditGameStoryViewControl;
import com.cs6920.view.edit.EditItemsViewControl;
import com.cs6920.view.edit.EditNPCCharactersViewControl;
import com.cs6920.view.edit.EditPlayersAndAdminsViewControl;
import com.cs6920.view.manage.ManageItemsViewControl;
import com.cs6920.view.manage.ManageNPCCharactersViewControl;
import com.cs6920.view.manage.ManagePlayersAndAdminsViewControl;
import com.cs6920.view.manage.ManageConflictsViewControl;

/**
 * This class is the View Logic for a MainDashboard
 * @author Matthew Hodge
 * @version 6.12.2020
 */
public class MainDashboardViewControl extends ViewControl {
	@FXML
    private VBox mainDashboardVBox;
	@FXML
	private Label gameStoryDashboardLabel;
	
	private FXMLLoader theFxmlLoader;
	private MainDashboardControl theMainDashbaordControl;
	private Stage theMainDashboardStage;
	private Scene theMainDashboardScene;
    private Scene theManagePlayersAndAdminsScene;
    private Scene theEditPlayersAndAdminsScene;
    private Scene theCreatePlayersAndAdminsScene;
    private ManagePlayersAndAdminsViewControl theManagePlayersAndAdminsViewControl;
	private EditPlayersAndAdminsViewControl theEditPlayersAndAdminsViewControl;
    private Scene theManageItemsScene;
    private Scene theEditItemsScene;
    private Scene theCreateItemsScene;
    private ManageItemsViewControl theManageItemsViewControl;
	private EditItemsViewControl theEditItemsViewControl;
    private Scene theManageNPCCharactersScene;
    private Scene theEditNPCCharactersScene;
    private Scene theCreateNPCCharactersScene;
    private ManageNPCCharactersViewControl theManageNPCCharactersViewControl;
	private EditNPCCharactersViewControl theEditNPCCharactersViewControl;
    private Scene theManageQuestChainsScene;
    private ManageConflictsViewControl theManageQuestChainsViewControl;
    private Scene theManageTemplateTheQuestScene;
    private EditConflictQuestsViewControl theEditConflictQuestsViewControl;
    private Scene theManageTemplateVoyageAndReturnScene;
    private EditConflictQuestsViewControl theEditConflictVoyageViewControl;
    private Scene theManageTemplateDefeatTheMonsterScene;
    private EditConflictQuestsViewControl theEditConflictMonsterViewControl;
    private Scene theManageTemplateCustomScene;
    private EditConflictQuestsViewControl theEditConflictCustomViewControl;
    private Scene theEditGameStoryScene;
	private EditGameStoryViewControl theEditGameStoryViewControl;
	
	/**
	 * Constructor for the MainDashbaordView Control with 1 argument
	 * @param theMainDashboardControl	the instance of a MainDashboard to communicate with
	 * @throws SQLException 
	 */
	public MainDashboardViewControl(MainDashboardControl theMainDashbaordControl, Stage theMainDashboardStage) throws SQLException {
		this.theMainDashbaordControl = theMainDashbaordControl;
		this.theMainDashboardStage = theMainDashboardStage;
		this.createEditViewControls();
		this.theMainDashboardScene = this.createScene("MainDashboardView", this);
		this.theEditGameStoryScene = this.createScene("EditGameStory", this.theEditGameStoryViewControl);
		
		this.theManagePlayersAndAdminsScene = this.createScene("ManagePlayersAndAdminsView", new ManagePlayersAndAdminsViewControl(this));
		this.theEditPlayersAndAdminsScene = this.createScene("EditPlayersAndAdminsView", this.theEditPlayersAndAdminsViewControl);
		this.theCreatePlayersAndAdminsScene = this.createScene("CreatePlayersAndAdminsView", new CreatePlayersAndAdminsViewControl(this));
		
		this.theManageItemsScene = this.createScene("ManageItemsView", new ManageItemsViewControl(this));
		this.theEditItemsScene = this.createScene("EditItemsView", this.theEditItemsViewControl);
		this.theCreateItemsScene = this.createScene("CreateItemsView", new CreateItemsViewControl(this));
		
		this.theManageNPCCharactersScene = this.createScene("ManageNPCCharactersView", new ManageNPCCharactersViewControl(this));
		this.theEditNPCCharactersScene = this.createScene("EditNPCCharactersView", this.theEditNPCCharactersViewControl);
		this.theCreateNPCCharactersScene = this.createScene("CreateNPCCharactersView", new CreateNPCCharactersViewControl(this));
		
		this.theManageQuestChainsScene = this.createScene("ManageQuestChainsView", new ManageConflictsViewControl(this));
		this.theManageTemplateVoyageAndReturnScene = this.createScene("ManageTemplateVoyageView", new EditConflictQuestsViewControl(this, "Voyage and Return"));
		this.theManageTemplateTheQuestScene = this.createScene("ManageTemplateTheQuestView", new EditConflictQuestsViewControl(this, "The Quest"));
		this.theManageTemplateDefeatTheMonsterScene = this.createScene("ManageTemplateMonsterView", new EditConflictQuestsViewControl(this, "Defeat the Monster"));
		this.theManageTemplateCustomScene = this.createScene("ManageTemplateCustomView", new EditConflictQuestsViewControl(this, "Custom"));
	} 
	
	public GameStory getTheGameStory() {
		return this.theEditGameStoryViewControl.getGameStoryEditControl().getGameStoryToEdit();
	}
	
	/**
	 * Gets the Player object that is logged in as Admin
	 * @return the Admin Player Object
	 */
	public Player getTheAdminPlayer() {
		return this.theMainDashbaordControl.getTheAdminPlayer();
	}
	
	/**
	 * Sets the view control reference in the logic control the theManagePlayersAndAdminsViewControl
	 * @param theManagePlayersAndAdminsViewControl
	 */
	public void setTheManagePlayersAndAdminsViewControl(ManagePlayersAndAdminsViewControl theManagePlayersAndAdminsViewControl) {
		this.theManagePlayersAndAdminsViewControl = theManagePlayersAndAdminsViewControl;
	}
	
	/**
	 * Sets the view control reference in the logic control the theManageNPCCharactersViewControl
	 * @param theManageNPCCharactersViewControl
	 */
	public void setTheManageNPCCharactersViewControl(ManageNPCCharactersViewControl theManageNPCCharactersViewControl) {
		this.theManageNPCCharactersViewControl = theManageNPCCharactersViewControl;
	}

	/**
	 * Sets the view control reference in the logic control the theManageItemsViewControl
	 * @param theManageItemsViewControl
	 */
	public void setTheManageItemsViewControl(ManageItemsViewControl theManageItemsViewControl) {
		this.theManageItemsViewControl = theManageItemsViewControl;
	}

	/**
	 * Sets the view control reference in the logic control the theManageQuestChainsViewControl
	 * @param theManageQuestChainsViewControl
	 */
	public void setTheManageQuestChainsViewControl(ManageConflictsViewControl theManageQuestChainsViewControl) {
		this.theManageQuestChainsViewControl = theManageQuestChainsViewControl;
	}

	/**
	 * Sets the view control reference in the logic control the theEditConflictQuestsViewControl
	 * @param theEditConflictQuestsViewControl
	 */
	public void setTheEditConflictQuestsViewControl(EditConflictQuestsViewControl theEditConflictQuestsViewControl) {
		this.theEditConflictQuestsViewControl = theEditConflictQuestsViewControl;
	}

	/**
	 * Sets the view control reference in the logic control the theEditConflictVoyageViewControl
	 * @param theEditConflictVoyageViewControl
	 */
	public void setTheEditConflictVoyageViewControl(EditConflictQuestsViewControl theEditConflictVoyageViewControl) {
		this.theEditConflictVoyageViewControl = theEditConflictVoyageViewControl;
	}

	/**
	 * Sets the view control reference in the logic control the theEditConflictMonsterViewControl
	 * @param theEditConflictMonsterViewControl
	 */
	public void setTheEditConflictMonsterViewControl(EditConflictQuestsViewControl theEditConflictMonsterViewControl) {
		this.theEditConflictMonsterViewControl = theEditConflictMonsterViewControl;
	}

	/**
	 * Sets the view control reference in the logic control the theEditConflictCustomViewControl
	 * @param theEditConflictCustomViewControl
	 */
	public void setTheEditConflictCustomViewControl(EditConflictQuestsViewControl theEditConflictCustomViewControl) {
		this.theEditConflictCustomViewControl = theEditConflictCustomViewControl;
	}
	
	/**
	 * Sets the id of the Player to be edited
	 * @param playerIdToEdit
	 */
	public void setPlayerToEdit(int playerIdToEdit) {
		theEditPlayersAndAdminsViewControl.getEditPlayersAndAdminsControl().setSelectedPlayer(playerIdToEdit);
		theEditPlayersAndAdminsViewControl.setFormForSelectedPlayer(theEditPlayersAndAdminsViewControl.getEditPlayersAndAdminsControl().getSelectedPlayer());
	}

	/**
	 * Sets the id of the NPCCharacter to be edited
	 * @param npcIdToEdit
	 */
	public void setNPCToEdit(int npcIdToEdit) {
		theEditNPCCharactersViewControl.getEditNPCCharactersControl().setSelectedNPC(npcIdToEdit);
		theEditNPCCharactersViewControl.setFormForSelectedNPC(theEditNPCCharactersViewControl.getEditNPCCharactersControl().GetSelectedNPC());
	}

	/**
	 * Sets the id of the Item to be edited
	 * @param itemIdToEdit
	 */
	public void setItemToEdit(int itemIdToEdit) {
		theEditItemsViewControl.getEditItemsControl().setSelectedItem(itemIdToEdit);
		theEditItemsViewControl.setFormForSelectedItem(theEditItemsViewControl.getEditItemsControl().getSelectedItem());
	}
	
	public void setConflictToEdit(Conflict conflictToEdit, String arcType) {
    	switch(arcType) {
    	case "The Quest":
    		this.theEditConflictQuestsViewControl.getTheManageQuestsControl().setTheConflictToEdit(conflictToEdit);
    		break;
    	case "Voyage and Return":
    		this.theEditConflictVoyageViewControl.getTheManageQuestsControl().setTheConflictToEdit(conflictToEdit);
    		break;
    	case "Defeat the Monster":
    		this.theEditConflictMonsterViewControl.getTheManageQuestsControl().setTheConflictToEdit(conflictToEdit);
    		break;
    	case "Custom":
    		this.theEditConflictCustomViewControl.getTheManageQuestsControl().setTheConflictToEdit(conflictToEdit);
    		break;
		default: break;
	}
		//theEditItemsViewControl.SetFormForSelectedItem(theEditItemsViewControl.GetEditItemsControl().GetSelectedItem());
	}
	
	@FXML
	private void initialize() {
		this.gameStoryDashboardLabel.setText(this.getTheGameStory().getGameStoryName() + " Management Dashboard");
	}

	@FXML
	private void handleManageEditGameStory() throws SQLException {
		setMainDashboardStage("editGameStory");
	}
	
	@FXML
	private void handleLogoutButtonAction() throws Exception
	{
		theMainDashbaordControl.resetLoginView();
		HideMainDashboardView();
	}
	
	@FXML
	public void handleManagePlayersAndAdminsButton() throws Exception
	{
		setMainDashboardStage("managePlayersAndAdmins");
	}
	
	@FXML
	private void handleItemsButton() throws Exception
	{
		setMainDashboardStage("manageItems");
	}
	
	@FXML
	private void handleNPCCharactersButton() throws Exception
	{
		setMainDashboardStage("manageNPCCharacters");
	}
	
	@FXML
	private void handleQuestChainsButton() throws Exception
	{
		setMainDashboardStage("manageQuestChains");
	}
	
	/**
	 * Loads the new MainDashboard when the dashboard is first accessed
	 * @throws SQLException 
	 */
	public void loadMainDashboardView() throws SQLException {
		setMainDashboardStage("mainDashboard");
	}
	
	/**
	 * Enabiles the view of the MainDashboard
	 */
	public void showMainDashboardView() {
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
	public MySQLAccess getDBConnection() {
		return theMainDashbaordControl.getDBConnection();
	}
	
	/**
	 * Sets the MainDashboard Stage Scene
	 * @param theSceneNameToLoad	the String name of the scene to load
	 * @throws SQLException 
	 */
	public void setMainDashboardStage(String theSceneNameToLoad) throws SQLException {
		Scene theSceneToStage = null;
		switch (theSceneNameToLoad) {
			case "mainDashboard":
				this.gameStoryDashboardLabel.setText(this.getTheGameStory().getGameStoryName() + " Management Dashboard");
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
				theEditConflictQuestsViewControl.updateExistingTheQuestList();
				theSceneToStage = theManageTemplateTheQuestScene;
				break;
			case "manageTemplateVoyageAndReturn":
				theEditConflictVoyageViewControl.updateExistingTheQuestList();
				theSceneToStage = theManageTemplateVoyageAndReturnScene;
				break;
			case "manageTemplateDefeatTheMonster":
				theEditConflictMonsterViewControl.updateExistingTheQuestList();
				theSceneToStage = theManageTemplateDefeatTheMonsterScene;
				break;
			case "manageTemplateCustom":
				theEditConflictCustomViewControl.updateExistingTheQuestList();
				theSceneToStage = theManageTemplateCustomScene;
				break;
			case "editGameStory":
				theSceneToStage = theEditGameStoryScene;
				break;
			default: break;
		}
        theMainDashboardStage.setScene(theSceneToStage);
        showMainDashboardView();
	}
	
	private void createEditViewControls() throws SQLException {
        theEditPlayersAndAdminsViewControl = new EditPlayersAndAdminsViewControl(this);
        theEditItemsViewControl = new EditItemsViewControl(this);
        theEditNPCCharactersViewControl = new EditNPCCharactersViewControl(this);
        theEditGameStoryViewControl = new EditGameStoryViewControl(this);
	}
	
	private Scene createScene(String viewFXMLFilename, ViewControl theViewControl) {
        try {
            theFxmlLoader = new FXMLLoader(App.class.getResource(viewFXMLFilename + ".fxml"));
            theFxmlLoader.setController(theViewControl);
            Parent theParent = theFxmlLoader.load();
            return new Scene(theParent);
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
	}
}
