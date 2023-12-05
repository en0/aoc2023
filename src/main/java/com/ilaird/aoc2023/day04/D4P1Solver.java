package com.ilaird.aoc2023.day04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ilaird.aoc2023.aoc.AocSolution;
import com.ilaird.aoc2023.aoc.Solver;
import com.ilaird.aoc2023.aoc.SolverError;

@Component
@AocSolution(day = 4, part = 1)
class D4P1Solver implements Solver {

    @Autowired
    private Iterable<ScratchCard> input;

    @Override
    public int solve() throws SolverError {
        var ret = 0;
        for (ScratchCard card : input)
            ret += Math.pow(2, card.getValue() - 1);
        return ret;
    }
}
