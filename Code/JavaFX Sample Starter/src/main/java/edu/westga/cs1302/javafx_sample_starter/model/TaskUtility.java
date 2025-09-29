package edu.westga.cs1302.javafx_sample_starter.model;

import java.util.List;

public class TaskUtility {
  
	/**
     * Counts how many tasks have the given priority.
     *
     * @param priority the priority to match
     * @param tasks    the list of tasks
     */
	public static int priorityCount(String priority, List<DataTask>tasks) {
		if (priority == null || tasks == null) {
            return 0;
        }
		int count = 0;
        for (DataTask task : tasks) {
            if (priority.equals(task.getPriority())) {
                count++;
            }
        }
        return count;
    }
  
}
