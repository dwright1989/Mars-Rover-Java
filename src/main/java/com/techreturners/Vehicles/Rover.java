package com.techreturners.Vehicles;

import com.techreturners.Enums.Direction;

public class Rover extends Vehicle {

    final int size = 1;

    public Rover(int[] position, Direction direction) {
        super(position, direction);
    }

    // A rover can move only one square at a time - so get new position based on direction
    public int[] getNewPosition(){
        switch (super.getDirection()) {
            case N -> {return new int[]{getPosition()[0], getPosition()[1] + 1};}
            case E -> {return new int[]{getPosition()[0] + 1, getPosition()[1]};}
            case S -> {return new int[]{getPosition()[0], getPosition()[1] - 1};}
            case W -> {return new int[]{getPosition()[0] - 1, getPosition()[1]};}
        }
        return super.getPosition();
    }

    @Override
    public boolean moveForward(Object[][] grid) {
        boolean canMove = false;
        int[] newPosition = getNewPosition();
        int x = getNewPosition()[0];
        int y = getNewPosition()[1];
        int lengthOne = grid.length;
        int lengthTwo = grid[0].length;
        if(x<lengthOne && x>=0 && y<lengthTwo && y>=0 && grid[x][y] == null){
            canMove = true;
        }
        if(canMove){
            setPosition(newPosition);
        }
        return canMove;
    }
}
