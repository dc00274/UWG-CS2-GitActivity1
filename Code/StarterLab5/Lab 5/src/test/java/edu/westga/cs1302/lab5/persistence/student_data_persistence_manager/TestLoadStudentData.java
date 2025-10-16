package edu.westga.cs1302.lab5.persistence.student_data_persistence_manager;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


import org.junit.jupiter.api.Test;

import edu.westga.cs1302.lab5.model.Student;
import edu.westga.cs1302.lab5.persistence.StudentDataPersistenceManager;

class TestLoadStudentData {

	
	
	@Test
    public void testLoadStudentData_fileDoesNotExist_throwsException() {
        assertThrows(FileNotFoundException.class, () -> {
            StudentDataPersistenceManager.loadStudentData();
        });
    }
	 @Test
	    public void testLoadStudentData_invalidFormat_throwsException() throws Exception {
	        Files.writeString(Paths.get(TEST_RUN), "Janine,60\n");
              assertThrows(IOException.class, () -> {
	            StudentDataPersistenceManager.loadStudentData();
	        });
	    }

	    @Test
	    public void testLoadStudentData_validFile_readsCorrectly() throws Exception {
	        Files.writeString(Paths.get(TEST_RUN), "Janine,90\nMArk,95\n");
             Student[] loaded = StudentDataPersistenceManager.loadStudentData();
             assertEquals(2, loaded.length);
	        assertEquals("Janine", loaded[0].getName());
	        assertEquals(90, loaded[0].getGrade());
	        assertEquals("Mark", loaded[1].getName());
	        assertEquals(85, loaded[1].getGrade());
	    }
	    private static final String TEST_RUN = "data.txt";
}
