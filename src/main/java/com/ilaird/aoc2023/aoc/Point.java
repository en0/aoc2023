package com.ilaird.aoc2023.aoc;

import java.util.Objects;

public class Point {

    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Point pointAbove() {
        return new Point(x, y-1);
    }

    public Point pointBelow() {
        return new Point(x, y+1);
    }

    public Point pointLeft() {
        return new Point(x-1, y);
    }

    public Point pointRight() {
        return new Point(x+1, y);
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
}
