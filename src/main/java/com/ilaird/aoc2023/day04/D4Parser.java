package com.ilaird.aoc2023.day04;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Component;

import com.ilaird.aoc2023.aoc.LnXfmPuzzleInput;
import com.ilaird.aoc2023.aoc.TransformError;

@Component
class D4Parser extends LnXfmPuzzleInput<ScratchCard> {

    Pattern pattern = Pattern.compile("Card\\s+(\\d+):\\s*([^|]+)\\s*\\|\\s*(.*)");

    @Override
    public ScratchCard transform(String input) throws TransformError {
        Matcher matcher = pattern.matcher(input);
        if (matcher.matches()) {
            return new ScratchCard() {{
                cardNumber = Integer.parseInt(matcher.group(1));
                winningNumbers = parseSet(matcher.group(2));
                givenNumbers = parseSet(matcher.group(3));
            }};
        }
        throw new TransformError("Cannot parse line: " + input);
    }

    private Set<Integer> parseSet(String line) {
        var ret = new HashSet<Integer>();
        for (String number : line.split(" ")) {
            var s = number.trim();
            if (s.length() > 0) {
                var n = Integer.parseInt(s);
                ret.add(n);
            }
        }
        return ret;
    }
}
