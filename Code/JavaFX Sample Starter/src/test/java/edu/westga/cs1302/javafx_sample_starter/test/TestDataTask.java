package edu.westga.cs1302.javafx_sample_starter.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.javafx_sample_starter.model.DataTask;

class TestDataTask {

	@Test
	void testvalidConstructor() {
		DataTask task = new DataTask("Yellow","Yellow is amazing","High");
		assertEquals("Yellow", task.getName());
        assertEquals("Yellow is amazing", task.getDescription());
        assertEquals("High", task.getPriority());
	}
	@Test
	void testConstructorInvalidName() {
		assertThrows(IllegalArgumentException.class, () -> {
            new DataTask("", "Yellow is amazing", "High");
        });
	}
	@Test
    void testConstructorInvalidPriority() {
        assertThrows(IllegalArgumentException.class, () -> {
            new DataTask("Yellow", "Yellow is amazing", "");
        });
	}
	
	@Test
    void testSetDescription() {
        DataTask task = new DataTask("Red", "Red is okay", "Medium");
        task.setDescription("Red is okay");
        assertEquals("Red is okay", task.getDescription());
    }
	
	

}
