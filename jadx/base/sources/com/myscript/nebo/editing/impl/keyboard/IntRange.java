package com.myscript.nebo.editing.impl.keyboard;

import android.util.Pair;

/* JADX INFO: loaded from: classes7.dex */
public class IntRange {
    public final int end;
    public final int start;

    IntRange(int i, int i2) {
        this.start = Math.min(i, i2);
        this.end = Math.max(i, i2);
    }

    IntRange(Pair<Integer, Integer> pair) {
        this(((Integer) pair.first).intValue(), ((Integer) pair.second).intValue());
    }

    int size() {
        return this.end - this.start;
    }

    boolean equals(IntRange intRange) {
        return intRange != null && this.start == intRange.start && this.end == intRange.end;
    }

    static boolean equals(IntRange intRange, IntRange intRange2) {
        if (intRange == null && intRange2 == null) {
            return true;
        }
        return intRange != null && intRange2 != null && intRange.start == intRange2.start && intRange.end == intRange2.end;
    }

    static IntRange intersect(IntRange intRange, IntRange intRange2) {
        int i;
        int i2;
        if (intRange == null || intRange2 == null || (i = intRange.start) > intRange2.end || (i2 = intRange2.start) > intRange.end) {
            return null;
        }
        return new IntRange(Math.max(i, i2), Math.min(intRange.end, intRange2.end));
    }

    IntRange offset(int i) {
        return new IntRange(this.start + i, this.end + i);
    }

    public String toString() {
        return "start=" + this.start + " end=" + this.end;
    }
}
