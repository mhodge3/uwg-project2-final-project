package com.cs6920.control.view_control;

import java.sql.SQLException;

import com.cs6920.control.logic_control.ManageQuestChainsControl;
import com.cs6920.model.Conflict;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * Provides the View Control Logic for the Managing Quest Chains View
 * @author Matthew Hodge
 * @version 6.13.2020
 */
public class ManageQuestChainsViewControl {
	@FXML
	private TableView<Conflict> conflictChainTableView;
	@FXML
	private TableColumn<Conflict, Integer> conflictMinLvlTableColumn;
	@FXML
	private TableColumn<Conflict, Integer> conflictIdTableColumn;
	@FXML
	private TableColumn<Conflict, String> conflictNameTableColumn;
	@FXML
	private TableColumn<Conflict, String> conflictDescriptionTableColumn;
	
	private MainDashboardViewControl theMainDashboardViewControl;
	private ManageQuestChainsControl theManageQuestChainsControl;
    
	/**
	 * Constructor for this View Control
	 * @param theMainDashboardViewControl	Reference to the MainDashboard's View Control
	 */
    public ManageQuestChainsViewControl(MainDashboardViewControl theMainDashboardViewControl) {
    	this.theMainDashboardViewControl = theMainDashboardViewControl;
    	this.theMainDashboardViewControl.SetTheManageQuestChainsViewControl(this);
    	this.theManageQuestChainsControl = new ManageQuestChainsControl(theMainDashboardViewControl.GetDBConnection());
    
    }

	@FXML
    private void initialize() throws SQLException {
		conflictMinLvlTableColumn.setCellValueFactory(new PropertyValueFactory<Conflict, Integer>("conflictMinLvl"));
		conflictIdTableColumn.setCellValueFactory(new PropertyValueFactory<Conflict, Integer>("conflictId"));
		conflictNameTableColumn.setCellValueFactory(new PropertyValueFactory<Conflict, String>("conflictName"));
		conflictDescriptionTableColumn.setCellValueFactory(new PropertyValueFactory<Conflict, String>("conflictDescription"));
	}
    
	public ManageQuestChainsControl GetManageQuestChainsControl() {
		return this.theManageQuestChainsControl;
	}
	/**
	 * Binds the ObservableList to the TableView
	 * @throws SQLException 
	 */
    public void updateExistingConflictList() throws SQLException {
    	theManageQuestChainsControl.UpdateConflictArrayList();
    	conflictChainTableView.getItems().clear();
    	conflictChainTableView.getItems().addAll(theManageQuestChainsControl.GetObservableConflictList());
    	conflictMinLvlTableColumn.setSortType(TableColumn.SortType.DESCENDING);
    	conflictChainTableView.getSortOrder().add(conflictMinLvlTableColumn);
    	conflictChainTableView.sort();
    }
	
	@FXML
	private void handleCreateTemplateTheQuestButton() throws SQLException {
		theMainDashboardViewControl.SetMainDashboardStage("manageTemplateTheQuest");
	}
	
	@FXML
	private void handleEditQuestChainButton() throws SQLException {
		if (conflictChainTableView.getSelectionModel().getSelectedItem() != null) {
			theMainDashboardViewControl.SetConflictToEdit(conflictChainTableView.getSelectionModel().getSelectedItem().GetConflictId());
			theMainDashboardViewControl.SetMainDashboardStage("manageTemplateTheQuest");
		}
		else {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Edit Story Conflict Issue");
			alert.setHeaderText("Cannot Edit Story Conflict");
			alert.setContentText("A Story Conflict to edit was not selected. Please select the Conflict you wish to edit");
			alert.showAndWait();
		}
	}
	
	@FXML
	private void handleQuestChainsBackButton() throws SQLException {
		theMainDashboardViewControl.LoadMainDashboardView();
	}
}
