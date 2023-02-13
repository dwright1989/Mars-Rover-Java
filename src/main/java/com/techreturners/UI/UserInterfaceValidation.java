package com.techreturners.UI;

import java.util.regex.Pattern;

public class UserInterfaceValidation {

    public static boolean isValidPlateauCoordinates(String values){
        values = values.replaceAll("\\s+","");
        return Pattern.matches("^(0|[1-9][0-9]*)$", values) && values.length() == 2;
    }

    public static boolean isValidName(String name){
        return Pattern.matches("[A-Za-z]*", name) && name.length()>=1;
    }

    public static boolean isValidPlanetSelection(String number){
        return Pattern.matches("^(0|[1-9][0-9]*)$", number) && number.equals("1");
    }
}
