package com.ilaird.aoc2023.day09;

import org.junit.jupiter.api.BeforeEach;

import com.ilaird.aoc2023.aoc.PartSolverTestBase;
import com.ilaird.aoc2023.aoc.StringPuzzleInput;

class D9P1SolverTest extends PartSolverTestBase<String> {

    @BeforeEach
    void setUp() {
        unit = new D9P1Solver();
        parser = new StringPuzzleInput();
        answer = 114;
        sample = new String[] {
            "0 3 6 9 12 15",
            "1 3 6 10 15 21",
            "10 13 16 21 30 45"
        };

        initMocks();
    }
}