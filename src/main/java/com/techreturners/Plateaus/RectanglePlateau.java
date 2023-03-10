package com.techreturners.Plateaus;

import com.techreturners.Enums.Orientation;
import com.techreturners.Obstacles.Obstacle;
import com.techreturners.Obstacles.Rock;
import com.techreturners.Vehicles.Vehicle;

public class RectanglePlateau extends Plateau {


    public RectanglePlateau(int x,int y) {
        super.setGrid(new Object[x][y]);
        generateObstacles();
    }

    public void addVehicle(Vehicle vehicle) {
        int x = vehicle.getPosition()[0];
        int y = vehicle.getPosition()[1];
        Object[][] grid = super.getGrid();
        int xLength = grid.length;
        int yLength = grid[0].length;
        if(x<xLength && y<yLength && grid[x][y]==null){
            grid[x][y] = vehicle;
        }

        if(vehicle.getSize()>1){
            // Additional logic can be added here if/when larger vehicles implemented
            // E.g. spans over two squares - check the direction and add vehicle on additional array elements
            // So size == 2 at pos [0,1] and direction N would also be added to [1,1].
        }

    }

    public void removeVehicle(int[] pos, int size) {
        int x = pos[0];
        int y = pos[1];
        super.getGrid()[x][y] = null;
        if(size>1){
            // Additional logic can be added here if/when larger vehicles implemented
            // E.g. spans over two squares - check the direction and remove vehicle on additional array elements
            // So size == 2 at pos [0,1] and direction N would also be removed from [1,1]
        }

    }
    public void moveVehicleForward(Vehicle vehicle){
            removeVehicle(vehicle.getPosition(), vehicle.getSize());
            vehicle.moveForward(getGrid());
            addVehicle(vehicle);
    }

    @Override
    public Object[] moveVehicle(String movements, Vehicle vehicle) {
        boolean fullJourneySuccessful = false;
        movements = movements.toUpperCase();
        outerloop:
        for(int i=0; i<movements.length(); i++){
            char input = movements.charAt(i);
            switch (input) {
                case 'M' -> {
                    int[] oldPosition = vehicle.getPosition();
                    boolean moveSuccessful = vehicle.moveForward(getGrid());
                    if(moveSuccessful){
                        removeVehicle(oldPosition, vehicle.getSize());
                        addVehicle(vehicle);
                        fullJourneySuccessful = true;
                    }else{
                        fullJourneySuccessful = false;
                        break outerloop;
                    }
                }
                case 'L', 'R' -> vehicle.changeDirection(Orientation.valueOf(String.valueOf(input)));
            }
        }
        return new Object[]{vehicle.getPosition()[0] + "" + vehicle.getPosition()[1] + "" + vehicle.getDirection(), fullJourneySuccessful};
    }

    @Override
    public void addObstacle(Obstacle obstacle) {
        int x = obstacle.getPosition()[0];
        int y = obstacle.getPosition()[1];
        super.getGrid()[x][y] = obstacle;
    }

    @Override
    public void generateObstacles() {
        int number;
        int x = getGrid().length;
        int y = getGrid()[0].length;
        if(x<=2 || y<=2){
            number = 0;
        }
        else if(x<=4 || y<=4){
            number = 1;
        }else{
            int totalSquares = x*y;
            number = (int) (totalSquares/10);
        }
        addObstacles(number);
    }

    @Override
    public void addObstacles(int number) {
        Object[][] grid = super.getGrid();
        int xLength = grid.length-1;
        int yLength = grid[0].length-1;
        for(int i = 0; i<number; i++){
            boolean validValue = false;
            int randomXPosition = 0;
            int randomYPosition = 0;
            while(!validValue){
                randomXPosition = (int) (Math.random() * xLength);
                randomYPosition = (int) (Math.random() * yLength);
                if(grid[randomXPosition][randomYPosition]==null){
                    validValue = true;
                }
            }
            Rock rock = new Rock(randomXPosition, randomYPosition);
            addObstacle(rock);
        }
    }

}
