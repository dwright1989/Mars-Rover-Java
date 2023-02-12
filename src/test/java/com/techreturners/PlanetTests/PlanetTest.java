package com.techreturners.PlanetTests;

import com.techreturners.Planet;
import com.techreturners.RectanglePlateau;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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

    @Test
    public void canRemovePlateauFromPlanet(){
        RectanglePlateau rectanglePlateau = new RectanglePlateau(1,3);
        mars.addPlateau(rectanglePlateau);
        mars.removePlateau(rectanglePlateau);
        assertEquals(0, mars.getPlateaus().size());
    }
}
