package edu.westga.cs1302.lab5.persistence.student_data_persistence_manager;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

import java.nio.file.Files;
import java.nio.file.Paths;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.lab5.model.Student;
import edu.westga.cs1302.lab5.persistence.StudentDataPersistenceManager;

class TestSaveStudentData {

	@Test
    public void testSaveStudentData_nullInput_throwsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            StudentDataPersistenceManager.saveStudentData(null);
        });
    }

    @Test
    public void testSaveStudentData_emptyArray_createsEmptyFile() throws Exception {
        Student[] students = new Student[0];
        StudentDataPersistenceManager.saveStudentData(students);
        String fileContent = Files.readString(Paths.get(TEST_RUN));
        assertTrue(fileContent.isEmpty(), "File should be empty");
    }
    
    @Test
    public void testSaveStudentData_validStudents_writtenCorrectly() throws Exception {
        Student[] students = {
            new Student("Mandy", 100),
            new Student("Liam", 75)
        };
        StudentDataPersistenceManager.saveStudentData(students);
        String fileContent = Files.readString(Paths.get(TEST_RUN)).trim();
        assertEquals("Mandy,100\nBob,75", fileContent.replace("\r", ""));
    }
    
    private static final String TEST_RUN= "data.txt";


}
