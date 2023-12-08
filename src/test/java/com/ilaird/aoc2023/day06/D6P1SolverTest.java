package com.ilaird.aoc2023.day06;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.ilaird.aoc2023.aoc.PartSolverTestBase;

class D6P1SolverTest extends PartSolverTestBase<Race> {

    @BeforeEach
    void setUp() {
        unit = new D6P1Solver();
        parser = new D6P1Parser();
        answer = 288;
        sample = new String[] {
            "Time:      7  15   30",
            "Distance:  9  40  200"
        };

        initMocks();
    }

    @Test
    void testParser() {
        var expected = List.of(
            new Race() {{ time=7; distance=9; }},
            new Race() {{ time=15; distance=40; }},
            new Race() {{ time=30; distance=200; }}
        );

        var iter = parser.iterator();
        for (int i = 0; i < expected.size(); i++) {
            var e = expected.get(i);
            var a = iter.next();
            assertEquals(e.time, a.time);
            assertEquals(e.distance, a.distance);
        }
    }
}
