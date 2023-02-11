package com.techreturners;
import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

public class RectanglePlateauTest {

    RectanglePlateau rectanglePlateau;

    @BeforeEach
    public void setUp(){
        rectanglePlateau = new RectanglePlateau(1,3);
    }
    @Test
    public void canCreateRectanglePlateauWithGrid(){
        assertNotNull(rectanglePlateau.getGrid());
    }

    @Test
    public void canAddVehicleToGrid(){
        Rover rover = new Rover(new int[] {0,1}, Direction.N);
        rectanglePlateau.addVehicle(rover);
        assertNotNull(rectanglePlateau.getGrid()[0][1]);
        assertNull(rectanglePlateau.getGrid()[0][0]);
    }


}
