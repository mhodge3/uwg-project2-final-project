package controller;

import javafx.fxml.FXMLLoader;

public class MainDashboardViewControl {
	private FXMLLoader theFxmlLoader;
	private MainDashboardControl theMainDashbaordControl;
	/**
	 * Constructor for the MainDashbaordView Control with 1 argument
	 * @param theMainDashboardControl	the instance of a MainDashboard to communicate with
	 */
	public MainDashboardViewControl(MainDashboardControl theMainDashbaordControl) {
		this.theMainDashbaordControl = theMainDashbaordControl;
        theFxmlLoader = new FXMLLoader(getClass().getResource("/view/MainDashboardView.fxml"));
        theFxmlLoader.setController(this);
	} 
}
