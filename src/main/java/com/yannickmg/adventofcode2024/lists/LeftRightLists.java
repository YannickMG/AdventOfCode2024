package com.yannickmg.adventofcode2024.lists;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LeftRightLists {
    private final List<Integer> leftList = new ArrayList<>();
    private final List<Integer> rightList = new ArrayList<>();

    public void buildLists(BufferedReader input) throws IOException {
        while(true) {
            String line = input.readLine();
            if (line == null) break;
            String[] numbers = line.split("\s+");
            leftList.add(Integer.parseInt(numbers[0]));
            rightList.add(Integer.parseInt(numbers[1]));
        }
    }

    public List<Integer> getLeftList() {
        return leftList;
    }

    public List<Integer> getRightList() {
        return rightList;
    }

}
