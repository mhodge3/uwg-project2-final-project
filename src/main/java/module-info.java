module story_mapper {   
	exports com.cs6920.model;
	exports com.cs6920.DAL;
	exports com.cs6920.story_mapper;
	exports com.cs6920.control.logic_control;
	exports com.cs6920.view; 
    requires javafx.baseEmpty;

    requires javafx.base;

    requires javafx.fxmlEmpty;

    requires javafx.fxml;

    requires javafx.controlsEmpty;

    requires javafx.controls;

    requires javafx.graphicsEmpty;

    requires javafx.graphics;
    
    requires java.sql;

    opens com.cs6920.view to javafx.fxml;
    opens com.cs6920.control.logic_control to javafx.fxml;
    opens com.cs6920.story_mapper to javafx.fxml;
    opens com.cs6920.DAL to java.sql;
}
