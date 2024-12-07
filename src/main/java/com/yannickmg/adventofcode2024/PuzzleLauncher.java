package com.yannickmg.adventofcode2024;

import com.yannickmg.adventofcode2024.puzzles.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class PuzzleLauncher {

    private static final List<List<Puzzle>> puzzles = List.of(
            List.of(new Day01Puzzle1(), new Day01Puzzle2()),
            List.of(new Day02Puzzle1(), new Day02Puzzle2()),
            List.of(new Day03Puzzle1(), new Day03Puzzle2()),
            List.of(new Day04Puzzle1(), new Day04Puzzle2()),
            List.of(new Day05Puzzle1(), new Day05Puzzle2()),
            List.of(new Day06Puzzle1())
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
            Puzzle puzzle = puzzles.get(day - 1).get(puzzleNumber - 1);
            try (BufferedReader reader = new BufferedReader(new InputStreamReader( PuzzleLauncher.class.getResourceAsStream(input)))) {
                System.out.println(puzzle.solve(reader));
            }
        } catch (NumberFormatException e) {
            printUsage();
            System.exit(1);
        } catch (ArrayIndexOutOfBoundsException e ) {
            System.out.println("Invalid puzzle identifier.");
            System.exit(1);
        }
    }

    private static void printUsage() {
        System.out.println("Usage: java PuzzleLauncher day puzzleNumber");
    }
}
