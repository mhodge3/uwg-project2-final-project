package com.cs6920.control.logic_control;

import java.sql.SQLException;

import com.cs6920.control.view_control.ManageTemplateTheQuestViewControl;

public class QuestEditCallingControl extends QuestEditAbstractControl {
	private ManageTemplateTheQuestViewControl theManageTemplateTheQuestViewControl;
	
	public QuestEditCallingControl(ManageTemplateTheQuestViewControl theManageTemplateTheQuestViewControl, int questIdToEdit) throws SQLException {
		super(theManageTemplateTheQuestViewControl.GetTheMainDashboardViewControl().GetDBConnection(), questIdToEdit);
		this.theManageTemplateTheQuestViewControl = theManageTemplateTheQuestViewControl;
	}
	
	public void updateQuestName(String newQuestName) throws SQLException {
		theManageTemplateTheQuestViewControl.GetTheManageTemplateTheQuestControl().getExistingQuestList().get(super.getQuestIdToEdit() - 1).SetQuestName(newQuestName);
	}
	
	public void updateQuestDescription(String newQuestDescription) throws SQLException {
		theManageTemplateTheQuestViewControl.GetTheManageTemplateTheQuestControl().getExistingQuestList().get(super.getQuestIdToEdit() - 1).SetQuestDescription(newQuestDescription);
	}
	
	public void updateGiverNPC(int npcId) throws SQLException {
		theManageTemplateTheQuestViewControl.GetTheManageTemplateTheQuestControl().getExistingQuestList().get(super.getQuestIdToEdit() - 1).SetQuestGiverNpcId(npcId);
	}
	
	public void updateQuestGiverDialog(String newQuestGiverDialog) throws SQLException {
		theManageTemplateTheQuestViewControl.GetTheManageTemplateTheQuestControl().getExistingQuestList().get(super.getQuestIdToEdit() - 1).SetQuestGiverDialog(newQuestGiverDialog);
	}
	
	public void updateQuestReceiverDialog(String newQuestReceiverDialog) throws SQLException {
		theManageTemplateTheQuestViewControl.GetTheManageTemplateTheQuestControl().getExistingQuestList().get(super.getQuestIdToEdit() - 1).SetQuestReceiverDialog(newQuestReceiverDialog);
	}
	
	public void updateReceiverNPC(int npcId) throws SQLException {
		theManageTemplateTheQuestViewControl.GetTheManageTemplateTheQuestControl().getExistingQuestList().get(super.getQuestIdToEdit() - 1).SetQuestReceiverNpcId(npcId);
	}
	
	public int getQuestGiverNpcId() throws SQLException {
		return theManageTemplateTheQuestViewControl.GetTheManageTemplateTheQuestControl().getExistingQuestList().get(super.getQuestIdToEdit() - 1).GetQuestGiverNpcId();
	}
	
	public int getQuestReceiverNpcId() throws SQLException {
		return theManageTemplateTheQuestViewControl.GetTheManageTemplateTheQuestControl().getExistingQuestList().get(super.getQuestIdToEdit() - 1).GetQuestReceiverNpcId();
	}
	
	public String getQuestName() throws SQLException {
		return theManageTemplateTheQuestViewControl.GetTheManageTemplateTheQuestControl().getExistingQuestList().get(super.getQuestIdToEdit() - 1).GetQuestName();
	}
	
	public String getQuestDescription() throws SQLException {
		return theManageTemplateTheQuestViewControl.GetTheManageTemplateTheQuestControl().getExistingQuestList().get(super.getQuestIdToEdit() - 1).GetQuestDescription();
	}
	
	public String getGiverDialog() throws SQLException {
		return theManageTemplateTheQuestViewControl.GetTheManageTemplateTheQuestControl().getExistingQuestList().get(super.getQuestIdToEdit() - 1).GetQuesGiverDialog();
	}
	
	public String getReceiverDialog() throws SQLException {
		return theManageTemplateTheQuestViewControl.GetTheManageTemplateTheQuestControl().getExistingQuestList().get(super.getQuestIdToEdit() - 1).GetQuesReceiverDialog();
	}
	
	public void refreshQuestDisplay() throws SQLException {
		theManageTemplateTheQuestViewControl.updateQuestList();
	}
}