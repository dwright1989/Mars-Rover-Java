package com.techreturners.UI;

import com.techreturners.Planets.Planet;
import com.techreturners.User;

import java.util.Scanner;

public class UserInterface {
    public UserInterface(){
        createUser();
    }

    public void createUser(){
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
        Planet mars = new Planet("Mars", -81, 3389.5, 3.721);
        User user = new User(mars, name);

        scanner.close();
    }
}
