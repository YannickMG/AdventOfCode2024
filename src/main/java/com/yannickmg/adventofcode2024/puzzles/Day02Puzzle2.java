package com.yannickmg.adventofcode2024.puzzles;

import com.yannickmg.adventofcode2024.Puzzle;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Day02Puzzle2 implements Puzzle {

    @Override
    public String solve(BufferedReader input) throws IOException {
        String line = input.readLine();
        int safeReportCount = 0;
        while (line != null) {
            int[] fullReport = Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray();
            if (reportHasSafeVariation(fullReport)) {
                safeReportCount++;
            }
            line = input.readLine();
        }
        return Integer.toString(safeReportCount);
    }

    private boolean reportHasSafeVariation(int[] fullReport) {
        int variations = 0;
        boolean safe = isSafe(fullReport);
        while (!safe && variations < fullReport.length) {
            int skippedIndex = variations;
            safe = isSafe(IntStream.range(0, fullReport.length).filter(i -> i != skippedIndex).map(i -> fullReport[i]).toArray());
            variations++;
        }
        return safe;
    }

    private boolean isSafe(int[] report) {
        return getReportValidator(report).map(
                validator -> {
                    int i = 2;
                    while (i <= report.length - 1 && validator.test(report[i])) {
                        i++;
                    }
                    return i == report.length;
                }
        ).orElse(false);
    }

    Optional<ReportValidator> getReportValidator(int[] report) {
        // Cannot process a single value report
        if (report.length < 2) {
            return Optional.empty();
        }
        int firstDiff = report[0] - report[1];
        Predicate<Integer> increasing = diff -> diff < 0 && diff > -4;
        Predicate<Integer> decreating = diff -> diff > 0 && diff < 4;
        return Stream.of(increasing, decreating).filter(pred -> pred.test(firstDiff)).map(pred -> new ReportValidator(report[1], pred)).findAny();
    }

    private static class ReportValidator implements Predicate<Integer> {
        private int prevValue;
        private final Predicate<Integer> safetyValidator;

        private ReportValidator(int prevValue, Predicate<Integer> safetyValidator) {
            this.prevValue = prevValue;
            this.safetyValidator = safetyValidator;
        }

        @Override
        public boolean test(Integer currentValue) {
            int diff = prevValue - currentValue;
            prevValue = currentValue;
            return safetyValidator.test(diff);
        }
    }
}
