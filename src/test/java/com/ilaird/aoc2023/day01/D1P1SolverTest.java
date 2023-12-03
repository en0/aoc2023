package com.ilaird.aoc2023.day01;

import org.junit.jupiter.api.BeforeEach;

import com.ilaird.aoc2023.aoc.PartSolverTestBase;
import com.ilaird.aoc2023.aoc.StringPuzzleInput;

class D1P1SolverTest extends PartSolverTestBase<String> {
    @BeforeEach
    void setUp() {
        unit = new D1P1Solver();
        parser = new StringPuzzleInput();
        answer = 142;
        sample = new String[] {
            "1abc2",
            "pqr3stu8vwx",
            "a1b2c3d4e5f",
            "treb7uchet",
        };
    }
}
