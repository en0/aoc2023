package com.ilaird.aoc2023.day11;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ilaird.aoc2023.aoc.AocSolution;
import com.ilaird.aoc2023.aoc.Solver;
import com.ilaird.aoc2023.aoc.SolverError;

@Component
@AocSolution(day = 11, part = 1)
class D11P1Solver implements Solver {

    @Autowired
    private Iterable<String> input;

    @Override
    public long solve() throws SolverError {
        var input = getInputAsArray();
        var rowExp = getRowExpansion(input);
        var colExp = getColumnExpansion(input);
        var points = getGalaxyPoints(input, rowExp, colExp);
        var ret = 0L;
        for (var i = 0; i < points.size() - 1; i++) {
            var a = points.get(i);
            for (var j = i; j < points.size(); j ++) {
                var b = points.get(j);
                ret += Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1]);
            }
        }
        return ret;
    }

    int getExpansion() {
        return 1;
    }

    String[] getInputAsArray() {
        var lst = new ArrayList<String>();
        input.forEach(lst::add);
        var arr = new String[lst.size()];
        lst.toArray(arr);
        return arr;
    }

    List<long[]> getGalaxyPoints(String[] input, int[] rowExp, int[] colExp) {
        var ret = new ArrayList<long[]>();
        for (int y = 0; y < input.length; y++) {
            for (int x = 0; x < input[y].length(); x++) {
                var c = input[y].charAt(x);
                if (c == '#')
                    ret.add(new long[] {x + colExp[x], y + rowExp[y]});
            }
        }
        return ret;
    }

    int[] getColumnExpansion(String[] input) {
        var cols = new int[input[0].length()];
        var expander = 0;
        for (var i = 0; i < input[0].length(); i++) {
            var isColumnAllDots = true;
            for (var j = 0; j < input.length; j++)
                isColumnAllDots &= input[j].charAt(i) == '.';
            if (isColumnAllDots)
                expander += getExpansion();
            cols[i] = expander;
        }
        return cols;
    }

    int[] getRowExpansion(String[] input) {
        var rows = new int[input.length];
        var expander = 0;
        for (var i = 0; i < input.length; i++) {
            var isLineAllDots = true;
            for (var c : input[i].toCharArray())
                isLineAllDots &= c == '.';
            if (isLineAllDots)
                expander += getExpansion();
            rows[i] = expander;
        }
        return rows;
    }
}
