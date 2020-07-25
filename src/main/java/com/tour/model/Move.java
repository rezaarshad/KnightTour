package com.tour.model;

public enum Move {
    NORTHEAST(2, 2),
    NORTH(0, 3),
    NORTHWEST(-2, 2),
    EAST(3, 0),
    SOUTHEAST(2, -2),
    SOUTH(0, -3),
    SOUTHWEST(-2, -2),
    WEST(-3, 0);

    private final int x;
    private final int y;

    Move(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
