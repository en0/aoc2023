package com.ilaird.aoc2023.day06;

class Race {
    long time;
    long distance;

    long waysToWin() {
        long l = time / 2;
        long h = time - l;
        while ((h++)*(l--) > distance);
        return (h - 1) - (l + 1) - 1;
    }
}
