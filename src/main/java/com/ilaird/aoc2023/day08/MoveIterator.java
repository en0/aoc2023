package com.ilaird.aoc2023.day08;

import java.util.Iterator;

class MoveIterator implements Iterator<Integer> {

    private final char[] moves;
    private int i;

    MoveIterator(String moves) {
        this.moves = moves.toCharArray();
        this.i = moves.length() - 1;
    }

    public int getMoveCount() {
        return moves.length;
    }

    public int getMoveIndex() {
        return i;
    }

    @Override
    public boolean hasNext() {
        return true;
    }

    @Override
    public Integer next() {
        i = (i + 1) % moves.length;
        return moves[i] == 'L' ? 0 : 1;
    }
}
