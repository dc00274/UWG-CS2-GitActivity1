package edu.westga.cs1302.task_tracker.model;

public class Descending {
  
	
	public int compare(Task t1, Task t2) {
		return t2.getPriority().compareTo(t1.getPriority());
	}
}
