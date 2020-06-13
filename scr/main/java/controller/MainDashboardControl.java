package controller;

import model.Player;

public class MainDashboardControl {
	private Player theAdminPlayer;
	private LoginViewControl theLoginViewControl;
	private MainDashboardViewControl theMainDashboardViewControl;
	
	public MainDashboardControl(Player theAdminPlayer, LoginViewControl theLoginViewControl) {
		this.theAdminPlayer = theAdminPlayer;
		this.theLoginViewControl = theLoginViewControl;
	}
	
	public void SetMainDashboardViewControl(MainDashboardViewControl theMainDashboardViewControl) {
		this.theMainDashboardViewControl = theMainDashboardViewControl;
	}
	
	public void LogOut() {
		theAdminPlayer = null;
	}
	
	public void ResetLoginView() {
		theLoginViewControl.ShowLoginStage();
	}
}
