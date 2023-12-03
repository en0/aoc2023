package com.ilaird.aoc2023.day02;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ilaird.aoc2023.aoc.AocSolution;
import com.ilaird.aoc2023.aoc.PuzzleInput;
import com.ilaird.aoc2023.aoc.Solver;
import com.ilaird.aoc2023.aoc.SolverError;

@Component
@AocSolution(day = 2, part = 2)
class D2P2Solver implements Solver {

    @Autowired
    private PuzzleInput<Game> input;

    @Override
    public int solve() throws SolverError {
        int ret = 0;
        for (Game game : input)
            ret += computePower(game);
        return ret;
    }

    int computePower(Game game) {

        var mins = new HashMap<String, Integer>(Map.of(
            "red", 1,
            "green", 1,
            "blue", 1
        ));

        game.rounds.forEach(round ->
            round.forEach((color, value) ->
                mins.merge(color, value, (a, b) -> Math.max(a, b))
            )
        );

        return mins.values().stream().reduce(1, (a, b) -> a*b);
    }
}
