package com.ilaird.aoc2023.day09;

class Estimator {

    Estimator parent;
    Integer[] samples;

    Estimator(Integer[] samples, Estimator parent) {
        this.samples = samples;
        this.parent = parent;
    }

    int getValueAt(int i) {
        if (samples[i] == null)
            samples[i] = parent.getValueAt(i + 1) - parent.getValueAt(i);
        return samples[i];
    }

    int getEstimate() {
        var lastIndex = samples.length - 1;
        var a = getValueAt(lastIndex);
        if (lastIndex == 0)
            return a;
        return new Estimator(new Integer[lastIndex], this).getEstimate() + a;
    }
}
