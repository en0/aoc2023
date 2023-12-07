package com.ilaird.aoc2023.day04;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ilaird.aoc2023.aoc.AocSolution;
import com.ilaird.aoc2023.aoc.Solver;
import com.ilaird.aoc2023.aoc.SolverError;

@Component
@AocSolution(day = 4, part = 2)
class D4P2Solver implements Solver {

    @Autowired
    private Iterable<ScratchCard> input;

    @Override
    public long solve() throws SolverError {

        var cards = new ArrayList<ScratchCard>();
        input.forEach(c -> cards.add(c));

        var multipliers = new int[cards.size()];
        Arrays.fill(multipliers, 1);

        for (int i = 0; i < multipliers.length; i++) {
            var m = multipliers[i];
            var c = cards.get(i);
            for (int j = c.getValue(); j > 0; j--)
                multipliers[i + j] += m;
        }

        var ret = 0;
        for (int i : multipliers) ret += i;
        return ret;
    }
}
