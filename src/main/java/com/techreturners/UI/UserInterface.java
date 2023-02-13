package com.techreturners.UI;

import com.techreturners.Planets.Planet;
import com.techreturners.Plateaus.Plateau;
import com.techreturners.Plateaus.RectanglePlateau;
import com.techreturners.User;
import com.techreturners.Vehicles.Rover;
import com.techreturners.Vehicles.Vehicle;

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
        Vehicle vehicle = createVehicleAndAddToPlateau(scanner, plateau);
        // Add a vehicle
        // Move the vehicle
        scanner.close();
    }



    private Plateau createPlateauAndAddToPlanet(Scanner scanner){
        String plateauValues = getUserEnteredPlateauSize(scanner);
        return generatePlateauFromInput(plateauValues);
    }

    private String getUserEnteredPlateauSize(Scanner scanner) {
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
        System.out.println("Thank you, " + user.getName() + "!  Have a look at the grid of the plateau below.");
        return plateau;
    }

    private Vehicle createVehicleAndAddToPlateau(Scanner scanner, Plateau plateau) {
       String vehicleValues = getUserEnteredVehicleValues(scanner);
        //generateVehicleFromUserInput();
        return null;
    }

    private String getUserEnteredVehicleValues(Scanner scanner) {
        System.out.println("Where would you like to place your vehicle?  Enter two coordinates followed by a direction e.g. 11N for x coordinate 1, y coordinate 1 and facing North.");
        String vehicleValues = scanner.next();
        while(!isValidVehiclesValues(vehicleValues)){
            System.out.println("Please enter a valid selection.  Enter two coordinates followed by a direction e.g. 11N for x coordinate 1, y coordinate 1 and facing North.");
            vehicleValues = scanner.next();
        }
        return vehicleValues;
    }


}
