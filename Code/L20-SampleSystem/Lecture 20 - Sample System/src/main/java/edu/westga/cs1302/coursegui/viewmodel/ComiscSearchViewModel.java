package edu.westga.cs1302.coursegui.viewmodel;

import edu.westga.cs1302.coursegui.model.Comic;
import edu.westga.cs1302.coursegui.model.ComicSearch;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * The Class ComicSearchViewModel.
 * @version 2025
 * @author Dillan
 */
public class ComiscSearchViewModel {
	private final ComicSearch model = new ComicSearch();

    private final StringProperty searchTitle = new SimpleStringProperty();
    private final StringProperty searchIssue = new SimpleStringProperty();

    /**
     * Search title property.
     *
     * @return the string property
     */
    public StringProperty searchTitleProperty() {
        return this.searchTitle;
    }

    /**
     * Search issue property.
     *
     * @return the string property
     */
    public StringProperty searchIssueProperty() {
        return this.searchIssue;
    }

    /**
     * Search comic.
     *
     * @return the comic
     */
    public Comic searchComic() {
    	try {
            String title = this.searchTitle.get();
            int issueNumber = Integer.parseInt(this.searchIssue.get());
            return this.model.searchComic(title, issueNumber);
        } catch (NumberFormatException e) {
            return null;  
        }
    }
    
    /**
     * Adds the comic.
     *
     * @param comic the comic
     */
    public void addComic(Comic comic) {
        this.model.addComic(comic);
    }
}
