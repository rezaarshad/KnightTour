package com.tour.service;

import com.tour.model.ChessBoard;
import com.tour.model.Move;
import com.tour.model.KnightTourParameters;
import com.tour.model.Point;

public class BacktrackingKnightTourFinderImpl extends AbstractKnightTourFinder implements KnightTourFinder {

    /**
     * This function is a recursive function to solve Knight's tour Problem.
     * returns true if there is a solution otherwise returns false
     */
    protected boolean find(Point startingPoint, ChessBoard chessBoard, KnightTourParameters knightTourParameters) {
        if (startingPoint.getStep() == chessBoard.getRowNum() * chessBoard.getColNum())
            return true;

        for (Move move : knightTourParameters.getPossibleMoves()) {
            int r = startingPoint.getRow() + move.getX();
            int c = startingPoint.getCol() + move.getY();
            if (isValidMove(Point.of(r, c), chessBoard)) {
                Point nextPoint = chessBoard.getPoint(r, c);
                nextPoint.setStep(startingPoint.getStep() + 1);
                boolean found = find(nextPoint, chessBoard, knightTourParameters);
                if (!found) nextPoint.setStep(0);
                else return true;
            }
        }

        return false;
    }

}
