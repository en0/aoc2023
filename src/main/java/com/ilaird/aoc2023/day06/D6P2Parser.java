package com.ilaird.aoc2023.day06;

import java.util.List;
import java.util.regex.Pattern;

import org.springframework.stereotype.Component;

import com.ilaird.aoc2023.aoc.BlkXfmPuzzleInput;
import com.ilaird.aoc2023.aoc.TransformError;

@Component("d6p2")
class D6P2Parser extends BlkXfmPuzzleInput<Race> {

    Pattern digit = Pattern.compile("\\d+");

    @Override
    public List<Race> transformAll(String[] inputs) throws TransformError {

        var timeSB = new StringBuilder();
        var distanceSB = new StringBuilder();

        var timeMatcher = digit.matcher(inputs[0]);
        var distanceMatcher = digit.matcher(inputs[1]);

        while (timeMatcher.find() && distanceMatcher.find()) {
            timeSB.append(timeMatcher.group());
            distanceSB.append(distanceMatcher.group());
        }

        return List.of(
            new Race() {{
                time = Long.parseLong(timeSB.toString());
                distance = Long.parseLong(distanceSB.toString());
            }}
        );
    }
}
