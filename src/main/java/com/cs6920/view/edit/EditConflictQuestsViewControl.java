package com.cs6920.view.edit;

import java.io.IOException;
import java.sql.SQLException;

import com.cs6920.control.logic_control.ManageQuestsControl;
import com.cs6920.model.Quest;
import com.cs6920.story_mapper.App;
import com.cs6920.view.MainDashboardViewControl;
import com.cs6920.view.ViewControl;

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

public class EditConflictQuestsViewControl extends ViewControl {
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
	private ManageQuestsControl theManageQuestsControl;
    
	/**
	 * Constructor for this View Control
	 * @param theMainDashboardViewControl	Reference to the MainDashboard's View Control
	 */
    public EditConflictQuestsViewControl(MainDashboardViewControl theMainDashboardViewControl, String arcType) {
    	this.theMainDashboardViewControl = theMainDashboardViewControl;
    	switch(arcType) {
	    	case "The Quest":
	        	this.theMainDashboardViewControl.SetTheEditConflictQuestsViewControl(this);
	    		break;
	    	case "Voyage and Return":
	        	this.theMainDashboardViewControl.SetTheEditConflictVoyageViewControl(this);
	    		break;
	    	case "Defeat the Monster":
	        	this.theMainDashboardViewControl.SetTheEditConflictMonsterViewControl(this);
	    		break;
	    	case "Custom":
	        	this.theMainDashboardViewControl.SetTheEditConflictCustomViewControl(this);
	    		break;
    		default: break;
    	}
    	this.theManageQuestsControl = new ManageQuestsControl(theMainDashboardViewControl.GetDBConnection());
    	
    }
    
    public MainDashboardViewControl GetTheMainDashboardViewControl() {
    	return this.theMainDashboardViewControl;
    }
    
    public ManageQuestsControl GetTheManageQuestsControl() {
    	return this.theManageQuestsControl;
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
    private void addVariableQuest() {
    	try {
			theManageQuestsControl.addObstacle();
	    	this.refreshTheQuestList();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    @FXML
    private void removeVariableQuest() throws SQLException {
    	if (questTableView.getSelectionModel().getSelectedItem() != null) {
			theManageQuestsControl.removeQuest(questTableView.getSelectionModel().getSelectedItem().GetQuestId());
			this.refreshTheQuestList();
		}
    }
    
    @FXML
    private void updateConflictNameDescription() throws SQLException {
    	this.theManageQuestsControl.getConflict().SetConflictName(storyConflictNameTextField.getText());
    	this.theManageQuestsControl.getConflict().SetConflictDescription(storyConflictDescriptionTextArea.getText());
    	this.theManageQuestsControl.updateTheConflict();
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Story Conflict Update");
		alert.setHeaderText("Information update");
		alert.setContentText("The name and description for story conflict containing these quests has been updated");
		alert.showAndWait();
    }
    
    @FXML
    private void editQuest(ActionEvent event) throws IOException, SQLException {
		if (questTableView.getSelectionModel().getSelectedItem() != null) {
			int theSelectedItemIndex = theManageQuestsControl.getExistingQuestList().indexOf(questTableView.getSelectionModel().getSelectedItem());
			String theSelectedItemArcRole = theManageQuestsControl.getExistingQuestList().get(theSelectedItemIndex).GetQuestArcType();
			switch (questTableView.getSelectionModel().getSelectedItem().GetQuestArcType()) {
				case "calling":
					this.createEditQuestWindow(event, theSelectedItemIndex, "EditQuestCalling", theSelectedItemArcRole);
					break;
				case "leaving":
					this.createEditQuestWindow(event, theSelectedItemIndex, "EditQuestLeaving", theSelectedItemArcRole);
					break;
				case "obstacle":
					this.createEditQuestWindow(event, theSelectedItemIndex, "EditQuestObstacle", theSelectedItemArcRole);
					break;
				case "insight":
					this.createEditQuestWindow(event, theSelectedItemIndex, "EditQuestInsight", theSelectedItemArcRole);
					break;
				case "henchman":
					this.createEditQuestWindow(event, theSelectedItemIndex, "EditQuestHenchman", theSelectedItemArcRole);
					break;
				case "monster":
					this.createEditQuestWindow(event, theSelectedItemIndex, "EditQuestMonster", theSelectedItemArcRole);
					break;
				case "meeting mentor":
					this.createEditQuestWindow(event, theSelectedItemIndex, "EditQuestMentor", theSelectedItemArcRole);
					break;
				case "obtain elixir":
					this.createEditQuestWindow(event, theSelectedItemIndex, "EditQuestObtainElixir", theSelectedItemArcRole);
					break;
				case "return elixir":
					this.createEditQuestWindow(event, theSelectedItemIndex, "EditQuestReturnWithElixir", theSelectedItemArcRole);
					break;
				case "return new wisdom":
					this.createEditQuestWindow(event, theSelectedItemIndex, "EditQuestReturnWithWisdom", theSelectedItemArcRole);
					break;
				case "return and reward":
					this.createEditQuestWindow(event, theSelectedItemIndex, "EditQuestReturnAndReward", theSelectedItemArcRole);
					break;
				case "custom":
					this.createEditQuestWindow(event, theSelectedItemIndex, "EditQuestCustom", theSelectedItemArcRole);
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
    
    private void createEditQuestWindow(ActionEvent event, int questIdToEdit, String fxmlFileName, String questArcRole) throws IOException, SQLException {
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader(App.class.getResource(fxmlFileName + ".fxml"));
        loader.setController(new EditQuestsViewControl(this, this.theMainDashboardViewControl.GetDBConnection(), questIdToEdit, questArcRole));
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
    	theManageQuestsControl.createQuestTemplateList();
    	theManageQuestsControl.UpdateTheQuestArrayList();
    	this.refreshTheQuestList();
    }
    
    public void refreshTheQuestList() {
		storyConflictNameTextField.setText(this.theManageQuestsControl.getConflict().GetConflictName());
		storyConflictDescriptionTextArea.setText(this.theManageQuestsControl.getConflict().GetConflictDescription());
		questTableView.getItems().clear();
		questTableView.getItems().addAll(theManageQuestsControl.GetObservableTheQuestList());
		questTableView.refresh();
    }
    
    /**
     * These update methods will be refactored into one when we don't have to build temp data
     * @throws SQLException 
     */
    public void updateQuestList() throws SQLException {
    	theManageQuestsControl.UpdateTheQuestArrayList();
		questTableView.getItems().clear();
		questTableView.getItems().addAll(theManageQuestsControl.GetObservableTheQuestList());
    }
	
	@FXML
	private void handleQuestChainsBackButton() throws SQLException {
		theMainDashboardViewControl.SetMainDashboardStage("manageQuestChains");
	}
}
