package com.yannickmg.adventofcode2024.puzzles.day06;

public record WestwardGuard(Position position) implements Guard {
    static final Position step = new Position(-1, 0);
    @Override
    public Guard stepForward() {
        return new WestwardGuard(position.add(step));
    }

    @Override
    public Guard turnRight() {
        return new NorthwardGuard(position);
    }
}
