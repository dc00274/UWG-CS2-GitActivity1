package edu.westga.cs1302.task_tracker.model.container_task;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.task_tracker.model.ContainerTask;
import edu.westga.cs1302.task_tracker.model.Task;
import edu.westga.cs1302.task_tracker.model.Task.TaskPriority;

class TestConstructor {
	
	@Test
    void testAddNullTaskThrowsException() {
		ContainerTask container = new ContainerTask("Task", "Main description", TaskPriority.HIGH);
        Task sub = new Task("Sub", "Sub description", TaskPriority.MEDIUM);
        Task sub1 = new Task("Sub1", "Sub1 description", TaskPriority.LOW);
        assertThrows(IllegalArgumentException.class, () -> container.addTask(null));
    }

	@Test
    void testAddTaskAddsSubtask() {
		ContainerTask container = new ContainerTask("Task", "Main description", TaskPriority.HIGH);
        Task sub = new Task("Sub", "Sub description", TaskPriority.MEDIUM);
        Task sub1 = new Task("Sub1", "Sub1 description", TaskPriority.LOW);
        container.addTask(sub);
        assertTrue(container.getSubTask().contains(sub));
        assertEquals(1, container.getSubTask().size());
    }
	
	@Test
    void testAddMultipleSubtasks() {
		ContainerTask container = new ContainerTask("Task", "Main description", TaskPriority.HIGH);
        Task sub = new Task("Sub", "Sub description", TaskPriority.MEDIUM);
        Task sub1 = new Task("Sub1", "Sub1 description", TaskPriority.LOW);
        container.addTask(sub);
        container.addTask(sub1);
        assertEquals(2, container.getSubTask().size());
        assertTrue(container.getSubTask().contains(sub));
        assertTrue(container.getSubTask().contains(sub1));
    }
	
	

}
