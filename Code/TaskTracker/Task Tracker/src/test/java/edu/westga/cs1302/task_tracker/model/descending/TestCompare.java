package edu.westga.cs1302.task_tracker.model.descending;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.task_tracker.model.Task;
import edu.westga.cs1302.task_tracker.views.Ascending;

class TestCompare {

	@Test 
    void testOrderMidbeforeLow() {
		  Ascending ascending = new Ascending();
		  Task lowTask = new Task ("low 1", "low 2" ,Task.TaskPriority.LOW);
		  Task mediumTask =  new Task ("med 1", "med 2",Task.TaskPriority.MEDIUM);
		  assertFalse(ascending.compare(lowTask, mediumTask) < 0);
   }
   
  
	@Test 
   void testOrderHighBeforeMid() {
		  Ascending ascending = new Ascending();
		  Task highTask = new Task ("high 1", "high 2", Task.TaskPriority.HIGH);
		  Task mediumTask =  new Task ("med 1", "med 2",Task.TaskPriority.MEDIUM);
		  assertFalse(ascending.compare(mediumTask, highTask) < 0);
  }
   
	@Test 
   void testOrderSamePriority() {
		  Ascending ascending = new Ascending();
		  Task highTask = new Task ("high 1", "high 2", Task.TaskPriority.HIGH);
		  Task highTask2 = new Task ("high 3", "high 4", Task.TaskPriority.HIGH);
		  assertEquals(0, ascending.compare(highTask, highTask2));
  }

}
