package com.ilaird.aoc2023.day06;

import org.junit.jupiter.api.BeforeEach;

import com.ilaird.aoc2023.aoc.PartSolverTestBase;

class D6P2SolverTest extends PartSolverTestBase<Race> {

    @BeforeEach
    void setUp() {
        unit = new D6P2Solver();
        parser = new D6P2Parser();
        answer = 71503;
        sample = new String[] {
            "Time:      7  15   30",
            "Distance:  9  40  200"
        };

        initMocks();
    }
}
