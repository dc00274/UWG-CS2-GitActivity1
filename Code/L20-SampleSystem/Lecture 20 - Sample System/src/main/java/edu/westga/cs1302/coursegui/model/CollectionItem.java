package edu.westga.cs1302.coursegui.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class CollectionItem {
	private final String name;
	private final ObservableList<Comic> comics;
	
	public CollectionItem(String name) {
        if (name == null || name.isBlank())
            throw new IllegalArgumentException("Collection name cannot be empty.");
        this.name = getName();
        this.comics = FXCollections.observableArrayList();
    }
	
	public String getName() {
        return name;
    }
	
	public ObservableList<Comic> getComics(){
		return comics;
	}
    
	public void addComic(Comic comic) {
		if(!comics.contains(comic)) {
			comics.add(comic);
		}
	}
	
	public void removeComic(Comic comic) {
		comics.remove(comic);
	}
	
	
    @Override
    public String toString() {
        return name;
    }
}
