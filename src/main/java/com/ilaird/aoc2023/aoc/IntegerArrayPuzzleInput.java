package com.ilaird.aoc2023.aoc;

import java.util.ArrayList;
import java.util.regex.Pattern;

import org.springframework.stereotype.Component;

@Component
public class IntegerArrayPuzzleInput extends LnXfmPuzzleInput<Integer[]> {

    Pattern digit = Pattern.compile("(-?\\d+)");

    @Override
    public Integer[] transform(String line) throws TransformError {

        var ret = new ArrayList<Integer>();
        var matcher = digit.matcher(line);
        while (matcher.find())
            ret.add(toInt(matcher.group(1)));
        var array = new Integer[ret.size()];
        ret.toArray(array);
        return array;
    }

    private int toInt(String val) throws TransformError {
        try {
            return Integer.parseInt(val);
        } catch (NumberFormatException e) {
            throw new TransformError("Unable to create Integer from string: " + val);
        }
    }
}
