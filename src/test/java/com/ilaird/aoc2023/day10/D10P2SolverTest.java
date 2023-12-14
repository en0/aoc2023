package com.ilaird.aoc2023.day10;

import org.junit.jupiter.api.BeforeEach;

import com.ilaird.aoc2023.aoc.CharPoint;
import com.ilaird.aoc2023.aoc.CharPointPuzzleInput;
import com.ilaird.aoc2023.aoc.PartSolverTestBase;

class D10P2SolverTest extends PartSolverTestBase<CharPoint> {

    @BeforeEach
    void setUp() {
        unit = new D10P2Solver();
        parser = new CharPointPuzzleInput();
        answer = 10;
        sample = new String[] {
            "FF7FSF7F7F7F7F7F---7",
            "L|LJ||||||||||||F--J",
            "FL-7LJLJ||||||LJL-77",
            "F--JF--7||LJLJIF7FJ-",
            "L---JF-JLJIIIIFJLJJ7",
            "|F|F-JF---7IIIL7L|7|",
            "|FFJF7L7F-JF7IIL---7",
            "7-L-JL7||F7|L7F-7F7|",
            "L.L7LFJ|||||FJL7||LJ",
            "L7JLJL-JLJLJL--JLJ.L"
        };

        initMocks();
    }
}
