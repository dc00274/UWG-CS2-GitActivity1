package edu.westga.cs1302.coursegui;

import edu.westga.cs1302.coursegui.model.CollectionItem;
import edu.westga.cs1302.coursegui.viewmodel.CollectionViewModel;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;

public class MainWindow {
	    @FXML private TextField collectionName;
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
	        collectionName.textProperty().bindBidirectional(vm.newCollectionNameProperty());
	        collectionListView.setItems(vm.getCollections());
	        vm.selectedCollectionProperty().bind(collectionListView.getSelectionModel().selectedItemProperty());
	        addCollection.disableProperty().bind(vm.newCollectionNameProperty().isEmpty());
	        removeCollection.disableProperty().bind(vm.selectedCollectionProperty().isNull());
	        removeMenuItem.disableProperty().bind(vm.selectedCollectionProperty().isNull());
	       
	 addCollection.setOnAction(e -> {
         if (!vm.addCollection()) {
             showError("Could not add collection. Make sure name is valid and not a duplicate.");
         }
     });

     removeCollection.setOnAction(e -> {
         if (!vm.removeSelectedCollection()) {
             showError("No collection selected.");
         }
     });

     removeMenuItem.setOnAction(e -> {
         if (!vm.removeSelectedCollection()) {
             showError("No collection selected.");
         }
      });
     
           addComicButton.setOnAction(e -> showAddComicWindow());
           removeComicButton.setOnAction(e -> removeComic());
           removeComicMenuItem.setOnAction(e -> removeComic());
     
           removeCollection.disableProperty().bind(vm.selectedCollectionProperty().isNull());
           removeComicButton.disableProperty().bind(vm.selectedCollectionProperty().isNull().or(comicListView.getSelectionModel().selectedItemProperty().isNull()));
           removeComicMenuItem.disableProperty().bind(removeComicButton.disableProperty());
       }
	 
     private void showError(String message) {
         Alert alert = new Alert(Alert.AlertType.ERROR);
         alert.setTitle("Error");
         alert.setHeaderText(null);
         alert.setContentText(message);
         alert.showAndWait();
     }
 }

