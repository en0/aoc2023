package com.ilaird.aoc2023.day08;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ilaird.aoc2023.aoc.AocSolution;
import com.ilaird.aoc2023.aoc.Solver;
import com.ilaird.aoc2023.aoc.SolverError;

@Component
@AocSolution(day = 8, part = 1)
class D8P1Solver implements Solver {

    @Autowired
    private Iterable<String> input;

    Pattern linePattern = Pattern.compile("(\\w+) = \\((\\w+), (\\w+)\\)");
    Map<String, String[]> graph;
    MoveIterator moveIter;

    @Override
    public long solve() throws SolverError {
        loadInput(input);
        var ret = 0L;
        var node = "AAA";

        while (!node.equals("ZZZ")) {
            node = graph.get(node)[moveIter.next()];
            ret ++;
        }

        return ret;
    }

    void loadInput(Iterable<String> input) throws SolverError {
        var i = input.iterator();
        loadMoveIterator(i);
        i.next();
        loadGraph(i);
    }

    void loadMoveIterator(Iterator<String> input) throws SolverError {
        moveIter = new MoveIterator(input.next());
    }

    void loadGraph(Iterator<String> input) throws SolverError {
        graph = new HashMap<String, String[]>();
        while(input.hasNext()) {
            var line = input.next();
            var matcher = linePattern.matcher(line);
            if (!matcher.matches())
                throw new SolverError("cannot parse " + line);
            var node = matcher.group(1);
            var left = matcher.group(2);
            var right = matcher.group(3);
            graph.put(node, new String[] {left, right});
        }
    }
}
