package com.owen.scott.programs.friday.builds.build7;

public class PythagoreanTriple {
    long a, b, c;

    public PythagoreanTriple() {
        a = 3;
        b = 4;
        c = 5;
    }

    public PythagoreanTriple(long a, long b, long c) {
        if (a * a + b * b != c * c) {
            throw new IllegalArgumentException("A, B, and C must be a valid Pythagorean Triple!");
        }
        this.a = a;
        this.b = b;
        this.c = c;
    }

    PythagoreanTriple multipliedBy(int multiplier) {
        return new PythagoreanTriple(this.a * multiplier, this.b * multiplier, this.c * multiplier);
    }

    @Override
    public String toString() {
        return a + "\t" + b + "\t" + c;
    }

    public long getA() {
        return a;
    }

    public long getB() {
        return b;
    }

    public long getC() {
        return c;
    }
}
