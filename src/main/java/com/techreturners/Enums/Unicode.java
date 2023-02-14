package com.techreturners.Enums;

public enum Unicode {

    NORTH_ARROW("↑"),
    EAST_ARROW("→"),
    SOUTH_ARROW("↓"),
    WEST_ARROW("←"),

    ROCK("¤");
    private final String code;

    Unicode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return code;
    }

}
