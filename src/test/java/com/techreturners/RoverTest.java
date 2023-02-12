package com.techreturners;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RoverTest {

    @Test
    public void canCreateRover(){
        Rover rover = new Rover(new int[]{0, 1}, Direction.N);
        assertArrayEquals(new int[]{0, 1}, rover.getPosition());
        assertEquals(Direction.N, rover.getDirection());
    }

    @Test
    public void canMoveForwardWhenFacingNorthAndSpaceAvailable(){
        RectanglePlateau rectanglePlateau = new RectanglePlateau(5,5);
        Rover rover = new Rover(new int[]{2,4}, Direction.N);
        rectanglePlateau.addVehicle(rover);
        rectanglePlateau.moveVehicle(rover);
        assertArrayEquals(new int[]{2,4}, rover.getPosition());
        assertEquals(rectanglePlateau.getGrid()[4][2], rover); // Printing back to front for grid purposes so 2,4 == 4,2
    }



    /*@Test
    public void canMoveRoverOneSpaceToTheLeft(){
        RectanglePlateau rectanglePlateau = new RectanglePlateau(5,5);
        Rover rover = new Rover(new int[]{2, 3}, Direction.N);
        rectanglePlateau.addVehicle(rover);

        assertEquals("13W", rover.move("LM"));
        //assertEquals(Direction.W, rover.getDirection());
       // assertArrayEquals(new int[]{1, 3}, rover.getPosition());
       // assertNotNull(rectanglePlateau.getGrid()[1][3]);
        //assertNull(rectanglePlateau.getGrid()[2][3]);
    }*/
}
