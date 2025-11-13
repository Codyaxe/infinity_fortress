// When something is available in C++ but not in Java

package com.infinityfortress.utils;

public class Pair<L, R> {
    public final L first;
    public final R second;

    public Pair(L a, R b) {
        this.first = a;
        this.second = b;
    }
}