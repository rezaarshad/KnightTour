package com.tour.model;

import static com.google.common.base.Preconditions.checkArgument;

public class ChessBoard {

    private final int rowNum;
    private final int colNum;
    private Point[][] points;

    public ChessBoard(int rowNum, int colNum) {
        this.rowNum = rowNum;
        this.colNum = colNum;
        this.points = new Point[rowNum][colNum];
        for (int i = 0; i < rowNum; i++) {
            for (int j = 0; j < colNum; j++) {
                this.points[i][j] = new Point(i, j);
            }
        }
    }

    public int getRowNum() {
        return rowNum;
    }

    public int getColNum() {
        return colNum;
    }

    public Point[][] getPoints() {
        return points;
    }

    public Point getPoint(int row, int col) {
        checkArgument(row >= 0 && row < rowNum);
        checkArgument(col >= 0 && col < rowNum);

        return points[row][col];
    }

    public void resetSteps() {
        for (int i = 0; i < rowNum; i++) {
            for (int j = 0; j < colNum; j++) {
                this.points[i][j].setStep(0);
            }
        }
    }


}
