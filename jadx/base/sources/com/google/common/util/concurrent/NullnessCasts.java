package com.google.common.util.concurrent;

/* JADX INFO: loaded from: classes6.dex */
final class NullnessCasts {
    static <T> T uncheckedCastNullableTToT(T t) {
        return t;
    }

    static <T> T uncheckedNull() {
        return null;
    }

    private NullnessCasts() {
    }
}
