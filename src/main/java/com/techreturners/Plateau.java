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

    public void addVehicle(Rover rover) {
        int x = rover.getPosition()[0];
        int y = rover.getPosition()[1];
        grid[x][y] = rover;
    }
    public void removeVehicle(Rover rover) {
        int x = rover.getPosition()[0];
        int y = rover.getPosition()[1];
        grid[x][y] = null;
    }

    public void printGrid(){
        System.out.println(Arrays.deepToString(grid));
    }
}
