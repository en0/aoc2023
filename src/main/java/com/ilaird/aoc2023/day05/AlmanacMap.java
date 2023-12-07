package com.ilaird.aoc2023.day05;

import java.util.List;

class AlmanacMap {

    String mapName;
    List<AlmanacMapEntry> entries;

    long getTarget(long sourceValue) {
        for (AlmanacMapEntry e : entries)
            if (e.isInRange(sourceValue))
                return e.getTarget(sourceValue);
        return sourceValue;
    }

    long getSource(long targetValue) {
        for (AlmanacMapEntry e : entries)
            if (e.isInReverseRange(targetValue))
                return e.getSource(targetValue);
        return targetValue;
    }

    @Override
    public String toString() {
        var sb = new StringBuilder();
        for (var entry : entries)
            sb.append("\n + " + mapName + ": " + entry.toString());
        return sb.toString();
    }
}
