package com.yannickmg.adventofcode2024.puzzles;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

class DayOnePuzzleOneTest {

    PuzzleTestRunner runner = new PuzzleTestRunner();

    @Test
    void solve() throws IOException {
        runner.runPuzzleTest("day1-puzzle1", (input, expectedAnswer)-> {
            assertThat(new DayOnePuzzleOne().solve(input)).isEqualTo(expectedAnswer);
        });
    }
}