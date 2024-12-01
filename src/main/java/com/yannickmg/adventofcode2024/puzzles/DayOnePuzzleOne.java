package com.yannickmg.adventofcode2024.puzzles;

import com.yannickmg.adventofcode2024.Puzzle;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class DayOnePuzzleOne implements Puzzle {

    private final List<Integer> leftList = new ArrayList<>();
    private final List<Integer> rightList = new ArrayList<>();

    @Override
    public String solve(BufferedReader input) throws IOException {
        buildLists(input);
        leftList.sort(Integer::compareTo);
        rightList.sort(Integer::compareTo);
        int totalDifference = IntStream.range(0, leftList.size()).map(i -> Math.abs(leftList.get(i) - rightList.get(i))).sum();
        return Integer.toString(totalDifference);
    }

    private void buildLists(BufferedReader input) throws IOException {
        while(true) {
            String line = input.readLine();
            if (line == null) break;
            String[] numbers = line.split("\s+");
            leftList.add(Integer.parseInt(numbers[0]));
            rightList.add(Integer.parseInt(numbers[1]));
        }
    }

}
