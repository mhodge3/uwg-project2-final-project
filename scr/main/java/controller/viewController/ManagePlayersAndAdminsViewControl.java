package controller.viewController;

import controller.logicController.ManagePlayersAndAdminsControl;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Player;

/**
 * Provides the View Control Logic for the Manage Players and Admin View
 * @author Matthew Hodge
 * @version 6.13.2020
 */
public class ManagePlayersAndAdminsViewControl {
	@FXML
	private TableView<Player> existingUserTableView;
	@FXML
	private TableColumn<Player, Integer> userIDTableColumn;
	@FXML
	private TableColumn<Player, String> userNameTableColumn;
	@FXML
	private TableColumn<Player, String> userEmailTableColumn;
	@FXML
	private TableColumn<Player, String> userCountryCodeTableColumn;
	
	private MainDashboardViewControl theMainDashboardViewControl;
	private ManagePlayersAndAdminsControl theManagePlayersAndAdminsControl;

	@FXML
    public void initialize() {
		userIDTableColumn.setCellValueFactory(new PropertyValueFactory<Player, Integer>("playerId"));
		userNameTableColumn.setCellValueFactory(new PropertyValueFactory<Player, String>("playerName"));
		userEmailTableColumn.setCellValueFactory(new PropertyValueFactory<Player, String>("playerEmail"));
		userCountryCodeTableColumn.setCellValueFactory(new PropertyValueFactory<Player, String>("playerCountryCode"));
    	updateExistingPlayerAdminList();
    }
    
	/**
	 * Binds the ObservableList to the TableView
	 */
    public void updateExistingPlayerAdminList() {
    	existingUserTableView.getItems().addAll(theManagePlayersAndAdminsControl.GetObservablePlayerList());
    }
    
	/**
	 * Constructor for this View Control
	 * @param theMainDashboardViewControl	Reference to the MainDashboard's View Control
	 */
    public ManagePlayersAndAdminsViewControl(MainDashboardViewControl theMainDashboardViewControl) {
    	this.theMainDashboardViewControl = theMainDashboardViewControl;
    	this.theManagePlayersAndAdminsControl = new ManagePlayersAndAdminsControl(theMainDashboardViewControl.GetDBConnection());
    }
	
	@FXML
	private void handlePlayerAndAdminBackButton() {
		theMainDashboardViewControl.SetMainDashboardStage("mainDashboard");
	}
	
	@FXML
	private void handleEditSelectedUserButton() {
		theMainDashboardViewControl.SetMainDashboardStage("editPlayersAndAdmins");
	}
	
	@FXML
	private void handleCreateUserButton() {
		theMainDashboardViewControl.SetMainDashboardStage("createPlayersAndAdmins");
	}
}
