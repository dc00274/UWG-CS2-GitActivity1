package edu.westga.cs1302.coursegui.model;

public class CollectionItem {
	private final String name;
	
	
	public CollectionItem(String name) {
        if (name == null || name.isBlank())
            throw new IllegalArgumentException("Collection name cannot be empty.");
        this.name = getName();
    }
	
	public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
