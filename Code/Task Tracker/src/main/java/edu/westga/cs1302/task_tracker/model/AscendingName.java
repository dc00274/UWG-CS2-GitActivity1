package edu.westga.cs1302.task_tracker.model;

import java.util.Comparator;


public class AscendingName implements Comparator<Task> {

	/** Returns a value indicating ordering of the two tasks based 
	 * on Ascending name.
	 * 
	 * @precondition o1 != null && o2 != null
	 * @postcondition none
	 * 
	 * @param o1 the first task to compare
	 * @param o2 the second task to compare
	 * 
	 * @return o1 compared to o2
	 * 
	 */
	public int compare(Task o1, Task o2) {
		if (o1 == null) {
			throw new IllegalArgumentException("o1 must not be null");
		}
		if (o2 == null) {
			throw new IllegalArgumentException("o2 must not be null");
		}
		return o1.getName().compareTo(o2.getName());
	}
	
	@Override
	public String toString() {
		return "Ascending Name A-Z";
	}
}

