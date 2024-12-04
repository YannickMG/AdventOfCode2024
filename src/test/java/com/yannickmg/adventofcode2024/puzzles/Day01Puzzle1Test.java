package com.yannickmg.adventofcode2024.puzzles;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

class Day01Puzzle1Test {

    PuzzleTestRunner runner = new PuzzleTestRunner();

    @Test
    void solve() throws IOException {
        runner.runPuzzleTest("day1-puzzle1", (input, expectedAnswer)-> {
            assertThat(new Day01Puzzle1().solve(input)).isEqualTo(expectedAnswer);
        });
    }
}