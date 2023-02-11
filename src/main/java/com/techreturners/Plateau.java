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
        int n =grid.length;


        for(int i=0; i< n; i++) {
            int m = grid[i].length;
            for(int j=0; j<grid[i].length; j++){
                System.out.print(grid[n-i-1][m-j-1] + "");
            }
        }
    }
}
