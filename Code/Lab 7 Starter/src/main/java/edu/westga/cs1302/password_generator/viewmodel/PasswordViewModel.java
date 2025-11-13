package edu.westga.cs1302.password_generator.viewmodel;

import java.util.function.BooleanSupplier;

import edu.westga.cs1302.password_generator.model.PasswordGenerator;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

// TODO: Auto-generated Javadoc
/**
 * The Class PasswordViewModel.
 * @version 2025
 * @author Dillan
 */
public class PasswordViewModel {
	
	private final PasswordGenerator generator = null;

	private final IntegerProperty minimumLength = new SimpleIntegerProperty(1);
	private final BooleanProperty mustIncludeDigits = new SimpleBooleanProperty(false);
	private final BooleanProperty mustIncludeLowerCaseLetters = new SimpleBooleanProperty(false);
	private final BooleanProperty mustIncludeUpperCaseLetters = new SimpleBooleanProperty(false);
	private final StringProperty generatedPassword = new SimpleStringProperty("");
	
    /**
     * Bind properties.
     */
    private void bindProperties() {
        this.minimumLength.addListener((obs, oldVal, newVal) -> {
            try {
                this.generator.setMinimumLength(newVal.intValue());
            } catch (IllegalArgumentException e) {
                this.minimumLength.set(oldVal.intValue()); 
            }
        });

        this.mustIncludeDigits.addListener((obs, oldVal, newVal) ->
                this.generator.setMustHaveAtLeastOneDigit(newVal));
        this.mustIncludeLowerCaseLetters.addListener((obs, oldVal, newVal) ->
                this.generator.setMustHaveAtLeastOneLowerCaseLetter(newVal));
        this.mustIncludeUpperCaseLetters.addListener((obs, oldVal, newVal) ->
                this.generator.setMustHaveAtLeastOneUpperCaseLetter(newVal));
    }
    
    /**
     * Generate password.
     */
    public void generatePassword() {
        String password = this.generator.generatePassword();
        this.generatedPassword.set(password);
    }
    
    /**
     * Minimum length property.
     *
     * @return the integer property
     */
    public IntegerProperty minimumLengthProperty() {
        return this.minimumLength;
    }
 
    /**
     * Must include digits property.
     *
     * @return the boolean property
     */
    public BooleanProperty mustIncludeDigitsProperty() {
        return this.mustIncludeDigits;
    }
 
    /**
     * Must include lower case letters property.
     *
     * @return the boolean property
     */
    public BooleanProperty mustIncludeLowerCaseLettersProperty() {
        return this.mustIncludeLowerCaseLetters;
    }

    /**
     * Must include upper case letters property.
     *
     * @return the boolean property
     */
    public BooleanProperty mustIncludeUpperCaseLettersProperty() {
        return this.mustIncludeUpperCaseLetters;
    }

    /**
     * Generated password property.
     *
     * @return the string property
     */
    public StringProperty generatedPasswordProperty() {
        return this.generatedPassword;
    }

}
