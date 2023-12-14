package com.ilaird.aoc2023.day10;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.ilaird.aoc2023.aoc.AocSolution;
import com.ilaird.aoc2023.aoc.Point;
import com.ilaird.aoc2023.aoc.SolverError;

@Component
@AocSolution(day = 10, part = 2)
class D10P2Solver extends D10P1Solver {

    @Override
    public long solve() throws SolverError {

        var start = loadGraph();
        var loop = findLoop(start);
        var limit = findBounds();

        var ret = 0L;

        for (var y = 0; y < limit.getY(); y++) {

            var inRegion = false;
            char corner = ' ';

            for (var x = 0; x < limit.getX(); x++) {

                var tp = new Point(x, y);
                var c = loop.contains(tp) ? charMap.get(tp) : '.';

                if (c == '.')
                    ret += inRegion ? 1 : 0;
                else if (Set.of('L', 'F').contains(c))
                    corner = c;
                else if (c == '7')
                    inRegion = corner == 'L' ? !inRegion : inRegion;
                else if (c == 'J')
                    inRegion = corner == 'F' ? !inRegion : inRegion;
                else if (c == '|')
                    inRegion = !inRegion;
            }
        }
        return ret;
    }

    Point findBounds() {
        var xLimit = 0;
        var yLimit = 0;

        for (var p : graph) {
            xLimit = Math.max(p.getX(), xLimit);
            yLimit = Math.max(p.getY(), yLimit);
        }
        return new Point(xLimit + 1, yLimit + 1);
    }

    Set<Point> findLoop(Point start) {
        var stack = new LinkedList<Point>();
        var seen = new HashSet<Point>();
        stack.push(start);
        seen.add(start);
        while (!stack.isEmpty()) {
            var p = stack.pop();
            for (var nP : graph.getAdjVertices(p)) {
                if (!seen.contains(nP)) {
                    seen.add(nP);
                    stack.push(nP);
                }
            }
        }
        return seen;
    }
}
