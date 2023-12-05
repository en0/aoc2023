package com.ilaird.aoc2023.aoc;

import java.util.ArrayList;
import java.util.List;


public abstract class LnXfmPuzzleInput<T> extends BlkXfmPuzzleInput<T> {

    @Override
    public List<T> transformAll(String[] inputs) throws TransformError {
        var ret = new ArrayList<T>();
        for (int i = 0; i < inputs.length; i++)
            ret.add(transform(inputs[i]));
        return ret;
    }

    public abstract T transform(String input) throws TransformError;
}
