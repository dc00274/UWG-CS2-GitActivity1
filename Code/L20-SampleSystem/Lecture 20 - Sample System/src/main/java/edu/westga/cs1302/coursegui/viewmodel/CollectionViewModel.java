package edu.westga.cs1302.coursegui.viewmodel;

import edu.westga.cs1302.coursegui.model.CollectionItem;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class CollectionViewModel {
	private final StringProperty collectionName = new SimpleStringProperty("");
	 private final ObservableList<CollectionItem> collections = FXCollections.observableArrayList();
	 private final ObjectProperty<CollectionItem> selectedCollection = new SimpleObjectProperty<>(null);
	 
	 
	 public StringProperty newCollectionNameProperty() {
	        return collectionName;
	    }

	    public ObservableList<CollectionItem> getCollections() {
	        return collections;
	    }

	    public ObjectProperty<CollectionItem> selectedCollectionProperty() {
	        return selectedCollection;
	    }
	    
	    public boolean addCollection() {
	        String name = collectionName.get().trim();

	        if (name.isEmpty())
	            return false;

	        
	        boolean exists = collections.stream()
	                .anyMatch(c -> c.getName().equalsIgnoreCase(name));

	        if (exists)
	            return false;

	        collections.add(new CollectionItem(name));
	        collectionName.set(""); 
	        return true;
	    }
	    
	    public boolean removeSelectedCollection() {
	        CollectionItem selected = selectedCollection.get();

	        if (selected == null)
	            return false;

	        collections.remove(selected);
	        selectedCollection.set(null);
	        return true;
	    }
}
