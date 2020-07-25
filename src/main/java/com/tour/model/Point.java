package com.tour.model;

import java.text.DecimalFormat;
import java.util.Objects;

public final class Point {

    private final int row;
    private final int col;
    private int step;

    public Point(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public static Point of(int row, int col) {
        return new Point(row, col);
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public int getStep() {
        return step;
    }

    public void setStep(int step) {
        this.step = step;
    }

    @Override
    public String toString() {
        DecimalFormat digits = new DecimalFormat("000");
        return digits.format(step);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return row == point.row &&
                col == point.col &&
                step == point.step;
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, col, step);
    }
}
