package com.techreturners.Plateaus;

import com.techreturners.Vehicles.Vehicle;

public abstract class Plateau {
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
    }


    public abstract String moveVehicle(String movements, Vehicle vehicle);
}
