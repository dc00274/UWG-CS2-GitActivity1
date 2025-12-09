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

// TODO: Auto-generated Javadoc
/**
 * The Class CollectionViewModel.
 *
 * @author Dillan
 * @version 2025
 */
public class CollectionViewModel {
	
	/** The comics in selected collection. */
	private final ObservableList<Comic> comicsInSelectedCollection = FXCollections.observableArrayList();
    
    /** The selected comic. */
    private final ObjectProperty<Comic> selectedComic = new SimpleObjectProperty<>(null);
    
    /** The selected collection. */
    private final ObjectProperty<CollectionItem> selectedCollection = new SimpleObjectProperty<>(null);
	 
 	/** The comic title. */
 	private final StringProperty comicTitle = new SimpleStringProperty(" ");
	 
 	/** The issue number. */
 	private final IntegerProperty issueNumber = new SimpleIntegerProperty(0);
	 
 	/** The collections. */
 	private final ObservableList<CollectionItem> collections = FXCollections.observableArrayList();
	 
	 /**
 	 * Gets the comics in selected collection.
 	 *
 	 * @return the comics in selected collection
 	 */
 	public ObservableList<Comic> getComicsInSelectedCollection() {
	        return this.comicsInSelectedCollection;
	    }

	    /**
    	 * Selected comic property.
    	 *
    	 * @return the object property
    	 */
    	public ObjectProperty<Comic> selectedComicProperty() {
	        return this.selectedComic;
	    }

	    /**
    	 * Selected collection property.
    	 *
    	 * @return the object property
    	 */
    	public ObjectProperty<CollectionItem> selectedCollectionProperty() {
	        return this.selectedCollection;
	    }
	    
    	/**
    	 * Comic title property.
    	 *
    	 * @return the string property
    	 */
    	public StringProperty comicTitleProperty() {
	    	return  this.comicTitle;
	    }
	    
	    /**
    	 * Issue number property.
    	 *
    	 * @return the integer property
    	 */
    	public IntegerProperty issueNumberProperty() {
	    	return this.issueNumber;
	    }
	    
	    /**
    	 * Gets the collections.
    	 *
    	 * @return the collections
    	 */
    	public ObservableList<CollectionItem> getCollections() {
	        return this.collections;
	    }
	    
	    /**
    	 * Adds the collection.
    	 *
    	 * @return true, if successful
    	 */
    	public boolean addCollection() {
	        if(this.selectedCollection.get() == null) {
	        	return false;
	        }

	        String title = this.comicTitle.get();
	        int comicIssueNumber = this.issueNumber.get();
	        
	        if (title.isEmpty() || comicIssueNumber <= 0) {
	            return false;
	        }

	        Comic newComic = new Comic(title, comicIssueNumber);
	        this.selectedCollection.get().addComic(newComic);
	        this.comicsInSelectedCollection.setAll(this.selectedCollection.get().getComics());
            this.comicTitle.set(" ");
            this.issueNumber.set(0);
	        return true;
	    }
	    
	    /**
    	 * Removes the selected comic.
    	 *
    	 * @return true, if successful
    	 */
    	public boolean removeSelectedComic() {
	        if (this.selectedCollection.get() == null || this.selectedComic.get() == null) {
	            return false;
	        }

	        this.selectedCollection.get().removeComic(this.selectedComic.get());
	        this.comicsInSelectedCollection.setAll(this.selectedCollection.get().getComics());
	        this.selectedComic.set(null);

	        return true;
	    }
	    
	    /**
    	 * Sets the selected collection.
    	 *
    	 * @param collection the new selected collection
    	 */
    	public void setSelectedCollection(CollectionItem collection) {
	        this.selectedCollection.set(collection);
	        this.comicsInSelectedCollection.setAll(collection.getComics());
	    }
	    
	    /**
    	 * Removes the collection.
    	 *
    	 * @param collection the collection
    	 */
    	public void removeCollection(CollectionItem collection) {
	        this.collections.remove(collection);
	    }
	    
	    /**
    	 * Adds the collection.
    	 *
    	 * @param collection the collection
    	 */
    	public void addCollection(CollectionItem collection) {
	        this.collections.add(collection);
	    }
	    
}
