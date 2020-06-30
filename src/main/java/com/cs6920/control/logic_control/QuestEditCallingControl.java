package com.cs6920.control.logic_control;

import java.sql.SQLException;

import com.cs6920.control.view_control.ManageTemplateTheQuestViewControl;

public class QuestEditCallingControl extends QuestEditAbstractControl {
	private ManageTemplateTheQuestViewControl theManageTemplateTheQuestViewControl;
	private int questIdToEdit;
	
	public QuestEditCallingControl(ManageTemplateTheQuestViewControl theManageTemplateTheQuestViewControl, int questIdToEdit) throws SQLException {
		super(theManageTemplateTheQuestViewControl.GetTheMainDashboardViewControl().GetDBConnection());
		this.theManageTemplateTheQuestViewControl = theManageTemplateTheQuestViewControl;
		this.questIdToEdit = questIdToEdit;
	}
	
	public void updateQuestName(String newQuestName) throws SQLException {
		theManageTemplateTheQuestViewControl.GetTheManageTemplateTheQuestControl().getExistingQuestList().get(questIdToEdit - 1).SetQuestName(newQuestName);
	}
	
	public void updateQuestDescription(String newQuestDescription) throws SQLException {
		theManageTemplateTheQuestViewControl.GetTheManageTemplateTheQuestControl().getExistingQuestList().get(questIdToEdit - 1).SetQuestDescription(newQuestDescription);
	}
	
	public void updateGiverNPC(int npcId) throws SQLException {
		theManageTemplateTheQuestViewControl.GetTheManageTemplateTheQuestControl().getExistingQuestList().get(questIdToEdit - 1).SetQuestGiverNpcId(npcId);
	}
	
	public void updateReceiverNPC(int npcId) throws SQLException {
		theManageTemplateTheQuestViewControl.GetTheManageTemplateTheQuestControl().getExistingQuestList().get(questIdToEdit - 1).SetQuestReceiverNpcId(npcId);
	}
	
	public int getQuestGiverNpcId() throws SQLException {
		return theManageTemplateTheQuestViewControl.GetTheManageTemplateTheQuestControl().getExistingQuestList().get(questIdToEdit - 1).GetQuestGiverNpcId();
	}
	
	public int getQuestReceiverNpcId() throws SQLException {
		return theManageTemplateTheQuestViewControl.GetTheManageTemplateTheQuestControl().getExistingQuestList().get(questIdToEdit - 1).GetQuestReceiverNpcId();
	}
	
	public String getQuestName() throws SQLException {
		return theManageTemplateTheQuestViewControl.GetTheManageTemplateTheQuestControl().getExistingQuestList().get(questIdToEdit - 1).GetQuestName();
	}
	
	public String getQuestDescription() throws SQLException {
		return theManageTemplateTheQuestViewControl.GetTheManageTemplateTheQuestControl().getExistingQuestList().get(questIdToEdit - 1).GetQuestDescription();
	}
	
	public void refreshQuestDisplay() throws SQLException {
		theManageTemplateTheQuestViewControl.updateQuestList();
	}
}