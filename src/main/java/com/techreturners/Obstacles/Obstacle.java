package com.techreturners.Obstacles;

public class Obstacle {

    private final int[] position;

    public Obstacle(int x, int y){
        this.position = new int[]{x, y};
    }

    public int[] getPosition() {
        return position;
    }
}
