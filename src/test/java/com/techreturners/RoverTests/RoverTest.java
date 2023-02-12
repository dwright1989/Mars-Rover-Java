package com.techreturners.RoverTests;

import com.techreturners.Enums.Direction;
import com.techreturners.Plateaus.RectanglePlateau;
import com.techreturners.Vehicles.Rover;
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


}
