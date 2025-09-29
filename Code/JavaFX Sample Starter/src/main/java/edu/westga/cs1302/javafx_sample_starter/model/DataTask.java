package edu.westga.cs1302.javafx_sample_starter.model;

public class DataTask {
	private String name;
	private String description;
	private String priority;

	/**
	 * Creates a new Task.
	 *
	 * @param name        the name of the task
	 * @param description the description of the task
	 * @param priority    the priority of the task
	 */
	public DataTask(String name, String description, String priority) {
		if (name == null || name.isBlank()) {
			throw new IllegalArgumentException("Task name cannot be null or empty.");
		}
		if (priority == null || priority.isBlank()) {
			throw new IllegalArgumentException("Priority cannot be null or empty.");
		}

		this.name = name;
		this.description = description;
		this.priority = priority;
	}

	/**
	 * Gets the name of the task.
	 *
	 * @return the task name
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Gets the description of the task.
	 *
	 * @return the task description
	 */
	public String getDescription() {
		return this.description;
	}

	/**
	 * Gets the priority of the task.
	 *
	 * @return the task priority
	 */
	public String getPriority() {
		return this.priority;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}

}
