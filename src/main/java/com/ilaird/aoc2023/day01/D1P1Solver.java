package com.ilaird.aoc2023.day01;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ilaird.aoc2023.aoc.AocSolution;
import com.ilaird.aoc2023.aoc.PuzzleInput;
import com.ilaird.aoc2023.aoc.Solver;
import com.ilaird.aoc2023.aoc.SolverError;

@Component
@AocSolution(day = 1, part = 1)
class D1P1Solver implements Solver {

    @Autowired
    private PuzzleInput<String> input;

    @Override
    public int solve() throws SolverError {

        int total = 0;
        for (String line : input) {
            char[] digits = new char[2];
            digits[0] = findDigit(line);
            digits[1] = findDigit(revStr(line));
            total += Integer.parseInt(new String(digits));
        }

        return total;
    }

    protected String revStr(String line) {
        var revLine = new StringBuilder(line).reverse();
        return revLine.toString();
    }

    private char findDigit(String line) throws SolverError {
        for (int i = 0; i < line.length(); i++) {
            var c = line.charAt(i);
            if (Character.isDigit(c)) {
                return c;
            }
        }
        throw new SolverError("Couldn't find digit on line: " + line);
    }
}
