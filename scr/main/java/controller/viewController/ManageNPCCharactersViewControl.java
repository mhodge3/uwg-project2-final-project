package controller.viewController;

import java.sql.SQLException;

import controller.logicController.ManageNPCCharactersControl;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import model.NpcCharacter;

/**
 * Provides the View Control Logic for the Manage NPC Characters View
 * @author Matthew Hodge
 * @version 6.13.2020
 */
public class ManageNPCCharactersViewControl {
	@FXML
	private TableView<NpcCharacter> existingNPCTableView;
	@FXML
	private TableColumn<NpcCharacter, Integer> npcIDTableColumn;
	@FXML
	private TableColumn<NpcCharacter, Integer> npcTypeTableColumn;
	@FXML
	private TableColumn<NpcCharacter, String> npcNameTableColumn;
	@FXML
	private TableColumn<NpcCharacter, String> npcDescriptionTableColumn;
	
	private MainDashboardViewControl theMainDashboardViewControl;
	private ManageNPCCharactersControl theManageNPCCharactersControl;
    
	/**
	 * Constructor for this View Control
	 * @param theMainDashboardViewControl	Reference to the MainDashboard's View Control
	 */
    public ManageNPCCharactersViewControl(MainDashboardViewControl theMainDashboardViewControl) {
    	this.theMainDashboardViewControl = theMainDashboardViewControl;
    	this.theMainDashboardViewControl.SetTheManageNPCCharactersViewControl(this);
    	this.theManageNPCCharactersControl = new ManageNPCCharactersControl(theMainDashboardViewControl.GetDBConnection());
    }
    
	/**
	 * Binds the ObservableList to the TableView
	 * @throws SQLException 
	 */
    public void updateExistingNPCCharactersList() throws SQLException {
    	theManageNPCCharactersControl.UpdatePlayerArrayList();
    	existingNPCTableView.getItems().clear();
    	existingNPCTableView.getItems().addAll(theManageNPCCharactersControl.GetObservablePlayerList());
    }

	@FXML
    public void initialize() throws SQLException {
		npcIDTableColumn.setCellValueFactory(new PropertyValueFactory<NpcCharacter, Integer>("npcId"));
		npcTypeTableColumn.setCellValueFactory(new PropertyValueFactory<NpcCharacter, Integer>("npcType"));
		npcNameTableColumn.setCellValueFactory(new PropertyValueFactory<NpcCharacter, String>("npcName"));
		npcDescriptionTableColumn.setCellValueFactory(new PropertyValueFactory<NpcCharacter, String>("npcDescription"));
    }
	
	@FXML
	private void handleNPCCharacterBackButton() throws SQLException {
		theMainDashboardViewControl.LoadMainDashboardView();
	}
	
	@FXML
	private void handleEditSelectedNPCButton() throws SQLException {
		if (existingNPCTableView.getSelectionModel().getSelectedItem() != null) {
			theMainDashboardViewControl.SetNPCToEdit(existingNPCTableView.getSelectionModel().getSelectedItem().GetNpcId());
			theMainDashboardViewControl.SetMainDashboardStage("editNPCCharacters");
		}
		else {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Edit User Issue");
			alert.setHeaderText("Cannot Edit User");
			alert.setContentText("A User to edit was not selected. Please select the user you wish to edit");
			alert.showAndWait();
		}
	}
	
	@FXML
	private void handleCreateNPCButton() throws SQLException {
		theMainDashboardViewControl.SetMainDashboardStage("createNPCCharacters");
	}
}
