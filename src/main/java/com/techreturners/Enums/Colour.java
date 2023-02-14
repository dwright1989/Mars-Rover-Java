package com.techreturners.Enums;

public enum Colour {
    //Color end string, color reset
    MAIN_TEXT_COLOUR("\033[0;33m"),
    SECONDARY_COLOUR("\033[0;36m"),
    ARROW_COLOUR("\033[0;34m"),
    GRID_COLOUR("\033[0;91m"),
    RESET("\033[0m");

    private final String code;

    Colour(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return code;
    }
}
