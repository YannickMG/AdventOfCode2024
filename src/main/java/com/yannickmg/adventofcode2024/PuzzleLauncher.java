package com.yannickmg.adventofcode2024;

import com.yannickmg.adventofcode2024.puzzles.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.Optional;

public class PuzzleLauncher {

    private static final Map<Integer, Map<Integer, Puzzle>> puzzles = Map.of(
            1, Map.of(1, new DayOnePuzzleOne(), 2, new DayOnePuzzleTwo()),
            2, Map.of(1, new DayTwoPuzzleOne(), 2, new DayTwoPuzzleTwo())
    );

    public static void main(String[] args) throws IOException {
        if (args.length != 2 ) {
            printUsage();
            System.exit(1);
        }
        try {
            int day = Integer.parseInt(args[0]);
            int puzzleNumber = Integer.parseInt(args[1]);
            String input = "/inputs/day" + day + "-puzzle" + puzzleNumber + ".txt";
            Puzzle puzzle = getPuzzle(day, puzzleNumber);
            if (puzzle != null) {
                try (BufferedReader reader = new BufferedReader(new InputStreamReader( PuzzleLauncher.class.getResourceAsStream(input)))) {
                    System.out.println(puzzle.solve(reader));
                }
            } else {
                System.out.println("Invalid puzzle identifier.");
                System.exit(1);
            }

        } catch (NumberFormatException e) {
            printUsage();
        }
    }

    private static Puzzle getPuzzle(int day, int puzzle) {
        return Optional.ofNullable(puzzles.get(day)).map(dayPuzzles -> dayPuzzles.get(puzzle)).orElse(null);
    }

    private static void printUsage() {
        System.out.println("Usage: java PuzzleLauncher day puzzleNumber");
    }
}
