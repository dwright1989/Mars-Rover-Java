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
}
