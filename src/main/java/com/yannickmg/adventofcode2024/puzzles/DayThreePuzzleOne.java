package com.yannickmg.adventofcode2024.puzzles;

import com.yannickmg.adventofcode2024.Puzzle;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.regex.Pattern;

public class DayThreePuzzleOne implements Puzzle {

    @Override
    public String solve(BufferedReader input) throws IOException {
        StringBuilder instructions = new StringBuilder();
        String line = input.readLine();
        while (line != null) {
            instructions.append(line);
            line = input.readLine();
        }

        return Long.toString(Pattern.compile("mul\\((\\d+),(\\d+)\\)").matcher(instructions).results().mapToInt(result -> {
            int a = Integer.parseInt(result.group(1));
            int b = Integer.parseInt(result.group(2));
            return a * b;
        }).sum());
    }

}
