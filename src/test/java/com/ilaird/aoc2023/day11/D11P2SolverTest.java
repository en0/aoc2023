package com.ilaird.aoc2023.day11;

import org.junit.jupiter.api.BeforeEach;

import com.ilaird.aoc2023.aoc.PartSolverTestBase;
import com.ilaird.aoc2023.aoc.StringPuzzleInput;

class D11P2SolverTest extends PartSolverTestBase<String> {

    @BeforeEach
    void setUp() {
        unit = new D11P2Solver();
        parser = new StringPuzzleInput();
        //answer = 8410;
        answer = 82000210; // the sample didn't use the same expansion as the
                           // real puzzle. My tests must pass!
        sample = new String[] {
            "...#......",
            ".......#..",
            "#.........",
            "..........",
            "......#...",
            ".#........",
            ".........#",
            "..........",
            ".......#..",
            "#...#....."
        };

        initMocks();
    }
}
