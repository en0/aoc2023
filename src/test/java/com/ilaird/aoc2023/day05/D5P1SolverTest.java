package com.ilaird.aoc2023.day05;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.ilaird.aoc2023.aoc.PartSolverTestBase;

class D5P1SolverTest extends PartSolverTestBase<Almanac> {

    @BeforeEach
    void setUp() {
        unit = new D5P1Solver();
        parser = new D5Parser();
        answer = 35;
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
    void testAlmanacMapEntryWorks() {
        var map = new AlmanacMapEntry() {{
            targetRangeStart = 52;
            sourceRangeStart = 50;
            rangeSize = 48;
        }};

        assertFalse(map.isInRange(40));
        assertTrue(map.isInRange(53));
        assertEquals(55, map.getTarget(53));
    }

    @Test
    void testAlmanacMapWorks() {
        var map1 = new AlmanacMapEntry() {{
            targetRangeStart = 50;
            sourceRangeStart = 98;
            rangeSize = 2;
        }};

        var map2= new AlmanacMapEntry() {{
            targetRangeStart = 52;
            sourceRangeStart = 50;
            rangeSize = 48;
        }};

        var map = new AlmanacMap() {{
            mapName = "seed-to-soil";
            entries = List.of(map1, map2);
        }};

        assertEquals(51, map.getTarget(99));
        assertEquals(55, map.getTarget(53));
    }

    @Test
    void testD5ParserWorks() {
        var almanac = parser.iterator().next();
        long[] mapEntityCounts = {2, 3, 4, 2, 3, 2, 2};
        String[] mapNames = {
            "seed-to-soil",
            "soil-to-fertilizer",
            "fertilizer-to-water",
            "water-to-light",
            "light-to-temperature",
            "temperature-to-humidity",
            "humidity-to-location"
        };

        assertEquals(List.of(79L, 14L, 55L, 13L), almanac.seeds);
        for (int i = 0; i < almanac.maps.size(); i++) {
            var map = almanac.maps.get(i);
            assertEquals(mapNames[i], map.mapName);
            assertEquals(mapEntityCounts[i], map.entries.size());
        }

    }

    @Test
    void testSeed79() {
        var almanac = parser.iterator().next();
        assertEquals(81, almanac.maps.get(0).getTarget(79), almanac.maps.get(0).mapName + " is wrong");
        assertEquals(81, almanac.maps.get(1).getTarget(81), almanac.maps.get(1).mapName + " is wrong");
        assertEquals(81, almanac.maps.get(2).getTarget(81), almanac.maps.get(2).mapName + " is wrong");
        assertEquals(74, almanac.maps.get(3).getTarget(81), almanac.maps.get(3).mapName + " is wrong");
        assertEquals(78, almanac.maps.get(4).getTarget(74), almanac.maps.get(4).mapName + " is wrong");
        assertEquals(78, almanac.maps.get(5).getTarget(78), almanac.maps.get(5).mapName + " is wrong");
        assertEquals(82, almanac.maps.get(6).getTarget(78), almanac.maps.get(6).mapName + " is wrong");
    }
}

