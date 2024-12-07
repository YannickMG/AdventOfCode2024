package com.yannickmg.adventofcode2024.puzzles.day06;

public record Position(int x, int y) {
    public Position add(Position step) {
        return new Position(x + step.x, y + step.y);
    }
}
