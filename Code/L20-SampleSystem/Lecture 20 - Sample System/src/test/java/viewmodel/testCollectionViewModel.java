package viewmodel;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.coursegui.model.CollectionItem;
import edu.westga.cs1302.coursegui.model.Comic;
import edu.westga.cs1302.coursegui.viewmodel.CollectionViewModel;

class testCollectionViewModel {

	private CollectionViewModel viewModel;
    private CollectionItem collection;
    
    @Test
    public void testAddComic() {
    	collection = new CollectionItem("Test ");
        viewModel = new CollectionViewModel();
        viewModel.setSelectedCollection(collection);
        Comic comic = new Comic("Batman", 1);
        viewModel.comicTitleProperty().set("Batman");
        viewModel.issueNumberProperty().set(1);
        boolean correct = viewModel.addComic2(); 
        assertTrue(correct, "Comic should be added successfully.");
        assertTrue(collection.getComics().contains(comic), "Collection should contain the added comic.");
    } 
    @Test
    public void testInvalidComicTitle() {
    	collection = new CollectionItem("Test ");
        viewModel = new CollectionViewModel();
        viewModel.setSelectedCollection(collection);
        viewModel.comicTitleProperty().set("");  
        viewModel.issueNumberProperty().set(1);
        boolean correct = viewModel.addComic(); 
        assertFalse(correct, "Comic should not be added with an empty title.");
    }

    @Test
    public void testInvalidComicIssueNumber() {
    	collection = new CollectionItem("Test ");
        viewModel = new CollectionViewModel();
        viewModel.setSelectedCollection(collection);
        viewModel.comicTitleProperty().set("Batman");
        viewModel.issueNumberProperty().set(0);  
        boolean correct = viewModel.addComic();
        assertFalse(correct, "Comic should not be added with an a wrong issue number.");
    }
    
    @Test
    public void testRemoveComic() {
    	collection = new CollectionItem("Test ");
        viewModel = new CollectionViewModel();
        viewModel.setSelectedCollection(collection);
        Comic comic = new Comic("Batman", 1);
        collection.addComic(comic); 
        viewModel.selectedComicProperty().set(comic); 
        boolean correct = viewModel.removeSelectedComic(); 
        assertTrue(correct, "Comic should be removed successfully.");
        assertFalse(collection.getComics().contains(comic), "Collection should no longer contain the removed comic.");
    }
	}


