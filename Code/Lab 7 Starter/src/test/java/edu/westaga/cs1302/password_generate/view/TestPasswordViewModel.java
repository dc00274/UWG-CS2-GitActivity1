package edu.westaga.cs1302.password_generate.view;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.password_generator.model.PasswordGenerator;
import edu.westga.cs1302.password_generator.viewmodel.PasswordViewModel;

class TestPasswordViewModel {

	@Test
	void testValues() {
		PasswordGenerator generator = new PasswordGenerator(1);
		generator.setMinimumLength(3);
		generator.setMustHaveAtLeastOneUpperCaseLetter(false);
		generator.setMustHaveAtLeastOneLowerCaseLetter(true);
		generator.setMustHaveAtLeastOneDigit(true);
		
		String result = generator.generatePassword();
		
		assertTrue(3 <= result.length(), "checking length of generated password");
	}

	@Test
	void testProperty() {
		PasswordGenerator generator = new PasswordGenerator(1);
		generator.setMinimumLength(3);
		generator.setMustHaveAtLeastOneUpperCaseLetter(true);
		generator.setMustHaveAtLeastOneLowerCaseLetter(false);
		generator.setMustHaveAtLeastOneDigit(true);
		
		String result = generator.generatePassword();
		
		assertTrue(3 <= result.length(), "checking length of generated password");
	}

	

}
