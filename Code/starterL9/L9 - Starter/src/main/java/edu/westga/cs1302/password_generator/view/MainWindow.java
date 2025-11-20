package edu.westga.cs1302.password_generator.view;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import edu.westga.cs1302.password_generator.viewmodel.ViewModel;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;

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
    @FXML private Label errorTextLabel;
    @FXML private Label minLengthErrorText;
    @FXML private Button generatePasswordButton;
    @FXML private ListView<String> passwordHistory;
    
    private ViewModel vm;
    
    @FXML
    private void letSave() {
    	FileChooser fileChooser = new FileChooser();
    	fileChooser.setTitle("Password save");
    	File file = fileChooser.showOpenDialog(null);
    	fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("text Files", ".txt"));
    	
    	
    	try (FileWriter writer = new FileWriter(file)) {
            for (String entry : this.vm.getPasswordHistory()) {
                writer.write(entry);
            }
        } catch (IOException error) {
            this.errorTextLabel.setText("Error saving file: " + error.getMessage());
        }
    }
    
    
    @FXML
    public void  aboutPage() {
    	Alert alert = new Alert(Alert.AlertType.INFORMATION);
    	alert.setTitle("Createing a Password generator");
    	alert.setContentText("Dillan Clayton");
    	alert.showAndWait();
    }
    
    @FXML
    private void closePage() {
    	((Node)(this.errorTextLabel)).getScene().getWindow().hide();
    }
    
    @FXML
    void initialize() {
    	this.vm = new ViewModel();
    	this.vm.getRequireDigits().bind(this.mustIncludeDigits.selectedProperty());
    	this.vm.getRequireLowercase().bind(this.mustIncludeLowerCaseLetters.selectedProperty());
    	this.vm.getRequireUppercase().bind(this.mustIncludeUpperCaseLetters.selectedProperty());
    	this.minimumLength.setText(this.vm.getMinimumLength().getValue());
    	this.vm.getMinimumLength().bind(this.minimumLength.textProperty());
    	
    	this.errorTextLabel.textProperty().bind(this.vm.getErrorText());
    	this.passwordHistory.setItems(this.vm.getPasswordHistory());
    	
    	generatePasswordButton.setDisable(true);
    	
    	this.minimumLength.textProperty().addListener((observable, newValue, oldValue) -> {
    		this.minLengthErrorText.setVisible(!newValue.matches("\\d+") || Integer.parseInt(newValue) == 0);
    	});
    	
    	this.generatePasswordButton.setOnAction(
    			(event) -> { 
    				this.vm.generatePassword();
    			} 
    	);
    }
}
