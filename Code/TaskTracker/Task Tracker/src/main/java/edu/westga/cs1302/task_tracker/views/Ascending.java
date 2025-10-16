package edu.westga.cs1302.task_tracker.views;

import java.util.Comparator;

import edu.westga.cs1302.task_tracker.model.Task;

// TODO: Auto-generated Javadoc
/**
 * The Class Ascending.
 * @author Dillan
 * 
 * Compares Tasks based on priority lower priority coming first
 * @version 1
 */
public class Ascending implements Comparator<Task> {

	/**
	 * Compare.
	 *
	 * @param t1 the t 1
	 * @param t2 the t 2
	 * @return the int
	 */
	@Override
	public int compare(Task t1, Task t2) {
		return t1.getPriority().compareTo(t2.getPriority());
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
