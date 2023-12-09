package com.ilaird.aoc2023.day07;

import org.junit.jupiter.api.BeforeEach;

import com.ilaird.aoc2023.aoc.PartSolverTestBase;

class D7P1SolverTest extends PartSolverTestBase<Hand> {

    @BeforeEach
    void setUp() {
        unit = new D7P1Solver();
        parser = new D7P1Parser();
        answer = 6440;
        sample = new String[] {
            "32T3K 765",
            "T55J5 684",
            "KK677 28",
            "KTJJT 220",
            "QQQJA 483"
        };

        initMocks();
    }
}
