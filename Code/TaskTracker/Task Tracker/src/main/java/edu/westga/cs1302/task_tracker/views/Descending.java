package edu.westga.cs1302.task_tracker.views;

import java.util.Comparator;

import edu.westga.cs1302.task_tracker.model.Task;

/**
 * The Class Descending.
 * @author Dillan
 * 
 * Compares Tasks based on priority higher priority coming first
 * @version 1
 */
public class Descending implements Comparator<Task> {

	@Override
	public int compare(Task t1, Task t2) {
		return t2.getPriority().compareTo(t1.getPriority());
	}
	
	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "Ascending Low to High";
	}
}
