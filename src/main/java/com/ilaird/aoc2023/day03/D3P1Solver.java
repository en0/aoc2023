package com.ilaird.aoc2023.day03;

import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ilaird.aoc2023.aoc.AocSolution;
import com.ilaird.aoc2023.aoc.Solver;
import com.ilaird.aoc2023.aoc.SolverError;

@Component
@AocSolution(day = 3, part = 1)
class D3P1Solver implements Solver {

    @Autowired
    private Iterable<GridRow> input;

    @Override
    public long solve() throws SolverError {
        var ret = 0;
        var grid = new Grid();
        var seen = new HashSet<>();
        input.forEach(r -> grid.addGridRow(r));
        for (char c : grid.listSymbols()) {
            for (Point sp : grid.getSymbolOffsets(c)) {
                for (Point tp : sp.getAdjacentPoints()) {
                    var ident = grid.getIdentityAt(tp);
                    if (!seen.contains(ident)) {
                        seen.add(ident);
                        var gv = grid.getValueAt(tp);
                        ret += gv;
                    }
                }
            }
        }
        return ret;
    }
}
