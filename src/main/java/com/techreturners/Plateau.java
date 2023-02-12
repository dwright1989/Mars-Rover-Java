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
        int xLength = grid.length;
        int yLength = grid[0].length;

        for(int j=1; j<=yLength; j++){
            for(int i=0; i<xLength; i++){
                Object gridPosition = grid[i][yLength-j];
                if(gridPosition==null){
                    System.out.print(" _ ");
                }else{
                    System.out.print(" X ");
                }
            }
            System.out.println();
        }

        /*int n =grid.length;
        int xLength = grid.length;
        int yLength = grid[0].length;

        for(int j=1; j<=yLength; j++){
            for(int i=0; i<xLength; i++){
                System.out.print(grid[i][yLength-j] + " " + i + " " + (yLength-j));
            }
            System.out.println();
        }*/




    }

}
