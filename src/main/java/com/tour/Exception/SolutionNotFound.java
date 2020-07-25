package com.tour.Exception;

public class SolutionNotFound extends RuntimeException {
    public SolutionNotFound() {
        super("Solution not found!");
    }
}
