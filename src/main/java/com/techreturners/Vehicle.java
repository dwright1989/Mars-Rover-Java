package com.techreturners;

public class Vehicle {

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
}
