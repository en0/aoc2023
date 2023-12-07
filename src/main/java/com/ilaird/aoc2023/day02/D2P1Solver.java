package com.ilaird.aoc2023.day02;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ilaird.aoc2023.aoc.AocSolution;
import com.ilaird.aoc2023.aoc.Solver;
import com.ilaird.aoc2023.aoc.SolverError;

@Component
@AocSolution(day = 2, part = 1)
class D2P1Solver implements Solver {

    static final Map<String, Integer> possible = Map.of(
        "red", 12,
        "green", 13,
        "blue", 14
    );

    @Autowired
    private Iterable<Game> input;

    @Override
    public long solve() throws SolverError {
        int ret = 0;
        for (Game game : input) {
            if (isGamePossible(game))
                ret += game.id;

        }
        return ret;
    }

    boolean isGamePossible(Game game) {
        for (String key : possible.keySet()) {
            var limit = possible.get(key);
            for (Map<String, Integer> round : game.rounds) {
                if (round.containsKey(key) && round.get(key) > limit)
                    return false;
            }
        }
        return true;
    }
}
