package com.tour.service;

import com.tour.model.ChessBoard;
import com.tour.model.KnightTour;
import com.tour.model.KnightTourParameters;
import com.tour.model.Point;

import java.util.Objects;
import java.util.Optional;

public abstract class AbstractKnightTourFinder implements KnightTourFinder {

    @Override
    public Optional<KnightTour> findAny(ChessBoard chessBoard, KnightTourParameters knightTourParameters) {
        Objects.requireNonNull(chessBoard, "chessBoard must not be null");
        Objects.requireNonNull(knightTourParameters, "knightTourParameters must not be null");

        Point startingPoint = chessBoard.getPoint(knightTourParameters.getStartingPoint().getRow(), knightTourParameters.getStartingPoint().getCol());
        startingPoint.setStep(1);

        boolean solutionIsFound = find(startingPoint, chessBoard, knightTourParameters);
        return solutionIsFound ? Optional.of(new KnightTour(chessBoard.getPoints())) : Optional.empty();
    }

    /**
     * Validation check for next move
     */
    protected boolean isValidMove(Point point, ChessBoard chessBoard) {
        return point.getRow() >= 0 && point.getCol() >= 0 && point.getRow() < chessBoard.getRowNum() && point.getCol() < chessBoard.getColNum() && chessBoard.getPoint(point.getRow(), point.getCol()).getStep() == 0;
    }

    protected abstract boolean find(Point startingPoint, ChessBoard chessBoard, KnightTourParameters knightTourParameters);
}
