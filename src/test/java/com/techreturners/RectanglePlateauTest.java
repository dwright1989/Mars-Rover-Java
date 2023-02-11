package com.techreturners;
import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertNotNull;

public class RectanglePlateauTest {
    @Test
    public void canCreateRectanglePlateauWithGrid(){
        RectanglePlateau rectanglePlateau = new RectanglePlateau(1,3);
        assertNotNull(rectanglePlateau.getGrid());
    }


}
