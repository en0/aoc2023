package com.ilaird.aoc2023.day10;

import org.junit.jupiter.api.BeforeEach;

import com.ilaird.aoc2023.aoc.CharPoint;
import com.ilaird.aoc2023.aoc.CharPointPuzzleInput;
import com.ilaird.aoc2023.aoc.PartSolverTestBase;

class D10P1SolverTest extends PartSolverTestBase<CharPoint> {

    @BeforeEach
    void setUp() {
        unit = new D10P1Solver();
        parser = new CharPointPuzzleInput();
        answer = 8;
        sample = new String[] {
            "7-F7-",
            ".FJ|7",
            "SJLL7",
            "|F--J",
            "LJ.LJ"
        };

        initMocks();
    }
}
