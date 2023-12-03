package com.ilaird.aoc2023.day00;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ilaird.aoc2023.aoc.AocSolution;
import com.ilaird.aoc2023.aoc.PuzzleInput;
import com.ilaird.aoc2023.aoc.Solver;
import com.ilaird.aoc2023.aoc.SolverError;

@Component
@AocSolution(day = 0, part = 1)
class D0P2Solver implements Solver {

    @Autowired
    private PuzzleInput<String> input;

    @Override
    public int solve() throws SolverError {
        return input.hashCode();
    }
}
