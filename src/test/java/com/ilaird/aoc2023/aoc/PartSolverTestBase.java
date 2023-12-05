package com.ilaird.aoc2023.aoc;

import org.junit.jupiter.api.Test;
import org.springframework.test.util.ReflectionTestUtils;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.ilaird.aoc2023.aoc.PartSolverTestBase;

public abstract class PartSolverTestBase<T> {

    protected Solver unit;
    protected Iterable<T> parser;
    protected int answer;
    protected String[] sample;
    private boolean mocksInitialized = false;

    protected void initMocks() {
        if (mocksInitialized)
            return;
        ReflectionTestUtils.setField(parser, "puzzleInput", sample);
        ReflectionTestUtils.setField(unit, "input", parser);
        mocksInitialized = true;
    }

    @Test
    public void testSolve() throws SolverError {
        // given
        initMocks();

        // When
        var result = unit.solve();

        // Then
        assertEquals(answer, result);
    }
}
