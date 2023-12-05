package com.ilaird.aoc2023.aoc;

import java.util.Iterator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;


public abstract class BlkXfmPuzzleInput<T> implements Iterable<T> {

    private static final Logger logger = LoggerFactory.getLogger(BlkXfmPuzzleInput.class);

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

    public abstract List<T> transformAll(String[] inputs) throws TransformError;

}
