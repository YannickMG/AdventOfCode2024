package com.yannickmg.adventofcode2024.puzzles;

import com.yannickmg.adventofcode2024.Puzzle;
import com.yannickmg.adventofcode2024.lists.LeftRightLists;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;
import java.util.stream.IntStream;

public class DayOnePuzzleOne implements Puzzle {

    @Override
    public String solve(BufferedReader input) throws IOException {
        LeftRightLists lists = new LeftRightLists();
        lists.buildLists(input);
        List<Integer> leftList = lists.getLeftList();
        List<Integer> rightList = lists.getRightList();
        leftList.sort(Integer::compareTo);
        rightList.sort(Integer::compareTo);
        int totalDifference = IntStream.range(0, leftList.size()).map(i -> Math.abs(leftList.get(i) - rightList.get(i))).sum();
        return Integer.toString(totalDifference);
    }

}
