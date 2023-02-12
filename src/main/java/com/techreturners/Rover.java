package com.techreturners;

public class Rover extends Vehicle {


    public Rover(int[] position, Direction direction) {
        super(position, direction);
    }

    public void moveForward(){
        switch (super.getDirection()) {
            case N -> setPosition(new int[]{getPosition()[0], getPosition()[1] + 1});
            case E -> setPosition(new int[]{getPosition()[0] + 1, getPosition()[1]});
            case S -> setPosition(new int[]{getPosition()[0], getPosition()[1] - 1});
            case W -> setPosition(new int[]{getPosition()[0] - 1, getPosition()[1]});
        }
        // Check CAN move forward
    }
}
