package com.yannickmg.adventofcode2024.puzzles;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

class DayOnePuzzleTwoTest {

    PuzzleTestRunner runner = new PuzzleTestRunner();

    @Test
    void solve() throws IOException {
        runner.runPuzzleTest("day1-puzzle2", (input, expectedAnswer)-> {
            assertThat(new DayOnePuzzleTwo().solve(input)).isEqualTo(expectedAnswer);
        });
    }
}
