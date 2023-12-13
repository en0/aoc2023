package com.ilaird.aoc2023.day10;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ilaird.aoc2023.aoc.AocSolution;
import com.ilaird.aoc2023.aoc.CharPoint;
import com.ilaird.aoc2023.aoc.Solver;
import com.ilaird.aoc2023.aoc.SolverError;
import com.ilaird.aoc2023.aoc.Point;

@Component
@AocSolution(day = 10, part = 1)
class D10P1Solver implements Solver {

    class G {

        Map<Point, List<Point>> adjList;

        G() {
            adjList = new HashMap<>();
        }

        void addVertex(Point v) {
            if (!adjList.containsKey(v))
                adjList.put(v, new ArrayList<>());
        }

        void addEdge(Point a, Point b) {
            addVertex(a);
            adjList.get(a).add(b);
        }

        Set<Point> getAdjVertices(Point v) {
            return new HashSet<>(adjList.getOrDefault(v, List.of()));
        }
    }

    @Autowired
    private Iterable<CharPoint> input;
    private G graph = new G();
    private Map<Point, Character> charMap = new HashMap<>();

    @Override
    public long solve() throws SolverError {

        class TPath { Point point; int count; }
        Queue<TPath> queue = new LinkedList<>();
        Set<Point> seen = new HashSet<>();

        var start = loadGraph();
        seen.add(start);
        queue.add(new TPath() {{ point = start; count = 0; }});

        var ret = 0L;
        while (!queue.isEmpty()) {
            var tp = queue.poll();
            ret = Math.max(ret, tp.count);
            for (var aPoint : graph.getAdjVertices(tp.point)) {
                if (!seen.contains(aPoint)) {
                    seen.add(aPoint);
                    queue.add(new TPath() {{
                        point = aPoint;
                        count = tp.count + 1;
                    }});
                }
            }
        }
        return ret;
    }

    Point loadGraph() throws SolverError {
        Point start = null;
        for (var cp : input) {

            var p = new Point(cp.x, cp.y);

            charMap.put(p, cp.c);
            graph.addVertex(p);

            switch (cp.c) {
                case '|':
                    graph.addEdge(p, p.pointAbove());
                    graph.addEdge(p, p.pointBelow());
                    break;
                case '-':
                    graph.addEdge(p, p.pointLeft());
                    graph.addEdge(p, p.pointRight());
                    break;
                case 'L':
                    graph.addEdge(p, p.pointAbove());
                    graph.addEdge(p, p.pointRight());
                    break;
                case 'J':
                    graph.addEdge(p, p.pointAbove());
                    graph.addEdge(p, p.pointLeft());
                    break;
                case '7':
                    graph.addEdge(p, p.pointLeft());
                    graph.addEdge(p, p.pointBelow());
                    break;
                case 'F':
                    graph.addEdge(p, p.pointRight());
                    graph.addEdge(p, p.pointBelow());
                    break;
                case 'S':
                    start = p;
                case '.':
                    break;
            }
        }

        if (start == null)
            throw new SolverError("No start point");

        if (Set.of('|', '7', 'F').contains(charMap.getOrDefault(start.pointAbove(), '.')))
            graph.addEdge(start, start.pointAbove());

        if (Set.of('|', 'L', 'J').contains(charMap.getOrDefault(start.pointBelow(), '.')))
            graph.addEdge(start, start.pointBelow());

        if (Set.of('-', '7', 'J').contains(charMap.getOrDefault(start.pointRight(), '.')))
            graph.addEdge(start, start.pointRight());

        if (Set.of('-', 'L', 'F').contains(charMap.getOrDefault(start.pointLeft(), '.')))
            graph.addEdge(start, start.pointLeft());

        return start;
    }
}
