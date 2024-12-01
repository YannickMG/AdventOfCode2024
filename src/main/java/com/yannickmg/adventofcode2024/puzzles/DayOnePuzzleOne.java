package com.yannickmg.adventofcode2024.puzzles;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class DayOnePuzzleOne {

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader( DayOnePuzzleOne.class.getResourceAsStream("/inputs/day1-puzzle1.txt")))) {
            DayOnePuzzleOne puzzle = new DayOnePuzzleOne(reader);
            System.out.println(puzzle.solve());
        }
    }

    private final BufferedReader input;
    private final List<Integer> leftList = new ArrayList<>();
    private final List<Integer> rightList = new ArrayList<>();

    public DayOnePuzzleOne(BufferedReader input) {
        this.input = input;
    }

    private String solve() throws IOException {
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
