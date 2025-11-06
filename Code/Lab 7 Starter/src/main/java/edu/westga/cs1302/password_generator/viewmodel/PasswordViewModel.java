package edu.westga.cs1302.password_generator.viewmodel;

import edu.westga.cs1302.password_generator.model.PasswordGenerator;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class PasswordViewModel {
	private final PasswordGenerator generator = null;
	
	private final IntegerProperty minimumLength = new SimpleIntegerProperty(1);
	private final BooleanProperty mustIncludeDigits = new SimpleBooleanProperty(false);
	private final BooleanProperty mustIncludeLowerCaseLetters = new SimpleBooleanProperty(false);
	private final BooleanProperty mustIncludeUpperCaseLetters = new SimpleBooleanProperty(false);
	private final StringProperty generatedPassword = new SimpleStringProperty("");
	
    private void bindProperties() {
        minimumLength.addListener((obs, oldVal, newVal) -> {
            try {
                generator.setMinimumLength(newVal.intValue());
            } catch (IllegalArgumentException e) {
                minimumLength.set(oldVal.intValue()); 
            }
        });

        this.mustIncludeDigits.addListener((obs, oldVal, newVal) ->
                this.generator.setMustHaveAtLeastOneDigit(newVal));

         this.mustIncludeLowerCaseLetters.addListener((obs, oldVal, newVal) ->
                this.generator.setMustHaveAtLeastOneLowerCaseLetter(newVal));

        this.mustIncludeUpperCaseLetters.addListener((obs, oldVal, newVal) ->
                this.generator.setMustHaveAtLeastOneUpperCaseLetter(newVal));
    }
}
