package com.ilaird.aoc2023.day06;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.ilaird.aoc2023.aoc.AocSolution;
import com.ilaird.aoc2023.aoc.Solver;
import com.ilaird.aoc2023.aoc.SolverError;

@Component
@AocSolution(day = 6, part = 2)
class D6P2Solver implements Solver {

    @Autowired
    @Qualifier("d6p2")
    private Iterable<Race> input;

    @Override
    public long solve() throws SolverError {
        var ret = 1L;
        for (Race race : input)
            ret *= race.waysToWin();
        return ret;
    }
}
