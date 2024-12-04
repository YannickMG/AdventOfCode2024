package com.yannickmg.adventofcode2024.puzzles;

import com.yannickmg.adventofcode2024.Puzzle;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class DayThreePuzzleTwo implements Puzzle {

    @Override
    public String solve(BufferedReader input) throws IOException {
        StringBuilder instructions = new StringBuilder();
        String line = input.readLine();
        while (line != null) {
            instructions.append(line);
            line = input.readLine();
        }
        Matcher matcher = Pattern.compile("(do\\(\\))|(don't\\(\\))|(mul\\((\\d+),(\\d+)\\))").matcher(instructions);

        long sum = 0;
        boolean shouldSum = true;
        while (matcher.find()) {
            if (Objects.nonNull(matcher.group(1))) {
                shouldSum = true;
            } else if (Objects.nonNull(matcher.group(2))) {
                shouldSum = false;
            } else if (shouldSum){
                long a = Long.parseLong(matcher.group(4));
                long b = Long.parseLong(matcher.group(5));
                sum += a * b;
            }
        }

        return Long.toString(sum);
    }

}
