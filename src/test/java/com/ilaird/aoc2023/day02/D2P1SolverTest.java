package com.ilaird.aoc2023.day02;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.ilaird.aoc2023.aoc.PartSolverTestBase;

class D2P1SolverTest extends PartSolverTestBase<Game> {
    @BeforeEach
    void setUp() {
        unit = new D2P1Solver();
        parser = new D2PuzzleInput();
        answer = 8;
        sample = new String[] {
            "Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green",
            "Game 2: 1 blue, 2 green; 3 green, 4 blue, 1 red; 1 green, 1 blue",
            "Game 3: 8 green, 6 blue, 20 red; 5 blue, 4 red, 13 green; 5 green, 1 red",
            "Game 4: 1 green, 3 red, 6 blue; 3 green, 6 red; 3 green, 15 blue, 14 red",
            "Game 5: 6 red, 1 blue, 3 green; 2 blue, 1 red, 2 green"
        };

        initMocks();
    }

    @Test
    void testFirstGame() {
        var iter = parser.iterator();
        var game = iter.next();
        assertEquals(1, game.id);
        assertEquals(3, game.rounds.size());

        var round = game.rounds.get(0);
        assertEquals(2, round.size());

        assertEquals(3, round.get("blue"));
        assertEquals(4, round.get("red"));
    }

    @Test
    void testHaveFiveGames() {
        int counter = 0;
        var iter = parser.iterator();
        while(iter.hasNext()) {
            iter.next();
            counter++;
        }
        assertEquals(5, counter);
    }

    @Test
    void testEachGameHasThreeRoundsExceptGameFive() {
        for (Game game : parser)
            if (game.id != 5)
                assertEquals(3, game.rounds.size());
            else
                assertEquals(2, game.rounds.size());
    }
}
