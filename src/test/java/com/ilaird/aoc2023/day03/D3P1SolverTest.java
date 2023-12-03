package com.ilaird.aoc2023.day03;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.ilaird.aoc2023.aoc.PartSolverTestBase;

class D3P1SolverTest extends PartSolverTestBase<GridRow> {

    @BeforeEach
    void setUp() {
        unit = new D3P1Solver();
        parser = new D3PuzzleInput();
        answer = 4361;
        sample = new String[] {
            "467..114..",
            "...*......",
            "..35..633.",
            "......#...",
            "617*......",
            ".....+.58.",
            "..592.....",
            "......755.",
            "...$.*....",
            ".664.598..",
        };

        initMocks();
    }

    @Test
    void testGridRowFindsValues() {
        var g = parser.iterator().next();
        assertEquals(467, g.getValueAt(0));
        assertEquals(467, g.getValueAt(1));
        assertEquals(467, g.getValueAt(2));
        assertEquals(0, g.getValueAt(3));
        assertEquals(0, g.getValueAt(4));
        assertEquals(114, g.getValueAt(5));
        assertEquals(114, g.getValueAt(6));
        assertEquals(114, g.getValueAt(7));
        assertEquals(0, g.getValueAt(8));
        assertEquals(0, g.getValueAt(9));
    }

    @Test
    void testValueIdentity() {
        var g = parser.iterator().next();
        assertEquals(3, g.getIdentityAt(0));
        assertEquals(3, g.getIdentityAt(1));
        assertEquals(3, g.getIdentityAt(2));
        assertEquals(-1, g.getIdentityAt(3));
        assertEquals(-1, g.getIdentityAt(4));
        assertEquals(8, g.getIdentityAt(5));
        assertEquals(8, g.getIdentityAt(6));
        assertEquals(8, g.getIdentityAt(7));
        assertEquals(-1, g.getIdentityAt(8));
        assertEquals(-1, g.getIdentityAt(9));
    }

    @Test
    void testGridRowFindsSymbols() {
        var p = parser.iterator();
        p.next();
        var g = p.next();
        assertEquals(List.of('*'), g.listSymbols());
        assertEquals(Set.of(3), g.getSymbolOffsets('*'));
        assertEquals(Set.of(), g.getSymbolOffsets('%'));
    }

    @Test
    void testGridCanGetSymbols() {
        var grid = new Grid();
        for (GridRow gridRow : parser)
            grid.addGridRow(gridRow);
        assertEquals(Set.of('*', '#', '+', '$'), grid.listSymbols());

        var expectedPoints = Set.of(
            new Point(3, 1),
            new Point(3, 4),
            new Point(5, 8)
        );
        assertEquals(expectedPoints, grid.getSymbolOffsets('*'));
    }

    @Test
    void testGridGetValueAt() {
        var grid = new Grid();
        for (GridRow gridRow : parser)
            grid.addGridRow(gridRow);
        var p = new Point(7, 5);
        var result = grid.getValueAt(p);
        assertEquals(58, result);
    }
}
