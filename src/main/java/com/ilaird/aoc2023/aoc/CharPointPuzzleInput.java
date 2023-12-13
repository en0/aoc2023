package com.ilaird.aoc2023.aoc;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class CharPointPuzzleInput extends BlkXfmPuzzleInput<CharPoint> {

    @Override
    public List<CharPoint> transformAll(String[] inputs) throws TransformError {
        var ret = new ArrayList<CharPoint>();
        for (var y = 0; y < inputs.length; y++) {
            for (var x = 0; x < inputs[y].length(); x++) {
                var cp = new CharPoint();
                cp.x = x;
                cp.y = y;
                cp.c = inputs[y].charAt(x);
                ret.add(cp);
            }
        }
        return ret;
    }
}
