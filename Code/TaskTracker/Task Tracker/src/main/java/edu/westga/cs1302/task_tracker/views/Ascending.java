package edu.westga.cs1302.task_tracker.views;

import java.util.Comparator;

import edu.westga.cs1302.task_tracker.model.Task;

/**
 * The Class Ascending.
 * @author Dillan
 * 
 * Compares Tasks based on priority lower priority coming first
 * @version 1
 */
public class Ascending implements Comparator<Task> {

	@Override
	public int compare(Task t1, Task t2) {
		return t1.getPriority().compareTo(t2.getPriority());
	}

}
