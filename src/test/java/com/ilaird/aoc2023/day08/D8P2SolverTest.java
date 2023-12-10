package com.ilaird.aoc2023.day08;

import org.junit.jupiter.api.BeforeEach;

import com.ilaird.aoc2023.aoc.PartSolverTestBase;
import com.ilaird.aoc2023.aoc.StringPuzzleInput;

class D8P2SolverTest extends PartSolverTestBase<String> {

    @BeforeEach
    void setUp() {
        unit = new D8P2Solver();
        parser = new StringPuzzleInput();
        answer = 6;
        sample = new String[] {
            "LR",
            "",
            "11A = (11B, XXX)",
            "11B = (XXX, 11Z)",
            "11Z = (11B, XXX)",
            "22A = (22B, XXX)",
            "22B = (22C, 22C)",
            "22C = (22Z, 22Z)",
            "22Z = (22B, 22B)",
            "XXX = (XXX, XXX)"
        };

        initMocks();
    }
}