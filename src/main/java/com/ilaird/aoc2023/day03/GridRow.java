package com.ilaird.aoc2023.day03;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class GridRow {

    private Map<Character, Set<Integer>> symbols;
    private Map<Integer, Integer> values;
    private Map<Integer, Integer> idents;

    GridRow() {
        symbols = new HashMap<>();
        values = new HashMap<>();
        idents = new HashMap<>();
    }

    void addValue(int value, int offset, int identity) {
        values.put(offset, value);
        idents.put(offset, identity);
    }

    void addSymbol(char symbol, int offset) {
        if (!symbols.containsKey(symbol))
            symbols.put(symbol, new HashSet<>());
        symbols.get(symbol).add(offset);
    }

    int getValueAt(int offset) {
        var val = values.get(offset);
        return val != null ? val : 0;
    }

    int getIdentityAt(int offset) {
        var val = idents.get(offset);
        return val != null ? val : -1;
    }

    Set<Integer> getSymbolOffsets(char symbol) {
        var ret = symbols.get(symbol);
        return ret == null ? Set.of() : ret;
    }

    boolean contains(char symbol) {
        return symbols.containsKey(symbol);
    }

    List<Character> listSymbols() {
        return new ArrayList<>(symbols.keySet());
    }
}
