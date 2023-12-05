package com.ilaird.aoc2023.aoc;

import org.springframework.stereotype.Component;

@Component
public class IntegerPuzzleInput extends LnXfmPuzzleInput<Integer> {
    @Override
    public Integer transform(String line) throws TransformError {
        try {
            return Integer.parseInt(line);
        } catch (NumberFormatException e) {
            throw new TransformError("Unable to create Integer from line: " + line);
        }
    }
}
