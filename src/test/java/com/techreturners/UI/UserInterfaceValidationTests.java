package com.techreturners.UI;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserInterfaceValidationTests {

    @Test
    public void canEnterAnyLengthOfName(){
        assertTrue(UserInterfaceValidation.isValidName("D"));
        assertTrue(UserInterfaceValidation.isValidName("Debbie"));
    }

    @Test
    public void nameCannotBeEmpty(){
        assertFalse(UserInterfaceValidation.isValidName(""));
        assertFalse(UserInterfaceValidation.isValidName("    "));
    }

    @Test
    public void nameCannotBeNumberOrSpecialCharacters(){
        assertFalse(UserInterfaceValidation.isValidName("1"));
        assertFalse(UserInterfaceValidation.isValidName("1232323"));
    }

    @Test
    public void nameCannotContainNumberOrSpecialCharacters(){
        assertFalse(UserInterfaceValidation.isValidName("Deb1bie"));
        assertFalse(UserInterfaceValidation.isValidName("D£bbie"));
    }
}
