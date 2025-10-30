package edu.westga.cs1302.task_tracker.model.descending_name;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.task_tracker.model.DescendingName;
import edu.westga.cs1302.task_tracker.model.Task;

class TestCompare {

	@Test
    void testO1IsNull() {
        @SuppressWarnings("unused")
		Task o1 = new Task("Alan", "desc", Task.TaskPriority.HIGH);
        Task o2 = new Task("Ben", "desc", Task.TaskPriority.HIGH);
        DescendingName descending = new DescendingName();

        assertThrows(IllegalArgumentException.class, ()->{descending.compare(null, o2);});
    }

    @Test
    void testO2IsNull() {
        Task o1 = new Task("Alan", "desc", Task.TaskPriority.HIGH);
        @SuppressWarnings("unused")
		Task o2 = new Task("Ben", "desc", Task.TaskPriority.HIGH);
        DescendingName descending = new DescendingName();

        assertThrows(IllegalArgumentException.class, ()->{descending.compare(o1, null);});
    }

    @Test
    void testO1BeforeO2() {
        Task o1 = new Task("Alan", "desc", Task.TaskPriority.HIGH);
        Task o2 = new Task("Ben", "desc", Task.TaskPriority.HIGH);
        DescendingName descending = new DescendingName();

        int result = descending.compare(o1, o2);
        assertTrue(result > 0); // reversed order
    }

    @Test
    void testO1AfterO2() {
        Task o1 = new Task("Charlie", "desc", Task.TaskPriority.HIGH);
        Task o2 = new Task("Ben", "desc", Task.TaskPriority.HIGH);
        DescendingName descending = new DescendingName();

        int result = descending.compare(o1, o2);
        assertTrue(result < 0); 
    }

    @Test
    void testO1EqualsO2() {
        Task o1 = new Task("Dillan", "desc", Task.TaskPriority.HIGH);
        Task o2 = new Task("Dillan", "desc", Task.TaskPriority.LOW);
        DescendingName descending = new DescendingName();

        int result = descending.compare(o1, o2);
        assertEquals(0, result);
    }

}
