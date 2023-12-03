package com.ilaird.aoc2023.day03;

import org.junit.jupiter.api.BeforeEach;

import com.ilaird.aoc2023.aoc.PartSolverTestBase;

class D3P2SolverTest extends PartSolverTestBase<GridRow> {

    @BeforeEach
    void setUp() {
        unit = new D3P2Solver();
        parser = new D3PuzzleInput();
        answer = 467835;
        sample = new String[] {
            "467..114..",
            "...*......",
            "..35..633.",
            "......#...",
            "617*......",
            ".....+.58.",
            "..592.....",
            "......755.",
            "...$.*....",
            ".664.598.."
        };

        initMocks();
    }
}
