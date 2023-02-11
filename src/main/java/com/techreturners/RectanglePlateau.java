package com.techreturners;

public class RectanglePlateau extends Plateau{


    public RectanglePlateau(int x,int y) {
        super.setGrid(new Object[x][y]);
    }

    public void addVehicle(Vehicle vehicle) {
        int x = vehicle.getPosition()[0];
        int y = vehicle.getPosition()[1];
        super.getGrid()[x][y] = vehicle;
        if(vehicle.getSize()>1){
            // Additional logic can be added here if/when larger vehicles implemented
            // E.g. spans over two squares - check the direction and add vehicle on additional array elements
            // So size == 2 at pos [0,1] and direction N would also be added to [1,1]
        }
    }

    public void removeVehicle(Vehicle vehicle) {
        int x = vehicle.getPosition()[0];
        int y = vehicle.getPosition()[1];
        super.getGrid()[x][y] = null;
        if(vehicle.getSize()>1){
            // Additional logic can be added here if/when larger vehicles implemented
            // E.g. spans over two squares - check the direction and remove vehicle on additional array elements
            // So size == 2 at pos [0,1] and direction N would also be removed from [1,1]
        }

    }

}
