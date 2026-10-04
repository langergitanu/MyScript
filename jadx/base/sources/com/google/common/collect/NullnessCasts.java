package com.google.common.collect;

/* JADX INFO: loaded from: classes6.dex */
final class NullnessCasts {
    static <T> T uncheckedCastNullableTToT(T t) {
        return t;
    }

    static <T> T unsafeNull() {
        return null;
    }

    private NullnessCasts() {
    }
}
