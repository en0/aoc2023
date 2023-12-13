package com.ilaird.aoc2023.day10;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ilaird.aoc2023.aoc.AocSolution;
import com.ilaird.aoc2023.aoc.Solver;
import com.ilaird.aoc2023.aoc.SolverError;

@Component
@AocSolution(day = 10, part = 2)
class D10P2Solver implements Solver {

    @Autowired
    private Iterable<String> input;

    @Override
    public long solve() throws SolverError {
        var ret = 0L;
        for (String line : input) {
            ret += line.length();
        }
        return ret;
    }
}