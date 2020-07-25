package com.tour;

import com.tour.model.ChessBoard;
import com.tour.model.KnightTour;
import com.tour.model.KnightTourParameters;
import com.tour.model.Point;
import com.tour.service.KnightTourFinder;
import com.tour.service.WarnsdorffKnightTourFinderImpl;
import com.tour.Exception.SolutionNotFound;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.println("Please enter starting point 0-9 ( format: x y):");

        try (Scanner scanner = new Scanner(System.in)) {
            while (scanner.hasNext()) {

                int x = scanner.nextInt();
                int y = scanner.nextInt();

                ChessBoard chessBoard = new ChessBoard(10, 10);
                KnightTourParameters knightTourParameters = new KnightTourParameters.Builder()
                        .withStartingPoint(Point.of(x, y))
                        .withMaxRetry(100)//retry for heuristic solution which may no find a solution
                        .build();

                KnightTourFinder knightTourFinder = new WarnsdorffKnightTourFinderImpl();
                KnightTour knightTour = knightTourFinder.findAny(chessBoard, knightTourParameters).orElseThrow(SolutionNotFound::new);

                System.out.println(knightTour);
            }
        }
    }


}
