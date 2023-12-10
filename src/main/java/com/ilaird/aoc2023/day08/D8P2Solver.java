package com.ilaird.aoc2023.day08;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ilaird.aoc2023.aoc.AocSolution;
import com.ilaird.aoc2023.aoc.Solver;
import com.ilaird.aoc2023.aoc.SolverError;

@Component
@AocSolution(day = 8, part = 2)
class D8P2Solver implements Solver {

    /*
     * Full Disclosure:
     * I did this using a brute force approach that optimized the search based
     * on the cycle length. That is how i go the initial answer. The search ran
     * in about 45 seconds.
     *
     * My assumption was then to use CRT to generalize it - I assumed that
     * because the sample input had multiple possible end nodes per-ghost, i had
     * to account for that. However, after speaking with a co-worker, he pointed
     * out that LCM was adiqute. Looking at my input file confirmed LCM works.
     * After that conversation i refactored my solution to what is currently here.
     */

    @Autowired
    private Iterable<String> input;

    Pattern linePattern = Pattern.compile("(\\w+) = \\((\\w+), (\\w+)\\)");
    Map<String, String[]> graph;
    List<String> travelers;
    String moveInstructions;

    @Override
    public long solve() throws SolverError {
        loadInput(input);
        long[] vals = travelers.stream().mapToLong(n -> getCycleLength(n)).toArray();
        return lcm(vals);
    }

    void loadInput(Iterable<String> input) throws SolverError {
        var i = input.iterator();
        moveInstructions = i.next();
        i.next();
        loadGraphAndCreateTravelers(i);
    }

    void loadGraphAndCreateTravelers(Iterator<String> input) throws SolverError {
        graph = new HashMap<String, String[]>();
        travelers = new ArrayList<>();
        while(input.hasNext()) {
            var line = input.next();
            var matcher = linePattern.matcher(line);
            if (!matcher.matches())
                throw new SolverError("cannot parse " + line);

            var node = matcher.group(1);
            var left = matcher.group(2);
            var right = matcher.group(3);

            if (node.endsWith("A"))
                travelers.add(node);

            graph.put(node, new String[] {left, right});
        }
    }

    long getCycleLength(String currentNode) {

        var seen = new HashSet<String>();
        var movePath = new ArrayList<String>();
        var moveIter = new MoveIterator(moveInstructions);

        do {
            currentNode = graph.get(currentNode)[moveIter.next()];
            var ident = moveIter.getMoveIndex() + "|" + currentNode;
            if (seen.contains(ident))
                return movePath.size() - movePath.indexOf(ident);
            seen.add(ident);
            movePath.add(ident);
        } while (true);
    }

    public long lcm(long a, long b) {
        if (a == 0 || b == 0) {
            return 0;
        }
        long h = Math.max(Math.abs(a), Math.abs(b));
        long l = Math.min(Math.abs(a), Math.abs(b));
        long ret = h;
        while (ret % l != 0)
            ret += h;
        return ret;
    }

    long lcm(long[] vals)
    {
        long ret = vals[0];
        for(int i = 1; i < vals.length; i++) ret = lcm(ret, vals[i]);
        return ret;
    }
}
