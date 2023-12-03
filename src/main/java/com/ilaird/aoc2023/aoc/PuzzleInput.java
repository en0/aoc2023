package com.ilaird.aoc2023.aoc;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;


public abstract class PuzzleInput<T> implements Iterable<T> {

    private static final Logger logger = LoggerFactory.getLogger(PuzzleInput.class);

    @Value("#{puzzleInputConfig.puzzleInput}")
    String[] puzzleInput;

    @Override
    public Iterator<T> iterator() {
        try {
            return transformAll(puzzleInput).iterator();
        } catch (TransformError e) {
            logger.error("Failed to transform input.", e);
            return null;
        }
    }

    private List<T> transformAll(String[] inputs) throws TransformError {
        var ret = new ArrayList<T>();
        for (int i = 0; i < inputs.length; i++)
            ret.add(transform(inputs[i]));
        return ret;
    }

    public abstract T transform(String input) throws TransformError;
}
