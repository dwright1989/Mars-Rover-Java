package com.techreturners.Plateaus;

import com.techreturners.Enums.Colour;
import com.techreturners.Enums.Unicode;
import com.techreturners.Vehicles.Rover;
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
        int xLength = grid.length;
        int yLength = grid[0].length;
        System.out.println();
        for(int j=1; j<=yLength; j++){
            System.out.print(Colour.YELLOW);
            System.out.print(yLength-j + " ");
            System.out.print(Colour.RESET);
            for (Object[] objects : grid) {
                Object gridPosition = objects[yLength - j];
                if (gridPosition == null) {
                    System.out.print("|   |");
                } else {
                    System.out.print("|");
                    System.out.print(Colour.RED_BRIGHT);
                    switch (((Rover) gridPosition).getDirection()) {
                        case N -> {
                            System.out.print(" " + Unicode.NORTH_ARROW + " ");
                        }
                        case E -> {
                            System.out.print(" " + Unicode.EAST_ARROW + " ");
                        }
                        case S -> {
                            System.out.print(" " + Unicode.SOUTH_ARROW + " ");
                        }
                        case W -> {
                            System.out.print(" " + Unicode.WEST_ARROW + " ");
                        }
                    }
                    System.out.print(Colour.RESET);
                    System.out.print("|");
                }
            }
            System.out.println();
        }
        for(int i=0; i<xLength; i++){
            System.out.print(Colour.YELLOW);
            System.out.print("    " + i);
            System.out.print(Colour.RESET);
        }
        System.out.println();
    }


    public abstract String moveVehicle(String movements, Vehicle vehicle);
    public abstract boolean addVehicle(Vehicle vehicle);
}
