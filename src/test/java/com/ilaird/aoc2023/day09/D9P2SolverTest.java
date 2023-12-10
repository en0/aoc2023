package com.ilaird.aoc2023.day09;

import org.junit.jupiter.api.BeforeEach;

import com.ilaird.aoc2023.aoc.IntegerArrayPuzzleInput;
import com.ilaird.aoc2023.aoc.PartSolverTestBase;

class D9P2SolverTest extends PartSolverTestBase<Integer[]> {

    @BeforeEach
    void setUp() {
        unit = new D9P2Solver();
        parser = new IntegerArrayPuzzleInput();
        answer = 2;
        sample = new String[] {
            "0 3 6 9 12 15",
            "1 3 6 10 15 21",
            "10 13 16 21 30 45"
        };

        initMocks();
    }
}
