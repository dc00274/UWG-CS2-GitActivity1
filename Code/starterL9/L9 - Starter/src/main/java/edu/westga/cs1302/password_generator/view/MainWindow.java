package edu.westga.cs1302.password_generator.view;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import edu.westga.cs1302.password_generator.viewmodel.ViewModel;
import javafx.event.ActionEvent;
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
    private void onSave(ActionEvent event) {
    	FileChooser fileChooser = new FileChooser();
    	fileChooser.setTitle("Password save");
    	fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Text File", ".* txt"));
    	File file = fileChooser.showOpenDialog(null);
    	if (file != null) {
    		return;
    	}
    	
    	try (FileWriter writer = new FileWriter(file)) {
            for (String entry : this.vm.getPasswordHistory()) {
                writer.write(entry);
            }
        } catch (IOException error) {
            this.errorTextLabel.setText("Error saving file: " + error.getMessage());
        }
    }
    
     @FXML
    private void  onAbout(ActionEvent event) {
    	Alert alert = new Alert(Alert.AlertType.INFORMATION);
    	alert.setTitle("Creating a Password generator");
    	alert.setContentText("Author: Dillan Clayton");
    	alert.showAndWait();
    }
    
    @FXML
    private void onClose(ActionEvent event) {
    	((Node) this.generatePasswordButton).getScene().getWindow().hide();
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
    	
    	this.minLengthErrorText.visibleProperty().bind(this.vm.validPasswordProperty().not());
    	this.generatePasswordButton.disableProperty().bind(this.vm.validPasswordProperty().not());
    	
    	this.generatePasswordButton.setOnAction(
    			(event) -> { 
    				this.vm.generatePassword();
    			} 
    	);
    }
}
