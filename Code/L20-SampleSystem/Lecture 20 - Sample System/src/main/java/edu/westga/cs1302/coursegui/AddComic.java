package edu.westga.cs1302.coursegui;

import java.util.Collection;
import javafx.util.converter.NumberStringConverter;
import edu.westga.cs1302.coursegui.model.CollectionItem;
import edu.westga.cs1302.coursegui.viewmodel.CollectionViewModel;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

// TODO: Auto-generated Javadoc
/**
 * The Class AddComic.
 * @version 2025
 * @author Dillan
 */
public class AddComic {
	
	/** The title field. */
	@FXML private TextField titleField;
    
    /** The issue field. */
    @FXML private TextField issueField;
    
    /** The add button. */
    @FXML private Button addButton;
    
    /** The cancel button. */
    @FXML private Button cancelButton;

    /** The view model. */
    private CollectionViewModel viewModel;

    /**
     * Instantiates a new adds the comic.
     *
     * @param selectedCollection the selected collection
     */
    public AddComic(CollectionItem selectedCollection) {
        this.viewModel = new CollectionViewModel();
        this.viewModel.setSelectedCollection(selectedCollection);
    }

    /**
     * Initialize.
     */
    @FXML
    public void initialize() {
        this.titleField.textProperty().bindBidirectional(this.viewModel.comicTitleProperty());
        this.issueField.textProperty().bindBidirectional(this.viewModel.issueNumberProperty(), new NumberStringConverter());
        this.addButton.setOnAction(e -> this.addComic());
        this.cancelButton.setOnAction(e -> this.closeWindow());
    }

    /**
     * Adds the comic.
     */
    private void addComic() {
        if (!this.viewModel.addCollection()) {
        	this.showError("Failure to add comic. Title and Issue Number should be valid.");
        } else {
            this.closeWindow();
        }
     }

    /**
     * Close window.
     */
    private void closeWindow() {
        Stage stage = (Stage) this.cancelButton.getScene().getWindow();
        stage.close();
    }

    /**
     * Show error.
     *
     * @param message the message
     */
    private void showError(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    /**
     * Show window.
     */
    public void showWindow() {
    	try {
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("AddComic.fxml"));
        AnchorPane root = loader.load();
        AddComic controller = loader.getController();
        controller.setViewModel(this.viewModel); 
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Add Comic");
        stage.show();
    	 } catch (Exception e) {
             e.printStackTrace();
         }
    }
    /**
     * Sets the view model.
     *
     * @param viewModel the new view model
     */
    private void setViewModel(CollectionViewModel viewModel) {
        this.viewModel = viewModel;
    }
}





