package com.ilaird.aoc2023.day09;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.ilaird.aoc2023.aoc.IntegerArrayPuzzleInput;
import com.ilaird.aoc2023.aoc.PartSolverTestBase;

class D9P1SolverTest extends PartSolverTestBase<Integer[]> {

    @BeforeEach
    void setUp() {
        unit = new D9P1Solver();
        parser = new IntegerArrayPuzzleInput();
        answer = 114;
        sample = new String[] {
            "0 3 6 9 12 15",
            "1 3 6 10 15 21",
            "10 13 16 21 30 45"
        };

        initMocks();
    }

    @Test
    void testEstimator() {
        var e = new Estimator(new Integer[] {1, 3, 6, 10, 15, 21}, null);
        assertEquals(28, e.getEstimate());
    }

    @Test
    void testEstimatorThatHasToGoAllTheWayDown() {
        var e = new Estimator(new Integer[] {1, 3}, null);
        assertEquals(5, e.getEstimate());
    }
}
