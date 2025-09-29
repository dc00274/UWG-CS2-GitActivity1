package edu.westga.cs1302.javafx_sample_starter.views;

import edu.westga.cs1302.javafx_sample_starter.model.DataTask;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
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
	private ComboBox<String> comboBox;

	@FXML
	private TextArea textArea;
	
	@FXML
    private Label numberTasks;
	
	@FXML
	private ListView<DataTask> listView;
    
	@FXML
	private TextArea descriptionPriority;
	
	@FXML
	private TextField descriptionText;
	
	@FXML
    private Button displayNumber;
	
	@FXML
    private Button updateButton;
	
	@FXML
	private Button button;
	
	 @FXML
	 private Button removeButton;

	@FXML
	private TextField textField;

	@FXML
	void onSubmit(ActionEvent event) {
		String name = this.textField.getText();
		String description = this.textArea.getText();
		String priority = this.comboBox.getValue();
		try {
			DataTask task = new DataTask(name, description, priority);
			 this.listView.getItems().add(task);

		} catch (IllegalArgumentException e) {
			System.err.println("Error: " + e.getMessage());
		}

	}
	@FXML
    void taskNumber(ActionEvent event) {

    }
	
	@FXML
    void removeTask(ActionEvent event) {
	DataTask selectedTask = listView.getSelectionModel().getSelectedItem();
	   if (selectedTask != null) {
	       listView.getItems().remove(selectedTask);
	   }
    }
	
	@FXML
	void updateDescription(ActionEvent event) {
       DataTask selectedTask = listView.getSelectionModel().getSelectedItem();
        if(selectedTask != null) {
        	selectedTask.setDescription(descriptionPriority.getText());
        }
    }

	/**
	 * Perform any needed initialization of UI components and underlying objects.
	 */
	public void initialize() {
		comboBox.getItems().addAll("Red", "Blue", "Green");
		
		listView.getSelectionModel().selectedItemProperty().addListener((obs, oldTask, newTask) -> {
            if (newTask != null) {
                descriptionText.setText(newTask.getPriority());      
                descriptionPriority.setText(newTask.getDescription()); 
            } else {
                descriptionText.clear();
                descriptionPriority.clear();
            }
        });
	}
}