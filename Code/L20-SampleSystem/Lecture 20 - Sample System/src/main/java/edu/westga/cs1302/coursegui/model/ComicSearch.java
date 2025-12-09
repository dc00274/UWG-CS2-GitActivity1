package edu.westga.cs1302.coursegui.model;

import java.util.HashMap;
import java.util.Map;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * The Class ComicSearch.
 * @version 2025
 * @author Dillan
 */
public class ComicSearch {
	private final Map<String, Map<Integer, Comic>> comicList = new HashMap<>();
	
	/**
	 * Instantiates a new comic search.
	 */
	public ComicSearch(){
		this.addComic(new Comic("Batman", 1));
        this.addComic(new Comic("Super Man", 1));
        this.addComic(new Comic("Spider-Man", 1));
	}
	
	/**
	 * Adds the comic.
	 *
	 * @param comic the comic
	 */
	public void addComic(Comic comic) {
         Map<Integer, Comic> issueMap = this.comicList.get(comic.getTitle());
            if (issueMap == null) {
            issueMap = new HashMap<>();
            this.comicList.put(comic.getTitle(), issueMap);
        }
        issueMap.put(comic.getIssueNumber(), comic);  
    }
	
	/**
	 * Search comic.
	 *
	 * @param title the title
	 * @param issueNumber the issue number
	 * @return the comic
	 */
	public Comic searchComic(String title, int issueNumber) {
        Map<Integer, Comic> issueMap = this.comicList.get(title);
        if (issueMap != null) {
            return issueMap.get(issueNumber);
        }
        return null;
	}
	
	 /**
 	 * Gets the every comics.
 	 *
 	 * @return the every comics
 	 */
 	public ObservableList<Comic> getEveryComics() {
	        ObservableList<Comic> allComics = FXCollections.observableArrayList();
	        this.comicList.forEach((title, issueMap) -> allComics.addAll(issueMap.values()));
	        return allComics;
	    }
}
