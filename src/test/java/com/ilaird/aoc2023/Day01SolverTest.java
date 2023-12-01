package com.ilaird.aoc2023;

import org.junit.jupiter.api.Test;
import java.io.BufferedReader;
import java.io.StringReader;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day01SolverTest {

    @Test
    public void testSolvePart1() throws Exception {
        // Given
        String[] input = {
            "1abc2",
            "pqr3stu8vwx",
            "a1b2c3d4e5f",
            "treb7uchet",
        };

        var reader = new BufferedReader(new StringReader(String.join("\n", input)));
        var unit = new Day01Solver();

        // When
        var result = unit.solvePart1(reader);

        // Then
        assertEquals(142, result);
    }

    @Test
    public void testSolvePart2() throws Exception {
        // Given
        String[] input = {
            "two1nine",
            "eightwothree",
            "abcone2threexyz",
            "xtwone3four",
            "4nineeightseven2",
            "zoneight234",
            "7pqrstsixteen"
        };

        var reader = new BufferedReader(new StringReader(String.join("\n", input)));
        var unit = new Day01Solver();

        // When
        var result = unit.solvePart2(reader);

        // Then
        assertEquals(281, result);
    }
}
