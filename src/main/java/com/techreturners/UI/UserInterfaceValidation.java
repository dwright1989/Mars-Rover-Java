package com.techreturners.UI;

import com.techreturners.Enums.Direction;
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

    public static boolean isValidVehiclesValues(String values, Object[][] grid){
        boolean isValid = false;
        values = values.replaceAll("\\s+","");
        if(values.length()==3){
            int positionX = Integer.parseInt(values.substring(0, 1));
            int positionY = Integer.parseInt(values.substring(1, 2));
            int xLength = grid.length;
            int yLength = grid[0].length;
            boolean firstSectionValid = positionX <= xLength && positionY <= yLength;
            if(firstSectionValid){
                String dir = values.substring(2);
                dir =  dir.toUpperCase();
                try{
                    Direction direction = Direction.valueOf(dir);
                    isValid = true;
                }catch(IllegalArgumentException ignored){

                }
            }
        }
        return isValid;
    }

    public static boolean isValidMovementValues(String values){
        values = values.replaceAll("\\s+","");
        if(values.isEmpty()){
            return false;
        }
        values = values.toUpperCase();
        return  Pattern.matches("[LRM]*", values);
    }

}
