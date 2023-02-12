package com.techreturners;

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
    public String moveForward(Object[][] grid) {
        boolean canMove = false;
        int[] newPosition = getNewPosition();
        int y = getNewPosition()[0];
        int x = getNewPosition()[1];
        int lengthOne = grid.length;
        int lengthTwo = grid[0].length;
        if(y<lengthOne && y>=0 && x<lengthTwo && x>=0){ // TODO Method may need to be updated if/when obstacles added
            canMove = true;
        }
        if(canMove){
            setPosition(newPosition);
            return "Vehicle has been successfully moved.";
        }else{
            return "This is an invalid move, no space. Try again";
        }

    }
}
