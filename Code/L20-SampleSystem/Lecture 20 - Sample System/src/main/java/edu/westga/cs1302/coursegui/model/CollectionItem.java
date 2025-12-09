package edu.westga.cs1302.coursegui.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * The Class CollectionItem.
 *
 * @author Dillan
 * @version 2025
 */
public class CollectionItem {
	private final String name;
	private final ObservableList<Comic> comics;
	
	/**
	 * Instantiates a new collection item.
	 *
	 * @param name the name
	 */
	public CollectionItem(String name) {
        if (name == null || name.isBlank()) {
			throw new IllegalArgumentException("Collection name cannot be empty.");
		}
        this.name = name;
        this.comics = FXCollections.observableArrayList();
    }
	
	/**
	 * Instantiates a new collection item.
	 *
	 * 
	 * @return the name
	 */
	public String getName() {
        return this.name;
    }
	
	/**
	 * Instantiates a new collection item.
	 *
	 * @param 
	 * @return the comics
	 */
	public ObservableList<Comic> getComics() {
		return this.comics;
	}
	
	/**
	 * Instantiates a new collection item.
	 *
	 * @param comic the comic
	 */
	public void addComic(Comic comic) {
		if (!this.comics.contains(comic)) {
			this.comics.add(comic);
		}
	}
	
	/**
	 * Instantiates a new collection item.
	 *
	 * @param comic the comic
	 */
	public void removeComic(Comic comic) {
		this.comics.remove(comic);
	}
	
    @Override
    public String toString() {
        return this.name;
    }
}
