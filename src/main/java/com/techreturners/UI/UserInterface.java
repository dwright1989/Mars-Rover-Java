package com.techreturners.UI;

import com.techreturners.Planets.Planet;
import com.techreturners.User;

import java.util.Scanner;

public class UserInterface {
    User user;
    Planet mars;
    public UserInterface(){
        startApplication();
    }

    public void startApplication(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nWelcome to the planet explorer.  What is your name?");
        while(!scanner.hasNext("[A-Za-z]*")){
            System.out.println("Please enter a valid name");
            scanner.next();
        }
        String name = scanner.next();
        System.out.println("Welcome " + name + " please select which planet you would like to explore.");
        System.out.println("[1] Mars");
        while(!(scanner.nextInt()==1)){
            System.out.println("Please enter a valid selection");
        }

        System.out.println("Welcome to Mars, " + name);
        // Assuming the planet is Mars - TODO upgrade if/when more planets added
        mars = new Planet("Mars", -81, 3389.5, 3.721);
        user = new User(mars, name);

        // Add a plateau
        addPlateauToPlanet(scanner);
        // Add a vehicle
        // Move the vehicle
        scanner.close();
    }

    private void addPlateauToPlanet(Scanner scanner) {
        System.out.println("Enter a plateau size in the form XY.  Where X is the length of the horizontal coordinates and Y is the length of the vertical coordinates. E.g. 54");
        String input = scanner.next();
        while(input.length()!=2){
            System.out.println("Please enter a valid selection.  This must be two numerical values e.g. 54. The largest values you can enter are 99");
            input = scanner.next();
        }
        System.out.println("Thank you, " + user.getName() + "!  Have a look at the grid of the plateau below.");
        //mars.addPlateau();
    }
}
