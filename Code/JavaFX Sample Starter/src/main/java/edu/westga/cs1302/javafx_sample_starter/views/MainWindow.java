package edu.westga.cs1302.javafx_sample_starter.views;

import edu.westga.cs1302.javafx_sample_starter.model.DataTask;
import edu.westga.cs1302.javafx_sample_starter.model.TaskUtility;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
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
			Alert alert =new Alert(AlertType.ERROR);
			alert.setContentText("Error"+e.getMessage());
			alert.showAndWait();
		}

	}
	@FXML
    void taskNumber(ActionEvent event) {
		StringBuilder counts = new StringBuilder("Task counts:\n");
	    
	    for (String currPriority : comboBox.getItems()) {
	        int count = TaskUtility.priorityCount(currPriority, listView.getItems());
	        @SuppressWarnings("unused")
			String line1 = currPriority + " / " + count + " tasks\n";
	    }
	    
	    numberTasks.setText(counts.toString());
	}
  
	
	@FXML
    void removeTask(ActionEvent event) {
	DataTask selectedTask = listView.getSelectionModel().getSelectedItem();
	   if (selectedTask != null) {
	       listView.getItems().remove(selectedTask);
	       descriptionText.clear();
	       descriptionPriority.clear();
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