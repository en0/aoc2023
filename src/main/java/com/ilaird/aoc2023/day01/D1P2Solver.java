package com.ilaird.aoc2023.day01;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ilaird.aoc2023.aoc.AocSolution;
import com.ilaird.aoc2023.aoc.PuzzleInput;
import com.ilaird.aoc2023.aoc.SolverError;

@Component
@AocSolution(day = 1, part = 2)
class D1P2Solver extends D1P1Solver {

    @Autowired
    PuzzleInput<String> input;

    @Override
    public int solve() throws SolverError {
        int total = 0;
        var wordDigits = Map.of(
            "one", '1', "two", '2', "three", '3',
            "four", '4', "five", '5', "six", '6',
            "seven", '7', "eight", '8', "nine", '9'
        );

        var wordDigitsReversed = new HashMap<String, Character>();
        for (String word : wordDigits.keySet())
            wordDigitsReversed.put(revStr(word), wordDigits.get(word));

        for(String line : input) {
            char[] digits = new char[2];
            digits[0] = findDigitWithWords(line, wordDigits);
            digits[1] = findDigitWithWords(revStr(line), wordDigitsReversed);
            total += Integer.parseInt(new String(digits));
        }

        return total;
    }

    private char findDigitWithWords(String line, Map<String, Character> words) throws SolverError {

        var firstLetterSet = new HashSet<Character>();

        // A little premature optimization...
        for (String word : words.keySet())
            firstLetterSet.add(word.charAt(0));

        for (int i = 0; i < line.length(); i++) {
            var c = line.charAt(i);
            if (Character.isDigit(c)) {
                return c;
            } else if (firstLetterSet.contains(c)) {
                var sub = line.substring(i);
                for (String word : words.keySet()) {
                    if (sub.startsWith(word)) {
                        return words.get(word);
                    }
                }
            }
        }
        throw new SolverError("Couldn't find digit or word on line: " + line);
    }
}
