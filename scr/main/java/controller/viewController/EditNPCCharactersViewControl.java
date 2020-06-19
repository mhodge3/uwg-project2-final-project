package controller.viewController;

import java.sql.SQLException;

import controller.logicController.EditNPCCharactersControl;
import controller.logicController.EditPlayersAndAdminsControl;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import model.NpcCharacter;

public class EditNPCCharactersViewControl {
	@FXML
	private TextField editNPCType;
	@FXML
	private TextField editNPCNameTextBox;
	@FXML
	private TextArea editNPCDescriptionTextBox;

	private MainDashboardViewControl theMainDashboardViewControl;
	private EditNPCCharactersControl theEditNPCCharactersControl;
    
	/**
	 * Constructor for this View Control
	 * @param theMainDashboardViewControl	Reference to the MainDashboard's View Control
	 */
    public EditNPCCharactersViewControl(MainDashboardViewControl theMainDashboardViewControl) {
    	this.theMainDashboardViewControl = theMainDashboardViewControl;
    	this.theEditNPCCharactersControl = new EditNPCCharactersControl(theMainDashboardViewControl.GetDBConnection());
    }
    
    public EditNPCCharactersControl GetEditNPCCharactersControl() {
    	return theEditNPCCharactersControl;
    }
    
    public void SetFormForSelectedNPC(NpcCharacter theNPCToEdit) {
    	editNPCType.setText(String.valueOf(theNPCToEdit.GetNpcType()));
    	editNPCNameTextBox.setText(theNPCToEdit.GetNpcName());
    	editNPCDescriptionTextBox.setText(theNPCToEdit.GetNpcDescprition());
    }
    
	@FXML
	private void handleNPCEditBackButton() throws SQLException {
		theMainDashboardViewControl.SetMainDashboardStage("manageNPCCharacters");
	}
    
	@FXML
	private void handleNPCEditSaveButton() throws SQLException {
		//TODO save logic
	}
}
