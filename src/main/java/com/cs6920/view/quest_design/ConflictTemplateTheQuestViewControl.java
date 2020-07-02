package com.cs6920.view.quest_design;

import java.io.IOException;
import java.sql.SQLException;

import com.cs6920.control.logic_control.ManageTemplateTheQuestControl;
import com.cs6920.model.Conflict;
import com.cs6920.model.Quest;
import com.cs6920.story_mapper.App;
import com.cs6920.view.MainDashboardViewControl;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ConflictTemplateTheQuestViewControl {
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
	@FXML
	private TextField storyConflictNameTextField;
	@FXML
	private TextArea storyConflictDescriptionTextArea;
	
	private MainDashboardViewControl theMainDashboardViewControl;
	private ManageTemplateTheQuestControl theManageTemplateTheQuestControl;
    
	/**
	 * Constructor for this View Control
	 * @param theMainDashboardViewControl	Reference to the MainDashboard's View Control
	 */
    public ConflictTemplateTheQuestViewControl(MainDashboardViewControl theMainDashboardViewControl) {
    	this.theMainDashboardViewControl = theMainDashboardViewControl;
    	this.theMainDashboardViewControl.SetTheManageTheQuestViewControl(this);
    	this.theManageTemplateTheQuestControl = new ManageTemplateTheQuestControl(theMainDashboardViewControl.GetDBConnection());
    	
    }
    
    public MainDashboardViewControl GetTheMainDashboardViewControl() {
    	return this.theMainDashboardViewControl;
    }
    
    public ManageTemplateTheQuestControl GetTheManageTemplateTheQuestControl() {
    	return this.theManageTemplateTheQuestControl;
    }

	@FXML
    private void initialize() throws SQLException {
		questMinLvlTableColumn.setCellValueFactory(new PropertyValueFactory<Quest, Integer>("minCharacterLevel"));
		questIDTableColumn.setCellValueFactory(new PropertyValueFactory<Quest, Integer>("idInConflict"));
		questPRIDTableColumn.setCellValueFactory(new PropertyValueFactory<Quest, Integer>("preReqIdInConflict"));
		questNameTableColumn.setCellValueFactory(new PropertyValueFactory<Quest, String>("questName"));
		questTypeTableColumn.setCellValueFactory(new PropertyValueFactory<Quest, Integer>("questArcType"));
	}
    
    @FXML
    private void addObstacleQuest() {
    	try {
			theManageTemplateTheQuestControl.addObstacle();
	    	questTableView.getItems().clear();
	    	questTableView.getItems().addAll(theManageTemplateTheQuestControl.GetObservableTheQuestList());
	    	questPRIDTableColumn.setSortType(TableColumn.SortType.DESCENDING);
	    	questTableView.getSortOrder().add(questPRIDTableColumn);
	    	questTableView.sort();
			questTableView.refresh();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    @FXML
    private void removeObstacleQuest() throws SQLException {
    	if (questTableView.getSelectionModel().getSelectedItem() != null) {
			theManageTemplateTheQuestControl.removeQuest(questTableView.getSelectionModel().getSelectedItem().GetQuestId());
			questTableView.getItems().clear();
			questTableView.getItems().addAll(theManageTemplateTheQuestControl.GetObservableTheQuestList());
			questPRIDTableColumn.setSortType(TableColumn.SortType.DESCENDING);
			questTableView.getSortOrder().add(questPRIDTableColumn);
			questTableView.sort();
			questTableView.refresh();
		}
    }
    
    @FXML
    private void editQuest(ActionEvent event) throws IOException, SQLException {
		if (questTableView.getSelectionModel().getSelectedItem() != null) {
			switch (questTableView.getSelectionModel().getSelectedItem().GetQuestArcType()) {
				case "calling":
					this.editCallToAdventure(event, questTableView.getSelectionModel().getSelectedItem().GetidInConflict(), "EditQuestCalling");
					break;
				case "leaving":
					this.editCallToAdventure(event, questTableView.getSelectionModel().getSelectedItem().GetidInConflict(), "EditQuestLeaving");
					break;
				case "obstacle":
					this.editCallToAdventure(event, questTableView.getSelectionModel().getSelectedItem().GetidInConflict(), "EditQuestObstacle");
					break;
				case "obtain elixir":
					this.editCallToAdventure(event, questTableView.getSelectionModel().getSelectedItem().GetidInConflict(), "EditQuestObtainElixir");
					break;
				case "return elixir":
					this.editCallToAdventure(event, questTableView.getSelectionModel().getSelectedItem().GetidInConflict(), "EditQuestReturnWithElixir");
					break;
				default: break;
			}
		}
		else {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Edit Conflict Quest Issue");
			alert.setHeaderText("Cannot Edit Quest");
			alert.setContentText("A Quest to edit was not selected. Please select the Quest you wish to edit");
			alert.showAndWait();
		}
    }
    
    private void editCallToAdventure(ActionEvent event, int questIdToEdit, String fxmlFileName) throws IOException, SQLException {
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader(App.class.getResource(fxmlFileName + ".fxml"));
        loader.setController(new QuestTemplateTheCallingViewControl(this, this.theMainDashboardViewControl.GetDBConnection(), questIdToEdit));
        Parent root = loader.load();
        stage.setScene(new Scene(root));
        stage.setTitle("My modal window");
        stage.initModality(Modality.WINDOW_MODAL);
        stage.initOwner( ((Node)event.getSource()).getScene().getWindow() );
        stage.show();
    }
    
	/**
	 * Binds the ObservableList to the TableView
	 * @throws SQLException 
	 */
    public void updateExistingTheQuestList() throws SQLException {
    	theManageTemplateTheQuestControl.createQuestTemplateList(2);
    	theManageTemplateTheQuestControl.UpdateTheQuestArrayList();
    	questTableView.getItems().clear();
    	questTableView.getItems().addAll(theManageTemplateTheQuestControl.GetObservableTheQuestList());
    	questPRIDTableColumn.setSortType(TableColumn.SortType.DESCENDING);
    	questTableView.getSortOrder().add(questPRIDTableColumn);
    	questTableView.sort();
    }
    
    /**
     * These update methods will be refactored into one when we don't have to build temp data
     * @throws SQLException 
     */
    public void updateQuestList() throws SQLException {
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
