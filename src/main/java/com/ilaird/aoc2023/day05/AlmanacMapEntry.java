package com.ilaird.aoc2023.day05;

class AlmanacMapEntry {

    long sourceRangeStart;
    long targetRangeStart;
    long rangeSize;

    boolean isInRange(long sourceValue) {
        if (sourceValue < sourceRangeStart)
            return false;
        else if (sourceValue >= (sourceRangeStart + rangeSize))
            return false;
        return true;
    }

    long getTarget(long sourceValue) {
        return targetRangeStart + (sourceValue - sourceRangeStart);
    }

    boolean isInReverseRange(long targetValue) {
        if (targetValue < targetRangeStart)
            return false;
        else if (targetValue >= (targetRangeStart + rangeSize))
            return false;
        return true;
    }

    long getSource(long targetValue) {
        return sourceRangeStart + (targetValue - targetRangeStart);
    }

    @Override
    public String toString() {
        return "SOURCE=" + sourceRangeStart + ", TARGET=" + targetRangeStart + ", RANGE:" + rangeSize;
    }
}
