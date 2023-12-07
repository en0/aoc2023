package com.ilaird.aoc2023.day05;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.ilaird.aoc2023.aoc.BlkXfmPuzzleInput;
import com.ilaird.aoc2023.aoc.TransformError;

@Component
class D5Parser extends BlkXfmPuzzleInput<Almanac> {

    @Override
    public List<Almanac> transformAll(String[] inputs) throws TransformError {
        return List.of(new Almanac() {{
            seeds = parseSeeds(inputs[0]);
            maps = parseMaps(inputs);
        }});
    }

    List<AlmanacMap> parseMaps(String[] inputs) {
        List<AlmanacMap> ret = new ArrayList<>();
        AlmanacMap map = null;
        for (int i = 1; i < inputs.length; i++) {
            var line = inputs[i].strip();
            if (line.endsWith(":")) {
                map = new AlmanacMap() {{
                    mapName = line.split(" ")[0].strip();
                    entries = new ArrayList<>();
                }};
                ret.add(map);
            } else if (!line.isEmpty() && map != null){
                var s = line.split(" ");
                map.entries.add(new AlmanacMapEntry() {{
                    targetRangeStart = Long.parseLong(s[0]);
                    sourceRangeStart = Long.parseLong(s[1]);
                    rangeSize = Long.parseLong(s[2]);
                }});
            }
        }
        return ret;
    }

    List<Long> parseSeeds(String line) {
        List<Long> ret = new ArrayList<>();
        var parts = line.split(":");
        for (String n : parts[1].split(" ")) {
            n = n.strip();
            if (!n.isEmpty()) {
                ret.add(Long.parseLong(n));
            }
        }
        return ret;
    }

}
