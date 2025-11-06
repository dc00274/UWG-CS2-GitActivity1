package edu.westga.cs1302.task_tracker.model;

import java.util.ArrayList;
import java.util.List;


public class ContainerTask extends Task {
  
 /** The sub task. */
 private List<Task> subTask;
 
 /**
  * Instantiates a new container task.
  *
  * @param name the name
  * @param description the description
  * @param priority the priority
  */
 public ContainerTask(String name, String description, TaskPriority priority) {
	 super(name, description, priority);
	 this.subTask = new ArrayList<>();
 }
 
  /**
   * Adds the task.
   *
   * @param subTask the sub task
   * @return the container task
   */
  @Override
  public ContainerTask addTask(Task subTask) {
	  if (subTask == null) {
			throw new IllegalArgumentException("description must not be null");
		}
	  this.subTask.add(subTask);
	  return this;
  }
  
  /**
   * Gets the sub task.
   *
   * @return the sub task
   */
  @Override
  public List<Task> getSubTask() {
	  return this.subTask;
  }
  
  /**
   * To string.
   *
   * @return the string
   */
  @Override
  public String toString() {
	  return super.getName() + "(+)";
  }
}
