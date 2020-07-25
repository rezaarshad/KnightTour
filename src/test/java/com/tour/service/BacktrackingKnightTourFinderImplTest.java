package com.tour.service;

import com.tour.model.ChessBoard;
import com.tour.model.KnightTour;
import com.tour.model.KnightTourParameters;
import com.tour.model.Point;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Optional;

public class BacktrackingKnightTourFinderImplTest {

    KnightTourFinder knightTourFinder = new BacktrackingKnightTourFinderImpl();

    @Test
    public void testFindAnyTourWithPoint00() {
        ChessBoard chessBoard = new ChessBoard(7, 7);
        KnightTourParameters knightTourParameters = new KnightTourParameters.Builder()
                .withStartingPoint(Point.of(0, 0))
                .build();

        Optional<KnightTour> pieceTour = knightTourFinder.findAny(chessBoard, knightTourParameters);

        Assert.assertTrue(pieceTour.isPresent());

        long expectedDistinctCount = chessBoard.getColNum() * chessBoard.getColNum();
        long count = Arrays.stream(pieceTour.get().getPoints()).flatMap(Arrays::stream).map(Point::getStep).distinct().count();

        Assert.assertEquals(expectedDistinctCount, count);
    }

    @Test
    public void testFindAnyTourNotFound() {
        ChessBoard chessBoard = new ChessBoard(4, 4);
        KnightTourParameters knightTourParameters = new KnightTourParameters.Builder()
                .withStartingPoint(Point.of(0, 0))
                .build();

        Optional<KnightTour> pieceTour = knightTourFinder.findAny(chessBoard, knightTourParameters);

        Assert.assertFalse(pieceTour.isPresent());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFindAnyTourWithInvalidStartingPoint() {

        KnightTourParameters knightTourParameters = new KnightTourParameters.Builder()
                .withStartingPoint(Point.of(-2, 0))
                .build();

        knightTourFinder.findAny(null, knightTourParameters);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFindAnyTourWithInvalidArgument() {

        KnightTourParameters knightTourParameters = new KnightTourParameters.Builder()
                .withStartingPoint(Point.of(0, 0))
                .build();

        knightTourFinder.findAny(null, knightTourParameters);
    }
}