package com.techreturners;

public class RectanglePlateau extends Plateau{


    public RectanglePlateau(int x,int y) {
        super.setGrid(new Object[x][y]);
    }

    public void addVehicle(Vehicle vehicle) {
        int x = vehicle.getPosition()[0];
        int y = vehicle.getPosition()[1];
        super.getGrid()[x][y] = vehicle;
    }

    public void removeVehicle(Vehicle vehicle) {
        int x = vehicle.getPosition()[0];
        int y = vehicle.getPosition()[1];
        super.getGrid()[x][y] = null;
    }

}
