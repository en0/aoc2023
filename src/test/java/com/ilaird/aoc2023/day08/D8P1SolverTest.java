package com.ilaird.aoc2023.day08;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.ilaird.aoc2023.aoc.PartSolverTestBase;
import com.ilaird.aoc2023.aoc.StringPuzzleInput;

class D8P1SolverTest extends PartSolverTestBase<String> {

    @BeforeEach
    void setUp() {
        unit = new D8P1Solver();
        parser = new StringPuzzleInput();
        answer = 2;
        sample = new String[] {
            "RL",
            "",
            "AAA = (BBB, CCC)",
            "BBB = (DDD, EEE)",
            "CCC = (ZZZ, GGG)",
            "DDD = (DDD, DDD)",
            "EEE = (EEE, EEE)",
            "GGG = (GGG, GGG)",
            "ZZZ = (ZZZ, ZZZ)"
        };

        initMocks();
    }

    @Test
    void testMoveIterator() {
        var mi = new MoveIterator("LLR");
        assertEquals(0, mi.next());
        assertEquals(0, mi.next());
        assertEquals(1, mi.next());
        assertEquals(0, mi.next());
        assertEquals(0, mi.next());
        assertEquals(1, mi.next());

    }

    @Test
    void testMoveIteratorInit() {
        var mi = new MoveIterator(parser.iterator().next());
        assertEquals(1, mi.next());
        assertEquals(0, mi.next());
        assertEquals(1, mi.next());
        assertEquals(0, mi.next());
    }
}
