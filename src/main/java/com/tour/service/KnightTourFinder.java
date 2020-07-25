package com.tour.service;

import com.tour.model.ChessBoard;
import com.tour.model.KnightTourParameters;
import com.tour.model.KnightTour;

import java.util.Optional;

public interface KnightTourFinder {

    Optional<KnightTour> findAny(ChessBoard chessBoard, KnightTourParameters knightTourParameters);
}
