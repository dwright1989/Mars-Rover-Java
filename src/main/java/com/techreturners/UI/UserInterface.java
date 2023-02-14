package com.techreturners.UI;

import com.techreturners.Enums.Colour;
import com.techreturners.Enums.Direction;
import com.techreturners.Enums.Unicode;
import com.techreturners.Planets.Planet;
import com.techreturners.Plateaus.Plateau;
import com.techreturners.Plateaus.RectanglePlateau;
import com.techreturners.User;
import com.techreturners.Vehicles.Vehicle;
import com.techreturners.Vehicles.Rover;

import java.util.Map;
import java.util.Scanner;
import static com.techreturners.UI.UserInterfaceValidation.*;

public class UserInterface {
    /*
    CURRENT UI ASSUMPTION
    - Planet is Mars
    - Plateau is Rectangle
    - Vehicle is rover
    - Planet can have ONE User
    - These have the background logic available to add further planets, plateaus and vehicles however UI must be updated to address this
     */
    User user;
    Planet mars;

    public UserInterface(){
        startApplication();
    }

    public void startApplication(){
        Scanner scanner = new Scanner(System.in);
        System.out.print(Colour.MAIN_TEXT_COLOUR);
        System.out.println("\nWelcome to the planet explorer.  What is your name?");
        String name = scanner.next();
        while(!isValidName(name)){
            System.out.println("Please enter a valid name");
            name = scanner.next();
        }
        System.out.println("Welcome " + name + " please select which planet you would like to explore.");
        System.out.println("[1] Mars");
        // Assuming the planet is Mars - TODO upgrade if/when more planets added
        String planetSelection = scanner.next();
        while(!isValidPlanetSelection(planetSelection)){
            System.out.println("Please enter a valid selection");
            planetSelection = scanner.next();
        }

        System.out.println("Welcome to Mars, " + name);
        mars = new Planet("Mars", -81, 3389.5, 3.721);
        user = new User(mars, name);

        Plateau plateau = createPlateauAndAddToPlanet(scanner);
        plateau.printGrid();
        System.out.print(Colour.MAIN_TEXT_COLOUR);
        System.out.print("Obstacles are represented by: ");
        System.out.print(Colour.ROCK);
        System.out.println(Unicode.ROCK);
        Vehicle vehicle = createVehicleAndAddToPlateau(scanner, plateau);
        plateau.addVehicle(vehicle);
        plateau.printGrid();
        int[] originalPosition = vehicle.getPosition();
        Direction originalDirection = vehicle.getDirection();
        System.out.print(Colour.MAIN_TEXT_COLOUR);
        System.out.println("Your vehicle has been placed on the grid");
        System.out.println("Your vehicle is represented as the following:");
        System.out.print("North: ");
        System.out.print(Colour.ARROW_COLOUR);
        System.out.println(Unicode.NORTH_ARROW);
        System.out.print(Colour.MAIN_TEXT_COLOUR);
        System.out.print("East:  ");
        System.out.print(Colour.ARROW_COLOUR);
        System.out.println(Unicode.EAST_ARROW);
        System.out.print(Colour.MAIN_TEXT_COLOUR);
        System.out.print("South: ");
        System.out.print(Colour.ARROW_COLOUR);
        System.out.println(Unicode.SOUTH_ARROW);
        System.out.print(Colour.MAIN_TEXT_COLOUR);
        System.out.print("West:  ");
        System.out.print(Colour.ARROW_COLOUR);
        System.out.println(Unicode.WEST_ARROW);
        System.out.print(Colour.MAIN_TEXT_COLOUR);
        boolean fullJourneyCompleted = getUserInputJourney(scanner, plateau, vehicle);
        if(!fullJourneyCompleted){
            System.out.println("Your vehicle has been moved as far in it's journey as possible without moving off the edge of the plateau or running into obstacles!");
        }else{
            System.out.println("Your vehicle has now completed it's journey.");
        }
        System.out.println("See the results below.");
        plateau.printGrid();
        System.out.println();
        System.out.print(Colour.SECONDARY_COLOUR);
        System.out.println("Your vehicle has been moved from: " + originalPosition[0] + "" + originalPosition[1] +  "" + originalDirection + " to: " + vehicle.getPosition()[0] + "" + vehicle.getPosition()[1] + "" + vehicle.getDirection());

        scanner.close();
    }



    /*
    Plateau generation
     */

    private Plateau createPlateauAndAddToPlanet(Scanner scanner){
        String plateauValues = getUserEnteredPlateauSize(scanner);
        return generatePlateauFromInput(plateauValues);
    }

    private String getUserEnteredPlateauSize(Scanner scanner) {
        System.out.print(Colour.MAIN_TEXT_COLOUR);
        System.out.println("Enter a plateau size in the form XY.  Where X is the length of the horizontal coordinates and Y is the length of the vertical coordinates. E.g. 54");
        String plateauValues = scanner.next();
        while(!isValidPlateauCoordinates(plateauValues)){
            System.out.println("Please enter a valid selection.  This must be two numerical values e.g. 54. The largest values you can enter are 99");
            plateauValues = scanner.next();
        }
        return plateauValues;
    }

    private Plateau generatePlateauFromInput(String plateauValues) {
        int xCoord = Character.digit(plateauValues.charAt(0),10);
        int yCoord = Character.digit(plateauValues.charAt(1),10);
        RectanglePlateau plateau = new RectanglePlateau(xCoord, yCoord); // TODO upgrade if/when different shapes of plateaus available
        mars.addPlateau(plateau);
        System.out.print(Colour.MAIN_TEXT_COLOUR);
        System.out.println("Thank you, " + user.getName() + "!  Have a look at the grid of the plateau below.");
        return plateau;
    }

      /*
    Vehicle generation
     */
    private Vehicle createVehicleAndAddToPlateau(Scanner scanner, Plateau plateau) {
       String vehicleValues = getUserEnteredVehicleValues(scanner, plateau);
       boolean validPosition = checkPositionWithinPlateau(vehicleValues, plateau );
       while(!validPosition){
           System.out.println("You cannot please your vehicle here.  Please try again.");
           vehicleValues = getUserEnteredVehicleValues(scanner, plateau);
           validPosition = checkPositionWithinPlateau(vehicleValues, plateau );
       }
        return generateVehicleFromUserInput(vehicleValues);
    }

    private boolean checkPositionWithinPlateau(String vehicleValues, Plateau plateau) {
        boolean isValid = false;
        int xPos = Integer.parseInt(vehicleValues.substring(0, 1));
        int yPos = Integer.parseInt(vehicleValues.substring(1, 2));
        int lengthOne = plateau.getGrid().length;
        int lengthTwo = plateau.getGrid()[0].length;
        if(xPos<lengthOne && xPos>=0 && yPos<lengthTwo && yPos>=0 && (plateau.getGrid()[xPos][yPos]==null)){
            isValid = true;
        }

        return isValid;
    }

    private String getUserEnteredVehicleValues(Scanner scanner, Plateau plateau) {
        System.out.print(Colour.MAIN_TEXT_COLOUR);
        System.out.println("Where would you like to place your vehicle?  Enter two coordinates followed by a direction e.g. 11N for x coordinate 1, y coordinate 1 and facing North.");
        String vehicleValues = scanner.next();
        while(!isValidVehiclesValues(vehicleValues, plateau.getGrid())){
            System.out.println("Please enter a valid selection.  Enter two coordinates followed by a direction e.g. 11N for x coordinate 1, y coordinate 1 and facing North.");
            vehicleValues = scanner.next();
        }
        return vehicleValues.replaceAll("\\s+","");
    }

    private Vehicle generateVehicleFromUserInput(String vehicleValues) {
        int xPos = Integer.parseInt(vehicleValues.substring(0, 1));
        int yPos = Integer.parseInt(vehicleValues.substring(1, 2));
        Direction dir = Direction.valueOf(vehicleValues.substring(2,3).toUpperCase());
        return new Rover(new int[]{xPos,yPos}, dir);
    }

    /*
    Vehicle movement
     */
    private boolean getUserInputJourney(Scanner scanner, Plateau plateau, Vehicle vehicle) {
        String movementValues = getUserEnteredMovementValues(scanner);
        Object[] results = plateau.moveVehicle(movementValues, vehicle);
        return (boolean) results[1];
    }

    private String getUserEnteredMovementValues(Scanner scanner) {
        System.out.print(Colour.MAIN_TEXT_COLOUR);
        System.out.println("Enter your journey for your vehicle");
        System.out.println("Valid moves include: ");
        System.out.print(Colour.SECONDARY_COLOUR);
        System.out.println("L - turn left");
        System.out.println("R - turn right");
        System.out.println("M - move forward");
        System.out.print(Colour.MAIN_TEXT_COLOUR);
        System.out.println("For example, LMM will turn the vehicle left and move forward 2x.");
        String movementValues = scanner.next();
        while(!isValidMovementValues(movementValues)){
            System.out.println("Please enter a valid selection.");
            System.out.println("Valid moves include: ");
            System.out.print(Colour.SECONDARY_COLOUR);
            System.out.println("L - turn left");
            System.out.println("R - turn right");
            System.out.println("M - move forward");
            System.out.print(Colour.MAIN_TEXT_COLOUR);
            System.out.println("For example, LMM will turn the vehicle left and move forward 2x.");
            movementValues = scanner.next();
        }
        return movementValues;
    }


}
