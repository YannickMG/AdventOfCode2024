package com.yannickmg.adventofcode2024.puzzles;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PuzzleTestRunner {
    void runPuzzleTest(String testCaseName, PuzzleTest puzzleTest) throws IOException {
        String inputPath = "/inputs/" + testCaseName + ".txt";
        String answerPath = "/answers/" + testCaseName + ".txt";
        try (BufferedReader input = new BufferedReader(new InputStreamReader( PuzzleTestRunner.class.getResourceAsStream(inputPath)))) {
            try (BufferedReader answerReader = new BufferedReader(new InputStreamReader( PuzzleTestRunner.class.getResourceAsStream(answerPath)))){
                String expectedAnswer =  answerReader.readLine();
                puzzleTest.runPuzzleTest(input, expectedAnswer);
            }
        }
    }
}
