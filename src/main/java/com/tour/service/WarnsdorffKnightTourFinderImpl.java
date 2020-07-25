package com.tour.service;

import com.tour.model.ChessBoard;
import com.tour.model.Move;
import com.tour.model.KnightTourParameters;
import com.tour.model.Point;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

public class WarnsdorffKnightTourFinderImpl extends AbstractKnightTourFinder implements KnightTourFinder {

    /**
     * Since Warnsdorff is a heuristic algorithm, we might need to retry to find a solution.
     */
    protected boolean find(Point startingPoint, ChessBoard chessBoard, KnightTourParameters knightTourParameters) {

        int retries = 0;
        boolean solutionIsFound = false;
        while (retries++ < knightTourParameters.getMaxRetry() && !solutionIsFound) {
            solutionIsFound = warnsdorff(startingPoint, chessBoard, knightTourParameters);
            //reset result and steps if solution not found for next retry
            if (!solutionIsFound) {
                chessBoard.resetSteps();
                startingPoint = chessBoard.getPoint(startingPoint.getRow(), startingPoint.getCol());
                startingPoint.setStep(1);
            }
        }

        return solutionIsFound;
    }

    private boolean warnsdorff(Point startingPoint, ChessBoard chessBoard, KnightTourParameters knightTourParameters) {
        int step = 1;

        int n = chessBoard.getRowNum() * chessBoard.getColNum();
        while (step < n) {
            Optional<Point> newPoint = nextMove(chessBoard, startingPoint, knightTourParameters.getPossibleMoves());
            if (newPoint.isPresent()) {
                startingPoint = chessBoard.getPoint(newPoint.get().getRow(), newPoint.get().getCol());
                startingPoint.setStep(++step);
            } else {
                break;
            }
        }
        return step == n;
    }

    private Optional<Point> nextMove(ChessBoard chessBoard, Point point, List<Move> possibleMoves) {

        return possibleMoves.stream().
                //shuffle the list
                sorted((o1, o2) -> ThreadLocalRandom.current().nextInt(-1, 2)).
                map(move -> Point.of(point.getRow() + move.getX(), point.getCol() + move.getY())).
                filter(p -> isValidMove(p, chessBoard)).
                min(Comparator.comparingInt(p -> getDegree(chessBoard, possibleMoves, p)));
    }

    private int getDegree(ChessBoard chessBoard, List<Move> possibleMoves, Point point) {

        return (int) possibleMoves.stream().
                map(move -> Point.of(point.getRow() + move.getX(), point.getCol() + move.getY())).
                filter(p -> isValidMove(p, chessBoard)).count();
    }
}
