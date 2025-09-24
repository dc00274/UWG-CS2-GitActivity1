package edu.westga.cs1302.javafx_sample_starter.views;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * Controller class for drawing various things to our canvas window.
 * 
 * @author CS 1302
 * @version Fall 2025
 */
public class MainWindow {
    
	@FXML
	private  ComboBox<String> comboBox;
	
	@FXML
	private TextArea textArea;
	
	@FXML
	private ListView<String> listView;
	
	@FXML
	private Button button;
	
	@FXML
	private TextField textField;
	
	
	
    /**
     * Perform any needed initialization of UI components and underlying objects.
     */
    public void initialize() {
    	
    }
}
