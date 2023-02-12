package com.techreturners;

public abstract class Vehicle {

    private int size;
    private int[] position;
    private Direction direction;

    public Vehicle(int[] position, Direction direction){
        this.position = position;
        this.direction = direction;
    }


    public int getSize() {
        return size;
    }

    public int[] getPosition() {
        return position;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setPosition(int[] position) {
        this.position = position;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    /*public String move(String movements) {
        String updatedPosition = "";
        for(int i=0; i<movements.length(); i++){
            char input = movements.charAt(i);
            // Check if move forward or direction
            switch (input) {
                case 'M' -> moveForward();
                case 'L', 'R' -> changeDirection(input);
            }
        }
        return updatedPosition;
    }*/

    abstract String moveForward(Object[][] grid);
}
