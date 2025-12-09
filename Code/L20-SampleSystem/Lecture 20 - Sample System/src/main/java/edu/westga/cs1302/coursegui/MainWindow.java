package edu.westga.cs1302.coursegui;

import edu.westga.cs1302.coursegui.model.CollectionItem;
import edu.westga.cs1302.coursegui.viewmodel.CollectionViewModel;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;

public class MainWindow {
	    @FXML private TextField collectionName;
	    @FXML private ListView<CollectionItem> collectionListView;
	    @FXML private Button addCollection;
	    @FXML private Button removeCollection;
	    @FXML private MenuItem removeMenuItem;
	
	 private final CollectionViewModel vm = new CollectionViewModel();
	 
	 @FXML
	    public void initialize() {
	        collectionName.textProperty().bindBidirectional(vm.newCollectionNameProperty());
	        collectionListView.setItems(vm.getCollections());
	        vm.selectedCollectionProperty().bind(collectionListView.getSelectionModel().selectedItemProperty());
	        addCollection.disableProperty().bind(vm.newCollectionNameProperty().isEmpty());
	        removeCollection.disableProperty().bind(vm.selectedCollectionProperty().isNull());
	        removeMenuItem.disableProperty().bind(vm.selectedCollectionProperty().isNull());
	       
	}

}
