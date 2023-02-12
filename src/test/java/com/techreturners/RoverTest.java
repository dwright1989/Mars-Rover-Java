package com.techreturners;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RoverTest {

    RectanglePlateau rectanglePlateau;

    @BeforeEach
    public void setUp(){
        rectanglePlateau = new RectanglePlateau(5,5);
    }

    @Test
    public void canCreateRover(){
        Rover rover = new Rover(new int[]{0, 1}, Direction.N);
        assertArrayEquals(new int[]{0, 1}, rover.getPosition());
        assertEquals(Direction.N, rover.getDirection());
    }

    /*
    ################################################
    ############## MOVE FORWARD TESTS ##############
    ################################################
     */

    @Test
    public void canMoveForwardWhenFacingNorthAndSpaceAvailable(){
        Rover rover = new Rover(new int[]{2,3}, Direction.N);
        rectanglePlateau.addVehicle(rover);
        rectanglePlateau.moveVehicle(rover);
        assertArrayEquals(new int[]{2,4}, rover.getPosition());
        assertEquals(rectanglePlateau.getGrid()[2][4], rover);
    }

    @Test
    public void roverStaysInTheSamePlaceIfNoSpaceAvailableFacingNorth(){
        Rover rover = new Rover(new int[]{2,4}, Direction.N);
        rectanglePlateau.addVehicle(rover);
        rectanglePlateau.moveVehicle(rover);
        assertArrayEquals(new int[]{2,4}, rover.getPosition());
        assertEquals(rectanglePlateau.getGrid()[2][4], rover);
    }

    @Test
    public void canMoveForwardWhenFacingEastAndSpaceAvailable(){
        Rover rover = new Rover(new int[]{2,3}, Direction.E);
        rectanglePlateau.addVehicle(rover);
        rectanglePlateau.moveVehicle(rover);
        assertArrayEquals(new int[]{3,3}, rover.getPosition());
        assertEquals(rectanglePlateau.getGrid()[3][3], rover);
    }

    @Test
    public void roverStaysInTheSamePlaceIfNoSpaceAvailableFacingEast(){
        Rover rover = new Rover(new int[]{4,3}, Direction.E);
        rectanglePlateau.addVehicle(rover);
        rectanglePlateau.moveVehicle(rover);
        assertArrayEquals(new int[]{4,3}, rover.getPosition());
        assertEquals(rectanglePlateau.getGrid()[4][3], rover);
    }

    @Test
    public void canMoveForwardWhenFacingWestAndSpaceAvailable(){
        Rover rover = new Rover(new int[]{1,1}, Direction.W);
        rectanglePlateau.addVehicle(rover);
        rectanglePlateau.moveVehicle(rover);
        assertArrayEquals(new int[]{0,1}, rover.getPosition());
        assertEquals(rectanglePlateau.getGrid()[0][1], rover);
    }

    @Test
    public void roverStaysInTheSamePlaceIfNoSpaceAvailableFacingWest(){
        Rover rover = new Rover(new int[]{0,1}, Direction.W);
        rectanglePlateau.addVehicle(rover);
        rectanglePlateau.moveVehicle(rover);
        assertArrayEquals(new int[]{0,1}, rover.getPosition());
        assertEquals(rectanglePlateau.getGrid()[0][1], rover);
    }

    @Test
    public void canMoveForwardWhenFacingSouthAndSpaceAvailable(){
        Rover rover = new Rover(new int[]{0,1}, Direction.S);
        rectanglePlateau.addVehicle(rover);
        rectanglePlateau.moveVehicle(rover);
        assertArrayEquals(new int[]{0,0}, rover.getPosition());
        assertEquals(rectanglePlateau.getGrid()[0][0], rover);
    }

    @Test
    public void roverStaysInTheSamePlaceIfNoSpaceAvailableFacingSouth(){
        Rover rover = new Rover(new int[]{0,0}, Direction.S);
        rectanglePlateau.addVehicle(rover);
        rectanglePlateau.moveVehicle(rover);
        assertArrayEquals(new int[]{0,0}, rover.getPosition());
        assertEquals(rectanglePlateau.getGrid()[0][0], rover);
    }

    /*
    ################################################
    ############  CHANGE DIRECTION TESTS ###########
    ################################################
     */


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
