package com.cs6920.view.manage;

import java.sql.SQLException;

import com.cs6920.control.logic_control.ManageConflictsControl;
import com.cs6920.model.Conflict;
import com.cs6920.view.MainDashboardViewControl;
import com.cs6920.view.ViewControl;

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
public class ManageConflictsViewControl extends ViewControl {
	@FXML
	private TableView<Conflict> conflictChainTableView;
	@FXML
	private TableColumn<Conflict, Integer> conflictMinLvlTableColumn;
	@FXML
	private TableColumn<Conflict, Integer> conflictIdTableColumn;
	@FXML
	private TableColumn<Conflict, String> conflictNameTableColumn;
	@FXML
	private TableColumn<Conflict, String> conflictArcTypeTableColumn;
	
	private MainDashboardViewControl theMainDashboardViewControl;
	private ManageConflictsControl theManageConflictsControl;
    
	/**
	 * Constructor for this View Control
	 * @param theMainDashboardViewControl	Reference to the MainDashboard's View Control
	 */
    public ManageConflictsViewControl(MainDashboardViewControl theMainDashboardViewControl) {
    	this.theMainDashboardViewControl = theMainDashboardViewControl;
    	this.theMainDashboardViewControl.setTheManageQuestChainsViewControl(this);
    	this.theManageConflictsControl = new ManageConflictsControl(theMainDashboardViewControl.getDBConnection());
    
    }

	@FXML
    private void initialize() throws SQLException {
		conflictMinLvlTableColumn.setCellValueFactory(new PropertyValueFactory<Conflict, Integer>("conflictMinLvl"));
		conflictIdTableColumn.setCellValueFactory(new PropertyValueFactory<Conflict, Integer>("conflictId"));
		conflictNameTableColumn.setCellValueFactory(new PropertyValueFactory<Conflict, String>("conflictName"));
		conflictArcTypeTableColumn.setCellValueFactory(new PropertyValueFactory<Conflict, String>("conflictArcType"));
	}
    
	public ManageConflictsControl GetManageQuestChainsControl() {
		return this.theManageConflictsControl;
	}
	
	/**
	 * Binds the ObservableList to the TableView
	 * @throws SQLException 
	 */
    public void updateExistingConflictList() throws SQLException {
    	theManageConflictsControl.updateConflictArrayList();
    	this.updateConflictsTableDisplay();
    }
    
    private void updateConflictsTableDisplay() {
    	conflictChainTableView.getItems().clear();
    	conflictChainTableView.getItems().addAll(theManageConflictsControl.GetObservableConflictList());
    	conflictMinLvlTableColumn.setSortType(TableColumn.SortType.DESCENDING);
    	conflictChainTableView.getSortOrder().add(conflictMinLvlTableColumn);
    	conflictChainTableView.sort();
    }
	
	@FXML
	private void handleCreateTemplateTheQuestButton() throws SQLException {
		theManageConflictsControl.createTheQuestConflict();
    	this.updateConflictsTableDisplay();
	}
	
	@FXML
	private void handleCreateTemplateVoyageButton() throws SQLException {
		theManageConflictsControl.createVoyageConflict();
    	this.updateConflictsTableDisplay();
	}
	
	@FXML
	private void handleCreateTemplateMonsterButton() throws SQLException {
		theManageConflictsControl.createMonsterConflict();
    	this.updateConflictsTableDisplay();
	}
	
	@FXML
	private void handleCreateTemplateCustomButton() throws SQLException {
		theManageConflictsControl.createCustomConflict();
    	this.updateConflictsTableDisplay();
	}
	
	@FXML
	private void handleEditQuestChainButton() throws SQLException {
		if (conflictChainTableView.getSelectionModel().getSelectedItem() != null) {
			theMainDashboardViewControl.setConflictToEdit(theManageConflictsControl.getConflictById(conflictChainTableView.getSelectionModel().getSelectedItem().getConflictId()), conflictChainTableView.getSelectionModel().getSelectedItem().getConflictArcType());
			switch(conflictChainTableView.getSelectionModel().getSelectedItem().getConflictArcType()) {
				case "The Quest":
					theMainDashboardViewControl.setMainDashboardStage("manageTemplateTheQuest");
					break;
				case "Voyage and Return":
					theMainDashboardViewControl.setMainDashboardStage("manageTemplateVoyageAndReturn");
					break;
				case "Defeat the Monster":
					theMainDashboardViewControl.setMainDashboardStage("manageTemplateDefeatTheMonster");
					break;
				case "Custom":
					theMainDashboardViewControl.setMainDashboardStage("manageTemplateCustom");
					break;
				default: break;
			}
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
	private void handleDeleteQuestChainButton() throws SQLException {
		if (conflictChainTableView.getSelectionModel().getSelectedItem() != null) {
			theManageConflictsControl.deleteTheQuestConflict(conflictChainTableView.getSelectionModel().getSelectedItem().getConflictId());
	    	this.updateConflictsTableDisplay();
		}
		else {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Delete Story Conflict Issue");
			alert.setHeaderText("Cannot Delete Story Conflict");
			alert.setContentText("A Story Conflict to Delete was not selected. Please select the Conflict you wish to Delete");
			alert.showAndWait();
		}
	}
	
	@FXML
	private void handleQuestChainsBackButton() throws SQLException {
		theMainDashboardViewControl.loadMainDashboardView();
	}
}
