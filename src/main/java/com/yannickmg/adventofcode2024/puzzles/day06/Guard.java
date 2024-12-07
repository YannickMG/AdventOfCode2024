package com.yannickmg.adventofcode2024.puzzles.day06;

public interface Guard {
    int PUZZLE_DIM = 130;

    Guard stepForward();
    Guard turnRight();
    Position position();

    default boolean isOutOfBounds() {
        Position position = position();
        return position.x() < 0 || position.x() >= PUZZLE_DIM || position.y() < 0 || position.y() >= PUZZLE_DIM;
    }
}
