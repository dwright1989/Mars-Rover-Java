package com.techreturners.PlateauTests;
import com.techreturners.Direction;
import com.techreturners.RectanglePlateau;
import com.techreturners.Rover;
import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

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
        rectanglePlateau.removeVehicle(rover);
        assertNull(rectanglePlateau.getGrid()[0][1]);
    }

    @Test
    public void testPrintingGrid(){
        Rover rover = new Rover(new int[] {2,4}, Direction.N);
        rectanglePlateau.addVehicle(rover);
        rectanglePlateau.printGrid();
    }


}
