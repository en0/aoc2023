package com.ilaird.aoc2023.day05;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ilaird.aoc2023.aoc.AocSolution;
import com.ilaird.aoc2023.aoc.Solver;
import com.ilaird.aoc2023.aoc.SolverError;

@Component
@AocSolution(day = 5, part = 1)
class D5P1Solver implements Solver {

    @Autowired
    private Iterable<Almanac> input;

    @Override
    public long solve() throws SolverError {
        var ret = Long.MAX_VALUE;
        var almanac = input.iterator().next();
        for (var seed : almanac.seeds) {
            var v = seed;
            for (var map : almanac.maps)
                v = map.getTarget(v);
            ret = Math.min(v, ret);
        }
        return ret;
    }
}
