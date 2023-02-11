package com.techreturners;

import java.util.ArrayList;
import java.util.Arrays;

public class Plateau {
    private Object[][] grid;

    public Object[][] getGrid() {
        return grid;
    }

    public void setGrid(Object[][] grid) {
        this.grid = grid;
    }

    public void printGrid(){
        System.out.println(Arrays.deepToString(grid));
    }
}
