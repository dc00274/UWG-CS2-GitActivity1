package edu.westga.cs1302.task_tracker.model;

import java.util.Comparator;

public class DescendingName implements Comparator<Task>{
	
	
	public int compare(Task o1, Task o2) {
		if (o1 == null) {
			throw new IllegalArgumentException("o1 must not be null");
		}
		if (o2 == null) {
			throw new IllegalArgumentException("o2 must not be null");
		}
		return o2.getName().compareTo(o1.getName());
	}
	
	@Override
	public String toString() {
		return "Ascending Name Z-A";
	}
}
