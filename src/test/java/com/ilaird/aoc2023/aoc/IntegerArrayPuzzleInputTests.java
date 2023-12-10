package com.ilaird.aoc2023.aoc;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class IntegerArrayPuzzleInputTests {

    @Test
    void parserCanParse() throws TransformError {
        var parser = new IntegerArrayPuzzleInput();
        var actual = parser.transform("1  -2 \t3 4");
        var expected = new int[] {1, -2, 3, 4};
        for (int i = 0; i < expected.length; i++)
            assertEquals(expected[i], actual[i]);
    }
}
