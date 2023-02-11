package com.techreturners;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class PlanetTest {

    Planet mars;

    @BeforeEach
    public void setUp(){
        mars = new Planet("Mars", -81, 3389.5, 3.721);
    }

    @Test
    public void canAddPlateauToPlanet(){
        RectanglePlateau rectanglePlateau = new RectanglePlateau(1,3);
        mars.addPlateau(rectanglePlateau);
        assertNotNull(mars.getPlateaus());
    }
}
