package com.yannickmg.adventofcode2024.puzzles;

import com.yannickmg.adventofcode2024.Puzzle;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Day04Puzzle1 implements Puzzle {

    private static final int[] target = "XMAS".chars().toArray();
    private static final int PUZZLE_DIM = 140;

    @Override
    public String solve(BufferedReader input) throws IOException {
        List<List<Integer>> lines =
                input.lines().map(String::chars).map(IntStream::boxed).map(Stream::toList).toList();
        Stream<List<Integer>> sequences =
                Stream.of(getHorizontalStream(lines),
                        getVerticalStream(lines),
                        getMainDiagonalStream(lines),
                        getAntiDiagonalStream(lines)).reduce(Stream.empty(),
                        Stream::concat).flatMap(sequence -> Stream.of(sequence, sequence.reversed()));
        return Integer.toString(sequences.mapToInt(this::countXmasInLine).sum());
    }

    private static Stream<List<Integer>> getHorizontalStream(List<List<Integer>> lines) {
        return lines.stream();
    }

    private static Stream<List<Integer>> getVerticalStream(List<List<Integer>> lines) {
        return IntStream.range(0, PUZZLE_DIM).mapToObj(x ->
                IntStream.range(0, PUZZLE_DIM).map(y -> lines.get(y).get(x)).boxed().toList()
        );
    }

    private static Stream<List<Integer>> getMainDiagonalStream(List<List<Integer>> lines) {
        return IntStream.range(target.length - PUZZLE_DIM, PUZZLE_DIM - (target.length - 1))
                .mapToObj(rootX ->
                        IntStream.range(Math.max(0, -rootX), Math.min(PUZZLE_DIM, PUZZLE_DIM - rootX))
                                .map(y -> lines.get(y).get(rootX + y)).boxed().toList()
                );
    }

    private static Stream<List<Integer>> getAntiDiagonalStream(List<List<Integer>> lines) {
        return IntStream.range(target.length - 1, PUZZLE_DIM * 2 - (target.length - 1))
                .mapToObj(rootX ->
                        IntStream.range(Math.max(0, rootX - (PUZZLE_DIM - 1)) , Math.min(PUZZLE_DIM, rootX + 1))
                                .map(y -> lines.get(y).get(rootX - y)).boxed().toList()
                );
    }

    int countXmasInLine(List<Integer> line) {
        int count = 0;
        int progress = 0;

        for (int c : line) {
            if (c == target[progress]) {
                progress++;
                if (progress == target.length) {
                    count++;
                    progress = 0;
                }
            } else {
                progress = c == target[0] ? 1 : 0;
            }
        }
        return count;
    }
}
