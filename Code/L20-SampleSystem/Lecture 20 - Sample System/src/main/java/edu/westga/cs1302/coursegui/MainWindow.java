package edu.westga.cs1302.coursegui;

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
	 
	 @FXML
	    public void initialize() {
	        collectionName.textProperty().bindBidirectional(vm.comicTitleProperty());
	        issueField.textProperty().bindBidirectional(vm.issueNumberProperty(), new NumberStringConverter());
	        
	        addComicButton.disableProperty().bind(Bindings.or(vm.comicTitleProperty().isEmpty(), vm.issueNumberProperty().isEqualTo(0)));
	        removeComicButton.disableProperty().bind(vm.selectedComicProperty().isNull());
            
	        addComicButton.setOnAction(e -> launchAddComicWindow());
	        removeComicButton.setOnAction(e -> removeComicFromCollection());
	        
	        collectionListView.setItems(vm.getCollections());
	        collectionListView.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
	            if (newSelection != null) {
	                vm.setSelectedCollection(newSelection);
	                comicListView.setItems(vm.getComicsInSelectedCollection());
	            }
	        });
	 }
	 
	 private void removeComicFromCollection() {
	        if (!vm.removeSelectedComic()) {
	            showError("Failed to remove comic.");
	        }
	    }
	 
	 private void launchAddComicWindow() {
	        AddComic newWindow = new AddComic();
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

