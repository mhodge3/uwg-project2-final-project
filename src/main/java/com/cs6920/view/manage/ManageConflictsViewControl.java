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
		this.conflictMinLvlTableColumn.setCellValueFactory(new PropertyValueFactory<Conflict, Integer>("conflictMinLvl"));
		this.conflictIdTableColumn.setCellValueFactory(new PropertyValueFactory<Conflict, Integer>("conflictId"));
		this.conflictNameTableColumn.setCellValueFactory(new PropertyValueFactory<Conflict, String>("conflictName"));
		this.conflictArcTypeTableColumn.setCellValueFactory(new PropertyValueFactory<Conflict, String>("conflictArcType"));
	}
    
	public ManageConflictsControl GetManageQuestChainsControl() {
		return this.theManageConflictsControl;
	}
	
	/**
	 * Binds the ObservableList to the TableView
	 * @throws SQLException 
	 */
    public void updateExistingConflictList() throws SQLException {
    	this.theManageConflictsControl.updateConflictArrayList();
    	this.updateConflictsTableDisplay();
    }
    
    private void updateConflictsTableDisplay() {
    	this.conflictChainTableView.getItems().clear();
    	this.conflictChainTableView.getItems().addAll(this.theManageConflictsControl.GetObservableConflictList());
    	this.conflictMinLvlTableColumn.setSortType(TableColumn.SortType.DESCENDING);
    	this.conflictChainTableView.getSortOrder().add(this.conflictMinLvlTableColumn);
    	this.conflictChainTableView.sort();
    }
	
	@FXML
	private void handleCreateTemplateTheQuestButton() throws SQLException {
		this.theManageConflictsControl.createTheQuestConflict();
    	this.updateConflictsTableDisplay();
	}
	
	@FXML
	private void handleCreateTemplateVoyageButton() throws SQLException {
		this.theManageConflictsControl.createVoyageConflict();
    	this.updateConflictsTableDisplay();
	}
	
	@FXML
	private void handleCreateTemplateMonsterButton() throws SQLException {
		this.theManageConflictsControl.createMonsterConflict();
    	this.updateConflictsTableDisplay();
	}
	
	@FXML
	private void handleCreateTemplateCustomButton() throws SQLException {
		this.theManageConflictsControl.createCustomConflict();
    	this.updateConflictsTableDisplay();
	}
	
	@FXML
	private void handleEditQuestChainButton() throws SQLException {
		if (this.conflictChainTableView.getSelectionModel().getSelectedItem() != null) {
			this.theMainDashboardViewControl.setConflictToEdit(this.theManageConflictsControl.getConflictById(this.conflictChainTableView.getSelectionModel().getSelectedItem().getConflictId()), this.conflictChainTableView.getSelectionModel().getSelectedItem().getConflictArcType());
			switch(this.conflictChainTableView.getSelectionModel().getSelectedItem().getConflictArcType()) {
				case "The Quest":
					this.theMainDashboardViewControl.setMainDashboardStage("manageTemplateTheQuest");
					break;
				case "Voyage and Return":
					this.theMainDashboardViewControl.setMainDashboardStage("manageTemplateVoyageAndReturn");
					break;
				case "Defeat the Monster":
					this.theMainDashboardViewControl.setMainDashboardStage("manageTemplateDefeatTheMonster");
					break;
				case "Custom":
					this.theMainDashboardViewControl.setMainDashboardStage("manageTemplateCustom");
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
		if (this.conflictChainTableView.getSelectionModel().getSelectedItem() != null) {
			this.theManageConflictsControl.deleteTheQuestConflict(this.conflictChainTableView.getSelectionModel().getSelectedItem().getConflictId());
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
		this.theMainDashboardViewControl.loadMainDashboardView();
	}
}
