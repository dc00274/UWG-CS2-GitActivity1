package edu.westga.cs1302.task_tracker.model.ascending_name;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.task_tracker.model.AscendingName;
import edu.westga.cs1302.task_tracker.model.Task;

class TestCompare {

	@Test
    void testO1IsNull() {
        @SuppressWarnings("unused")
		Task o1 = new Task("Alan", "desc", Task.TaskPriority.HIGH);
        Task o2 = new Task("Ben", "desc", Task.TaskPriority.HIGH);
        AscendingName ascending = new AscendingName();

        assertThrows(IllegalArgumentException.class, ()->{ascending.compare(null, o2);});
    }

    @Test
    void testO2IsNull() {
        Task o1 = new Task("Alan", "desc", Task.TaskPriority.HIGH);
        @SuppressWarnings("unused")
		Task o2 = new Task("Ben", "desc", Task.TaskPriority.HIGH);
        AscendingName ascending = new AscendingName();

        assertThrows(IllegalArgumentException.class, ()->{ascending.compare(o1, null);});
    }

    @Test
    void testO1BeforeO2() {
        Task o1 = new Task("Alan", "desc", Task.TaskPriority.HIGH);
        Task o2 = new Task("Ben", "desc", Task.TaskPriority.HIGH);
        AscendingName ascending = new AscendingName();

        int result = ascending.compare(o1, o2);
        assertTrue(result < 0);
    }

    @Test
    void testO1AfterO2() {
        Task o1 = new Task("Charlie", "desc", Task.TaskPriority.HIGH);
        Task o2 = new Task("Ben", "desc", Task.TaskPriority.HIGH);
        AscendingName ascending = new AscendingName();

        int result = ascending.compare(o1, o2);
        assertTrue(result > 0);
    }

    @Test
    void testO1EqualsO2() {
        Task o1 = new Task("Dillan", "desc", Task.TaskPriority.HIGH);
        Task o2 = new Task("Dillan", "desc", Task.TaskPriority.LOW);
        AscendingName ascending = new AscendingName();

        int result = ascending.compare(o1, o2);
        assertEquals(0, result);
	}

}
