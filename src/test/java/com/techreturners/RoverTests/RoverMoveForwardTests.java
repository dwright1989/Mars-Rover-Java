package com.techreturners.RoverTests;

import com.techreturners.Enums.Direction;
import com.techreturners.Plateaus.RectanglePlateau;
import com.techreturners.Vehicles.Rover;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RoverMoveForwardTests {

    RectanglePlateau rectanglePlateau;

    @BeforeEach
    public void setUp(){
        rectanglePlateau = new RectanglePlateau(5,5);
    }

    @Test
    public void canMoveForwardWhenFacingNorthAndSpaceAvailable(){
        Rover rover = new Rover(new int[]{2,3}, Direction.N);
        rectanglePlateau.addVehicle(rover);
        // check to see if obstacle on this square
        Object[][] grid = rectanglePlateau.getGrid();
        if(grid[2][4]==null){
            rectanglePlateau.moveVehicleForward(rover);
            assertArrayEquals(new int[]{2,4}, rover.getPosition());
            assertEquals(rectanglePlateau.getGrid()[2][4], rover);
        }

    }

    @Test
    public void roverStaysInTheSamePlaceIfNoSpaceAvailableFacingNorth(){
        Rover rover = new Rover(new int[]{2,4}, Direction.N);
        rectanglePlateau.addVehicle(rover);
        rectanglePlateau.moveVehicleForward(rover);
        assertArrayEquals(new int[]{2,4}, rover.getPosition());
        assertEquals(rectanglePlateau.getGrid()[2][4], rover);
    }

    @Test
    public void canMoveForwardWhenFacingEastAndSpaceAvailable(){
        Rover rover = new Rover(new int[]{2,3}, Direction.E);
        rectanglePlateau.addVehicle(rover);
        // check to see if obstacle on this square
        Object[][] grid = rectanglePlateau.getGrid();
        if(grid[3][3]==null){
            rectanglePlateau.moveVehicleForward(rover);
            assertArrayEquals(new int[]{3,3}, rover.getPosition());
            assertEquals(rectanglePlateau.getGrid()[3][3], rover);
        }
    }

    @Test
    public void roverStaysInTheSamePlaceIfNoSpaceAvailableFacingEast(){
        Rover rover = new Rover(new int[]{4,3}, Direction.E);
        rectanglePlateau.addVehicle(rover);
        rectanglePlateau.moveVehicleForward(rover);
        assertArrayEquals(new int[]{4,3}, rover.getPosition());
        assertEquals(rectanglePlateau.getGrid()[4][3], rover);
    }

    @Test
    public void canMoveForwardWhenFacingWestAndSpaceAvailable(){
        Rover rover = new Rover(new int[]{1,1}, Direction.W);
        rectanglePlateau.addVehicle(rover);
        // check to see if obstacle on this square
        Object[][] grid = rectanglePlateau.getGrid();
        if(grid[0][1]==null){
            rectanglePlateau.moveVehicleForward(rover);
            assertArrayEquals(new int[]{0,1}, rover.getPosition());
            assertEquals(rectanglePlateau.getGrid()[0][1], rover);
        }
    }

    @Test
    public void roverStaysInTheSamePlaceIfNoSpaceAvailableFacingWest(){
        Rover rover = new Rover(new int[]{0,1}, Direction.W);
        rectanglePlateau.addVehicle(rover);
        rectanglePlateau.moveVehicleForward(rover);
        assertArrayEquals(new int[]{0,1}, rover.getPosition());
        assertEquals(rectanglePlateau.getGrid()[0][1], rover);
    }

    @Test
    public void canMoveForwardWhenFacingSouthAndSpaceAvailable(){
        Rover rover = new Rover(new int[]{0,1}, Direction.S);
        rectanglePlateau.addVehicle(rover);
        // check to see if obstacle on this square
        Object[][] grid = rectanglePlateau.getGrid();
        if(grid[0][0]==null){
            rectanglePlateau.moveVehicleForward(rover);
            assertArrayEquals(new int[]{0,0}, rover.getPosition());
            assertEquals(rectanglePlateau.getGrid()[0][0], rover);
        }
    }

    @Test
    public void roverStaysInTheSamePlaceIfNoSpaceAvailableFacingSouth(){
        Rover rover = new Rover(new int[]{0,0}, Direction.S);
        rectanglePlateau.addVehicle(rover);
        rectanglePlateau.moveVehicleForward(rover);
        assertArrayEquals(new int[]{0,0}, rover.getPosition());
        assertEquals(rectanglePlateau.getGrid()[0][0], rover);
    }
}
