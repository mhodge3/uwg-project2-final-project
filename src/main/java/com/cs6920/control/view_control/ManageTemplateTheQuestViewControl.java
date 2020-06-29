package com.cs6920.control.view_control;

import java.sql.SQLException;

import com.cs6920.control.logic_control.ManageTemplateTheQuestControl;
import com.cs6920.model.Quest;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class ManageTemplateTheQuestViewControl {
	@FXML
	private TableView<Quest> questTableView;
	@FXML
	private TableColumn<Quest, Integer> questMinLvlTableColumn;
	@FXML
	private TableColumn<Quest, Integer> questIDTableColumn;
	@FXML
	private TableColumn<Quest, Integer> questPRIDTableColumn;
	@FXML
	private TableColumn<Quest, String> questNameTableColumn;
	@FXML
	private TableColumn<Quest, Integer> questTypeTableColumn;
	
	private MainDashboardViewControl theMainDashboardViewControl;
	private ManageTemplateTheQuestControl theManageTemplateTheQuestControl;
    
	/**
	 * Constructor for this View Control
	 * @param theMainDashboardViewControl	Reference to the MainDashboard's View Control
	 */
    public ManageTemplateTheQuestViewControl(MainDashboardViewControl theMainDashboardViewControl) {
    	this.theMainDashboardViewControl = theMainDashboardViewControl;
    	this.theMainDashboardViewControl.SetTheManageTheQuestViewControl(this);
    	this.theManageTemplateTheQuestControl = new ManageTemplateTheQuestControl(theMainDashboardViewControl.GetDBConnection());
    
    }

	@FXML
    private void initialize() throws SQLException {
		questMinLvlTableColumn.setCellValueFactory(new PropertyValueFactory<Quest, Integer>("minCharacterLevel"));
		questIDTableColumn.setCellValueFactory(new PropertyValueFactory<Quest, Integer>("questId"));
		questPRIDTableColumn.setCellValueFactory(new PropertyValueFactory<Quest, Integer>("preReqQuestId"));
		questNameTableColumn.setCellValueFactory(new PropertyValueFactory<Quest, String>("questName"));
		questTypeTableColumn.setCellValueFactory(new PropertyValueFactory<Quest, Integer>("questDescription"));
	}
    
	/**
	 * Binds the ObservableList to the TableView
	 * @throws SQLException 
	 */
    public void updateExistingTheQuestList() throws SQLException {
    	theManageTemplateTheQuestControl.UpdateTheQuestArrayList();
    	questTableView.getItems().clear();
    	questTableView.getItems().addAll(theManageTemplateTheQuestControl.GetObservableTheQuestList());
    	questPRIDTableColumn.setSortType(TableColumn.SortType.DESCENDING);
    	questTableView.getSortOrder().add(questPRIDTableColumn);
    	questTableView.sort();
    }
	
	@FXML
	private void handleQuestChainsBackButton() throws SQLException {
		theMainDashboardViewControl.SetMainDashboardStage("manageQuestChains");
	}
}
