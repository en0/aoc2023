package com.ilaird.aoc2023.day03;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class Grid {

    List<GridRow> rows;
    Map<Character, Set<Point>> symbols;

    Grid() {
        rows = new ArrayList<>();
        symbols = new HashMap<>();
    }

    void addGridRow(GridRow gridRow) {
        var yOffset = rows.size();
        rows.add(gridRow);
        for (char s : gridRow.listSymbols()) {
            for (int o : gridRow.getSymbolOffsets(s)) {
                symbols.putIfAbsent(s, new HashSet<>());
                symbols.get(s).add(new Point(o, yOffset));
            }
        }
    }

    Set<Character> listSymbols() {
        return symbols.keySet();
    }

    Set<Point> getSymbolOffsets(char symbol) {
        var ret = symbols.get(symbol);
        return ret == null ? Set.of() : ret;
    }

    int getValueAt(Point p) {
        if (p.y < 0 || p.y >= rows.size()) return 0;
        return rows.get(p.y).getValueAt(p.x);
    }

    Point getIdentityAt(Point p) {
        if (p.y < 0 || p.y >= rows.size()) return new Point(-1, -1);
        var ident = rows.get(p.y).getIdentityAt(p.x);
        if (ident == -1)
            return new Point(-1, -1);
        return new Point(ident, p.y);
    }
}
