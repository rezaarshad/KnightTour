package com.tour.model;

import java.util.Arrays;
import java.util.List;

import static com.google.common.base.Preconditions.checkArgument;

public final class KnightTourParameters {

    private final Point startingPoint;
    private final List<Move> possibleMoves;
    private final int maxRetry;

    public KnightTourParameters(Builder builder) {
        checkArgument(builder != null);

        this.startingPoint = builder.getStartingPoint();
        this.possibleMoves = builder.getPossibleMoves();
        this.maxRetry = builder.getMaxRetry();
    }

    public Point getStartingPoint() {
        return startingPoint;
    }

    public List<Move> getPossibleMoves() {
        return possibleMoves;
    }

    public int getMaxRetry() {
        return maxRetry;
    }

    public static class Builder {
        private Point startingPoint;
        private List<Move> possibleMoves = Arrays.asList(Move.EAST, Move.NORTH, Move.NORTHEAST, Move.NORTHWEST, Move.SOUTH, Move.SOUTHEAST, Move.SOUTHWEST, Move.WEST);
        private int maxRetry = 1;

        public Builder withStartingPoint(Point startingPoint) {
            checkArgument(startingPoint != null);

            this.startingPoint = startingPoint;
            return this;
        }

        public Builder withMaxRetry(int maxRetry) {
            checkArgument(maxRetry > 0);

            this.maxRetry = maxRetry;
            return this;
        }

        public Builder withPossibleMoves(List<Move> possibleMoves) {
            checkArgument(possibleMoves != null && !possibleMoves.isEmpty());

            this.possibleMoves = possibleMoves;
            return this;
        }

        public Point getStartingPoint() {
            return startingPoint;
        }

        public List<Move> getPossibleMoves() {
            return possibleMoves;
        }

        public int getMaxRetry() {
            return maxRetry;
        }

        public KnightTourParameters build() {
            return new KnightTourParameters(this);
        }

    }
}
