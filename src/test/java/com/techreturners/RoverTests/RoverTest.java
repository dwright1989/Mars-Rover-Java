package com.techreturners.RoverTests;

import com.techreturners.Direction;
import com.techreturners.Orientation;
import com.techreturners.RectanglePlateau;
import com.techreturners.Rover;
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
