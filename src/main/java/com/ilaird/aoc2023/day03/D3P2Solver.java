package com.ilaird.aoc2023.day03;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ilaird.aoc2023.aoc.AocSolution;
import com.ilaird.aoc2023.aoc.PuzzleInput;
import com.ilaird.aoc2023.aoc.Solver;
import com.ilaird.aoc2023.aoc.SolverError;

@Component
@AocSolution(day = 3, part = 2)
class D3P2Solver implements Solver {

    @Autowired
    private PuzzleInput<GridRow> input;

    @Override
    public int solve() throws SolverError {
        var ret = 0;
        var astriscCount = 0;
        var gearCount = 0;
        var grid = new Grid();
        var seen = new HashSet<>();
        input.forEach(r -> grid.addGridRow(r));
        for (Point sp : grid.getSymbolOffsets('*')) {
            astriscCount++;
            System.out.println("SYMBOL: " + sp);
            var gearVals = new ArrayList<Integer>();
            for (Point tp : sp.getAdjacentPoints()) {
                var ident = Objects.hash(sp, grid.getIdentityAt(tp));
                if (!seen.contains(ident)) {
                    seen.add(ident);
                    var gv = grid.getValueAt(tp);
                    if (gv > 0) {
                        gearVals.add(gv);
                        System.out.println("        " + tp + " -> " + gv + " (" + gearVals + ")");
                    }
                }
            }

            if (gearVals.size() == 2) {
                var product = gearVals.stream().reduce(1, (a, b) -> a * b);
                ret += product;
                gearCount++;
                System.out.println("        " + product + " -> " + ret);
            }
        }
        System.out.println("Astriscs: " + astriscCount);
        System.out.println("Gears: " + gearCount);
        // to low : 86783783
        return ret;
    }
}
