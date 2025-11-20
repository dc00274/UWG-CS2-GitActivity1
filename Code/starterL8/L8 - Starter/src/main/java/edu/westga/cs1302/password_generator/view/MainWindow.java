package edu.westga.cs1302.password_generator.view;

import edu.westga.cs1302.password_generator.viewmodel.ViewModel;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/** Codebehind for the MainWindow of the Application.
 * 
 * @author CS 1302
 * @version Fall 2025
 */
public class MainWindow {

    @FXML private CheckBox mustIncludeDigits;
    @FXML private CheckBox mustIncludeLowerCaseLetters;
    @FXML private CheckBox mustIncludeUpperCaseLetters;
    @FXML private TextField minimumLength;
    @FXML private ListView<String> outputList;
    @FXML private Label errorTextLabel;
    @FXML private Button generatePasswordButton;
    
    private ViewModel vm;
	
    @FXML
    void initialize() {
    	this.minimumLength.textProperty().addListener((observable, oldValue, newValue) -> {
    		if (!newValue.matches("^\\d*$")) {
    			this.minimumLength.setText(oldValue);
    			this.vm.getErrorText().setValue("Minimum length must be numeric");
    		} else {
    				this.vm.getErrorText().setValue("");
    			}
    	});
    	this.vm = new ViewModel();
    	this.vm.getRequireDigits().bind(this.mustIncludeDigits.selectedProperty());
    	this.vm.getRequireLowercase().bind(this.mustIncludeLowerCaseLetters.selectedProperty());
    	this.vm.getRequireUppercase().bind(this.mustIncludeUpperCaseLetters.selectedProperty());
    	this.minimumLength.setText(this.vm.getMinimumLength().getValue());
    	this.vm.getMinimumLength().bind(this.minimumLength.textProperty());
    	this.outputList.itemsProperty().bind(this.vm.getPasswordList());
    	this.errorTextLabel.textProperty().bind(this.vm.getErrorText());
    	String password = this.vm.getPassword().getValue();
    	this.outputList.getItems().add(password);
    	this.generatePasswordButton.setOnAction(
    			(event) -> { 
    				this.vm.generatePassword();
    	
    			} 
    	);
    }
  }

