package edu.westga.cs1302.coursegui.viewmodel;

import java.util.Collection;

import edu.westga.cs1302.coursegui.model.CollectionItem;
import edu.westga.cs1302.coursegui.model.Comic;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class CollectionViewModel {
	private final StringProperty collectionName = new SimpleStringProperty("");
	 private final ObservableList<CollectionItem> collections = FXCollections.observableArrayList();
	 private final ObjectProperty<CollectionItem> selectedCollection = new SimpleObjectProperty<>(null);
	 private final StringProperty comicTitle = new SimpleStringProperty(" ");
	 private final IntegerProperty issueNumber = new SimpleIntegerProperty(0);
	 
	 public StringProperty newCollectionNameProperty() {
	        return collectionName;
	    }

	    public ObservableList<CollectionItem> getCollections() {
	        return collections;
	    }

	    public ObjectProperty<CollectionItem> selectedCollectionProperty() {
	        return selectedCollection;
	    }
	    public StringProperty comicTitleProperty() {
	    	return  comicTitle;
	    }
	    
	    public IntegerProperty issueNumberProperty() {
	    	return issueNumber;
	    }
	    
	    public boolean addCollection() {
	        if(selectedCollection.get() == null) {
	        	return false;
	        }

	        String title = comicTitle.get();
	        int comicIssueNumber = issueNumber.get();
	        if (title.isEmpty() || issueNumber <= 0) {
	            return false;
	        }

	        Comic newComic = new Comic(title, issueNumber);
	        selectedCollection.get().addComic(newComic);
	        comicsInSelectedCollection.setAll(selectedCollection.get().getComics());
            comicTitle.set(" ");
            issueNumber.set(0);
	        return true;
	    }
	    
	    public boolean removeSelectedCollection() {
	    	if (selectedCollection.get() == null || selectedComic.get() == null) {
	            return false;
	        }

	        selectedCollection.get().removeComic(selectedComic.get());
	        comicsInSelectedCollection.setAll(selectedCollection.get().getComics());
	        selectedComic.set(null);

	        return true;
	    }
	    
	    public void setSelectedCollection(Collection collection) {
	        selectedCollection.set(collection);
	        comicsInSelectedCollection.setAll(collection.getComics());
	    }
	    
}
