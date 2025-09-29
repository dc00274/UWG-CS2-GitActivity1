package edu.westga.cs1302.javafx_sample_starter.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.javafx_sample_starter.model.DataTask;
import edu.westga.cs1302.javafx_sample_starter.model.TaskUtility;

class TestTaskUtility {

	@Test
    void testPriorityCountWithNullList() {
        int count = TaskUtility.priorityCount("Medium", null);
        assertEquals(0, count);
	}
	
	@Test
    void testPriorityCountWithMatchingTasks() {
        List<DataTask> tasks = Arrays.asList(
            new DataTask("Homework", "Books", "High"),
            new DataTask("Videogames", "Fortnite", "Low"),
            new DataTask("Homework", "Math", "High")
        );
        int count = TaskUtility.priorityCount("High", tasks);
        assertEquals(2, count);
    }
	@Test
    void testPriorityCountWithNoMatches() {
        List<DataTask> tasks = Arrays.asList(
            new DataTask("Homework", "Books", "High"),
            new DataTask("Videogames", "Forrnite", "Low")
        );
        int count = TaskUtility.priorityCount("Medium", tasks);
        assertEquals(0, count);
    }

}
