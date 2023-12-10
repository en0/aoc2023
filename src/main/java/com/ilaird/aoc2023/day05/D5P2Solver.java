package com.ilaird.aoc2023.day05;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ilaird.aoc2023.aoc.AocSolution;
import com.ilaird.aoc2023.aoc.Solver;
import com.ilaird.aoc2023.aoc.SolverError;

@Component
@AocSolution(day = 5, part = 2)
class D5P2Solver implements Solver {

    @Autowired
    private Iterable<Almanac> input;

    @Override
    public long solve() throws SolverError {

        /*
         * This code implements a brute force solution that takes about 15
         * minutes to run on my system. I realized that this problem might be to
         * big to bute force but i decided to let it run while i tryied finding
         * a better approach. The solution here took about 5 minutes to create
         * since it's just a small change from part 1.
         *
         * I will revisit this once I have some free time. Here is my real part
         * 2 solution (untested obviously)...
         *
         * Split each range to match target ranges in the adjacent maps. For
         * example:
         *
         * map-1:
         * 10 15 10
         *
         * map-2:
         * 50 5 10
         *
         * Split map 1 so it has ranges that line up with map-2
         *
         * 10 15 5 -> 10 15 5
         *            15 20 5
         *
         * Next, add the missing range to map 1 that maps into the first 5
         * values of map-2
         *
         *            5 5 5
         *
         * Then, do the same thing to map-2 backwards to map-1.
         *
         * Result
         *
         * map-1:
         * 5 5 5
         * 10 15 5
         * 15 20 5
         *
         * map-2:
         * 5 5 5
         * 50 10 5
         * 55 15 5
         *
         * this allows us to reduce the maps to a single map where the source of
         * the first map maps directly to the target of the last map
         *
         * map-optimized:
         * 5 5 5
         * 50 15 5
         * 55 20 5
         *
         * This map can then be sorted by target. Which, in this case, it already is.
         * Last step is to take the first lowest soure range and compare it with
         * the seed ranges to find the one that overlaps. If it doesn't overlap
         * with any, throw that map-range away and move to the next one.
         *
         * I believe this will produce an answer very quickly because the amount
         * of checks we have to do is reduced to the total number of buckets in
         * our optimized map.
         */

        var almanac = input.iterator().next();
        var tpe = (ThreadPoolExecutor)Executors.newFixedThreadPool(10);
        List<Future<Long>> futures = new ArrayList<>();

        for (int i = 0; i < almanac.seeds.size(); i += 2) {
            var seedStart = almanac.seeds.get(i);
            var seedLimit = almanac.seeds.get(i+1) + seedStart;
            var f = tpe.submit(() -> {
                var _ret = Long.MAX_VALUE;
                for (long seed = seedStart; seed < seedLimit; seed++) {
                    var v = seed;
                    for (var map : almanac.maps)
                        v = map.getTarget(v);
                    _ret = Math.min(v, _ret);
                }
                return _ret;
            });
            futures.add(f);
        }


        long ret = Long.MAX_VALUE;
        try {
            for (var f : futures) {
                ret = Math.min(ret, f.get());
            }
        } catch (InterruptedException ex) {
            throw new SolverError(null);
        } catch (ExecutionException ex) {
            throw new SolverError(null);
        }

        tpe.shutdownNow();
        return ret;
    }
}
