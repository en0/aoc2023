package com.ilaird.aoc2023.day07;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.ilaird.aoc2023.aoc.AocSolution;
import com.ilaird.aoc2023.aoc.SolverError;

@Component
@AocSolution(day = 7, part = 2)
class D7P2Solver extends D7P1Solver {

    @Autowired
    @Qualifier("d7p2")
    private Iterable<Hand> input;

    @Override
    public long solve() throws SolverError {
        return solveWithInput(input);
    }
}
