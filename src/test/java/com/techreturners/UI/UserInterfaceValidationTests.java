package com.techreturners.UI;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserInterfaceValidationTests {

    /*
    Name Validations
     */
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


    /*
    Plateau Coordinates Validations
     */
    @Test
    public void plateauCoordinatesMustBeTwoDigits(){
        assertTrue(UserInterfaceValidation.isValidPlateauCoordinates("12"));
        assertTrue(UserInterfaceValidation.isValidPlateauCoordinates("23"));
        assertTrue(UserInterfaceValidation.isValidPlateauCoordinates("2 3"));
        assertTrue(UserInterfaceValidation.isValidPlateauCoordinates(" 9 1  "));
    }

    @Test
    public void plateauCoordinatesCannotBeOneDigit(){
        assertFalse(UserInterfaceValidation.isValidPlateauCoordinates("1"));
        assertFalse(UserInterfaceValidation.isValidPlateauCoordinates("2 "));
        assertFalse(UserInterfaceValidation.isValidPlateauCoordinates(" 2"));
    }

    @Test
    public void plateauCoordinatesCannotContainLetters(){
        assertFalse(UserInterfaceValidation.isValidPlateauCoordinates("XX"));
        assertFalse(UserInterfaceValidation.isValidPlateauCoordinates("2X"));
        assertFalse(UserInterfaceValidation.isValidPlateauCoordinates("X2"));
        assertFalse(UserInterfaceValidation.isValidPlateauCoordinates("2A2"));
        assertFalse(UserInterfaceValidation.isValidPlateauCoordinates("22S"));
    }

    @Test
    public void plateauCoordinatesCannotBeBlank(){
        assertFalse(UserInterfaceValidation.isValidPlateauCoordinates(" "));
        assertFalse(UserInterfaceValidation.isValidPlateauCoordinates(""));
    }



    /*
    Planet Selection Validations - Currently just ONE - TODO - update when/if more planets added
     */
    @Test
    public void planetSelectionMustBeANumber(){
        assertTrue(UserInterfaceValidation.isValidPlanetSelection("1"));
    }
    @Test
    public void planetSelectionMustBeWithinSelectionsAvailable(){
        assertFalse(UserInterfaceValidation.isValidPlanetSelection("2"));
    }
}
