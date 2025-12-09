package edu.westga.cs1302.coursegui;

import java.util.Collection;

import edu.westga.cs1302.coursegui.viewmodel.CollectionViewModel;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddComic {
	@FXML private TextField titleField;
    @FXML private TextField issueField;
    @FXML private Button addButton;
    @FXML private Button cancelButton;

    private final CollectionViewModel viewModel;

    public AddComic(Collection selectedCollection) {
        this.viewModel = viewModel;
    }

    @FXML
    public void initialize() {
        titleField.textProperty().bindBidirectional(viewModel.comicTitleProperty());
        issueField.textProperty().bindBidirectional(viewModel.issueNumberProperty(), new NumberStringConverter());
        addButton.setOnAction(e -> addComic());
        cancelButton.setOnAction(e -> closeWindow());
    }

    private void addComic() {
        if(!viewModel.addCollection()) {
        	showError("Failed to add comic. Title and Issue Number should be valid.");
        } else {
            closeWindow();
        }
     }

    private void closeWindow() {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }

    private void showError(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public void showWindow() {
    	Stage stage = new Stage();
        stage.setScene(new Scene(getClass().getResource("AddComic.fxml")));
        stage.setTitle("Add Comic");
        stage.show();
    }
}





