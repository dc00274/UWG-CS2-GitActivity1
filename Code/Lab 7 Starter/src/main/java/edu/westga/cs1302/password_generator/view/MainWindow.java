package edu.westga.cs1302.password_generator.view;

import java.util.Random;

import edu.westga.cs1302.password_generator.model.PasswordGenerator;
import edu.westga.cs1302.password_generator.viewmodel.PasswordViewModel;
import javafx.beans.binding.Bindings;
import javafx.beans.value.WritableBooleanValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.util.converter.FormatStringConverter;

/** Codebehind for the MainWindow of the Application.
 * 
 * @author CS 1302
 * @version Fall 2024
 */
public class MainWindow {

    @FXML private CheckBox mustIncludeDigits;
    @FXML private CheckBox mustIncludeLowerCaseLetters;
    @FXML private CheckBox mustIncludeUpperCaseLetters;
    @FXML private TextField minimumLength;
    @FXML private TextArea output;
    
    private PasswordGenerator generator;
	private PasswordViewModel viewModel;

    @FXML
    void generatePassword(ActionEvent event) {
    	WritableBooleanValue generatedPassword;
		try {
    	this.generator.setMustHaveAtLeastOneDigit(this.mustIncludeDigits.isSelected());
    	this.generator.setMustHaveAtLeastOneLowerCaseLetter(this.mustIncludeLowerCaseLetters.isSelected());
    	this.generator.setMustHaveAtLeastOneUpperCaseLetter(this.mustIncludeUpperCaseLetters.isSelected());
    	
    	Boolean password = this.generator.generatePassword();
    	
    	generatedPassword.set(password);
    	
    	this.output.setText(password);
    	 catch (IllegalArgumentException e) {
    	        generatedPassword.set("Error: " + e.getMessage());
    	    }
    }

    @FXML
    void initialize() {
        assert this.mustIncludeDigits != null : "fx:id=\"mustIncludeDigits\" was not injected: check your FXML file 'MainWindow.fxml'.";
        assert this.mustIncludeLowerCaseLetters != null : "fx:id=\"mustIncludeLowerCaseLetters\" was not injected: check your FXML file 'MainWindow.fxml'.";
        assert this.mustIncludeUpperCaseLetters != null : "fx:id=\"mustIncludeUpperCaseLetters\" was not injected: check your FXML file 'MainWindow.fxml'.";
        assert this.minimumLength != null : "fx:id=\"minimumLength\" was not injected: check your FXML file 'MainWindow.fxml'.";
        assert this.output != null : "fx:id=\"output\" was not injected: check your FXML file 'MainWindow.fxml'.";
         
        this.viewModel = new PasswordViewModel();
        this.mustIncludeDigits.selectedProperty().bindBidirectional(viewModel.mustIncludeDigitsProperty());
        this.mustIncludeLowerCaseLetters.selectedProperty().bindBidirectional(viewModel.mustIncludeLowerCaseLettersProperty());
        this.mustIncludeUpperCaseLetters.selectedProperty().bindBidirectional(viewModel.mustIncludeUpperCaseLettersProperty());
        Bindings.bindBidirectional(minimumLength.textProperty(),viewModel.minimumLengthProperty(),new FormatStringConverter(null));
        output.textProperty().bind(viewModel.generatedPasswordProperty());
    }
}
