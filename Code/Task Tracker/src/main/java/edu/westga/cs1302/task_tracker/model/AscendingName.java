package edu.westga.cs1302.task_tracker.model;

import java.util.Comparator;

public class AscendingName implements Comparator<Task>{
	
	public int compare(Task o1, Task o2) {
		if (o1 == null) {
			throw new IllegalArgumentException("o1 must not be null");
		}
		if (o2 == null) {
			throw new IllegalArgumentException("o2 must not be null");
		}
		return o1.getName().compareTo(o2.getName());
	}
}

