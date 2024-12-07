package com.yannickmg.adventofcode2024.puzzles;

import com.yannickmg.adventofcode2024.Puzzle;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Day05Puzzle1 implements Puzzle {

    @Override
    public String solve(BufferedReader input) throws IOException {
        Map<String, Set<String>> precedingPages = new HashMap<>();
        String line = input.readLine();
        while (!line.isBlank()) {
            String[] tokens = line.split("\\|");
            precedingPages.computeIfAbsent(tokens[1], _-> new HashSet<>()).add(tokens[0]);
            line = input.readLine();
        }

        line = input.readLine();
        long sum = 0;
        while (line != null) {
            String[] pages = line.split(",");
            Set<String> printedAfter = new HashSet<>();
            for (int i = pages.length - 1; i >= 0; i--) {
                String page = pages[i];
                if (precedingPages.containsKey(page) && precedingPages.get(page).stream().anyMatch(printedAfter::contains)) {
                    break;
                }
                printedAfter.add(page);
            }
            if (printedAfter.size() == pages.length) {
                sum += Integer.parseInt(pages[pages.length / 2]);
            }
            line = input.readLine();
        }

        return Long.toString(sum);
    }
}
