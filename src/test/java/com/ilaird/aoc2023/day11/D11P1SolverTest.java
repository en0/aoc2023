package com.ilaird.aoc2023.day11;

import org.junit.jupiter.api.BeforeEach;
import com.ilaird.aoc2023.aoc.PartSolverTestBase;
import com.ilaird.aoc2023.aoc.StringPuzzleInput;

class D11P1SolverTest extends PartSolverTestBase<String> {

    @BeforeEach
    void setUp() {
        unit = new D11P1Solver();
        parser = new StringPuzzleInput();
        answer = 374;
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
