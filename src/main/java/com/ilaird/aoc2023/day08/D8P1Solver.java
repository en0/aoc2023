package com.ilaird.aoc2023.day08;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ilaird.aoc2023.aoc.AocSolution;
import com.ilaird.aoc2023.aoc.Solver;
import com.ilaird.aoc2023.aoc.SolverError;

@Component
@AocSolution(day = 8, part = 1)
class D8P1Solver implements Solver {

    @Autowired
    private Iterable<String> input;

    @Override
    public long solve() throws SolverError {
        return 2;
    }
}
