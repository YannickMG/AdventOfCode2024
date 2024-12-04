package com.yannickmg.adventofcode2024.puzzles;

import com.yannickmg.adventofcode2024.Puzzle;
import com.yannickmg.adventofcode2024.lists.LeftRightLists;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Day01Puzzle2 implements Puzzle {
    @Override
    public String solve(BufferedReader input) throws IOException {
        LeftRightLists lists = new LeftRightLists();
        lists.buildLists(input);
        Map<Integer, Long> rightListCounts =
                lists.getRightList().stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        long similarityScore = lists.getLeftList().stream().mapToLong(i ->
                i * rightListCounts.getOrDefault(i, 0L)
        ).sum();
        return Long.toString(similarityScore);
    }
}
