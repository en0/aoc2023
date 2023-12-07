package com.ilaird.aoc2023.day03;

import java.util.ArrayList;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ilaird.aoc2023.aoc.AocSolution;
import com.ilaird.aoc2023.aoc.Solver;
import com.ilaird.aoc2023.aoc.SolverError;

@Component
@AocSolution(day = 3, part = 2)
class D3P2Solver implements Solver {

    @Autowired
    private Iterable<GridRow> input;

    @Override
    public long solve() throws SolverError {

        var ret = 0;
        var grid = new Grid();
        var seen = new HashSet<>();

        input.forEach(r -> grid.addGridRow(r));

        for (Point sp : grid.getSymbolOffsets('*')) {

            var gearVals = new ArrayList<Integer>();

            for (Point tp : sp.getAdjacentPoints()) {

                var ident = mkIdentity(sp, grid.getIdentityAt(tp));
                if (!seen.contains(ident)) {
                    seen.add(ident);
                    var gv = grid.getValueAt(tp);
                    if (gv > 0)
                        gearVals.add(gv);
                }
            }

            if (gearVals.size() == 2)
                ret += gearVals.stream().reduce(1, (a, b) -> a * b);
        }

        return ret;
    }

    Point mkIdentity(Point a, Point b) {
        var x = (a.x * 61) + (b.x);
        var y = (a.y * 61) + (b.y);
        return new Point(x, y);
    }
}
