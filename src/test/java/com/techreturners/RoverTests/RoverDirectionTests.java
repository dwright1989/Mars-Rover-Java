package com.techreturners.RoverTests;

import com.techreturners.Enums.Direction;
import com.techreturners.Enums.Orientation;
import com.techreturners.Plateaus.RectanglePlateau;
import com.techreturners.Vehicles.Rover;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RoverDirectionTests {

    RectanglePlateau rectanglePlateau;

    @BeforeEach
    public void setUp(){
        rectanglePlateau = new RectanglePlateau(5,5);
    }

    @Test
    public void roverChangesLeftFromNorth(){
        Rover rover = new Rover(new int[]{2,3}, Direction.N);
        rectanglePlateau.addVehicle(rover);
        rover.changeDirection(Orientation.L);
        assertEquals(Direction.W, rover.getDirection());
    }

    @Test
    public void roverChangesRightFromNorth(){
        Rover rover = new Rover(new int[]{2,3}, Direction.N);
        rectanglePlateau.addVehicle(rover);
        rover.changeDirection(Orientation.R);
        assertEquals(Direction.E, rover.getDirection());
    }

    @Test
    public void roverChangesLeftFromEast(){
        Rover rover = new Rover(new int[]{2,3}, Direction.E);
        rectanglePlateau.addVehicle(rover);
        rover.changeDirection(Orientation.L);
        assertEquals(Direction.N, rover.getDirection());
    }

    @Test
    public void roverChangesRightFromEast(){
        Rover rover = new Rover(new int[]{2,3}, Direction.E);
        rectanglePlateau.addVehicle(rover);
        rover.changeDirection(Orientation.R);
        assertEquals(Direction.S, rover.getDirection());
    }

    @Test
    public void roverChangesLeftFromSouth(){
        Rover rover = new Rover(new int[]{2,3}, Direction.S);
        rectanglePlateau.addVehicle(rover);
        rover.changeDirection(Orientation.L);
        assertEquals(Direction.E, rover.getDirection());
    }

    @Test
    public void roverChangesRightFromSouth(){
        Rover rover = new Rover(new int[]{2,3}, Direction.S);
        rectanglePlateau.addVehicle(rover);
        rover.changeDirection(Orientation.R);
        assertEquals(Direction.W, rover.getDirection());
    }

    @Test
    public void roverChangesLeftFromWest(){
        Rover rover = new Rover(new int[]{2,3}, Direction.W);
        rectanglePlateau.addVehicle(rover);
        rover.changeDirection(Orientation.L);
        assertEquals(Direction.S, rover.getDirection());
    }

    @Test
    public void roverChangesRightFromWest(){
        Rover rover = new Rover(new int[]{2,3}, Direction.W);
        rectanglePlateau.addVehicle(rover);
        rover.changeDirection(Orientation.R);
        assertEquals(Direction.N, rover.getDirection());
    }
}
