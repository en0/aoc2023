package com.ilaird.aoc2023.day01;

import org.junit.jupiter.api.BeforeEach;

import com.ilaird.aoc2023.aoc.PartSolverTestBase;
import com.ilaird.aoc2023.aoc.StringPuzzleInput;

class D1P2SolverTest extends PartSolverTestBase<String> {
    @BeforeEach
    void setUp() {
        unit = new D1P2Solver();
        parser = new StringPuzzleInput();
        answer = 281;
        sample = new String[] {
            "two1nine",
            "eightwothree",
            "abcone2threexyz",
            "xtwone3four",
            "4nineeightseven2",
            "zoneight234",
            "7pqrstsixteen"
        };
    }
}
