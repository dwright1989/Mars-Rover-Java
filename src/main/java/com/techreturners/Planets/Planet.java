package com.techreturners.Planets;

import com.techreturners.Plateaus.Plateau;
import com.techreturners.Plateaus.RectanglePlateau;

import java.util.ArrayList;

public class Planet {

    final String name;
    final double temperature;
    final double radius;
    final double gravity;

    private ArrayList<Plateau> plateaus = new ArrayList<Plateau>();

    public Planet(String name, double temperature, double radius, double gravity) {
        this.name = name;
        this.temperature = temperature;
        this.radius = radius;
        this.gravity = gravity;
    }

    public ArrayList<Plateau> getPlateaus() {
        return plateaus;
    }

    public void addPlateau(RectanglePlateau rectanglePlateau) {
        plateaus.add(rectanglePlateau);
    }

    public void removePlateau(RectanglePlateau rectanglePlateau) {
        plateaus.remove(rectanglePlateau);
    }



}
