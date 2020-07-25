package com.tour.model;

import java.util.Arrays;

public final class KnightTour {
    private final Point[][] points;

    public KnightTour(Point[][] points) {
        this.points = points;
    }

    public Point[][] getPoints() {
        return points;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Point[] res : points) {
            stringBuilder.append(Arrays.toString(res));
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
}
