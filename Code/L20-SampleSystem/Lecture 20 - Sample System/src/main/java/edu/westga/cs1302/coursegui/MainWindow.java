package edu.westga.cs1302.coursegui;

import java.util.Collection;
import javafx.util.converter.NumberStringConverter;
import edu.westga.cs1302.coursegui.model.CollectionItem;
import edu.westga.cs1302.coursegui.model.Comic;
import edu.westga.cs1302.coursegui.viewmodel.CollectionViewModel;
import javafx.beans.binding.Bindings;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;

/**
 * The Class MainWindow.
 * @version 2025
 * @author Dillan
 */
public class MainWindow {
	    @FXML private TextField collectionName;
	    @FXML private TextField issueField;
	    @FXML private ListView<CollectionItem> collectionListView;
	    @FXML private ListView<Comic> comicListView;
	    @FXML private Button addCollection;
	    @FXML private Button removeCollection;
	    @FXML private MenuItem removeMenuItem;
	    @FXML private Button addComicButton;
	    @FXML private Button removeComicButton;
	    @FXML private MenuItem removeComicMenuItem;
	
	 private final CollectionViewModel vm = new CollectionViewModel();
	 
	 /**
 	 * Initialize.
 	 */
 	@FXML
	    public void initialize() {
	        this.collectionName.textProperty().bindBidirectional(this.vm.comicTitleProperty());
	        this.issueField.textProperty().bindBidirectional(this.vm.issueNumberProperty(), new NumberStringConverter());
	        
	        this.addComicButton.disableProperty().bind(Bindings.or(this.vm.comicTitleProperty().isEmpty(), vm.issueNumberProperty().isEqualTo(0)));
	        this.removeComicButton.disableProperty().bind(this.vm.selectedComicProperty().isNull());
	        this.removeCollection.disableProperty().bind(this.vm.selectedCollectionProperty().isNull());
	        this.addCollection.setOnAction(e -> this.addNewCollection());
	        this.removeCollection.setOnAction(e -> this.removeSelectedCollection());
	        this.addComicButton.setOnAction(e -> this.launchAddComicWindow());
	        this.removeComicButton.setOnAction(e -> this.removeComicFromCollection());
	        
	        this.collectionListView.setItems(this.vm.getCollections());
	        this.collectionListView.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
	            if (newSelection != null) {
	                this.vm.setSelectedCollection(newSelection);
	                this.comicListView.setItems(this.vm.getComicsInSelectedCollection());
	            }
	        });
	 }
	 
 	private void addNewCollection() {
	        String collectionName = "New Collection"; 
	        CollectionItem newCollection = new CollectionItem(collectionName);
	        this.vm.addCollection(newCollection);
	    }
	 
	    private void removeSelectedCollection() {
	        CollectionItem selectedCollection = this.vm.selectedCollectionProperty().get();
	        if (selectedCollection != null) {
	            this.vm.removeCollection(selectedCollection);
	        }
	    }
	    
	 private void removeComicFromCollection() {
	        if (!this.vm.removeSelectedComic()) {
	            this.showError("Failed to remove comic.");
	        }
	    }
	 
	 private void launchAddComicWindow() {
	        AddComic newWindow = new AddComic(this.vm.selectedCollectionProperty().get());
	        newWindow.showWindow();
	    }
	 
     private void showError(String message) {
         Alert alert = new Alert(Alert.AlertType.ERROR);
         alert.setTitle("Error");
         alert.setHeaderText(null);
         alert.setContentText(message);
         alert.showAndWait();
     }
 }

