package com.owen.scott.programs.commons

class Triplet<A, B, C>(val a: A, val b: B, val c: C) {

    fun setA(a: A): Triplet<A, B, C> {
        return Triplet(a, b, c)
    }

    fun setB(b: B): Triplet<A, B, C> {
        return Triplet(a, b, c)
    }

    fun setC(c: C): Triplet<A, B, C> {
        return Triplet(a, b, c)
    }
}