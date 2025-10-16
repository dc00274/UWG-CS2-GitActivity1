package edu.westga.cs1302.task_tracker.model.ascending;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.westga.cs1302.task_tracker.model.Task;
import edu.westga.cs1302.task_tracker.views.Ascending;

class TestCompare {

      
	@Test 
       void testOrderLowBeforeMid() {
		  Ascending ascending = new Ascending();
		  Task lowTask = new Task ("low 1", "low 2" ,Task.TaskPriority.LOW);
		  Task mediumTask =  new Task ("med 1", "med 2",Task.TaskPriority.MEDIUM);
		  assertFalse(ascending.compare(lowTask, mediumTask) < 0);
      }
      
     
	@Test 
      void testOrderMidBeforeHigh() {
		  Ascending ascending = new Ascending();
		  Task highTask = new Task ("high 1", "high 2", Task.TaskPriority.HIGH);
		  Task mediumTask =  new Task ("med 1", "med 2",Task.TaskPriority.MEDIUM);
		  assertFalse(ascending.compare(mediumTask, highTask) < 0);
     }
      
	@Test 
      void testOrderSamePriority() {
		  Ascending ascending = new Ascending();
		  Task lowTask = new Task ("low 1", "low 2" ,Task.TaskPriority.LOW);
		  Task lowTask2 = new Task ("low 3", "low 4" ,Task.TaskPriority.LOW);
		  assertEquals(0, ascending.compare(lowTask, lowTask2));
     }
      
      
	

}
