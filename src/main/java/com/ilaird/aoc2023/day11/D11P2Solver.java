package com.ilaird.aoc2023.day11;

import org.springframework.stereotype.Component;

import com.ilaird.aoc2023.aoc.AocSolution;

@Component
@AocSolution(day = 11, part = 2)
class D11P2Solver extends D11P1Solver {

    @Override
    int getExpansion() {
        return 999999;
    }
}
