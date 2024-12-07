package com.yannickmg.adventofcode2024.puzzles;

import com.yannickmg.adventofcode2024.Puzzle;
import com.yannickmg.adventofcode2024.puzzles.day06.Guard;
import com.yannickmg.adventofcode2024.puzzles.day06.NorthwardGuard;
import com.yannickmg.adventofcode2024.puzzles.day06.Position;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Objects;

import static com.yannickmg.adventofcode2024.puzzles.day06.Guard.PUZZLE_DIM;

public class Day06Puzzle1 implements Puzzle {

    @Override
    public String solve(BufferedReader input) throws IOException {
        final boolean[][] walls = new boolean[PUZZLE_DIM][PUZZLE_DIM];
        final boolean[][] visited = new boolean[PUZZLE_DIM][PUZZLE_DIM];
        Guard guard = null;
        for (int y = 0; y < PUZZLE_DIM; y++) {
            for (int x = 0; x < PUZZLE_DIM; x++) {
                int c = input.read();
                if (c == '#') {
                    walls[y][x] = true;
                } else if (c == '^') {
                    visited[y][x] = true;
                    guard = new NorthwardGuard(new Position(x, y));
                }
            }
            // Read newline character(s)
            input.readLine();
        }
        Objects.requireNonNull(guard);

        int visitedCount = 1;
        while (true) {
            Guard futureGuard = guard.stepForward();
            final Position p = futureGuard.position();
            if (futureGuard.isOutOfBounds()) {
                break;
            } else if (walls[p.y()][p.x()]) {
                futureGuard = guard.turnRight();
            } else if (!visited[p.y()][p.x()]) {
                visited[p.y()][p.x()] = true;
                visitedCount++;
            }
            guard = futureGuard;
        }
        return Integer.toString(visitedCount);
    }
}
