package com.techreturners;
import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertNotNull;

public class RectanglePlateauTest {

    @BeforeEach
    public void setUp(){
        Planet mars = new Planet("Mars", -81, 3389.5, 3.721);
    }

    @Test
    public void canCreateRectanglePlateauWithGrid(){
        RectanglePlateau rectanglePlateau = new RectanglePlateau(1,3);
        assertNotNull(rectanglePlateau.getGrid());
    }

    @Test
    public void canAddPlateauToPlanet(){

    }

}
