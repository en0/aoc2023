package com.ilaird.aoc2023.day09;

import org.springframework.stereotype.Component;

import com.ilaird.aoc2023.aoc.AocSolution;

@Component
@AocSolution(day = 9, part = 2)
class D9P2Solver extends D9P1Solver {
    @Override
    long getEstimate(Integer[] n) {
        for (int i = 0; i < n.length/2; i++) {
            var tmp = n[i];
            n[i] = n[n.length - i - 1];
            n[n.length - i - 1] = tmp;
        }
        return new Estimator(n, null).getEstimate();
    }
}
