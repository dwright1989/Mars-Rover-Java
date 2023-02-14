package com.techreturners.PlateauTests;
import com.techreturners.Enums.Direction;
import com.techreturners.Plateaus.RectanglePlateau;
import com.techreturners.Vehicles.Rover;
import org.junit.Ignore;
import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RectanglePlateauTest {

    RectanglePlateau rectanglePlateau;

    @BeforeEach
    public void setUp(){
        rectanglePlateau = new RectanglePlateau(5,5);
    }
    @Test
    public void canCreateRectanglePlateauWithGrid(){
        assertNotNull(rectanglePlateau.getGrid());
    }

    @Test
    public void canAddVehicleToGrid(){
        Rover rover = new Rover(new int[] {2,3}, Direction.N);
        rectanglePlateau.addVehicle(rover);
        assertNotNull(rectanglePlateau.getGrid()[2][3]);
        assertNull(rectanglePlateau.getGrid()[0][0]);
        rectanglePlateau.printGrid();
    }

    @Test
    public void canRemoveVehicleFromGrid(){
        Rover rover = new Rover(new int[] {0,1}, Direction.N);
        rectanglePlateau.addVehicle(rover);
        rectanglePlateau.removeVehicle(rover.getPosition(), rover.getSize());
        assertNull(rectanglePlateau.getGrid()[0][1]);
    }

    @Test
    public void canMoveVehicleOneSpaceToTheLeft(){
        Rover rover = new Rover(new int[]{2, 3}, Direction.N);
        rectanglePlateau.addVehicle(rover);
        assertEquals("13W", rectanglePlateau.moveVehicle("LM", rover));
        assertEquals(Direction.W, rover.getDirection());
        assertArrayEquals(new int[]{1, 3}, rover.getPosition());
        assertNotNull(rectanglePlateau.getGrid()[1][3]);
        assertNull(rectanglePlateau.getGrid()[2][3]);
    }

    @Test
    public void cannotMoveVehicleOneSpaceToTheLeftWhereIncompatible(){
        Rover rover = new Rover(new int[]{0, 4}, Direction.N);
        rectanglePlateau.addVehicle(rover);
        assertEquals("04W", rectanglePlateau.moveVehicle("LM", rover));
        assertEquals(Direction.W, rover.getDirection());
        assertArrayEquals(new int[]{0, 4}, rover.getPosition());
        assertNotNull(rectanglePlateau.getGrid()[0][4]);
    }

    @Test
    public void canMoveVehicleLeftTwice(){
        Rover rover = new Rover(new int[]{2, 3}, Direction.N);
        rectanglePlateau.addVehicle(rover);
        assertEquals("03W", rectanglePlateau.moveVehicle("LMM", rover));
        assertEquals(Direction.W, rover.getDirection());
        assertArrayEquals(new int[]{0, 3}, rover.getPosition());
        assertNotNull(rectanglePlateau.getGrid()[0][3]);
        assertNull(rectanglePlateau.getGrid()[2][3]);
        assertNull(rectanglePlateau.getGrid()[1][3]);
    }

    @Test
    public void canMoveVehicleLeftTurnLeftMoveAgain(){
        Rover rover = new Rover(new int[]{2, 3}, Direction.N);
        rectanglePlateau.addVehicle(rover);
        assertEquals("12S", rectanglePlateau.moveVehicle("LMLM", rover));
        assertEquals(Direction.S, rover.getDirection());
        assertArrayEquals(new int[]{1, 2}, rover.getPosition());
        assertNotNull(rectanglePlateau.getGrid()[1][2]);
    }

    @Test
    public void canMoveVehicleUsingALongStringOfLefts(){
        Rover rover = new Rover(new int[]{1, 2}, Direction.N);
        rectanglePlateau.addVehicle(rover);
        assertEquals("13N", rectanglePlateau.moveVehicle("LMLMLMLMM", rover));
        assertEquals(Direction.N, rover.getDirection());
        assertArrayEquals(new int[]{1, 3}, rover.getPosition());
        assertNotNull(rectanglePlateau.getGrid()[1][3]);
    }

    @Test
    public void canMoveVehicleUsingALongStringOfRights(){
        Rover rover = new Rover(new int[]{3, 3}, Direction.E);
        rectanglePlateau.addVehicle(rover);
        assertEquals("41E", rectanglePlateau.moveVehicle("MMRMMRMRRM", rover));
        assertEquals(Direction.E, rover.getDirection());
        assertArrayEquals(new int[]{4, 1}, rover.getPosition());
        assertNotNull(rectanglePlateau.getGrid()[4][1]);
    }

    @Test
    public void canTurnVehicleLeftAndRight(){
        Rover rover = new Rover(new int[]{3, 3}, Direction.E);
        rectanglePlateau.addVehicle(rover);
        assertEquals("33N", rectanglePlateau.moveVehicle("LLR", rover));
        assertEquals(Direction.N, rover.getDirection());
        assertArrayEquals(new int[]{3, 3}, rover.getPosition());
        assertNotNull(rectanglePlateau.getGrid()[3][3]);
    }

    @Test
    public void canMoveVehicleForwardWithoutTurning(){
        Rover rover = new Rover(new int[]{3, 3}, Direction.E);
        rectanglePlateau.addVehicle(rover);
        assertEquals("43E", rectanglePlateau.moveVehicle("MMM", rover));
        assertEquals(Direction.E, rover.getDirection());
        assertArrayEquals(new int[]{4, 3}, rover.getPosition());
        assertNotNull(rectanglePlateau.getGrid()[4][3]);
    }


    @Test
    public void blankStringMovementShouldNotChange(){
        Rover rover = new Rover(new int[]{3, 3}, Direction.E);
        rectanglePlateau.addVehicle(rover);
        assertEquals("33E", rectanglePlateau.moveVehicle("", rover));
        assertEquals(Direction.E, rover.getDirection());
        assertArrayEquals(new int[]{3, 3}, rover.getPosition());
        assertNotNull(rectanglePlateau.getGrid()[3][3]);
    }

    @Test
    public void invalidStringMovementShouldNotChange(){
        Rover rover = new Rover(new int[]{3, 3}, Direction.E);
        rectanglePlateau.addVehicle(rover);
        assertEquals("33E", rectanglePlateau.moveVehicle("S", rover));
        assertEquals(Direction.E, rover.getDirection());
        assertArrayEquals(new int[]{3, 3}, rover.getPosition());
        assertNotNull(rectanglePlateau.getGrid()[3][3]);
    }

    @Test
    public void invalidStringMovementWithValidStringMovementShouldIgnoreInvalid(){
        Rover rover = new Rover(new int[]{3, 3}, Direction.E);
        rectanglePlateau.addVehicle(rover);
        assertEquals("33N", rectanglePlateau.moveVehicle("LSLR", rover));
        assertEquals(Direction.N, rover.getDirection());
        assertArrayEquals(new int[]{3, 3}, rover.getPosition());
        assertNotNull(rectanglePlateau.getGrid()[3][3]);
    }

    @Test
    public void testPrintingGrid(){
        Rover rover = new Rover(new int[] {2,4}, Direction.N);
        rectanglePlateau.addVehicle(rover);
        rectanglePlateau.printGrid();
    }

    /*
    Generating Obstacles
     */
    @Test
    public void canGenerateRockAndAddToGrid(){
        rectanglePlateau.generateObstacles(1);
        rectanglePlateau.printGrid();
    }


}
