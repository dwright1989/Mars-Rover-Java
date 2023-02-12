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

    public void changeDirection(Orientation input){
        switch(input){
            case L -> {
                switch (getDirection()) {
                    case N -> setDirection(Direction.W);
                    case E -> setDirection(Direction.N);
                    case S -> setDirection(Direction.E);
                    case W -> setDirection(Direction.S);
                }
            }
            case R -> {
                switch (getDirection()) {
                    case N -> setDirection(Direction.E);
                    case E -> setDirection(Direction.S);
                    case S -> setDirection(Direction.W);
                    case W -> setDirection(Direction.N);
                }
            }
        }
    }

    abstract boolean moveForward(Object[][] grid);
}
