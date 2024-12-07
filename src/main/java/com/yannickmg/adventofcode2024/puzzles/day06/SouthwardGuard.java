package com.yannickmg.adventofcode2024.puzzles.day06;

public record SouthwardGuard(Position position) implements Guard {
    static final Position step = new Position(0, 1);
    @Override
    public Guard stepForward() {
        return new SouthwardGuard(position.add(step));
    }

    @Override
    public Guard turnRight() {
        return new WestwardGuard(position);
    }
}
