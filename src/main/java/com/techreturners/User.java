package com.techreturners;
import com.techreturners.Planets.Planet;
public class User {
    private Planet planet;
    private String name;


    public User(Planet planet, String name) {
        this.planet = planet;
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
