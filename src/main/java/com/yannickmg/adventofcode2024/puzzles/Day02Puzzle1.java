package com.yannickmg.adventofcode2024.puzzles;

import com.yannickmg.adventofcode2024.Puzzle;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Objects;
import java.util.function.Predicate;

public class Day02Puzzle1 implements Puzzle {

    @Override
    public String solve(BufferedReader input) throws IOException {
        String line = input.readLine();
        int safeReportCount = 0;
        while (line != null) {
            String[] report = line.split(" ");
            Predicate<String> validator = getReportValidator(report);
            if (Objects.nonNull(validator)) {
                int i = 2;
                while (i <= report.length - 1 && validator.test(report[i])) {
                    i++;
                }
                if (i == report.length) {
                    safeReportCount++;
                }
            }
            line = input.readLine();
        }
        return Integer.toString(safeReportCount);
    }

    Predicate<String> getReportValidator(String[] report) {
        // Cannot process a single value report
        if (report.length < 2) {
            return null;
        }
        int firstValue = Integer.parseInt(report[0]);
        int secondValue = Integer.parseInt(report[1]);
        int firstDiff = firstValue - secondValue;
        return switch (firstDiff) {
            case -1, -2, -3 ->  new IncreasingReportValidator(secondValue);
            case 1, 2, 3 ->  new DecreasingReportValidator(secondValue);
            default -> null;
        };
    }

    private static class IncreasingReportValidator implements Predicate<String> {
        int prevValue;

        private IncreasingReportValidator(int prevValue) {
            this.prevValue = prevValue;
        }

        @Override
        public boolean test(String s) {
            int currentValue = Integer.parseInt(s);
            int diff = prevValue - currentValue;
            prevValue = currentValue;
            return diff < 0  && diff > -4;
        }
    }

    private static class DecreasingReportValidator implements Predicate<String> {
        int prevValue;
        public DecreasingReportValidator(int prevValue) {
            this.prevValue = prevValue;
        }

        @Override
        public boolean test(String s) {
            int currentValue = Integer.parseInt(s);
            int diff = prevValue - currentValue;
            prevValue = currentValue;
            return diff > 0  && diff < 4;
        }
    }
}
