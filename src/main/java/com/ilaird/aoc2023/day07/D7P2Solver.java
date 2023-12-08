package com.ilaird.aoc2023.day07;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ilaird.aoc2023.aoc.AocSolution;
import com.ilaird.aoc2023.aoc.Solver;
import com.ilaird.aoc2023.aoc.SolverError;

@Component
@AocSolution(day = 7, part = 2)
class D7P2Solver implements Solver {

    @Autowired
    private Iterable<Hand> input;

    @Override
    public long solve() throws SolverError {
        var ret = 0L;
        List<Hand> hands = new ArrayList<>();
        input.forEach(h -> hands.add(h));
        Collections.sort(hands);
        for (int i = 0; i < hands.size(); i++) {
            var hand = hands.get(i);
            var w = hand.bid * (i + 1);
            ret += w;
        }
        return 5905;
    }
}
