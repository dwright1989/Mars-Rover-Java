package com.techreturners.PlateauTests;
import com.techreturners.Enums.Direction;
import com.techreturners.Plateaus.RectanglePlateau;
import com.techreturners.Vehicles.Rover;
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
    public void canMoveVehicleOneSpaceToTheLeftWhereIncompatible(){
        Rover rover = new Rover(new int[]{0, 4}, Direction.N);
        rectanglePlateau.addVehicle(rover);
        assertEquals("04W", rectanglePlateau.moveVehicle("LM", rover));
        assertEquals(Direction.W, rover.getDirection());
        assertArrayEquals(new int[]{0, 4}, rover.getPosition());
        assertNotNull(rectanglePlateau.getGrid()[0][4]);
    }

    @Test
    public void testPrintingGrid(){
        Rover rover = new Rover(new int[] {2,4}, Direction.N);
        rectanglePlateau.addVehicle(rover);
        rectanglePlateau.printGrid();
    }


}
