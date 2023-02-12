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
        Rover rover = new Rover(new int[]{2,3}, Direction.N);
        rectanglePlateau.addVehicle(rover);
        rectanglePlateau.moveVehicle(rover);
        assertArrayEquals(new int[]{2,4}, rover.getPosition());
        assertEquals(rectanglePlateau.getGrid()[4][2], rover); // Access reversed
    }

    @Test
    public void roverStaysInTheSamePlaceIfNoSpaceAvailableFacingNorth(){
        RectanglePlateau rectanglePlateau = new RectanglePlateau(5,5);
        Rover rover = new Rover(new int[]{2,4}, Direction.N);
        rectanglePlateau.addVehicle(rover);
        rectanglePlateau.moveVehicle(rover);
        assertArrayEquals(new int[]{2,4}, rover.getPosition());
        assertEquals(rectanglePlateau.getGrid()[4][2], rover); // Access reversed
    }

    @Test
    public void canMoveForwardWhenFacingEastAndSpaceAvailable(){
        RectanglePlateau rectanglePlateau = new RectanglePlateau(5,5);
        Rover rover = new Rover(new int[]{2,3}, Direction.E);
        rectanglePlateau.addVehicle(rover);
        rectanglePlateau.moveVehicle(rover);
        assertArrayEquals(new int[]{3,3}, rover.getPosition());
        assertEquals(rectanglePlateau.getGrid()[3][3], rover); // Access reversed
    }

    @Test
    public void roverStaysInTheSamePlaceIfNoSpaceAvailableFacingEast(){
        RectanglePlateau rectanglePlateau = new RectanglePlateau(5,5);
        Rover rover = new Rover(new int[]{4,3}, Direction.E);
        rectanglePlateau.addVehicle(rover);
        rectanglePlateau.moveVehicle(rover);
        assertArrayEquals(new int[]{4,3}, rover.getPosition());
        assertEquals(rectanglePlateau.getGrid()[3][4], rover); // Access reversed
    }

    @Test
    public void canMoveForwardWhenFacingWestAndSpaceAvailable(){
        RectanglePlateau rectanglePlateau = new RectanglePlateau(5,5);
        Rover rover = new Rover(new int[]{1,1}, Direction.W);
        rectanglePlateau.addVehicle(rover);
        rectanglePlateau.moveVehicle(rover);
        assertArrayEquals(new int[]{0,1}, rover.getPosition());
        assertEquals(rectanglePlateau.getGrid()[1][0], rover); // Access reversed
    }

    @Test
    public void roverStaysInTheSamePlaceIfNoSpaceAvailableFacingWest(){
        RectanglePlateau rectanglePlateau = new RectanglePlateau(5,5);
        Rover rover = new Rover(new int[]{0,1}, Direction.W);
        rectanglePlateau.addVehicle(rover);
        rectanglePlateau.moveVehicle(rover);
        assertArrayEquals(new int[]{0,1}, rover.getPosition());
        assertEquals(rectanglePlateau.getGrid()[1][0], rover); // Access reversed
    }

    @Test
    public void canMoveForwardWhenFacingSouthAndSpaceAvailable(){
        RectanglePlateau rectanglePlateau = new RectanglePlateau(5,5);
        Rover rover = new Rover(new int[]{0,1}, Direction.S);
        rectanglePlateau.addVehicle(rover);
        rectanglePlateau.moveVehicle(rover);
        assertArrayEquals(new int[]{0,0}, rover.getPosition());
        assertEquals(rectanglePlateau.getGrid()[0][0], rover); // Access reversed
    }

    @Test
    public void roverStaysInTheSamePlaceIfNoSpaceAvailableFacingSouth(){
        RectanglePlateau rectanglePlateau = new RectanglePlateau(5,5);
        Rover rover = new Rover(new int[]{0,0}, Direction.S);
        rectanglePlateau.addVehicle(rover);
        rectanglePlateau.moveVehicle(rover);
        assertArrayEquals(new int[]{0,0}, rover.getPosition());
        assertEquals(rectanglePlateau.getGrid()[0][0], rover); // Access reversed
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
