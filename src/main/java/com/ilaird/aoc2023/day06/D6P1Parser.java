package com.ilaird.aoc2023.day06;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import org.springframework.stereotype.Component;

import com.ilaird.aoc2023.aoc.BlkXfmPuzzleInput;
import com.ilaird.aoc2023.aoc.TransformError;

@Component("d6p1")
class D6P1Parser extends BlkXfmPuzzleInput<Race> {

    Pattern digit = Pattern.compile("\\d+");

    @Override
    public List<Race> transformAll(String[] inputs) throws TransformError {
        var ret = new ArrayList<Race>();

        var timeMatcher = digit.matcher(inputs[0]);
        var distanceMatcher = digit.matcher(inputs[1]);

        while (timeMatcher.find() && distanceMatcher.find())
            ret.add(new Race() {{
                time = Integer.parseInt(timeMatcher.group());
                distance = Integer.parseInt(distanceMatcher.group());
            }});

        return ret;
    }
}
