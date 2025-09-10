package edu.westga.cs1302.lab3.views;


/**
 * Controller class for drawing various things to our canvas window.
 * 
 * @author CS 1302
 * @version Fall 2025
 */

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class MainWindow {
	 @FXML
	    private TextField amount;

	    @FXML
	    private TextField name;

	    @FXML
	    private TextArea output;

	    @FXML
	    void addItem(ActionEvent event) {
	    }

    /**
     * Perform any needed initialization of UI components and underlying objects.
     */
    public void initialize() {
    	
    }
}
