package com.ilaird.aoc2023.day03;

import java.util.List;
import java.util.Objects;

class Point {

    int x;
    int y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Point other = (Point)obj;
        return x == other.x && y == other.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return String.format("(%d, %d)", x, y);
    }

    List<Point> getAdjacentPoints() {
        return List.of(
            new Point(x, y-1),
            new Point(x, y+1),
            new Point(x-1, y),
            new Point(x+1, y),
            new Point(x-1, y-1),
            new Point(x+1, y-1),
            new Point(x-1, y+1),
            new Point(x+1, y+1)
        );
    }
}
