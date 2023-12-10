package com.ilaird.aoc2023.day09;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ilaird.aoc2023.aoc.AocSolution;
import com.ilaird.aoc2023.aoc.Solver;
import com.ilaird.aoc2023.aoc.SolverError;

@Component
@AocSolution(day = 9, part = 1)
class D9P1Solver implements Solver {

    @Autowired
    private Iterable<Integer[]> input;

    @Override
    public long solve() throws SolverError {
        var ret = 0;
        for (Integer[] n : input)
            ret += getEstimate(n);
        return ret;
    }

    long getEstimate(Integer[] n) {
        return new Estimator(n, null).getEstimate();
    }
}
