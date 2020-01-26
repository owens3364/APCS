package com.owen.scott.programs.commons

class Tuple<A, B>(val a: A, val b: B) {

    fun setA(a: A): Tuple<A, B> {
        return Tuple(a, b)
    }

    fun setB(b: B): Tuple<A, B> {
        return Tuple(a, b)
    }

}