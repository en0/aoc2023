package com.ilaird.aoc2023.day02;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import org.springframework.stereotype.Component;

import com.ilaird.aoc2023.aoc.LnXfmPuzzleInput;
import com.ilaird.aoc2023.aoc.TransformError;

@Component
class D2PuzzleInput extends LnXfmPuzzleInput<Game> {

    Pattern pattern = Pattern.compile("game (\\d+): (.*)", Pattern.CASE_INSENSITIVE);

    @Override
    public Game transform(String input) throws TransformError {

        var matcher = pattern.matcher(input);
        matcher.find();

        int gameId = Integer.parseInt(matcher.group(1));
        String gameDetail = matcher.group(2);

        return new Game() {{
            id = gameId;
            rounds = parseGame(gameDetail);
        }};
    }

    private List<Map<String, Integer>> parseGame(String detail) {
        var ret = new ArrayList<Map<String, Integer>>();
        for (String round : detail.split("; "))
            ret.add(parseRound(round));
        return ret;
    }

    private Map<String, Integer> parseRound(String round) {
        var ret = new HashMap<String, Integer>();
        for (String item : round.split(", ")) {
            var comp = item.split(" ");
            ret.put(comp[1], Integer.parseInt(comp[0]));
        }
        return ret;
    }
}

