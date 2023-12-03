package com.ilaird.aoc2023.day03;

import java.util.LinkedList;

import org.springframework.stereotype.Component;

import com.ilaird.aoc2023.aoc.PuzzleInput;
import com.ilaird.aoc2023.aoc.TransformError;

@Component
class D3PuzzleInput extends PuzzleInput<GridRow> {

    @Override
    public GridRow transform(String input) throws TransformError {

        var ret = new GridRow();
        var queue = new LinkedList<Integer>();
        var buffer = new StringBuilder();
        // Fixed a bug... oops.
        input = input + ".";

        for (int i = 0; i < input.length(); i++) {
            var c = input.charAt(i);
            if (Character.isDigit(c)) {
                queue.push(i);
                buffer.append(c);
            } else if (!queue.isEmpty()) {
                int value = Integer.parseInt(buffer.toString());
                while (!queue.isEmpty()) {
                    var qc = queue.pop();
                    ret.addValue(value, qc, i);
                }
                buffer = new StringBuilder();
            }

            if (!Character.isDigit(c) && c != '.') {
                ret.addSymbol(c, i);
            }
        }

        return ret;
    }
}

