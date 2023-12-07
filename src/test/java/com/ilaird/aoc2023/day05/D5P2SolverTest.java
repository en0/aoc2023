package com.ilaird.aoc2023.day05;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.ilaird.aoc2023.aoc.PartSolverTestBase;

class D5P2SolverTest extends PartSolverTestBase<Almanac> {

    @BeforeEach
    void setUp() {
        unit = new D5P2Solver();
        parser = new D5Parser();
        answer = 46;
        sample = new String[] {
            "seeds: 79 14 55 13",
            "",
            "seed-to-soil map:",
            "50 98 2",
            "52 50 48",
            "",
            "soil-to-fertilizer map:",
            "0 15 37",
            "37 52 2",
            "39 0 15",
            "",
            "fertilizer-to-water map:",
            "49 53 8",
            "0 11 42",
            "42 0 7",
            "57 7 4",
            "",
            "water-to-light map:",
            "88 18 7",
            "18 25 70",
            "",
            "light-to-temperature map:",
            "45 77 23",
            "81 45 19",
            "68 64 13",
            "",
            "temperature-to-humidity map:",
            "0 69 1",
            "1 0 69",
            "",
            "humidity-to-location map:",
            "60 56 37",
            "56 93 4"
        };

        initMocks();
    }

    @Test
    void testSeed82() {
        var almanac = parser.iterator().next();

        // forward
        assertEquals(84, almanac.maps.get(0).getTarget(82), almanac.maps.get(0).mapName + " is wrong");
        assertEquals(84, almanac.maps.get(1).getTarget(84), almanac.maps.get(1).mapName + " is wrong");
        assertEquals(84, almanac.maps.get(2).getTarget(84), almanac.maps.get(2).mapName + " is wrong");
        assertEquals(77, almanac.maps.get(3).getTarget(84), almanac.maps.get(3).mapName + " is wrong");
        assertEquals(45, almanac.maps.get(4).getTarget(77), almanac.maps.get(4).mapName + " is wrong");
        assertEquals(46, almanac.maps.get(5).getTarget(45), almanac.maps.get(5).mapName + " is wrong");
        assertEquals(46, almanac.maps.get(6).getTarget(46), almanac.maps.get(6).mapName + " is wrong");

        // And backwards
        assertEquals(46, almanac.maps.get(6).getSource(46), almanac.maps.get(6).mapName + " is wrong");
        assertEquals(45, almanac.maps.get(5).getSource(46), almanac.maps.get(6).mapName + " is wrong");
        assertEquals(77, almanac.maps.get(4).getSource(45), almanac.maps.get(4).mapName + " is wrong");
        assertEquals(84, almanac.maps.get(3).getSource(77), almanac.maps.get(3).mapName + " is wrong");
        assertEquals(84, almanac.maps.get(2).getSource(84), almanac.maps.get(2).mapName + " is wrong");
        assertEquals(84, almanac.maps.get(1).getSource(84), almanac.maps.get(1).mapName + " is wrong");
        assertEquals(82, almanac.maps.get(0).getSource(84), almanac.maps.get(0).mapName + " is wrong");
    }
}
