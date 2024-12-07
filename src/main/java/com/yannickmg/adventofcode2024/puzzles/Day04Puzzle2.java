package com.yannickmg.adventofcode2024.puzzles;

import com.yannickmg.adventofcode2024.Puzzle;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Day04Puzzle2 implements Puzzle {

    private static final int PUZZLE_DIM = 140;

    @Override
    public String solve(BufferedReader input) throws IOException {
        List<List<Integer>> lines =
                input.lines().map(String::chars).map(IntStream::boxed).map(Stream::toList).toList();
        long xMasCount = IntStream.range(1, PUZZLE_DIM - 1).mapToLong(
                y -> IntStream.range(1, PUZZLE_DIM - 1)
                        .filter(x -> lines.get(y).get(x) == 'A' &&
                                isMS(lines.get(y - 1).get(x - 1) + lines.get(y + 1).get(x + 1)) &&
                                isMS(lines.get(y - 1).get(x + 1) + lines.get(y + 1).get(x - 1))
                        ).peek(x -> System.out.printf("%d,%d:%d%n", x, y,
                                lines.get(y).get(x))).count()
        ).sum();
        return String.valueOf(xMasCount);
    }

    private static boolean isMS(int sum) {
        return sum == 'M' + 'S';
    }
}
