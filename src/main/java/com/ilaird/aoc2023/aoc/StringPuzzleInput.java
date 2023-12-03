package com.ilaird.aoc2023.aoc;

import org.springframework.stereotype.Component;

@Component
public class StringPuzzleInput extends PuzzleInput<String> {
    @Override
    public String transform(String line) throws TransformError {
        return line;
    }
}
